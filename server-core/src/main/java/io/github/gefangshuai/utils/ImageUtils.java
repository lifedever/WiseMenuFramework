package io.github.gefangshuai.utils;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by gefangshuai on 2015/11/12.
 */
public class ImageUtils {
    public static String cutImage(InputStream inputStream, String targetPath, int x, int y, int width, int height) throws IOException {

        String format = targetPath.substring(targetPath.lastIndexOf(".") + 1, targetPath.length());
        BufferedImage image = ImageIO.read(inputStream);
        image = image.getSubimage(x, y, width, height);
        ImageIO.write(image, format, new File(targetPath));
        return targetPath;
    }

    /**
     * 将图片转换成base64格式进行存储
     * @param imagePath
     * @return
     */
    public static String encodeToString(String imagePath) throws IOException {
        String type = StringUtils.substring(imagePath, imagePath.lastIndexOf(".") + 1);
        BufferedImage image = ImageIO.read(new File(imagePath));
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}
