package makeFile;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class make {
	long rowid=0;
	public String makeRow(){
		
			Byte b[]=new Byte[16];
			rowid++;
			Date  da=new Date();
			Timestamp time=new Timestamp(da.getTime());
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh24:mm:ss.SSSSSSS");
			String st=df.format(time).toString();
			//String st=time.;
			Random ai=new Random(7);
			String mobile="186"+mRadom(8,10);
			String lac=mRadom(5,10);
			String cell=mRadom(5,10);
			String imei=mRadom(15,10);
			String flow_type=mRadom(3,10);
			String start_time=st;
			
			String duration="1";
			String upload="164";
			String download="156";
			String total_byte="320";
			String rat_type="1";
			String ip="10"+"."+mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9);
			String access_ip=mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9);
			String status="0";
			String user_agent="0";
			String apn="3gnet";
			String imsi="46001"+mRadom(10,9);
			String sgsn_ip="220"+"."+mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9);
			String ggsn_ip="220"+"."+mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9);
			String content_type="application/json;charset=utf-8";
			String source_port="49"+mRadom(3,9);
			String dest_port="80";
			String record_type="0";
			long  flag=Thread.currentThread().getId();
			long a[]={rowid,flag};
			//System.arraycopy( a, b.length, b, 0, b.length);
			//System.out.println(b);
			String url="http://"+mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9)+"."+mRadom(2,9)+"/stat.m.360.cn/index.php?para=QWN0aW9uPWxvZyZJbWVpPTM1NjM4MTA0MTY4MDM2OCZVaVZlcnNpb249MTAwJk15VmVyc2lvbj0zLjUuMiZEYXRhPSU4MDEwLDElODAwMSw2JTgwMDIsMTUlODkwMSwxJTgwMDYsMSU4MDA3LDElODAxMiwxJTgwMTMsMzk5JTgwMTQsMSU4MDE3LDElODAyMywxJTgwMjgsMSUxMTAwMSwxJTExMDAyLDElMTEwMDMsMSUxMzAwMCwxJTgwMzEsMSU4ODA0LDElMTEwMTAsMQ=="+flag;
			Date dt=new Date();
			String end_time=df.format(dt).toString();
			
			return mobile+"|"+lac+"|"+cell+"|"+imei+"|"+flow_type+"|"+start_time+"|"+end_time+"|"+duration+"|"+upload+"|"+download+"|"+total_byte+"|"+rat_type+"|"+ip+"|"+access_ip+"|"+status+"|"+user_agent+"|"+apn+"|"+imsi+"|"+sgsn_ip+"|"+ggsn_ip+"|"+content_type+"|"+source_port+"|"+dest_port+"|"+record_type+"|"+url+"\r\n";
		//,"record","9910|33243|"+ds+"|4053160tsc|3519700559774402|201|011658163027950|3865|19388|2|"+i);
		
	}
	public String mRadom(int sum, int n)
	{
		String prnum="";
		for(int i=0;i<sum;i++)
		{
			Random r=new Random();
			int ai=r.nextInt(n);
			prnum+=ai;
		}
		return prnum;
	}

}
