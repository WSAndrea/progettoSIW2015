<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Napster Store</title>
</head>
<body>
	<f:view>
		<h1>Navigazione sito</h1>
		<ul>
			<li><a href='<c:url value = "faces/adminPanel.jsp"/>'>Pannello
					Amministratore</a></li>
			<li><h:form>
					<h:commandLink action="#{productController.retrieveAllProducts}"
						value="Catalogo" />
				</h:form></li>
		</ul>
	</f:view>
</body>
</html>