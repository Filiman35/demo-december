package december.christmas.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class AuthController {

  @GetMapping("logout-page")
  @PreAuthorize("hasAuthority('buyer:read')")
  public String getLogoutPage() {
    return "logoutPage";
  }

  @GetMapping("home")
  @PreAuthorize("hasAuthority('buyer:read')")
  public String getHomePage() {
    return "homePage";
  }

  @GetMapping("my-profile")
  @PreAuthorize("hasAuthority('buyer:write')")
  public String getMyProfile() {
    return "myProfile";
  }
}
