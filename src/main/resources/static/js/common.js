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
	$('#exportMediumReportInExcel').click(function() {
		window.open("/export-medium");
	});
	$('#exportCenterReportInExcel').click(function() {
		window.open("/export-center");
	});
	$('#exportHeadExaminerReportInExcel').click(function() {
		window.open("/export-head-examiner");
	});
	$('#exportExaminerReportInExcel').click(function() {
		window.open("/export-examiner");
	});
});
function refreshForm(){
	window.location.reload();
}
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
function deleteMedium(id) {
	$.ajax({
		url: '/delete-medium/' + id,
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

$("#mediumAjaxCallUpload").click(function(e) {
	var formData = new FormData($("#mediumUploadForm")[0]);
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/upload-medium",
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
function deleteCenter(id) {
	$.ajax({
		url: '/delete-center/' + id,
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

$("#centerAjaxCallUpload").click(function(e) {
	var formData = new FormData($("#centerUploadForm")[0]);
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/upload-center",
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
function deleteHeadExaminer(id) {
	$.ajax({
		url: '/delete-head-examiner/' + id,
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

$("#headExaminerAjaxCallUpload").click(function(e) {
	var formData = new FormData($("#headExaminerUploadForm")[0]);
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/upload-head-examiner",
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
function deleteExaminer(id) {
	$.ajax({
		url: '/delete-examiner/' + id,
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

$("#examinerAjaxCallUpload").click(function(e) {
	var formData = new FormData($("#examinerUploadForm")[0]);
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/upload-examiner",
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