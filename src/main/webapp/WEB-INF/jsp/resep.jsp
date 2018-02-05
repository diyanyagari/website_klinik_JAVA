<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Resep</h3>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary pull-right">
				<i class="fa fa-plus"></i> Add Resep
			</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Kunjungan Id</th>
					<th>Dokter</th>
					<th>Pasien</th>
				</tr>
			</thead>
			<tbody id="list-data">

			</tbody>
		</table>
	</div>
</div>

<!-- Modal -->
<div id="modal-input" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="fa fa-close"></i>
				</button>
				<h4>Form Resep</h4>
			</div>
			<div class="modal-body"></div>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="modal-search-obat" class="modal">
	<div class="modal-dialog">
		<div class="modal-content" style="margin: auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="fa fa-close"></i>
				</button>
				<h4>Daftar Obat</h4>
				<div class="modal-body">
					<table class="table">
						<tbody id="list-data-obat">

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="modal-jumlah-item" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="fa fa-close"></i>
				</button>
				<h4>Jumlah Obat</h4>
			</div>
			<div class="modal-body">
				<input class="form-control" id="idObat" type="hidden"
					readonly="readonly">
				<div class="form-group">
					<label for="namaObat" class="col-sm-2 control-label">Nama</label>
					<div class="col-sm-10">
						<input class="form-control" id="namaObat" type="text"
							readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label for="kemasan" class="col-sm-2 control-label">Kemasan</label>
					<div class="col-sm-10">
						<input class="form-control" id="kemasan" type="text"
							readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label for="harga" class="col-sm-2 control-label">Harga</label>
					<div class="col-sm-10">
						<input class="form-control" id="harga" type="number"
							readonly="readonly">
					</div>
				</div>

				<div class="form-group">
					<label for="jumlahBeli" class="col-sm-2 control-label">Jumlah</label>
					<div class="col-sm-10">
						<input class="form-control" id="jumlahBeli" type="number"
							onkeydown="hitungSubTotal()" onkeypress="hitungSubTotal()"
							onkeyup="hitungSubTotal()" autofocus="autofocus">
					</div>
				</div>

				<div class="form-group">
					<label for="judulBuku" class="col-sm-2 control-label">Sub
						Total</label>
					<div class="col-sm-10">
						<input class="form-control" id="subTotal" type="text"
							readonly="readonly">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left"
					data-dismiss="modal" onclick="bersihJumlah()">Batalkan</button>
				<button type="button" class="btn btn-primary" id="konfirmasiTambah">Tambahkan</button>
			</div>
		</div>
	</div>
</div>

<script>
	/* function loadData(){
		$.ajax({
			url:'biaya/list.html',
			type:'get',
			dataType:'html',
			success:function(data){
				$("#list-data").html(data);
			}
		});
	}
	
	loadData(); */
	
	var itemBeli = [];
	var resep = [];

	$("#modal-input").on("click", "#tambah-item", function() {
		loadObat();
	});

	$("#btn-add").on("click", function() {
		$.ajax({
			url : 'resep/add.html',
			type : 'get',
			dataType : 'html',
			success : function(data) {
				$("#modal-input").find(".modal-body").html(data);
				loadDokter();
				loadPasien();
				$("#modal-input").modal('show');
			}
		});

	});

	function loadPasien() {
		$.ajax({
			url : 'ajax/getPasien.json',
			type : 'get',
			dataType : 'json',
			success : function(data) {
				$("#modal-input #pasienId").empty();
				$("#modal-input #pasienId").append(
						'<option value="">Pilih Pasien</option>');
				$.each(data.result, function(index, item) {
					$("#modal-input #pasienId").append(
							'<option value="'+ item.id +'">' + item.nama
									+ '</option>');
				});
			},
		});
	}

	function loadDokter() {
		$.ajax({
			url : 'ajax/getDokter.json',
			type : 'get',
			dataType : 'json',
			success : function(data) {
				$("#modal-input #dokterId").empty();
				$("#modal-input #dokterId").append(
						'<option value="">Pilih Dokter</option>');
				$.each(data.result, function(index, item) {
					$("#modal-input #dokterId").append(
							'<option value="'+ item.id +'">' + item.nama
									+ '</option>');
				});
			},
		});
	}

	function loadObat() {
		$.ajax({
			url : 'resep/listObat.html',
			type : 'get',
			dataType : 'html',
			success : function(data) {
				$("#list-data-obat").html(data);
				$("#modal-search-obat").modal('show');
			}
		});
	}

	$('#modal-search-obat').on("click", ".btn-obat-ok", function() {
		$('#modal-jumlah-item #idObat').val($(this).val());
		$('#modal-jumlah-item #namaObat').val($(this).attr('data-nama'));
		$('#modal-jumlah-item #kemasan').val($(this).attr('data-kemasan'));
		$('#modal-jumlah-item #harga').val($(this).attr('data-harga'));
		
		$('#modal-jumlah-item').modal('show');
		$('#modal-search-obat').modal('hide');
	});
	
	function hitungSubTotal() {
		var jmlBeli = $("#modal-jumlah-item #jumlahBeli").val();
		var subTotal = $("#modal-jumlah-item #harga").val() * jmlBeli;
		$("#modal-jumlah-item #subTotal").val(subTotal);
	}
	
	function bersihJumlah() {
		$('#modal-jumlah-item #idObat').val("");
		$('#modal-jumlah-item #namaObat').val("");
		$('#modal-jumlah-item #kemasan').val("");
		$('#modal-jumlah-item #harga').val("");
		$('#modal-jumlah-item #jumlahBeli').val("");
		$('#modal-jumlah-item #subTotal').val("");
	}
	
	$('#modal-jumlah-item').on('click', '#konfirmasiTambah', function() {
		addItem();
		bersihJumlah();
		showItemObat();
		$('#modal-jumlah-item').modal('hide');
	});
	
	function addItem() {
		var newData = {
			obatId : $('#modal-jumlah-item #idObat').val(),
			harga : $('#modal-jumlah-item #harga').val(),
			jumlah : $('#modal-jumlah-item #jumlahBeli').val(),
			subTotal : $('#modal-jumlah-item #subTotal').val(),
		};
		itemBeli.push(newData);
	}
	
	function showItemObat() {
		$("#modal-input #listBeli").empty();
		var tr;
		for (var i = 0; i < itemBeli.length; i++) {
			var obj = itemBeli[i];
			tr = '<tr>'+
					'<td>'+(i+1)+'</td>'+
 					'<td>'+obj.obatId+'</td>'+
					'<td>'+obj.harga+'</td>'+
					'<td>'+obj.jumlah+'</td>'+
					'<td>'+obj.subTotal+'</td>'+
					'<td><button type="button" class="btn btn-block btn-danger btn-xs" '+
					'value="'+i+'" onclick="hapusItemObat('+i+')">Hapus</button></td>'+
				'</tr>';
				
				
			$("#modal-input #listBeli").append(tr);
		}
	}
	
	function hapusItemObat(index) {
		itemBeli.splice(index, 1);
		showItemObat();
	}
	
	function addResep() {
		var newData = {
			kunjunganId : $('#modal-input #kunjunganId').val(),
			pasienId : $('#modal-input #pasienId').val(),
			dokterId : $('#modal-input #dokterId').val(),
			itemBeli : itemBeli
		}
		resep.push(newData);
		console.log(resep);
		resep = [];
		itemBeli = [];
		$('#modal-input').modal('hide');
	}
	
	
	/* 		$("#modal-input").on("submit","#form-biaya",function(){
	 $.ajax({
	 url:'biaya/save.json',
	 type:'post',
	 data:$(this).serialize(),
	 dataType:'json',
	 success:function(data){
	 if(data.result=="berhasil"){
	 $("#modal-input").modal('hide');
	 loadData();
	 }
	 else{
	 $("#modal-input").modal('show');
	 }
	 }
	 });
	 return false;
	 });
	
	 // buttun edit di klik
	 $("#list-data").on("click",".btn-edit",function(){
	 var vId = $(this).val();
	 $.ajax({
	 url:'biaya/edit.html',
	 type:'get',
	 data:{ id:vId },
	 dataType:'html',
	 success:function(data){
	 $("#modal-input").find(".modal-body").html(data);
	 $("#modal-input").modal('show');
	 }
	 });
	 });
	
	 // button delete
	 $("#list-data").on("click",".btn-delete",function(){
	 var vId = $(this).val();
	 $.ajax({
	 url:'biaya/delete.html',
	 type:'get',
	 data:{ id:vId },
	 dataType:'html',
	 success:function(data){
	 $("#modal-input").find(".modal-body").html(data);
	 $("#modal-input").modal('show');
	 }
	 });
	 });*/
</script>
