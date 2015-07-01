package com.hbd.retrieval.common.util;

/**
 * DLL文件加载工具类
 * @author Edward
 *
 */
public class DllLoaderUtils {
	/**
	 * 加载DLL文件
	 * @param fileNames	DLL文件名
	 */
	public static void loadDllFile(String... fileNames){
		String path = DllLoaderUtils.class.getResource("/").getPath();
		path = path.replaceAll("%20", " ");
		
		for(String fileName : fileNames){
			System.load(path + fileName);
		}
	}
}
