package december.christmas.demo.service;


import december.christmas.demo.dto.book.Book;
import december.christmas.demo.dto.book.BookRequestDTO;
import december.christmas.demo.dto.book.BookResponseDTO;
import december.christmas.demo.dto.wish.ChildWishDTO;
import december.christmas.demo.properties.SantaProperties;
import december.christmas.demo.properties.SpidermanProperties;
import december.christmas.demo.properties.ZorroProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Book handling service */
@Slf4j
@Service
// @RequiredArgsConstructor
public class BookService {

  private final SantaProperties santaProperties;
  private final ZorroProperties zorroProperties;
  private final SpidermanProperties spidermanProperties;
  private final List<Book> localBookList;

  @Autowired
  public BookService(SantaProperties santaProperties, ZorroProperties zorroProperties, SpidermanProperties spidermanProperties) {
    this.santaProperties = santaProperties;
    this.zorroProperties = zorroProperties;
    this.spidermanProperties = spidermanProperties;

    localBookList= Stream.of(new Book("1111","Adventures of Superman", "Bob Jenkins"),
                             new Book("2222", "Stormy night", "Steve Jobs"),
                             new Book("3333", "Fairy tales", "Linus Torvalds"),
                             new Book("4444", "Alice in the Wonderland", "Louis Carrol"),
                             new Book("5555", "Alice in the Wonderland", "Ben Franklin"),
                             new Book("6666", "Fairy tales", "Jack Smithson"))
        .collect(Collectors.toList());
  }

  /**
   * Find all books by name
   *
   * @param filter request with the list of books and authors
   * @return list of books and their total number
   */
  public BookResponseDTO<Book> getBooksByNames(BookRequestDTO filter) {
    List<Book> bookList = localBookList.stream()
        .filter(book -> filter.getFilter().getBookNames().contains(book.getBookName()))
        .collect(Collectors.toList());
    return BookResponseDTO.<Book>builder().bookList(bookList).totalNumber(123L).build();
  }

  /**
   * Find all books by author
   *
   * @param filter request with the list of books and authors
   * @return list of books and their total number
   */
  public BookResponseDTO<Book> getBooksByAuthors(BookRequestDTO filter) {
    List<Book> bookList = localBookList.stream()
        .filter(book -> filter.getFilter().getBookAuthors().contains(book.getBookAuthor()))
        .collect(Collectors.toList());

    return BookResponseDTO.<Book>builder().bookList(bookList).totalNumber(321L).build();
  }

  public BookResponseDTO<Book> answerToChildren(ChildWishDTO filter) {
    List<Book> childWish = localBookList.stream()
        .filter(book -> book.getBookId().equals(filter.getBookId()))
        .collect(Collectors.toList());

    return BookResponseDTO.<Book>builder().bookList(childWish).totalNumber(321L).build();
  }

  // To show testing of static methods:
  /**
   * Return the current date in the format "yyyy-MM-DD" for SAP
   *
   * @return current day of month in the format "yyyy-MM-dd"
   */
  public static String getDateForSuccess() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    return dateFormat.format(date);
  }

  /**
   * Return the current date in the format "YYYY-MM-DD" for SAP
   *
   * @return current date and time in the format "uuuu-MM-dd'T'HH:mm:ssZ" where Z - time zone offset
   */
  public static String getDateForError() {
    DateTimeFormatter DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssZ").withZone(ZoneId.systemDefault());
    return DATE_TIME_FORMATTER.format(new Date().toInstant());
  }
}
