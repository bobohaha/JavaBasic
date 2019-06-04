
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class EncryptionUtils {

	private static final String Algorithm = "DESede";
	private static final String hexString = "0123456789ABCDEF";

	public static String encryptMode(String keyString, String srcString)
			throws Exception
			{
		try
		{
			byte[] keybyte = keyString.getBytes();
			byte[] srcByte = srcString.getBytes();

			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");

			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(1, deskey);

			byte[] resultByteArray = c1.doFinal(srcByte);

			return byte2hex(resultByteArray);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			}

	public static String decryptMode(String keyString, String srcString)
			throws Exception
			{
		try
		{
			byte[] keybyte = keyString.getBytes();
			byte[] srcByte = hexStringToByte(srcString);
            int i = srcByte.length%8;
            System.out.println(i);
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");

			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(2, deskey);

			byte[] resultByteArray = c1.doFinal(srcByte);
			return new String(resultByteArray);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
			}

	public static final String createMD5(String data)
	{
		MessageDigest digest = null;

		if (digest == null) {
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException nsae) {
				System.err.println("Failed to load the MD5 MessageDigest. Jive will be unable to function normally.");

				nsae.printStackTrace();
			}
		}

		digest.update(data.getBytes());
		return byte2hex(digest.digest());
	}

	public static String byte2hex(byte[] b)
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; ++n) {
			stmp = Integer.toHexString(b[n] & 0xFF);
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + "";
		}
		return hs.toUpperCase();
	}
	
	/**将16进制转换为二进制 
	 * @param hexStr 
	 * @return 
	 */  
	public static byte[] parseHexStr2Byte(String hexStr) {  
	        if (hexStr.length() < 1)  
	                return null;  
	        byte[] result = new byte[hexStr.length()/2];  
	        for (int i = 0;i< hexStr.length()/2; i++) {  
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	                result[i] = (byte) (high * 16 + low);  
	        }  
	        return result;  
	}  

	public static byte[] hexStringToByte(String hex)
	{
		int len = hex.length() / 2;
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();

		for (int i = 0; i < len; ++i) {
			int pos = i * 2;
			result[i] = (byte)(toByte(achar[pos]) << 4 | toByte(achar[(pos + 1)]));
		}

		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte)"0123456789ABCDEF".indexOf(c);
		return b;
	}

	public static String createKey(int count)
	{
		char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		int codeCount = count;

		StringBuffer randomCode = new StringBuffer();

		Random random = new Random();

		for (int i = 0; i < codeCount; ++i)
		{
			String strRand = String.valueOf(codeSequence[random.nextInt(36)]);

			randomCode.append(strRand);
		}

		return randomCode.toString();
	}
}
