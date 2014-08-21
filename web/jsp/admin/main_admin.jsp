<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="custom" uri="customtags" %>


<!DOCTYPE html>
<html>
    <head>
        <fmt:setLocale value="${locale}" scope="session"/>
        <fmt:bundle basename="title" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="header.title"/></title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

    </head>
    <body>
        <div class="page-wrapper"> 
            <div class="page-buffer">    
                <div class="header"> 
                    <c:import url="..\common\header.jsp" charEncoding="utf-8"/> 
                </div>
                <div id="menu">    
                    <c:import url="..\common\menu_admin.jsp" charEncoding="utf-8"/>
                </div>
                <div id="page-content">
                    <h2>
                        <fmt:message key="admin.welcome"/>, <b>${userName}.</b>
                        <br/>
                        <br/>
                        <fmt:message key="tag.order"/>
                        <custom:statistics-tag command="newOrders" >
                            ${rw}
                        </custom:statistics-tag>
                        <fmt:message key="tag.user"/>
                        <custom:statistics-tag command="usersW">
                            ${us}
                        </custom:statistics-tag>
                        <fmt:message key="tag.car"/>
                        <custom:statistics-tag command="carsRedirectAdmin">
                            ${car}
                        </custom:statistics-tag>

                    </h2> 
                </div>
            </div> 
        </div>
        <div class="footer">  <c:import url="..\common\footer.jsp" charEncoding="utf-8"/> </div>
    </body>
</html>