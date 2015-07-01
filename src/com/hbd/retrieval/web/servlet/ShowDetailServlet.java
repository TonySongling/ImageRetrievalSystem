package com.hbd.retrieval.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbd.retrieval.common.servlet.BaseServlet;
import com.hbd.retrieval.data.domain.Disease;
import com.hbd.retrieval.data.manager.DataManager;
/**
 * ������ϸServlet
 * @author Edward
 *
 */
public class ShowDetailServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DataManager dataManager = null;
	@Override
	public void init() throws ServletException {
		super.init();
		dataManager = this.getDataManager();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����ID����
		String diseaseId = request.getParameter("diseaseId");
		//ͼƬURL
		String imgUrl = request.getParameter("imgUrl");
		
		//����ͼ�����
		int num = 0;
		num = Integer.parseInt(getServletContext().getInitParameter("similarImgNum"));
		
		Disease disease = dataManager.getDiseaseById(diseaseId);
		
		String[] similarImgUrls = dataManager.getSimilarImgUrls(diseaseId, num);
		
		request.setAttribute("disease", disease);
		request.setAttribute("imgUrl", imgUrl);
		request.setAttribute("similarImgUrls", similarImgUrls);
		//response.sendRedirect(request.getContextPath() + "/detail.jsp");
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
