<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data User</h3>
		<div class="box-tools">
			<button type="button" id="btn-add" class="btn btn-primary pull-right"><i class="fa fa-plus"></i> Add User</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nama User</th>
					<th>Username</th>
					<th>Password</th>
					<th>Role</th>
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
				<h4>Form User</h4>
			</div>
			<div class="modal-body">
			
			</div>
		</div>
	</div>
</div>

<script>
	function loadData(){
		$.ajax({
			url:'user/list.html',
			type:'get',
			dataType:'html',
			success:function(data){
				$("#list-data").html(data);
			}
		});
	}
	
	loadData();
	
	$(document).ready(function(){
		$("#btn-add").on("click", function(){
			$.ajax({
				url:'user/add.html',
				type:'get',
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					loadRole();
					$("#modal-input").modal('show');
					
				}
			});
		});
		
		function loadRole(){
			$.ajax({
				url:'ajax/getRole.json',
				type:'get',
				dataType:'json',
				success:function(data){
					$("#modal-input #roleId").empty();
					$("#modal-input #roleId").append('<option value="">Pilih Role</option>');
					$.each(data.result,function(index,item){
						$("#modal-input #roleId").append('<option value="'+ item.id +'">'+ item.namaRole +'</option>');
					});
				},
			});
		}
		
		$("#modal-input").on("submit","#form-user",function(){
			$.ajax({
				url:'user/save.json',
				type:'post',
				data:$(this).serialize(),
				dataType:'json',
				success:function(data){
					if(data.result=="berhasil"){
						$("#modal-input").modal('hide');
						loadData();
					}else{
						$("#modal-input").modal('show');
					}
				}
			});
			return false;
		});
		
		
		//tombol edit saat di klik
		$("#list-data").on("click",".btn-edit",function(){
			var vId = $(this).val();
			$.ajax({
				url:'user/edit.html',
				type:'get',
				data:{id:vId},
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					loadRole();
					$("#modal-input").modal('show');
				}
			});
		});
		
		//tombol delete saat di klik
		$("#list-data").on("click",".btn-delete",function(){
			var vId = $(this).val();
			$.ajax({
				url:'user/delete.html',
				type:'get',
				data:{id:vId},
				dataType:'html',
				success:function(data){
					$("#modal-input").find(".modal-body").html(data);
					$("#modal-input").modal('show');
				}
			});
		});
		
	});

</script>