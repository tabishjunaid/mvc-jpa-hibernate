<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Accounts</title>
</head>
<body>
    <a href="<c:url value="displayForm" />">Add New Account</a>
    <table border="1">
         <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>BALANCE</td>    
         </tr>
        <c:forEach items="${accounts}" var="account">
          <tr>
            <td width="100px"><a href="<c:url value="accountDetails/${account.id}" />"><c:out value="${account.id}"/></a></td>
            <td width="100px"><c:out value="${account.name}"/></td>
            <td  width="100px"><c:out value="${account.balance}"/></td>    
         </tr>
        </c:forEach>
    </table>
 
</body>
</html>