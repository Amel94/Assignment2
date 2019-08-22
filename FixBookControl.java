//Author Manusha Anjaana
public class FixBookControl {
	
	private FixBookUI userInterface; // variable name changed UI to userInterface
	private enum ControlState { INITIALISED, READY, FIXING };// variable  name changed CONTROL_STATE to ControlState
	private ControlState state ; // changing the variable names CONTROL_STATE to ControlState and StAtE to state
	
	private library library; //variable name changed LIB to library
	private book currentBook; // variable name changed Cur_Book to currentBook


	public FixBookControl() {
		this.library = library.INSTANCE();//variable name changed LIB to lib
		state = ControlState.INITIALISED;// changing the variable names StAtE to state and CONTROL_STATE to ControlState
	}
	
	
	public void setUserInterface(FixBookUI userInterface) { // method name Set_Ui changed  to setUserInterface
		if (!state.equals(ControlState.INITIALISED)) {// changing the varaiable name to StAtE to state and CONTROL_STATE to ControlState
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.userInterface = userInterface; // variable name changed UI to userInterface
		userInterface.Set_State(FixBookUI.UI_STATE.READY);
		state = ControlState.READY;	// changing the variable names StAtE to state and CONTROL_STATE to ControlState
	}


	public void BookScanned(int bookId) {// class name changed Book_scanned to BookScanned
		if (!state.equals(ControlState.READY)) {// changing the variable names StAtE to state and CONTROL_STATE to ControlState
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
		}	
		currentBook = library.Book(bookId);// variable name changed Cur_Book to currentBook and LIB to library
		
		if (currentBook == null) {// variable name changed Cur_Book to currentBook
			userInterface.display("Invalid bookId"); // variable name changed UI to userInterface
			return;
		}
		if (!currentBook.IS_Damaged()) {// variable name changed Cur_Book to currentBook
			userInterface.display("Book has not been damaged"); // variable name changed UI to userInterface
			return;
		}
		userInterface.display(curBook.toString());// variable name changed Cur_Book to curBook and UI to userInterface
		userInterface.Set_State(FixBookUI.UI_STATE.FIXING); // variable name changed UI to userInterface
		state= ControlState.FIXING;// changing the variable names StAtE to state and CONTROL_STATE to ControlState
	}


	public void FixBook(boolean mustFix) { // method name changed fix_Book to FixBook and variable name changed MUST_fix to mustFix
		if (!state.equals(ControlState.FIXING)) {// changing the variable names StAtE to state and CONTROL_STATE to ControlState
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
		}	
		if (mustFix) { // variable name changed MUST_fix to mustFix
			library.repairBook(currentBook);//variable name changed LIB to lib  variable name changed Cur_Book to currentBook
			// method name changed Repair_BOOK to repairBook()
		}
		currentBook = null; //variable name changed Cur_Book to currentBook
		userInterface.Set_State(FixBookUI.UI_STATE.READY);// variable name changed UI to userInterface
		state = ControlState.READY;// changing the variable names StAtE to state and CONTROL_STATE to ControlState		
	}

	
	public void ScanningComplete() { // method name changed SCannING_COMplete to ScanningComplete
		if (!state.equals(ControlState.READY)) {// changing the variable names StAtE to state and CONTROL_STATE to ControlState
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
		}	
		userInterface.Set_State(FixBookUI.UI_STATE.COMPLETED);// variable name changed UI to userInterface	
	}






}
