package unicom;

import java.util.Random;

public class Lac {

	/**
	 * @param args
	 */
	static StringBuffer []prelac={new StringBuffer("118"),new StringBuffer("272"),new StringBuffer("139"),new StringBuffer("203"),new StringBuffer("154"),new StringBuffer("140"),new StringBuffer("218")};
	int randnum=6;//后面几位随机产生的
	public StringBuffer generateLac()
	{
		StringBuffer sb=new StringBuffer();
		int iprepos=getPremobileRandom(randnum);
		StringBuffer pre=prelac[iprepos];
		sb=sb.append(pre);
		sb.append(everyRandom(2, 10));
		return sb;
		
	}
	/*
	 * 
	 * 返回  premobile中的一个随机数组位置 0-5;
	 * 0为 186,1-185,2-132,3-131
	 * max=5;
	*/
	public int getPremobileRandom(int max)
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
		Lac lac=new Lac();
		for(int i=0; i<1000; i++)
		{
			System.out.println(lac.generateLac());
		}
	}

}
