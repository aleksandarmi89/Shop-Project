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

    <!--BREADCRUMBS START-->
    <div class="container">
        <section class="product-breadcrumb d-none d-lg-block" style="background: #fff;">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/homepage">Homepage</a></li>
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop-list1">Shop</a></li>
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop-list1?category=${product.category.id}">${product.category.name }</a></li>
                    <li class="breadcrumb-item active">${product.title}</li>
                </ol>
            </nav>
        </section>
    </div>
    <!--BREADCRUMBS ENDS-->


    <!--SINGLE PRODUCT START-->
    <section class="single-product" style="background-color: #fff;">
        <div class="container">
            <div class="row">
                <div class="col-md-6 mb-3 mb-md-0">
                    <figure class="text-center product-img d-inline-block">
                        <img src="${product.image}" alt="" />
                        <span class="zoom-img">
                            <img src="${pageContext.request.contextPath}/front/img/zoom/icon.png" alt="" />
                        </span>
                    </figure>
                </div>
                <div class="col-md-6 mb-4 mb-md-0">
                    <div class="single-product-details">
                        <h3><a class="text-uppercase" href="#">${product.title}</a></h3>
                        <a class="category">${product.category.name}</a>
                        <div class="sticker-wrapper">
                        <c:forEach items="${product.stickers}" var="sticker">
                            <span class="sticker" style="background-color: ${sticker.color};">${sticker.title}</span>
                            
                           </c:forEach>
                        </div>
                        <h6 class="text-uppercase">${product.description}</h6>
                        
                        <h5 class="text-uppercase">${product.formatedPrice} DIN</h5>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--SINGLE PRODUCT ENDS-->


    <!--SPECIFICATIONS START
    <section class="specifications-table" style="background-color: #fff">
        <div class="container">
            <h5 class="text-uppercase text-success mb-3">specifications</h5>
            <table class="table text-uppercase">
                <tbody>
                    <tr>
                        <td>Motor:</td>
                        <td>elecric</td>
                    </tr>
                    <tr>
                        <td>Snaga:</td>
                        <td>1800 w</td>
                    </tr>
                    <tr>
                        <td>Širina čišćenja:</td>
                        <td>45 cm</td>
                    </tr>
                    <tr>
                        <td>Visina čišćenja:</td>
                        <td>25 cm</td>
                    </tr>
                    <tr>
                        <td>Težina:</td>
                        <td>21 kg</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>
    SPECIFICATIONS ENDS-->



    <!--MOST POPULAR PRODUCTS START-->
    
    
    <section class="popular-products recently-viewed-products mb-2 mb-lg-4" style="background-color: #fff;">
        <div class="container text-center">
            <h3 class="text-uppercase mb-0"> PRODUCTS CATEGORY ${product.category.name }</h3>
            
            <ul class="list-unstyled owl-carousel popular-products-slider pb-3 pb-lg-4">
            <c:forEach var="product" items="${products}">
                <li>
                    <article class="popular-products-item mb-2 mb-lg-0">
                        <figure class="mb-3 d-flex justify-content-center align-items-center">
                            <a href="${pageContext.request.contextPath}/product-shop-detail/${product.ceoTitle}/${product.id}" class="d-block"><img src="${product.image}" alt="" /></a>
                            
                                <c:set  var="s" value="${product.randomSticker}" />
                            <c:if test="${s!=null}">
                             <p style="background-color: ${s.color};" class="discount">
                                ${s.title}
                             </p>
                            </c:if>
                           
                        </figure>
                        <div class="popular-products-details text-center text-lg-left">
                            <h5 class="mb-1"><a href="#" class="text-uppercase">${product.category.name}</a></h5>
                            <p class="text-uppercase mb-2">${product.title}</p>
                            <p class="text-uppercase">${product.formatedPrice} din</p>
                        </div>
                    </article>
                </li>
               
               
                </c:forEach>
               
                

            </ul>
           
        </div>
    </section>
    <!--MOST POPULAR PRODUCTS ENDS-->

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