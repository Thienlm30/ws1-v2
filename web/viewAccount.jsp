<%-- 
    Document   : viewAccount
    Created on : 22-Jun-2024, 10:37:45
    Author     : Thienlm30
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View List Account</title>
    </head>
    <body>
        <div>
            <%@include file="Header.jsp" %>
        </div>
<!--        <div>
            <jsp:include page="Header.jsp"/>
        </div>-->
        <div class="table-container">
            <div class="table-wrapper">
                <h1 class="text-2xl font-bold mb-4">List of account in system</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Account</th>
                            <th>Full name</th>
                            <th>Birth day</th>
                            <th>Gender</th>
                            <th>Phone</th>
                            <th>Role in system</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    
                    <c:forEach var="acc" items="${listAccount}">
                        <tr>
                            <td>${acc.account}</td>
                            <td>${acc.firstName}, ${acc.lastName}</td>
                            <td>${acc.birthday}</td>
                            <td>${acc.gender ? 'Male' : 'Female'}</td>
                            <td>${acc.phone}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${acc.roleInSystem == 1}">
                                        Administrator
                                    </c:when>
                                    <c:otherwise>
                                        Staff
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <form action="MainController" method="post">
                                    <input type="hidden" name="account" value="${acc.account}" />
                                    <input type="hidden" name="password" value="${acc.pass}" />
                                    <input type="hidden" name="firstName" value="${acc.firstName}" />
                                    <input type="hidden" name="lastName" value="${acc.lastName}" />
                                    <input type="hidden" name="phone" value="${acc.phone}" />
                                    <input type="hidden" name="birthday" value="${acc.birthday}" />
                                    <input type="hidden" name="gender" value="${acc.gender ? '1' : '0'}"/>
                                    <input type="hidden" name="isUse" value="${acc.isUse ? '1' : '0'}"/>
                                    <input type="hidden" name="roleInSystem" value="${acc.roleInSystem}" />

                                    <button class="update" type="submit" name="action" value="<%= Action.UPDATE%>">Update</button>
                                    <button class="delete" type="submit" name="action" value="<%= Action.DELETE%>">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>   
                </table>
            </div>
        </div>
    </body>
</html>
