import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tst {

	public static void main(String[] args) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
		Date date = new Date();

		System.out.println(date);
	}

}

