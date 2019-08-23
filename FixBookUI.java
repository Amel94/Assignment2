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
		control.setUserInterface(this);// method name changed Set_Ui to setUserInterface
	}


	public void setState(UI_STATE state) { // method name changed Set_State to setState
		this.state = state;  // variable name changed StAtE to state
	}

	
	public void run() { // method name changed RuN to run
		output("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (state) {  // variable name changed StAtE to state
			
			case READY:
				String bookString = input("Scan Book (<enter> completes): "); // variable name changed  Book_STR to bookString
				if (bookString.length() == 0) {  // variable name changed  Book_STR to bookString
					control.scanningComplete();// variable name changed to CoNtRoL to control // method name changed SCannING_COMplete() to scanningComplete()
				}
				else {
					try {
						int bookId = Integer.valueOf(bookString).intValue(); // variable name changed  Book_ID to bookId Book_STR to bookString
						control.bookScanned(bookId); // variable name changed to CoNtRoL to control and Book_ID to bookId  and method name changed Book_scanned to bookScanned()
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String answer = input("Fix Book? (Y/N) : "); // variable name changed to AnS to answer
				boolean fix = false; // variable name changes FiX to fix
				if (answer.toUpperCase().equals("Y")) { // variable name changed to AnS to answer
					fix = true;// variable name changes FiX to fix
				}
				control.fixBook(fix);  // variable name changes FiX to fix  and CoNtRoL to control method name changes to FIX_Book to fixBook()
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
