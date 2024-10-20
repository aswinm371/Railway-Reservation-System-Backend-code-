package railwayReservationSystem;

import java.util.Map;

public class TotalPassengerDetailsList {


	private Map<Long, PassengerDetails> bookedPassengerList;
	private Map<Long, PassengerDetails> racPassengerList;
	private Map<Long, PassengerDetails> waitingListPassengerList;

	public Map<Long, PassengerDetails> getBookedPassengerList() {
		return bookedPassengerList;
	}
	public void setBookedPassengerList(Map<Long, PassengerDetails> bookedPassengerList) {
		this.bookedPassengerList = bookedPassengerList;
	}
	public Map<Long, PassengerDetails> getRacPassengerList() {
		return racPassengerList;
	}
	public void setRacPassengerList(Map<Long, PassengerDetails> racPassengerList) {
		this.racPassengerList = racPassengerList;
	}
	public Map<Long, PassengerDetails> getWaitingListPassengerList() {
		return waitingListPassengerList;
	}
	public void setWaitingListPassengerList(Map<Long, PassengerDetails> waitingListPassengerList) {
		this.waitingListPassengerList = waitingListPassengerList;
	}
}
