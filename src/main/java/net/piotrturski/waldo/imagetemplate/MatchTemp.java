package net.piotrturski.waldo.imagetemplate;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Point;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.WINDOW_AUTOSIZE;
import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_highgui.namedWindow;
import static org.bytedeco.javacpp.opencv_imgcodecs.IMREAD_COLOR;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.TM_CCOEFF_NORMED;
import static org.bytedeco.javacpp.opencv_imgproc.matchTemplate;

public class MatchTemp {

    public static void match(String img, String temp) {
        Mat image = imread(img, IMREAD_COLOR);
        String image_window = "original";
//        namedWindow( image_window, WINDOW_AUTOSIZE );
//        imshow(image_window, image);

        Mat template = imread(temp, IMREAD_COLOR);

        byte b = template.ptr(6, 7).get();

        Mat result = new Mat(image.rows() - template.rows() + 1, image.cols() - template.cols() + 1, CV_32FC1);
        matchTemplate(image, template, result, TM_CCOEFF_NORMED);

        Mat normalizedResult = new Mat();
        normalize(result, normalizedResult, 0, 1, NORM_MINMAX, -1, new Mat());
//        normalizedResult = result;

        DoublePointer maxVal = new DoublePointer();
        DoublePointer minVal = new DoublePointer();
        Point minLoc = new Point();
        Point maxLoc = new Point();
        minMaxLoc(normalizedResult, minVal, maxVal, minLoc, maxLoc, null);
        System.out.println("min: "+minLoc.x()+", "+minLoc.y());
        System.out.println("max: "+maxLoc.x()+", "+maxLoc.y());

        System.out.println(3);



    }
}
