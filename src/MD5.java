import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		?messagename=esfinfo&housetype=AGT&houseid=113602030&jkVersion=2&city=北京&
           StringBuffer message =new StringBuffer("esflist");
           message.append("soufunhttp");
           System.out.println(sMD5(message.toString()));
           Md5(message.toString());
	       
	}
	private static void Md5(String plainText ) { 
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] bb = null;
			try {
				bb = plainText.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			md.update(bb); 
			byte b[] = md.digest(); 

			int i; 

			StringBuffer buf = new StringBuffer(""); 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) i+= 256; 
				if(i<16) 
					buf.append("0"); 
				buf.append(Integer.toHexString(i)); 
			} 

			System.out.println("result: " + buf.toString());//32位的加密 

			System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 

		} catch (NoSuchAlgorithmException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	} 
	public final static String sMD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
