package unicom.tools;

public class DicTion {
	public static String movedirstr="";//需要移动到的目录；
		public static String outdir=null;//解码生成的decode文件的目录；
		public static Dir movedir=null;
		public static int fieldsize=0;//多线生成的文件行数
		public static String changeline="\n";
		public static String linuxline="\n";
		public static String windowline="\r\n";
		public static int blocksize=0;//放入的bean对象块大小
		public static int queuemax=100;//阻塞队列的大小
		public static String log="/home/wwh/log.txt";
		public static String url="jdbc:t4jdbc://192.168.0.21:37800/:";
		public static String username="trafodion";
		public static String password = "trafodion";
		public static String classname="org.trafodion.jdbc.t4.T4Driver";
}

