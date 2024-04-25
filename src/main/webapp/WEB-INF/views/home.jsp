<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<title>Futsport</title>

	<style>
		.navbar{
            padding: 2rem;
            background-color: #f5f6f7;
        }

        .navbar-collapse {
            align-items: center;
            justify-content: space-between;
        }

        .d-item {
            height: 700px;
        }
        .d-img{
            height: 100%;
            object-fit: cover;
            filter: brightness(0.6);
        }
        ul li a:hover{
        	background-color:#282727;
            border-radius: 3px;
            
        }
        .nav-link:hover{
            color: #f5f6f7;
        }
        p{
        	color:#39E258
        }
	</style>


</head>
<body>
		<nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-toggler" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar-toggler">
                <a class="navbar-brand" href="#"><img src="https://images.vexels.com/media/users/3/141231/isolated/lists/c59b6035d104844f7006c5d74f200be6-jugador-de-futbol-golpear-1.png" width="60px" height="50px" alt="">
                	 <span class="titulo"><strong>
                        Futsport
                    </strong>
                    </span>
                </a>
                <ul class="navbar-nav d-flex justify-content-center align-items-center">
                    <li class="nav-item">
                        <a class="nav-link" href="/senati/futbolista/lista">Futbolistas</a>
                    </li>
                    <li class="nav-item">
                    	<security:authorize access="hasRole('USUARIO')or hasRole('ADMINISTRADOR')or hasRole('JEFE')">
							<a class="nav-link" href="/senati/liga/listar">Ligas</a>
						</security:authorize> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/senati/club/listar">Clubes</a>
                    </li>
                    <li class="nav-item">
                    	<security:authorize access="hasRole('USUARIO')or hasRole('ADMINISTRADOR')or hasRole('JEFE')">
							<a class="nav-link" href="/senati/estadistica/listar">Estadisticas</a>
						</security:authorize>
                    </li>
                    <li class="nav-item">
                    	<security:authorize access="hasRole('USUARIO')or hasRole('ADMINISTRADOR')or hasRole('JEFE')">
							<a class="nav-link" href="/senati/estadio/listar">Estadios</a>
						</security:authorize>
                        
                    </li>
                    <li class="nav-item com">
                    	<security:authorize access="hasRole('USUARIO')or hasRole('ADMINISTRADOR')or hasRole('JEFE')">
							<a class="nav-link" href="/senati/club_competicion/listar">Competiciones</a>
						</security:authorize>
                        
                    </li>
                </ul>
                <div>
                	<security:authorize access="isAnonymous()">
						<a href="/senati/login" type="button" class="btn btn-outline-success">
        				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
        				<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
        				<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"></path>
        				</svg>
        					Login
    					</a>
					</security:authorize>
					
					<security:authorize access="isAuthenticated()">
						<security:authentication property="principal.username" var="username"/>
						<p>Bienvenido(a) ${username}</p> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
						<a href="/senati/logout" type="button" class="btn btn-outline-danger">
        					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
        					<path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"></path>
        					<path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"></path>
        					</svg>
       				 		Salir
    					</a>
					</security:authorize>
                </div>
            </div>
        </div>
    </nav>
	
	<div id="carouselExampleIndicators" class="carousel slide">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active d-item">
                <img src="https://www.rtv.org.mx/masnoticias/wp-content/uploads/sites/13/2021/04/D8C1D0E2-34D4-4C42-AADF-E62DB73D127C.jpeg" class="d-block w-100 d-img" alt="slider1">
                <div class="carousel-caption top-0 mt-4">
                    <p class="mt-5 fs-3 text-uppercase">
                        
                    </p>
                    <h1 class="display-1 fw-bolder text-capitalize">Clubs</h1>
                    <button class="btn btn-dark px-4 py-2 fs-5 mt-5">ver más</button>
                </div>
            </div>
            <div class="carousel-item active d-item">
                <img src="https://a.espncdn.com/photo/2021/1107/r934259_2_1001x563_16-9.jpg" class="d-block w-100 d-img" alt="slider1">
                <div class="carousel-caption top-0 mt-4">
                    <p class="mt-5 fs-3 text-uppercase">
                        
                    </p>
                    <h1 class="display-1 fw-bolder text-capitalize">Estadios</h1>
                    <button class="btn btn-dark px-4 py-2 fs-5 mt-5">ver más</button>
                </div>
            </div>
            <div class="carousel-item active d-item">
                <img src="https://phantom-marca.unidadeditorial.es/410f1f34c505630c3ac387a0525bcdf9/resize/1320/f/jpg/assets/multimedia/imagenes/2023/01/12/16735370253017.jpg" class="d-block w-100 d-img" alt="slider1">
                <div class="carousel-caption top-0 mt-4">
                    <p class="mt-5 fs-3 text-uppercase">
                        
                    </p>
                    <h1 class="display-1 fw-bolder text-capitalize">Futbolistas</h1>
                    <button class="btn btn-dark px-4 py-2 fs-5 mt-5">ver más</button>
                </div>
            </div>
            
        </div>
        
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
     <footer class="bg-light text-center text-white">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
          <!-- Section: Social media -->
          <section class="mb-4">
            <!-- Facebook -->
            <a
              class="btn text-white btn-floating m-1"
              style="background-color: #3b5998;"
              href="#!"
              role="button"
              ><i class="bi bi-facebook"></i
            ></a>
      
            <!-- Twitter -->
            <a
              class="btn text-white btn-floating m-1"
              style="background-color: #55acee;"
              href="#!"
              role="button"
              ><i class="bi bi-twitter"></i
            ></a>
      
            <!-- Google -->
            <a
              class="btn text-white btn-floating m-1"
              style="background-color: #dd4b39;"
              href="#!"
              role="button"
              ><i class="bi bi-google"></i
            ></a>
      
            <!-- Instagram -->
            <a
              class="btn text-white btn-floating m-1"
              style="background-color: #ac2bac;"
              href="#!"
              role="button"
              ><i class="bi bi-instagram"></i
            ></a>
      
            <!-- Linkedin -->
            <a
              class="btn text-white btn-floating m-1"
              style="background-color: #0082ca;"
              href="#!"
              role="button"
              ><i class="bi bi-linkedin"></i></a>
            <!-- Github -->
            <a
              class="btn text-white btn-floating m-1"
              style="background-color: #333333;"
              href="#!"
              role="button"
              ><i class="bi bi-github"></i></a>
          </section>
          <!-- Section: Social media -->
        </div>
        <!-- Grid container -->
      
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
          © 2023 Copyright:
          <a class="text-white" href="https://mdbootstrap.com/">Aaron Jimenez</a>
        </div>
        <!-- Copyright -->
      </footer>
	
	
		<!-- Security -->
		
		<security:authorize access="isAnonymous()">
			<a href="/senati/login"></a>
		</security:authorize>
		
		
		<security:authorize access="isAuthenticated()">
			<security:authentication property="principal.username" var="username"/>
		</security:authorize>
		
	 <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous">
    </script>
</body>
</html>