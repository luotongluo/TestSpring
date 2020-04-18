package com.lt.commparent.utils;

  
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


@SuppressWarnings("restriction")
public class AES {  
      
   
    
 
  
        // 加密
        public static String aesEecrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = sKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            
            byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
            
           // String encryptResultStr = new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
            String encryptResultStr = parseByte2HexStr(encrypted);  
            return encryptResultStr;
    }

        // 解密
        public static String aesDecrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
            try {
                byte[] raw = sKey.getBytes("ASCII");
                
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
               
                //byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
                byte[] encrypted1 = parseHexStr2Byte(sSrc); 
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,encodingFormat);
                return originalString;
            } catch (Exception ex) {
               ex.printStackTrace();
               throw ex;
            }
    }

        /**将二进制转换成16进制 
         * @param buf 
         * @return 
         */  
        public static String parseByte2HexStr(byte buf[]) {  
                StringBuffer sb = new StringBuffer();  
                for (int i = 0; i < buf.length; i++) {  
                        String hex = Integer.toHexString(buf[i] & 0xFF);  
                        if (hex.length() == 1) {  
                                hex = '0' + hex;  
                        }  
                        sb.append(hex.toUpperCase());  
                }  
                return sb.toString();  
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
        
        
    public static void main(String[] args) throws Exception {
    
   
            String sKey=MD5.MD5Encode("1234", "UTF-8").substring(0, 16);
            
            String ivParameter=MD5.MD5Encode("1234", "UTF-8").substring(0, 16);
             
            // 需要加密的字串
            String cSrc = "123456";
            System.out.println("加密前的字串是："+cSrc);
            // 加密
            String enString = aesEecrypt(cSrc,"utf-8",sKey,ivParameter);
            System.out.println("加密后的字串是："+ enString);
            
            // 解密
            String DeString = aesDecrypt(enString,"utf-8",sKey,ivParameter);
            System.out.println("解密后的字串是：" + DeString);
        }
  
} 