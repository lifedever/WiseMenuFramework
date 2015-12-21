package io.github.gefangshuai.utils;

import org.apache.commons.lang3.StringUtils;
import org.im4java.core.ConvertCmd;
import org.im4java.core.GMOperation;
import org.im4java.core.IM4JavaException;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by gefangshuai on 2015/11/12.
 */
public class ImageUtils {

    /**
     * 图片剪裁
     */
    public static String cutImage(InputStream inputStream, String targetPath, int x, int y, int width, int height) throws IOException {

        String format = targetPath.substring(targetPath.lastIndexOf(".") + 1, targetPath.length());
        BufferedImage image = ImageIO.read(inputStream);
        image = image.getSubimage(x, y, width, height);
        ImageIO.write(image, format, new File(targetPath));
        return targetPath;
    }

    /**
     * 将图片转换成base64格式进行存储
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

    /**
     * 图片压缩
     */
    public static void compress(String graphicsMagickHome,String sourcePath, String targetPath) throws InterruptedException, IOException, IM4JavaException {
        compress(graphicsMagickHome, sourcePath, targetPath, null);
    }

    /**
     * 图片压缩
     */
    public static void compress(String graphicsMagickHome,String sourcePath, String targetPath, String widthAndHeight) throws InterruptedException, IOException, IM4JavaException {
        GMOperation op = new GMOperation();
        //待处理图片的绝对路径
        op.addImage(sourcePath);
        //图片压缩比，有效值范围是0.0-100.0，数值越大，缩略图越清晰  s
        op.quality(30.0);
        //width 和height可以是原图的尺寸，也可以是按比例处理后的尺寸
//        op.addRawArgs("-resize", "100");
        //宽高都为100
        if(StringUtils.isNotBlank(widthAndHeight))
            op.addRawArgs("-resize", widthAndHeight);
        op.addRawArgs("-gravity", "center");
        //op.resize(100, null);
        //处理后图片的绝对路径
        File smallFile = new File(targetPath);
        if (!smallFile.getParentFile().exists()) {
            smallFile.mkdir();
        }
        op.addImage(targetPath);

        // 如果使用ImageMagick，设为false,使用GraphicsMagick，就设为true，默认为false
        ConvertCmd convert = new ConvertCmd(true);
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            //linux下不要设置此值，不然会报错
            convert.setSearchPath(graphicsMagickHome);
        }
        convert.run(op);
    }
}
