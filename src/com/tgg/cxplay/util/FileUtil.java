package com.tgg.cxplay.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.FileChannel;

import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;

public class FileUtil {

    public final static String SEPARATOR = File.separator;             // "\"
    public final static String PATH_SEPARATOR = File.pathSeparator;    // ";"
    public final static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static String getSuffix(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }

    /**
     * @param String target for target suffix.
     * @param String[] suffixes for limited criteria.
     * @return if target suffix is empty, return false.
     * if limited criteria is empty, return false.
     * @author Jerry Teng
     */
    public static boolean isMatchSuffix(String target, String[] suffixes) {
        if (StringUtil.isEmpty(target)) {
            return false;
        }
        if (StringUtil.isEmpty(suffixes)) {
            return true;
        }
        for (String suffix : suffixes) {
            if (target.equalsIgnoreCase(suffix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description Used for write down the file MD5 down.
     * @param file the directory or a file.
     * @param writer, use this to write down the MD5.
     * @param path the first level directory or null.
     * @throws IOException
     * @author Jerry Teng
     */
    public static void getMD5(File file, Writer writer, String path) throws IOException {
        path = (path == null || "".equals(path)) ? file.getName() : path + SEPARATOR + file.getName();
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                getMD5(f, writer, path);
            }
        } else {
            try {
                String MD5String = MD5Util.getMD5(file);
                String line = path + "----" + MD5String + LINE_SEPARATOR;
                writer.write(line);
                log.info(line);
            } catch (IOException e) {
                log.error(e);
                throw e;
            }
        }
    }

    /**
     * @param file can be a directory or a file.
     * @param suffixes is a limited criteria array.
     * @param MD5Array as result array.
     * @return file MD5.
     * @author Jerry Teng
     */
    public static String[] getMD5(File file, String[] suffixes, String[] MD5Array) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for(File f : files) {
                MD5Array = StringUtil.concat(MD5Array, getMD5(f, suffixes, MD5Array));
            }
        } else {
            String[] temp = new String[0];
            if(isMatchSuffix(getSuffix(file), suffixes)) {
                try {
                    String fileMD5 = MD5Util.getMD5(file);
                    temp = StringUtil.concat(temp, fileMD5);
                    return temp;
                } catch (FileNotFoundException e) {
                    log.error(e);
                }
            }
            return temp;
        }
        return MD5Array;
    }

    /**
     * @description Implement file copy with File Stream and buffer.
     * @param src the source file. 
     * @param target the output file.
     * @throws IOException
     * @author Jerry Teng
     */
    public static void oldCopy(File src, File target) throws IOException {
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(src);
            output = new FileOutputStream(target);
            byte[] buffer = new byte[4096];
            int i = 0;
            while ((i = input.read(buffer)) != -1) {
                output.write(buffer, 0, i);
            }
        } catch (IOException e) {
            log.error(e);
            throw e;
        } finally {
            close(input);
            close(output);
        }
    }

    /**
     * @description Implement file copy with File Channel.
     * @param src the source file.
     * @param target the output file.
     * @throws IOException
     * @author Jerry Teng
     */
    public static void copy(File src, File target) throws IOException {
        FileInputStream input = null;
        FileOutputStream output = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            input = new FileInputStream(src);
            output = new FileOutputStream(target);
            in = input.getChannel();
            out = output.getChannel();
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            log.error(e);
            throw e;
        } finally {
            close(input);
            close(output);
            close(in);
            close(out);
        }
    }

    private static void close(FileInputStream input) {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private static void close(FileOutputStream output) {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private static void close(FileChannel fileChannel) {
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private static final Log log = LogFactoryUtil.getLog(FileUtil.class);
}
