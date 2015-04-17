package unicom;

import java.util.Random;

public class Type {

	/**
	 * @param args
	 */
	Random r=new Random();
	static StringBuffer typestr[]={new StringBuffer("00"),new StringBuffer("01")};
	public StringBuffer generateType()
	{
		StringBuffer sb=new StringBuffer();
		int iprepos=getRandom(2);
		StringBuffer pre=typestr[iprepos];
		sb.append(pre);
		return sb;
		
	}
	public int getRandom(int max)
	{
		
		int arrpos=r.nextInt(max);
		return arrpos;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Type type=new Type();
		for(int i=0; i<1000; i++)
		{
			System.out.println(type.generateType());
		}
	}

}
