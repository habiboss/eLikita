/**
 * 
 */

$(document).ready(function() {
	//alert("s");
	
	$(".classTypeFk").select2({
		placeholder : "Type ...",
		ajax : {
			url : '/ClassType/',
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
							text : obj.id + '||' + obj.name,
							name : obj.id
						};
					})
				};
			}
		}

	});

	
});

