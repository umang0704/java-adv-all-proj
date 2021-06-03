<%@page import="dynamicUtil.Send_email"%>
<%@page import="dbUtil.PatientUtil"%>
<%
String pass = request.getParameter("password");
String repass = request.getParameter("repassword");
if (pass.equals(repass)) {
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	Integer age = Integer.parseInt(request.getParameter("age"));
	String phone = request.getParameter("ph");
	String msg = PatientUtil.createPatientAccount(email, pass, address, name, age, phone, gender);
	if(msg!=null){
		Send_email.sendEmail(email,"Registration: Successfull", "Mr.\\Mrs. "+name+" you have been success fully registered to Your Doc + with \n Email: "+email+" \n Phone:"+phone);
	}
	application.setAttribute("msg", msg);
	response.sendRedirect("index.jsp");

} else {
	application.setAttribute("msg", "Passwords in both the field do not match");
	response.sendRedirect("patient_signup.jsp");
}
%>