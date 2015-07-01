package com.hbd.retrieval.common.servlet;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.hbd.retrieval.common.domain.ImgResourcePath;
import com.hbd.retrieval.common.domain.ResPathConfig;
import com.hbd.retrieval.common.util.ConfigManager;

/**
 * ��ʼ��servlet��ִ��һЩ��ʼ������
 * @author Edward
 *
 */
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		
		//���������������ϴ��ļ����ļ���ImgData
		String nowPath = System.getProperty("user.dir");
		String tempPath = nowPath.replace("bin", "webapps");
		ResPathConfig resPathConfig = ConfigManager.getResPathConfig();
		String projectName = resPathConfig.getProjectName();
		tempPath += "\\" + projectName;

		String imgDataPath = tempPath + "\\" + resPathConfig.getImgData();
		
		File file = new File(imgDataPath);
		if(!file.exists() && !file.isDirectory()){
			file.mkdir();
		}
		

		//���ڴ��������Ŀ¼
		String indexPath = imgDataPath + "\\" + resPathConfig.getIndexPath() + "\\";
		// ���ڴ�Ÿ���ͼƬ�ļ���Ŀ¼
		String uploadSrcPath = imgDataPath + "\\" + resPathConfig.getUploadSrcPath() + "\\";
		String uploadCropPath = imgDataPath + "\\" + resPathConfig.getUploadCropPath() + "\\";
		String uploadSegPath = imgDataPath + "\\" + resPathConfig.getUploadSegPath() + "\\";
		//���ڴ洢��ʱ�ļ���Ŀ¼
		String tempImgPath = imgDataPath + "\\" + resPathConfig.getTempImgPath() + "\\";
		
		File indexFile = new File(indexPath);
		File srcFile = new File(uploadSrcPath);
		File cropFile = new File(uploadCropPath);
		File segFile = new File(uploadSegPath);
		File tempFile = new File(tempImgPath);
		
		if(!indexFile.exists() && !indexFile.isDirectory()){
			indexFile.mkdir();
		}
		if(!srcFile.exists() && !srcFile.isDirectory()){
			srcFile.mkdir();
		}
		if(!cropFile.exists() && !cropFile.isDirectory()){
			cropFile.mkdir();
		}
		if(!segFile.exists() && !segFile.isDirectory()){
			segFile.mkdir();
		}
		if(!tempFile.exists() && !tempFile.isDirectory()){
			tempFile.mkdir();
		}
		ImgResourcePath imgResourcePath = new ImgResourcePath();
		imgResourcePath.setImgDataPath(imgDataPath);
		imgResourcePath.setIndexPath(indexPath);
		imgResourcePath.setTempImgPath(tempImgPath);
		imgResourcePath.setUploadSrcPath(uploadSrcPath);
		imgResourcePath.setUploadCropPath(uploadCropPath);
		imgResourcePath.setUploadSegPath(uploadSegPath);
		this.getServletContext().setAttribute("imgResourcePath", imgResourcePath);
		this.getServletContext().setAttribute("resPathConfig", resPathConfig);
		
	}
	
}
