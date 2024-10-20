package railwayReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class railwayReservationSystem {

	static Scanner sc = new Scanner(System.in);
	static long passengerId = 1;
	static int totalBerthTickets = 3;
	static int totalRacTickets = 1;
	static int bookedTickets = 0;
	static int ticketNo = 1;
	
	
	public static void main(String[] args) {
		
		TotalPassengerDetailsList totalPassengerDetailsList = new TotalPassengerDetailsList();
		Map<Long, PassengerDetails> bookedPassengerList = new LinkedHashMap<>();
		Map<Long, PassengerDetails> racPassengerList = new LinkedHashMap<>();
		Map<Long, PassengerDetails> waitingListPassengerList = new LinkedHashMap<>();
		totalPassengerDetailsList.setBookedPassengerList(bookedPassengerList);
		totalPassengerDetailsList.setRacPassengerList(racPassengerList);
		totalPassengerDetailsList.setWaitingListPassengerList(waitingListPassengerList);
		
		// TODO Auto-generated method stub
		int ch;
		do {
			System.out.println("Enter the choice:  \n 1) Book Ticket \n 2) Cancel Ticket \n 3) Display Booked Ticket Details \n 4) Display RAC Details \n 5) Display Waiting List Details ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				bookTicket(totalPassengerDetailsList);
				break;
			case 2:
				cancelTicket(totalPassengerDetailsList);
				break;
			case 3:
				displayBookedTickets(totalPassengerDetailsList.getBookedPassengerList());
				break;
			case 4:
				displayRacTickets(totalPassengerDetailsList.getRacPassengerList());
				break;
			case 5:
				displayWaitingListTickets(totalPassengerDetailsList.getWaitingListPassengerList());
				break;
			default:
				System.out.println("Choice is incorrect");
			}
			System.out.println("Enter 1 to continue: ");
			ch=sc.nextInt();
		}while(ch==1);
		
	}


	private static void bookTicket(TotalPassengerDetailsList totalPassengerDetailsList) {
		// TODO Auto-generated method stub
		
		PassengerDetails passengerDetails = new PassengerDetails(); 
		
		passengerDetails.setPassengerId(passengerId++);
		
		System.out.println("Enter the Passenger Name: ");
		passengerDetails.setPassengerName(sc.next());
		
		System.out.println("Enter the age: ");
		passengerDetails.setAqe(sc.nextInt());
		
		System.out.println("Enter the birth preference: ");
		passengerDetails.setBirthPreference(sc.next().charAt(0));
		
		if(bookedTickets < totalBerthTickets) {
			passengerDetails.setTicketNo(ticketNo++);
			totalPassengerDetailsList.getBookedPassengerList().put(passengerDetails.getPassengerId(), passengerDetails);
			bookedTickets++;
		}
		
		else if(bookedTickets < totalBerthTickets + totalRacTickets ) {
			totalPassengerDetailsList.getRacPassengerList().put(passengerDetails.getPassengerId(), passengerDetails);
			bookedTickets++;
		}
		
		else {
			totalPassengerDetailsList.getWaitingListPassengerList().put(passengerDetails.getPassengerId(), passengerDetails);
			bookedTickets++;
		}
		
		System.out.println("Ticket Booked Successfully");
		
	}


	private static void cancelTicket(TotalPassengerDetailsList totalPassengerDetailsList) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Passenger ID to cancel ticket: ");
		long passengerId = sc.nextLong();
		
		if(totalPassengerDetailsList.getBookedPassengerList().containsKey(passengerId)) {
			PassengerDetails passengerDetailsToRemove = totalPassengerDetailsList.getBookedPassengerList().get(passengerId);
			long ticketNoToAdd = passengerDetailsToRemove.getTicketNo();
			

			if(!totalPassengerDetailsList.getRacPassengerList().isEmpty()) {
				PassengerDetails passengerDetailsToAdd = totalPassengerDetailsList.getRacPassengerList().entrySet().iterator().next().getValue();
				passengerDetailsToAdd.setTicketNo(ticketNoToAdd);
				totalPassengerDetailsList.getBookedPassengerList().put(passengerDetailsToAdd.getPassengerId(), passengerDetailsToAdd);
				
				if(!totalPassengerDetailsList.getWaitingListPassengerList().isEmpty())
				{
					PassengerDetails passengerDetailsToAddRac = totalPassengerDetailsList.getWaitingListPassengerList().entrySet().iterator().next().getValue();
					totalPassengerDetailsList.getRacPassengerList().put(passengerDetailsToAddRac.getPassengerId(), passengerDetailsToAddRac);
					totalPassengerDetailsList.getWaitingListPassengerList().remove(passengerDetailsToAddRac.getPassengerId());
				}
				else {
					System.out.println("No bookings in waiting list to shift to RAC list");
				}
				totalPassengerDetailsList.getRacPassengerList().remove(passengerDetailsToAdd.getPassengerId());

			}
			else {
				System.out.println("No bookings in RAC list to shift to Booking list");
			}
			totalPassengerDetailsList.getBookedPassengerList().remove(passengerDetailsToRemove.getPassengerId());
			System.out.println("Ticket Cancelled Succesfully");
		}
		else {
			System.out.println("Passenger ID not exists to cancel");
		}
	}


	private static void displayBookedTickets(Map<Long, PassengerDetails> bookedPassengerList) {
		// TODO Auto-generated method stub
		
		if(bookedPassengerList == null || bookedPassengerList.isEmpty()) {
			System.out.println("No Bookings Done yet");
		}
		else {
			for(Map.Entry<Long, PassengerDetails> bookedPassenger: bookedPassengerList.entrySet()) {
				System.out.println(bookedPassenger.getValue());
			}
		}
		
	}


	private static void displayRacTickets(Map<Long, PassengerDetails> racPassengerList) {
		// TODO Auto-generated method stub
		
		if(racPassengerList == null || racPassengerList.isEmpty() ) {
			System.out.println("No RAC Bookings Done yet");
		}
		else {
			for(Map.Entry<Long, PassengerDetails> racPassenger: racPassengerList.entrySet()) {
				System.out.println(racPassenger.getValue());
			}
		}
	}


	private static void displayWaitingListTickets(Map<Long, PassengerDetails> waitingListPassengerList) {
		// TODO Auto-generated method stub
		
		if(waitingListPassengerList == null || waitingListPassengerList.isEmpty()) {
			System.out.println("No Waiting List Bookings Done yet");
		}
		else {
			for(Map.Entry<Long, PassengerDetails> waitingListPassenger: waitingListPassengerList.entrySet()) {
				System.out.println(waitingListPassenger.getValue());
			}
		}
		
	}

}  