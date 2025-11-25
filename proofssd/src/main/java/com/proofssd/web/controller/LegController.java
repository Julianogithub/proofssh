package com.proofssd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proofssd.model.Foot;
import com.proofssd.model.Leg;
import com.proofssd.service.FootService;
import com.proofssd.service.LegService;

@Controller
@RequestMapping("/legs")            // <- plural: /legs
public class LegController {

    @Autowired
    private LegService legService;
    @Autowired
    private FootService footService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("legs", legService.findAll()); // lista como "legs"
        return "legs/list";                                 // view: legs/list.html
    }

    @GetMapping("/novo")
    public String novoLeg(Model model) {
        model.addAttribute("leg", new Leg()); 
        model.addAttribute("foots", footService.findAll());// item único como "leg" para o form
        return "legs/form";                                 // view: legs/form.html
    }

    @PostMapping
    public String salvar(@ModelAttribute Leg leg) {
    	if (leg.getFoot() != null && leg.getFoot().getId() != null) {
			Foot foot = footService.findById(leg.getFoot().getId());
			leg.setFoot(foot);
		}
    	legService.save(leg);
        return "redirect:/legs";                            // redireciona para /legs
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("leg", legService.findById(id));
        model.addAttribute("foots", footService.findAll());// item único como "leg" para o form
        return "legs/form";                                 // corrige para legs/form
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        legService.delete(id);
        return "redirect:/legs";
    }
}
