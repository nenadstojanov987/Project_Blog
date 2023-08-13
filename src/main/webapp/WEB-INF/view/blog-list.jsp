<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">

        <title>Blog list- welcome to Admin page</title>

        <meta name="description" content="ProUI is a Responsive Bootstrap Admin Template created by pixelcave and published on Themeforest.">
        <meta name="author" content="pixelcave">
        <meta name="robots" content="noindex, nofollow">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="img/favicon.png">
        <link rel="apple-touch-icon" href="img/icon57.png" sizes="57x57">
        <link rel="apple-touch-icon" href="img/icon72.png" sizes="72x72">
        <link rel="apple-touch-icon" href="img/icon76.png" sizes="76x76">
        <link rel="apple-touch-icon" href="img/icon114.png" sizes="114x114">
        <link rel="apple-touch-icon" href="img/icon120.png" sizes="120x120">
        <link rel="apple-touch-icon" href="img/icon144.png" sizes="144x144">
        <link rel="apple-touch-icon" href="img/icon152.png" sizes="152x152">
        <link rel="apple-touch-icon" href="img/icon180.png" sizes="180x180">
        <!-- END Icons -->

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css">

        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/plugins.css">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/main.css">
         <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/custom2.css"> 

        <!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/themes.css">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="${pageContext.request.contextPath}/admin/js/vendor/modernizr.min.js"></script>
    </head>
    <body>
        <!-- Page Wrapper -->
        <!-- In the PHP version you can set the following options from inc/config file -->
        <!--
            Available classes:

            'page-loading'      enables page preloader
        -->
        <div id="page-wrapper">
            <!-- Preloader -->
            <!-- Preloader functionality (initialized in js/app.js) - pageLoading() -->
            <!-- Used only if page preloader is enabled from inc/config (PHP version) or the class 'page-loading' is added in #page-wrapper element (HTML version) -->
            <div class="preloader themed-background">
                <h1 class="push-top-bottom text-light text-center"><strong>Pro</strong>UI</h1>
                <div class="inner">
                    <h3 class="text-light visible-lt-ie10"><strong>Loading..</strong></h3>
                    <div class="preloader-spinner hidden-lt-ie10"></div>
                </div>
            </div>
            <!-- END Preloader -->

            <!-- Page Container -->
            <!-- In the PHP version you can set the following options from inc/config file -->
            <!--
                Available #page-container classes:

                '' (None)                                       for a full main and alternative sidebar hidden by default (> 991px)

                'sidebar-visible-lg'                            for a full main sidebar visible by default (> 991px)
                'sidebar-partial'                               for a partial main sidebar which opens on mouse hover, hidden by default (> 991px)
                'sidebar-partial sidebar-visible-lg'            for a partial main sidebar which opens on mouse hover, visible by default (> 991px)
                'sidebar-mini sidebar-visible-lg-mini'          for a mini main sidebar with a flyout menu, enabled by default (> 991px + Best with static layout)
                'sidebar-mini sidebar-visible-lg'               for a mini main sidebar with a flyout menu, disabled by default (> 991px + Best with static layout)

                'sidebar-alt-visible-lg'                        for a full alternative sidebar visible by default (> 991px)
                'sidebar-alt-partial'                           for a partial alternative sidebar which opens on mouse hover, hidden by default (> 991px)
                'sidebar-alt-partial sidebar-alt-visible-lg'    for a partial alternative sidebar which opens on mouse hover, visible by default (> 991px)

                'sidebar-partial sidebar-alt-partial'           for both sidebars partial which open on mouse hover, hidden by default (> 991px)

                'sidebar-no-animations'                         add this as extra for disabling sidebar animations on large screens (> 991px) - Better performance with heavy pages!

                'style-alt'                                     for an alternative main style (without it: the default style)
                'footer-fixed'                                  for a fixed footer (without it: a static footer)

                'disable-menu-autoscroll'                       add this to disable the main menu auto scrolling when opening a submenu

                'header-fixed-top'                              has to be added only if the class 'navbar-fixed-top' was added on header.navbar
                'header-fixed-bottom'                           has to be added only if the class 'navbar-fixed-bottom' was added on header.navbar

                'enable-cookies'                                enables cookies for remembering active color theme when changed from the sidebar links
            -->
            <div id="page-container" class="sidebar-partial sidebar-visible-lg sidebar-no-animations">
                <!-- Alternative Sidebar -->
            
      
                <!-- Main Sidebar -->
                <c:import url="admin-sidebar.jsp"></c:import>
                <!-- END Main Sidebar -->
              

                <!-- Main Container -->
                <div id="main-container">
                    <!-- Header -->
                    <!-- In the PHP version you can set the following options from inc/config file -->
                    <!--
                        Available header.navbar classes:

                        'navbar-default'            for the default light header
                        'navbar-inverse'            for an alternative dark header

                        'navbar-fixed-top'          for a top fixed header (fixed sidebars with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar())
                            'header-fixed-top'      has to be added on #page-container only if the class 'navbar-fixed-top' was added

                        'navbar-fixed-bottom'       for a bottom fixed header (fixed sidebars with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar()))
                            'header-fixed-bottom'   has to be added on #page-container only if the class 'navbar-fixed-bottom' was added
                    -->
                     <c:import url="admin-header.jsp"></c:import>
                    <!-- END Header -->

                    <!-- Page content -->
                    <div id="page-content">
                        <!-- Datatables Header -->
                        <div class="content-header">
                       		<div class="header-section">
                       			 <h1>
                                    Blog list<br><small>View and manage existing blogs</small>
                                </h1>
                                
                            <ul class="nav-horizontal text-center">
                                <li class="active">
                                    <a href="blog-form"><i class="fa fa-file-text-o"></i> Add Blog</a>
                                </li>
                                
                            </ul>
                            </div>
                            
                   <div class="block">
                            <!-- Grid Blocks Title -->
                            <div class="block-title"><h2><strong>Search blog list</strong></h2>
                            
                            </div>
                            <!-- END Grid Blocks Title -->

                            <!-- Grid Blocks Content -->
                     <form class="filter-form" method="GET" action="">
                            <div class="row">
                               
                              <div class="col-sm-2">
                                <div class="block">
                                    <div class="block-title"><h4>Title</h4></div>
                                    <div class="form-group mb-5">
                                                <input type="text" id="title" name="title" class="form-control" placeholder="Enter blog title">
                                                
                                    </div>
                                </div>
                            	</div>
                               
                               
                                <div class="col-sm-2">
                                    <!-- Block 2 -->
                                    <div class="block">
                                        <div class="block-title"><h4>Category</h4></div>
                                         <div class="form-group mb-5">
                                         <select class="form-control" name="id_category">
                                			 <option value="">---Category---</option>
                                				<c:forEach var="category" items="${categoryList}">
                                   
                                   					<option value="${category.id_category}">${category.category_name}</option>
                                   				 </c:forEach>
                               			 </select>
                                		 </div>
                                    </div>
                                    <!-- END Block 2 -->
                                </div>
                                
                                
                                
                                
                                <div class="col-sm-2">
                                    <!-- Block 2 -->
                                    <div class="block">
                                       <div class="block-title"><h4>Tags</h4></div>
                                        	<div class="form-group mb-5">
                                			 
				                               		 <c:forEach var="tag" items="${tagList}">
				                                
						                                	<label class="d-flex">
								                                    <input type="checkbox" name="tag" value="${tag.id_tag}">
								                                    ${tag.tag_name}
								                                    <span class="fake-element"></span>
						                                	</label>
				                              		</c:forEach>
                          					  </div>
                                    </div>
                                    <!-- END Block 2 -->
                                </div>
                                 
                           <sec:authorize access="hasRole('admin')">  
                                 <div class="col-sm-2">
                                    <!-- Block 2 -->
                                    <div class="block">
                                        <div class="block-title"><h4>Author name</h4></div>
                                        <div class="form-group mb-5">
                                         <select class="form-control" name="author_name">
                                			 <option value="">---Author name---</option>
                                				<c:forEach var="user" items="${userList}">
                                   
                                   					<option value="${user.name}">${user.name}</option>
                                   				 </c:forEach>
                               			 </select>
                                	 </div>
                                    </div>
                                    <!-- END Block 2 -->
                                </div>
                                
                                  <div class="col-sm-2">
                                    <!-- Block 2 -->
                                    <div class="block">
                                        <div class="block-title"><h4>Author surname</h4></div>
                                         <div class="form-group mb-5">
                                         <select class="form-control" name="author_surname">
                                			 <option value="">---Author surname---</option>
                                				<c:forEach var="user" items="${userList}">
                                   
                                   					<option value="${user.surname}">${user.surname}</option>
                                   				 </c:forEach>
                               			 </select>
                                 	</div>
                                    </div>
                                    <!-- END Block 2 -->
                                </div>
                             </sec:authorize>
                                <div class="col-sm-2">
                                <div class="block">
                                    <div class="block-title"><h4>Enabled</h4></div>
                                    
                                    
                                   <div class="form-group mb-5">
                                                <label class="checkbox-inline" for="example-inline-checkbox1">
                                                    <input type="checkbox" id="enabled" name="enabled" value="1"> Enabled
                                                </label>
                                                <label class="checkbox-inline" for="example-inline-checkbox2">
                                                    <input type="checkbox" id="enabled" name="enabled" value="0"> Disabled
                                                </label>
                                                 
                                          </div>
                                        
                                    			 
	                              </div>
	                           </div>
                           		 
                                
                           
                            <!-- END Grid Blocks -->
                      
                             </div>
                            
                             <button type="submit" name="filter-form" value="filter" class="btn btn-success text-uppercase">
                             		Apply filter
			                 </button>
				           </form>
                        </div>         
                    
                            
                            
                        </div>
                        
                        
                        <!-- END Datatables Header -->

                        <!-- Datatables Content -->
                    
                            
				                    <c:forEach var="blog" items="${blogList}">
				                          
				                            <div class="col-md-4" style="height: 590px; width: 555px">
				                                <!-- Active Theme Color Widget with Carousel -->
				                                <div class="widget" style="height: 550px; width: 525px">
				                                    <div class="widget-simple">
				                                      
				                                         <div class="post col-xl-6">
				                                               <div class="post-details" >
															                  
												                    <div class="widget-content">
	                                          							  <h2><a href="blog-read?id_blog_product=${blog.id_blog_product}"><strong>${blog.blog_title}</strong></a> 
	                                          							   <c:choose>
			                                          							 	<c:when test="${blog.enabled}">
			                                          							 		 <span class="title meta-last"> <i class="gi gi-disk_saved"></i>Enabled</span>
			                                          							 	</c:when>
			                                          							 	<c:otherwise>
			                                          							 	     <span class="title meta-last"> <i class="gi gi-disk_remove"></i>Disabled</span>
			                                          							 	</c:otherwise>
	                                          									 </c:choose>
	                                          							  </h2>
	                                          							  <div class="category"><a href="blog-category.html">${blog.blogCategoryName}</a>
												                    			
												                    	
	                                          							   <a href="#"><span class="date meta-last"> author: ${blog.user.name} ${blog.user.surname} </span></a>
	                                          								<a href="blog-author.html" class="author d-flex align-items-center flex-wrap">
													                       <img src="${pageContext.request.contextPath}/${blog.user.image}" alt="..." style=" max-width: 40px; min-width: 40px;height: 40px;overflow: hidden; border-radius: 50%; margin-right: 10px;"> 
													                       </a>
	                                          							  
	                                          							 </div>
	                                          							  
	                                       							  </div>
												                  
												               	 
													                  <footer class="post-footer d-flex justify-content-between">
													                  
													                     <span>
													                     <i class="icon-clock"></i> <span class="date"><i class="gi gi-clock"></i>${blog.date_created} </span>
													                     <i class="icon-comment"></i><span class="comments"><i class="gi gi-comments"></i>${blog.comment_count}</span>
													                     <i class="icon-comment"></i><span class="comments"><i class="gi gi-eye_open"></i>${blog.visit_count}</span>
													                    <c:if test="${blog.important}">
		                                            						 <span class="date  meta-last"><i class="gi gi-warning_sign"></i>Important </span>
		                                           					   </c:if>
													                    </span>
													                  </footer>
															      </div>
				                                            
				                                            </div>
				                                     
				                                        
				                                        
				                                    </div>
				                                    <div class="widget-extra-full themed-background-dark-modern">
				                                        <!-- Carousel -->
				                                        <div id="widget-carousel1" class="carousel remove-margin">
				                                            <!-- Wrapper for slides -->
				                                            <div class="carousel-inner">
				                                                <div class="active item">
				                                                    <img src="${pageContext.request.contextPath}/${blog.image}" alt="image" style=" width: 480px;height: 230px;object-fit: cover;">
				                                                </div>
				                                                 
				                                            </div>
				                                            <!-- END Wrapper for slides -->
				 
				                                        </div>
				                                        <!-- END Carousel -->
				                                        
				                                      
				                                    </div>
				                                      
				                                      <div class="text-center">
				                                      
				                                       
				                                      		<div class="btn-group btn-group-sm">
				                                                    <a href="blog-update-form?id_blog_product=${blog.id_blog_product}" data-toggle="tooltip" title="Edit" class="btn btn-success"><i class="fa fa-pencil"></i></a>
				                                                                   
				                                                     <sec:authorize access="hasRole('admin')">
												                       <c:choose>
												                       <c:when test="${blog.enabled}">
												                           		<a href="blog-enabled?id_blog_product=${blog.id_blog_product}" data-toggle="tooltip" title="Disable" class="btn btn-warning"
												                           		onclick="if(!(confirm('Do you want do disable blog ${blog.blog_title}?'))) return false">
												                            		<i class="gi gi-disk_saved"></i> 
												                          		</a>
																		</c:when>
																		<c:otherwise>
																		   		<a href="blog-enabled?id_blog_product=${blog.id_blog_product}" data-toggle="tooltip" title="Enable" class="btn btn-warning"
												                           		onclick="if(!(confirm('Do you want do enable blog ${blog.blog_title}?'))) return false">
												                            		<i class="gi gi-disk_remove"></i> 
												                          		</a>
																		</c:otherwise>
												                       </c:choose>   
												                       </sec:authorize>
				                                                    <a href="blog-delete?id_blog_product=${blog.id_blog_product}" data-toggle="tooltip" title="Delete" class="btn btn-danger" onclick="if(!(confirm('Do you want do delete blog ${blog.blog_title}?'))) return false"><i class="fa fa-times"></i></a>
				                                                    
				                                                </div>
				                                      
				                                      
				                                      </div>
				                               
				                                    
				                                    
				                                </div>
				                                <!-- END Active Theme Color Widget with Carousel -->
				                            </div>
				                                        
				                </c:forEach>
                             
                     
                  
                        <!-- END Datatables Content -->
              
                    <!-- END Page Content -->

                    <!-- Footer -->
                    <footer class="clearfix">
                        <div class="pull-right">
                            Crafted with <i class="fa fa-heart text-danger"></i> by <a href="https://1.envato.market/ydb" target="_blank">pixelcave</a>
                        </div>
                        <div class="pull-left">
                            <span id="year-copy"></span> &copy; <a href="https://1.envato.market/x4R" target="_blank">ProUI 3.8</a>
                        </div>
                    </footer>
                    <!-- END Footer -->
                </div>
                <!-- END Main Container -->
            </div>
            <!-- END Page Container -->
        </div>
        <!-- END Page Wrapper -->

        <!-- Scroll to top link, initialized in js/app.js - scrollToTop() -->
        <a href="#" id="to-top"><i class="fa fa-angle-double-up"></i></a>

        <!-- User Settings, modal which opens from Settings link (found in top right user menu) and the Cog link (found in sidebar user info) -->
        <div id="modal-user-settings" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                     
                    <!-- END Modal Header -->

                    <!-- Modal Body -->
                    
                    <!-- END Modal Body -->
                </div>
            </div>
        </div>
        <!-- END User Settings -->

        <!-- jQuery, Bootstrap.js, jQuery plugins and Custom JS code -->
        <script src="${pageContext.request.contextPath}/admin/js/vendor/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/js/vendor/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/js/plugins.js"></script>
        <script src="${pageContext.request.contextPath}/admin/js/app.js"></script>

        <!-- Load and execute javascript code used only in this page -->
        <script src="${pageContext.request.contextPath}/admin/js/pages/tablesDatatables.js"></script>
        <script src="${pageContext.request.contextPath}/admin/js/helpers/ckeditor/ckeditor.js"></script>
        <script>$(function(){ TablesDatatables.init(); });</script>
    </body>
</html>






