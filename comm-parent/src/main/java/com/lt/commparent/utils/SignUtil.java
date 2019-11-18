/**   
* @Title: SignUtil.java 
* @Package com.leyou.util 
* @Description:
* @author Abin  
* @date 2018年11月22日 下午8:21:08 
* @version V1.0   
* <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
* <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p> 
*/
package com.lt.commparent.utils;

public class SignUtil {

	/**
	 * 
	 * @Title: encodeAESToMsg
	 * @Description: 对header,body,appkey,appid做加密
	 * @param
	 * @return String 返回类型
	 * @throws @author
	 *             Abin
	 * @date 2018年11月22日 下午8:32:56
	 */

	public static String encodeAESToMsg(String json, String appkey, String appid, String time_stamp) throws Exception {
//		String sKey = MD5.MD5Encode(appkey, "utf-8").substring(0, 16);
//		String ivParameter = MD5.MD5Encode(appid, "utf-8").substring(0, 16);
//		String msg = AES.aesEecrypt(json, "utf-8", sKey, ivParameter);
		String sign = MD5.MD5Encode(appkey + json + time_stamp);
		return sign;
	}

	public static boolean verify(String signReq, String signUs) {
		if (signReq == null || "".equals(signReq)) {
			return false;
		}
		if (signUs == null || "".equals(signUs)) {
			return false;
		}
		if (signReq.equals(signUs)) {
			// 验签成功
			return true;
		} else {
			// 验签失败
			return false;
		}
	}

}
