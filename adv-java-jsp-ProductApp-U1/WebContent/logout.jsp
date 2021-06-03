
<%
String name = (String) session.getAttribute("name");
if (name != null) {
	session.invalidate();
	response.sendRedirect("admin.jsp");
} else {
	session.setAttribute("msg", "Plz Login first!");
	response.sendRedirect("admin.jsp");
}
%>