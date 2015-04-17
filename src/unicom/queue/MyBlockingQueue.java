package unicom.queue;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import unicom.database.BeanPackage;
import unicom.database.BillingBean;
import unicom.tools.DicTion;

public class MyBlockingQueue {

	/**
	 * @param args
	 * 全局的阻塞队列对象
	 */
	static int queuemax=DicTion.queuemax;//阻塞队列中的最大数
	public static BlockingQueue<BillingBean[]> queque=new LinkedBlockingQueue(queuemax) ;;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
