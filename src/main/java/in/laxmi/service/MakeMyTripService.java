package in.laxmi.service;

import in.laxmi.binding.Passenger;
import in.laxmi.response.Ticket;

public interface MakeMyTripService {
	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicketByNum(Integer ticketNumber);
}
