/**
 * 
 */
$(document).ready(function() {
 	///////////////////R SyllabusName//////////////////////////
	$(".r_syllabusfk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RSyllabus/',
			dataType : 'json',
			data : function(params) {
				return {
					q : params.term
				};
			},
			processResults : function(data) {
				return {
					results : $.map(data, function(obj) {
						return {
							id : obj.id,
							text : obj.id + '||' + obj.name_,
							name : obj.id
						};
					})
				};
			}
		}

	});
 	///////////////////R AttendanceType////////////////////
	$(".r_attendancetypefk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RAttendanceType/',
			dataType : 'json',
			data : function(params) {
				return {
					q : params.term
				};
			},
			processResults : function(data) {
				return {
					results : $.map(data, function(obj) {
						return {
							id : obj.id,
							text : obj.id + '||' + obj.name_,
							name : obj.id
						};
					})
				};
			}
		}

	});
	
	///////////////////COURSE//////////////
	$(".course_fk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/Course/',
			dataType : 'json',
			data : function(params) {
				return {
					q : params.term
				};
			},
			processResults : function(data) {
				return {
					results : $.map(data, function(obj) {
						return {
							id : obj.id,
							text : obj.id + '||' + obj.title,
							name : obj.id
						};
					})
				};
			}
		}

	});
	///////////////////BATCH//////////////
	$(".batch_fk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/BATCH/',
			dataType : 'json',
			data : function(params) {
				return {
					q : params.term
				};
			},
			processResults : function(data) {
				return {
					results : $.map(data, function(obj) {
						return {
							id : obj.id,
							text : obj.id + '||' + obj.name_,
							name : obj.id
						};
					})
				};
			}
		}

	});
});