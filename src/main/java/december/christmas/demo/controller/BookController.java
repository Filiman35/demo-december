package december.christmas.demo.controller;

import december.christmas.demo.dto.book.Book;
import december.christmas.demo.dto.book.BookRequestDTO;
import december.christmas.demo.dto.book.BookResponseDTO;
import december.christmas.demo.dto.santa.Present;
import december.christmas.demo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

@Slf4j
// @Log4j2
@Controller
@RequestMapping("/books")
public class BookController {

  private static final Gson gson = new Gson();
  private final BookService bookService;

  @Value("${authorize-foreign-servers.auth-token}")
  private String credentials;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }


  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getAllBooks(@RequestParam(value = "book_number", required = false) String bookNumber,
                                            @RequestParam(value = "book_name", required = false) String bookName,
                                            Model model) {
    log.debug("getAllBooks: bookNumber=[{}]", bookNumber);
    log.debug("getAllBooks: bookName=[{}]", bookName);
    System.out.println("Book number: " + bookNumber);
    System.out.println("Book name: " + bookName);

    if (!StringUtils.hasText(bookNumber)) {
      log.debug("Book number is empty!");

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (!StringUtils.hasText(bookName)) {
      log.debug("No book name, it's bad!");

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
      log.debug("Request for a book is ok.");

      return ResponseEntity.ok(gson.toJson(Present.builder().presentName("candy").description("Some sweet candy").build()));
    }
  }

  @PostMapping("/by-name")
  @Operation(summary = "Get list of books by names")
  @ApiResponse(responseCode = "200", description = "Gave list of books successfully")
  public ResponseEntity<BookResponseDTO<Book>> getBooksByNames(
      @RequestBody BookRequestDTO filter) {

    return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByNames(filter));
  }

  @PostMapping("/by-author/{bookType}")
  @Operation(summary = "Get list of books by authors and book type")
  @ApiResponse(responseCode = "200", description = "Gave list of books successfully")
  public ResponseEntity<BookResponseDTO<Book>> getBooksByAuthors(
      @PathVariable String bookType,
      @RequestHeader(value = "Authorization") String basicAuthorization,
      @RequestBody BookRequestDTO filter) {

    log.debug("Request to /book/by-author/{bookType} came with bookType=[{}]", bookType);
    System.out.println("Book type is in /book/by-author/{bookType} : " + bookType);

    if (!basicAuthorization.equals("Basic " + credentials)) {
      log.debug("Credentials received from external server, when trying to get books by author were wrong.");
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAuthors(filter));
  }


}
