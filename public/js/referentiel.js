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
	///////////////////BATCH by COURSE//////////////
	$(".course_fk").change(function() {
		$('.batchByCourse').html('',true);
		var full_url = $(this).val();
		var url_array = full_url.split('||');
		$.getJSON("/BatchByCourse/" + url_array + "", function(data) {
			var series = {};
	    	series.data = [];
	    	$.each(data, function( key, val ) {
	    		series.data.push(val);

	    	  });
	    	$('.batchByCourse').append("<option selected='selected' disabled='disabled'>Choisir un resultat</option>");
	    	for (i in series.data) {
	    		
	    		  $('.batchByCourse').append($('<option>', { 
  	    	        value: series.data[i].id,
  	    	        text: series.data[i].batchName
  	    	       
  	    	    }));

	    		}
		});
	});
	///////////////////SUBJECT by BATCH//////////////
	$(".batchByCourse").change(function() {
		$('.subjectByBatch').html('',true);
		var full_url = $(this).val();
		var url_array = full_url.split('||');
		$.getJSON("/SubjectByBatch/" + url_array + "", function(data) {
			var series = {};
	    	series.data = [];
	    	$.each(data, function( key, val ) {
	    		series.data.push(val);

	    	  });
	    	$('.batchByCourse').append("<option selected='selected' disabled='disabled'>Choisir un resultat</option>");
	    	for (i in series.data) {
	    		  $('.subjectByBatch').append($('<option>', { 
  	    	        value: series.data[i].subject_id,
  	    	        text: series.data[i].subject_name
  	    	       
  	    	    }));

	    		}
		});
	});
	///////////////////AssignSubject///////////////////
	$.getJSON("/AssignSubject/", function(data) {
		$('.subject_fk').html('',true);
		var series = {};
    	series.data = [];
    	$.each(data, function( key, val ) {
    		series.data.push(val);

    	  });
    	$('.subject_fk').append("<option selected='selected' disabled='disabled'>Choisir un resultat</option>");
    	for (i in series.data) {
    		$('.options').append("<li>"+"<input type='hidden' name='subjectFkArray[]' value="+series.data[i].id+">" +"</li>");

    		  $('.subject_fk').append($('<option>', { 
	    	        value: series.data[i].id,
	    	        text: series.data[i].name
	    	       
	    	    }));

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
	///////////////////R MONTH//////////////
	$(".r_month_fk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RMonth/',
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
							text : obj.id + '||' + obj.month_,
							name : obj.id
						};
					})
				};
			}
		}

	});
	///////////////////R YEAR//////////////
	$(".r_year_fk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RYear/',
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
							text : obj.id + '||' + obj.year_,
							name : obj.id
						};
					})
				};
			}
		}

	});
	///////////////////R STATUS//////////////
	$(".r_status_fk").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RStatus/',
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
							text : obj.id + '||' + obj.status,
							name : obj.id
						};
					})
				};
			}
		}

	});
	////////////////////R LEVEL//////////////
	$(".r_level").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RLevel/',
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
							text : obj.id + '||' + obj.level,
							name : obj.id
						};
					})
				};
			}
		}

	});
 	///////////////////R COUNTRY////////////////
	$(".r_country").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RCountry/',
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
 	///////////////////R CAMPUS////////////////
	$(".r_campus").select2({
		placeholder : "Choisisser...",
		ajax : {
			url : '/RCampus/',
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