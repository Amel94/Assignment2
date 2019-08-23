// auther: Ameesha, Reviewer: Manusha, Mediator: Nisal

import java.util.Scanner;


public class PayFineUI {


	public static enum UiState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED }; // Changed UI_STATE to UiState

	private PayFineControl control; //Changed CoNtRol to control
	private Scanner input;
	private UI_STATE state; // Changed UI_STATE to UiState and StAtE to state

	
	public PayFineUI(PayFineControl control) {
		this.control = control; //Changed this.CoNtRol to this.control
		input = new Scanner(System.in);
		state = UiState.INITIALISED; // Changed UI_STATE to UiState  and Chanegd StAtE to state
		control.Set_UI(this);
	}
	
	
	public void Set_State(UI_STATE state) {
		this.state = state; //Chanegd this.StAtE to this.state
	}


	public void RuN() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) //Chanegd StAtE to state {
			
			case READY:
				String Mem_Str = input("Swipe member card (press <enter> to cancel): ");
				if (Mem_Str.length() == 0) {
					control.cancel(); //Changed CoNtRol.CaNcEl to control.cancel
					break;
				}
				try {
					int Member_ID = Integer.valueOf(Mem_Str).intValue();
					control.Card_Swiped(Member_ID); //Chnaged CoNtRoL.Card_Swiped to control.Card_Swiped
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double amount = 0; //Changed AmouNT to amount
				String Amt_Str = input("Enter amount (<Enter> cancels) : ");
				if (Amt_Str.length() == 0) {
					control.cancel(); //Changed CoNtRol.CaNcEl to control.cancel
					break;
				}
				try {
					amount = Double.valueOf(Amt_Str).doubleValue();  //Changed AmouNT to amount
				}
				catch (NumberFormatException e) {}
				if (amount <= 0) //Changed AmouNT to amount  
				{
					output("Amount must be positive");
					break;
				}
				control.PaY_FiNe(amount); // Changed CoNtRoL.PaY_FiNe to control.PaY_FiNe and Changed AmouNT to amount
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state); //Chanegd StAtE to state			
			
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
			

	public void display(Object object) //Changed DiSplAY to display  
	{
		output(object);
	}


}
