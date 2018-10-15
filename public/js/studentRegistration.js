/**
 * 
 */
$(document).ready(function() {
	$(".r_country").change(function() {
		var r_country = $(this).val();
		$.getJSON("/RCountry/" + r_country + "", function(data) {
			//dataform.r_country_code.value = data;
			document.getElementById("phoneNo").value = data;
		});
	});
///////////////////R EMERGENCY CONTACT TYPE
	$(".r_emergency_contact_type").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/RContactPersonType/',
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
							text : obj.id + '||' + obj.typeName,
							name : obj.id
						};
					})
				};
			}
		}

	});

//////////////////////////////////////////////////////
/*	$(".institution").select2({
		placeholder : "Saisisse ...",
		ajax : {
			url : '/institution/',
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
							text : obj.id + '||' + obj.institutionName,
							name : obj.id
						};
					})
				};
			}
		}

	});*/

	//////////////// R LEVEL ////////////////////////////////////////////
/*	$(".r_level").select2({
		placeholder : "Niveau ...",
		ajax : {
			url : '/level/',
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

	});*/
	//////////////////

/*	$(".institution").change(function() {
		var institution = $(this).val();
		$.getJSON("/institutionDetail/" + institution + "", function(data) {
			dataform.institutionDetail.value = data;
		});
	});*/



});	

