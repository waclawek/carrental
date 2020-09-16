package pl.waclawek.carrental.mvc;

import org.dom4j.rule.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.springsecurity5.util.SpringSecurityContextUtils;
import pl.waclawek.carrental.domain.rent.Rent;
import pl.waclawek.carrental.domain.rent.RentService;
import pl.waclawek.carrental.domain.user.UserService;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping("/rent")
public class RentController {

    RentService rentService;
    UserService userService;

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
        mav.addObject("rents",
                rentService.getAllByClientId(userService.getIdByUsername(username)));
        return mav;
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    ModelAndView addRentPage() {
        ModelAndView mav = new ModelAndView("addRent.html");
        mav.addObject("rent", new Rent());
        return mav;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    String createRent(@ModelAttribute Rent rent){
        rentService.create(rent);
        return "redirect:/rent";
    }
}
