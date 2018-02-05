<form id="form-penyakit" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="delete"> 
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }"> 
		<input type="hidden" id="nama" name="nama" class="form-control"	value="${item.nama }"> 
		<input type="hidden" id="gejala" name="gejala" class="form-control" value="${item.gejala }">

		<div class="form-group">
			<div class="col-md-12">
				<p>Apakah anda yakin mau menghapus data penyakit ${item.nama} ?</p>
			</div>
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Hapus</button>
	</div>
</form>
