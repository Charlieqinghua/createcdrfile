package unicom;

public class ShutdownBean {

	/**
	 * @param args
	 */
	RecordTime rt=new RecordTime("d:\\test1.txt");
	
	public void excuteShutDown() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				// 添入你想在退出JVM之前要处理的必要操作代码
				System.out.println("T1");
				rt.recordNowTime();
			}
		});

		//System.exit(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShutdownBean shutdown=new ShutdownBean();
		shutdown.excuteShutDown();
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
