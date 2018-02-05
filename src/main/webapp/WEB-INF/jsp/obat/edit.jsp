<form id="form-obat" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="update">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Obat</label>
			<div class="col-md-6">
				<input type="text" id="nama" name="nama" class="form-control" value="${item.nama }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Kemasan</label>
			<div class="col-md-6">
				<input type="text" id="kemasan" name="kemasan" class="form-control" value="${item.kemasan }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Harga</label>
			<div class="col-md-6">
				<input type="text" id="harga" name="harga" class="form-control" value="${item.harga }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Dosis</label>
			<div class="col-md-6">
				<input type="text" id="dosis" name="dosis" class="form-control" value="${item.dosis }">
			</div>					
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
