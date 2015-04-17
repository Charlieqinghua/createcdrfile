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




/**
 *   模拟生成 cdr话单的启动类
 * 
 * **/

public class generateCdrThread {

	/**
	 * @param args
	 * @param inputdir 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubInputStream in = new BufferedInputStream(new FileInputStream(path));
		Configuration config=new Configuration();
		config.readConfiguration(args);
		
	}

}
