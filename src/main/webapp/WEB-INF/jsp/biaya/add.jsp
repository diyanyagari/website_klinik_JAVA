<form id="form-biaya" action="save" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="insert">
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Biaya</label>
			<div class="col-md-6">
				<input type="text" id="nama" name="nama" class="form-control">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Harga</label>
			<div class="col-md-6">
				<input type="text" id="harga" name="harga" class="form-control">
			</div>					
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>