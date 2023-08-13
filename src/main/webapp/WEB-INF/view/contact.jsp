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
        
        <style>
			.error {
				color: #ff0000;
				font-style: italic;
			}
		</style>
  </head>
  <body>
      <c:import url="index-header.jsp">
      <c:param name="user" value="${user}" />
      </c:import>
    <!-- Hero Section -->
    <section style="background: url(${pageContext.request.contextPath}/front/img/hero.jpg); background-size: cover; background-position: center center" class="hero">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h1>Have an interesting news or idea? Don't hesitate to contact us!</h1>
          </div>
        </div>
      </div>
    </section>
    <div class="container">
      <div class="row">
        <!-- Latest Posts -->
        <main class="col-lg-8"> 
          <div class="container">
            <form:form action="message-save" method="post" modelAttribute="message" class="commenting-form">
            <form:hidden path="message_date"/>
            <form:hidden path="seen"/>
              <div class="row">
                <div class="form-group col-md-6">
                  <form:input path="name" type="text" placeholder="Your Name" class="form-control"/>
                  <form:errors path="name" cssClass="error"></form:errors>
                </div>
                 
                 
                <div class="form-group col-md-6">
                  <form:input path="email" type="email" placeholder="Email Address (will not be published)" class="form-control"/>
                  <form:errors path="email" cssClass="error"></form:errors>
                </div>
 
                <div class="form-group col-md-12">
                  <form:textarea path="content" placeholder="Type your message" class="form-control" rows="20"></form:textarea>
                  <form:errors path="content" cssClass="error"></form:errors>
                </div>
              
                <div class="form-group col-md-12">
                  <button type="submit" class="btn btn-secondary">Submit Your Message</button>
                </div>
              </div>
            </form:form>
          </div>
        </main>
        <aside class="col-lg-4">
          <!-- Widget [Contact Widget]-->
          <div class="widget categories">
            <header>
              <h3 class="h6">Contact Info</h3>
              <div class="item d-flex justify-content-between">
                <span>${contact.adress }</span>
                <span><i class="fa fa-map-marker"></i></span>
              </div>
              <div class="item d-flex justify-content-between">
                <span>${contact.phone_number}</span>
                <span><i class="fa fa-phone"></i></span>
              </div>
              <div class="item d-flex justify-content-between">
                <span>${contact.email}</span>
                <span><i class="fa fa-envelope"></i></span>
              </div>
            </header>
            
          </div>
          <div class="widget latest-posts">
            <header>
              <h3 class="h6">Latest Posts</h3>
            </header>
 
            <div class="blog-posts">
            <c:forEach var="blog" items="${top3BlogList}">
            <a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
              <div class="item d-flex align-items-center">
                <div class="image"><img src="${pageContext.request.contextPath}/${blog.image}" alt="..." class="img-fluid"></div>
                <div class="title"><strong>${blog.blog_title}</strong>
                  <div class="d-flex align-items-center">
                    <div class="views"><i class="icon-eye"></i>${blog.visit_count}</div>
                    <div class="comments"><i class="icon-comment"></i>12</div>
                  </div>
                </div>
              </div></a>
              
             </c:forEach>
              
              </div>
          </div>
        </aside>
      </div>
    </div>
    <!-- Page Footer-->
    <c:import url="index-footer.jsp"></c:import>
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/front/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/front/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/front/vendor/@fancyapps/fancybox/jquery.fancybox.min.js"></script>
    <script src="${pageContext.request.contextPath}/front/js/front.js"></script>
  </body>
</html>