
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <meta name="description" content="Online garden shop">
    <meta name="keywords" content="garden, shop, plants, decorate,
            decoration">


    <!--ios compatibility-->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-title" content="garden Shop">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/front/apple-icon-144x144.png">


    <!--Android compatibility-->

    <meta name="mobile-web-app-capable" content="yes">
    <meta name="application-name" content="Garden Shop">
    <link rel="icon" type="${pageContext.request.contextPath}/front/image/png" href="${pageContext.request.contextPath}/front/android-icon-192x192.png">

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/front/favicon.ico" type="${pageContext.request.contextPath}/front/image/x-icon" />


    <!--FONTS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/front/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!--THEME CSS-->
    <link href="${pageContext.request.contextPath}/front/css/theme.css" rel="stylesheet" type="text/css" />





    <title>Garden Shop</title>
</head>

<body>
    <!--HEADER START-->
<jsp:include page="include-front-header-navigation.jsp"></jsp:include>
<!--NAVIGATION ENDS-->


<main>

    <!--LOCATION MAP START-->
    <section class="location-map" style="background-color: #fff">
        <div class="container">
            <div class="embed-responsive embed-responsive-16by9 b-radius">
                <iframe class="embed-responsive-item" allowfullscreen
                    src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d6729.2175020694!2d20.415230656369506!3d44.83607936847891!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ssr!2srs!4v1534173827565"
                    width="800" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
        </div>
        
        
        
        
        
        
    </section>
    <!--LOCATION MAP ENDS-->





    <!--LOCATION MAIN START-->
    
    
    <section class="services-3--bottom-article contact-main-form location-main" style="background-color: #fff">
        <div class="container">
            <h3 class="text-uppercase">location</h3>
            
            
            
            <c:forEach var="location" items="${locations}">
            <div class="row d-flex justify-content-between align-items-bottom">
                <div class="col-md-6 col-lg-6 mb-4 mb-md-0">
                    <article class="contact-details text-uppercase">
                        <div class="contact-group">
                            <p>Address:</p>
                            <a href="#">${location.address}</a>
                            
                        </div>
                        
                        <div class="contact-group">
                            <p>Phone 1: <a href="#">${location.phone1}</a></p>
                            <c:if test="${location.phone2!=null}&&${location.phone2!=''}">
                            <p>Phone 2: <a href="#">${location.phone2}</a></p></c:if>
                        </div>
                        <div class="contact-group">
                            <p class="d-inline-block">E-mail:</p>
                            <a class="lead mb-2 mb-lg-3" href="contact-form">${location.email}</a>
                        </div>
                        <div class="contact-group">
                            <p>RADNO VREME:</p>
                            <p class="contact-medium">${location.workingdays}</p>
                            <p class="contact-medium">${location.weekdays}</p>
                        </div>
                    </article>
                </div>
               <div class="col-md-6 col-lg-6 text-center">
                    
                    
           
                      <iframe  width="500" height="250"
                      src="https://www.google.com/maps?q=${location.x},${location.y}&output=embed">
                        </iframe>
                       
        
                 
                </div>
               
            </div>
            
            
            
            
            </c:forEach>
            
        </div>

    </section>
    <!--LOCATION MAIN ENDS-->

</main>

<!--FOOTER START-->
<jsp:include page="include-front-footer.jsp"></jsp:include>
<!--FOOTER ENDS-->










<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/front/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/popper.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/owl.carousel.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/jquery.zoom.min.js" type="text/javascript"></script>


<script src="${pageContext.request.contextPath}/front/js/main.js" type="text/javascript"></script>


</body>

</html>