//Author manusha 
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
	
	
	public void setUserInterface(FixBookUI userInterface) { // Set_Ui changed  to setUserInterface
		if (!state.equals(ControlState.INITIALISED)) {// changing the varaiable name to StAtE to state and CONTROL_STATE to ControlState
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.ui = ui; // variable name changed UI to ui
		ui.Set_State(FixBookUI.UI_STATE.READY);
		state = controlState.READY;	// changing the variable names StAtE to state and CONTROL_STATE to controlState
	}


	public void Book_scanned(int bookId) {
		if (!state.equals(controlState.READY)) {// changing the variable names StAtE to state and CONTROL_STATE to controlState
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
		}	
		curBook = lib.Book(bookId);// variable name changed Cur_Book to curBook and LIB to lib
		
		if (curBook == null) {// variable name changed Cur_Book to curBook
			ui.display("Invalid bookId"); // variable name changed UI to ui
			return;
		}
		if (!curBook.IS_Damaged()) {// variable name changed Cur_Book to curBook
			ui.display("Book has not been damaged"); // variable name changed UI to ui
			return;
		}
		ui.display(curBook.toString());// variable name changed Cur_Book to curBook and UI to ui
		ui.Set_State(FixBookUI.UI_STATE.FIXING); // variable name changed UI to ui
		state= controlState.FIXING;// changing the variable names StAtE to state and CONTROL_STATE to controlState
	}


	public void fixBook(boolean mustFix) { // method name changed fix_Book to fixBook and variable name changed MUST_fix to mustFix
		if (!state.equals(controlState.FIXING)) {// changing the variable names StAtE to state and CONTROL_STATE to controlState
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
		}	
		if (mustFix) { // variable name changed MUST_fix to mustFix
			lib.Repair_BOOK(curBook);//variable name changed LIB to lib  variable name changed Cur_Book to curBook
		}
		curBook = null; //variable name changed Cur_Book to curBook
		ui.Set_State(FixBookUI.UI_STATE.READY);// variable name changed UI to ui
		state = controlState.READY;// changing the variable names StAtE to state and CONTROL_STATE to controlState		
	}

	
	public void scanningComplete() { // method name changed SCannING_COMplete to scanningComplete
		if (!state.equals(controlState.READY)) {// changing the variable names StAtE to state and CONTROL_STATE to controlState
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
		}	
		ui.Set_State(FixBookUI.UI_STATE.COMPLETED);// variable name changed UI to ui	
	}






}
