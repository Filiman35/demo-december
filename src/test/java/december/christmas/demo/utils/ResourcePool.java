package december.christmas.demo.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourcePool extends AbstractTestResourcePool {

  public static Resource multipleChildrenResource = new ClassPathResource("json/multiple-children.json");
  public static Resource allBooksRespResource = new ClassPathResource("json/all-books-response.json");
  public static Resource booksRequestResource = new ClassPathResource("json/request-for-books.json");
  public static Resource booksByAuthorRespResource = new ClassPathResource("json/response-from-books-by-author.json");
  public static Resource booksByNameRespResource = new ClassPathResource("json/response-from-books-by-name.json");
  public static Resource bookNumber1RespResource = new ClassPathResource("json/response-with-book-1.json");
  public static Resource bookNumber2RespResource = new ClassPathResource("json/response-with-book-2.json");
  public static Resource bookNumber3RespResource = new ClassPathResource("json/response-with-book-3.json");



  public static Resource booksRespResourceCSV =
      new ClassPathResource("csv/report-with-books.csv");
}