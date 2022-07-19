package devoir.boulami.erguibi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import devoir.boulami.erguibi.models.*;
import devoir.boulami.erguibi.service.LogicielService;

@Controller
@RequestMapping("/logiciel")
public class LogicielMVCController {

	@Autowired
	private LogicielService logSer;
	
	@GetMapping("add")
	public String add(Model model) {
		Logiciel l  = new Logiciel();
		model.addAttribute("log",l);
		return "logiciel/add";
	}
	
	@PostMapping("add")
	public String save(@ModelAttribute ("log") Logiciel log) {
		//Logiciel l  = new Logiciel();
		logSer.ajouter(log);
		return "redirect:/client";
	}
}
