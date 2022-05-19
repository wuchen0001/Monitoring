package com.welink.realtime_monitoring;

import com.csvreader.CsvReader;
import com.welink.realtime_monitoring.utils.CsvUtils;

import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.Queue;

/**
 * @Author:welink
 * @Date 2022/5/16 下午4:36
 */
public class NewFile_save {
    public void cathe_queue_file(File file) throws IOException {
        Deque<String> dataList = null;
        CsvUtils.importCsv(file);
    }
}
