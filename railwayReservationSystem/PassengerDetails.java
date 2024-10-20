package railwayReservationSystem;

public class PassengerDetails {

	private long passengerId;
	private String passengerName;
	private int aqe;
	private char birthPreference;
	private long ticketNo;
	
	public long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAqe() {
		return aqe;
	}
	public void setAqe(int aqe) {
		this.aqe = aqe;
	}
	public char getBirthPreference() {
		return birthPreference;
	}
	public void setBirthPreference(char birthPreference) {
		this.birthPreference = birthPreference;
	}
	public long getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(long ticketNo) {
		this.ticketNo = ticketNo;
	}
	@Override
	public String toString() {
		return "PassengerDetails [passengerId=" + passengerId + ", passengerName=" + passengerName + ", aqe=" + aqe
				+ ", birthPreference=" + birthPreference + ", ticketNo=" + ticketNo + "]";
	}
	
}
