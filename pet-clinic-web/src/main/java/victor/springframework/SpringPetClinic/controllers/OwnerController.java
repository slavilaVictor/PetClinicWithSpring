package victor.springframework.SpringPetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import victor.springframework.SpringPetClinic.model.Owner;
import victor.springframework.SpringPetClinic.model.Pet;
import victor.springframework.SpringPetClinic.services.OwnerService;

import javax.jws.WebParam;
import java.util.List;

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

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /*
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){

        // "owners" will be the name of the property inside the model
        // I will iterate through "owners" in the HTML5 file
        model.addAttribute("owners",ownerService.findAll());

        // Be careful here at the name, to match the name in my packages
        return "owners/index";
    }  */

    @RequestMapping("/find")
    public String findOwners(Model model){

        model.addAttribute("owner",Owner.builder().build());

        return "owners/findOwners";
    }

    @RequestMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
         // Allow parameter less GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    // Another way -> I do not return a String, I return a ModelAndView object
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }


}
