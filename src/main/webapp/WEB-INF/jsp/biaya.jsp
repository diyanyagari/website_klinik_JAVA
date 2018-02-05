<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Biaya</h3>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary pull-right"><i class="fa fa-plus"></i> Add Biaya</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nama</th>
					<th>Harga</th>
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
				<h4>Form Biaya</h4>
			</div>
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<script>
	function loadData(){
		$.ajax({
			url:'biaya/list.html',
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
				url:'biaya/add.html',
				type:'get',
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					$("#modal-input").modal('show');
				}
			});
			
		});
		
		$("#modal-input").on("submit","#form-biaya",function(){
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
		});
	});
</script>
