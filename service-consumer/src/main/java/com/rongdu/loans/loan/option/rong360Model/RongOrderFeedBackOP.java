package com.rongdu.loans.loan.option.rong360Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**  
* @Title: RongOrderfeedbackOP.java  
* @Package com.rongdu.loans.loan.option.rong360  
* @Description: TODO(用一句话描述该文件做什么)  
* @author: yuanxianchu  
* @date 2018年6月29日  
* @version V1.0  
*/
@Data
public class RongOrderFeedBackOP implements Serializable{

	private static final long serialVersionUID = -6343545502224270423L;

	/**
	 * 订单编号
	 */
	@JsonProperty("order_no")
	private String orderNo;
	
	/**
	 * 状态
	 */
	@JsonProperty("order_status")
	private Integer orderStatus;
	
	/**
	 * 订单变更时间
	 */
	@JsonProperty("update_time")
	private int updateTime;
}
