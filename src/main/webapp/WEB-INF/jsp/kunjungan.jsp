<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Kunjungan</h3>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary pull-right"><i class="fa fa-plus"></i> Add Kunjungan</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Id Pasien</th>
					<th>Id Dokter</th>
					<th>Tanggal</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody id="list-data">
			
			</tbody>
		</table>
	</div>
</div>

<!-- Modal -->
<div id="modal-input" class="modal">
	<div class="modal-dialog" style="width: 95%;">
		<div class="modal-content" style="margin: auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="fa fa-close"></i>
				</button>
				<h4>Form Kunjungan</h4>
			</div>
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="modal-search" class="modal">
	<div class="modal-dialog" style="width: 95%;">
		<div class="modal-content" style="margin: auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="fa fa-close"></i>
				</button>
				<h4>Form Kunjungan</h4>
			</div>
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>
<script>
	/*function loadData(){
		$.ajax({
			url:'kunjungan/list.html',
			type:'get',
			dataType:'html',
			success:function(data){
				$("#list-data").html(data);
			}
		});
	}
	
	loadData();*/
	
	$(document).ready(function(){
		
		$("#btn-add").on("click",function(){
			$.ajax({
				url:'kunjungan/add.html',
				type:'get',
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					loadDokter();
					loadPasien();
					loadBiaya();
					$("#modal-input").modal('show');
				}
			});
			
		});
		
		$('#modal-input').on("click", "#btn-search", function(){
			$.ajax({
				url:'kunjungan/pasienSearch.html',
				type:'get',
				dataType:'html',
				success:function(data){
					$("#modal-search .modal-body").html(data);
					$("#modal-search").modal('show');
				}
			});
		});
		
		$('#modal-search').on('click', '.btn-pasien-ok', function(){
			var id = $(this).val();
			var nama = $(this).attr('data-nama');
			var alamat = $(this).attr('data-alamat');
			var tempatLahir = $(this).attr('data-tempatLahir');
			var tglLahir = $(this).attr('data-tglLahir');
			
			$('#modal-input #namaPasien').val(nama);
			$('#modal-input #alamat').val(alamat);
			$('#modal-input #tempatLahir').val(tempatLahir + ', ' + tglLahir);
			$("#modal-search").modal('hide');
		});
		
		
		
		function loadPasien(){
			$.ajax({
				url:'ajax/getPasien.json',
				type:'get',
				dataType:'json',
				success:function(data){
					$("#modal-input #pasienId").empty();
					$("#modal-input #pasienId").append('<option value="">Pilih Pasien</option>');
					$.each(data.result,function(index,item){
						$("#modal-input #pasienId").append('<option value="'+ item.id +'">'+ item.nama +'</option>');
					});
				},
			});
		}
		
		function loadDokter(){
			$.ajax({
				url:'ajax/getDokter.json',
				type:'get',
				dataType:'json',
				success:function(data){
					$("#modal-input #dokterId").empty();
					$("#modal-input #dokterId").append('<option value="">Pilih Dokter</option>');
					$.each(data.result,function(index,item){
						$("#modal-input #dokterId").append('<option value="'+ item.id +'">'+ item.nama +'</option>');
					});
				},
			});
		}
		
		/* function loadBiaya(){
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
		} */
		
		$("#modal-input").on("submit","#form-biaya",function(){
			$.ajax({
				url:'kunjungan/save.json',
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
				url:'kunjungan/edit.html',
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
				url:'kunjungan/delete.html',
				type:'get',
				data:{ id:vId },
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					$("#modal-input").modal('show');
				}
			});
		});
	});
</script>
