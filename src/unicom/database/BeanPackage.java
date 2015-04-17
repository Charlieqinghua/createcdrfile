package unicom.database;

import unicom.BillingCDR;
import unicom.CFile;
import unicom.TimeField;
import unicom.tools.DicTion;

public class BeanPackage {

	/**
	 * @param args
	 */
	BillingCDR bill=new BillingCDR();
	String fname;
	TimeField time=new TimeField();
	BillingBean billbean;//一行

	/*
	 * 
	 * 每次产生一个 BillBean
	 * */
	public BillingBean  generateBillingBean()
	{
		
		billbean=bill.generateBillingBean();
		return billbean;
	}
	/*
	 * 批量产生 BillBean 
	 * 每次产生 max 个 Billbean
	 * 
	 * */
	public BillingBean[] geneateAmoutBillingBean(int max)
	{
		BillingBean billingpacke[]=new BillingBean[max];
		fname=time.generateTime().toString();
		for(int i=0; i<max ; i++)
		{
			billingpacke[i]=bill.generateBillingBean();
		}
		return billingpacke;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
