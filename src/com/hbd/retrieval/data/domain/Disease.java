package com.hbd.retrieval.data.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * ����йؼ�������Ϣ
 * @author sunyinhui
 *
 */
public class Disease {
	private String id;
	
	private Date createdTime;
	
	private Date updatedTime;
	
	//��������
	private String name;
	
	//�������
	private String desc;
	
	//����
	private String etiology;
	
	//֢״
	private String symptom;
	
	//Ԥ��
	private String prevent;
	
	//����
	private String identify;
	
	//����֢
	private String complication;
	
	//���Ʒ���
	private String therapies;
	
	
	/**
	 * �ӻ�õ�diseaseJsonObj�����õ������ݣ�ͨ�����캯������Disease���󡣼�������Ϣ
	 * @param diseaseJsonObj  ���ݿ�json�ļ��е�disease�ĵ���
	 * @throws JSONException
	 * @throws ParseException
	 */
	public Disease(JSONObject diseaseJsonObj) throws JSONException, ParseException{
		if(!diseaseJsonObj.isNull("id")){
			this.id = diseaseJsonObj.getString("id");
		}
		
		
		if(!diseaseJsonObj.isNull("created_at")){
			this.createdTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(diseaseJsonObj.getString("created_at").replace("Z", "+0800"));
		}
		if(!diseaseJsonObj.isNull("updated_at")){
			this.updatedTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(diseaseJsonObj.getString("updated_at").replace("Z", "+0800"));
		}
		
		//��Ҫ�п�
		if(!diseaseJsonObj.isNull("name")){
			this.name = diseaseJsonObj.getString("name");
		}
		
		if(!diseaseJsonObj.isNull("desc")){
			this.desc = diseaseJsonObj.getString("desc");
		}
		
		
		if(!diseaseJsonObj.isNull("etiology")){
			this.etiology = diseaseJsonObj.getString("etiology");
		}
		
		if(!diseaseJsonObj.isNull("symptom")){
			this.symptom = diseaseJsonObj.getString("symptom");
		}
		
		if(!diseaseJsonObj.isNull("prevent")){
			this.prevent = diseaseJsonObj.getString("prevent");
		}
		
		if(!diseaseJsonObj.isNull("identify")){
			this.identify = diseaseJsonObj.getString("identify");
		}
		
		
		if(!diseaseJsonObj.isNull("complication")){
			this.complication = diseaseJsonObj.getString("complication");
		}
		
		
		if(!diseaseJsonObj.isNull("therapies")){
			this.therapies = diseaseJsonObj.getString("therapies");
		}
	
	}

    /**
     * �õ�����id
     * @return id 
     */
	public String getId() {
		return id;
	}

	/**
	 * ���ü���id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * ��ô���������
     * @return  createdTime
     */
	public Date getCreatedTime() {
		return createdTime;
	}


	/**
	 * ���ô���������
	 * @param createdTime
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	/**
	 * ��ø��µ�ʱ��
	 * @return updatedTime
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}


	/**
	 * ���ø��µ�����
	 * @param updatedTime
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}


	/**
	 * ��ü�������
	 * @return  name ��������
	 */
	public String getName() {
		return name;
	}


	/**
	 * ���ü�������
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * ���ü������
	 * @return desc �������
	 */
	public String getDesc() {
		return desc;
	}


	/**
	 * ���ü������
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}


	/**
	 * ��ü�������
	 * @return  etiology
	 */
	public String getEtiology() {
		return etiology;
	}


	/**
	 * ���ü�������
	 * @param etiology
	 */
	public void setEtiology(String etiology) {
		this.etiology = etiology;
	}


	/**
	 * ��ü���֢״ 
	 * @return  symptom  ֢״
	 */
	public String getSymptom() {
		return symptom;
	}


	/**
	 * ���ü���֢״
	 * @param symptom
	 */
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}


	/**
	 * ���Ԥ����������
	 * @return
	 */
	public String getPrevent() {
		return prevent;
	}


	/**
	 * ����Ԥ����������
	 * @param prevent
	 */
	public void setPrevent(String prevent) {
		this.prevent = prevent;
	}


	/**
	 * ��ô��׻켲���м������������������
	 * @return
	 */
	public String getIdentify() {
		return identify;
	}


	/**
	 * ���ü����ļ�������
	 * @param identify
	 */
	public void setIdentify(String identify) {
		this.identify = identify;
	}


	/**
	 * ��ü����Ĳ���֢����
	 * @return
	 */
	public String getComplication() {
		return complication;
	}


	/**
	 * ���ü����Ĳ�������
	 * @param complication
	 */
	public void setComplication(String complication) {
		this.complication = complication;
	}


	/**
	 * ��ü��������Ʒ���
	 * @return
	 */
	public String getTherapies() {
		return therapies;
	}


	/**
	 * ���ü��������Ʒ���
	 * @param therapies
	 */
	public void setTherapies(String therapies) {
		this.therapies = therapies;
	}
	

	
}
