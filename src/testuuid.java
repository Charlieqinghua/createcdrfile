import java.util.UUID;


public class testuuid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = UUID.randomUUID().toString();//
		String s1 = UUID.randomUUID().toString();//
		String input="18601106193";
		byte bin[]=input.getBytes();
		System.out.println(s+"  "+s1);
		Long rowid=0L;
		byte r[]=new byte[8];
		r=java.lang.Long.toString(rowid).getBytes(); 
		//System.out.println(Long.toBinaryString(rowid));
		long  flag=Thread.currentThread().getId();
		byte r1[]=java.lang.Long.toString(flag).getBytes(); ;
		byte b[]=new byte[16];
		System.arraycopy( r, 0, b, 0, r.length);
		System.arraycopy( r1, 0, b, 8, r1.length);
		for(int i=0; i<16;i++ ){
		System.out.print(b[i]);
		}

	}

}
