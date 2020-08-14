
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

$("#ajaxCallUpload").click(function (e) {
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

$("#locationAjaxCallUpload").click(function (e) {
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