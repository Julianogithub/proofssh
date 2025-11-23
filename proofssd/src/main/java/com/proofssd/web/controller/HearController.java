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
import com.proofssd.model.Head;
import com.proofssd.service.NeckService;
import com.proofssd.service.HeadService;

@Controller
@RequestMapping({ "/", "/heads" })
public class HearController {

	@Autowired
	private HeadService headService;
	@Autowired
	private NeckService neckService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("heads", headService.findAll());
		return "heads/list";
	}

	@GetMapping("/novo")
	public String novoHead(Model model) {
		model.addAttribute("head", new Head());
		model.addAttribute("necks", neckService.findAll());
		return "heads/form";
	}

	@PostMapping
	public String salvar(@ModelAttribute Head head) {
		if (head.getNeck() != null && head.getNeck().getId() != null) {
			Neck neck = neckService.findById(head.getNeck().getId());
			head.setNeck(neck);
		}
		headService.save(head);
		return "redirect:/heads";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("head", headService.findById(id));
		model.addAttribute("necks", neckService.findAll());
		return "heads/form";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		headService.delete(id);
		return "redirect:/heads";
	}
}
