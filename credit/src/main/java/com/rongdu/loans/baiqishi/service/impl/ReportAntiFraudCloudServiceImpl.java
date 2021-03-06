/**
 * Copyright 2015-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.loans.baiqishi.service.impl;

import com.rongdu.common.service.BaseService;
import com.rongdu.loans.baiqishi.manager.ReportAntiFraudCloudManager;
import com.rongdu.loans.baiqishi.service.ReportAntiFraudCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 白骑士-反欺诈云-业务逻辑实现类
 * @author sunda
 * @version 2017-08-14
 */
@Service("reportAntiFraudCloudService")
public class ReportAntiFraudCloudServiceImpl  extends BaseService implements  ReportAntiFraudCloudService{
	
	/**
 	* 白骑士-反欺诈云-实体管理接口
 	*/
	@Autowired
	private ReportAntiFraudCloudManager reportAntiFraudCloudManager;
	
}