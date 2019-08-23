// auther: Ameesha, Reviewer: Manusha, Mediator: Nisal

public class ReturnBookControl {

	private ReturnBookUI Ui;
	private enum ControlState { INITIALISED, READY, INSPECTING }; //Changed CONTROL_STATE to ControlState
	private ControlState state; //Changed CONTROL_STATE to ControlState and sTaTe to state
	
	private library library; // Changed lIbRaRy to library
	private loan CurrENT_loan; // Chnaged CurrENT_loan to current_loan
	

	public ReturnBookControl() {
		this.library = library.Instance(); // Changed lIbRaRy to library and lIbRaRy.INSTANCE to library.Instance
		state = CONTROL_STATE.INITIALISED; // Changed sTaTe to state
	}
	
	
	public void Set_UI(ReturnBookUI ui) {
		if (!sTaTe.equals(CONTROL_STATE.INITIALISED)) {
			throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = ui;
		ui.Set_State(ReturnBookUI.UI_STATE.READY);
		state = CONTROL_STATE.READY; // Changed sTaTe to state		
	}


	public void Book_scanned(int Book_ID) {
		if (!state.equals(CONTROL_STATE.READY)) // Changed sTaTe.equals to state.equals 
		{ 
			throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
		}	
		book CurrentBook_book = library.book(book_ID); // Changed lIbRaRy.Book to library.book and Book_ID to book_ID and Changed 'CUR_book' to 'CurrentBook'
		
		if (CurrentBook == null) // Changed 'CUR_book' to 'CurrentBook'
		{
			Ui.display("Invalid Book Id");
			return;
		}
		if (!CurrentBook_book.On_loan()) // Changed 'CUR_book' to 'CurrentBook' 
		{
			Ui.display("Book has not been borrowed");
			return;
		}		
		current_loan = library.LOAN_BY_BOOK_ID(Book_ID); // Changed 'CurrENT_loan' to 'current_loan' and  'lIbRaRy' to library'	
		double Over_Due_Fine = 0.0;
		if (current_loan.OVer_Due()) // Changed 'CurrENT_loan.OVer_Due' to 'current_loan.OVer_Due' 
		{
			Over_Due_Fine = library.CalculateOverDueFine(current_loan); // Changed 'lIbRaRy.CalculateOverDueFine' to 'library.CalculateOverDueFine' and 'CurrENT_loan' to 'current_loan' 
		}
		Ui.display("Inspecting");
		Ui.display(CurrentBook.toString()); // Changed 'CUR_book' to 'CurrentBook'
		Ui.display(current_loan.toString()); // Changed 'CurrENT_loan.toString' to 'current_loan.toString'
		
		if (current_loan.over_Due()) // Changed 'CurrENT_loan.OVer_Due' to 'current_loan.over_Due'
		{
			Ui.display(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));
		}
		Ui.Set_State(ReturnBookUI.UI_STATE.INSPECTING);
		state = CONTROL_STATE.INSPECTING; // Changed 'sTaTe' to 'state'		
	}


	public void Scanning_Complete() {
		if (!state.equals(CONTROL_STATE.READY)) // // Changed 'sTaTe.equals' to 'state.equals'	
		{
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
		}	
		Ui.Set_State(ReturnBookUI.UI_STATE.COMPLETED);		
	}


	public void Discharge_loan(boolean isDamaged) {
		if (!state.equals(CONTROL_STATE.INSPECTING)) // Changed 'sTaTe.equals' to 'state.equals'
		{
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
		}	
		lIbRaRy.Discharge_loan(current_loan, isDamaged); // Changed 'CurrENT_loan' to 'current_loan'
		current_loan = null; // Changed 'CurrENT_loan' to 'current_loan'
		Ui.Set_State(ReturnBookUI.UI_STATE.READY);
		state = CONTROL_STATE.READY; // Changed 'sTaTe' to 'state'				
	}


}
