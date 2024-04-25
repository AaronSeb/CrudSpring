<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Club y Competicion</title>
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
	
	
	<div class="flex justify-center items-center text-center mt-14">
			<b>Club: </b>
			<select class="appearance-none w-64 bg-gray-200 border border-gray-200 text-gray-700 py-2 px-3 mx-2 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name="" id="seleccionarClub">
				<option value="null">--Seleccione--</option>
				<c:forEach var="club" items="${bClubs}">
					<option value="${club.clubId}">${club.nombreClub}</option>
				</c:forEach>
			</select>
			
			<button class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" 
					 id="buttonBuscar">Buscar</button><br><br>
			<button class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" 
					 id="mostrarTodo" onclick="location.reload()">Mostrar todo</button><br><br>
	</div>	
	
	<div class="relative overflow-x-auto mt-10 mx-56">
		<table class="w-full text-sm text-left text-gray-500 dark:text-gray-400" id="tablaCyC">
			<thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
				<tr>
					<th scope="col" class="px-6 py-3">ID</th>
					<th scope="col" class="px-6 py-3">Club</th>
					<th scope="col" class="px-6 py-3">ID</th>
					<th scope="col" class="px-6 py-3">Competicion</th>
					<th scope="col" class="px-6 py-3">Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="object" items="${bClubCompeticion}">	
				<tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
					<td class="px-6 py-4">${object[0]}</td>
					<td class="px-6 py-4">${object[1]}</td>
					<td class="px-6 py-4">${object[2]}</td>
					<td class="px-6 py-4">${object[3]}</td>
					<td class="px-6 py-4">
						<a class="bg-yellow-600 hover:bg-yellow-400 text-white font-bold py-2 px-4 rounded-full" href="/senati/club_competicion/mostrar/${object[0]}">Detalle</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<script type="text/javascript">
		const seleccionarClub = document.getElementById('seleccionarClub'); //comobox de empleados
		const tablaC_C = document.getElementById('tablaCyC'); // obtiene la tabla d eempleados y proyectos
		const botonBuscar = document.querySelector('button'); // obtiene el  boton para filtrar
	
		//Agreagr un escuchador de eventos al boton "Buscar"
		botonBuscar.addEventListener("click",() => {
			
		    //obtienes tu empleado
		    	
				const clubSeleccionado = seleccionarClub.value;
				if(clubSeleccionado ==="null"){
					window.alert("Por favor, Seleccione un empleado")
					location.reload();
				} 
			    //obtienes las filas de la tabla
			    const filasDeTabla = tablaC_C.getElementsByTagName('tbody')[0].getElementsByTagName('tr'); 
			    
			    //recorrer todas las filas de la tabla
		
			    for(let i=0; i < filasDeTabla.length; i++){
		
			        const fila = filasDeTabla[i];//obtiene la fila actual
			        const celda= fila.getElementsByTagName('td');//obtiene todas las celdas de la fila
		
			        //compara el id del club de la celda actual con el nombre seleccionado
			        if (celda[0].innerText === clubSeleccionado){
			            fila.style.display='table-row'; //muestra la fila si el nombre coincide
			        } else{
		
			            fila.style.display = 'none'; //oculta la fila si el nombre no coincide
			        }
			    }
		});
	
	</script>
</body>
</html>