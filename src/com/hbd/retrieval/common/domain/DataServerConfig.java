package com.hbd.retrieval.common.domain;
/**
 * ������������Ϣ
 * @author Edward
 *
 */
public class DataServerConfig {
	//��������ַ
	private String serverUrl;
	//��������
	private String authorization;
	//���ؽ����ʽ
	private String format;
	//��ȡ��������ַ
	public String getServerUrl() {
		return serverUrl;
	}
	//���÷�������ַ
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	//��ȡ����
	public String getAuthorization() {
		return authorization;
	}
	//��������
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	//��ȡ���ؽ����ʽ
	public String getFormat() {
		return format;
	}
	//���÷��ؽ����ʽ
	public void setFormat(String format) {
		this.format = format;
	}
}
