package december.christmas.demo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import december.christmas.demo.dto.book.BookRequestDTO;
import december.christmas.demo.dto.book.BookResponseDTO;
import december.christmas.demo.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static december.christmas.demo.service.BookService.getDateForError;
import static december.christmas.demo.service.BookService.getDateForSuccess;
import static december.christmas.demo.utils.AbstractTestResourcePool.read;
import static december.christmas.demo.utils.ResourcePool.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.util.Base64Utils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests for {@link BookController}.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
  @MockBean
  private BookService bookService;
  @Autowired
  private MockMvc mockMvc;

  @Before
  public void setup() {
  }

  @Test
  public void getBooksByNamesShouldReturnBooks() throws Exception {
    BookRequestDTO bookRequestSearchByName = read(booksRequestResource, new TypeReference<BookRequestDTO>() {
    });
    BookResponseDTO bookResponseSearchByName = read(booksByNameRespResource, new TypeReference<BookResponseDTO>() {
    });

    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String searchByNameRequestJson = objectWriter.writeValueAsString(bookRequestSearchByName);
    String searchByNameRespJson = objectWriter.writeValueAsString(bookResponseSearchByName);

    when(bookService.getBooksByNames(bookRequestSearchByName)).thenReturn(bookResponseSearchByName);

    mockMvc.perform(post("/books/by-name")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        //.header(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString("username:password".getBytes()))
        .header(HttpHeaders.AUTHORIZATION, "Basic some-auth-token")
        .content(searchByNameRequestJson))
        .andExpect(status().isOk())
        .andExpect(content().json(searchByNameRespJson));
  }

  @Test
  public void getBooksByAuthorsShouldReturnBooks() throws Exception {
    BookRequestDTO bookRequestSearchByAuthor = read(booksRequestResource, new TypeReference<BookRequestDTO>() {
    });
    BookResponseDTO bookResponseSearchByAuthor = read(booksByAuthorRespResource, new TypeReference<BookResponseDTO>() {
    });

    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String searchByAuthorRequestJson = objectWriter.writeValueAsString(bookRequestSearchByAuthor);
    String searchByAuthorRespJson = objectWriter.writeValueAsString(bookResponseSearchByAuthor);

    when(bookService.getBooksByAuthors(bookRequestSearchByAuthor)).thenReturn(bookResponseSearchByAuthor);

    mockMvc.perform(post("/books/by-author/historical")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        //.header(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString("username:password".getBytes()))
        .header(HttpHeaders.AUTHORIZATION, "Basic some-auth-token")
        .content(searchByAuthorRequestJson))
        .andExpect(status().isOk())
        .andExpect(content().json(searchByAuthorRespJson));
  }

  @Test
  public void testSuccessDate() {
    String successDate = getDateForSuccess();
    Pattern successDatePattern = Pattern.compile("^20\\d{2}-[01]{1}\\d{1}-[0123]{1}\\d{1}$");
    Matcher successMatcher = successDatePattern.matcher(successDate);
    assertThat(successMatcher.matches()).isEqualTo(true);
  }

  @Test
  public void testErrorDate() {
    String errorDate = getDateForError();
    Pattern errorDatePattern =
        Pattern.compile(
            "^20\\d{2}-[01]{1}\\d{1}-[0123]{1}\\d{1}T[012]{1}\\d{1}:[0-5]{1}\\d{1}:[0-5]{1}\\d{1}\\+\\d{4}$");
    Matcher errorMatcher = errorDatePattern.matcher(errorDate);
    assertThat(errorMatcher.matches()).isEqualTo(true);
  }
}
