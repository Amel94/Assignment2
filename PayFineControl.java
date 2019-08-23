// auther: Ameesha, Reviewer: Manusha, Mediator: Nisal

public class PayFineControl {
	
	private PayFineUI UI; //changed Ui to UI
	private enum ControlState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED }; // Changed CONTROL_STATE  to ControlState
	private CONTROL_STATE StAtE;
	
	private library library; // Changed LiBrArY to library
	private member member; //Changed MeMbEr to member


	public PayFineControl() {
		this.library = Library.getInstance(); // Changed LiBrArY to library and LiBrArY.INSTANCE to Library.getInstance
		state = CONTROL_STATE.INITIALISED; //Changed StAte to state
	}
	
	
	public void Set_UI(PayFineUI ui) {
		if (!StAtE.equals(CONTROL_STATE.INITIALISED)) {
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = ui;
		ui.Set_State(PayFineUI.UI_STATE.READY);
		state = CONTROL_STATE.READY; //Changed StAte to state		
	}


	public void Card_Swiped(int memberId) {
		if (!state.equals(CONTROL_STATE.READY)) //Changed StAte to state {
			throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
		}	
		member = library.MEMBER(memberId); // Changed MwMbEr to member and Changed LiBrArY to library
		
		if (member == null) // Changed MwMbEr to member{
			Ui.DiSplAY("Invalid Member Id");
			return;
		}
		Ui.DiSplAY(member.toString()); // Changed MwMbEr to member
		Ui.Set_State(PayFineUI.UI_STATE.PAYING);
		state = CONTROL_STATE.PAYING; //Changed StAte to state
	}
	
	
	public void cancel() // Changed CaNcEl to cancel {
		Ui.Set_State(PayFineUI.UI_STATE.CANCELLED);
		state = CONTROL_STATE.CANCELLED; //Changed StAte to state
	}


	public double PaY_FiNe(double amount) // Changed AmOuNt to amount { 
		if (!state.equals(CONTROL_STATE.PAYING)) //Changed StAte to state {
			throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
		}	
		double Change = member.Pay_Fine(amount); // Changed MwMbEr to member and Changed ChAnGe to Change and Changed AmOuNt to amount
		if (Change > 0)// Changed ChAnGe to Change {
			Ui.display(String.format("Change: $%.2f", Change)); // Changed ChAnGe to Change and DiSplay to display
		}
		Ui.display(member.toString()); // Changed MwMbEr to member and DiSplay to display
		Ui.Set_State(PayFineUI.UI_STATE.COMPLETED);
		state = CONTROL_STATE.COMPLETED; //Changed StAte to state
		return Change; // Changed ChAnGe to Change
	}
	


}
