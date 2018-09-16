import java.text.DateFormat;
import java.util.Calendar;

public class ManipulacaoDatas {
	
	
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		
		DateFormat[] df = new DateFormat[6];
		df[0] = DateFormat.getInstance();
		df[1] = DateFormat.getDateInstance();
		df[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		df[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		df[4] = DateFormat.getDateInstance(DateFormat.LONG);
		df[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		for (DateFormat dateFormat : df) {
			System.out.println(dateFormat.format(c.getTime()));
		}
		
		
		System.out.println(c.getTime());
	}

}
