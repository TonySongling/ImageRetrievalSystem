package com.hbd.retrieval.common.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.hbd.retrieval.common.domain.ImgResourcePath;
import com.hbd.retrieval.common.domain.ResPathConfig;
import com.hbd.retrieval.data.manager.DataManager;
import com.hbd.retrieval.data.manager.DataManagerImpl;
import com.hbd.retrieval.image.util.ImageOperate;
import com.hbd.retrieval.image.util.ImageOperateImpl;
import com.hbd.retrieval.index.manager.IndexManager;
import com.hbd.retrieval.index.manager.IndexManagerImpl;
import com.hbd.retrieval.search.manager.SearchManager;
import com.hbd.retrieval.search.manager.SearchManagerImpl;
/**
 * ��Ŀ������Servlet�ĸ���
 * @author Edward
 *
 */
public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//������Դ·��
	private ImgResourcePath imgResourcePath = null;
	//��Դ·������
	private ResPathConfig resPathConfig = null;
	//ͼƬ�������߶���
	private ImageOperate imageOperate = null;
	//�������ܶ���
	private SearchManager searchManager = null;
	//���ݹ������
	private DataManager dataManager = null;
	//�����������ܶ���
	private IndexManager indexManager = null;
	@Override
	public void init() throws ServletException {
		super.init();
		imgResourcePath = (ImgResourcePath) this.getServletContext().getAttribute("imgResourcePath");
		
		resPathConfig = (ResPathConfig) this.getServletContext().getAttribute("resPathConfig");
		
		imageOperate = new ImageOperateImpl();
		
		searchManager = new SearchManagerImpl();
		
		dataManager = new DataManagerImpl();
		
		indexManager = new IndexManagerImpl();
	}
	//��ȡͼƬ��Դ·����Ϣ
	public ImgResourcePath getImgResourcePath() {
		return imgResourcePath;
	}
	//��ȡͼƬ��������
	public ImageOperate getImageOperate() {
		return imageOperate;
	}
	
	//��ȡͼƬ��Դ·��������Ϣ
	public ResPathConfig getResPathConfig() {
		return resPathConfig;
	}
	//��ȡ�������ܶ���
	public SearchManager getSearchManager() {
		return searchManager;
	}
	//��ȡ�������ݶ���
	public DataManager getDataManager() {
		return dataManager;
	}
	//��ȡ�����������ܶ���
	public IndexManager getIndexManager() {
		return indexManager;
	}
	
}
