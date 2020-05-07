$(document).ready(function() {
		$('#usersDashBordTable').DataTable();
	});








function showRateDiv() {
	$('#productRateDiv').show();



	var table = document.getElementById('usersDashBordTable');

	for (var i = 1; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			//rIndex = this.rowIndex;
			document.getElementById("productID").value = this.cells[0].innerHTML;
			document.getElementById("productName").value = this.cells[2].innerHTML;
//			document.getElementById("productID").value = this.cells[1].innerHTML;
//			document.getElementById("newpassword").value = this.cells[2].innerHTML;
//			document.getElementById("newadminstatus").value = this.cells[3].innerHTML;
		};
	}

};





function addToCart() {
	
	
	var table = document.getElementById('usersDashBordTable');

	for (var i = 1; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			//rIndex = this.rowIndex;
			
			
			
			document.getElementById("row").value = this.cells[0].innerHTML;
			
			
		};
	}

};


