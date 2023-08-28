package in.laxmi.response;

import lombok.Data;

@Data
public class Ticket {
	private Integer ticketNum;
	private String Status;
	private Integer ticketCost;
	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNumber;
}
