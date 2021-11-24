package Implementation;

public class Room {
	private String building;
	private String roomNum;
	
	public Room(String building, String roomNum) {
		this.building = building;
		this.roomNum = roomNum;
	}

	public String getBuilding() {
		return building;
	}

	public String getRoomNumber() {
		return roomNum;
	}
}
