package december.christmas.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import december.christmas.demo.configuration.PostgresConfig;
import december.christmas.demo.dto.book.BookRequestDTO;
import december.christmas.demo.dto.book.BookResponseDTO;
import december.christmas.demo.dto.wish.ChildWishDTO;
import december.christmas.demo.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static december.christmas.demo.utils.AbstractTestResourcePool.read;
import static december.christmas.demo.utils.ResourcePool.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest(
//    classes = {PostgresConfig.class},
//    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("magicunit")
@RunWith(SpringRunner.class)
@WebMvcTest(ChildWishController.class)
public class ChildWishControllerTest {

//  @Autowired private TestRestTemplate restTemplate;
  @MockBean private BookService bookService;
  @Autowired private MockMvc mockMvc;

  @Test
  public void answerToChildrenShouldReturnBook() throws Exception {
    List<ChildWishDTO> requestsList = read(multipleChildrenResource, new TypeReference<List<ChildWishDTO>>() {});
    ChildWishDTO childRequest = requestsList.get(0);
    BookResponseDTO responseToChildWish = read(bookNumber1RespResource, new TypeReference<BookResponseDTO>() {
    });

    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String childWishRequestJson = objectWriter.writeValueAsString(childRequest);
    String responseToChildWishJson = objectWriter.writeValueAsString(responseToChildWish);

    when(bookService.answerToChildren(childRequest)).thenReturn(responseToChildWish);

    mockMvc.perform(post("/wish")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        //.header(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString("username:password".getBytes()))
        .content(childWishRequestJson))
        .andExpect(status().isOk())
        .andExpect(content().json(responseToChildWishJson));
  }

//  @Test
//  public void answerToChildrenShouldCallServiceMethod() {
//
//    List<ChildWishDTO> requestsList = read(multipleChildrenResource, new TypeReference<List<ChildWishDTO>>() {});
//
//    restTemplate.postForObject("/api/v1/wish", requestsList.get(0), Object.class);
//
//    //verify(bookService, atLeast(1)).answerToChildren(requestsList.get(0));
//    verify(bookService, times(1)).answerToChildren(requestsList.get(0));
//  }
}