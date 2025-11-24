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
import com.proofssd.service.ArmService;
import com.proofssd.service.ChestService;

@Controller
@RequestMapping("/arms")
public class ArmController {

	@Autowired
	private ArmService armService;
	@Autowired
	ChestService chestService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("arms", armService.findAll());
		return "arms/list";
	}

	@GetMapping("/novo")
	public String novoArm(Model model) {
		model.addAttribute("arm", new Arm());
		
		return "arms/form";
	}

	@PostMapping
	public String salvar(@ModelAttribute Arm arm) {
		armService.save(arm);
		return "redirect:/arms";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("arm", armService.findById(id));
		model.addAttribute("chests", chestService.findAll());
		return "arms/form";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		armService.delete(id);
		return "redirect:/arms";
	}
}