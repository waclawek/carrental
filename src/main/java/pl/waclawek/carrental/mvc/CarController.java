package pl.waclawek.carrental.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.waclawek.carrental.domain.car.Car;
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
        //todo filer by avaliablityl
        mav.addObject("cars", carService.findAll());
        return mav;
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    ModelAndView addCar() {
        ModelAndView mav = new ModelAndView("addCar.html");
        mav.addObject("car", new Car());
        return mav;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    ModelAndView allCars(){
        ModelAndView mav = new ModelAndView("allCars.html");
        mav.addObject("cars", carService.findAll());
        return mav;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    String createCar(@ModelAttribute Car car){
        carService.create(car);
        return "redirect:/car";
    }

}
