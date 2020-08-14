$(document).ready(function() {
	// Activate tooltips
	$('[data-toggle="tooltip"]').tooltip();

	// Filter table rows based on searched term
	$("#search").on("keyup", function() {
		var term = $(this).val().toLowerCase();
		$("table tbody tr").each(function() {
			$row = $(this);
			var name = $row.find("td:nth-child(2)").text().toLowerCase();
			console.log(name);
			if (name.search(term) < 0) {
				$row.hide();
			} else {
				$row.show();
			}
		});
	});

	$('#exportSubjectsReportInExcel').click(function() {
		window.open("/export-subjects");
	});
	$('#exportLocationsReportInExcel').click(function() {
		window.open("/export-locations");
	});
});
function mypopup(url) {
	width = window.screen.width;
	height = window.screen.height;
	mywindow = window.open(url, "Title",
		"location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="
		+ width + ",height=" + height);
	mywindow.moveTo(0, 0);
	mywindow.focus();
}
function openForm() {
	document.getElementById("uploadForm").style.display = "block";
}

function closeForm() {
	document.getElementById("uploadForm").style.display = "none";
}
function deleteSubject(id) {
	$.ajax({
		url: '/delete-subject/' + id,
		method: 'DELETE',
		success: function() {
			alert("Record has been deleteds");
			window.location.reload();
		},
		error: function(error) {
			alert("Record has been deleteds");
			window.location.reload();
		}
	})
}

$("#ajaxCallUpload").click(function(e) {
	var formData = new FormData($("#subjectUploadForm")[0]);
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/upload-subject",
		headers: { 'IsAjax': 'true' },
		dataType: "json",
		processData: false,
		contentType: false,
		data: formData,
		success: function() {
			window.location.reload();
		},
		error: function(error) {
			window.location.reload();
		}
	});
});

function deleteLocation(id) {
	$.ajax({
		url: '/delete-location/' + id,
		method: 'DELETE',
		success: function() {
			alert("Record has been deleteds");
			window.location.reload();
		},
		error: function(error) {
			alert("Record has been deleteds");
			window.location.reload();
		}
	})
}

$("#locationAjaxCallUpload").click(function(e) {
	var formData = new FormData($("#locationUploadForm")[0]);
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/upload-location",
		headers: { 'IsAjax': 'true' },
		dataType: "json",
		processData: false,
		contentType: false,
		data: formData,
		success: function() {
			window.location.reload();
		},
		error: function(error) {
			window.location.reload();
		}
	});
});