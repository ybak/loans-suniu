/**
 *Copyright 2014-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.loans.risk.dao;

import com.rongdu.common.persistence.BaseDao;
import com.rongdu.common.persistence.annotation.MyBatisDao;
import com.rongdu.loans.risk.entity.HitRule;

/**
 * 命中的风控规则-数据访问接口
 * @author sunda
 * @version 2017-08-14
 */
@MyBatisDao
public interface HitRuleDao extends BaseDao<HitRule,String> {
	
}