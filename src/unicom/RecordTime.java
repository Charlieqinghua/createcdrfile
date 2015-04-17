package unicom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * 完成时间记录的功能
 * 构造函数是输入日志的存放路径
 * **/

public class RecordTime {

	/**
	 * @param recordtime 当前的时间
	 * @param log 写日志 
	 */
	SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhh24mmss",Locale.CHINESE);;
	long recordtime; 
	CFile log;
	//StringBuffer sbtime=new StringBuffer();
	public RecordTime(String path) {
		super();
		log=new CFile(path);
		
	}
	public void recordNowTime()
	{
		Date nowtime=new Date();
		recordtime=nowtime.getTime();
		String st=df.format(nowtime);
		try {
			log.writeRow(st+","+String.format("%d", this.recordtime));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RecordTime rt=new RecordTime("d:\\test.txt");
		rt.recordNowTime();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rt.recordNowTime();
		//System.out.println(st);

	}

}
