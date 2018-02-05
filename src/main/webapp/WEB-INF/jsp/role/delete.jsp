<form id="form-role" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="delete">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		<input type="hidden" id="namaRole" name="namaRole" class="form-control" value="${item.namaRole }">
		<input type="hidden" id="keterangan" name="keterangan" class="form-control" value="${item.keterangan }">
		
		<div class="form-group">
			<p>Apakah anda yakin mau menghapus data role ${item.namaRole} ?</p>				
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">HAPUS</button>
	</div>
</form>
