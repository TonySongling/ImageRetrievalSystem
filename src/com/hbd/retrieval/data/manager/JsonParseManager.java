package com.hbd.retrieval.data.manager;

import java.util.List;

import com.hbd.retrieval.data.domain.Disease;
import com.hbd.retrieval.data.domain.ImageStrc;

public interface JsonParseManager {
	/**
	 * ����/api/images�� API��ȡ����json�����ɶ�Ӧ�Ķ����б�
	 * @param jsonStr	json�ַ���
	 * @return	ͼƬ�ṹ������б�
	 */
	public List<ImageStrc> parseJsonToImagesList(String jsonStr);
	
	/**
	 * ����/api/diseases/{id}�� API��ȡ��json�����ɶ�Ӧ��disease����
	 * @param diseaseId	����id
	 * @return	��������
	 */
	public Disease parseJsonToDisease(String diseaseId);
	
	/**
	 * ����/api/images/{id}�� API��ȡ��json�����ɶ�Ӧ��imageStrc����
	 * @param imageStrcId	ͼ��ṹid
	 * @return	ͼƬ�ṹ����
	 */
	public ImageStrc parseJsonToImageStrc(String imageStrcId);
	
	/**
	 * �����ȡnum��ͼƬ�ṹ
	 * @param jsonStr	���ʻ�ȡͼƬAPI�ķ��ص�json�ַ���
	 * @param num	�����ȡͼƬ�ĸ���
	 * @return	����ͼƬ�ṹ������б�
	 */
	public List<ImageStrc> parseJsonToImageStrcRandomly(String jsonStr, int num);
	
	/**
	 * ����json����������diseaseId ������ڸü���������ͼƬ
	 * @param jsonStr
	 * @return
	 */
	public List<ImageStrc>  parseJsonToImageStrcByDiseaseId(String jsonStr);
	
	
	
}
