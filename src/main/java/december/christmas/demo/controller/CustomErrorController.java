package december.christmas.demo.controller;

import december.christmas.demo.exception.BassException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom-error-path")
public class CustomErrorController implements ErrorController {

  @GetMapping()
  @Operation(summary = "Get an error page")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "Give a page with error status to user",
              content = @Content(schema = @Schema(implementation = String.class)))
      })
  public String getError(Model model) {
    model.addAttribute("header", "Your request was processed with error.");
    model.addAttribute("messageMain", "Our team is working on fixing it.");
    model.addAttribute("messageAdvice", "Please, try again in 5 minutes.");
    return "error";
  }
}
