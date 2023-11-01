package friendrequest;
import java.util.*;
import java.util.ArrayList;

public class Person {
	private String data;
	private ArrayList<FriendShip> edges;
	
	public Person (String inputData) {
		this.data = inputData;
		this.edges = new ArrayList<FriendShip>();
	}
	
	public void friendRequest(Person person2, Integer weight ) {
		this.edges.add(new FriendShip(this, person2, weight));
	}
	
	public void unFriend(Person person2) {
		this.edges.removeIf(edge -> edge.getEnd().equals(person2) ); 
	}


public String getData() {
	return this.data;
}

public ArrayList<FriendShip> getEdges(){
	return this.edges;
}

public void print(boolean showWeight) {
	String message = "";
	
	if (this.edges.size() == 0) {
		System.out.println(this.data + " -->");
		return;
	}
	for(int i = 0; i<this.edges.size(); i++) {
		if (i == 0) { 
			message += this.edges.get(i).getStart().data + " -->  ";
			
		}
		
		message += this.edges.get(i).getEnd().data;
		
		if (showWeight) {
			message += "(" + this.edges.get(i).getWeight() + ")";
		}
		
		if (i != this.getEdges().size() -1) {
			message += ", ";
		}
	}
	System.out.println(message);
}
}
