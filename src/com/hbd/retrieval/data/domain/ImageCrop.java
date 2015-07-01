package com.hbd.retrieval.data.domain;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * ��òü�ͼƬ����Ϣ����ȡid  file->mongo_grid_f_s_file->file->_id->$id
 * @author sunyinhui
 *
 */
public class ImageCrop {
	private String pathIdCrop;
	/**
	 * �Ѵ�������cropJsonObj�����������ݣ�ͨ�����캯��������cropJsonObj���󣬲ü�ͼƬ����Ϣ��
	 * @param cropJsonObj  json��image_files�����е�crop�ĵ���Ϣ��
	 * @throws JSONException
	 */
	public ImageCrop(JSONObject cropJsonObj) throws JSONException{
		this.pathIdCrop = cropJsonObj.getJSONObject("file").getJSONObject("mongo_grid_f_s_file").getJSONObject("file").getJSONObject("_id").getString("$id");
	}
	/**
	 * ��òü�ͼƬ��·��id
	 * @return
	 */
	public String getPathIdCrop() {
		return pathIdCrop;
	}
	/**
	 * ���òü�ͼƬ��·��id
	 * @param pathIdCrop
	 */
	public void setPathIdCrop(String pathIdCrop) {
		this.pathIdCrop = pathIdCrop;
	}
}
