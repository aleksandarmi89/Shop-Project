<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link rel="apple-touch-icon" href="apple-icon-144x144.png">


    <!--Android compatibility-->

    <meta name="mobile-web-app-capable" content="yes">
    <meta name="application-name" content="Garden Shop">
    <link rel="icon" type="image/png" href="android-icon-192x192.png">

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />


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
    <header class="py-1 py-lg-4" id="header" style="background-color:
            #6FB25D;">
        <div class="container">
            <div class="row justify-content-between align-items-center">
                <div class="col-12 col-lg-3">
                    <a href="#" class="header-brand">
                        <img src="img/logo.png" alt="" />
                    </a>
                </div>
                <div class="col-12 col-lg-6 header-details text-center
                        text-lg-left">
                    <div>
                        <a class="d-inline-block mr-lg-4" href="#"><img class="mobile" src="img/icons/mobile.png"
                                alt="" />(+01) 123 456 7896</a>
                        <a class="d-inline-block" href="mailto:gardenshop@gmail.com"><img class="mail"
                                src="img/icons/mail.png" alt="" />gardenshop@gmail.com</a>
                    </div>
                    <p><img class="clock" src="img/icons/clock.png" alt="" />Monday-Friday : 9:00 AM to 7:00 PM Sunday :
                        Closed</p>
                </div>
                <div class="col-12 col-lg-3 d-lg-flex justify-content-end">
                    <form class="input-group search" method="GET" action="">
                        <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                        <div class="input-group-append text-center">
                            <button type="submit" name="search-form" value="search"><span
                                    class="fa fa-search"></span></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <!--HEADER ENDS-->



    <!--NAVIGATION START-->
    <section class="navigation py-2 p-lg-0" style="background-color:
            #6FB25D;">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-green">
                <a class="navbar-brand" href="#">
                    <img src="img/logo.png" alt="" />
                </a>
                <a class="search-mobile ml-auto" href="#">
                    <span class="fa fa-search"></span>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
                <div class="search-toggle">
                    <form class="input-group search" method="GET" action="">
                        <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                        <div class="input-group-append text-center">
                            <button type="submit" name="search-form" value="search"><span
                                    class="fa fa-search"></span></button>
                        </div>
                    </form>
                </div>
                <div class="collapse navbar-collapse mt-2 mt-lg-0" id="main-menu">
                    <ul class="navbar-nav mr-auto mr-lg-0 mb-3 mb-lg-0
                            text-center">
                        <li class="nav-item active">
                            <a class="nav-link" href="homepage">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="shop-list">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="location">Location</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="about-us">About us</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="contact">Contact</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
    </section>
    <!--NAVIGATION ENDS-->


    <main>

        <!--SHOP 1 STARTS-->
        <section class="shop-1 popular-products mb-2 mb-lg-4" style="background-color: #fff;">
            <div class="container text-center">
                <div class="row">
                    
                    <div class="col-lg-3 sidebar">
                        <span class="close-sidebar-icon">x</span>
                        <h4 class="text-uppercase text-left mb-5">filter products by:</h4>


                         <form:form action="shop-list" role="form" modelAttribute="p">
                       

                            <div class="form-group mb-5">
                                <h5 class="text-uppercase mb-2">Category</h5>
                               
                                 <form:select class="form-control" path="category.id" itemLabel="name" itemValue="id" items="${categories}"/>
                            <br><br>
                             <a href="shopp-list-by-category?id=3">
                            	<button type="button" name="filter-form" value="filter"
                                class="btn btn-success text-uppercase">PRONADJI</button>
                             </a>
						
						</form:form>  
						
						
						
						
						
						                          
                            </div>
                           
 
            	
                            
                        

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
                        
                        
                        <c:forEach var="product" items="${products}">
                            <div class="col-xxm-6 col-md-4">
                                <article class="popular-products-item mb-2
                                    mb-lg-0">
                                    <figure class="mb-3 d-flex
                                        justify-content-center
                                        align-items-center">
                                        <a href="product.html" class="d-block"><img src="${pageContext.request.contextPath}/slike/${product.image}"
                                                alt="" /></a>
                                        
                                        <c:set scope="page" var="tempSticker" value="${product.randomSticker}"/>
                           				 <c:if test="${tempSticker!=null}">
                            					<p style="background-color: ${tempSticker.color};" class="discount">
                               					 ${tempSticker.title}
                            					</p>
                            			 </c:if>
                                        
                                    </figure>
                                    <div class="popular-products-details
                                        text-center text-lg-left">
                                        <h5 class="mb-1"><a href="product.html" class="text-uppercase">${product.category.name}</a></h5>
                                        <p class="text-uppercase mb-2">${product.price}</p>
                                        <p class="text-uppercase">${product.title} din</p>
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
    <footer style="background-color: #404040">
        <div class="container">
            <a href="#header" id="footerButton" class="d-inline-block
                    text-uppercase btn btn-warning">back to top<span class="d-inline-block fa fa-angle-up"></span></a>
            <div class="row text-center d-flex align-items-center">
                <div class="col-12 col-md-6 col-xl-4 text-md-left mb-3
                        mb-md-0">
                    <a class="footer-brand d-inline-block">
                        <img src="img/logo.png" alt="" />
                    </a>
                </div>
                <div class="col-12 col-md-6 col-xl-4 text-md-right">
                    <div class="footer-info-wrapper mb-1 mb-md-0">
                        <a class="d-inline-block mr-2 mr-lg-4 mr-xl-5" href="#"><img class="mobile"
                                src="img/icons/mobile.png" alt="" />(+01)
                            123 456 7896</a>
                        <a class="d-inline-block" href="mailto:gardenshop@gmail.com"><img class="mail"
                                src="img/icons/mail.png" alt="" />gardenshop@gmail.com</a>
                    </div>
                </div>
                <div class="col-12 col-md-12 col-xl-4 text-md-right
                        align-self-lg-center">
                    <p><img class="clock" src="img/icons/clock.png" alt="" />Monday-Friday : 9:00 AM to 7:00 PM Sunday :
                        Closed</p>
                </div>
            </div>
        </div>
    </footer>
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