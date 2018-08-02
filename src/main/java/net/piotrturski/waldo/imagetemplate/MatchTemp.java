package net.piotrturski.waldo.imagetemplate;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Point;

import static org.bytedeco.javacpp.opencv_core.CV_32FC1;
import static org.bytedeco.javacpp.opencv_core.NORM_MINMAX;
import static org.bytedeco.javacpp.opencv_core.minMaxLoc;
import static org.bytedeco.javacpp.opencv_core.normalize;
import static org.bytedeco.javacpp.opencv_imgcodecs.IMREAD_COLOR;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.TM_CCOEFF_NORMED;
import static org.bytedeco.javacpp.opencv_imgproc.matchTemplate;

public class MatchTemp {

    public static void match(String img, String temp) {

        Mat image = imread(img, IMREAD_COLOR);
        Mat template = imread(temp, IMREAD_COLOR);

        int resultRows = image.rows() - template.rows() + 1;
        int resultCols = image.cols() - template.cols() + 1;
        Mat result = new Mat(resultRows, resultCols, CV_32FC1);

        matchTemplate(image, template, result, TM_CCOEFF_NORMED);

        Mat normalizedResult = new Mat();
        normalize(result, normalizedResult, 0, 1, NORM_MINMAX, -1, new Mat());

        DoublePointer maxVal = new DoublePointer();
        DoublePointer minVal = new DoublePointer();
        Point minLoc = new Point();
        Point maxLoc = new Point();

        minMaxLoc(normalizedResult, minVal, maxVal, minLoc, maxLoc, null);

        System.out.println("min: "+minLoc.x()+", "+minLoc.y());
        System.out.println("max: "+maxLoc.x()+", "+maxLoc.y());

        minVal.get(); // this throws exception
        maxVal.get(); // this throws exception
    }
}
