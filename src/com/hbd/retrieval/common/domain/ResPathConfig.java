package com.hbd.retrieval.common.domain;
/**
 * �洢resPath-config.xml����Ϣ���洢��Դ�ļ�������
 * @author Edward
 *
 */
public class ResPathConfig {
	//��Ŀ����
	private String projectName;
	//��Դ�ļ�����
	private String imgData;
	//�����ļ�����
	private String indexPath;
	//ԭͼ���ļ�����
	private String uploadSrcPath;
	//�ü�ͼ���ļ�����
	private String uploadCropPath;
	//�ָ�ͼ���ļ�����
	private String uploadSegPath;
	//��ʱ�ļ�����
	private String tempImgPath;
	//��ȡ��Ŀ����
	public String getProjectName() {
		return projectName;
	}
	//������Ŀ����
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	//��ȡ��Դ�ļ�����
	public String getImgData() {
		return imgData;
	}
	//������Դ�ļ�����
	public void setImgData(String imgData) {
		this.imgData = imgData;
	}
	//��ȡ�����ļ�����
	public String getIndexPath() {
		return indexPath;
	}
	//���������ļ�����
	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}
	//��ȡԭͼ���ļ�����
	public String getUploadSrcPath() {
		return uploadSrcPath;
	}
	//����ԭͼ���ļ�����
	public void setUploadSrcPath(String uploadSrcPath) {
		this.uploadSrcPath = uploadSrcPath;
	}
	//��ȡ�ü�ͼ���ļ�����
	public String getUploadCropPath() {
		return uploadCropPath;
	}
	//���òü�ͼ���ļ�����
	public void setUploadCropPath(String uploadCropPath) {
		this.uploadCropPath = uploadCropPath;
	}
	//��ȡ�ָ�ͼ���ļ�����
	public String getUploadSegPath() {
		return uploadSegPath;
	}
	//���÷ָ�ͼ���ļ�����
	public void setUploadSegPath(String uploadSegPath) {
		this.uploadSegPath = uploadSegPath;
	}
	//��ȡ��ʱ�ļ�����
	public String getTempImgPath() {
		return tempImgPath;
	}
	//������ʱ�ļ�����
	public void setTempImgPath(String tempImgPath) {
		this.tempImgPath = tempImgPath;
	}
}
