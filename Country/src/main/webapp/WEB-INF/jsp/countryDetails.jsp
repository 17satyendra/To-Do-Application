<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
   <head>
      <link rel="stylesheet" href="./css/world.css" type="text/css" />
      <title>
         <spring:message code="country.details" />
      </title>
   </head>
   <body>
      <center>
         <h1>
            <spring:message code="application.name"  />
         </h1>
            <table>
               <tr>
                  <td align="right" valign="bottom">
					<form:form modelAttribute="country" action="delete" method="post">                  
                     	<input id="id" name="id" type="hidden" value="${country.id}"/>
                     	<%-- <form:hidden path="id" id="id"/> --%>         
                     	<button type="submit" onclick="return confirm('Are you sure you want to delete ${country.id}?')">Delete</button>
                     	<a href="update?id=${country.id}">Update</a>
                     </form:form>
                  </td>
               </tr>
               <tr>
                  <td>
                     <table class="silver" width="260" border="5" bgcolor="#66FFCC">
                        <tr>
                           <th colspan=2>
                              <spring:message code="country.details" />
                           </th>
                        </tr>
                        <tr>
                           <td>
                              <spring:message code="country.name" />
                           </td>
                           <td>${country.name}</td>
                        </tr>
                        <tr>
                           <td>
                              <spring:message code="country.area" />
                           </td>
                           <td>
                              <fmt:formatNumber type="number" value="${country.area}" />
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <spring:message code="country.population" />
                           </td>
                           <td>
                              <fmt:formatNumber type="number"
                                 value="${country.population}" />
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <spring:message code="country.currency" />
                           </td>
                           <td>${country.currerncy}</td>
                        </tr>
                        <tr>
                           <td>
                              <spring:message code="country.updatedOn" />
                           </td>
                           <td>${country.lastModified}</td>
                        </tr>
                     </table>
                  </td>
               </tr>
            </table>
            <a href="listOfCountries.html">
               &lt;&lt;
               <spring:message
                  code="navigation.back" />
            </a>
         
      </center>
   </body>
</html>