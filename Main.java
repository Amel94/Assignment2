import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Main {
	
	private static Scanner in;// variable name changes IN to in
	private static library library;  // variable name changes LIB to library
	private static String menu; // variable name changes MENU to menu
	private static Calendar calender; // variable name changes CAL to calender
	private static SimpleDateFormat sdf; // variable name changes SDF to sdf
	
	
	private static String getMenu() { // method name changes Get_menu to getMenu()
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
			library = library.INSTANCE(); // variable name changes LIB to library
			calender = calendar.INSTANCE(); // variable name changes CAL, Calender to calender
			sdf = new SimpleDateFormat("dd/MM/yyyy"); // variable name changes SDF to sdf
	
			for (member m : library.getMembers()) { // variable name changes LIB to lib and method name MEMBERS to getMembers()
				output(m);
			}
			output(" ");
			for (book b : lib.outputBook()) { // variable name changes LIB to lib , method name BOOKS to outputBook()
				output(b);
			}
						
			menu = getMenu();  // variable name changes MENU to menu and method name Get_Menu() to getMenu()
			
			boolean e = false;
			
			while (!e) {
				
				output("\n" + sdf.format(cal.date())); // variable name changes SDF to sdf , CAL to cal and method Date to date()
				String c = input(menu); // variable name changes MENU to menu
				
				switch (c.toUpperCase()) {
				
				case "M": 
					addMember(); // method name changes ADD_MEMBER to addMember()
					break;
					
				case "LM": 
					getMember(); // method name changes MEMBERS to getMember()
					break;
					
				case "B": 
					addBook();// method name changes ADD_BOOK to addBook()
					break;
					
				case "LB": 
					outputBook();// method name changes BOOKS to outputBook()
					break;
					
				case "FB": 
					fixBooks();// method name changes FIX_BOOKS to fixBooks()
					break;
					
				case "L": 
					borrowBook();// method name changes BORROW_BOOK to borrowBook()
					break;
					
				case "R": 
					returnBook(); // method name changes RETURN_BOOK to returnBook()
					break;
					
				case "LL": 
					currentLoan();//  method name changes CURRENT_LOANS to currentLoan()
					break;
					
				case "P": 
					fines(); // method name changes FINES to fines
					break;
					
				case "T": 
					incrementDate(); // method name chenage INCREMENT_DATE() to incrementDate()
					break;
					
				case "Q": 
					e = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				library.save(); // method name changes SAVE() to save()
			}			
		} catch (RuntimeException e) {
			output(e);
		}		
		output("\nEnded\n");
	}	

	
	private static void fines() { // method name chenages Fines() to fines()
		new PayFineUI(new payFineControl()).run(); // method name changes RuN() to run() , PayFineControl to payFineControl()
	}


	private static void currentLoan() { // method name changes CURRENT_LOANS to currentLoan()
		output("");
		for (loan loan : library.currentLoan()) {// method name changes CURRENT_LOANS to currentLoan() , variable name LIB to library
			output(loan + "\n");
		}		
	}



	private static void outputBook() {// method name changes BOOKS to outputBook()
		output("");
		for (book book : library.outputBook()) { // method name changes BOOKS to outputBook()
			output(book + "\n");
		}		
	}



	private static void getMember() {// method name changes MEMBERS to getMember()
		output("");
		for (member member : library.getMember()) {// variable name LIB to library and MEMBER to getMember()
			output(member + "\n");
		}		
	}



	private static void borrow() { // method name BORROW_BOOK to borrowBook()
		new BorrowBookUI(new borrowBookControl()()).run();	// method changes BorrowBookControl to borrowBookControl()	
	}


	private static void returnBook() { // method changes RETURN_BOOK to returnBook()
		new ReturnBookUI(new returnBookControl()).run();	// method name change ReturnBookControl() to returnBookControl(),RuN to run()
	}


	private static void fixBook() { // method name change FIX_BOOKS to fixBook()
		new FixBookUI(new fixBookControl()).run();	// method name FixBookControl changes to fixBookControl	,RuN to run()
	}


	private static void incrementDate() { // method name change INCREMENT_DATE to incrementDate
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			calculator.incrementDate(days); // variable name changes CAL to calculator
			library.checkCurrentLoans(); // variable name changes LIB to library
			output(sdf.format(cal.date())); // variable name changes SDF to sdf , CAL to cal , method changes Date() to date()
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	private static void addBook() { // method name changes ADD_BOOK to addBook()
		
		String author = input("Enter author: "); // varaible change A to author
		String title = input("Enter title: "); // variable changes T to title
		String callNumber = input("Enter call number: "); // variable name change C to callNumber
		book B = lib.addBook(author, title, callNumber); //variable  LIB changes to library,A to author,T to title,C to callNumber , method changes Add_book to addBook()
		output("\n" + B + "\n");
		
	}

	
	private static void addMember() { // method name changes ADD_MEMBER to addMember()
		try {
			String lastName = input("Enter last name: "); // variable name changes LN to lastName
			String firstName  = input("Enter first name: "); // variable name changes FN to firstName
			String email = input("Enter email: "); // varible name changes EM to email
			int phoneNumber = Integer.valueOf(input("Enter phone number: ")).intValue(); // variable name changes PN to phoneNumber
			member M = library.Add_mem( lastName, firstName, email, phoneNumber); // variable name changes LIB library , LN to lastName, FN to firstName,EM to email
			output("\n" + M + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return in.nextLine();// variable IN changes to in
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
