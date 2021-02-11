package victor.springframework.SpringPetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    // I could use only one path, but I chose multiple for my users
    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(){


        // It corresponds to the folder vets, in which I have my index.html
        return "vets/index";
    }
}
