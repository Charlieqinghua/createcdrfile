package unicom.thread;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;

import unicom.database.BeanPackage;
import unicom.database.BillingBean;
import unicom.queue.MyBlockingQueue;
import unicom.tools.DicTion;



/**
 * 类 producerBeanThread 往阻塞队列中放置产品
 * 
 * @param blockmax 是 每个bean数组的大小
 * @param beanpackage 是用来生成模拟数据
 * @param BlockingQueue 是阻塞队列
 *  */
public class producerBeanThread extends Thread 
{	
	public static BlockingQueue<BillingBean[]> queque=MyBlockingQueue.queque;
	BeanPackage beanpackage=new BeanPackage();
	static int blockmax=DicTion.blocksize;
	public producerBeanThread() 
	{
		super();
	}
	/*
	 * 往队列中放置 产品
	 * */
	public void putQueque() 
	{
		BillingBean beanblock[]=beanpackage.geneateAmoutBillingBean(blockmax);
		try {
			queque.put(beanblock);//放置一个 beanblock;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("reading thread id is " + this.getId() + "fname+");

	}

	public void run() 
	{
		//System.out.println("thread id is "+this.getId()+"reading file");
		while (true) 
		{
			putQueque();			
		}
			
		
	}

	public static void main(String args[]) {
		long before = System.currentTimeMillis();
		String path = "E:\\SMSCDR_20130901\\SMSCDR_20130901\\";
		producerBeanThread dir = new producerBeanThread();
		dir.start();
		
	}

}
