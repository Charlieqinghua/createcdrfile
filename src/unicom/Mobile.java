package unicom;

import java.util.Random;

public class Mobile {

	/**
	 * @param args
	 */
	//StringBuffer mobile;
	Random r=new Random();
	int randpre=6;//后面几位随机产生的
	static StringBuffer []premobile={new StringBuffer("186"),new StringBuffer("185"),new StringBuffer("132"),new StringBuffer("131"),new StringBuffer("156"),new StringBuffer("155")};
	public StringBuffer generateMobile()
	{
		StringBuffer sb=new StringBuffer();
		int iprepos=getPremobileRandom(randpre);
		StringBuffer pre=premobile[iprepos];
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
		Mobile mobile=new Mobile();
		for(int i=0; i<1000; i++)
		{
		
			mobile.generateMobile();
			System.out.println(mobile.generateMobile().toString());
		
		}

	}

}
