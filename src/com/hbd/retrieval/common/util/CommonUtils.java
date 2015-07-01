package com.hbd.retrieval.common.util;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.hbd.retrieval.search.domain.ImageInfo;
/**
 * ���ù�����
 * @author Edward
 *
 */
public class CommonUtils {
	
	/**
	 * ��ȡList<String[]>�и����ַ����������ͬԪ�ص�����
	 * @param resultList	�ַ�������
	 * @return	ȥ����ͬԪ�غ���ַ�������
	 */
	public static String[] getSameSearchResult(List<String[]> resultList){
		String[] sameElements = resultList.get(0);
		for(int i=1; i<resultList.size(); i++){
			sameElements = findSameElementIn2Arrays(sameElements, resultList.get(i));
		}
		return sameElements;
	}
	
	/**
	 * �ҳ�������ͬ�������ͬԪ��
	 * @param strArray1	�ַ�������1
	 * @param strArray2	�ַ�������2
	 * @return	��ͬԪ�ص��ַ�������
	 */
	public static String[] findSameElementIn2Arrays(String[] strArray1, String[] strArray2){
		Set<String> sameSet = new HashSet<String>();//����������ͬԪ��
		Set<String> tempSet = new HashSet<String>();//�������1�е�Ԫ��
		
		for(int i=0; i<strArray1.length; i++){
			tempSet.add(strArray1[i]);
		}
		
		for(int i=0; i<strArray2.length; i++){
			//������2�е�Ԫ����ӵ�tempSet��
		    //���tempSet���Ѵ�����ͬ��Ԫ�أ���tempSet.add��array2[j]������false
			if(!tempSet.add(strArray2[i])){
				sameSet.add(strArray2[i]);
			}
		}
		
		Object[] objects = sameSet.toArray();
		String[] sameElements = new String[objects.length];
		for(int i=0; i<objects.length; i++){
			sameElements[i] = objects[i].toString();
		}
		return sameElements;
	}
	
	/**
	 * ɾ���ļ�
	 * @param file	��ɾ���ļ�
	 */
	public static void delelteFile(File file){	
		if (file != null) {
            if (file.isFile()) {
                System.out.println(file.getPath());
                file.delete();
            } else if (file.isDirectory()) {
                System.out.println(file.getPath());
                File[] subFiles = file.listFiles();
                int n = subFiles.length;
                for (int i = 0; i < n; i++) {
                	delelteFile(subFiles[i]);
                }
                file.delete();
            }
        }
	}
	
	/**
	 * �ļ�������
	 * @param file�ļ�
	 * @param prefixStr	�ļ�Ŀ¼ǰ׺
	 * @param imageInfo	�û��ϴ���ͼƬ����Ϣ
	 * @return	����������ļ���
	 */
	public static synchronized String renameSrcFile(File file, String prefixStr, ImageInfo imageInfo){
		String newFilePath = null;
		String filePath = file.getAbsolutePath();
		String suffix = filePath.substring(filePath.lastIndexOf(".") + 1);
		Format format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String newName = format.format(new Date());
		File newFile = new File(prefixStr + newName +  "_" + imageInfo.getPositionFlag() + "_" + "src" + "." + suffix);
		if(file.renameTo(newFile)){
			newFilePath = newFile.getAbsolutePath();
		}
		return newFilePath;
	}
	
	/**
	 * ��ȡͼƬ�ڷ����������·��
	 * @param results	�ַ�������
	 * @param projectName	��Ŀ����
	 * @return	���·��
	 */
	public static String[] getRelativePath(String[] results, String projectName){
		String[] relativePaths = new String[results.length];
		for(int i = 0; i < results.length; i++){
			results[i] = results[i].replaceAll("\\\\", "/");
			results[i] = results[i].substring(results[i].indexOf(projectName) + projectName.length());
			relativePaths[i] = results[i];
		}
		return relativePaths;
	}
	
	/**
	 * Ϊ�ϴ�ͼƬ����
	 * @param fileName	�ϴ�ͼƬ��ԭ��
	 * @return	�ϴ�ͼƬ��������
	 */
	public static synchronized String getNewName(String fileName){
		String newName = null;;
		if(!"".equals(fileName) && fileName != null){
			Format format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
			newName = format.format(new Date());
			newName = newName + "." + prefix;
		}
		return newName;
	}
	
	/**
	 * ����·������ȡ�ļ���
	 * @param filePath	�ļ�·����
	 * @return	�ļ���
	 */
	public static String getFileName(String filePath){
		if(filePath.contains("\\")){
			filePath = filePath.replaceAll("\\\\", "/");
		}
		String srcName = filePath.substring(filePath.lastIndexOf("/") + 1);
		
		return srcName;
	}
	
	/**
	 * ����HTML�ַ�������ȡ������
	 * @param str	HTML�ַ���
	 * @return	HTML������
	 */
	public static String removeHtmlTag(String str){
		String desc = null;
		if(!"".equals(str) && str != null){
			if(str.contains("&nbsp;")){
				str = str.replace("&nbsp;", "");
			}
			Document doc = Jsoup.parse(str);
			desc = doc.body().text();
			if(desc.length() > 35){
				desc = desc.substring(0, 35) + "......";
			}else{
				desc = desc + "......";
			}
		}
		return desc;
	}
}
