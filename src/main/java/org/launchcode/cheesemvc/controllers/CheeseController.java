package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    /* static - will make the list of cheeses accessible to our methods
    This is known as a static member - it exists will Spring is running*/
    static ArrayList<String> cheeses = new ArrayList<>();

    // Request Path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

//        cheeses.add("Gouda");
//        cheeses.add("Cheddar");
//        cheeses.add("Munster");
//        cheeses.add("Parmesan");

        // the model passes data into the view
        model.addAttribute("title", "Ladhi Thai's Favorite Cheeses");
        model.addAttribute("title1","A List of My Favorite Cheeses" );
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }
    /* This handler will display the form */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese Here:");
        return "cheese/add";
    }

    /* This handler will process the form */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        cheeses.add(cheeseName);
        // Redirect to path: /cheese
        return "redirect:";
    }
}


