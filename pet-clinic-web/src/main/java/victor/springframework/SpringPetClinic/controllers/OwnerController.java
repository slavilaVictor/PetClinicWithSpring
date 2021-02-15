package victor.springframework.SpringPetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import victor.springframework.SpringPetClinic.services.OwnerService;

// Another way to do the mapping here, because all the requests start with "/owners"
// I need that empty string in this case
@RequestMapping("/owners")
@Controller
public class OwnerController {

    // I declare it final because I do not want to be changed
    private final OwnerService ownerService;

    // The proper way to work with injected proprieties is by using a constructor
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){

        // "owners" will be the name of the property inside the model
        // I will iterate through "owners" in the HTML5 file
        model.addAttribute("owners",ownerService.findAll());

        // Be careful here at the name, to match the name in my packages
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){

        return "notimplemented";
    }


}
