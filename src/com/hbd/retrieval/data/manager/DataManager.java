package com.hbd.retrieval.data.manager;

import java.util.List;
import java.util.Map;

import com.hbd.retrieval.data.domain.Disease;
import com.hbd.retrieval.data.domain.ImageStrc;
import com.hbd.retrieval.search.domain.RetrievalResult;

public interface DataManager {
	/**
	 * ��ȡ����ͼƬ
	 * @return	����ͼƬ�����б�
	 */
	public List<ImageStrc> getAllImages();
	
	/**
	 * ����id����ĳ��ͼƬ�����������Ϣ
	 * @param id
	 * @return	ͼƬ�ṹ����
	 */
	public ImageStrc getImageById(String id);
	
	/**
	 * �����ȡnum��ͼƬ�ṹ
	 * @return num��ͼƬ�ṹ
	 */
	public List<ImageStrc> getShowImagesRandomly(int num);
	
	/**
	 * ����ͼƬid��ȡ��������
	 * @param id
	 * @return ��������
	 */
	public Disease getDiseaseById(String id);
	
	/**
	 * �������зָ�ͼƬ��map,����key:ImageStrc.id; value:segImgUrl
	 * @return ����map����
	 */
	public Map<String, String> getAllSegImgMap();
	
	/**
	 * ��ѯ��ͼ�����Ƶ�num��ͼ��
	 * @param imageStrcId	ͼƬ�ṹ��id
	 * @param diseaseId		������id
	 * @param num	����ͼ��ĸ���
	 * @return	����ͼ��URL����
	 */
	
	/**
	 * ���ݼ���Id�������ڸü����µ����е�ImageStrc
	 * @param diseaseId ����Id
	 */
	public List<ImageStrc> getDisesesListById(String diseaseId);
	
	
	/**
	 * ���ݼ���Id, ����num������ͬһ�ּ����Ĳü����ͼƬurl
	 * @param diseaseId
	 * @param num
	 * @return
	 */
	public String[] getSimilarImgUrls(String diseaseId, int num);
	
	/**
	 * ����imageStrc�б��ȡ��Ӧ�ü�ͼƬ��URL
	 * @param imagesList
	 * @return
	 */
	public String[] getImagesUrlArr(List<ImageStrc> imagesList);
	
	
	/**
	 * ��ȡ���м���ͼƬ�����Ӧ�����ļ������
	 * @param resultList	�����ṹ�б�
	 * @return	�����������
	 */
	public String[] getDescContent(List<RetrievalResult> resultList);
}
