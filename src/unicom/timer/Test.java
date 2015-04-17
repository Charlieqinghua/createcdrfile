package unicom.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.Timer; 

public class Test {

	/**
	 * @param args
	 * 
	 */
	long after=10000;
	public static Timer time=new Timer();
	/*
	 * minute 代表间隔几分钟开始执行
	 * */
	public static void start(TimerTask task, String minute) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.CHINA);
	    long   period=Long.parseLong(minute)*60*1000;// 
        time.schedule(task,   1000,   period);
		
		
	}
	public static void main(String args[])
	{
		Task task=new Task();
		Test.start(task, "1");
	}
}
