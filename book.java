import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable { // changed book to Book - Amel
	
	private String title;  //changed TITLE to title - Amel
	private String author; //changed AUTHOR to author - Amel
	private String callNo; //changed CALLNO to callNo - Amel
	private int id; //changed ID to id - Amel
	
	private enum state { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };  //changed STATE to state - Amel
	private state state;//changed STATE to state - Amel. //changed State to state - Amel
	
	
	public book(String author, String title, String callNo, int id) {
		this.author = author; //changed AUTHOR to author - Amel
		this.title = title; //changed TITLE to title - Amel
		this.callNo = callNo; //changed CALLNO to callNo - Amel
		this.id = id;  //changed ID to id - Amel
		this.State = state.AVAILABLE; //changed STATE to state - Amel
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(id).append("\n")  //changed ID to id - Amel
		  .append("  Title:  ").append(title).append("\n") //changed TITLE to title - Amel
		  .append("  Author: ").append(author).append("\n") //changed AUTHOR to author - Amel
		  .append("  CallNo: ").append(callNo).append("\n") //changed CALLNO to callNo - Amel
		  .append("  State:  ").append(state); //changed STATE to state - Amel
		
		return sb.toString();
	}

	public Integer id() { //changed ID to id - Amel
		return id; //changed ID to id - Amel
	}

	public String title() { //changed TITLE to title - Amel
		return title; //changed TITLE to title - Amel
	}


	
	public boolean available() { /changed AVAILABLE to available - Amel
		return State == state.available; //changed STATE to state - Amel. AVAILABLE to available - Amel
	}

	
	public boolean On_loan() {
		return State == state.ON_LOAN; //changed STATE to state - Amel
	}

	
	public boolean IS_Damaged() {
		return State == state.DAMAGED; //changed STATE to state - Amel
	}

	
	public void Borrow() {
		if (State.equals(state.AVAILABLE)) { //changed STATE to state - Amel
			State = state.ON_LOAN; //changed STATE to state - Amel
		}
		else {
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));
		}
		
	}


	public void Return(boolean DAMAGED) {
		if (State.equals(STATE.ON_LOAN)) {
			if (DAMAGED) {
				State = state.DAMAGED; //changed STATE to state - Amel
			}
			else {
				State = state.AVAILABLE; //changed STATE to state - Amel
			}
		}
		else {
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));
		}		
	}

	
	public void Repair() {
		if (State.equals(state.DAMAGED)) { //changed STATE to state - Amel
			State = state.AVAILABLE; //changed STATE to state - Amel
		}
		else {
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));
		}
	}


}
