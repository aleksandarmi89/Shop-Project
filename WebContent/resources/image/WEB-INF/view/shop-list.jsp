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

        <!--SHOP 1 STARTS-->
        <section class="shop-1 popular-products mb-2 mb-lg-4" style="background-color: #fff;">
            <div class="container text-center">
                <div class="row">
                    
                    <div class="col-lg-3 sidebar">
                        <span class="close-sidebar-icon">x</span>
                        <h4 class="text-uppercase text-left mb-5">filter products by:</h4>

                        <form:form class="filter-form"  action="shop-apply" modelAttribute="product">
                        
                        <form:hidden path="id"/>
                        
                           
                            <div class="form-group mb-5">
                                <h5 class="text-uppercase mb-2">Category</h5>
                                 
            <form:select class="form-control" itemLabel="name" itemValue="id" items="${categories}" path="category.id"/>
                     
                                     </div> 
                            
                            
                             
                             
                         <c:forEach var="category" items="${categories}">
                             <a href="shop-apply?id=${category.id}"> 
                            <button type="button" name="filter-form" value="filter"
                                class="btn btn-success text-uppercase">Apply filter</button></a>
                                </c:forEach>
                               
                        </form:form>

                    </div>
                    
                    <div class="col-lg-9 popular-products-slider grid-view shop-wrapper">
                        <div class="shop-icons-wrapper d-flex
                            justify-content-between align-items-center
                            align-items-lg-baseline">
                            <a href="#" class="side-nav-button" ><span class="fa
                                    fa-list d-inline-block"></span></a>
                            <h4 class="text-uppercase ml-auto mr-lg-auto
                                ml-lg-0">all products</h4>
                        </div>
                        <div class="row">
                           
                            <c:forEach  var="product" items="${products}">
                            <div class="col-xxm-6 col-md-4">
                                <article class="popular-products-item mb-2
                                    mb-lg-0">
                                    <figure class="mb-3 d-flex
                                        justify-content-center
                                        align-items-center">
                                        <a href="product-shop-detail?id=${product.id}" class="d-block"><img src="${product.image}"
                                                alt="" /></a>
                             <c:set scope="page" var="s" value="${product.randomSticker}" />
                            <c:if test="${s!=null}">
                             <p style="background-color: ${s.color};" class="discount">
                                ${s.title}
                             </p>
                            </c:if>
                                    </figure>
                                    <div class="popular-products-details
                                        text-center text-lg-left">
                                        <h5 class="mb-1"><a href="product-shop-detail?id=${product.id}" class="text-uppercase">${product.category.name}
                                                </a></h5>
                                        <p class="text-uppercase mb-2">${product.title}
                                            </p>
                                        <p class="text-uppercase">${product.price}0 DIN</p>
                                    </div>
                                </article>
                            </div>
                            
                            </c:forEach>
                        </div>
                        <!--PAGINATION START-->
                        <div class="pagination-gallery pagination-shop">
                            <ul class="pagination d-flex
                                justify-content-center">
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item active"><a class="page-link" href="#">2</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#">
                                        <span class="fa fa-angle-right"></span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--PAGINATION ENDS-->
                    </div>
                </div>
            </div>
        </section>
        <!--SHOP 1 ENDS-->


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
    <script src="${pageContext.request.contextPath}/front/js/main.js" type="text/javascript"></script>


</body>

</html>