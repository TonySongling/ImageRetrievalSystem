package com.hbd.retrieval.common.domain;
/**
 * �洢������Դ��Ŀ¼
 * @author Edward
 *
 */
public class ImgResourcePath {
	//��Դ��Ŀ¼
	private String imgDataPath;
	//�����ļ�Ŀ¼
	private String indexPath;
	//�洢ԭͼĿ¼
	private String uploadSrcPath;
	//�洢�ü�ͼƬĿ¼
	private String uploadCropPath;
	//�洢�ָ�ͼƬĿ¼
	private String uploadSegPath;
	//��ʱ�ļ�Ŀ¼
	private String tempImgPath;
	//��ȡ��Դ��Ŀ¼
	public String getImgDataPath() {
		return imgDataPath;
	}
	//������Դ��Ŀ¼
	public void setImgDataPath(String imgDataPath) {
		this.imgDataPath = imgDataPath;
	}
	//��ȡ�����ļ�Ŀ¼
	public String getIndexPath() {
		return indexPath;
	}
	//���������ļ�Ŀ¼
	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}
	//��ȡ�洢ԭͼ�ļ�Ŀ¼
	public String getUploadSrcPath() {
		return uploadSrcPath;
	}
	//���ô洢ԭͼ�ļ�Ŀ¼
	public void setUploadSrcPath(String uploadSrcPath) {
		this.uploadSrcPath = uploadSrcPath;
	}
	//��ȡ�洢�ü�ͼƬ�ļ�Ŀ¼
	public String getUploadCropPath() {
		return uploadCropPath;
	}
	//���ô洢�ü�ͼƬ�ļ�Ŀ¼
	public void setUploadCropPath(String uploadCropPath) {
		this.uploadCropPath = uploadCropPath;
	}
	//��ȡ�洢�ָ�ͼƬ�ļ�Ŀ¼
	public String getUploadSegPath() {
		return uploadSegPath;
	}
	//���ô洢�ָ�ͼƬ�ļ�Ŀ¼
	public void setUploadSegPath(String uploadSegPath) {
		this.uploadSegPath = uploadSegPath;
	}
	//��ȡ��ʱ�ļ�Ŀ¼
	public String getTempImgPath() {
		return tempImgPath;
	}
	//������ʱ�ļ�Ŀ¼
	public void setTempImgPath(String tempImgPath) {
		this.tempImgPath = tempImgPath;
	}
}
