package com.hbd.retrieval.common.util;

import java.util.List;

import com.hbd.retrieval.common.domain.DataServerConfig;
import com.hbd.retrieval.common.domain.DocBuilderConfig;
import com.hbd.retrieval.common.domain.ResPathConfig;

/**
 * ����ThreadLocal��װ��������������Ϣ�����ݿ������������Ϣ����Դ�ļ�����Ϣ
 * @author Edward
 *
 */
public class ConfigManager {
	private static ThreadLocal<List<DocBuilderConfig>> configHolder = new ThreadLocal <List<DocBuilderConfig>>();
	
	private static ThreadLocal<DataServerConfig> serverConfigHolder = new ThreadLocal<DataServerConfig>();
	
	private static ThreadLocal<ResPathConfig> resPathConfigHolder = new ThreadLocal<ResPathConfig>();
	
	/**
	 * ��ȡ������Ȩ��������Ϣ
	 * @return	������Ȩ����Ϣ������Ϣ�б�
	 */
	public static List<DocBuilderConfig> getConfigList(){
		List<DocBuilderConfig> configList = configHolder.get();
		//�����ǰ�س���û�а���Ӧ��Config
		if(configList == null){
			configList = XmlConfigReader.getDocBuilderConfigFromXML();
			configHolder.set(configList);
		}
		return configList;
	}
	
	/**
	 * ��ȡͼ�����ݿ�������Ϣ
	 * @return	ͼ�����ݿ�������Ϣ
	 */
	public static DataServerConfig getDataServerConfig(){
		DataServerConfig serverConfig = serverConfigHolder.get();
		if(serverConfig == null){
			serverConfig = XmlConfigReader.getServerConfigFromXML();
			serverConfigHolder.set(serverConfig);
		}
		return serverConfig;
	}
	
	/**
	 * ��ȡ��Դ�ļ�Ŀ¼������Ϣ
	 * @return	��Դ�ļ�Ŀ¼������Ϣ
	 */
	public static ResPathConfig getResPathConfig(){
		ResPathConfig config = resPathConfigHolder.get();
		if(config == null){
			config = XmlConfigReader.getResPathConfigFromXML();
			resPathConfigHolder.set(config);
		}
		return config;
	}
}
