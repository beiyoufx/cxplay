package com.tgg.cxplay.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.tgg.cxplay.log.Log;
import com.tgg.cxplay.log.LogFactoryUtil;

public class MD5Util {

    public static String getMD5(String string) {
        // Transform string to byte array.
        byte[] inputByte = string.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(inputByte);
            return byteArrayToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            log.error("[Can Not Get MD5 Iinstance.]" + e);
        }
        return null;
    }

    public static String getMD5(File file) throws FileNotFoundException {
        int bufferSize = 256 * 1024;

        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream = null;

        try {
            // Use file as input stream.
            fileInputStream = new FileInputStream(file);

            // get MD5 instance from java MessageDigest.
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // Use DigestInputStream to update MessageDigest.
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);

            // Read file and update MessageDigest.
            byte[] buffer = new byte[bufferSize];
            while(digestInputStream.read(buffer) > 0);

            // Get final MessageDigest from DigestInputStream.
            messageDigest = digestInputStream.getMessageDigest();
            digestInputStream.close();

            // Process byte[] to MD5 String.
            return byteArrayToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            log.error("[Can Not Get MD5 Iinstance.]" + e);
        } catch (FileNotFoundException e) {
            log.error(e);
            throw e;
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }

    /**
     * @description Transform byte array to 16 hexadecimal characters.
     * @param byteArray[]
     * @return String
     * @author Jerry Teng
     */
    public static String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] resultCharArray =new char[byteArray.length * 2];

        int index = 0;  
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }

        return new String(resultCharArray);
    }

    private static final Log log = LogFactoryUtil.getLog(MD5Util.class);

}
