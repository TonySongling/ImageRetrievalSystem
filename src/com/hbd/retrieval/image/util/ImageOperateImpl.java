package com.hbd.retrieval.image.util;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import com.hbd.retrieval.common.util.DllLoaderUtils;
import com.hbd.retrieval.search.domain.ImageInfo;

public class ImageOperateImpl implements ImageOperate {

	public String getCropImgPath(String srcImgPath, ImageInfo imageInfo,
			String uploadCropPath) {
		String srcPath = srcImgPath.replaceAll("\\\\", "/");

		String srcName = srcImgPath.substring(srcPath.lastIndexOf("/") + 1);

		DllLoaderUtils.loadDllFile("opencv_java248.dll");
		Mat image = null;
		image = Highgui.imread(srcPath);

		Point leftTop = new Point(imageInfo.getLeftTopX(), imageInfo
				.getLeftTopY());
		Point rightBottom = new Point(imageInfo.getRightBottomX(), imageInfo
				.getRightBottomY());

		Rect cropRect = new Rect(leftTop, rightBottom);
		Mat ROI = image.submat(cropRect);

		String cropName = srcName.replaceAll("src", "crop");

		String cropPath = uploadCropPath + cropName;

		Highgui.imwrite(cropPath, ROI);

		return cropPath;
	}

	public String getSegImgPath(String cropImgPath, String uploadSegPath) {
		String cropPath = cropImgPath;
		
		DllLoaderUtils.loadDllFile("opencv_java248.dll");
		Mat img = null;
		img = Highgui.imread(cropPath);

		Point tl = new Point(img.width() / 6, img.height() / 6);
		Point br = new Point(5 * img.width() / 6, 5 * img.height() / 6);

		Mat result = new Mat();
		Mat bgModel = new Mat();
		Mat fgModel = new Mat();

		Mat source = new Mat(1, 1, CvType.CV_8U, new Scalar(3.0));
		Rect rect = new Rect(tl, br);

		Imgproc.grabCut(img, result, rect, bgModel, fgModel, 1, 0);
		Core.compare(result, source, result, Core.CMP_EQ);
		Mat foreground = new Mat(img.size(), CvType.CV_8UC3,
				new Scalar(0, 0, 0));

		img.copyTo(foreground, result);

		String cropName = cropPath.substring(cropPath.lastIndexOf("\\") + 1);
		String segName = cropName.replace("crop", "seg");
		String segPath = uploadSegPath + segName;

		Highgui.imwrite(segPath, foreground);

		return segPath;
	}
}
