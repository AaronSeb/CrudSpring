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
            <div class="w-1/2 mx-4">
                <h2 class="text-center font-bold text-4xl">
                    Eliminar Fútbolista
                </h2>
                <p class="text-center font-bold text-2xl mt-10">¿Está seguro que desea borrar?</p>
                <div class="bg-white rounded-xl shadow-lg p-8 mt-10">
                    <form:form name="" method="post" action="" modelAttribute="futbolista" cssClass="flex flex-col space-y-3">
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">ID</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="id" readonly="true"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Nombre y Apellidos</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="nombre" readonly="true"/>
                        </div>
                       
                     
                        <div>
                            <label class="text-sm font-bold" for="nombre">Points FIFA</label>
                        </div>
                        <div>
                            <form:input cssClass="w-200 rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="skill" readonly="true"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Club</label>
                        </div>
                        <div>
                            <form:input cssClass="w-200 rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="club.nombreClub" readonly="true"/>
                        </div>
                        

                        <div class="flex justify-center">
                            <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                               Si,borrar
                            </button>

                            <button type="button" onclick="location.href='/senati/futbolista/lista'" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
                            	Cancelar
                            </button>
                        </div>
                           
                    </form:form>
                </div>
            </div>
        </section>
	
	

</body>
</html>