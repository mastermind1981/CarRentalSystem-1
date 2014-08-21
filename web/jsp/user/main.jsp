<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <c:import url='..\common\header.jsp' charEncoding="utf-8"/> 
                </div>
               <div id="menu">     <c:import url="..\common\menu.jsp" charEncoding="utf-8"/>
               </div>
               <div id="page-content">
                   <h2><fmt:message key="user.mainpage.title"/></h2>
                   <p><fmt:message key="user.mainpage.test"/></p>
                     <div id="back"> 
                            <form name ="BackForm"  method="POST" action="carrent" >
                                <input type="hidden" name="command" value="CARSREDIRECT"/> 
                                <input type="submit" value="<fmt:message key="media.slogan"/>"/>
                            </form> 
                        </div> 
               </div>
            </div> 
        </div>
        <div class="footer">  <c:import url="..\common\footer.jsp" charEncoding="utf-8"/> </div>
    </body>
</html>