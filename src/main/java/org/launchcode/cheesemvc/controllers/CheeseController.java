package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    /* static - will make the list of cheeses accessible to our methods
    This is known as a static member - it exists while Spring is running
    static ArrayList<String> cheeses = new ArrayList<>(); */

    // Request Path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

//        cheeses.add("Gouda");
//        cheeses.add("Cheddar");
//        cheeses.add("Munster");
//        cheeses.add("Parmesan");

        // the model passes data into the view
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Ladhi Thai's Favorite Cheeses");
        // model.addAttribute("title1","A List of My Favorite Cheeses" );

        return "cheese/index";
    }

    /* This handler will display the form */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Favorite Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    /* This handler will process the form */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    // Model Binding will reduce written code for form submission and help with validation
    // Set validation here using the @Valid from the Cheese.java file
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        // Redirect to path: /cheese
        return "redirect:";
    }

    /* This handler will add functionality to remove cheese(s) from the list
    The form should make a POST request to a controller at the same URL as the
    form, and should redirect to the Index view associated with the Cheese controller.*/
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Old Cheese Here:");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int [] cheeseIds) {
        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }
        // Redirect to path: /cheese
        return "redirect:/cheese";
    }
}


