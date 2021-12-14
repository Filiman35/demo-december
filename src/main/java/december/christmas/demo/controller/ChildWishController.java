package december.christmas.demo.controller;

import december.christmas.demo.dto.book.Book;
import december.christmas.demo.dto.book.BookRequestDTO;
import december.christmas.demo.dto.book.BookResponseDTO;
import december.christmas.demo.dto.wish.ChildWishDTO;
import december.christmas.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/wish")
public class ChildWishController {

  private final BookService bookService;

  @Autowired
  public ChildWishController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping()
  public ResponseEntity<BookResponseDTO<Book>> answerToChildren(
      @RequestBody ChildWishDTO wish) {

    return ResponseEntity.status(HttpStatus.OK).body(bookService.answerToChildren(wish));
  }
}
