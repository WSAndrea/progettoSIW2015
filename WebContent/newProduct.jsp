<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nuovo Prodotto</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				Nome:
				<h:inputText value="#{productController.name}" required="true"
					requiredMessage="Parametro obbligatorio" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Codice:
				<h:inputText value="#{productController.code}" required="true"
					requiredMessage="Parametro obbligatorio" id="code" />
				<h:message for="code" />
			</div>
			<div>
				Prezzo:
				<h:inputText value="#{productController.price}" required="true"
					requiredMessage="Parametro obbligatorio"
					converterMessage="Il prezzo dev'essere un numero" id="price" />
				<h:message for="price" />
			</div>
			<div>
				Descrizione:
				<h:inputTextarea value="#{productController.description}"
					required="false" cols="20" rows="5" />

			</div>
			<div>
				Quantità in stock:
				<h:inputText value="#{productController.stockquantity}"
					required="true" requiredMessage="Parametro obbligatorio"
					converterMessage="La quantità dev'essere un numero"
					id="stockquantity" />
				<h:message for="stockquantity" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{productController.createProduct}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>