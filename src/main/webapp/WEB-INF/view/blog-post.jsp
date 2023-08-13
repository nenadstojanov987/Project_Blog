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
    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/plugins/owl-carousel2/assets/owl.carousel.min.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/plugins/owl-carousel2/assets/owl.theme.default.min.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/header-navbar.css">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
  
    <!-- Page header -->
   <c:import url="index-header.jsp">
   <c:param name="user" value="${user}" />
   </c:import>
     <!-- End Page header -->
     
    <div class="container">
      <div class="row">
        <!-- Latest Posts -->
        <main class="post blog-post col-lg-8"> 
          <div class="container">
            <div class="post-single">
              <div class="post-thumbnail"><img src="${pageContext.request.contextPath}/${blogProduct.image}" class="img-fluid" alt="..."></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="category"><a href="${pageContext.request.contextPath}/blog-post-category/${blogProduct.category.category_name}/${blogProduct.category.id_category}">${blogProduct.blogCategoryName}</a></div>
                </div>
                <h1>${blogProduct.blog_title}<a href="#"><i class="fa fa-bookmark-o"></i></a></h1>
                <div class="post-footer d-flex align-items-center flex-column flex-sm-row"><a href="${pageContext.request.contextPath}/blog-post-author/${blogProduct.user.name}-${blogProduct.user.surname}/${blogProduct.user.username}" class="author d-flex align-items-center flex-wrap">
                    <span class="avatar"><img src="${pageContext.request.contextPath}/${blogProduct.user.image}" alt="..." class="img-fluid"></span>
                    <span class="title">${blogProduct.user.name} ${blogProduct.user.surname}</span></a>
                  <div class="d-flex align-items-center flex-wrap">       
                    <span class="date"><i class="icon-clock"></i> ${blogProduct.dateCreatedString} </span>
                    <span class="views"><i class="icon-eye"></i>${blogProduct.visit_count}</span>
                    <span class="comments meta-last"><a href="#post-comments"><i class="icon-comment"></i>${blogProduct.comment_count}</a></span>
                  </div>
                </div>
                <div class="post-body">
                  <p class="lead">${blogProduct.description}</p>
                  <p>${blogProduct.content}</p>
                  <!--  
                  
                  <p> <img src="img/featured-pic-3.jpeg" alt="..." class="img-fluid"></p>
                  <h3>Lorem Ipsum Dolor</h3>
                  <p>div Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda temporibus iusto voluptates deleniti similique rerum ducimus sint ex odio saepe. Sapiente quae pariatur ratione quis perspiciatis deleniti accusantium</p>
                  <blockquote class="blockquote">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</p>
                    <footer class="blockquote-footer">Someone famous in
                      <cite title="Source Title">Source Title</cite>
                    </footer>
                  </blockquote>
                  <p>quasi nam. Libero dicta eum recusandae, commodi, ad, autem at ea iusto numquam veritatis, officiis. Accusantium optio minus, voluptatem? Quia reprehenderit, veniam quibusdam provident, fugit iusto ullam voluptas neque soluta adipisci ad.</p>
                </div>
                -->
               
                <div class="post-tags">
                 <c:forEach var="tag" items="${blogTagList}">
               		 <a href="${pageContext.request.contextPath}/blog-post-tags/${tag.tagSeoName}/${tag.id_tag}" class="tag">${tag.tag_name}</a>
                 </c:forEach>
                </div>
               
           
                <div class="posts-nav d-flex justify-content-between align-items-stretch flex-column flex-md-row">
                <c:choose>
                <c:when test="${currentBlogIndex==lastBlogIndex}">
                 
                    <div class="text"><strong class="text-primary"> </strong>
                   
                    </div>
                     
                </c:when>
                <c:otherwise>
                <a href="${pageContext.request.contextPath}/blog-post/${previousBlogPost.blogProductSeoTitle}/${previousBlogPost.id_blog_product}" class="prev-post text-left d-flex align-items-center">
                    <div class="icon prev"><i class="fa fa-angle-left"></i></div>
                    <div class="text"><strong class="text-primary">Previous Post </strong>
                      <h6>${previousBlogPost.blog_title}</h6>
                    </div>
                    
                    </a>
                </c:otherwise>
                </c:choose>
                
                 <c:choose>
	                <c:when test="${currentBlogIndex==0}">
	                
	                </c:when>
	                <c:otherwise>
	                    <a href="${pageContext.request.contextPath}/blog-post/${nextBlogPost.blogProductSeoTitle}/${nextBlogPost.id_blog_product}" class="next-post text-right d-flex align-items-center justify-content-end">
	                    <div class="text"><strong class="text-primary">Next Post </strong>
	                      <h6>${nextBlogPost.blog_title}</h6>
	                    </div>
	                    <div class="icon next"><i class="fa fa-angle-right">   </i></div></a>
	                </c:otherwise>
            
            	</c:choose>
             	       
                    </div>
                
                 
                <div class="post-comments" id="post-comments">
                  <header>
                    <h3 class="h6">Post Comments<span class="no-of-comments">(${blogCommentList.size()})</span></h3>
                  </header>
                  <c:forEach var="blogComment" items="${blogCommentList}">
                  <div class="comment">
                    <div class="comment-header d-flex justify-content-between">
                      <div class="user d-flex align-items-center">
                        
                        <c:choose>
                       	<c:when test="${blogComment.visitor.visitor_image==null}">
                       		 <div class="image"><img src="${pageContext.request.contextPath}/front/img/user.svg" alt="..." class="img-fluid rounded-circle"></div>
                        </c:when>
                        <c:otherwise>
                       		  <div class="image"><img src="${pageContext.request.contextPath}/${blogComment.visitor.visitor_image}" alt="..." class="img-fluid rounded-circle"></div>
                        </c:otherwise>
                         </c:choose>
                        
                        <div class="title"><strong>${blogComment.visitor.visitor_name}</strong><span class="date">${blogComment.blog_comment_date}</span></div>
                      </div>
                    </div>
                    <div class="comment-body">
                      <p>${blogComment.content}</p>
                    </div>
                  </div>
				</c:forEach>

                </div>
                
                <div class="add-comment">
                  <header>
                    <h3 class="h6">Leave a reply</h3>
                  </header>
                  <form:form action="${pageContext.request.contextPath}/blog-comment-save?id_blog_product=${blogProduct.id_blog_product}" modelAttribute="blogComment" class="commenting-form">
                  <form:hidden path="blog_product_id"/>
      			  <form:hidden path="blog_comment_date" />
       				<form:hidden path="enabled" />
                    <div class="row">
                      
                      <c:choose>
                     	<c:when test="${user!=null}">
                     		
                     		<div class="form-group col-md-6">
		                      
		                        <form:input path="visitor.visitor_name" name="visitor.visitor_name" value="${user.name}" type="text" id="visitor.visitor_name" placeholder="Name" class="form-control"/>
		                          <div><form:errors path="visitor.visitor_name" cssClass="text-red" /> </div>
		                      </div>
		                     
		                      
		                      <div class="form-group col-md-6">
		                        <form:input path="visitor.email" type="email" name="visitor.email" id="visitor.email" value ="${user.email}" placeholder="Email Address (will not be published)" class="form-control"/>
		                      		<div><form:errors path="visitor.email" cssClass="text-red" /> </div>
							 </div>
		                        
                     		
                     	</c:when>
                     	<c:otherwise>
                     	 
		                      <div class="form-group col-md-6">
		                      
		                        <form:input path="visitor.visitor_name" name="visitor.visitor_name" type="text" id="visitor.visitor_name" placeholder="Name" class="form-control"/>
		                         <div><form:errors path="visitor.visitor_name" cssClass="text-red" /> </div>
		                      </div>
		                      
		                      
		                      <div class="form-group col-md-6">
		                        <form:input path="visitor.email" type="email" required="true"  name="visitor.email" id="visitor.email" placeholder="Email Address (will not be published)" class="form-control"/>
		                    	 <div><form:errors path="visitor.email" cssClass="text-red" /> </div>
		                      </div>
		                      
		                      
		                  </c:otherwise> 
		            </c:choose>
		            
                      <div class="form-group col-md-12">
                        <form:textarea path="content" name="content" id="content" placeholder="Type your comment" class="form-control"></form:textarea>
                      </div>
                       <div><form:errors path="content" cssClass="text-red" /> </div>
                      
                      <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-secondary">Submit Comment</button>
                      </div>
                      
                    </div>
                  </form:form>
                </div>
                
                
              </div>
            </div>
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