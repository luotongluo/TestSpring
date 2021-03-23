package com.lt.commparent.tools;


import java.security.MessageDigest;

public class MD5Util {

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 把字节数组转换为十六进制的字符串
     *
     * @param b 字节数组
     * @return 十六进制的字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 把一个字节转换为一个十六进制的字符串
     *
     * @param b 字节
     * @return 十六进制的字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 把字符串以MD5的方式加密
     *
     * @param origin 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    public static String MD5ShiroEncode(String origin, String salt, int hashIterations) {
        String resultString = null;
        try {
            byte[] bytes = origin.getBytes("UTF-8");
            byte[] salts = salt.getBytes("UTF-8");

            MessageDigest digest = MessageDigest.getInstance("MD5");
            if (salt != null) {
                digest.reset();
                digest.update(salts);
            }
            byte[] hashed = digest.digest(bytes);
            int iterations = hashIterations - 1;
            // iterate remaining number:
            for (int i = 0; i < iterations; i++) {
                digest.reset();
                hashed = digest.digest(hashed);
            }
            resultString = byteArrayToHexString(hashed);
        } catch (Exception e) {

        }
        return resultString;
    }

    /**
     * 把字符串以16位MD5的方式加密
     *
     * @param origin 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String MD5Encode16Bit(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(
                    md.digest(resultString.getBytes())).substring(8, 24);
        } catch (Exception ex) {
        }
        return resultString;
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder("");
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }

        }
        return hs.toString().toUpperCase();
    }

    public static byte[] getCipherStr(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes("UTF-8"));
            return byte2hex(md5.digest()).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input.getBytes();

    }

	/*public static void main(String[] agrs) {
		// 2005062300010155702551 2320050623010492 99 99 1.05 0.00 1.00 0.05
		// 0.025 1 1119503743 577bc2a3af45db90727b4bd5c5644933
		String s = "100000233D9D4B288CC9A7770910449793882F5073B8127664260B6959FDC8FCC4D6B09F1D8BCFC0F163DED155CBC80EC42DDD50861E5C6B289A95E939247A3B7BBD10137AC1668C1042E6AD21AAC8DA490223F97C58DBF01A4D0273D4054AB6B8A6E6453DCC1E4448A46D79ABBAE9E9E700AA9637D6F9188D7D6C30C572EABEEFC4E5B8AC59B2902DE2F1E3359AD50CBB7F745F67250100057A2FA51DE58C106D3875F770DCEE0F03FCDE98C7E55BF1097FCC5D5FE728EDCF9B0C1A1B78A659098F989ACDCD13E2B5C98073A94574A90914857EF9C60A1DC8940DF1E6DE2CB7B168F118E3C6983D3F88A5EFA1272B55EF9270C93F8F846229581F979F1FD16BE4A737DEF4662ADE1A70FD62CA35CA4F12A282861543405340";
		// String s2 =
		// "MERCHANTID=010418407&POSID=000000000&BRANCHID=110000000&ORDERID=3020050516000055&PAYMENT=0.01&CURCODE=01&TXCODE=520100&REMARK1=&REMARK2=";//
		// &MAC=ed024dc57b4751a16911f0c1c301fc26";
		// String s3 = "200411191200123456";
		// String key = "123456";
		//
		// String s4 = "000001yenianxue1234566666200.0022" + key;
		System.out.println(MD5Encode(s));
		// System.out.println(MD5Encode(s2));
		// System.out.println(MD5Encode(s3));
		// System.out.println(MD5Encode("111111"));
		
		// 050416
		System.out.println();
	}*/
}
