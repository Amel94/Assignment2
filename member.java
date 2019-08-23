import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class member implements Serializable {

	private String ln; // change LN to ln - Amel
	private String fn; // change FN to fn - Amel
	private String em; // change EM to em - Amel
	private int pn; // change PN to pn - Amel
	private int id; // change ID to id - Amel
	private double fines; // change FINES to fines - Amel
	
	private Map<Integer, loan> LNS;

	
	public member(String lastName, String firstName, String email, int phoneNo, int id) {
		this.LN = lastName;
		this.FN = firstName;
		this.EM = email;
		this.PN = phoneNo;
		this.ID = id;
		
		this.LNS = new HashMap<>();
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(id).append("\n") // change ID to id - Amel
		  .append("  Name:  ").append(ln).append(", ").append(fn).append("\n") // change LN to ln - Amel // change FN to fn - Amel
		  .append("  Email: ").append(em).append("\n") // change EM to em - Amel
		  .append("  Phone: ").append(pn) // change PN to pn - Amel
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", fines)) // change FINES to fines - Amel
		  .append("\n");
		
		for (loan loan : LNS.values()) { // change LoAn to loan - Amel
			sb.append(loan).append("\n"); // change LoAn to loan - Amel
		}		  
		return sb.toString();
	}

	
	public int getId() { // change GeT_ID to getId - Amel
		return id; // change ID to id - Amel
	}

	
	public List<loan> getLoans() { // change GeT_LoAnS to getLoans - Amel
		return new ArrayList<loan>(LNS.values());
	}

	
	public int numberOfCurrentLoans() { // change Number_Of_Current_Loans to numberOfCurrentLoans - Amel
		return LNS.size();
	}

	 
	public double finesOwEd() { // change Fines_OwEd to finesOwEd - Amel
		return fines; // change FINES to fines - Amel
	}

	
	public void takeOutLoan(loan loan) { // change Take_Out_Loan to takeOutLoan - Amel
		if (!LNS.containsKey(loan.ID())) {
			LNS.put(loan.ID(), loan);
		}
		else {
			throw new RuntimeException("Duplicate loan added to member");
		}		
	}

	
	public String getLastName() { // change Get_LastName to getLastName - Amel
		return ln; // change LN to ln - Amel
	}

	
	public String getFirstName() { // change Get_FirstName to getFirstName - Amel
		return fn; // change FN to fn - Amel
	}


	public void addFine(double fine) { // change Add_Fine to addFine - Amel
		fines += fine; // change FINES to fines - Amel
	}
	
	public double payFine(double amount) { // change payFine to payFine - Amel // change AmOuNt to amount - Amel
		if (amount < 0) { // change AmOuNt to amount - Amel
			throw new RuntimeException("Member.payFine: amount must be positive");
		}
		double change = 0;
		if (amount > fines) { // change AmOuNt to amount - Amel. // change FINES to fines - Amel
			change = amount - fines; // change AmOuNt to amount - Amel. // change FINES to fines - Amel
			fines = 0;  // change FINES to fines - Amel
		}
		else {
			fines -= amount;  // change FINES to fines - Amel. // change AmOuNt to amount - Amel.
		}
		return change;
	}


	public void dischargeLoan(loan LoAn) { // change dIsChArGeLoAn to dischargeLoan - Amel
		if (LNS.containsKey(loan.ID())) { // change LoAn to loan - Amel
			LNS.remove(loan.ID()); // change LoAn to loan - Amel
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}		
	}

}
