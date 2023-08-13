<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Blog - B4 Template by Bootstrap Temple</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/fontastic.css">
    <!-- Google fonts - Open Sans-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <!-- Fancybox-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/vendor/@fancyapps/fancybox/jquery.fancybox.min.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/plugins/owl-carousel2/assets/owl.carousel.min.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/plugins/owl-carousel2/assets/owl.theme.default.min.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/header-navbar.css">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
  <!-- Page header -->
   <c:import url="index-header.jsp"></c:import>
     <!-- End Page header -->
    <div class="container">
      <div class="row">
        <!-- Latest Posts -->
        <main class="posts-listing col-lg-8"> 
          <div class="container">
         
          
          <h2 class="mb-3 author d-flex align-items-center flex-wrap">
              <span class="avatar"><img src="${pageContext.request.contextPath}/${author_image}" alt="..." class="img-fluid rounded-circle" style="witdh: 100px; height:100px;"></span>
            
                <div class="title">
                <span>Posts by author "${author_name}"</span>
              </div>
            </h2>
            <div class="row">
            
            <c:forEach var="blog" items="${blogListByAuthor}">
            
            <!-- blog-post?id_blog_product=${blog.id_blog_product} -->
              <!-- post -->
              <div class="post col-xl-6">
                <div class="post-thumbnail"><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}"><img src="${pageContext.request.contextPath}/${blog.image}" alt="..." class="img-fluid" style=" height: 233px; width: 350px;"></a></div>
                <div class="post-details">
                
                  <div class="post-meta d-flex justify-content-between">
                    <div class="date meta-last">${blog.date_string}</div>
                    <c:choose>
               		<c:when test="${blog.category.category_name=='Uncategorized'}">
                  		  <span style="color: #999; letter-spacing: 0.05em; font-weight: 700; text-transform: uppercase; text-decoration: none; ">${blog.category.category_name}</span>
					</c:when>
					<c:otherwise>
					<div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog.category.category_name}/${blog.category.id_category}">${blog.category.category_name}</a></div>
					</c:otherwise>
					</c:choose>
                         
                  </div><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                    	<h3 class="h4">${blog.blog_title}</h3></a>
                  <p class="text-muted">${blog.description}</p>
                  
                  <footer class="post-footer d-flex align-items-center"><a href="${pageContext.request.contextPath}/blog-post-author/${blog.user.name}-${blog.user.surname}/${blog.user.username}" class="author d-flex align-items-center flex-wrap">
                      <span class="avatar"><img src="${pageContext.request.contextPath}/${blog.user.image}" alt="..." class="img-fluid"></span>
                      <span class="title">${blog.user.name} ${blog.user.surname}</span></a>
                    <span class="date"><i class="icon-clock"></i>${blog.dateCreatedString} </span>
                    <span class="comments meta-last"><i class="icon-comment"></i>${blog.comment_count}</span>
                  </footer>
                </div>
              </div>
              
               </c:forEach>
               
            </div>
            <!-- Pagination -->
            <!--  
            <nav aria-label="Page navigation example">
              <ul class="pagination pagination-template d-flex justify-content-center">
                 <li class="page-item"><a href="blog?pageNumber=${previousPage}" class="page-link"> <i class="fa fa-angle-left"></i></a></li>
                <c:forEach var="count" items="${pageCountArr}">
                	
                	<li class="page-item"><a href="blog?pageNumber=${count}" class="page-link">${count}</a></li>
                	
                </c:forEach>
               <li class="page-item"><a href="blog?pageNumber=${nextPage}" class="page-link"> <i class="fa fa-angle-right"></i></a></li>
                <!-- 
                <li class="page-item"><a href="#" class="page-link active">1</a></li>
                
                <li class="page-item"><a href="#" class="page-link">3</a></li>
                
              </ul>
            </nav>
           -->
          </div>
        </main>
        <!-- Aside -->
        
         <c:import url="blog-aside.jsp"></c:import>
         
          <!-- Aside -->
      </div>
    </div>
    <!-- Page Footer-->
     <c:import url="index-footer.jsp"></c:import>
    <!-- End Page Footer-->
    
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/front/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/front/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/front/vendor/@fancyapps/fancybox/jquery.fancybox.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/js/front.js"></script>
  </body>
</html>