<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<form id="form-dokter" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="update">
		<div class="form-group">
			<label class="control-label col-md-2">ID</label>
			<div class="col-md-6">
				<input type="text" id="id" name="id" class="form-control" value="${item.id }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Dokter</label>
			<div class="col-md-6">
				<input type="text" id="nama" name="nama" class="form-control" value="${item.nama }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Dokter</label>
			<div class="col-md-6">
				<input type="text" id="alamat" name="alamat" class="form-control" value="${item.alamat }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-3">Propinsi</label>
			<div class="col-md-8">
				<select id="propinsiId" name="propinsiId" class="form-control">
					<option>Pilih Propinsi</option>							
					
				</select>
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-3">Kota</label>
			<div class="col-md-8">
				<select id="kotaId" name="kotaId" class="form-control">
					<option>Pilih Kota</option>							
				
				</select>
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-3">Kecamatan</label>
			<div class="col-md-8">
				<select id="kecamatanId" name="kecamatanId" class="form-control">
					<option>Pilih Kecamatan</option>							
					
				</select>
			</div>					
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
