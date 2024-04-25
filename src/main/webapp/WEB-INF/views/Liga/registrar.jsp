<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
                    Registro de una liga
                </h2>
                <div class="bg-white rounded-xl shadow-lg p-8 mt-10">
                    <form:form name="" method="post" action="" modelAttribute="liga" cssClass="flex flex-col space-y-3">
                        <div>
                            <label class="text-sm font-bold" for="nombre">Liga</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="nombre" placeholder="ingrese liga"/>
                        </div>

                        <div>
                            <label class="text-sm font-bold" for="nombre">Pais</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="pais" placeholder="Ingrese pais"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Fecha de Inicio</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="date" path="fInicio"/>
                        </div>
                        
                        <div>
                            <label class="text-sm font-bold" for="nombre">Premio</label>
                        </div>
                        <div>
                            <form:input cssClass="w-full rounded-md ring-1 ring-gray-300 outline-none focus:ring-2 focus:ring-blue-300 px-4 py-2" type="text" path="cantidadPremio" placeholder="ingrese premio"/>
                        </div>



                        <div class="flex justify-center">
                            <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
                                Guardar
                            </button>

                            <button type="button" onclick="location.href='/senati/liga/listar'" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
                            	Cancelar
                            </button>
                        </div>
                           
                    </form:form>
                </div>
            </div>
        </section>
	
</body>
</html>