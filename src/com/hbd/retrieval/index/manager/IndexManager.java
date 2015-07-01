package com.hbd.retrieval.index.manager;

import java.util.Map;

public interface IndexManager {
	/**
	 * ��indexPathĿ¼�½�������
	 * @param allSegImgMap	����ͼ��ṹidΪkey����Ӧ�ָ�ͼƬurlΪvalue
	 * @param indexPath	����������Ŀ¼
	 */
	public void createIndex(Map<String, String> allSegImgMap, String indexPath);
}
