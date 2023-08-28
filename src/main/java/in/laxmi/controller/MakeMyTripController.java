package in.laxmi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.laxmi.binding.Passenger;
import in.laxmi.response.Ticket;
import in.laxmi.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	@Autowired
	private MakeMyTripService service;
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNum,Model model) {
		Ticket ticketByNum = service.getTicketByNum(ticketNum);
		model.addAttribute("ticket", ticketByNum);
		return "ticket-form";
	}
	
	
	@GetMapping("/ticket")
	public String viewTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger,Model model) {
		System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg", "Your ticket booked with id:"+ticket.getTicketNum());
		return "index";

	}

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";

	}
}
