package unicom.thread;

import java.io.IOException;
/**
 * @param bill 生成话单的对象
 * @param cf  生成的文件
 * @param fname 要生成的文件名
 * @param contsb 要生成的文件内容
 * @param maxrow 每个文件的行数
 * @param 输出文件的目录
 * 
 */

import unicom.BillingCDR;
import unicom.CFile;
import unicom.TimeField;
import unicom.tools.DicTion;
/*
 * 生成  模拟文件的线程
 * 
 * */
public class BillingThread extends Thread {

	
	BillingCDR bill=new BillingCDR();
	CFile cf;
	String fname;
	TimeField time=new TimeField();
	StringBuffer contsb;
	int maxrow=DicTion.fieldsize; 
	String dir=DicTion.outdir;
	
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public void run()
	{
		//int i=1000;
		while(true)
		{
			fname=time.generateTime().toString()+"_"+this.getId();
			contsb=bill.generateAmountBillingCDR(maxrow);
			cf=new CFile(dir+fname);
			cf.writeCSVChannel(contsb);
			//i--;
		
			//cf.writeCSVChannel(contsb);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BillingThread thread=new BillingThread();
		thread.start();
	}

}
