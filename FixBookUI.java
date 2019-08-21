// author Manusha Anjaana
import java.util.Scanner;


public class FixBookUI {

	public static enum UI_STATE { INITIALISED, READY, FIXING, COMPLETED };

	private FixBookControl control; // variable name changed to CoNtRoL to control
	private Scanner input;
	private UI_STATE state; // variable name changed StAtE to state

	
	public FixBookUI(FixBookControl control) {
		this.control = control; // variable name changed to CoNtRoL to control
		input = new Scanner(System.in);
		state = UI_STATE.INITIALISED; // variable name changed to CoNtRoL to control
		control.Set_Ui(this);
	}


	public void Set_State(UI_STATE state) {
		this.state = state;  // variable name changed StAtE to state
	}

	
	public void RuN() {
		output("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (state) {  // variable name changed StAtE to state
			
			case READY:
				String bookstr = input("Scan Book (<enter> completes): "); // variable name changed  Book_STR to bookstr
				if (bookstr.length() == 0) {  // variable name changed  Book_STR to bookstr
					control.SCannING_COMplete();// variable name changed to CoNtRoL to control
				}
				else {
					try {
						int bookId = Integer.valueOf(bookstr).intValue(); // variable name changed  Book_ID to bookId
						control.Book_scanned(bookId); // variable name changed to CoNtRoL to control and Book_ID to bookId
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String ans = input("Fix Book? (Y/N) : "); // variable name changed to AnS to ans
				boolean fix = false; // variable name changes FiX to fix
				if (ans.toUpperCase().equals("Y")) { // variable name changed to AnS to ans
					fix = true;// variable name changes FiX to fix
				}
				control.FIX_Book(fix);  // variable name changes FiX to fix  and CoNtRoL to control
				break;
								
			case COMPLETED:
				output("Fixing process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);  // variable name changed StAtE to state	
			
			}		
		}
		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}
	

	public void display(Object object) {
		output(object);
	}
	
	
}
