<form id="form-user" action="save" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="insert">
		<div class="form-group">
			<label class="control-label col-md-3">Nama User</label>
			<div class="col-md-8">
				<input type="text" id="namaUser" name="namaUser" class="form-control">
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-3">Username</label>
			<div class="col-md-8">
				<input type="text" id="username" name="username" class="form-control">
			</div>					
		</div>
		<div class="form-group">
			<label class="control-label col-md-3">Password</label>
			<div class="col-md-8">
				<input type="password" id="password" name="password" class="form-control">
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