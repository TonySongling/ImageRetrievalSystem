package com.hbd.retrieval.data.domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * json��image_files�ĵ��н����õ�srcԭͼ��crop�ü���seg�ָ�ͼƬ����Ϣ
 * @author sunyinhui
 *
 */
public class PathsStrc {
	//ԭͼ����
	private ImageSrc imageSrc;
	//�ü�����
	private ImageCrop imageCrop;
	//�ָ����
	private ImageSeg imageSeg;

	JSONObject srcJsonObj = new JSONObject();
	JSONObject cropJsonObj = new JSONObject();
	JSONObject segJsonObj = new JSONObject();
	/**
	 * �ӵõ���imageJsonArray�����н������ݣ�ͨ�����캯������PathsStrc���󡣰���ԭͼ���ü��ͷָ��ͼƬ��Ϣ��
	 * @param imageJsonArray  :��json�ļ��е�image_files�ĵ��н����õ���JsonArray
	 * @throws JSONException
	 */
	public PathsStrc(JSONArray imageJsonArray) throws JSONException {
		for (int indexNum = 0; indexNum < imageJsonArray.length(); indexNum++) {
			JSONObject filesJsonObj = imageJsonArray.getJSONObject(indexNum);
			String type = filesJsonObj.getString("type");

			if (type.equals("src")) {
				srcJsonObj = filesJsonObj;
			}
			if (filesJsonObj.getString("type").equals("crop")) {
				cropJsonObj = filesJsonObj;
			}

			if (filesJsonObj.getString("type").equals("seg")) {
				segJsonObj = filesJsonObj;
			}
		}
		//����Ӧ��src��crop��seg�ֶβ�����ʱ��toString()��"{}"��ȡ�
		//������{}ʱ���ٰ���Ӧ��json����Ϊ��Ӧ�Ķ���(������Ӧ�Ĺ��캯��)
		if (!srcJsonObj.toString().equals("{}")) {
			this.imageSrc = new ImageSrc(srcJsonObj);
		}
		if (!cropJsonObj.toString().equals("{}")) {
			this.imageCrop = new ImageCrop(cropJsonObj);
		}
		if (!segJsonObj.toString().equals("{}")) {
			this.imageSeg = new ImageSeg(segJsonObj);
		}
	}
	/**
	 * ��ñ�ʾԭͼImageSrc����
	 * @return
	 */
	//��Ϊ�գ���Ϊnull
	public ImageSrc getImageSrc() {
		if (!srcJsonObj.toString().equals("{}")) {
			return imageSrc;
		}
		return null;
	}
	/**
	 * ����ԭͼ����
	 * @param imageSrc
	 */
	public void setImageSrc(ImageSrc imageSrc) {
		this.imageSrc = imageSrc;
	}
	/**
	 * ��ñ�ʾ�ü�ͼƬImageCrop����
	 * @return
	 */
	public ImageCrop getImageCrop() {
		if (!cropJsonObj.toString().equals("{}")) {
			return imageCrop;
		}
		return null;
	}
	/**
	 * ���òü�����
	 * @param imageCrop
	 */
	public void setImageCrop(ImageCrop imageCrop) {
		this.imageCrop = imageCrop;
	}
	/**
	 * ��ñ�ʾ�ָ�ͼƬImageSeg����
	 * @return
	 */
	public ImageSeg getImageSeg() {
		if (!segJsonObj.toString().equals("{}")) {
			return imageSeg;
		}
		return null;
	}
	/**
	 *���÷ָ����
	 * @param imageSeg
	 */
	public void setImageSeg(ImageSeg imageSeg) {
		this.imageSeg = imageSeg;
	}
}
