package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.MarcaDAO;
import br.com.fiap.model.Marca;

@Controller
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(){
		return new ModelAndView("marca/cadastro")
				.addObject("marca", new Marca());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processaForm(@Valid Marca marca,
			BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return new ModelAndView("marca/cadastro");
		}else{
			dao.cadastrar(marca);
			redirect.addFlashAttribute("msg", "Cadastrado!");
			return new ModelAndView("redirect:/marca/cadastrar");
		}
	}
	
}
