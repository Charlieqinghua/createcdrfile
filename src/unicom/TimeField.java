package unicom;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TimeField {

	/**
	 * @param args
	 * 20150323214332
	 * 产生字段  5
	 */
	
	SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhh24mm",Locale.CHINESE);;
	static int diffmax=1000000;
	int seed=10000;
	Random r=new Random(seed);	
	
	public StringBuffer generateTime()
	{
		StringBuffer sb=new StringBuffer();
		Date  da=new Date();
	  	String st=df.format(da).toString();
		sb.append(st);
		return sb;
		
	}
	public StringBuffer generateDiffTime()
	{
		StringBuffer sb=new StringBuffer();
		Date  da=new Date();
		long ltime=da.getTime();
		int diff=this.getTimeDiffRandom(diffmax);
		ltime-=diff;
		Date dadiff=new Date(ltime);	    
		String st=df.format(dadiff).toString();
		sb.append(st);
		return sb;
		
	}
	/**
	 * 随机取得一个时间差值 diff 范围在 0-10000之间
	 * */
	public int getTimeDiffRandom(int max)
	{
		int arrpos=r.nextInt(max);
		return arrpos;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeField time=new TimeField();
		for(int i=0; i<1000;i++)
		{
		
			System.out.println(time.generateDiffTime());
			System.out.println(time.generateTime());
		}

	}

}
