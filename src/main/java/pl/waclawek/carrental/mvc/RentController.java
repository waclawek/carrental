package pl.waclawek.carrental.mvc;

import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.springsecurity5.util.SpringSecurityContextUtils;
import pl.waclawek.carrental.domain.car.Car;
import pl.waclawek.carrental.domain.car.CarService;
import pl.waclawek.carrental.domain.rent.Rent;
import pl.waclawek.carrental.domain.rent.RentService;
import pl.waclawek.carrental.domain.user.UserService;

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;
    private final UserService userService;
    private final CarService carService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    ModelAndView getAllRents() {
        ModelAndView mav = new ModelAndView("allRents.html");
        mav.addObject("rents", rentService.getAll());
        return mav;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    ModelAndView myRentsPage() {
        ModelAndView mav = new ModelAndView("rents.html");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        int userId = userService.getIdByUsername(username);
        List<Rent> userRents =  rentService.getAllByClientId(userId);
        mav.addObject("rents", userRents);
        return mav;
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    ModelAndView addRentPage(@RequestParam(value = "carId", required = true) Integer carId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int clientId = userService.getIdByUsername(username);
        ModelAndView mav = new ModelAndView("addRent.html");
        Rent newRent = Rent.builder().carId(carId).clientId(clientId).build();
        mav.addObject("rent", newRent);
        Car rentedCar = carService.findById(carId);
        mav.addObject("rentedCar", rentedCar);
        return mav;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    String createRent(@ModelAttribute Rent rent){
        rentService.create(rent);
        return "redirect:/car";
    }
}
