import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.StringTokenizer;
public class Splitlee {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String month = "2021-03-01";
//		LocalDate cd = LocalDate.parse(month);
//		Month m = cd.getMonth();
//		System.out.println(m);
		StringTokenizer str = new StringTokenizer(month, "-"); 
		int y=0;
		int d=0;
		int m=0;
		while(str.hasMoreElements()) {
			y = Integer.parseInt(str.nextToken());
			m = Integer.parseInt(str.nextToken());
			d = Integer.parseInt(str.nextToken());
		}
		System.out.println(y);
		System.out.println(d);
		System.out.println(m);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(now.getMonthValue());  
	}

}
