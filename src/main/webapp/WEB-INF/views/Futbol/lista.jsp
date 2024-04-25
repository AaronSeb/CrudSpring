<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <style type="text/css">
    	.icon{
            display: inline-flex;
        }
        .icon2{
            display: inline-flex;
        }
    	
    	 .casa:hover{
            color: #334155;
        }
        .nav-link:hover{
            color: #334155;
        }
        .registra{
            margin-left: 4px;
            display: inline-flex;
            gap: 10px;
        }
    	
    </style>
    
    
</head>
<body>

	<nav class="p-3 border-gray-200 rounded bg-gray-50 dark:bg-gray-800 dark:border-gray-700 h-55">
    	<div class="container flex flex-wrap items-center justify-between mx-auto">
	      <a href="#" class="flex items-center">
	          <img src="https://images.vexels.com/media/users/3/141231/isolated/lists/c59b6035d104844f7006c5d74f200be6-jugador-de-futbol-golpear-1.png" class="h-6 mr-3 sm:h-10" alt="Flowbite Logo" />
	          <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">Futsport</span>
	      </a>
	      <button data-collapse-toggle="navbar-solid-bg" type="button" class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-solid-bg" aria-expanded="false">
	        <span class="sr-only">Abrir menu</span>
	        <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd"></path></svg>
	      </button>
	      <div>
	        <p class="text-5xl">Lista de Futbolistas</p>
	      </div>
	      <div class="hidden w-full md:block md:w-auto" id="navbar-solid-bg">
	        <ul class="flex flex-col mt-4 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium md:border-0 md:bg-transparent dark:bg-gray-800 md:dark:bg-transparent dark:border-gray-700">
	          <li>
	            <a href="/senati/home" class=" home block py-2 pl-3 pr-4 mr-10 text-white bg-blue-700 rounded md:bg-transparent md:text-gray-700 md:p-0 md:dark:text-white dark:bg-blue-600 md:dark:bg-transparent md:hover:text-gray-500" aria-current="page">
	                <svg class="casa h-8 w-8 text-gray-700 md:hover:text-gray-500"  width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">  <path stroke="none" d="M0 0h24v24H0z"/>  <polyline points="5 12 3 12 12 3 21 12 19 12" />  <path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7" />  <rect x="10" y="12" width="4" height="4" /></svg>
	                home</a>
	          </li>
	        </ul>
	      </div>
    	</div>
  	</nav>
  	
  	<!-- texto -->
  	<div class="registra relative overflow-x-auto mt-20 mx-32">
	    <p class="text-2xl">Ingresa un nuevo futbolista</p>
	    <a href="/senati/futbolista/registrar" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
	        <svg class="w-5 h-5 mr-2 -ml-1 text-white"  fill="none" viewBox="0 0 24 24"             stroke="currentColor">
	            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"/>
	          </svg>
	        Registrar
	    </a> 
  	</div>
  	
  	
  	<!-- Tabla -->
	<div class="relative overflow-x-auto mt-20 mx-32">
		<table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
			<!-- Encabezado -->
			<thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
				<tr>
					<th scope="col" class="px-6 py-3">ID</th>
					<th scope="col" class="px-6 py-3">Nombre</th>
					<th scope="col" class="px-6 py-3">Sexo</th>
					<th scope="col" class="px-6 py-3">F.Nacimiento</th>
					<th scope="col" class="px-6 py-3">Posicion</th>
					<th scope="col" class="px-6 py-3">Pais</th>
					<th scope="col" class="px-6 py-3">Pie Dominante</th>
					<th scope="col" class="px-6 py-3">Points FIFA</th>
					<th scope="col" class="px-6 py-3">Club</th>
					<th scope="col" class="px-6 py-3">Acciones</th>
				</tr>
			</thead>
			<c:forEach var="mvp" items="${jugadores}">
			<tbody>	
				<tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
					<th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">${mvp.id}</th>
					<td class="px-6 py-4">${mvp.nombre}</td>
					<td class="px-6 py-4">${mvp.sexo}</td>
					<td class="px-6 py-4">${mvp.fnaci}</td>
					<td class="px-6 py-4">${mvp.posicion}</td>
					<td class="px-6 py-4">${mvp.pais}</td>
					<td class="px-6 py-4">${mvp.pieDominante}</td>
					<td class="px-6 py-4">${mvp.skill}</td>
					<td class="px-6 py-4">${mvp.club.nombreClub}</td>
					
					<td class="px-6 py-4">
						<a class="icon" href="/senati/futbolista/edita/${mvp.id}">
							<svg class="h-8 w-8 text-blue-400"  width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
							<path stroke="none" d="M0 0h24v24H0z"/>
							<path d="M3 21h4l13 -13a1.5 1.5 0 0 0 -4 -4l-13 13v4" />
							<line x1="14.5" y1="5.5" x2="18.5" y2="9.5" />  <polyline points="12 8 7 3 3 7 8 12" />
							<line x1="7" y1="8" x2="5.5" y2="9.5" />  <polyline points="16 12 21 17 17 21 12 16" />
							<line x1="16" y1="17" x2="14.5" y2="18.5" /></svg>
						</a>
						<a class="icon2" href="/senati/futbolista/borrar/${mvp.id}">
							<svg class="h-8 w-8 text-red-400 ml-1"  viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  stroke-width="2"  stroke-linecap="round"  
							stroke-linejoin="round">  <polyline points="3 6 5 6 21 6" /> 
							<path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2" />  
							<line x1="10" y1="11" x2="10" y2="17" />  <line x1="14" y1="11" x2="14" y2="17" /></svg>      
						</a>
					</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
  	
</body>
</html>