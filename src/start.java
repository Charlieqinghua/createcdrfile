import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import makeFile.CreateCdrFile;


public class start {

	/**
	 * @param args
	 */
	ExecutorService writerService;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		int writerNum=10;
		long rowid=0;
		ExecutorService	writerService = Executors.newFixedThreadPool(writerNum);
		for (int i = 0; i < writerNum; i++) {
			CreateCdrFile m=new CreateCdrFile();
			m.CreateCdr(""+i);
			//m.addObserver(o)
			writerService.submit(m);
		}
//		CreateCdrFile m1=new CreateCdrFile();
//		m1.CreateCdr("m1");
//		CreateCdrFile m2=new CreateCdrFile();
//		m2.CreateCdr("m2");
//		writerService.submit(m1);
//		writerService.submit(m2);
	}

}
