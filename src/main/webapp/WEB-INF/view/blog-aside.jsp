<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
 <aside class="col-lg-4">
          <!-- Widget [Search Bar Widget]-->
          <div class="widget search">
            <header>
              <h3 class="h6">Search the blog</h3>
            </header>
            <form action="${pageContext.request.contextPath}/blog-search-page" class="search-form">
              <div class="form-group">
                <input type="search" placeholder="What are you looking for?" name="text">
                <button type="submit" class="submit"><i class="icon-search"></i></button>
              </div>
            </form>
          </div>
          <!-- Widget [Latest Posts Widget]        -->
          <div class="widget latest-posts">
            <header>
              <h3 class="h6">Latest Posts</h3>
            </header>
           
            <c:forEach var="blog" items="${top3BlogList}">
            <div class="blog-posts"><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                <div class="item d-flex align-items-center">
                  <div class="image"><img src="${pageContext.request.contextPath}/${blog.image}" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${blog.blog_title}</strong>
                    <div class="d-flex align-items-center">
                      <div class="views"><i class="icon-eye"></i> ${blog.visit_count}</div>
                      <div class="comments"><i class="icon-comment"></i>${blog.comment_count}</div>
                    </div>
                  </div>
                </div></a><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
               </a>
                
                </div>
            </c:forEach>
                
          </div>
          <!-- Widget [Categories Widget]-->
          <div class="widget categories">
            <header>
              <h3 class="h6">Categories</h3>
            </header>
            <c:forEach var="categoryTop" items="${categoryListPriorityTop4}">
            
            
            <div class="item d-flex justify-content-between"><a href="${pageContext.request.contextPath}/blog-post-category/${categoryTop.category_name}/${categoryTop.id_category}">${categoryTop.category_name}</a>${categoryTop.category_blog_count}</div>
            </c:forEach>
      
          </div>
          <!-- Widget [Tags Cloud Widget]-->
          <div class="widget tags">       
            <header>
              <h3 class="h6">Tags</h3>
            </header>
            <ul class="list-inline">
            
            <c:forEach var="tag" items="${tagList}">
              <li class="list-inline-item"><a href="${pageContext.request.contextPath}/blog-post-tags/${tag.tagSeoName}/${tag.id_tag}" class="tag">${tag.tag_name}</a></li>
              
            </c:forEach>
            </ul>
          </div>
        </aside>