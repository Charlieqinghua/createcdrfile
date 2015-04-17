package unicom;

import unicom.database.BillingBean;
import unicom.tools.DicTion;

public class BillingCDR {

	/**
	 * @param args
	 *  生成模拟的BillCDR 话单
	 */
	TimePre time=new TimePre();
	Type type=new Type();
	Mobile callmobile=new Mobile();
	Mobile calledmobile=new Mobile();
	TimeField timein=new TimeField();
	TimeField timeout=new TimeField();
	Ci ci=new Ci();
	Lac lac=new Lac();
	IMSI imsi=new IMSI();
	IMEI imei=new IMEI();
	/*
	 * 生成单独一行cdr
	 * */
	public StringBuffer generateBillingCDR()
	{
		StringBuffer billing=new StringBuffer();
		billing.append(time.generateTime());
		billing.append(",");
		billing.append(type.generateType());
		billing.append(",");
		billing.append(callmobile.generateMobile());
		billing.append(",");
		billing.append(calledmobile.generateMobile());
		billing.append(",");
		billing.append(timein.generateTime());
		billing.append(",");
		billing.append(timeout.generateDiffTime());
		billing.append(",");
		billing.append(ci.generateCi());
		billing.append(",");
		billing.append(lac.generateLac());
		billing.append(",");
		billing.append(imei.generateIMEI());
		billing.append(",");
		billing.append(imsi.generateIMSI());
		
		return billing;
	}
	/*
	 * 生成max行cdr
	 * */
	public StringBuffer generateAmountBillingCDR(int max)
	{
		StringBuffer amount=new StringBuffer();
		for(int i=0; i<max; i++)
		{
			amount.append(this.generateBillingCDR());
			amount.append(DicTion.changeline);
		}
		return amount;
	}
	/*
	 * 
	 * 产生一个 BIllingBean
	 * */
	public BillingBean generateBillingBean()
	{
		BillingBean billingbean=new BillingBean();
		billingbean.setTimePre(time.generateTime());
		billingbean.setType(type.generateType());
		
		billingbean.setCallmobile(callmobile.generateMobile());
		
		billingbean.setCalledmobile(calledmobile.generateMobile());
		
		billingbean.setTimein(timein.generateTime());
		
		billingbean.setTimeout(timeout.generateDiffTime());
		
		billingbean.setCi(ci.generateCi());
		
		billingbean.setLac(lac.generateLac());
		
		billingbean.setImei(imei.generateIMEI());
		
		billingbean.setImsi(imsi.generateIMSI());
		return billingbean;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BillingCDR bill=new BillingCDR();
		for(int i=0; i<100; i++)
		{
			System.out.println(bill.generateBillingCDR());
		}

	}

}
