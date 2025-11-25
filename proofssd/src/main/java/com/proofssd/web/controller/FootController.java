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
import com.proofssd.service.FootService;
import com.proofssd.service.ChestService;

@Controller
@RequestMapping("/foots")
public class FootController {

	@Autowired
	private FootService footService;
	@Autowired
	ChestService chestService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("foots", footService.findAll());
		return "foots/list";
	}

	@GetMapping("/novo")
	public String novoFoot(Model model) {
		model.addAttribute("foot", new Foot());
		
		return "foots/form";
	}

	@PostMapping
	public String salvar(@ModelAttribute Foot foot) {
		footService.save(foot);
		return "redirect:/foots";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("foot", footService.findById(id));
		model.addAttribute("chests", chestService.findAll());
		return "foots/form";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		footService.delete(id);
		return "redirect:/foots";
	}
}