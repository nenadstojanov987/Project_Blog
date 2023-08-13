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


    
    <!-- owl carousel 2 stylesheet-->

 
    
  </head>
  <body>
  
    <!-- Page header -->
    <c:import url="index-header.jsp">
    	<c:param name="user" value="${user}" />
    </c:import>
	<!-- End Page header -->
	
    <!-- Hero Section-->
    <div id="index-slider" class="owl-carousel">
    <c:forEach var="slider" items="${sliderList}">
    
      <section style="background: url(${slider.image}); background-size: cover; background-position: center center" class="hero">
        <div class="container">
          <div class="row">
            <div class="col-lg-7">
              <h1>${slider.description}</h1>
              <a href="${slider.url}" class="hero-link">${slider.button_title}</a>
            </div>
          </div>
        </div>
      </section>
      </c:forEach>
     
    </div>

    <!-- Intro Section-->
    <section class="intro">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <h2 class="h3">Some great intro here</h2>
            <p class="text-big">Place a nice <strong>introduction</strong> here <strong>to catch reader's attention</strong>.</p>
          </div>
        </div>
      </div>
    </section>
    <section class="featured-posts no-padding-top">
        <!-- Post-->
        <div class="container">
        <!-- Post-->
        <div class="row d-flex align-items-stretch">
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog1.category.category_name}/${blog1.category.id_category}">${blog1.blogCategoryName}</a></div><a href="${pageContext.request.contextPath}/blog-post/${blog1.blogProductSeoTitle}/${blog1.id_blog_product}">
                    <h2 class="h4">${blog1.blog_title}</h2></a>
                </header>
                <p>${blog1.description}</p>
                <footer class="post-footer d-flex align-items-center"><a href="${pageContext.request.contextPath}/blog-post-author/${blog1.user.name}-${blog1.user.surname}/${blog1.user.username}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${pageContext.request.contextPath}/${blog1.user.image}" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${blog1.user.name} ${blog1.user.surname}</span></div></a>
                  <div class="date"><i class="icon-clock"></i> ${blog1.dateCreatedString}</div>
                  <div class="comments"><i class="icon-comment"></i>${blog1.comment_count}</div>
                </footer>
              </div>
            </div>
          </div>
          <div class="image col-lg-5" style="min-height: 369.6px;"><img src="${pageContext.request.contextPath}/${blog1.image}" style="height: 369.6px; width: 520px;" alt="..."></div>
        </div>
        <!-- Post        -->
        <div class="row d-flex align-items-stretch">
          <div class="image col-lg-5" style="min-height: 369.6px;"><img src="${pageContext.request.contextPath}/${blog2.image}" style="height: 369.6px; width: 520px;" alt="..."></div>
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog2.category.category_name}/${blog2.category.id_category}">${blog2.blogCategoryName}</a></div><a href="${pageContext.request.contextPath}/blog-post/${blog2.blogProductSeoTitle}/${blog2.id_blog_product}">
                    <h2 class="h4">${blog2.blog_title}</h2></a>
                </header>
                <p>${blog2.description}</p>
                <footer class="post-footer d-flex align-items-center"><a href="${pageContext.request.contextPath}/blog-post-author/${blog2.user.name}-${blog2.user.surname}/${blog2.user.username}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${pageContext.request.contextPath}/${blog2.user.image}" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${blog2.user.name} ${blog2.user.surname}</span></div></a>
                  <div class="date"><i class="icon-clock"></i> ${blog2.dateCreatedString}</div>
                  <div class="comments"><i class="icon-comment"></i>${blog2.comment_count}</div>
                </footer>
              </div>
            </div>
          </div>
        </div>
        <!-- Post                            -->
        <div class="row d-flex align-items-stretch">
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog3.category.category_name}/${blog3.category.id_category}">${blog3.blogCategoryName}</a></div><a href="${pageContext.request.contextPath}/blog-post/${blog3.blogProductSeoTitle}/${blog3.id_blog_product}">
                    <h2 class="h4">${blog3.blog_title}</h2></a>
                </header>
                <p>${blog3.description}</p>
                <footer class="post-footer d-flex align-items-center"><a href="${pageContext.request.contextPath}/blog-post-author/${blog3.user.name}-${blog3.user.surname}/${blog3.user.username}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${pageContext.request.contextPath}/${blog3.user.image}" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${blog3.user.name} ${blog3.user.surname}</span></div></a>
                  <div class="date"><i class="icon-clock"></i> ${blog3.dateCreatedString}</div>
                  <div class="comments"><i class="icon-comment"></i>${blog3.comment_count}</div>
                </footer>
              </div>
            </div>
          </div>
          <div class="image col-lg-5" style="min-height: 369.6px;"><img src="${pageContext.request.contextPath}/${blog3.image}" style="height: 369.6px; width: 520px;" alt="..."></div>
        </div>
      
         
      </div>
    </section>
    <!-- Divider Section-->
    <section style="background: url(${pageContext.request.contextPath}/front/img/divider-bg.jpg); background-size: cover; background-position: center bottom" class="divider">
      <div class="container">
        <div class="row">
          <div class="col-md-7">
            <h2>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</h2>
            <a href="contact.html" class="hero-link">Contact Us</a>
          </div>
        </div>
      </div>
    </section>
    <!-- Latest Posts -->
    <section class="latest-posts"> 
      <div class="container">
        <header> 
          <h2>Latest from the blog</h2>
          <p class="text-big">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
        </header>
         
        <div class="owl-carousel" id="latest-posts-slider">
          <div class="row">
          <c:forEach var="blog" items="${latestBlogList1}">
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}"><img src="${pageContext.request.contextPath}/${blog.image}" style="height: 246px; width: 350px;" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${blog.date_string}</div>
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog.category.category_name}/${blog.category.id_category}">${blog.blogCategoryName}</a></div>
                </div><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                  <h3 class="h4">${blog.blog_title}</h3></a>
                <p class="text-muted">${blog.description}</p>
              </div>
            </div>
          </c:forEach>
             
          </div>
          
          <div class="row">
          <c:forEach var="blog" items="${latestBlogList2}">
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}"><img src="${pageContext.request.contextPath}/${blog.image}" style="height: 246px; width: 350px;" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${blog.date_string}</div>
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog.category.category_name}/${blog.category.id_category}">${blog.blogCategoryName}</a></div>
                </div><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                  <h3 class="h4">${blog.blog_title}</h3></a>
                <p class="text-muted">${blog.description}</p>
              </div>
            </div>
          </c:forEach>
             
          </div>
          
          <div class="row">
          <c:forEach var="blog" items="${latestBlogList3}">
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}"><img src="${pageContext.request.contextPath}/${blog.image}" style="height: 246px; width: 350px;" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${blog.date_string}</div>
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog.category.category_name}/${blog.category.id_category}">${blog.blogCategoryName}</a></div>
                </div><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                  <h3 class="h4">${blog.blog_title}</h3></a>
                <p class="text-muted">${blog.description}</p>
              </div>
            </div>
          </c:forEach>
             
          </div>
          
          <div class="row">
          <c:forEach var="blog" items="${latestBlogList4}">
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}"><img src="${pageContext.request.contextPath}/${blog.image}" style="height: 246px; width: 350px;" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${blog.date_string}</div>
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blog.category.category_name}/${blog.category.id_category}">${blog.blogCategoryName}</a></div>
                </div><a href="${pageContext.request.contextPath}/blog-post/${blog.blogProductSeoTitle}/${blog.id_blog_product}">
                  <h3 class="h4">${blog.blog_title}</h3></a>
                <p class="text-muted">${blog.description}</p>
              </div>
            </div>
          </c:forEach>
             
          </div>
           
        </div>
        
      </div>
    </section>
    <!-- Gallery Section-->
    <section class="gallery no-padding">    
      <div class="row">
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath}/front/img/gallery-1.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath}/front/img/gallery-1.jpg" alt="gallery image alt 1" class="img-fluid" title="gallery image title 1">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath}/front/img/gallery-2.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath}/front/img/gallery-2.jpg" alt="gallery image alt 2" class="img-fluid" title="gallery image title 2">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath}/front/img/gallery-3.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath}/front/img/gallery-3.jpg" alt="gallery image alt 3" class="img-fluid" title="gallery image title 3">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath}/front/img/gallery-4.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath}/front/img/gallery-4.jpg" alt="gallery image alt 4" class="img-fluid" title="gallery image title 4">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        
      </div>
    </section>
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


    <script src="${pageContext.request.contextPath}/front/plugins/owl-carousel2/owl.carousel.min.js"></script>
    <script>
      $("#index-slider").owlCarousel({
        "items": 1,
        "loop": true,
        "autoplay": true,
        "autoplayHoverPause": true
      });

      $("#latest-posts-slider").owlCarousel({
        "items": 1,
        "loop": true,
        "autoplay": true,
        "autoplayHoverPause": true
      });
    </script>
    
  </body>
</html>