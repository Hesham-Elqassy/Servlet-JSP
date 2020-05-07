
	$(document).ready(function() {
		$('#userOrdersTable').DataTable();
	});
	
	
	
	function showProductsUpdateDiv() {
		$('#myProductsDiv').show();
		$('#pIdInput').show();
		$('#psaveBTN').show();
		
		var table = document.getElementById('userOrdersTable');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("editedid").value = this.cells[0].innerHTML;
				document.getElementById("newProductName").value = this.cells[1].innerHTML;
				document.getElementById("newProductPrice").value = this.cells[2].innerHTML;
				
				
			};
		}

	};
	
	
	