/**
 *Copyright 2014-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.loans.baiqishi.dao;

import com.rongdu.common.persistence.BaseDao;
import com.rongdu.common.persistence.annotation.MyBatisDao;
import com.rongdu.loans.baiqishi.entity.ReportMnoOmccm;

/**
 * 白骑士-常用联系电话（近1个月)-mnoOneMonthCommonlyConnectMobiles-数据访问接口
 * @author sunda
 * @version 2017-08-14
 */
@MyBatisDao
public interface ReportMnoOmccmDao extends BaseDao<ReportMnoOmccm,String> {
	
}