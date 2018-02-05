<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Dokter</h3>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary pull-right"><i class="fa fa-plus"></i> Add Dokter</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nama</th>
					<th>Alamat</th>
					<th>Kecamatan</th>
					<th>Kota</th>
					<th>Propinsi</th>
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
				<h4>Form Dokter</h4>
			</div>
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<script>
	function loadData(){
		$.ajax({
			url:'dokter/list.html',
			type:'get',
			dataType:'html',
			success:function(data){
				$("#list-data").html(data);
			}
		});
	}
	
	loadData();
	
	$(document).ready(function(){
		
		$("#btn-add").on("click",function(){
			$.ajax({
				url:'dokter/add.html',
				type:'get',
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					loadProvinsi();
					$("#modal-input").modal('show');
				}
			});
			
		});
		
		// buttun edit di klik
		$("#list-data").on("click",".btn-edit",function(){
			var vId = $(this).val();
			$.ajax({
				url:'dokter/edit.html',
				type:'get',
				data:{ id:vId },
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					loadProvinsi();
					$("#modal-input").modal('show');
				}
			});
		});
		
		function loadProvinsi(){
			$.ajax({
				url:'ajax/getProvinsi.json',
				type:'get',
				dataType:'json',
				success:function(data){
					$("#modal-input #propinsiId").empty();
					$("#modal-input #propinsiId").append('<option value="">Pilih Provinsi</option>');
					$.each(data.result,function(index,item){
						$("#modal-input #propinsiId").append('<option value="'+ item.id +'">'+ item.nama +'</option>');
					});
				},
			});
		}
		
		$("#modal-input").on("change","#propinsiId",function(){
			var id = $(this).val();
			$.ajax({
				url:'ajax/getKota.json',
				type:'get',
				data:{ propinsiId:id },
				dataType:'json',
				success:function(data){
					$("#modal-input").find('#kotaId').empty();
					$("#modal-input").find('#kotaId').append('<option value=""> Pilih Kota </option>');
					
					$.each(data.list, function(index, item){
						$("#modal-input").find('#kotaId').append('<option value="'+ item.id +'"> '+ item.nama +' </option>');
					});
				}
			});
			
		});
		
		$("#modal-input").on("change","#kotaId",function(){
			var id = $(this).val();
			$.ajax({
				url:'ajax/getKecamatan.json',
				type:'get',
				data:{ kotaId:id },
				dataType:'json',
				success:function(data){
					$("#modal-input").find('#kecamatanId').empty();
					$("#modal-input").find('#kecamatanId').append('<option value=""> Pilih Kecamatan </option>');
					
					$.each(data.list, function(index, item){
						$("#modal-input").find('#kecamatanId').append('<option value="'+ item.id +'"> '+ item.nama +' </option>');
					});
				}
			});
			
		});

		
		$("#modal-input").on("submit","#form-dokter",function(){
			$.ajax({
				url:'dokter/save.json',
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
		
		// button delete
		$("#list-data").on("click",".btn-delete",function(){
			var vId = $(this).val();
			$.ajax({
				url:'dokter/delete.html',
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
