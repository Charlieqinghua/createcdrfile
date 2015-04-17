package unicom;

import java.util.Random;

public class IMSI {

	/**
	 * @param args
	 */
	
	Random r=new Random();
	int randnum=6;//后面几位随机产生的
	static StringBuffer []preIMSI={new StringBuffer("4600105"),new StringBuffer("4600173"),new StringBuffer("4600119"),new StringBuffer("4600111"),new StringBuffer("4600149"),new StringBuffer("4600166")};
	public StringBuffer generateIMSI()
	{
		StringBuffer sb=new StringBuffer();
		int iprepos=getPremobileRandom(randnum);
		StringBuffer pre=preIMSI[iprepos];
		sb=sb.append(pre);
		sb.append(everyRandom(8, 10));
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
		IMSI mobile=new IMSI();
		for(int i=0; i<1000; i++)
		{
		
			mobile.generateIMSI();
			System.out.println(mobile.generateIMSI().toString());
		
		}

	}

}
