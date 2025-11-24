package com.proofssd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proofssd.model.Leg;
import com.proofssd.model.Thigh;
import com.proofssd.service.LegService;
import com.proofssd.service.ThighService;

@Controller
@RequestMapping("/thighs")            // <- plural: /thighs
public class ThighController {

    @Autowired
    private ThighService thighService;
    @Autowired
    private LegService legService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("thighs", thighService.findAll()); // lista como "thighs"
        return "thighs/list";                                 // view: thighs/list.html
    }

    @GetMapping("/novo")
    public String novoThigh(Model model) {
        model.addAttribute("thigh", new Thigh()); 
        model.addAttribute("legs", legService.findAll());// item único como "thigh" para o form
        return "thighs/form";                                 // view: thighs/form.html
    }

    @PostMapping
    public String salvar(@ModelAttribute Thigh thigh) {
    	if (thigh.getLeg() != null && thigh.getLeg().getId() != null) {
			Leg leg = legService.findById(thigh.getLeg().getId());
			thigh.setLeg(leg);
		}
    	thighService.save(thigh);
        return "redirect:/thighs";                            // redireciona para /thighs
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("thigh", thighService.findById(id));
        model.addAttribute("legs", legService.findAll());// item único como "thigh" para o form
        return "thighs/form";                                 // corrige para thighs/form
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        thighService.delete(id);
        return "redirect:/thighs";
    }
}
