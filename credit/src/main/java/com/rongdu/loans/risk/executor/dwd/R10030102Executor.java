package com.rongdu.loans.risk.executor.dwd;

import com.rongdu.loans.loan.option.dwd.report.Report;
import com.rongdu.loans.risk.common.AutoApproveContext;
import com.rongdu.loans.risk.common.Executor;
import com.rongdu.loans.risk.common.RuleIds;
import com.rongdu.loans.risk.entity.HitRule;

import java.util.List;

/**
 * 身份证组合过其它电话个数大于等于4
 *
 * @author fy
 * @version 2019-05-27
 */
public class R10030102Executor extends Executor {

    @Override
    public void init() {
        super.setRuleId(RuleIds.R10030102);
    }

    @Override
    public void doExecute(AutoApproveContext context) {
        // 加载聚信立分析报告数据
        Report report = getDataInvokeService().getdwdChargeInfo(context).getReportInfo().getData().getReport();
        if (report == null) {
            return;
        }
        // 命中的规则
        HitRule hitRule = checkRule(report);
        // 决策依据
        String evidence = hitRule.getRemark();
        // 命中规则的数量
        int hitNum = getHitNum();
        if (hitNum > 0) {
            addHitRule(context, hitRule);
        }
        logger.info("执行规则-【{}-{}】-{},{},命中规则的数量：{},决策依据：{}", getRuleId(), getRuleName(), context.getUserName(),
                context.getApplyId(), hitNum, evidence);
    }

    /**
     * 身份证组合过其它电话个数大于等于4
     *
     * @param report
     * @return
     */
    private HitRule checkRule(Report report) {
        HitRule hitRule = createHitRule(getRiskRule());
        String remark = null;
        // 执行规则逻辑
        if (report != null) {
            List<String> lists = report.getUserInfoCheck().getCheckSearchInfo().getIdcardWithOtherPhones();
            if (lists != null && lists.size() >= 4){
                setHitNum(1);
                remark = String.format("身份证组合过其它电话个数大于等于4，详情列表：%s", lists.toString());
                hitRule.setRemark(remark);
            }
        } else {
            setHitNum(1);
            remark = "聚信立分析报告数据为空或紧急联系人为空";
            hitRule.setRemark(remark);
        }
        return hitRule;
    }

}
