package pl.waclawek.carrental.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.waclawek.carrental.domain.user.User;
import pl.waclawek.carrental.domain.user.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    ModelAndView allUsers(){
        ModelAndView mav = new ModelAndView("users.html");
        mav.addObject("users", userService.getAll());
        return mav;
    }

    @GetMapping
    ModelAndView registerPage(){
        ModelAndView mav = new ModelAndView("register.html");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping()
    String registerUser(@ModelAttribute User user, Model model){
        userService.registerUser(user);
        return "redirect:/";
    }

}
