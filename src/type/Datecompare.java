package type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datecompare {
	static String timetype = "yyyy-MM-dd";
	
	public int compare(String date1,String date2) {
		int result=-2;
		SimpleDateFormat format = new SimpleDateFormat(timetype);
		try {
			Date before=format.parse(date1);
			Date after=format.parse(date2);
			
			result=after.compareTo(before);
		} catch (ParseException e) {
			// TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
			e.printStackTrace();
		}
		return result;
	}
}
