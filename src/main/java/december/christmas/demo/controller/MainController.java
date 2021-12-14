package december.christmas.demo.controller;

import december.christmas.demo.exception.BassException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {

  @GetMapping()
  @Operation(summary = "Get a main page")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "Returned main page successfully",
              content = @Content(schema = @Schema(implementation = String.class))),
          @ApiResponse(responseCode = "404", description = "Failed to return the main page",
              content = @Content(schema = @Schema(implementation = BassException.class))),
      })
  public String getMainPage(Model model) {
    model.addAttribute("header", "Welcome to the best bank of Ukraine!");
    model.addAttribute("messageMain", "We've got Your application.");
    model.addAttribute("messageAdvice", "Please, wait for our manager to call You.");
    return "mainPage";
  }
}
