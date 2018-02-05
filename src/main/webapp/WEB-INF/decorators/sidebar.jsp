<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${contextName}/assets/dist/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${username}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<li>
				<a href="#"> 
					<i	class="fa fa-user"></i> <span>Users</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/user.html"><i class="fa fa-circle-o"></i> User</a></li>
					<li><a href="${contextName}/role.html"><i class="fa fa-circle-o"></i> Role</a></li>
				</ul>
			</li>
			
			<li class="treeview">
				<a href="#"> 
					<i	class="fa fa-dashboard"></i> <span>Master Data</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/obat.html" class="menu-item"><i class="fa fa-circle-o"></i> Obat</a></li>
					<li><a href="${contextName}/biaya.html" class="menu-item"><i class="fa fa-circle-o"></i> Biaya</a></li>
					<li><a href="${contextName}/dokter.html" class="menu-item"><i class="fa fa-circle-o"></i> Dokter</a></li>
					<li><a href="${contextName}/penyakit.html" class="menu-item"><i class="fa fa-circle-o"></i> Penyakit</a></li>
					<li><a href="${contextName}/pasien.html" class="menu-item"><i class="fa fa-circle-o"></i> Pasien</a></li>
				</ul>
			</li>
			<li>
				<a href="#"> 
					<i	class="fa fa-laptop"></i> <span>Purchase</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/purchase/request.html"><i class="fa fa-circle-o"></i> Request</a></li>
					<li><a href="${contextName}/purchase/order.html"><i class="fa fa-circle-o"></i> Order</a></li>
				</ul>
			</li>
			
			<li>
				<a href="#"> 
					<i	class="fa fa-pie-chart"></i> <span>Transaksi</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/kunjungan.html"><i class="fa fa-circle-o"></i> Kunjungan</a></li>
					<li><a href="${contextName}/resep.html"><i class="fa fa-circle-o"></i> Resep</a></li>
				</ul>
			</li>
			
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>