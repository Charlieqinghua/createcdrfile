package makeFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class createFile {
	 File f;
	 BufferedWriter output;
	
	public boolean makefile(String fName) throws IOException
	{
		 f = new File(fName);
	  
	   
	   if(f.exists())
	   {
	   // System.out.print("文件存在");
	    return false;
	   }
	   else
	   {
	   // System.out.print("文件不存在");
	    f.createNewFile();//不存在则创建
	    return true;
	   }
	  
	   
	 }
	public void inputRow(String row) throws Throwable
	{  
		output= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
	   output.write(row);
	   output.close();
	 } 
	 

	

}
