package com.welink.realtime_monitoring;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.log4j.Logger;
import org.apache.commons.io.monitor.FileAlterationObserver;
import java.io.*;

/**
 * @Author:welink
 * @Date 2022/5/16 下午3:23
 */
public class FileListener extends FileAlterationListenerAdaptor {

    public static final Logger logger = Logger.getLogger(FileListener.class);

    @Override
    public void onStart(FileAlterationObserver observer) {
        //System.out.println("启动监听器：");
    }
    @Override
    public void onDirectoryCreate(File directory) {
        logger.info("存在新文件夹生成："+directory.getPath());
    }
    @Override
    public void onDirectoryChange(File directory) {
        logger.info("有文件夹内容发生变化："+directory.getName());
    }
    @Override
    public void onDirectoryDelete(File directory) {
        logger.info("有文件夹被删除："+directory.getName());
    }
    @Override
    public void onFileCreate(File file){

        NewFile_save newFile_save = new NewFile_save();
        try {
            newFile_save.cathe_queue_file(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("有新文件生成："+file.getName());

    }
    @Override
    public void onFileChange(File file){
        logger.info("有文件被修改："+file.getName());
    }
    @Override
    public void onFileDelete(File file){
        logger.info("有文件被删除："+file.getName());
    }
    @Override
    public void onStop(FileAlterationObserver observer){
        //System.out.println("监听停止");
    }
}
