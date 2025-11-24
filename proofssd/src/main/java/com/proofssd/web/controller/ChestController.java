package com.proofssd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proofssd.model.Arm;
import com.proofssd.model.Chest;
import com.proofssd.service.ArmService;
import com.proofssd.service.ChestService;

@Controller
@RequestMapping("/chests")            // <- plural: /chests
public class ChestController {

    @Autowired
    private ChestService chestService;
    @Autowired
    private ArmService armService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("chests", chestService.findAll()); // lista como "chests"
        return "chests/list";                                 // view: chests/list.html
    }

    @GetMapping("/novo")
    public String novoChest(Model model) {
        model.addAttribute("chest", new Chest()); 
        model.addAttribute("arms", armService.findAll());// item único como "chest" para o form
        return "chests/form";                                 // view: chests/form.html
    }

    @PostMapping
    public String salvar(@ModelAttribute Chest chest) {
    	if (chest.getArm() != null && chest.getArm().getId() != null) {
			Arm arm = armService.findById(chest.getArm().getId());
			chest.setArm(arm);
		}
    	chestService.save(chest);
        return "redirect:/chests";                            // redireciona para /chests
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("chest", chestService.findById(id));
        model.addAttribute("arms", armService.findAll());// item único como "chest" para o form
        return "chests/form";                                 // corrige para chests/form
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        chestService.delete(id);
        return "redirect:/chests";
    }
}
