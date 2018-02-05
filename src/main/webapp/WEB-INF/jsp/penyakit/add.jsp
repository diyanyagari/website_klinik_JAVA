<form id="form-penyakit" action="save" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="insert">
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Penyakit</label>
			<div class="col-md-6">
				<input type="text" id="nama" name="nama" class="form-control">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Gejala</label>
			<div class="col-md-6">
				<input type="text" id="gejala" name="gejala" class="form-control">
			</div>					
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>