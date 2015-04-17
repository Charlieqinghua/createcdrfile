package unicom;

import java.util.Random;

public class Ci {

	/**
	 * @param args
	 *  Ci 共有 1168,28267  zai 第6位
	 */
	static int[]total={4,5};
	public StringBuffer generateCi()
	{
		StringBuffer sb=new StringBuffer();
		int iprepos=getPreLacRandom(2);
		int pre=total[iprepos];
		
		sb.append(everyRandom(pre, 10));
		return sb;
		
	}
	/*
	 * int arrpos=r.nextInt(2);
	 *   生成的是  0,1
	 * 
	 * **/
	public int getPreLacRandom(int max)
	{
		Random r=new Random();
		int arrpos=r.nextInt(max);
		return arrpos;
	}
	
	/*
	 *   @param sum 位数 
	 *   @param n   0-n 每个数的位数
	 * */
	public StringBuffer everyRandom(int sum, int n)
	{
		StringBuffer prnum=new StringBuffer();
		for(int i=0;i<sum;i++)
		{
			Random r=new Random();
			int ai=r.nextInt(n);
			prnum.append(ai);
		}
		return prnum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ci ci=new Ci();
		for(int i=0; i<1000; i++)
		{
			System.out.println(ci.generateCi());
		}
	}

}
