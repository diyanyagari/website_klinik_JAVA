<form id="form-pasien" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="delete">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.nomorRm }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.nama }">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.alamat }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.propinsiId }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.kotaId }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.kecamatanId }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.JK }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.tempatLahir }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.tglLahir }">
		<input type="hidden" id="nama" name="nama" class="form-control" value="${item.pekerjaan }">
		
		<div class="form-group">
			<p>Apakah anda yakin mau menghapus data dokter ${item.nama} ?</p>				
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
