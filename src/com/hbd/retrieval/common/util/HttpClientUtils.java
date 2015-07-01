package com.hbd.retrieval.common.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.hbd.retrieval.common.domain.DataServerConfig;
/**
 * ����ͼƬ���ݿ�API������
 * @author Edward
 *
 */
public class HttpClientUtils {
	/**
	 * ����ͼ�����ݿ�API����json�����ַ���
	 * @param apiStr	API�ַ���
	 * @return	json�����ַ���
	 */
	
	public static String getJsonStr(String apiStr){
		String jsonStr = null;
		//����HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		//����HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		
		DataServerConfig config = ConfigManager.getDataServerConfig();
		HttpGet httpGet = new HttpGet(config.getServerUrl() + apiStr + config.getFormat());
		httpGet.setHeader("Authorization", config.getAuthorization());
		
		try {
			//ִ��get����
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			//��ȡ��Ӧ��Ϣʵ��
			HttpEntity entity = httpResponse.getEntity();
			//��ȡ״̬��
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			//�ж���Ӧʵ���Ƿ�Ϊ��
			if(statusCode == 200 && entity != null){
				jsonStr = EntityUtils.toString(entity);
			}else{
				throw new ApplicationException("connect dataServer error");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//�ر������ͷ���Դ
			try {
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonStr;
	}
}
