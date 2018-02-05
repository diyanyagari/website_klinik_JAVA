<%@page import="com.fasterxml.jackson.core.JsonParser"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nomor_RM</th>
			<th>Nama</th>
			<th>Alamat</th>
			<th>Jenis Kelamin</th>
			<th>Tempat Lahir</th>
			<th>Tanggal Lahir</th>
		</tr>
	</thead>
	<tbody id="list-data">
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.id}</td>
				<td>${item.nomorRm}</td>
				<td>${item.nama}</td>
				<td>${item.alamat}</td>
				<td>${item.JK}</td>
				<td>${item.tempatLahir}</td>
				<td>${item.tglLahir}</td>
				<td>
					<button type="button" class="btn btn-success btn-xs btn-pasien-ok"
						value="${item.id }" data-nama="${item.nama }"
						data-alamat="${item.alamat }"
						data-tempatlahir="${item.tempatLahir }"
						data-tglLahir="${item.tglLahir }">
						<i class="fa fa-check"></i>
					</button>
				</td>
			</tr>

		</c:forEach>
	</tbody>
</table>

