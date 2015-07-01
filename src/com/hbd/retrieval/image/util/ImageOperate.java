package com.hbd.retrieval.image.util;

import com.hbd.retrieval.search.domain.ImageInfo;
/**
 * ͼ�������
 * @author Edward
 *
 */
public interface ImageOperate {
	
	/**
	 * ����imageInfo��Ϣ���вü�ͼ�񣬲����䱣����uploadCropPath
	 * @param srcImgPath ԭͼ��·������ͨ��opencv����
	 * @param imageInfo		ԭͼ���һЩ��Ϣ�������Ͻǡ����½���ߡ�������Ϣ
	 * @param uploadCropPath	����ü�ͼ���Ŀ¼
	 * @return	���طָ�ͼ���·��
	 */
	public String getCropImgPath(String srcImgPath, ImageInfo imageInfo, String uploadCropPath);
	
	
	/**
	 * �Էָ��ͼ����зָ�������������ͼ�񱣴浽uploadSegPathĿ¼��
	 * @param cropImgPath	�ü���ͼ���·��
	 * @param uploadSegPath		����ָ�ͼ���·��
	 * @return	���طָ��ͼ���·��
	 */
	public String getSegImgPath(String cropImgPath, String uploadSegPath);
	
}
