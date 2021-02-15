package victor.springframework.SpringPetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // When I have a request on this pages
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){


        // Spring will look for a template named index. And I do have an index.html file
        return "index";
    }

    @RequestMapping("/oups")
    public String oupsHandler(){

        return "notimplemented";
    }
}
