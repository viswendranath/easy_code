package controller;

import java.io.FileReader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OutputController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession(); 
		String code = (String) s.getAttribute("code");
		String output = "";
		StringBuffer sb = new StringBuffer();
		try(FileReader fr= new FileReader(RunController.BASE_PATH + s.getId() + "/output")){
			char buff[] = new char[1000];
			while(fr.read(buff) != -1){
				sb.append(String.valueOf(buff));
			}
			output = sb.toString();
		}catch(Exception e){
			System.out.println(e);
		}
		out.print(output.trim());
		out.close();
	}
	
}
