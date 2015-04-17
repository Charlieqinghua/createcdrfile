package unicom.start;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tools.factory.Factory;
import unicom.tools.Configuration;
import unicom.tools.ConfigurationTwoThread;




/**
 *   多线程批量插入数据库的启动类
 * 
 * **/

public class insertIntoDateBaseThread {

	/**
	 * @param args
	 * @param inputdir 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubInputStream in = new BufferedInputStream(new FileInputStream(path));
		ConfigurationTwoThread config=new ConfigurationTwoThread();
		config.readConfiguration(args);
		System.out.println("main thread");
		
	}

}
