<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Obat</h3>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary pull-right"><i class="fa fa-plus"></i> Add Obat</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nama</th>
					<th>Kemasan</th>
					<th>Harga</th>
					<th>Dosis</th>
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
				<h4>Form Obat</h4>
			</div>
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<script>
	function loadData(){
		$.ajax({
			url:'obat/list.html',
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
				url:'obat/add.html',
				type:'get',
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					$("#modal-input").modal('show');
				}
			});
			
		});
		
		$("#modal-input").on("submit","#form-obat",function(){
			$.ajax({
				url:'obat/save.json',
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
				url:'obat/edit.html',
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
				url:'obat/delete.html',
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
