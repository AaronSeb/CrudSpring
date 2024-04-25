<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
</head>
<body>
	<section class="py-36 bg-zinc-200 flex justify-around">
            <div class="w-1/3 mx-4">
                <h2 class="text-center font-bold text-4xl">
                    Editar un Club
                </h2>
                <div class="bg-white rounded-xl shadow-lg p-8 mt-10">
                    <form:form name="" method="post" action="" modelAttribute="club" cssClass="flex flex-col space-y-3">
                    	<div>
                            <label class="text-sm font-bold" for="nombre">Id</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="clubId" readonly="true"/>
                        </div>
                        <div>
                            <label class="text-sm font-bold" for="nombre">Club</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="nombreClub" placeholder="ingrese nombre"/>
                        </div>
                        <div>
                            <label class="text-sm font-bold" for="nombre">Presidente</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="nommbrePresidente" placeholder="ingrese nombre"/>
                        </div>
      
                        <div>
                            <label class="text-sm font-bold" for="nombre">Fecha de Fundación</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="date" path="feFundacion"/>
                        </div>
                        
                         <div>
                            <label class="text-sm font-bold" for="nombre">Correo</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="correo" placeholder="Ingrese correo"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Dirección</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="direccion" placeholder="Ingrese dirección"/>
                        </div>
                        <div>
                            <label class="text-sm font-bold" for="nombre">Pais</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="pais" placeholder="Ingrese pais"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Teléfono</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="telefono" placeholder="ingrese teléfono"/>
                        </div>
                        <div>
                            <label class="text-sm font-bold" for="nombre">DT</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="direcT" placeholder="ingrese DT"/>
                        </div>
                        <div>
                            <label class="text-sm font-bold" for="nombre">Dueño</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="duenio" placeholder="ingrese dueño"/>
                        </div>

						 <div class="">
                            <label class="text-sm font-bold">
                              Liga
                            </label>
                        </div>
                        <div>
                              <form:select path="liga.ligaId" class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-2 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                                <form:option value="">Selecciona una Liga</form:option>
                                <form:options items="${bLigas}" itemValue="ligaId" itemLabel="nombre"/>
                              </form:select>
                        </div>
						


                        <div class="flex justify-center">
                            <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                                Actualizar
                            </button>

                            <button type="button" onclick="location.href='/senati/club/listar'" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
                            	Cancelar
                            </button>
                        </div>
                           
                    </form:form>
                </div>
            </div>
        </section>
	
	
	
	
	
	
</body>
</html>