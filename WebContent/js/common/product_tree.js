var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		$(document).ready(function(){			 	
			jQuery.ajax({
				url : "DictionaryTree",
				type:"POST",
				dataType:"json",
				contentType: "application/json; charset=utf-8", 
				success : function(data) {						
					$.fn.zTree.init($("#tree"), setting, data);
				}
			});
		});

		


function option(id,allow_edit,field_name){
	$.ajax({
		url:"OptionMgrListSearch.action",
		data:"field_id="+id+"&allow_edit="+allow_edit+"&field_name="+field_name,
		type:"POST",
		success:function(msg){						
			$("#span9").html($(msg).find("#span9").html());			
		}
	});
}

function field(code){	
	$.ajax({
		url:"DictionaryMgrListSearch.action",
		data:"product_code="+code,
		type:"POST",
		success:function(msg){			
			$("#span9").html($(msg).find("#span9").html());			
		}
	});
	
}