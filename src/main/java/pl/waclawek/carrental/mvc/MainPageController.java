package pl.waclawek.carrental.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MainPageController {


    @GetMapping("/")
    ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView("main.html");
        return mav;
    }
}
