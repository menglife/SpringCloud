package com.zmn.springcloud.video;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoUtil {
    public static File frameRecord(String filePath,File video, String picPath) throws FrameGrabber.Exception {
        boolean isStart =true;
        FFmpegFrameGrabber fFmpegFrameGrabber=new FFmpegFrameGrabber(filePath);

        return recordByFrame(fFmpegFrameGrabber,isStart);
    }
    private static File recordByFrame(FFmpegFrameGrabber ff,Boolean status) throws FrameGrabber.Exception {
        ff.start();
        Frame frame = null;
        while (status && (frame = ff.grabFrame()) !=null){
         if (frame !=null&& frame.image !=null){
             Long time=System.currentTimeMillis();
             return writeToFile(frame,time);
         }
        }

        ff.stop();
        return  null;
    }
    private  static  File writeToFile(Frame frame,Long second){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String times = format.format(new Date(second * 1000L));
        File targetFile = new File("D:\\file\\images\\"+ second+ ".jpg"); //存放截取到的图片
        String imgSuffix = "jpg";
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage srcBi = converter.getBufferedImage(frame);
        int owidth = srcBi.getWidth();
        int oheight = srcBi.getHeight();
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(srcBi.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        try {
            ImageIO.write(bi, imgSuffix, targetFile);
            return targetFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    public static void main(String[] args) throws FrameGrabber.Exception {
        String inputFile = "D:\\file\\video\\ppt.mp4";  //被截取视频地址
        frameRecord(inputFile,null,null);
    }

}
