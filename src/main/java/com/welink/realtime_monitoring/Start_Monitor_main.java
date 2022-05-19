package com.welink.realtime_monitoring;

import java.util.logging.Logger;

/**
 * @Author:welink
 * @Date 2022/5/16 下午4:10
 */
public class Start_Monitor_main {
    public static void main(String[] args) {

        File_Monitoring file_monitoring = new File_Monitoring();
        file_monitoring.start_File_Monitoring();

    }
}
