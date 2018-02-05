<form id="form-obat" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="delete"> 
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }"> 
		<input type="hidden" id="nama" name="nama" class="form-control"	value="${item.nama }"> 
		<input type="hidden" id="kemasan" name="kemasan" class="form-control" value="${item.kemasan }">
		<input type="hidden" id="harga" name="harga" class="form-control" value="${item.harga }">
		<input type="hidden" id="dosis" name="dosis" class="form-control" value="${item.dosis }">

		<div class="form-group">
			<div class="col-md-12">
				<p>Apakah anda yakin mau menghapus data obat ${item.nama} ?</p>
			</div>
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
