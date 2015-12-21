package io.github.gefangshuai.utils;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.util.ThumbnailatorUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.im4java.core.IM4JavaException;
import org.jboss.jandex.Main;

import javax.servlet.http.HttpServletRequest;
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
        String relativePath = getRelativePath(extension);
        String filePath = rootDir + relativePath;
        File storeFile = new File(filePath);
        if (!storeFile.getParentFile().exists())
            storeFile.getParentFile().mkdirs();
        IOUtils.copyLarge(inputStream, new FileOutputStream(filePath));
        return relativePath;
    }

    private static String getFilePath(String rootDir, String relativePath) {
        rootDir = rootDir.endsWith("/") ? StringUtils.chop(rootDir) : rootDir;
        String filePath = rootDir + relativePath;
        File storeFile = new File(filePath);
        if (!storeFile.getParentFile().exists())
            storeFile.getParentFile().mkdirs();
        return filePath;
    }

    /**
     * 保存裁剪的数据
     */
    public static String storeCutFile(String rootDir, String extension, InputStream inputStream, int xText, int yText, int widthText, int heightText) throws IOException {
        String relativePath = getRelativePath(extension);
        String filePath = getFilePath(rootDir, relativePath);
        ImageUtils.cutImage(inputStream, filePath, xText, yText, widthText, heightText);
        return relativePath;
    }

    /**
     * 保存裁剪的数据，同时生成缩略图(不压缩图片)
     */
    public static String storeCutFileWithThumb(String rootDir, String extension, InputStream inputStream,
                                               int xText, int yText, int widthText, int heightText, int thumbWidth, int thumbHeight) throws IOException {
        String relativePath = getRelativePath(extension);
        String filePath = getFilePath(rootDir, relativePath);
        ImageUtils.cutImage(inputStream, filePath, xText, yText, widthText, heightText);
        Thumbnails.of(filePath)
                .size(thumbWidth, thumbHeight)
                .toFile(getThumbPath(filePath));
        return relativePath;
    }

    /**
     * 保存裁剪的数据，同时压缩生成缩略图
     */
    public static String storeCutFileWithThumbAndCompress(String graphicsMagickHome,String rootDir, String extension, InputStream inputStream,
                                                          int xText, int yText, int widthText, int heightText, int thumbWidth, int thumbHeight) throws InterruptedException, IOException, IM4JavaException {
        String relativePath = getRelativePath(extension);
        String filePath = getFilePath(rootDir, relativePath);
        ImageUtils.cutImage(inputStream, filePath, xText, yText, widthText, heightText);
        ImageUtils.compress(graphicsMagickHome, filePath, getThumbPath(filePath), thumbWidth+"x"+thumbHeight);
        return relativePath;
    }

    public static String getThumbPath(String path) {
        String pathOne = path.substring(0, path.lastIndexOf("."));
        String pattern = path.substring(path.lastIndexOf("."));
        return pathOne + "-thumb" + pattern;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getThumbPath("ddddd.jpg"));
    }

    private static String getRelativePath(String extension) {
        String relativePath = "/" + getShortPath() + "/" + System.nanoTime() + extension;
        return relativePath;
    }


    /**
     * 根据文件名称，获取后缀，如：".jpq",".png",
     */
    public static String getExtension(String fileName) {
        return StringUtils.substring(fileName, fileName.lastIndexOf("."));
    }

    private static String getShortPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date());
    }

    /**
     * 获取web路径
     *
     * @param request
     * @return
     */
    public static String getWebRootPath(HttpServletRequest request) {
        return request.getServletContext().getRealPath("");
    }


}
