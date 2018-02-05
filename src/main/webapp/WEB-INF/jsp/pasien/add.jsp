<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<form id="form-pasien" action="save" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="insert">
		
		<div class="form-group">
			<label class="control-label col-md-3">No. Rekam Medis</label>
			<div class="col-md-8">
				<input type="text" id="nomor_rm" name="nomor_rm" class="form-control">
			</div>					
		</div>

		<div class="form-group">
			<label class="control-label col-md-3">Nama Pasien</label>
			<div class="col-md-8">
				<input type="text" id="nama" name="nama" class="form-control">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-3">Alamat</label>
			<div class="col-md-8">
				<input type="text" id="alamat" name="alamat" class="form-control">
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
					
				</select>
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-3">Kecamatan</label>
			<div class="col-md-8">
				<select id="kecamatanId" name="kecamatanId" class="form-control">
					
				</select>
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-3">Jenis Kelamin</label>
			<div class="col-md-8">
				<input type="radio" name="JK" value="Laki-laki"> L<br>
				<input type="radio" name="JK" value="Perempuan"> P<br>
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-3">Tempat Lahir</label>
			<div class="col-md-8">
				<input type="text" id="tempatLahir" name="tempatLahir" class="form-control">
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-3">Pekerjaan</label>
			<div class="col-md-8">
				<input type="date" id="tglLahir" name="tglLahir" class="form-control">
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-3">Pekerjaan</label>
			<div class="col-md-8">
				<input type="text" id="pekerjaan" name="pekerjaan" class="form-control">
			</div>					
		</div>
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>