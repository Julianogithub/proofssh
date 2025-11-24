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
import com.proofssd.service.LegService;
import com.proofssd.service.ChestService;

@Controller
@RequestMapping("/legs")
public class LegController {

	@Autowired
	private LegService legService;
	@Autowired
	ChestService chestService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("legs", legService.findAll());
		return "legs/list";
	}

	@GetMapping("/novo")
	public String novoLeg(Model model) {
		model.addAttribute("leg", new Leg());
		
		return "legs/form";
	}

	@PostMapping
	public String salvar(@ModelAttribute Leg leg) {
		legService.save(leg);
		return "redirect:/legs";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("leg", legService.findById(id));
		model.addAttribute("chests", chestService.findAll());
		return "legs/form";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		legService.delete(id);
		return "redirect:/legs";
	}
}