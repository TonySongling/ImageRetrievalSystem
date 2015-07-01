package com.hbd.retrieval.data.domain;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * ��ȡԭͼ��Ϣid   file->mongo_grid_f_s_file->file->_id->$id
 * @author sunyinhui
 *
 */
public class ImageSrc {
	
	private String pathIdSrc;
	/**
	 * �Ѵ�������srcJsonObj�����������ݣ�ͨ�����캯������ImageSrc,ԭͼ����Ϣ��
	 * @param srcJsonObj
	 * @throws JSONException
	 */
	public ImageSrc(JSONObject srcJsonObj) throws JSONException{
		this.pathIdSrc = srcJsonObj.getJSONObject("file").getJSONObject("mongo_grid_f_s_file").getJSONObject("file").getJSONObject("_id").getString("$id");
	}
	/**
	 * ���ԭͼ��·��id
	 * @return
	 */
	public String getPathIdSrc() {
		return pathIdSrc;
	}
	/**
	 * ����ԭͼ��·��id
	 * @param pathIdSrc
	 */
	public void setPathIdSrc(String pathIdSrc) {
		this.pathIdSrc = pathIdSrc;
	}

}
