package guldana.demo.controllers;


import guldana.demo.models.magazin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public class magazinController {

    @Autowired
    magazin magazinReposotory;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("magazin", new magazin());
        return "magazin_add_form";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute magazin magazin) {
        magazinReposotory.save(magazin);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<magazin> allmagazins() { return magazinReposotory.findAll();
    }

    @GetMapping("/all2")
    public String allmagazins2(Model model) {
        List<magazin> magazins = (List<magazin>) magazinReposotory.findAll();
        Model magazins1 = model.addAttribute( "magazins", magazins );
        return "magazins";
    }

    @RequestMapping(value = "/deletemagazin", method = RequestMethod.GET)
    public ModelAndView deletemagazin(@RequestParam("id") long idd) {
        magazinReposotory.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
    @PostMapping("/editmagazin")
    public String editmagazin(@ModelAttribute magazin magazin) {
        magazin magazin1 = new magazin();
        magazin1.setId(a);
        magazin1.setmesto(magazin.getmesto());
        magazin1.setrabotniki(magazin.getrabotniki());
        magazin1.setodezhda(magazin.getodezhda());
        magazinReposotory.save(magazin1);
        return "redirect:/demo/all2";
    }

    @RequestMapping(value = "/editmagazin",method = RequestMethod.GET)
    public ModelAndView editmagazin(Model model,@RequestParam("id") long id){
        a=id;
        Optional<magazin> magazin = (Optional<magazin>) magazinReposotory.findById(id);
        model.addAttribute("magazin",magazin);
        return new ModelAndView("smp");
    }
    @RequestMapping("/editmagazin")
    public String showForm2(Model model){
        model.addAttribute("magazin",new magazin());
        return "smp";
    }
}

