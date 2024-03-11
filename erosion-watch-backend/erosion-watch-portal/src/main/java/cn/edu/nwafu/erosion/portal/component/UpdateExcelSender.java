package cn.edu.nwafu.erosion.portal.component;

import cn.edu.nwafu.erosion.portal.domain.dto.ExcelUpdateDto;
import cn.edu.nwafu.erosion.portal.enums.QueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 表格数据更改的发送者。
 *
 * @author Huang Z.Y.
 */
@Slf4j
@Component
public class UpdateExcelSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendUpdateRequest(ExcelUpdateDto excelUpdateDto) {
        // 发送到特定交换机，路由键指定为Excel数据更新队列
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_EXCEL_UPDATE.getExchange(), QueueEnum.QUEUE_EXCEL_UPDATE.getRouteKey(),
                excelUpdateDto, message -> {
                    // 可以在这里设置一些消息属性，如果需要的话
                    return message;
                });
        log.info("excelUpdateDto: {}", excelUpdateDto);
    }
}
    