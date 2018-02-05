<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.id}</td>
		<td>${item.nomorRm}</td>
		<td>${item.nama}</td>
		<td>${item.alamat}</td>
		<td>${item.propinsi.nama}</td>
		<td>${item.kotaId}</td>
		<td>${item.kecamatanId}</td>
		<td>${item.JK}</td>
		<td>${item.tempatLahir}</td>
		<td>${item.tglLahir}</td>
		<td>${item.pekerjaan}</td>
		<td>
			<button type="button" class="btn btn-success btn-xs btn-edit" value="${item.id }"><i class="fa fa-edit"></i></button>
			<button type="button" class="btn btn-danger btn-xs btn-delete" value="${item.id }"><i class="fa fa-trash"></i></button>
		</td>
	</tr>
</c:forEach>