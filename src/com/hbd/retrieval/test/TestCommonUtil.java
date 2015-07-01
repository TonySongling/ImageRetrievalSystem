package com.hbd.retrieval.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.hbd.retrieval.common.util.CommonUtils;

import junit.framework.TestCase;

public class TestCommonUtil extends TestCase {
	public void testGetNewName(){
		String a = CommonUtils.getNewName("java.txt");
		System.out.println(a);
	}
	
	public void testGetFileName(){
		String filePath = "D:\\ImageRetrievalSystem\\imgData\\uploadSegPath\\2015-06-12_15-51-29_1_seg.JPG";
		String name = CommonUtils.getFileName(filePath);
		System.out.println(name);
	}
	
	public void testCutString(){
		String str = "<p><span style=\"font-size:14px\">&nbsp;����ϸ����(basal cell carcinoma��BCC) ��Ƥ�����������֮һ���ֳƻ���ϸ����Ƥ��(basal cell epithelioma) ��������ϸ��������ʴ������ȣ���Դ�ڱ�Ƥ����ϸ����ë������ʵ���Ƥ�ԵͶȶ�������������Ϊ���Ի���ϸ���Ķ��������������չ���ɹ�����й�ϵ���������÷����չ���ɹ��ͷ���桢�������ֱ��ȴ��������ձ���Ϊ�������Ա�Ƥ��Ǳ��ϸ�����������õ���¡����֤ʵ����ϸ�������Ա�Ƥϸ����</span></p>";
		str = str.replace("&nbsp;", "");
		Document doc = Jsoup.parse(str);
		String desc = doc.body().text();
		//desc = desc.replace("&nbsp;", "");
		System.out.println(desc);
	}
}
