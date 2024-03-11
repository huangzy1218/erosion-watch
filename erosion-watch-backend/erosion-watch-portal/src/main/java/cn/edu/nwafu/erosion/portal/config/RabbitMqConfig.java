package cn.edu.nwafu.erosion.portal.config;

import cn.edu.nwafu.erosion.portal.enums.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列相关配置。
 *
 * @author Huang Z.Y.
 */
@Configuration
public class RabbitMqConfig {

    /**
     * Excel修改消费队列所绑定的交换机
     */
    @Bean
    DirectExchange orderDirect() {
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_EXCEL_UPDATE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * Excel延迟队列队列所绑定的交换机
     */
    @Bean
    DirectExchange orderTtlDirect() {
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_EXCEL_UPDATE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * Excel实际消费队列
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QueueEnum.QUEUE_EXCEL_UPDATE.getName());
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue orderTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_EXCEL_UPDATE.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_TTL_EXCEL_UPDATE.getExchange())//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_EXCEL_UPDATE.getRouteKey())//到期后转发的路由键
                .build();
    }

    /**
     * 将Excel队列绑定到交换机
     */
    @Bean
    Binding orderBinding(DirectExchange orderDirect, Queue orderQueue) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(QueueEnum.QUEUE_EXCEL_UPDATE.getRouteKey());
    }

    /**
     * 将Excel延迟队列绑定到交换机
     */
    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlDirect, Queue orderTtlQueue) {
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirect)
                .with(QueueEnum.QUEUE_TTL_EXCEL_UPDATE.getRouteKey());
    }
}
    