package frontproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontproject.dao.SampleTBDAO;
import frontproject.vo.SampleTBlistVO;
import frontproject.vo.SampleTBviewVO;

public class SampleTBController {
	
	public void getAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		//frontcontroller에서 sampleTB관련 모든 요청을 받아서
		//각 목적에 맞는 메소드로 분기하는 영역
		if(uris[1].equals("list.do")) {
			list(request,response);
		}else if(uris[1].equals("view.do")) {
			view(request,response);
		}else if(uris[1].equals("modify.do")) {
			modify(request,response);
		}else if(uris[1].equals("writePage.do")) {
			writePage(request,response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		List<SampleTBlistVO> slist = sampleTBDao.selectList();
		request.setAttribute("slist", slist);
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/list.jsp");
		rd.forward(request, response);
	}
	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno  = request.getParameter("sno");
		int snoIndex = 0;
		if(sno != null && !sno.equals("")) {
			snoIndex = Integer.parseInt(sno);
		}else {
			response.sendRedirect("list.do");
		}
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		SampleTBviewVO svo = sampleTBDao.selectSno(snoIndex);
		request.setAttribute("svo", svo);
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/view.jsp");
		rd.forward(request, response);
	}
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno  = request.getParameter("sno");
		int snoIndex = 0;
		if(sno != null && !sno.equals("")) {
			snoIndex = Integer.parseInt(sno);
		}else {
			response.sendRedirect("view.do");
		}
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		SampleTBviewVO svo = sampleTBDao.selectSno(snoIndex);
		request.setAttribute("svo", svo);
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/modify.jsp");
		rd.forward(request, response);
	}
	private void writePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/sampleTB/write.jsp");
		rd.forward(request, response);
	}
	public void postAction(HttpServletRequest request, HttpServletResponse response, String[] uris) throws ServletException, IOException {
		// post 요청에 대한 처리
		if(uris[1].equals("modify.do")) {
			modifyOK(request,response);
		}
		if(uris[1].equals("write.do")) {
			write(request,response);
		}
	}
	private void modifyOK(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String sno  = request.getParameter("sno");
		int snoIndex = 0;
		if(sno != null && !sno.equals("")) {
			snoIndex = Integer.parseInt(sno);
		}
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		int result = sampleTBDao.modify(title, writer, body, snoIndex);
		if(result > 0) {
			response.sendRedirect("view.do?sno="+snoIndex);
		}else {
			response.sendRedirect("modify.do?sno="+snoIndex+"&msg=fail");
		}
	}
	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String body = request.getParameter("body");
		SampleTBDAO sampleTBDao = new SampleTBDAO();
		int result = sampleTBDao.write(title, writer, body);
		if(result > 0) {
			response.sendRedirect("list.do");
		}
	}
}
