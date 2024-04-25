<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
	<title>Insert title here</title>
	
		<script type="text/javascript">
			function agregarJS(competicionId,clubId){
				location.href="/senati/club_competicion/agregar/" +competicionId+"/"+clubId;
			}
			function eliminarJS(competicionId,clubId){
				location.href="/senati/club_competicion/eliminar/" +competicionId+"/"+clubId;
			}
			
		</script>
		
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
	        <p class="text-5xl">Club-Competiciones</p>
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
	
<form:form name="" method="post" action="" modelAttribute="club">
	<div class="relative overflow-x-auto mt-10 mx-32">
	
		<h2 class="text-center font-bold text-4xl">
         	Club: ${club.nombreClub}
        </h2>
			<!-- Ocultar clubId -->
			<input type="hidden" value="${club.clubId}" id="inputClubId"/>
		<div class="text-center mt-14">
			<b>Competición: </b>
			<select class="appearance-none w-64 bg-gray-200 border border-gray-200 text-gray-700 py-2 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name="" id="selectCompeticionId">
				<option value=0>--Seleccione--</option>
				<c:forEach var="competicion" items="${bCompeticiones}">
					<option value="${competicion.competicionId}">${competicion.nombreCompeticion}</option>
				</c:forEach>
			</select>
			<button class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" 
					type="button" onclick="agregarJS(document.getElementById('selectCompeticionId').value,
					document.getElementById('inputClubId').value)">Agregar</button><br><br>
		</div>	
			
			
	</div>

	<!-- Tabla -->
	<div class="relative overflow-x-auto mt-10 mx-56">
		<table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
			<!-- Encabezado -->
			<thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
				<tr>
					<th scope="col" class="px-6 py-3">ID</th>
					<th scope="col" class="px-6 py-3">Competencia</th>
					<th scope="col" class="px-6 py-3">Premio</th>
					<th scope="col" class="px-6 py-3">Fecha de inicio</th>
				</tr>
			</thead>
			<c:forEach var="competicion" items="${bCarrito}">
			<tbody>	
				<tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
					<th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">${competicion.competicionId}</th>
					<td class="px-6 py-4">${competicion.nombreCompeticion}</td>
					<td class="px-6 py-4">${competicion.cantidadPremio}</td>
					<td class="px-6 py-4">${competicion.fInicio}</td>
					
				</tr>
			</tbody>
			</c:forEach>
		</table>
		
	</div>
	
	<div class="text-center mt-10">
		<button class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" 
			type="submit" type="submit">Guardar</button>
		<button class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
		 type="button" type="button" type="button" onclick="location.href='/senati/club/listar'">Ir Clubs</button>
		<button class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
		 type="button" onclick="location.href='/senati/club_competicion/listar'">Competicion-Club</button>
	</div>
</form:form>	
	
	
	
</body>
</html>