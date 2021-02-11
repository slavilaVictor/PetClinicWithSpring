package victor.springframework.SpringPetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Another way to do the mapping here, because all the requests start with "/owners"
// I need that empty string in this case
@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(){

        // Be careful here at the name, to match the name in my packages
        return "owners/index";
    }
}
