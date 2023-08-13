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

        <title>User form - welcome to Admin page</title>

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
   
    
        <style>
			.error {
				color: #ff0000;
				font-style: italic;
				 
			}
		</style>
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
               
                <!-- END Alternative Sidebar -->

                <!-- Main Sidebar -->
                <c:import url="admin-sidebar.jsp">
                 <c:param name="userPrincipal" value="${userPrincipal}" />
                </c:import>

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
                    <c:import url="admin-header.jsp">
                     <c:param name="userPrincipal" value="${userPrincipal}" />
                    </c:import>
                    <!-- END Header -->

                    <!-- Page content -->
                    <div id="page-content">
                        <!-- Validation Header -->
                        <div class="content-header">
                            <div class="header-section">
                                <h1>
                                    User form<br><small>Add new or edit existing user</small>
                                </h1>
                            </div>
                        </div>
                       
                        <!-- END Validation Header -->

                        <div class="row">
                            <div class="block full">
                                <!-- Form Validation Example Block -->
                                <div class="block">
                                    <!-- Form Validation Example Title -->
                                    <div class="block-title">
                                        <h2><strong>User elements</strong> </h2>
                                    </div>
                                    <!-- END Form Validation Example Title -->

                                    <!-- Form Validation Example Content -->
                                 
                                    <form:form id="form-validation" action="user-save" modelAttribute="newUser" method="POST" enctype="multipart/form-data" class="form-horizontal form-bordered">
                                        <form:hidden path="username"/>
                                        
                                        <fieldset>
                                            <legend><i class="fa fa-angle-right"></i> User credentials</legend>
                                            <div class="form-group">
                                            
                                                <label class="col-md-4 control-label" for="val_username">Username <span class="text-danger">*</span>
                                                 <div><form:errors path="username" cssClass="error"/> </div>
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="username" type="text" id="val_username" name="val_username" class="form-control" placeholder="Enter username.."/>
                                                        <span class="input-group-addon"><i class="gi gi-user"></i></span>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                            
                                                <label class="col-md-4 control-label" for="val_password">Password <span class="text-danger">*</span>
                                                 <div><form:errors path="password" cssClass="text-danger"/> </div>
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="password" type="password" id="val_password" name="val_password" class="form-control validate-equalTo-blur valid" placeholder="Add password.." aria-required="true" aria-describedby="val_password-error" aria-invalid="false"/>
                                                        <span class="input-group-addon"><i class="gi gi-asterisk"></i></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group has-error">
                                                <label class="col-md-4 control-label" for="val_confirm_password">Confirm Password <span class="text-danger">*</span></label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <input type="password" id="val_confirm_password" name="val_confirm_password" class="form-control" placeholder="Confirm password!" aria-required="true" aria-describedby="val_confirm_password-error" aria-invalid="true">
                                                        <span class="input-group-addon"><i class="gi gi-asterisk"></i></span>
                                                    </div>
                                                <div id="val_confirm_password-error" class="help-block animation-slideDown">Please enter the same password as above</div></div>
                                            </div>
                                        </fieldset>
                                        
                                        
                                       <fieldset>
                                        <legend><i class="fa fa-angle-right"></i> User Info</legend>
                                             <div class="form-group">
                                                <label class="col-md-4 control-label" for="val_title">Name <span class="text-danger">*</span>
                                                <br>
                                                <div><form:errors path="name" cssClass="text-danger"/> </div>
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="name" type="text" id="val_title" name="val_title" class="form-control" placeholder="Enter name..."/>
                                                        <span class="input-group-addon"><i class="gi gi-pencil"></i></span>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="val_title">Surname <span class="text-danger">*</span>
                                                <br>
                                                <div><form:errors path="surname" cssClass="text-danger"/> </div>
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="surname" type="text" id="val_title" name="val_title" class="form-control" placeholder="Enter surname..."/>
                                                        <span class="input-group-addon"><i class="gi gi-pencil"></i></span>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                            
                                            
                                            
                                             <div class="form-group">
                                                <label class="col-md-4 control-label" for="val_description">Email <span class="text-danger">*</span>
                                                <br>
                                                <div><form:errors path="email" cssClass="text-danger" /> </div>
                                                </label>
                                                 
                                               <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="email" type="text" id="val_title" name="val_title" class="form-control" placeholder="Enter email address..."/>
                                                        <span class="input-group-addon"><i class="gi gi-envelope"></i></span>
                                                    </div>
                                                    
                                                </div>
                                                 
                                                  
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="val_title">Phone number <span class="text-danger">*</span>
                                                <br>
                                                <div><form:errors path="phone_number" cssClass="text-danger" /> </div>
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="phone_number" type="text" id="val_title" name="val_title" class="form-control" placeholder="Enter button title or button name"/>
                                                        <span class="input-group-addon"><i class="gi gi-earphone"></i></span>
                                                    </div>
                                                   
                                                </div>
                                            </div>
                                            
                                             <div class="form-group">
                                                <label class="col-md-4 control-label" for="val_image">Image<span class="text-danger">*</span>
                                                
                                                <br>
                                                 
                                                </label>
                                                <div class="col-md-6">
                                                
                                                    <div class="col-md-9">
                                                        <input type="file" name="fileImage" class="form-control" />
                                                        
                                                    </div>
                                                    <div><form:errors path="image" cssClass="error" /> </div>
                                                   
                                                </div>
                                                
                                            </div>
                                            
                                             
                                            <!-- 
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="val_image">Image <span class="text-danger">*</span>
                                                
                                                <br>
                                                <div><form:errors path="image" cssClass="text-danger" /> </div>
                                                </label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <form:input path="image" type="text" id="val_image" name="val_image" class="form-control" placeholder="Enter image link"/>
                                                        <span class="input-group-addon"><i class="gi gi-picture"></i></span>
                                                    </div>
                                                   
                                                </div>
                                                
                                            </div>
                                            -->
                                             
                                             
                                             <div class="form-group">
							                         <label class="col-md-4 control-label" for="val_digits">Select Role <span class="text-danger">*</span>
                                                
                                           			 <br>
                                           			 <div><form:errors path="roles" cssClass="text-danger" /> </div>
                                              		</label>
                                              		<div class="col-md-6">
                                                		
							                        	<form:select path="roles" class="form-control" 
															itemLabel="authority" 
															itemValue="authority"
															items="${roleList}" multiple="false"/>
													</div>	
                    						  </div>
                                       		 
                                            <div class="form-group">
                                                <label class="col-md-4 control-label">Enable user <span class="text-danger">*</span></label>
                                                <div class="col-md-8">
 
 												<form:checkbox class="form-control" path="enabled" placeholder="Enable slider on blog index page" />  
                                                        
                                                </div>
                                            </div>
                                          
                                            
                                        </fieldset>
                                        
                                        <div class="form-group form-actions">
                                            <div class="col-md-8 col-md-offset-4">
                                                <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-arrow-right"></i> Save</button>
                                                <button type="reset" class="btn btn-sm btn-warning"><i class="fa fa-repeat"></i> Reset</button>
                                            </div>
                                        </div>
                                    </form:form>
                            
                             	 
                                    <!-- END Form Validation Example Content -->

                                    <!-- Terms Modal -->
                                     
                                    <!-- END Terms Modal -->
                                </div>
                                <!-- END Validation Block -->
                            </div>
                            
                        </div>
                    </div>
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
                    <!-- Modal Header -->
                    <div class="modal-header text-center">
                        <h2 class="modal-title"><i class="fa fa-pencil"></i> Settings</h2>
                    </div>
                    <!-- END Modal Header -->

                    <!-- Modal Body -->
                    <div class="modal-body">
                       
                    </div>
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
        <script src="${pageContext.request.contextPath}/admin/js/pages/formsValidation.js"></script>
        <script>$(function(){ FormsValidation.init(); });</script>
        <!-- Load and execute javascript code used only in this page -->
       
         
    </body>
</html>