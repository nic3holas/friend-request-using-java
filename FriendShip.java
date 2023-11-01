package friendrequest;

public class FriendShip {
	private Person start;
	private Person end;
	private Integer weight;
	
	public FriendShip(Person startV, Person endV, Integer inputWeight) {
		this.start = startV;
		this.end = endV;
		this.weight = inputWeight;
	}
	
	public Person getStart() {
		return this.start;
	}
	
	public Person getEnd() {
		return this.end;
	}
	
	public Integer getWeight() {
		return this.weight;
	}
}
