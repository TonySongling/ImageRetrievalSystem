package com.hbd.retrieval.search.domain;

import com.hbd.retrieval.data.domain.ImageStrc;
/**
 * �����������
 * @author Edward
 *
 */
public class RetrievalResult {
	//�������ͼƬ�ṹ
	private ImageStrc imageStrc;
	//���ƶ�
	private int similarity;
	//��Ӧ�ü�ͼƬ��URL
	private String cropImgUrl;

	public ImageStrc getImageStrc() {
		return imageStrc;
	}

	public void setImageStrc(ImageStrc imageStrc) {
		this.imageStrc = imageStrc;
	}

	public int getSimilarity() {
		return similarity;
	}

	public void setSimilarity(int similarity) {
		this.similarity = similarity;
	}

	public String getCropImgUrl() {
		return cropImgUrl;
	}

	public void setCropImgUrl(String cropImgUrl) {
		this.cropImgUrl = cropImgUrl;
	}
}
