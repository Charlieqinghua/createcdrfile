package unicom.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tools.factory.Factory;
import unicom.RecordTime;
import unicom.start.generateCdrThread;
/*
 *  自动生成模拟文件的配置
 * 读取配置文件的信息
 *  @param inputdir=null; 输入文件夹
	@param outputdir=null;输出文件夹
	@param movedir=null;  文件移动之后的文件夹
	@param threadnum=null; 线程个数
	@param fieldsize=null; 
	@param threadbean=null;当前线程要执行的线程
 * **/
public class ConfigurationTwoThread {
	String inputdir=null;
	String outputdir=null;
	String movedir=null;
	String writethreadnum=null;
	String readthreadnum=null;
	String fieldsize=null;
	String producerthreadbean=null;
	String consumerthreadbean=null;
	String os=null;
	String blocksize=null;
	String queuemax=null;
	String delay=null;
	String url=null;
	String username=null;
	String password=null;
	String classname=null;
	String log=null;
	public void readConfiguration(String []args)
	{
		if (args.length == 0) 
		{
			System.out.println("no configue file");
		}
		else
		{
			InputStream in=null;
			ResourceBundle rb=null;
			try {
				in = new BufferedInputStream(new FileInputStream(args[0]));
				if(in==null)
				{
					in=generateCdrThread.class.getResourceAsStream("/"+args[0]);
				}
				
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				in=generateCdrThread.class.getResourceAsStream("/"+args[0]);
				
			}
			try {
				rb = new PropertyResourceBundle(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inputdir = rb.getString("inputdir");
			outputdir = rb.getString("outputdir");
			readthreadnum=rb.getString("readthreadnum");
			writethreadnum=rb.getString("writethreadnum");
			movedir=rb.getString("movedir");
			fieldsize=rb.getString("fieldsize");
			producerthreadbean=rb.getString("producerthreadbean");
			consumerthreadbean=rb.getString("consumerthreadbean");
			os=rb.getString("os");
			blocksize=rb.getString("blocksize");
			queuemax=rb.getString("queuemax");
			delay=rb.getString("delay");
			log=rb.getString("log");
			url=rb.getString("url");
			username=rb.getString("username");
			password=rb.getString("password");
			classname=rb.getString("classname");
			if(os.equals("linux"))
			{
				DicTion.changeline=DicTion.linuxline;
			}
			else
			{
				DicTion.changeline=DicTion.windowline;
			}
			System.out.println("out"+outputdir+" "+"input"+" "+inputdir+" "+readthreadnum+" "+writethreadnum);
		}
	
		DicTion.movedir=new Dir(movedir);//初始化reading之后移动的目录
		DicTion.movedirstr=movedir;//设置要移动的文件路径
		DicTion.outdir=outputdir;
		DicTion.fieldsize=Integer.parseInt(fieldsize);//输出的列数
		DicTion.blocksize=Integer.parseInt(blocksize);//每个bean数组 有多少行
		DicTion.queuemax=Integer.parseInt(queuemax);//阻塞队列的大小
		DicTion.log=log;
		DicTion.url=url;//jdbc 连接 url
		DicTion.username=username;
		DicTion.password=password;
		DicTion.classname=classname;
		int readnum=Integer.parseInt(readthreadnum);
		int writenum=Integer.parseInt(writethreadnum);
		ExecutorService readServiceExecutors=Executors.newFixedThreadPool(readnum);
		//用来写时间日志的
		final RecordTime rt=new RecordTime(log);
		rt.recordNowTime();
		for(int i=0;i<readnum;i++)
		{
			
			Thread onethread=(Thread)Factory.createObject(producerthreadbean);
			readServiceExecutors.submit(onethread);
			
		}
		ExecutorService writeServiceExecutors=Executors.newFixedThreadPool(writenum);
		for(int i=0;i<writenum;i++)
		{
			
			Thread onethread=(Thread)Factory.createObject(consumerthreadbean);
			writeServiceExecutors.submit(onethread);
			
		}
		ExecutorService exitServiceExecutors=Executors.newFixedThreadPool(1);
		final long timedelay=Long.parseLong(delay);
		Thread timerThread=new Thread()
		{
			public void run()
			{
				TimerTask task=new TimerTask()
				{
					public void run()
					{
						synchronized(rt)
						{
							rt.recordNowTime();//退出时记录时间
						}
						System.out.println("end");
						System.exit(0);
					}
				};
				Timer timer=new Timer();
				timer.schedule(task, timedelay*60*1000);
			}
		};
		exitServiceExecutors.submit(timerThread);
		
		
	}
	

}
