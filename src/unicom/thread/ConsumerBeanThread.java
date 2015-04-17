package unicom.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import unicom.database.BillingBean;
import unicom.database.BillingService;
import unicom.queue.MyBlockingQueue;

public class ConsumerBeanThread extends Thread {

	/**
	 * @param args
	 */
	public static BlockingQueue<BillingBean[]> queque=MyBlockingQueue.queque;
	BillingBean beanblock[];//每次取出一个块
	BillingService billingservice=new BillingService();
	static Object object=new Object();
	public ConsumerBeanThread() {
		super();
		//billingservice.initConnect();
	}
	public void run()
	{
		billingservice.initConnect();
		try {
			while(true)
			{
				try {
					beanblock=queque.poll(20, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				insertIntoDataBase();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			billingservice.closeConnect();
		}
	}
	public void insertIntoDataBase()
	{
		if(beanblock!=null)
			
		{
//			synchronized(object)
//			{
//			
//				billingservice.insertIntoDataBase(beanblock);
//			}
			billingservice.insertIntoDataBase(beanblock);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
