package com.txy.meet.common;

public interface Constant {

	String SELLER_STATUS_UNPASS="0";  //待审核
	String SELLER_STATUS_PASS="1";    // 审核通过
	String SELLER_STATUS_REJECT="2";  //审核驳回
	String SELLER_STATUS_CLOSE="3";   //关闭
	
	Integer PROMOTION_STATUS_UNPASS=0;  //待审核
	Integer PROMOTION_STATUS_PASS=1;	//审核通过
	Integer PROMOTION_STATUS_REJECT=2;	//审核驳回
	Integer PROMOTION_STATUS_CLOSE=3;   //关闭
	
	Integer MEET_STATUS_NOSTART=0;  //未进行
	Integer MEET_STATUS_STARTING=1;	//进行中
	Integer MEET_STATUS_LODER=2;	//已过期
	
}
