<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
 <head>
 </head>   
 <body>

 
     <header class="navbar navbar-default">

                        <!-- Left Header Navigation -->
                        <ul class="nav navbar-nav-custom">
                            <!-- Main Sidebar Toggle Button -->
                            <li>
                                <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');this.blur();">
                                    <i class="fa fa-bars fa-fw"></i>
                                </a>
                            </li>
                            <!-- END Main Sidebar Toggle Button -->

                            <!-- Template Options -->
                            <!-- Change Options functionality can be found in js/app.js - templateOptions() -->
                            <li class="dropdown">
                                <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="gi gi-settings"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-custom dropdown-options">
                                    <li class="dropdown-header text-center">Header Style</li>
                                    <li>
                                        <div class="btn-group btn-group-justified btn-group-sm">
                                            <a href="javascript:void(0)" class="btn btn-primary" id="options-header-default">Light</a>
                                            <a href="javascript:void(0)" class="btn btn-primary" id="options-header-inverse">Dark</a>
                                        </div>
                                    </li>
                                    <li class="dropdown-header text-center">Page Style</li>
                                    <li>
                                        <div class="btn-group btn-group-justified btn-group-sm">
                                            <a href="javascript:void(0)" class="btn btn-primary" id="options-main-style">Default</a>
                                            <a href="javascript:void(0)" class="btn btn-primary" id="options-main-style-alt">Alternative</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- END Template Options -->
                        </ul>
                        <!-- END Left Header Navigation -->

                        <!-- Search Form -->
                        <form action="${pageContext.request.contextPath}/blog-search-page" class="navbar-form-custom">
                            <div class="form-group">
                                <input type="search" id="top-search" name="text" class="form-control" placeholder="Search..">
                            </div>
                        </form>
                    
                        <!-- END Search Form -->

                        <!-- Right Header Navigation -->
                        <ul class="nav navbar-nav-custom pull-right">
                            <!-- Alternative Sidebar Toggle Button -->
                             
                            <!-- END Alternative Sidebar Toggle Button -->

                            <!-- User Dropdown -->
                           
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src='<c:out value="${pageContext.request.contextPath}/${user.image}"></c:out>' alt="avatar"> <i class="fa fa-angle-down"></i>
                                  
                                </a>
                                <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                    <li class="dropdown-header text-center">Account</li>
                                    <li>
                                        
                                         <sec:authorize access="hasRole('admin')">
                                        <a href="message-list">
                                            <i class="fa fa-envelope-o fa-fw pull-right"></i>
                                             
                                            Messages
                                        </a>
                                        </sec:authorize>
                                          <a href="change-password-form">
                                            <i class="fa fa-cog fa-fw pull-right"></i>
                                             
                                            Change password
                                        </a>
                                         <a href="user-update-form?username=${user.username}">
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
                        <!-- END Right Header Navigation -->
                    </header>
                    <!-- END Header -->
       </body>
       </html>