<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<tag:template titulo="Cadastro de Marca">
	<h1>Cadastro de Marca</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	<c:url value="/marca/cadastrar" var="action"/>
	<form:form action="${action }" method="post" commandName="marca">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="dataFundacao">Data de Fundação</form:label>
			<form:input path="dataFundacao" cssClass="form-control"/>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>
</tag:template>




