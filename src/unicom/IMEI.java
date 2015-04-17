package unicom;

import java.util.Random;

public class IMEI {

	/**
	 * @param args
	 */
	
	Random r=new Random();
	int randnum=6;//后面几位随机产生的
	static StringBuffer []preIMEI={new StringBuffer("355224"),new StringBuffer("860705"),new StringBuffer("864653"),new StringBuffer("865761"),new StringBuffer("359538"),new StringBuffer("353405")};
	public StringBuffer generateIMEI()
	{
		StringBuffer sb=new StringBuffer();
		int iprepos=getPremobileRandom(randnum);
		StringBuffer pre=preIMEI[iprepos];
		sb=sb.append(pre);
		sb.append(everyRandom(9, 10));
		return sb;
		
	}
	/*
	 * 
	 * 返回  premobile中的一个随机数组位置 0-5;
	 * 0为 186,1-185,2-132,3-131
	 * max=6;
	*/
	public int getPremobileRandom(int max)
	{
		
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
			int ai=r.nextInt(n);
			prnum.append(ai);
		}
		return prnum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMEI mobile=new IMEI();
		for(int i=0; i<1000; i++)
		{
		
			mobile.generateIMEI();
			System.out.println(mobile.generateIMEI().toString());
		
		}

	}

}
