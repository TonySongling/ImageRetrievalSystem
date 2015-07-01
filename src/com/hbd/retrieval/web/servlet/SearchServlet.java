package com.hbd.retrieval.web.servlet;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hbd.retrieval.common.domain.ImgResourcePath;
import com.hbd.retrieval.common.domain.ResPathConfig;
import com.hbd.retrieval.common.servlet.BaseServlet;
import com.hbd.retrieval.common.util.CommonUtils;
import com.hbd.retrieval.data.manager.DataManager;
import com.hbd.retrieval.image.util.ImageOperate;
import com.hbd.retrieval.search.domain.ImageInfo;
import com.hbd.retrieval.search.domain.RetrievalResult;
import com.hbd.retrieval.search.manager.SearchManager;

/**
 * ���ڼ�����Servlet
 * @author Edward
 *
 */
public class SearchServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ���ڴ������ͼƬ��Ŀ¼
	private File uploadSrcPathFile = null;
	
	// ���ڴ����ʱ�ļ���Ŀ¼
	private File tempImgPathFile = null;
	
	//ͼ����Դ�Ĵ洢·������
	private ImgResourcePath imgResourcePath = null;

	private ResPathConfig resPathConfig = null;
	
	//�û��ϴ���ͼ�����Ϣ
	ImageInfo imageInfo = null;
	
	private ImageOperate imageOperate = null;
	
	private SearchManager searchManager = null;
	
	private DataManager dataManager = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		imgResourcePath = this.getImgResourcePath();
	
		resPathConfig = this.getResPathConfig();
		
		uploadSrcPathFile = new File(imgResourcePath.getUploadSrcPath());
		tempImgPathFile = new File(imgResourcePath.getTempImgPath());
		
		imageInfo = new ImageInfo();
		
		imageOperate = this.getImageOperate();
		searchManager = this.getSearchManager();
		dataManager = this.getDataManager();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		File file = null;
		int maxFileSize = 10000 * 1024;
		int maxMemSize = 10000 * 1024;
		// ��֤�ϴ���������
		boolean isMutipart = ServletFileUpload.isMultipartContent(request);
		if (isMutipart == true) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			// �����ڴ��еĴ洢�ļ������ֵ
			factory.setSizeThreshold(maxMemSize);

			factory.setRepository(tempImgPathFile);

			// ����һ���µ��ļ��ϴ��������
			ServletFileUpload upload = new ServletFileUpload(factory);

			// ��������ϴ����ļ���С
			upload.setSizeMax(maxFileSize);
			try {
				// ������ȡ���ļ�
				List<FileItem> fileItems = upload.parseRequest(request);

				// �����ϴ����ļ�
				Iterator<FileItem> iterator = fileItems.iterator();

				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (!item.isFormField()) {
						String fileName = item.getName();
						fileName = CommonUtils.getNewName(fileName);
						// д���ļ�
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(uploadSrcPathFile,
									fileName.substring(fileName
											.lastIndexOf("\\")));
						} else {
							file = new File(uploadSrcPathFile,
									fileName.substring(fileName
											.lastIndexOf("\\") + 1));
						}
						item.write(file);
					}else{
						String name = item.getFieldName();
						String valueStr = item.getString();
						float value = Float.parseFloat(valueStr);
						if("x1".equals(name)){
							imageInfo.setLeftTopX((int)value);
						}else if("y1".equals(name)){
							imageInfo.setLeftTopY((int)value);
						}else if("x2".equals(name)){
							imageInfo.setRightBottomX((int)value);
						}else if("y2".equals(name)){
							imageInfo.setRightBottomY((int)value);
						}else if("positionFlag".equals(name)){
							imageInfo.setPositionFlag((int)value);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		//���ϴ��ļ�������������������ȥ·��
		String srcImgPath = CommonUtils.renameSrcFile(file, imgResourcePath.getUploadSrcPath(), imageInfo);
		String srcServerPath = resPathConfig.getImgData() + "/" + resPathConfig.getUploadSrcPath() + "/" + CommonUtils.getFileName(srcImgPath);
		
		//��ԭͼ����вü������������䱣�浽imgResourcePath.getUploadCropPath()Ŀ¼�£�������·��
		String cropImgPath = imageOperate.getCropImgPath(srcImgPath, imageInfo, imgResourcePath.getUploadCropPath());
		String cropServerPath = resPathConfig.getImgData() + "/" + resPathConfig.getUploadCropPath() + "/" + CommonUtils.getFileName(cropImgPath);
		
		//�Բü�ͼ����зָ�����������䱣�浽imgResourcePath.getUploadSegPath()Ŀ¼�£�������·��
		String segImgPath = imageOperate.getSegImgPath(cropImgPath, imgResourcePath.getUploadSegPath());
		String segServerPath = resPathConfig.getImgData() + "/" + resPathConfig.getUploadSegPath() + "/" + CommonUtils.getFileName(segImgPath);
		
		//ʹ�÷ָ��ͼ����м���
		List<RetrievalResult> resultList = searchManager.getRetrievalResults(segImgPath, imgResourcePath.getIndexPath());
		
		//�������
		String[] descContent = dataManager.getDescContent(resultList);
		
		
		//��ԭͼ�񡢲ü�ͼ��·���Լ������������ת��
		request.setAttribute("srcServerPath", srcServerPath);
		request.setAttribute("cropServerPath", cropServerPath);
		request.setAttribute("segServerPath", segServerPath);
		request.setAttribute("resultList", resultList);
		request.setAttribute("descContent", descContent);
		
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
}
