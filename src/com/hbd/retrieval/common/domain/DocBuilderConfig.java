package com.hbd.retrieval.common.domain;
/**
 * ����������Ϣ
 * @author Edward
 *
 */
public class DocBuilderConfig {
	//������
	private String builderName;
	//����Ȩ��
	private float weight;
	//��ȡ������
	public String getBuilderName() {
		return builderName;
	}
	//������֤��
	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}
	//��ȡȨ��
	public float getWeight() {
		return weight;
	}
	//����Ȩ��
	public void setWeight(float weight) {
		this.weight = weight;
	}

}
