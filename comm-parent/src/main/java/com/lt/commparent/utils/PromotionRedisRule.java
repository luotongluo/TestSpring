/**   
* @Title: PromotionRedisRule.java 
* @Package com.leyou.apollo.framework 
* @Description: 定义促销与券的缓存存储规则
* @author JerryLong  
* @date 2019年2月28日 上午10:56:23 
* @version V1.0   
* <p>Company: Leyou(China) Chain Store Co.,Ltd</p>
* <p>版权所有: Copyright©1999-2019 leyou.com. All Rights Reserved</p> 
*/
package com.lt.commparent.utils;
public class PromotionRedisRule {
	
	/**
	 * 
	 * @Title: getPromotionKey 
	 * @Description: 根据SKU与城市获取缓存KEY名称
	 * @param 
	 * @return String    返回类型 
	 * @throws 
	 * @author JerryLong  
	 * @date 2019年2月28日 上午10:59:35
	 */
	public static String getPromotionKey(String sku,String city) {
		return "promotion:"+sku+":"+city;
	}
	
	public static String getPromotionHashKey(Integer promBillId,Integer ruleId) {
		return "promBillId:"+promBillId+"ruleId:"+ruleId;
	}
	
	public static String getCouponKey(String sku,String city) {
		return "coupon:"+sku+":"+city;
	} 
	
	public static String getCouponsHashKey(Integer couponBillId,Integer ruleId) {
		return "couponBillId:"+couponBillId+"ruleId:"+ruleId;
	}
	
}
