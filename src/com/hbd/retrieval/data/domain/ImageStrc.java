package com.hbd.retrieval.data.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * ��ȡ���ڵ����Ϣ,��Ӧjson�����е�Ԫ�ء�
 * 
 * @author sunyinhui
 *
 */
public class ImageStrc {
	private String id;
	//ͼ���������
	private PathsStrc pathsStrc;
	//����
	private Disease disease;
	//�Ƿ�ü�
	private boolean cropped;
	//��λ
	private int location;
	//����ʱ��
	private Date createdTime;
	//����ʱ��
	private Date updatedTime;
	//״̬
	private int state;
	/**
	 * �ӻ�ȡ��rootJsonObj�н��������ݣ�ͨ�����캯������ImageStrc����
	 * @param rootJsonObj   json�����е�Ԫ��(�ĵ�)
	 * @throws JSONException
	 * @throws ParseException
	 */
	public ImageStrc(JSONObject rootJsonObj) throws JSONException, ParseException{
		if(!rootJsonObj.isNull("id")){
			this.id = rootJsonObj.getString("id");
		}
		if(!rootJsonObj.isNull("disease")){
			this.disease = new Disease(rootJsonObj.getJSONObject("disease"));
		}
		if(!rootJsonObj.isNull("cropped")){
			this.cropped = rootJsonObj.getBoolean("cropped");
		}
		if(!rootJsonObj.isNull("location")){
			this.location = rootJsonObj.getInt("location");
		}
		if(!rootJsonObj.isNull("created_at")){
			this.createdTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(rootJsonObj.getString("created_at").replace("Z", "+0800"));
		}
		if(!rootJsonObj.isNull("updated_at")){
			this.updatedTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(rootJsonObj.getString("updated_at").replace("Z", "+0800"));;
		}
		if(!rootJsonObj.isNull("state")){
			this.state  = rootJsonObj.getInt("state");
		}
		if(!rootJsonObj.isNull("image_files")){
			this.pathsStrc =new PathsStrc(rootJsonObj.getJSONArray("image_files"));
		}
	}
	/**
	 * ���id
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * ����id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * ���PathsStrc���󣬰���ImageSrc��ImageCrop��ImageSeg����
	 * @return
	 */
	public PathsStrc getPathsStrc() {
		return pathsStrc;
	}
	/**
	 * ����PathStrc����
	 * @param pathsStrc
	 */
	public void setPathsStrc(PathsStrc pathsStrc) {
		this.pathsStrc = pathsStrc;
	}
	/**
	 * ��ü�������
	 * @return
	 */
	public Disease getDisease() {
		return disease;
	}
	/**
	 * ���ü�������
	 * @param disease
	 */
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	//�ж��Ƿ�ü���
	public boolean isCropped() {
		return cropped;
	}
	/**
	 * ���òü���ʶ
	 * @param cropped
	 */
	public void setCropped(boolean cropped) {
		this.cropped = cropped;
	}
	/**
	 * ȡ��λ����Ϣ
	 * @return
	 */
	public int getLocation() {
		return location;
	}
	/**
	 * ����λ����Ϣ
	 * @param location
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	/**
	 * ��ô���ʱ��
	 * @return
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * ���ô���ʱ��
	 * @param createdTime
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * ȡ�ø���ʱ��
	 * @return
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
	/**
	 * ���ø���ʱ��
	 * @param updatedTime
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	/**
	 * ���״̬
	 * @return
	 */
	public int getState() {
		return state;
	}
	/**
	 * ����״̬
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}
}
