<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
    
<div id="sidebar">
 
                    <!-- Wrapper for scrolling functionality -->
                    <div id="sidebar-scroll">
                        <!-- Sidebar Content -->
                        <div class="sidebar-content">
                            <!-- Brand -->
                            <a href="dashboard" class="sidebar-brand">
                                <i class="gi gi-oldman"></i><span class="sidebar-nav-mini-hide"><strong>Admin|</strong>Page</span>
                            </a>
                            <!-- END Brand -->

                            <!-- User Info -->
                            <div class="sidebar-section sidebar-user clearfix sidebar-nav-mini-hide">
                                <div class="sidebar-user-avatar">
                                    <a href="user-update-form?username=${user.username}">
                                        <img src="${pageContext.request.contextPath}/${user.image}" alt="avatar">
                                    </a>
                                </div>
                                <div class="sidebar-user-name">${user.name} ${user.surname }</div>
                                <div class="sidebar-user-links">
                                    <a href="user-update-form?username=${user.username}" data-toggle="tooltip" data-placement="bottom" title="Profile"><i class="gi gi-user"></i></a>
                                    <a href="message-list" data-toggle="tooltip" data-placement="bottom" title="Messages"><i class="gi gi-envelope"></i></a>
                                    
                                    <a href="change-password-form" data-toggle="tooltip" data-placement="bottom" title="Change-Password"><i class="gi gi-cogwheel"></i></a>
                                    <a href="${pageContext.request.contextPath}/logout" data-toggle="tooltip" data-placement="bottom" title="Logout"><i class="gi gi-exit"></i></a>
                                </div>
                            </div>
                            <!-- END User Info -->

                            <!-- Theme Colors -->
                            <!-- Change Color Theme functionality can be found in js/app.js - templateOptions() -->
                          
                            <!-- Sidebar Navigation -->
                            <ul class="sidebar-nav">
                              
                               <li>
                                    <a href="dashboard"><i class="gi gi-dashboard sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Dashboard</span></a>
                                </li>
                                
                                <li>
                                    <a href="#" class="sidebar-nav-menu"><i class="fa fa-angle-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-desktop sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Blog-Administration</span></a>
                                    <ul>
                                    <sec:authorize access="hasRole('admin')">
                                        <li>
                                            <a href="slider-list">Slider list</a>
                                        </li>
                                     </sec:authorize>
                                        <li>
                                            <a href="category-list">Category list</a>
                                        </li>
                                        <li>
                                            <a href="tag-list">Tag list</a>
                                        </li>
                                        <li>
                                            <a href="blog-list">Blog list</a>
                                        </li>
                                        <li>
                                            <a href="comment-list">Comment list</a>
                                        </li>
                                         <sec:authorize access="hasRole('admin')">
                                        <li>
                                            <a href="user-lista">Users list</a>
                                        </li>
                                         </sec:authorize>
                                    </ul>
                                </li>
                                
                                <li class="sidebar-header">
                                    
                                    <span class="sidebar-header-title">Administration</span>
                                </li>
                                
                                <li>
                                    <a href="blog-form"><i class="fa fa-file-text-o sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Add new Blog</span></a>
                                </li>
                                
                                <li>
                                    <a href="category-form"><i class="gi gi-folder_plus sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Add new Category</span></a>
                                </li>
                                
                                <li>
                                    <a href="tag-form"><i class="fa fa-hashtag sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Add new Tag</span></a>
                                </li>
                                
                                 <sec:authorize access="hasRole('admin')">
                                <li>
                                    <a href="slider-form"><i class="fa fa-picture-o sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Add new Slider</span></a>
                                </li>
                                <li>
                                    <a href="user-add"><i class="fa fa-user-plus sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Add new User/Admin</span></a>
                                </li>
                                
                                </sec:authorize>
                                <li>
                                    <a href="${pageContext.request.contextPath}/index" target="_blank" class=" active"><i class="gi gi-home sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">Blog-Homepage</span></a>
                                </li>
                               
                            </ul>
                            <!-- END Sidebar Navigation -->

                            <!-- Sidebar Notifications -->
                          
                            <!-- END Sidebar Notifications -->
                        </div>
                        <!-- END Sidebar Content -->
                    </div>
                    <!-- END Wrapper for scrolling functionality -->
                </div>
                <!-- END Main Sidebar -->
                
                