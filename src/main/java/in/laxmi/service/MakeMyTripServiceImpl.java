package in.laxmi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.laxmi.binding.Passenger;
import in.laxmi.response.Ticket;
@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL = "http://13.232.253.164:8080/ticket";

	private String GET_TICKET_URL = "http://13.232.253.164:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		// TODO Auto-generated method stub
		
	/*	RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity=rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket= respEntity.getBody();*/
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.post()
				.uri(BOOK_TICKET_URL)
				.bodyValue(passenger)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
		
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNumber) {
		// TODO Auto-generated method stub
		/*RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEnitty = rt.getForEntity(GET_TICKET_URL, Ticket.class,ticketNumber);
		Ticket ticket = respEnitty.getBody();
		return ticket;*/
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
		         .uri(GET_TICKET_URL,ticketNumber)
		         .retrieve()
		         .bodyToMono(Ticket.class)
		         .block();//sync call
		return ticket;
	}

}
