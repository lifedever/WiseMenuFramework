package io.github.gefangshuai.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件存储工具类
 * Created by gefangshuai on 2015/11/10.
 */
public class StoreUtils {

    /**
     * 保存文件，并且返回相对路径
     */
    public static String storeFile(String rootDir, String extension, InputStream inputStream) throws IOException {
        rootDir = rootDir.endsWith("/") ? StringUtils.chop(rootDir) : rootDir;
        String relativePath = "/" + getShortPath() + "/" + System.nanoTime() + extension;
        String filePath = rootDir + relativePath;
        File storeFile = new File(filePath);
        if(!storeFile.getParentFile().exists())
            storeFile.getParentFile().mkdirs();
        IOUtils.copyLarge(inputStream, new FileOutputStream(filePath));
        return relativePath;
    }

    /**
     * 根据文件名称，获取后缀，如：".jpq",".png",
     */
    public static String getExtension(String fileName){
        return StringUtils.substring(fileName, fileName.lastIndexOf("."));
    }

    private static String getShortPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getShortPath());
    }
}
