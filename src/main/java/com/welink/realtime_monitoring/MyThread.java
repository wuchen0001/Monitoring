package com.welink.realtime_monitoring;

import com.welink.realtime_monitoring.utils.CsvUtils;
import java.io.*;

/**
 * @Author:welink
 * @Date 2022/5/17 上午11:10
 */
public class MyThread implements Runnable {
    File file = null;
    String s = null;
    String[] dataString =  null;
    public MyThread(File file,String s,String[] dataString){
        this.file = file;
        this.s = s;
        this.dataString = dataString;
    }
    @Override
    public void run() {// 每一个run方法不断的对文件获取并写入新的文件
        if ( s != null) {
            CsvUtils.exportCsv_String(file, s);
        }else if ( dataString != null){
            CsvUtils.exportCsv(file,dataString);
        }else {
            CsvUtils.importCsv(file);
        }
    }
}
