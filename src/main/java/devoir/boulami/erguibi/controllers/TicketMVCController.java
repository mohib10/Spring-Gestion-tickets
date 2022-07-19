package devoir.boulami.erguibi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import devoir.boulami.erguibi.models.*;
import devoir.boulami.erguibi.service.*;

@Controller
@RequestMapping("/")
public class TicketMVCController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private BugService bugService;
	
	
	@GetMapping("/client")
	public String list (Model model) {
	model.addAttribute("tickets",ticketService.getTickets());
	return "users/listTic";
	}
	@GetMapping("/client/addBug")
	public String ajoutB (Model model) {
		Bug b = new Bug();
		model.addAttribute("bug",b);
		model.addAttribute("urgences",bugService.getUrgences());
		model.addAttribute("logs",bugService.getLogiciels());
		return "users/ajoutBug";
	}

	@PostMapping("/client/addBug")
	public String saveB(@ModelAttribute ("bug") Bug bug) {
		bug.setAttribue(false);
		bugService.ajouter(bug);
		return "redirect:/client";
	}
	
	@GetMapping("/developer")
	public String listD (Model model) {
	model.addAttribute("tickets",ticketService.getTickets());
	return "users/listDTic";
	}
	

	@GetMapping("/client/addTicket")
	public String ajout (Model model) {
		Ticket t = new Ticket();
		model.addAttribute("ticket",t);
		model.addAttribute("bugs",ticketService.getBugs());
		return "users/ajoutTicket";
	}
	
	@PostMapping("/client/addTicket")
	public String enregistrer(@ModelAttribute ("ticket") Ticket ticket) {
	ticket.setStatue("new");
	ticketService.ajouter(ticket);
	return "redirect:/client";

	}
	@GetMapping("/developer/changeStatus/{id}")
	public String changeStatus(@PathVariable int id,Model model) {	
		ticketService.changeStatue(id);
		return "redirect:/developer";
	}
	

	


}
