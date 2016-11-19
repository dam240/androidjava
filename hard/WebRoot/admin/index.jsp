
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@ taglib uri="/struts-tags" prefix="s" %><s:property value="str"/>
    




<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Volton - Responsive Mobile Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="<%=basePath %>admin/css/normalize.css">
        <link rel="stylesheet" href="<%=basePath %>admin/css/font-awesome.css">
        <link rel="stylesheet" href="<%=basePath %>admin/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=basePath %>admin/css/templatemo-style.css">
        <script src="<%=basePath %>admin/js/vendor/modernizr-2.6.2.min.js"></script>
    </head>
    
    <body>
    
 
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    
        <div class="responsive-header visible-xs visible-sm">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="top-section">
                            <div class="profile-image">
                                <img src="<%=basePath %><s:property value="use.photo"/>" alt="Volton">
                               
                            </div>
                            <div class="profile-content">
                                <h3 class="profile-title"><s:property value="use.user_name"/></h3>
                                <p class="profile-description"><s:property value="use.card"/></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
                <div class="main-navigation responsive-menu">
                    <ul class="navigation">
                        <li><a href="#top"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="#about"><i class="fa fa-user"></i>About Me</a></li>
                        <li><a href="#projects"><i class="fa fa-newspaper-o"></i>My Gallery</a></li>
                        <li><a href="#contact"><i class="fa fa-envelope"></i>Contact Me</a></li>
                    </ul>
                </div>
            </div>
        </div>
		
        <!-- SIDEBAR -->
        <div class="sidebar-menu hidden-xs hidden-sm">
            <div class="top-section">
                <div class="profile-image">
                    <img src="<%=basePath %><s:property value="use.photo"/>" alt="Volton">
                </div>
                <h3 class="profile-title"><s:property value="use.name"/></h3>
                <p class="profile-description"><s:property value="use.card"/></p>
            </div> <!-- top-section -->
            <div class="main-navigation">
                <ul class="navigation">
                    <li><a href="#top" onclick="document.getElementById('jk').src='<%=basePath %>admin/hello.jsp'"><i class="fa fa-globe"></i>Welcome</a></li>
                    <li><a href="#about"  onclick="document.getElementById('jk').src='list.action'"><i class="fa fa-pencil"></i>About Me</a></li>
                    <li><a href="#projects"   onclick="document.getElementById('jk').src='http://hao123.com'"><i class="fa fa-paperclip"></i>My Gallery</a></li>
                    <li><a href="#contact"   onclick="document.getElementById('jk').src='http://127.0.0.1/'"><i class="fa fa-link"></i>Contact Me</a></li>
                </ul>
            </div> <!-- .main-navigation -->
            <div class="social-icons">
                <ul>
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="#"><i class="fa fa-rss"></i></a></li>
                </ul>
            </div> <!-- .social-icons -->
        </div> <!-- .sidebar-menu -->
        
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >åè´¹æ¨¡æ¿</a></div>
        	
        	 <div id="top">
               <iframe src="" width="77%" height="650px" frameborder="0" id="jk" />
               
  
        
        
        
                
        </div>


        <script src="js/vendor/jquery-1.10.2.min.js"></script>
        <script src="js/min/plugins.min.js"></script>
        <script src="js/min/main.min.js"></script>
        
        
        <script type="text/javascript">
    function oci(){
     
     alert("had");
  document.getElementById("jk").src="<%=basePath %>admin/hello.jsp";
     
     }
     </script>
        

    </body>
</html>