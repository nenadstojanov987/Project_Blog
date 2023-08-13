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

        <title>Comment list- welcome to Admin page</title>

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
                                    Comment list<br><small>View and manage comments</small>
                                </h1>
                                
                            
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
                                    <div class="block-title"><h4>Comment ID</h4></div>
                                    <div class="form-group mb-5">
                                                <input type="text" id="id_blog_comment" name="id_blog_comment" class="form-control" placeholder="Enter comment ID...">
                                                
                                    </div>
                                </div>
                            	</div>
                                
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
                      
                      
                             </div>
                            
                             <button type="submit" name="filter-form" value="filter" class="btn btn-success text-uppercase">
                             		Apply filter
			                 </button>
				           </form>
                        </div>         
                    
                            
                            
                        </div>
                        
                        <div class="block full">
                            <div class="block-title">
                                <h2><strong>Comment list</strong> preview</h2>
                            </div>
                         
                            <div class="table-responsive">
                                <table id="example-datatable" class="table table-vcenter table-condensed table-bordered">
                                    <thead>
                                        <tr>
                                            <th class="text-center">ID Comment</th>
                                            <th>ID Blog Post</th>
                                            <th>Visitor name</th>
                                            <th>Content</th>
                                            <th>Blog comment date</th>
                                            <th>Enabled/Disabled</th>
                                             <sec:authorize access="hasRole('admin')">
                                            <th class="text-center">Actions</th>
                                            </sec:authorize>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    <c:forEach var="blogComment" items="${blogCommentList}">
                                     <tr>
                                      
                                             
                                             
	                                            <td class="text-center">${blogComment.id_blog_comment}</td>                                        
	                                            <td class="text-center"><a href="blog-read?id_blog_product=${blogComment.blog_product_id}">${blogComment.blog_product_id}</a></td>
	                                            <td class="text-center">${blogComment.visitor.visitor_name}</td>
	                                            <td class="text-justify">${blogComment.content}</td>
	                                             <td class="text-center">${blogComment.blog_comment_date}</td>
	                                            <td class="text-center"> 
	                                            	<c:choose>
	                                            		<c:when test="${blogComment.enabled}">
	                                            			<i class="gi gi-check"></i>
	                                            		</c:when>
	                                            		<c:otherwise>
	                                            			<i class="gi gi-unchecked"></i>
	                                            		</c:otherwise>
	                                            	</c:choose>
	                                            
	                                            </td>
	                                             
	                               				<sec:authorize access="hasRole('admin')">
	                                             
	                                            <td class="text-center">
	                                                <div class="btn-group">
	                                               
	                                                <c:choose>
								                       <c:when test="${blogComment.enabled}">
								                           		<a href="comment-enabled?id_blog_comment=${blogComment.id_blog_comment}" data-toggle="tooltip" title="Enabled" class="btn btn-xs btn-default">
								                            		<i class="fa fa-eye"></i> 
								                          		</a>
														</c:when>
														<c:otherwise>
														   		<a href="comment-enabled?id_blog_comment=${blogComment.id_blog_comment}" data-toggle="tooltip" title="Disabled" class="btn btn-xs btn-default">
								                          		 <i class="fa fa-eye-slash"></i> 
								                         		 </a>
														</c:otherwise>
								                       </c:choose>   
	                                                 
	                                                </div>
	                                            </td>
	                                           
                                       </sec:authorize>
                                   </tr>
                                        
                                </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                             
                     
                  
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
        <script src="${pageContext.request.contextPath}/admin/js/pages/tablesDatatables3.js"></script>
        <script src="${pageContext.request.contextPath}/admin/js/helpers/ckeditor/ckeditor.js"></script>
        <script>$(function(){ TablesDatatables.init(); });</script>
    </body>
</html>






