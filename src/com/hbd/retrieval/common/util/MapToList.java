package com.hbd.retrieval.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hbd.retrieval.data.domain.ImageStrc;
import com.hbd.retrieval.data.manager.DataManager;
import com.hbd.retrieval.data.manager.DataManagerImpl;
import com.hbd.retrieval.search.domain.RetrievalResult;

public class MapToList {
	/**
	 * �Ѽ����õ��Ľ��Map<���ƶȣ�ͼƬ��Id>ת����List<ImageStrc> 
	 * @param resultmap:�������Ľ��Map
	 * @return retrievalResult<RetrievalResult> :RetrievalResult�������ƶȡ�ImageStrc��CropImgUrl(ǰ����ʾ����)
	 * 
	 */
	public List<RetrievalResult> mapToList(Map<Integer,String> resultmap){
		
		Map<Integer, String> resultMap = resultmap;

		List<RetrievalResult> retrievalResult = new ArrayList<RetrievalResult>();

		DataManager dataManager = new DataManagerImpl();

		for (Map.Entry<Integer, String> entry : resultMap.entrySet()) {
			int similarity = entry.getKey();
			String imageId = entry.getValue();

			ImageStrc imageStrc = dataManager.getImageById(imageId);
			String ip = ConfigManager.getDataServerConfig().getServerUrl()
					+ ":8081/images/";
			String cropImgUrl = ip
					+ imageStrc.getPathsStrc().getImageCrop().getPathIdCrop();
			RetrievalResult retrieval = new RetrievalResult();
			retrieval.setSimilarity(similarity);
			retrieval.setImageStrc(imageStrc);
			retrieval.setCropImgUrl(cropImgUrl);
			retrievalResult.add(retrieval);

		}
		return retrievalResult;
	}

}
