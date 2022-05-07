package com.Spiralfit.Spiralfit.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.Spiralfit.Spiralfit.models.spiral;

import com.Spiralfit.Spiralfit.repository.ProfisRepository;

@Controller
public class formController {
	
	@Autowired
	private ProfisRepository pr;
	
	
	@RequestMapping(value ="/cadastrarProfis", method = RequestMethod.GET)	
public String form() {
		return "profissional/formulario-profis";
	}
	@RequestMapping(value = "/cadastrarProfis", method = RequestMethod.POST)
	public String form(@Valid spiral spiral, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarProfis";
		}
	
		pr.save(spiral);
		attributes.addFlashAttribute("mensagem", "Cadastro com sucesso!");
		return "redirect:/cadastrarProfis";
	}
	
	@RequestMapping("/editar-prof")
	public ModelAndView editarspiral(long codigo) {
		spiral spiral = pr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("spiral/update-spiral");
		mv.addObject("spiral", spiral);
		return mv;
	}
	
	@RequestMapping(value = "/editar-spiral", method = RequestMethod.POST)
	public String updateVaga(@Valid spiral spiral, BindingResult result, RedirectAttributes attributes) {
		pr.save(spiral);
		attributes.addFlashAttribute("success", "Spiralfit alterada com sucesso!");

		long codigoLong = spiral.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/spiral/" + codigo;
	}

}


