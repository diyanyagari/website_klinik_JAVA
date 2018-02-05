<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<form id="form-user" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="update">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama User</label>
			<div class="col-md-6">
				<input type="text" id="namaUser" name="namaUser" class="form-control" value="${item.namaUser }">
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Username</label>
			<div class="col-md-6">
				<input type="text" id="username" name="username" class="form-control" value="${item.username }">
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Password</label>
			<div class="col-md-6">
				<input type="password" id="password" name="password" class="form-control" value="${item.password }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Role Id</label>
			<div class="col-md-6">
				<select id="roleId" name="roleId" class="form-control" required="required">
						
				</select>
			</div>					
		</div>
		
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>

<script type="text/javascript">
	function loadRole(selectedId){
		$.ajax({
			url:'ajax/getRole.json',
			type:'get',
			dataType:'json',
			success:function(data){
				$("#modal-input #roleId").empty();
				$("#modal-input #roleId").append('<option value=""></option>');
				$.each(data.result,function(index,item){
					if (selectedId == item.id) {
						$("#modal-input #roleId").append('<option value="'+ item.id +'" selected="selected">'+ item.namaRole +'</option>');
					}else{
						$("#modal-input #roleId").append('<option value="'+ item.id +'">'+ item.namaRole +'</option>');
					}
				});
			},
		});
	}
	$(document).ready(function(){
		loadRole("${item.roleId}");
	});

	</script>
