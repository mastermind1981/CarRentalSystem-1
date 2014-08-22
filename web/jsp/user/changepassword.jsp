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
        <link rel="stylesheet" href="..\css\style.css" type="text/css">
        <link rel="shortcut icon" href="..\img\favicon.ico" type="image/x-icon" />

    </head>
    <body>
        <div class="page-wrapper"> 
            <div class="page-buffer">    
                <div class="header"> 
                    <c:import url='..\common\header.jsp' charEncoding="utf-8"/> 
                </div>
                <div id="menu">     
                    <c:import url="..\common\menu.jsp" charEncoding="utf-8"/> 
                </div>
                <div id="page-content">  
                    <h2><fmt:message key="user.change.password"/></h2>
                    <div id="back"> 
                        <form name ="BackForm"  method="POST" action="carrent" >
                            <input type="hidden" name="command" value="ACCOUNT"/> 
                            <input type="submit" value="<fmt:message key="back.button"/>"/>
                        </form> 
                    </div> 
                    <br/>
                    <form name='form-change-passwprd' method="POST" action="carrent">   
                        <input type="hidden" name="command" value="ChangePasswordConf" />
                        <fmt:message key="user.account.newpass"/>:<h7>*</h7><br/>
                        <div class="msg"> <fmt:message key="register.warn.pass"/> </div>
                        <input type="password" pattern="^[a-z0-9_-]{3,16}$" id="user" name= "newpass" placeholder="" required> <br/><br/>
                        <fmt:message key="user.account.oldpass"/>:<h7>*</h7><br/>
                        <input type="password" id="user" name= "pass" placeholder="" required> <br/><br/>
                        <input type="submit" value="<fmt:message key="user.account.passchange"/>"/>
                    </form> 
                    <c:if test="${not empty cpError}"><div class="msg"><fmt:message key="change.password.fail"/></div></c:if>
                    <c:if test="${not empty cpSuccess}"><div class="msg"><fmt:message key="change.password.success"/></div></c:if>
                    </div>                                
                </div>
            </div>
            <div class="footer">  <c:import url="..\common\footer.jsp" charEncoding="utf-8"/> </div>
    </body>
</html>