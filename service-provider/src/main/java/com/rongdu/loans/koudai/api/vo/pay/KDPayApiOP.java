package com.rongdu.loans.koudai.api.vo.pay;

import java.io.Serializable;

public class KDPayApiOP implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String project_name;// 项目名
	private String pwd;// 项目密码
	private String yur_ref;// 放款订单号，固定30位
	private String user_id;// 用户id(最长9位)
	private String real_name; // 姓名
	private String bank_id;// 银行id
	private String card_no;// 银行卡号
	private String money;// 放款金额（分）
	private String fee;// 放款手续费（分）
	private String pay_summary;// 备注

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getYur_ref() {
		return yur_ref;
	}

	public void setYur_ref(String yur_ref) {
		this.yur_ref = yur_ref;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getPay_summary() {
		return pay_summary;
	}

	public void setPay_summary(String pay_summary) {
		this.pay_summary = pay_summary;
	}

}
