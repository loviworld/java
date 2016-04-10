<%@include file="includes/header.jsp" %>
<h2>Welcome Java EX-1</h2>
<form action="<c:url value="signIn" />" method="post">
	<span>${errorMessage}</span>
	<input type="text" name="userId" value="${userId}" placeholder="user id" required="required"/>
	<input type="password" name="password" value="${password}" placeholder="password" required="required"/>
	<input type="submit" value="signin" />
</form>
<%@include file="includes/footer.jsp" %>
