<form id="form-penyakit" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="update">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Penyakit</label>
			<div class="col-md-6">
				<input type="text" id="nama" name="nama" class="form-control" value="${item.nama }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Gejala</label>
			<div class="col-md-6">
				<input type="text" id="gejala" name="gejala" class="form-control" value="${item.gejala }">
			</div>					
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
