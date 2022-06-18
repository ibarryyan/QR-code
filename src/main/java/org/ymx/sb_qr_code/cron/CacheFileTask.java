package org.ymx.sb_qr_code.cron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;

/**
 * @desc: 定时任务，清除缓冲区
 * @author: YanMingXin
 * @create: 2022/6/18-9:43
 **/
@Configuration
@EnableScheduling
public class CacheFileTask {

    @Value("${file.upload.path}")
    private String filePath;

    /**
     * cron方式
     */
    @Scheduled(cron = "0 0 * * * ?")
    private void configureTasks1() {
        File file = new File(filePath);
        delFile(file);
    }

    /**
     * 删除目录下文件
     *
     * @param index
     */
    public void delFile(File index) {
        File[] files = index.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                delFile(file);
            }
            file.delete();
        }
    }

}
