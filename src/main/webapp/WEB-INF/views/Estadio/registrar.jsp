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
            <div class="w-1/4 mx-4">
                <h2 class="text-center font-bold text-4xl">
                    Registrar un Estadio
                </h2>
                <div class="bg-white rounded-xl shadow-lg p-8 mt-10">
                    <form:form name="" method="post" action="" modelAttribute="estadio" cssClass="flex flex-col space-y-3">
                        <div>
                            <label class="text-sm font-bold" for="nombre">Estadio</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="nombreEstadio" placeholder="ingrese nombre"/>
                        </div>

                        <div>
                            <label class="text-sm font-bold" for="nombre">Ubicación</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="ubicacion" placeholder="Ingrese ubicación"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Capacidad</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="capacidad" placeholder="ingrese Capacidad"/>
                        </div>
                        
                        
             			<div class="">
                            <label class="text-sm font-bold">
                              Club
                            </label>
                        </div>
                        <div>
                              <form:select path="club.clubId" class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-2 px-4 pr-24 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500">
                                <form:option value="">Selecciona un Club</form:option>
                                <form:options items="${bclubes}" itemValue="clubId" itemLabel="nombreClub"/>
                              </form:select>
                        </div>
                        
                        
                        <div class="flex justify-center">
                            <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                                guardar
                            </button>

                            <button type="button" onclick="location.href='/senati/estadio/listar'" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
                            	cancelar
                            </button>
                        </div>
                           
                    </form:form>
                </div>
            </div>
        </section>	
</body>
</html>