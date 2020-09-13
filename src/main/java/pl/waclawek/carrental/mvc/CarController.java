package pl.waclawek.carrental.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.waclawek.carrental.domain.car.CarService;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    ModelAndView carPage() {
        ModelAndView mav = new ModelAndView("cars.html");
        mav.addObject("cars", carService.findAll());
        return mav;
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    ModelAndView addCar() {
        ModelAndView mav = new ModelAndView("addCar.html");
        return mav;
    }

}
