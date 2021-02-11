package victor.springframework.SpringPetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import victor.springframework.SpringPetClinic.services.VetService;


@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    // I could use only one path, but I chose multiple for my users
    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model){

        model.addAttribute("vets",vetService.findAll());

        // It corresponds to the folder vets, in which I have my index.html
        return "vets/index";
    }
}
