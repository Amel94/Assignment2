import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	private static Calendar self; // change SeLf into self - nisal
	private static java.util.Calendar calendar; // change CaLeNdAr into calendar - nisal
	
	
	private Calendar() { 
		CaLeNdAr = java.util.Calendar.getInstance();
	}
	
	public static Calendar INSTANCE() {
		if (self == null) { // change SeLf into self - nisal
			self = new Calendar();  // change SeLf into self - nisal
		}
		return self; // change SeLf into self - nisal
	}
	
	public void incrementDate(int days) {
		calendar.add(java.util.Calendar.DATE, days);	 // change CaLeNdAr into calendar - nisal	
	}
	
	public synchronized void setDate(Date date) {  // change Set_dATE into setDate - nisal
		try {
			calendar.setTime(date); // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);   // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.MINUTE, 0);  // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.SECOND, 0);  // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.MILLISECOND, 0);// change CaLeNdAr into calendar - nisal
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public synchronized Date date() { // change Date into date - nisal
		try {
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);   // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.MINUTE, 0);  // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.SECOND, 0);  // change CaLeNdAr into calendar - nisal
	        calendar.set(java.util.Calendar.MILLISECOND, 0);// change CaLeNdAr into calendar - nisal
			return calendar.getTime(); // change CaLeNdAr into calendar - nisal
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	public synchronized Date dueDate(int loanPeriod) { // change Due_Date into dueDate - nisal
		Date now = Date();// change NoW into now - nisal
		calendar.add(java.util.Calendar.DATE, loanPeriod); // change CaLeNdAr into calendar - nisal
		Date dueDate = calendar.getTime(); // change DuEdAtE into dueDate - nisal  // change CaLeNdAr into calendar - nisal
		calendar.setTime(now); // change CaLeNdAr into calendar - nisal // change NoW into now - nisal
		return dueDate; // change DuEdAtE into dueDate - nisal
	}
	
	public synchronized long getDaysDifference(Date targetDate) {  // change Get_Days_Difference into getDaysDifference - nisal
		
		long diffMillis = Date().getTime() - targetDate.getTime(); // change Diff_Millis into diffMillis - nisal
	    long diffDays = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS); // change Diff_Days into diffDays - nisal
	    return diffDays; // change Diff_Days into diffDays - nisal
	}

}
