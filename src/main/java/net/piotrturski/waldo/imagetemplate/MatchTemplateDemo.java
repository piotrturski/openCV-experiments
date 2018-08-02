package net.piotrturski.waldo.imagetemplate;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.bytedeco.javacpp.opencv_core;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MatchTemplateDemo {
    public static void main(String[] args) throws InterruptedException {
        // load the native OpenCV library
        System.out.println(System.getProperties());
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        new opencv_core.Mat().cop;
//        new Mat().cop;
        // run code
//        MatchTemp.match(args[0], args[1]);
//        MatchTemp.match("/tmp/docker/koala1.jpg", "/tmp/docker/koala3.jpg");
        MatchTemp.match("/tmp/docker/Template_Matching_Original_Image.jpg", "/tmp/docker/koala3.jpg");
//        new MatchTemplateDemoRun().run(args);
        Thread.sleep(5000);
    }
}

