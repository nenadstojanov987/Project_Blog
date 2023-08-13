<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<header class="header">
      <!-- Main Navbar-->
      <nav class="navbar navbar-expand-lg">
        <div class="search-area">
          <div class="search-area-inner d-flex align-items-center justify-content-center">
            <div class="close-btn"><i class="icon-close"></i></div>
            <div class="row d-flex justify-content-center">
              <div class="col-md-8">
                <form action="${pageContext.request.contextPath}/blog-search-page">
                  <div class="form-group">
                    <input type="search" name="text" id="search" placeholder="What are you looking for?">
                    <button type="submit" class="submit"><i class="icon-search-1"></i></button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="container">
          <!-- Navbar Brand -->
          <div class="navbar-header d-flex align-items-center justify-content-between">
            <!-- Navbar Brand --><a href="${pageContext.request.contextPath}/index" class="navbar-brand">Bootstrap Blog</a>
            <!-- Toggle Button-->
            <button type="button" data-toggle="collapse" data-target="#navbarcollapse" aria-controls="navbarcollapse" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span></span><span></span><span></span></button>
          </div>
          <!-- Navbar Menu -->
          <div id="navbarcollapse" class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item"><a href="${pageContext.request.contextPath}/index" class="nav-link active">Home</a>
              </li>
              <li class="nav-item"><a href="${pageContext.request.contextPath}/blog" class="nav-link">Blog</a>
              </li>
              <li class="nav-item"><a href="${pageContext.request.contextPath}/contact" class="nav-link">Contact</a>
              </li>
            </ul>
            <div class="navbar-text"><a href="${pageContext.request.contextPath}/blog-search" class="search-btn"><i class="icon-search-1"></i></a></div>
          </div>
           
          </div>
          <c:choose>
          <c:when test="${user.username==null}">
          	<div class="navbar-nav nav-link" style="text-align: right">
          		<a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a>
          	</div>
          </c:when>
          <c:otherwise>
        
   			 <ul class="nav navbar-nav-custom pull-right">
                           
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src='<c:out value="${pageContext.request.contextPath}/${user.image}"></c:out>' alt="avatar">
                                  
                                </a>
                                <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                    <li class="dropdown-header text-center">Account</li>
                                    <li>
                                     <sec:authorize access="hasRole('admin')">
                                         <a href="${pageContext.request.contextPath}/admin/message-list">
                                            <i class="fa fa-envelope-o fa-fw pull-right"></i>
                                             
                                            Messages
                                        </a>
                                     </sec:authorize>
                                        <a target="_blank" href="${pageContext.request.contextPath}/admin/dashboard">
                                            <i class="fa fa-dashboard fa-fw pull-right"></i>
                                             
                                            Dashboard
                                        </a>
                                        
                                          <a href="${pageContext.request.contextPath}/admin/change-password-form">
                                            <i class="fa fa-cog fa-fw pull-right"></i>
                                             
                                            Change password
                                        </a>
                                         <a href="${pageContext.request.contextPath}/admin/user-update-form?username=${user.username}">
                                            <i class="fa fa-user fa-fw pull-right"></i>
                                            Profile -  ${user.name}
                                        </a>
                                        
                                    </li>
                                    <li class="divider"></li>
                                     
                                    <li class="divider"></li>
                                    <li>
                                        
                                        <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-ban fa-fw pull-right"></i> Logout</a>
                                    </li>
                                     
                                </ul>
                            </li>
                            <!-- END User Dropdown -->
                        </ul>
   			 
   		    </c:otherwise>
   		 </c:choose>
      </nav>
    </header>