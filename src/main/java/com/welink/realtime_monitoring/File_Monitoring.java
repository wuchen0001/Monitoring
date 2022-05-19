package com.welink.realtime_monitoring;


import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author:welink
 * @Date 2022/5/16 下午3:11
 */
@Component   // 实现监控器的开启
public class File_Monitoring {
    @PostConstruct
    public void start_File_Monitoring(){
        String Path_Dir = "/Users/wuchen/Downloads/chores/monitoring/";
        Integer time = 5;
        long interval = TimeUnit.SECONDS.toMillis(time);
        //IOFileFilter ioFileFilter = FileFilterUtils.suffixFileFilter(".csv");
        FileAlterationObserver _observer = new FileAlterationObserver(
                Path_Dir,
                FileFilterUtils.and(
                        FileFilterUtils.fileFileFilter()),  //过滤文件格式
                null);
        FileAlterationObserver observer = new FileAlterationObserver(Path_Dir);
        observer.addListener(new FileListener()); //设置文件变化监听器
        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
