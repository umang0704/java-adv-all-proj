package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/UpdatePlant")
public class UpdatePlant extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String admin_name=(String)session.getAttribute("admin_name");
		if(admin_name!=null){
			try {
				String pname=request.getParameter("name");
				int price=Integer.parseInt(request.getParameter("price"));
				String description=request.getParameter("description");
				String category=request.getParameter("category");
				double height=Double.parseDouble(request.getParameter("height"));
				int quantity=Integer.parseInt(request.getParameter("quantity"));
				Part p=request.getPart("photo");
				InputStream photo=null,photo1=null,photo2=null;
				if(p!=null)
					photo=p.getInputStream();
				Part p1=request.getPart("photo1");
				if(p1!=null)
					photo1=p1.getInputStream();
				Part p2=request.getPart("photo2");
				if(p2!=null)
					photo2=p2.getInputStream();
				dao.DbConnect db=new dao.DbConnect();
//				String m=db.updatePlant();
//				session.setAttribute("msg",m);
				response.sendRedirect("editPlantDetails.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			session.setAttribute("msg","Plz login!");
			response.sendRedirect("adminLogin.jsp");
		}
	}

}
