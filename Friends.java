package friendrequest;
import java.util.*;
public class Friends {
	private ArrayList<Person> vertices;
	private boolean isWeighted;
	private boolean isDirected;
	
	public Friends(boolean inputIsWeighted, boolean inputIsDirected) {
		this.vertices = new ArrayList<Person>();
		this.isWeighted = inputIsWeighted;
		this.isDirected = inputIsDirected;
	}
	 
	public Person addVertex(String data) {
		Person newVertex = new Person(data);
		this.vertices.add(newVertex);
		return newVertex;
	}
	
	public void friendRequest(Person person1, Person person2, Integer weight) {
		if(!this.isWeighted) {
			weight = null;
		}
		person1.friendRequest(person2, weight);
		if (!this.isDirected) {
			person2.friendRequest(person1, weight);
		}
	}
	
	public void unFriend(Person person1, Person person2) {
		person1.unFriend(person2);
		if(!this.isDirected) {
			person2.unFriend(person1);
		}
	}
	
	public void removeVertex(Person person) {
		this.vertices.remove(person);
	}
	
	public ArrayList<Person> getVertices(){
		return this.vertices;
	}
	
	public boolean isWeighted() {
		return this.isWeighted;
	}
	
	public boolean isDirected() {
		return this.isDirected;
	}
	
	public Person getVertexByValue(String value) {
		for(Person v: this.vertices) {
			if(v.getData() == value) {
				return v;
			}
		}
		return null;
	}
	
	public void print() {
		for(Person v: this.vertices) {
			v.print(isWeighted);
		}
	}
	public static void main(String[] args) {
		Friends friend = new Friends(true, true );
		Person John = friend.addVertex("John");
	    Person Jane = friend.addVertex("Jane");
		Person Mercy = friend.addVertex("Mercy");
		Person Brian = friend.addVertex("Brian");
		Person Peter = friend.addVertex("Peter");
		Person Mary = friend.addVertex("Mary");
		Person Joyce = friend.addVertex("Joyce");
		Person Martin = friend.addVertex("Martin");
		Person Nicholas = friend.addVertex("Nicholas Murimi");
		Person Moses = friend.addVertex("Moses");
		
		friend.friendRequest(John, Mercy, 100);
		friend.friendRequest(John, Nicholas, 200);
		friend.friendRequest(Nicholas, John, 1000);
		friend.friendRequest(Mary, John, 1000);
		friend.friendRequest(Martin, Joyce, 1000);
		friend.friendRequest(Peter, Joyce, 1000);
		friend.friendRequest(Jane, Moses, 1000);
		friend.friendRequest(Moses, Jane, 1000);
		friend.friendRequest(Nicholas, Moses, 1000);
		friend.friendRequest(Nicholas, Peter, 1000);
		
		friend.unFriend(Martin, Joyce);
		
		friend.print();
	}

}
