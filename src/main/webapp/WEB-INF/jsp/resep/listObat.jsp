<%@page import="com.fasterxml.jackson.core.JsonParser"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nama Obat</th>
			<th>Kemasan</th>
			<th>Harga</th>
			<th>Dosis</th>
		</tr>
	</thead>
	<tbody id="list-data">
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.id}</td>
				<td>${item.nama}</td>
				<td>${item.kemasan}</td>
				<td>${item.harga}</td>
				<td>${item.dosis}</td>
				<td>
					<button type="button" class="btn btn-success btn-xs btn-obat-ok"
						value="${item.id }" data-nama="${item.nama }"
						data-kemasan="${item.kemasan }"
						data-harga="${item.harga }"
						data-dosis="${item.dosis }">
						<i class="fa fa-check"></i>
					</button>
				</td>
			</tr>

		</c:forEach>
	</tbody>
</table>

