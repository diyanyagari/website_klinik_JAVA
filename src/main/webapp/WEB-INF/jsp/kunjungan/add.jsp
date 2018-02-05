<form id="form-kunjungan" class="form-horizontal" action="save"
	method="post">
	<input type="hidden" id="proses" name="proses" class="form-control"
		value="insert">
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-3">Nama Pasien</label>
				<div class="col-md-8">
					<div class="input-group input-group-sm">
						<input type="text" name="namaPasien" id="namaPasien"
							class="form-control" /> <span class="input-group-btn">
							<button type="button" id="btn-search"
								class="btn btn-info btn-flat">Go!</button>
						</span>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Alamat</label>
				<div class="col-md-8">
					<input type="text" name="alamat" id="alamat" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Tempat Lahir</label>
				<div class="col-md-8">
					<input type="text" name="tempatLahir" id="tempatLahir"
						class="form-control">
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
			<div class="form-group">
				<label class="control-label col-md-3">Tanggal Kunjungan</label>
				<div class="col-md-8">
					<input type="text" name="tglKunjungan" id="tglKunjungan"
						class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Keluhan</label>
				<div class="col-md-8">
					<input type="text" name="tglKunjungan" id="tglKunjungan"
						class="form-control">
				</div>
			</div>
		</div>
	</div>

	<div class="box box-success">
		<div class="box-header">
			<h3 class="box-title">List Kunjungan</h3>
		</div>
		<div class="box-body">
			<div class="form-group">
				<div class="col-xs-3">
					<select id="biayaId" name="biayaId[0]" class="form-control biayaId">
						<option>Nama Biaya</option>
					</select>
				</div>
				<div class="col-xs-3">
					<input type="text" id="harga" name="harga[0]"
						class="form-control harga" placeholder="Biaya">
				</div>
				<div class="col-xs-3">
					<input type="text" id="banyak" name="banyak[0]"
						class="form-control banyak" placeholder="Jumlah">
				</div>
				<div class="col-xs-3">
					<div class="input-group">
						<input type="text" id="subTotal" name="subTotal[0]"
							class="form-control subTotal" placeholder="Sub Total">
						<div class="input-group-btn">
							<button class="btn btn-success" type="button"
								onclick="kunjungan_fields();">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
						</div>

						<div class="clear"></div>

					</div>
				</div>
			</div>
			<div id="kunjungan_fields" class="form-group"></div>
		</div>
	</div>
	<div class="modal-footer">
				<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
<script>
	var room = 0;

	function kunjungan_fields() {

		room++;
		var objTo = document.getElementById('kunjungan_fields')
		var divtest = document.createElement("div");
		divtest.setAttribute("class", "form-group removeclass" + room);
		var rdiv = 'removeclass' + room;
		loadBiaya();
		divtest.innerHTML = '<div class="col-xs-3"><select id="biayaId" name="biayaId['+room+']" class="form-control biayaId"><option>Nama Biaya</option>	</select></div>	<div class="col-xs-3"><input type="text" id="harga" name="harga['+room+']" class="form-control harga" placeholder="Biaya"></div><div class="col-xs-3"><input type="text" id="banyak" name="banyak['+room+']" class="form-control banyak" placeholder="Jumlah"></div><div class="col-xs-3"><div class="input-group"><input type="text" id="subTotal" name="subTotal['+room+']"class="form-control subTotal" placeholder="Sub Total"><div class="input-group-btn"><button class="btn btn-danger" type="button" onclick="remove_kunjungan_fields('
				+ room
				+ ');"> <span class="glyphicon glyphicon-minus" aria-hidden="true"></span> </button></div><div class="clear"></div></div></div>';

		objTo.appendChild(divtest)
	}
	
	function remove_kunjungan_fields(rid) {
		$('.removeclass' + rid).remove();
	}
	
	function loadBiaya(){
		$.ajax({
			url:'ajax/getBiaya.json',
			type:'get',
			dataType:'json',
			success:function(data){
				$("#modal-input .biayaId").empty();
				$("#modal-input .biayaId").append('<option value="">Pilih Biaya</option>');
				$.each(data.result,function(index,item){
					$("#modal-input .biayaId").append('<option value="'+ item.id +'">'+ item.nama +'</option>');
				});
			},
		});
	}
</script>
