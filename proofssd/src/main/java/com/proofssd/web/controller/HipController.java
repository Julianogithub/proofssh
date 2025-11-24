package com.proofssd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proofssd.model.Thigh;
import com.proofssd.model.Hip;
import com.proofssd.service.ThighService;
import com.proofssd.service.HipService;

@Controller
@RequestMapping("/hips")            // <- plural: /hips
public class HipController {

    @Autowired
    private HipService hipService;
    @Autowired
    private ThighService thighService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("hips", hipService.findAll()); // lista como "hips"
        return "hips/list";                                 // view: hips/list.html
    }

    @GetMapping("/novo")
    public String novoHip(Model model) {
        model.addAttribute("hip", new Hip()); 
        model.addAttribute("thighs", thighService.findAll());// item único como "hip" para o form
        return "hips/form";                                 // view: hips/form.html
    }

    @PostMapping
    public String salvar(@ModelAttribute Hip hip) {
    	if (hip.getThigh() != null && hip.getThigh().getId() != null) {
			Thigh thigh = thighService.findById(hip.getThigh().getId());
			hip.setThigh(thigh);
		}
    	hipService.save(hip);
        return "redirect:/hips";                            // redireciona para /hips
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("hip", hipService.findById(id));
        model.addAttribute("thighs", thighService.findAll());// item único como "hip" para o form
        return "hips/form";                                 // corrige para hips/form
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        hipService.delete(id);
        return "redirect:/hips";
    }
}
