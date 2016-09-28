package in.diszhappy.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date tDate = format.parse("01/01/1999"); 
		System.out.println(tDate);
		System.out.println();
		System.out.println(tDate.getTime());
	}
}
