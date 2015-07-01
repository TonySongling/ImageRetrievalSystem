package com.hbd.retrieval.data.domain;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * ��ȡ�ָ�ͼƬ��id  file->mongo_grid_f_s_file->file->_id->$id
 * @author sunyinhui
 *
 */
public class ImageSeg {
	private String pathIdSeg;
	/**
	 * �Ѵ�������segJsonObj�����������ݣ�ͨ�����캯��������ImageSeg���󣬷ָ�ͼ�����Ϣ��
	 * @param segJsonObj  
	 * @throws JSONException
	 */
	public ImageSeg(JSONObject segJsonObj) throws JSONException{
		this.pathIdSeg = segJsonObj.getJSONObject("file").getJSONObject("mongo_grid_f_s_file").getJSONObject("file").getJSONObject("_id").getString("$id");
	}
	
	/**
	 * ��÷ָ�ͼƬ��·��id
	 * @return
	 */
	public String getPathIdSeg() {
		return pathIdSeg;
	}
	/**
	 * ���÷ָ�ͼƬ��·��id
	 * @param pathIdSeg
	 */
	public void setPathIdSeg(String pathIdSeg) {
		this.pathIdSeg = pathIdSeg;
	}
}
