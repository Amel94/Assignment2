import java.util.Scanner;


public class ReturnBookUI {

	public static enum uiState { INITIALISED, READY, INSPECTING, COMPLETED }; // changed UI_STATE to uiState - Amel

	private ReturnBookControl control; // changed CoNtRoL to control - Amel
	private Scanner input;
	private uiState state; // changed StATe to state - Amel // changed UI_STATE to uiState - Amel

	
	public ReturnBookUI(ReturnBookControl control) {
		this.control = control; // changed CoNtRoL to control - Amel
		input = new Scanner(System.in);
		state =  uiState.INITIALISED; // changed StATe to state - Amel. // changed UI_STATE to uiState - Amel
		control.Set_UI(this);
	}


	public void run() {// changed RuN to run - Amel	 	
		output("Return Book Use Case UI\n");
		
		while (true) {
			
			switch (state) { // changed StATe to state - Amel
			
			case INITIALISED:
				break;
				
			case READY:
				String bookStr = input("Scan Book (<enter> completes): "); // changed Book_STR to bookStr - Amel
				if (bookStr.length() == 0) { // changed Book_STR to bookStr - Amel
					control.Scanning_Complete(); // changed CoNtRoL to control - Amel
				}
				else {
					try {
						int Book_Id = Integer.valueOf(bookStr).intValue(); // changed Book_STR to bookStr - Amel
						control.Book_scanned(Book_Id); // changed CoNtRoL to control - Amel
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				String answer = input("Is book damaged? (Y/N): "); // changed ans to answer - Amel
				boolean Is_Damaged = false;
				if (answer.toUpperCase().equals("Y")) {					
					Is_Damaged = true;
				}
				control.Discharge_loan(Is_Damaged); // changed CoNtRoL to control - Amel
			
			case COMPLETED:
				output("Return processing complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("ReturnBookUI : unhandled state :" + state);	 // changed StATe to state - Amel		
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
	
	public void Set_State(uiState uiState) { // changed state to uiState - Amel // changed UI_STATE to uiState - Amel
		this.state = uiState; // changed StATe to state - Amel
	}

	
}
