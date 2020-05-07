
	$(document).ready(function() {
		$('#usersInfoTable').DataTable();
	});
	
	


	function showUserInfoDiv() {
		$('#myUserInfoDiv').show();
		$('#IdInput').show();
		$('#saveBTN').show();
		
		var table = document.getElementById('usersInfoTable');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("editedid").value = this.cells[0].innerHTML;
				document.getElementById("newusername").value = this.cells[1].innerHTML;
				document.getElementById("newpassword").value = this.cells[2].innerHTML;
				
			};
		}

	};
	
	
	
	function showUserOrdersInfoDiv() {
		
		
		var table = document.getElementById('usersInfoTable');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("userIdForGetOrder").value = this.cells[0].innerHTML;
				
				
			};
		}

	};
	
	
	
	
	
	
