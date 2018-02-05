<form id="form-user" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="delete">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		<input type="hidden" id="namaUser" name="namaUser" class="form-control" value="${item.namaUser }">
		<input type="hidden" id="username" name="username" class="form-control" value="${item.username }">
		<input type="hidden" id="password" name="password" class="form-control" value="${item.password }">
		<input type="hidden" id="roleId" name="roleId" class="form-control" value="${item.roleId }">
		
		
		<div class="form-group">
			<p>Apakah anda yakin mau menghapus data role ${item.namaUser} ?</p>				
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">HAPUS</button>
	</div>
</form>
