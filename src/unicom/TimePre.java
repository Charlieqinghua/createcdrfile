package unicom;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimePre {
	/**
	 * @param args
	 *            20150323214332 产生字段 5
	 */
	SimpleDateFormat df = new SimpleDateFormat("yyMMdd", Locale.CHINESE);
	public StringBuffer generateTime() {
		StringBuffer sb = new StringBuffer();
		Date da = new Date();
		String st = df.format(da.getTime()).toString();
		sb.append(st);
		return sb;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimePre time = new TimePre();
		System.out.println(time.generateTime());

	}

}
