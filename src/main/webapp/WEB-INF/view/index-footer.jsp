<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <!-- Page Footer-->
    <footer class="main-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="logo">
              <h6 class="text-white">Bootstrap Blog</h6>
            </div>
            <div class="contact-details">
              <p>${contact.adress }</p>
              <p>${contact.phone_number }</p>
              <p>Email: <a href="mailto:info@company.com">${contact.email }</a></p>
              <ul class="social-menu">
                <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-behance"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-pinterest"></i></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="menus d-flex">
              <ul class="list-unstyled">
                <li> <a href="${pageContext.request.contextPath}/index">Home</a></li>
                <li> <a href="${pageContext.request.contextPath}/blog">Blog</a></li>
                <li> <a href="${pageContext.request.contextPath}/contact">Contact</a></li>
                <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
              </ul>
              
               
              <ul class="list-unstyled">
              	<c:forEach var="category" items="${categoryListPriorityTop4}">
                <li> <a href="${pageContext.request.contextPath}/blog-post-category/${category.category_name}/${category.id_category}">${category.category_name}</a></li>
                </c:forEach>
              </ul>
               
            </div>
          </div>
          <div class="col-md-4">
            <div class="latest-posts">
            <c:forEach var="blog" items="${latestBlogListFooter}">
         
            	<a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="${pageContext.request.contextPath}/${blog.image}" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${blog.blog_title}</strong><span class="date last-meta">${blog.dateStringFooter}</span></div>
                </div></a>
             
                   
            </c:forEach>
                </div>
          </div>
        </div>
      </div>
      <div class="copyrights">
        <div class="container">
          <div class="row">
            <div class="col-md-6">
              <p>&copy; 2017. All rights reserved. Your great site.</p>
            </div>
            <div class="col-md-6 text-right">
              <p>Template By <a href="https://bootstrapious.com/p/bootstrap-carousel" class="text-white">Bootstrapious</a>
                <!-- Please do not remove the backlink to Bootstrap Temple unless you purchase an attribution-free license @ Bootstrap Temple or support us at http://bootstrapious.com/donate. It is part of the license conditions. Thanks for understanding :)                         -->
              </p>
            </div>
          </div>
        </div>
      </div>
    </footer>