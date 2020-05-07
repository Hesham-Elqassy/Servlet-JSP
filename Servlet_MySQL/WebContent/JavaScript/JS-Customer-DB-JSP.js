
	$(document).ready(function() {
		
		$('#utable').DataTable();
	});

	function showDiv() {
		$('#mydiv').show();
		$('#IdInput').show();
		$('#saveBTN').show();
		$('#addBTN').hide();
		var table = document.getElementById('utable');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("editedid").value = this.cells[0].innerHTML;
				document.getElementById("newusername").value = this.cells[1].innerHTML;
				document.getElementById("newpassword").value = this.cells[2].innerHTML;
				document.getElementById("newadminstatus").value = this.cells[3].innerHTML;
			};
		}

	};
	
	
	function showAddForm(){
		$('#mydiv').show();
		$('#IdInput').hide();
		$('#addBTN').show();
		$('#saveBTN').hide();
		
	};
	
	
	
	

	// 	$("#table tbody").on('click',"#btn",function(){
	// 		$('#mydiv').show();

	// 	});

	// 		function showDiv() {
	// 			$('#table td').each(function() {
	// 				var currow = $(this).closest('tr');

	// 				var col1 = currow.find('td:eq(0)').text();
	// 				var col2 = currow.find('td:eq(1)').text();
	// 				var col3 = currow.find('td:eq(2)').text();
	// 				var col4 = currow.find('td:eq(3)').text();

	// 				$("#id2").text(col1);

	// 			});

	// 			$('#mydiv').show();

	// 		};

	