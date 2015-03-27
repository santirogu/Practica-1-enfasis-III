<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">

<script type="text/javascript" src="../lib/jquery/jquery.js"></script>
<script type="text/javascript" src="../lib/bootstrap/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de maquinas</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
				<%
					int contador = 1;
				%>
					<c:forEach var="item" items="${maquina}">					
						<tr>
							<td><img src="../img/${item.imagen}.jpg"></td>
							<td><em><p class="text-danger">${item.nombre}</p></em><br> 
								<em><strong><p class="text-primary">$${item.precio}</p></strong></em><br>
								<em>${item.disponible}</em>
							</td>
							<td>
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-warning btn-lg"
									data-toggle="modal" data-target="#myModal<%=contador%>">Ver detalle</button> <!-- Modal -->
								<div class="modal fade" id="myModal<%=contador%>" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title text-danger" id="myModalLabel">${item.nombre}</h4>
											</div>
											<div class="modal-body">
												<table>
													<tr><td><img src="../img/${item.imagen}.jpg"></td>
														<td>
															<em><strong>Ántes:</em>$${item.precio}</strong><br>
															<em>Su descuento es del </em>${item.descuento}%<br>
															<em><strong>Después:</em>$${item.preciodescuento}</strong><br>															
															<p class="text-success"><em>Disponible: </em>${item.disponible}</p><br>
															<p class="text-warning"><em>Descripción: </em>${item.descripcion}</p>
														</td>
													</tr>													
												</table>																								
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-danger"
													data-dismiss="modal">Close</button>												
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<%
							contador++;
						%>
					</c:forEach>
					
				</table>
			</div>
		</div>
	</div>
</body>
</html>