package com.proofssd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proofssd.model.Neck;
import com.proofssd.service.NeckService;

@Controller
@RequestMapping("/necks")
public class NeckController {

	@Autowired
	private NeckService neckService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("necks", neckService.findAll());
		return "necks/list";
	}

	@GetMapping("/novo")
	public String novoNeck(Model model) {
		model.addAttribute("neck", new Neck());
		return "necks/form";
	}

	@PostMapping
	public String salvar(@ModelAttribute Neck neck) {
		neckService.save(neck);
		return "redirect:/necks";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("neck", neckService.findById(id));
		return "necks/form";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		neckService.delete(id);
		return "redirect:/necks";
	}
}