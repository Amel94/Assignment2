//Author manusha 
public class FixBookControl {
	
	private FixBookUI ui; // variable name changed UI to ui
	private enum controlState { INITIALISED, READY, FIXING };// variable  name changed CONTROL_STATE to controlState
	private controlState state ; // changing the variable names CONTROL_STATE to controlState and StAtE to state
	
	private library lib; //variable name changed LIB to lib
	private book curBook; // variable name changed Cur_Book to curBook


	public FixBookControl() {
		this.lib = lib.INSTANCE();//variable name changed LIB to lib
		state = controlState.INITIALISED;// changing the variable names StAtE to state and CONTROL_STATE to controlState
	}
	
	
	public void Set_Ui(FixBookUI ui) {
		if (!state.equals(controlState.INITIALISED)) {// changing the varaiable name to StAtE to state and CONTROL_STATE to controlState
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
			lib.Repair_BOOK(Cur_Book);//variable name changed LIB to lib
		}
		Cur_Book = null;
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
