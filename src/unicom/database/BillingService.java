package unicom.database;



public class BillingService {

	/**
	 * @param args
	 */
	
	BillingDao dao = new BillingDao();
	public void initConnect()
	{
		dao.conn();
	}
	public void insertIntoDataBase(BillingBean beanblock[])
	{
				
		String sql = "insert into"+ " cdr_phonenumber_salt "+
					"(partion ,cdr_type,caller,callee,starttime,stoptime ,LAC ,CI ,emei ,emsi ) "+
				   " values (?,?,?,?,?,?,?,?,?,?)";
		dao.insertBillingBean(beanblock,sql);
	
	
		
	}
	public void closeConnect()
	{
		dao.freeConn();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=100;
		BillingService service =new BillingService();
		//service.initConnect();
		for(int i=0;i<1000;i++)
		{
			BeanPackage beanpackage=new BeanPackage();
			BillingBean beanblock[]=beanpackage.geneateAmoutBillingBean(max);
			service.insertIntoDataBase(beanblock);
			
		}
		service.closeConnect();
		
	}

}
