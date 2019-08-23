import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Loan implements Serializable {//changed class name loan to Loan-pavan
	
	public static enum LOAN_STATE { CURRENT, OVER_DUE, DISCHARGED };
	
	private int loanId;// changed ID to loanId- pavan
	private Book book;//changed book to Book and Variable B to book- pavan
	private Member member;//changed member to Member and Variable M to member- pavan
	private Date dueDate;//Changed D to duedate-pavan
	private String state;//Changed datatype from loanState to String- pavan

	
	public Loan(int loanId, Book book, Member member, Date dueDate) {//changed loan to Loan, book to Book, member to Member- pavan
		
		this.loanId = loanId; // changed ID to loanId-pavan
		this.book = book;// changed B to book-pavan
		this.member= member;// changed M to member -pavan
		this.dueDate = dueDate;// changed D to dueDate- pavan
		this.state = LOAN_STATE.CURRENT;
	}

	
	public void checkOverDue() {
		if (this.state == LOAN_STATE.CURRENT &&
			Calendar.INSTANCE().Date().after(this.dueDate)) {//Changed D to this.dueDate-pavan
			this.state = LOAN_STATE.OVER_DUE;			
		}
	}

	
	public boolean isOverDue() { //Changed OVer_Due to Over_due - pavan
		return this.state == LOAN_STATE.OVER_DUE; //changed object calling to this.state-pavan
	}

	
	public int getLoanId() {//changed Integer ID to int getLoanId- Pavan
		return this.loanId;//changed object calling to this.loanId from id-pavan
	}


	public Date getDueDate() { // Changed Get_Due_Date to getDueDate -pavan
		return this.dueDate;//changed object calling to this.dueDate from D-pavan
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		sb.append("Loan:  ").append(getLoanId).append("\n")//changed iD to getLoanId-Pavan
		  .append("  Borrower ").append(getMember.getId()).append(" : ")//changed M.Get_ID to getMember.getId-Pavan
		  .append(getMember.getLastName()).append(", ").append(getMember.getFirstName()).append("\n")//changed M.Get_LastName to getMember.getLastName, M.Get_FirstName to getMember.getFirstName-Pavan
		  .append("  Book ").append(getBook.getId()).append(" : " )//Changed B.ID to getBook.getId -PAVAN
		  .append(getBook.getTitle()).append("\n")// Changed B.TITLE to getBook.getTitle -Pavan
		  .append("  DueDate: ").append(sdf.format(getDueDate)).append("\n")// Changed D to getDueDate- Pavan
		  .append("  State: ").append(getState);// changed state to getState -Pavan	
		return sb.toString();
	}

    public String getState(){ //added Getter method to state - Pavan
        return this.state; // changed object calling to this.state from state-pavan
        
    }
	public Member getMember() { // Changed member to Member - Pavan
		return this.member; // changed B to this.member - Pavan
	}


	public Book getBook() { // Changed book to Book - Pavan
		return this.book; // changed  to this.member - Pavan
	}


	public boolean isDischarged() { //changed void to boolean and DiScHaRgE to isDischarge-Pavan
		this.state == LOAN_STATE.DISCHARGED;//	changed object calling  from state  to this.state-pavan	
	}

}
