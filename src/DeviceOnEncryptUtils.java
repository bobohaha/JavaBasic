import java.util.HashMap;
import java.util.Map;
public class DeviceOnEncryptUtils {
//	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceOnEncryptUtils.class);

	public static String pack(String sourceStr, String encryptKey)
	{
		StringBuffer temp = new StringBuffer();

		temp.append(sourceStr);
//		LOGGER.info("Դ�����ַ�Ϊ��" + temp.toString());
//		LOGGER.info("��ԿΪ��" + encryptKey);

		String digest = EncryptionUtils.createMD5(temp.toString());
//		LOGGER.debug("ǩ����ϢΪ��" + digest);

		temp.append("&digest=").append(digest);
//		LOGGER.debug("Դ�ַ���ǩ�������ַ�Ϊ��" + temp.toString());

		String encryptParamsAndDigest = "";
		try {
			encryptParamsAndDigest = EncryptionUtils.encryptMode(encryptKey, temp.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		LOGGER.debug("���ܺ�" + encryptParamsAndDigest);

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < encryptParamsAndDigest.length(); ++i)
		{
			result.append(encryptParamsAndDigest.subSequence(i, i + 1));

			if (i < encryptKey.length()) {
				result.append(encryptKey.substring(i, i + 1));
			}

			if ((i != encryptParamsAndDigest.length() - 1) || (encryptParamsAndDigest.length() >= encryptKey.length()))
				continue;
			result.append(encryptKey.substring(i + 1));
		}

//		LOGGER.debug("��Ϻ���ַ�Ϊ��" + result.toString());

		return result.toString();
	}

	public static Map<String, String> unPack(String encryptedString) {
		Map paramKeyAndValue = new HashMap();
		try
		{
			if ((null != encryptedString) && (!encryptedString.equals("")))
			{
				StringBuffer encryptKey = new StringBuffer();
				StringBuffer encryptedParamsStr = new StringBuffer();

				for (int i = 0; i < encryptedString.length(); ++i) {
					if ((i % 2 == 1) && (i <= 47)) {
						encryptKey.append(encryptedString.subSequence(i, i + 1));
					}
					else {
						encryptedParamsStr.append(encryptedString.subSequence(i, i + 1));
					}

				}

//				LOGGER.debug("����������ԿΪ��" + encryptKey.toString());
//				LOGGER.debug("�������ļ��ܺ�����ַ�Ϊ��" + encryptedParamsStr.toString());

				String decryptedParamsStr = EncryptionUtils.decryptMode(encryptKey.toString(), encryptedParamsStr.toString());

//				LOGGER.debug("��ѹ���Ľ����ַ�Ϊ��" + decryptedParamsStr);

				int lastIndex = decryptedParamsStr.lastIndexOf("&");
				String paramsString = decryptedParamsStr.substring(0, lastIndex);

				String digestString = decryptedParamsStr.substring(lastIndex + 1);

//				LOGGER.info("��������ϢΪ��" + paramsString);
//				LOGGER.debug("ǩ����ϢΪ" + digestString);

				String[] digestArray = digestString.split("=");
				String digest = digestArray[1];
//				LOGGER.debug("�Ӳ����н������Ĵ�ǩ��Ϊ��" + digestString);

				String newDigest = EncryptionUtils.createMD5(paramsString);
//				LOGGER.debug("���¼�����µ�ǩ��Ϊ��" + newDigest);

				if (digest.equals(newDigest))
				{
					String[] params = paramsString.split("&");
					for (String param : params) {
						String[] nameAndValue = param.split("=");

						if (nameAndValue.length == 2) {
							String name = nameAndValue[0];
							String value = nameAndValue[1];

							paramKeyAndValue.put(name, value);
						}
					}
				}

				paramKeyAndValue.put("key", encryptKey.toString());
			}
		} catch (Exception E) {
			paramKeyAndValue.put("RESULT", "ERROR");
		}

//		LOGGER.info(paramKeyAndValue.toString());

		return paramKeyAndValue;
	}

}
