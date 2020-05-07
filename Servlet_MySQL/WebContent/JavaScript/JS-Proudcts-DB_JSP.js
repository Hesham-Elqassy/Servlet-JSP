$(document).ready(function() {
		$('#ptable').DataTable();
	});


function showProductsUpdateDiv() {
		$('#myProductsDiv').show();
		$('#pIdInput').show();
		$('#psaveBTN').show();
		$('#paddBTN').hide();
		var table = document.getElementById('ptable');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("editedid").value = this.cells[0].innerHTML;
				document.getElementById("newProductName").value = this.cells[1].innerHTML;
				document.getElementById("newProductPrice").value = this.cells[2].innerHTML;
				document.getElementById("newProductQuantaty").value = this.cells[3].innerHTML;
				document.getElementById("newProductDescription").value = this.cells[4].innerHTML;
			};
		}

	};
	
	
	function showProductsAddForm(){
		$('#myProductsDiv').show();
		$('#pIdInput').hide();
		$('#paddBTN').show();
		$('#psaveBTN').hide();
		
	};