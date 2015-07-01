package com.hbd.retrieval.search.manager;

import java.util.List;

import com.hbd.retrieval.search.domain.RetrievalResult;


public interface SearchManager {

	/**
	 * ��ü������
	 * @param segImgPath	�ָ�ͼƬ��·��
	 * @param indexPath		�����ļ���
	 * @return	��������б�
	 */
	public List<RetrievalResult> getRetrievalResults(String segImgPath, String indexPath);
}
