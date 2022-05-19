package com.welink.realtime_monitoring.utils;

/**
 * @Author:welink
 * @Date 2022/5/16 下午9:34
 */

import com.welink.realtime_monitoring.MyThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.Deque;
import java.util.Queue;
public class CsvUtils {

    // 文件中抽离出字符串数组
    public static boolean exportCsv(File file, String[] dataString){
        boolean isSucess=false;
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file,true);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataString!=null){
                for(String data : dataString){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    public static boolean exportCsv_String(File file, String s){
        boolean isSucess=false;
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file,true);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(s!=null){
                bw.append(s).append("\r");
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    public static void importCsv(File file){
        Deque<String> dataList=new LinkedList<String>();

        BufferedReader br=null;
        int class_num = 0;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            int i = 1;

            while ((line = br.readLine()) != null) {
                dataList.add(line);

                // 根据第一行直接成文不同的文件
                if(i == 1){
                    String first_queue = dataList.poll();
                    String[] every_class = first_queue.split(",");
                    class_num = every_class.length;
                    for (int j = 0; j < class_num; j++) {
                        boolean isSuccess=CsvUtils.exportCsv_String(new File("/Users/wuchen/Downloads/chores/A/A-"+j+".csv"), every_class[j]);
                        System.out.println("A-"+j+".csv"+"生成");
                    }
                }

                i++;
                if (i % 10 == 0 && dataList!=null && !dataList.isEmpty()){  //每十次从队列中取数据并写入文件一次
                    for(int k=0; k<dataList.size();k++ ){
                        String s = dataList.poll();
                        String[] split = s.split(",");
                        for (int i1 = 0; i1 < split.length; i1++) {
                            if (i1 >= class_num){
                                CsvUtils.exportCsv_String(new File("/Users/wuchen/Downloads/chores/A/A-"+(class_num - 1)+".csv"), split[i1]);

                            }else {
                                CsvUtils.exportCsv_String(new File("/Users/wuchen/Downloads/chores/A/A-"+i1+".csv"), split[i1]);
                            }
                        }
                    }
                }
            }

        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * CSV读取测试
     * @throws Exception
     */
//    public static void importCsv()  {
//        Deque<String> dataList= (Deque<String>) CsvUtils.importCsv(new File("/Users/wuchen/Downloads/chores/monitoring/ljq.csv"));
//        if(dataList!=null && !dataList.isEmpty()){
//            for(int i=0; i<dataList.size();i++ ){
//                if(i!=0){//不读取第一行
//                    String s=dataList.poll();
//                    System.out.println("s  "+s);
//                    String[] as = s.split(",");
//                }
//            }
//        }
//    }

    /**
     * CSV写入测试
     * @throws Exception
     */
//    public static void exportCsv() {
//        Deque<String> dataList=new LinkedList<String>();
//        dataList.add("number,name,sex");
//        dataList.add("1,张三,男");
//        dataList.add("2,李四,男");
//        dataList.add("3,小红,女");
//        boolean isSuccess=CsvUtils.exportCsv(new File("/Users/wuchen/Downloads/chores/monitoring/ljq.csv"), dataList);
//        System.out.println(isSuccess);
//    }


}