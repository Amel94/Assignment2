import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class loan implements Serializable {
	
	public static enum LOAN_STATE { CURRENT, OVER_DUE, DISCHARGED }; //changed LOAN_STATE to loanState - Amel
	
	private int id; //changed ID to id - Amel
	private book b; //changed B to b - Amel
	private member m; //changed M to m - Amel
	private Date d; //changed D to d - Amel
	private loanState state; //changed LOAN_STATE to loanState - Amel

	
	public loan(int loanId, book book, member member, Date dueDate) {
		this.id = loanId; //changed ID to id - Amel
		this.b = book; //changed B to b - Amel
		this.m = member; //changed M to m - Amel
		this.d = dueDate; //changed D to d - Amel
		this.state = loanState.CURRENT; //changed LOAN_STATE to loanState - Amel
	}

	
	public void checkOverDue() {
		if (state == loanState.CURRENT && //changed LOAN_STATE to loanState - Amel
			Calendar.INSTANCE().Date().after(D)) {
			this.state = loanState.OVER_DUE;	 //changed LOAN_STATE to loanState - Amel		
		}
	}

	
	public boolean Over_Due() { //Changed OVer_Due to Over_due - pavan
		return state == loanState.OVER_DUE; //changed LOAN_STATE to loanState - Amel
	}

	
	public Integer id() { //changed ID to id - Amel
		return id; //changed ID to id - Amel
	}


	public Date getDueDate() { //changed Get_Due_Date to getDueDate - Amel
		return D; //changed D to d - Amel
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		sb.append("Loan:  ").append(ID).append("\n")
		  .append("  Borrower ").append(M.Get_ID()).append(" : ")//changed GeT to Get-Pavan
		  .append(M.Get_LastName()).append(", ").append(M.Get_FirstName()).append("\n")
		  .append("  Book ").append(B.ID()).append(" : " )
		  .append(B.TITLE()).append("\n")
		  .append("  DueDate: ").append(sdf.format(D)).append("\n")
		  .append("  State: ").append(state);		
		return sb.toString();
	}


	public member member() { //changed Member to member - Amel
		return m; //changed M to m - Amel
	}


	public book Book() { //changed Book to book - Amel
		return b; //changed B to b - Amel
	}


	public void Discharge() { //changed DiScHaRgE to Discharge-Pavan
		state = loanState.DISCHARGED;	 //changed LOAN_STATE to loanState - Amel	
	}

}
