import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Main {
	
	private static Scanner in;// variable name changes IN to in
	private static library lib;  // variable name changes LIB to lib
	private static String menu; // variable name changes MENU to menu
	private static Calendar cal; // variable name changes CAL to cal
	private static SimpleDateFormat sdf; // variable name changes SDF to sdf
	
	
	private static String Get_menu() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nLibrary Main Menu\n\n")
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		  
		return sb.toString();
	}


	public static void main(String[] args) {		
		try {			
			in = new Scanner(System.in); // variable name changes IN to in
			lib = library.INSTANCE(); // variable name changes LIB to lib
			cal = Calendar.INSTANCE(); // variable name changes CAL to cal
			sdf = new SimpleDateFormat("dd/MM/yyyy"); // variable name changes SDF to sdf
	
			for (member m : lib.MEMBERS()) { // variable name changes LIB to lib
				output(m);
			}
			output(" ");
			for (book b : lib.BOOKS()) { // variable name changes LIB to lib
				output(b);
			}
						
			menu = Get_menu();  // variable name changes MENU to menu
			
			boolean e = false;
			
			while (!e) {
				
				output("\n" + sdf.format(CAL.Date())); // variable name changes SDF to sdf
				String c = input(menu); // variable name changes MENU to menu
				
				switch (c.toUpperCase()) {
				
				case "M": 
					ADD_MEMBER();
					break;
					
				case "LM": 
					MEMBERS();
					break;
					
				case "B": 
					ADD_BOOK();
					break;
					
				case "LB": 
					BOOKS();
					break;
					
				case "FB": 
					FIX_BOOKS();
					break;
					
				case "L": 
					BORROW_BOOK();
					break;
					
				case "R": 
					RETURN_BOOK();
					break;
					
				case "LL": 
					CURRENT_LOANS();
					break;
					
				case "P": 
					FINES();
					break;
					
				case "T": 
					INCREMENT_DATE();
					break;
					
				case "Q": 
					e = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				library.SAVE();
			}			
		} catch (RuntimeException e) {
			output(e);
		}		
		output("\nEnded\n");
	}	

	
	private static void FINES() {
		new PayFineUI(new PayFineControl()).RuN();		
	}


	private static void CURRENT_LOANS() {
		output("");
		for (loan loan : LIB.CurrentLoans()) {
			output(loan + "\n");
		}		
	}



	private static void BOOKS() {
		output("");
		for (book book : LIB.BOOKS()) {
			output(book + "\n");
		}		
	}



	private static void MEMBERS() {
		output("");
		for (member member : LIB.MEMBERS()) {
			output(member + "\n");
		}		
	}



	private static void BORROW_BOOK() {
		new BorrowBookUI(new BorrowBookControl()).run();		
	}


	private static void RETURN_BOOK() {
		new ReturnBookUI(new ReturnBookControl()).RuN();		
	}


	private static void FIX_BOOKS() {
		new FixBookUI(new FixBookControl()).RuN();		
	}


	private static void INCREMENT_DATE() {
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			CAL.incrementDate(days);
			LIB.checkCurrentLoans();
			output(SDF.format(CAL.Date()));
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	private static void ADD_BOOK() {
		
		String A = input("Enter author: ");
		String T  = input("Enter title: ");
		String C = input("Enter call number: ");
		book B = LIB.Add_book(A, T, C);
		output("\n" + B + "\n");
		
	}

	
	private static void ADD_MEMBER() {
		try {
			String LN = input("Enter last name: ");
			String FN  = input("Enter first name: ");
			String EM = input("Enter email: ");
			int PN = Integer.valueOf(input("Enter phone number: ")).intValue();
			member M = LIB.Add_mem(LN, FN, EM, PN);
			output("\n" + M + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return IN.nextLine();
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
