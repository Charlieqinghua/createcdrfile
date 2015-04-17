package unicom.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tools.factory.Factory;
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
public class Configuration {
	String inputdir=null;
	String outputdir=null;
	String movedir=null;
	String threadnum=null;
	String fieldsize=null;
	String threadbean=null;
	String os=null;
	String blocksize=null;
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
					in=generateCdrThread.class.getResourceAsStream("/"+"config.properties");
				}
				
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				in=generateCdrThread.class.getResourceAsStream("/config.properties");
				
			}
			try {
				rb = new PropertyResourceBundle(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inputdir = rb.getString("inputdir");
			outputdir = rb.getString("outputdir");
			threadnum=rb.getString("threadnum");
			movedir=rb.getString("movedir");
			fieldsize=rb.getString("fieldsize");
			threadbean=rb.getString("threadbean");
			os=rb.getString("os");
			blocksize=rb.getString(blocksize);
			if(os.equals("linux"))
			{
				DicTion.changeline=DicTion.linuxline;
			}
			else
			{
				DicTion.changeline=DicTion.windowline;
			}
			System.out.println("out"+outputdir+" "+"input"+" "+inputdir+" "+threadnum);
		}
	
		DicTion.movedir=new Dir(movedir);//初始化reading之后移动的目录
		DicTion.movedirstr=movedir;//设置要移动的文件路径
		DicTion.outdir=outputdir;
		DicTion.fieldsize=Integer.parseInt(fieldsize);//输出的列数
		DicTion.blocksize=Integer.parseInt(blocksize);//输出的列数
				
		int writethreadnum=Integer.parseInt(threadnum);
		ExecutorService ServiceExecutors=Executors.newFixedThreadPool(writethreadnum);
		for(int i=0;i<writethreadnum;i++)
		{
			
			Thread onethread=(Thread)Factory.createObject(threadbean);
			ServiceExecutors.submit(onethread);
			//onethread.start();
		}
	}


}
