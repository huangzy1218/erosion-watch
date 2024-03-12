package cn.edu.nwafu.erosion.portal.component;

import cn.edu.nwafu.erosion.portal.domain.dto.ExcelUpdateDto;
import cn.edu.nwafu.erosion.portal.service.MyDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Huang Z.Y.
 */
@Slf4j
@Component
@RabbitListener(queues = "erosion.excel.update")
public class UpdateExcelReceiver {
    @Autowired
    private MyDataService myDataService;

    @RabbitHandler
    public void handle(ExcelUpdateDto excelUpdateDto) {
        myDataService.updateExcelData(excelUpdateDto);
        log.info("receive: excelUpdateDto: {}", excelUpdateDto);
    }
}
    