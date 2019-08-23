import java.util.ArrayList;
import java.util.List;

public class BorrowBookControl {
	
	private BorrowBookUI UI;
	
	private library library; // changed LIBRARY to library - nisal
	private member member; // changed M to member - nisal
	private enum CONTROL_STATE { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	private CONTROL_STATE State;
	
	private List<book> PENDING;
	private List<loan> COMPLETED;
	private book book; // changed BOOK to book - nisal
	
	
	public BorrowBookControl() {
		this.LIBRARY = LIBRARY.INSTANCE();
		State = CONTROL_STATE.INITIALISED;
	}
	

	public void setUI(BorrowBookUI ui) {
		if (!State.equals(CONTROL_STATE.INITIALISED)) 
			throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");
			
		this.UI = ui;
		ui.Set_State(BorrowBookUI.UI_STATE.READY);
		State = CONTROL_STATE.READY;		
	}

		
	public void swiped(int MEMMER_ID) { // changed Swiped to swipe - nisal
		if (!State.equals(CONTROL_STATE.READY)) 
			throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");
			
		member = LIBRARY.MEMBER(MEMMER_ID); // changed M to member - nisal
		if (member == null) { // changed M to member - nisal
			UI.Display("Invalid memberId");
			return;
		}
		if (LIBRARY.MEMBER_CAN_BORROW(member)) { // changed M to member - nisal
			PENDING = new ArrayList<>();
			UI.Set_State(BorrowBookUI.UI_STATE.SCANNING);
			State = CONTROL_STATE.SCANNING; }
		else 
		{
			UI.Display("Member cannot borrow at this time");
			UI.Set_State(BorrowBookUI.UI_STATE.RESTRICTED); }}
	
	
	public void scanned(int bookId) { // changes Scanned to scanned - nisal
		book = null; // changed BOOK to book - nisal
		if (!State.equals(CONTROL_STATE.SCANNING)) {
			throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
		}	
		book = LIBRARY.Book(bookId); // changed BOOK to book - nisal
		if (book == null) { // changed BOOK to book - nisal
			UI.Display("Invalid bookId");
			return;
		}
		if (!book.AVAILABLE()) { // changed BOOK to book - nisal
			UI.Display("Book cannot be borrowed");
			return;
		}
		PENDING.add(book); // changed BOOK to book - nisal
		for (book b : PENDING) { // changed B to b - nisal
			UI.Display(b.toString()); // changed B to b - nisal
		}
		if (LIBRARY.Loans_Remaining_For_Member(M) - PENDING.size() == 0) {
			UI.Display("Loan limit reached");
			Complete();
		}
	}
	
	
	public void complete() { // changed Complete to complete - nisal
		if (PENDING.size() == 0) {
			cancel();
		}
		else {
			UI.Display("\nFinal Borrowing List");
			for (book b : PENDING) { // changed B to b - nisal
				UI.Display(b.toString()); // changed B to b - nisal
			}
			COMPLETED = new ArrayList<loan>();
			UI.Set_State(BorrowBookUI.UI_STATE.FINALISING);
			State = CONTROL_STATE.FINALISING;
		}
	}


	public void commitLoans() { // changed Commit_LOans to commitLoans - nisal
		if (!State.equals(CONTROL_STATE.FINALISING)) {
			throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
		}	
		for (book b : PENDING) { // changed B to b - nisal
			loan LOAN = LIBRARY.ISSUE_LAON(b, member);  // changed B to b - nisal  // changed M to member - nisal
			COMPLETED.add(LOAN);			
		}
		UI.Display("Completed Loan Slip");
		for (loan LOAN : COMPLETED) {
			UI.Display(LOAN.toString());
		}
		UI.Set_State(BorrowBookUI.UI_STATE.COMPLETED);
		State = CONTROL_STATE.COMPLETED;
	}

	
	public void cancel() {
		UI.Set_State(BorrowBookUI.UI_STATE.CANCELLED);
		State = CONTROL_STATE.CANCELLED;
	}
	
	
}
