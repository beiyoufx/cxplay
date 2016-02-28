package com.tgg.cxplay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;
import com.tgg.cxplay.utils.FileUtil;
import com.tgg.cxplay.utils.MD5Util;

public class Test {

    public static void main(String[] args){
        testCopy();
    }

    public static void testMD5() {
        String srcPath = "D:" + FileUtil.SEPARATOR + "media" + FileUtil.SEPARATOR + "video" + FileUtil.SEPARATOR + "2015-07-05";
        File file = new File(srcPath);
        BufferedWriter writer = null;
        try {
            File MD5File = new File(file.getParentFile(), file.getName() + "-MD5.txt"); 
            writer = new BufferedWriter(new FileWriter(MD5File));
            FileUtil.getMD5(file, writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testCopy() {
        //String folderPath = "D:" + FileUtil.SEPARATOR + "media" + FileUtil.SEPARATOR + "video" + FileUtil.SEPARATOR + "test";
        String folderPath = "D:" + FileUtil.SEPARATOR + "media" + FileUtil.SEPARATOR + "movie" + FileUtil.SEPARATOR + "thunder";
        //String folderPath = "D:" + FileUtil.SEPARATOR + "media" + FileUtil.SEPARATOR + "video" + FileUtil.SEPARATOR + "2015-07-05";
        String outputPath = "D:" + FileUtil.SEPARATOR + "media" + FileUtil.SEPARATOR + "video" + FileUtil.SEPARATOR + "2015-08-09";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        File outFolder = new File(outputPath);
        BufferedWriter writer = null;
        File MD5Log = new File(outFolder.getParent(), outFolder.getName() + "-MD5.txt");
        String[] suffixes = {"mp4"};

        //主程序开始
        long startTime = System.currentTimeMillis();
        int index = 0;
        //创建记录文件输出流
        try {
            writer = new BufferedWriter(new FileWriter(MD5Log));
            for(File file : files) {
                if(FileUtil.isMatchSuffix(FileUtil.getSuffix(file), suffixes)) {
                    index++;
                    try {
                        //计算文件MD5
                        String fileMD5 = MD5Util.getMD5(file);
                        //生成新文件
                        File newfile = new File(outFolder, fileMD5 + "." + FileUtil.getSuffix(file));

                        //开始拷贝
                        long startCopy = System.currentTimeMillis();
                        FileUtil.copy(file, newfile);
                        long endCopy = System.currentTimeMillis();
                        //结束拷贝

                        //输出记录
                        String line = file.getName() + "-MD5-" + fileMD5 + FileUtil.LINE_SEPARATOR;
                        writer.write(line);
                        log.info("拷贝第" + index + "个文件:" + file.getName() + "--" + newfile.getName() + "(耗时：" + (endCopy - startCopy)/1000.0 + "s)" );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //主程序结束
        long endTime = System.currentTimeMillis();
        log.info("共" + index + "个文件(总耗时：" + (endTime - startTime)/1000.0 + "s)");
    }

    private static final Log log = LogFactoryUtil.getLog(Test.class);
}
