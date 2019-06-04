

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Decode458 {
	static byte[] key;
	
	public static void main(String[] args) throws Exception {
//		System.out.println(new String(Decode458.decode(Decode458.convertHexString("C62ECCE4734754EBF670F941A8640AA4"))));
//		System.out.println(Decode458.toHexString(Decode458.encode("13219863008".getBytes())));
		String params = "Mm1oc2ktMXNzM0A9c21AI3NqPTQ4KnNqdzAyamg=";
		b bb = new b();
		key = bb.a(params.toCharArray());
//		rpUnPack("14F234ED32B32795174153A92166E68E");
//		int i = 0;
//		CE4B55DC10ADBAFB
//		String paramString2 = "14F234ED32B32795174153A92166E68E";
//		if (paramString2.length() % 2 != 0)
//	        throw new IllegalArgumentException();
//	      char[] arrayOfChar = paramString2.toCharArray();
//	      byte[] arrayOfByte = new byte[paramString2.length() / 2];
//	      int j = paramString2.length();
//	      int k = 0;
//	      while (k < j)
//	      {
//	        StringBuilder localStringBuilder = new StringBuilder().append("");
//	        int l = k + 1;
////	        System.out.println(arrayOfChar[k] + arrayOfChar[l]);
//	        arrayOfByte[i] = new Integer(0xFF & Integer.parseInt(String.valueOf(arrayOfChar[k] + arrayOfChar[l]), 16)).byteValue();
//	        k = l + 1;
//	        ++i;
//	      }
	      
//		System.out.println(new String(Decode458.decode(Decode458.parseHexStr2Byte(paramString2))));
//	      System.out.println(new String(Decode458.decode(arrayOfByte)));
//		System.out.println(new String(Decode458.decode(Decode458.parseHexStr2Byte("14F234ED32B32795174153A92166E68E"))));
		byte[] ss = Decode458.encode("010-88630909".getBytes());
		String str1 = "";
	    for (int i = 0; i < ss.length; ++i)
	    {
	      String str2 = Integer.toHexString(ss[i]);
	      if (str2.length() > 2)
	        str2 = str2.substring(-2 + str2.length());
	      if (str2.length() < 2)
	        str2 = "0" + str2;
	      str1 = str1 + str2;
	    }
		System.out.println(str1.toUpperCase());
		System.out.println(new String(Decode458.decode(Decode458.parseHexStr2Byte(str1.toUpperCase()))));
	}
	
	public static byte[] decode(byte[] paramArrayOfByte) {
		try {
			SecureRandom localSecureRandom = new SecureRandom();
			DESKeySpec localDESKeySpec = new DESKeySpec(key);
			SecretKey localSecretKey = SecretKeyFactory.getInstance("DES")
					.generateSecret(localDESKeySpec);
			Cipher localCipher = Cipher.getInstance("DES");
			localCipher.init(2, localSecretKey, localSecureRandom);
			return localCipher.doFinal(paramArrayOfByte);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] encode(byte[] paramArrayOfByte) {
		try {
			SecureRandom localSecureRandom = new SecureRandom();
			DESKeySpec localDESKeySpec = new DESKeySpec(key);
			SecretKey localSecretKey = SecretKeyFactory.getInstance("DES")
					.generateSecret(localDESKeySpec);
			Cipher localCipher = Cipher.getInstance("DES");
			localCipher.init(1, localSecretKey, localSecureRandom);
			return localCipher.doFinal(paramArrayOfByte);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] convertHexString(String text) {
		byte digest[] = new byte[text.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = text.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}
	
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
	
	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}
	
	public static String rpUnPack(String encryptedString) {

        try {
            if (null != encryptedString && !encryptedString.equals("")) {
                // 从已经加密的字符串中先将密钥解析出来
                StringBuffer encryptKey = new StringBuffer();
                StringBuffer encryptedParamsStr = new StringBuffer();

                for (int i = 0; i < encryptedString.length(); i++) {
                    if (i % 2 == 1 && i <= 57) { // 密钥固定个数为24
                        encryptKey
                                .append(encryptedString.subSequence(i, i + 1));
                    } else {
                        encryptedParamsStr.append(encryptedString.subSequence(
                                i, i + 1));
                    }
                }

                // 根据密钥将字符串进行解密
                String decryptedParamsStr = EncryptionUtils.decryptMode(
                        encryptKey.toString(), encryptedParamsStr.toString());

                // 解析出签名信息
                int lastIndex = decryptedParamsStr.lastIndexOf("&");
                String paramsString = decryptedParamsStr
                        .substring(0, lastIndex);
                String digestString = decryptedParamsStr
                        .substring(lastIndex + 1);


                // 第除签名外的参数字符串进行MD5报文比对
                String[] digestArray = digestString.split("=");
                String digest = digestArray[1];

                // 两次密文比对相同，解析各个参数存入Map中
                String newDigest = EncryptionUtils.createMD5(paramsString);

                if (digest.equals(newDigest)) {
                    return paramsString;
                }
            }
        } catch (Exception E) {
            return null;
        }
        return null;
    }
}
