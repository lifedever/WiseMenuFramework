package io.github.gefangshuai.utils;

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

}
