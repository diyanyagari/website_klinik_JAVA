<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<form id="form-role" action="update" method="post">
	<div class="form-horizontal">
		<input type="hidden" id="proses" name="proses" class="form-control" value="update">
		<input type="hidden" id="id" name="id" class="form-control" value="${item.id }">
		
		<div class="form-group">
			<label class="control-label col-md-2">Nama Role</label>
			<div class="col-md-6">
				<input type="text" id="namaRole" name="namaRole" class="form-control" value="${item.namaRole }">
			</div>					
		</div>
		
		<div class="form-group">
			<label class="control-label col-md-2">Keterangan</label>
			<div class="col-md-6">
				<input type="text" id="keterangan" name="keterangan" class="form-control" value="${item.keterangan }">
			</div>					
		</div>
		
	</div>

	<div class="modal-footer">
		<button type="submit" class="btn btn-success">Simpan</button>
	</div>
</form>
