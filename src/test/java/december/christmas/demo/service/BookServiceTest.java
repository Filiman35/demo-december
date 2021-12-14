package december.christmas.demo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import december.christmas.demo.configuration.PostgresConfig;
import december.christmas.demo.controller.BookController;
import december.christmas.demo.controller.ChildWishController;
import december.christmas.demo.dto.book.Book;
import december.christmas.demo.dto.book.BookFilter;
import december.christmas.demo.dto.book.BookRequestDTO;
import december.christmas.demo.dto.book.BookResponseDTO;
import december.christmas.demo.dto.wish.ChildWishDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static december.christmas.demo.utils.AbstractTestResourcePool.read;
import static december.christmas.demo.utils.ResourcePool.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(BookService.class)
//@SpringBootTest(classes = {PostgresConfig.class})
//@ActiveProfiles("magictest")
@Slf4j
public class BookServiceTest {

  private List<ChildWishDTO> wishesDTOs;

  @MockBean
  private ChildWishController childWishController;

  @MockBean
  private BookService bookService;

  @Before
  public void init() {
    log.info("The BookServiceTest began");
  }

  @ParameterizedTest
  @ValueSource(strings = {"2222", "3333", "4444", "5555"})
  public void whenChildRequestArrivesShouldAnswerWithBook(String bookId) {

    ChildWishDTO childWishRequest = ChildWishDTO.builder()
        .childId("84be8c41-bf6f-4fd6-b051-9e933c893334").childWish("A dog").wishDescription("Small black dog")
        .bookId(bookId).build();

    BookResponseDTO<Book> allBooksResponse = read(allBooksRespResource, new TypeReference<BookResponseDTO<Book>>() {
    });

    List<Book> chosenBook = allBooksResponse.getBookList().stream()
        .filter(book -> bookId.equals(bookId))
        .collect(Collectors.toList());

    ResponseEntity<BookResponseDTO<Book>> responseWithBook = ResponseEntity.status(HttpStatus.OK)
        .body(BookResponseDTO.<Book>builder().totalNumber(321L).bookList(chosenBook).build());

    BookResponseDTO<Book> expectedResponse = BookResponseDTO.<Book>builder().totalNumber(321L)
        .bookList(chosenBook).build();

    when(childWishController.answerToChildren(childWishRequest)).thenReturn(responseWithBook);

    BookResponseDTO<Book> body = responseWithBook.getBody();

    assertNotNull(body);

    assertEquals(expectedResponse.getTotalNumber(), body.getTotalNumber());

    Collection<Book> expected = expectedResponse.getBookList();
    Collection<Book> actual = body.getBookList();

    assertEquals(expected, actual);
  }

  //  @Disabled("Do not run with all other tests")
  @Test
  public void answerToChildrenShouldReturnBookResponseDTO() {

    ChildWishDTO childWishRequest = ChildWishDTO.builder()
        .childId("dfa3f2ad-57d7-40bb-8dc7-70670a4742ed").childWish("Pony").wishDescription("Small pony").bookId("1111")
        .build();

    BookResponseDTO<Book> actualResponse = read(bookNumber1RespResource, new TypeReference<BookResponseDTO<Book>>() {
    });

    when(bookService.answerToChildren(childWishRequest)).thenReturn(actualResponse);

    assertThat(Book.class, typeCompatibleWith(actualResponse.getBookList()
        .toArray()[0].getClass()));
  }

  @Test
  public void answerToChildrenShouldReturnResponseWithBookIdFromRequest() {

    ChildWishDTO childWishDTO = ChildWishDTO.builder()
        .childId("dfa3f2ad-57d7-40bb-8dc7-70670a4742ed").childWish("Pony").wishDescription("Small pony").bookId("2222")
        .build();

    BookResponseDTO<Book> actualResponse = BookResponseDTO.<Book>builder().totalNumber(321L).bookList(
        List.of(new Book("2222", "Stormy night", "Steve Jobs"))
    ).build();

    when(bookService.answerToChildren(childWishDTO)).thenReturn(actualResponse);

    assertThat(actualResponse.getBookList().toArray()[0], hasProperty("bookId", equalTo("2222")));
  }

  @Test
  public void allPropertiesOfAnswerToChildrenShouldEqualToExpected() {

    BookResponseDTO<Book> actualBook = read(bookNumber2RespResource, new TypeReference<BookResponseDTO>() {
    });

    BookResponseDTO<Book> expectedBook = BookResponseDTO.<Book>builder()
        .totalNumber(321L)
        .bookList(actualBook.getBookList())
        .build();

    List<ChildWishDTO> wishesDTOs = read(multipleChildrenResource, new TypeReference<List<ChildWishDTO>>() {
    });

    when(bookService.answerToChildren(wishesDTOs.get(1))).thenReturn(actualBook);

    assertThat(expectedBook, samePropertyValuesAs(actualBook));
  }

  @Test
  public void answerToChildrenReturnsCorrectBook() {

    BookResponseDTO<Book> expectedPayloadWithBook =
        read(bookNumber3RespResource, new TypeReference<BookResponseDTO<Book>>() {
        });

    ResponseEntity<BookResponseDTO<Book>> expectedResponseWithBook = ResponseEntity.status(HttpStatus.OK)
        .body(expectedPayloadWithBook);

    ChildWishDTO childWishDTO = ChildWishDTO.builder()
        .childId("84be8c41-bf6f-4fd6-b051-9e933c893334").childWish("A dog").wishDescription("Small black dog")
        .bookId("3333").build();

    ResponseEntity<BookResponseDTO<Book>> actualResponseWithBook = ResponseEntity.status(HttpStatus.OK)
        .body(BookResponseDTO.<Book>builder()
            .totalNumber(321L)
            .bookList(List.of(new Book("3333", "Fairy tales", "Linus Torvalds"))).build());

    when(childWishController.answerToChildren(childWishDTO)).thenReturn(actualResponseWithBook);

    BookResponseDTO<Book> expectedPayload = expectedResponseWithBook.getBody();
    BookResponseDTO<Book> actualPayload = actualResponseWithBook.getBody();

    assertEquals(expectedResponseWithBook, actualResponseWithBook);
  }

  @Test
  public void checkIfTheFieldIsEmpty() {
    String emptyBookAuthor = null;
    assertThat(emptyBookAuthor, emptyOrNullString());
  }

  @Test
  public void showMockitoSpies() {
    BookRequestDTO filter = new BookRequestDTO(BookFilter.builder()
        .bookNames(List.of("Alice in the Wonderland"))
        .build());

    BookResponseDTO<Book> mockedBookResponse = BookResponseDTO.<Book>builder().totalNumber(123L).bookList(
        List.of(Book.builder()
            .bookId("4444")
            .bookName("Alice in the Wonderland")
            .bookAuthor("Louis Carrol")
            .build()))
        .build();

    // will work always
    doReturn(mockedBookResponse).when(bookService).getBooksByNames(filter);

    // does call a real method:
    when(bookService.getBooksByNames(filter)).thenReturn(mockedBookResponse);
  }

  @After
  public void clearAfterAll() {
    log.info("All test in BookServiceTest ended");
  }
}
