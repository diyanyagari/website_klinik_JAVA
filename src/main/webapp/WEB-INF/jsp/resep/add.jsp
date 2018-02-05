<form id="form-resep" class="form-horizontal" action="save"
	method="post">
	<input type="hidden" id="proses" name="proses" class="form-control"
		value="insert">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-3">Id Kunjungan</label>
				<div class="col-md-8">
					<div class="input-group input-group-sm">
						<input type="text" name="kunjunganId" id="kunjunganId"
							class="form-control" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Nama Pasien</label>
				<div class="col-md-8">
					<select id="pasienId" name="pasienId" class="form-control">
						<option>Nama Pasien</option>
					</select>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-3">Nama Dokter</label>
				<div class="col-md-8">
					<select id="dokterId" name="dokterId" class="form-control">
						<option>Nama Dokter</option>
					</select>
				</div>
			</div>
		</div>
	</div>


	<div class="modal-footer">
		<button type="button" class="btn btn-success" id="tambah-item">Tambah
			Item Obat</button>
	</div>
	
		<div class="box box-success">
		<div class="box-header">
			<h3 class="box-title">Item-item Obat Pada Resep</h3>
		</div>
		<div class="box-body no-padding">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th style="width: 10px">#</th>
						<th>Nama Obat</th>
						<th>Harga Satuan</th>
						<th>Jumlah Beli</th>
						<th>Sub Total</th>
					</tr>
				</thead>
				<tbody id="listBeli">
				</tbody>
			</table>
		</div>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-success" onclick="addResep()">Simpan</button>
	</div>
</form>