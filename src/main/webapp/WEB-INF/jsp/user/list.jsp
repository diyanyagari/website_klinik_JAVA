<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.id}</td>
		<td>${item.namaUser}</td>
		<td>${item.username}</td>
		<td>${item.password}</td>
		<td>${item.role.namaRole}</td>
		<td>
			<button type="button" class="btn btn-success btn-xs btn-edit" value="${item.id }"><i class="fa fa-edit"></i></button>
			<button type="button" class="btn btn-danger btn-xs btn-delete" value="${item.id }"><i class="fa fa-trash"></i></button>
		</td>
	</tr>
</c:forEach>