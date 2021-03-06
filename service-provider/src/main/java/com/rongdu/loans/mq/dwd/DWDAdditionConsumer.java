package com.rongdu.loans.mq.dwd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.rongdu.common.mapper.JsonMapper;
import com.rongdu.common.mq.CommonMessage;
import com.rongdu.loans.loan.option.dwd.DWDAdditionInfo;
import com.rongdu.loans.loan.option.dwd.DWDBaseInfo;
import com.rongdu.loans.loan.service.DWDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 */
@Service("DWDAdditionConsumer")
public class DWDAdditionConsumer implements ChannelAwareMessageListener {
    @Autowired
    private DWDService dwdService;

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            //控制接口调用频率
            Thread.sleep(3000);
            CommonMessage<DWDAdditionInfo> msg = parseMessage(message);
            logger.debug("大王贷推送补充信息消费者：{}，{}，{}", msg.getSource(), msg.getType(), msg.getBizId());
            DWDAdditionInfo intoOrder = msg.getMessage();
            boolean flag = dwdService.saveAdditionInfo(intoOrder);
            if (!flag) {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                channel.basicPublish(message.getMessageProperties().getReceivedExchange(),
                        message.getMessageProperties().getReceivedRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBody());
            } else {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }

        } catch (Exception e) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            channel.basicPublish(message.getMessageProperties().getReceivedExchange(),
                    message.getMessageProperties().getReceivedRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBody());
            e.printStackTrace();
        }
    }


    /**
     * 将消息映射为Java对象
     *
     * @param message
     * @return
     * @throws UnsupportedEncodingException
     */
    private CommonMessage<DWDAdditionInfo> parseMessage(Message message)
            throws UnsupportedEncodingException {
        String jsonMsg = new String(message.getBody(), "UTF-8");
        TypeReference<CommonMessage<DWDAdditionInfo>> reference = new TypeReference<CommonMessage<DWDAdditionInfo>>() {
        };
        CommonMessage<DWDAdditionInfo> msg =
                (CommonMessage<DWDAdditionInfo>) JsonMapper.fromJsonString(jsonMsg, reference);
        return msg;
    }

}