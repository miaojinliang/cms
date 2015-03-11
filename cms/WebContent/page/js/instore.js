
var _instoreList = new Array();
$(function(){
	$('#insotre_add').click(function(){
		var instoreItem = {
				code:$('#instore_code').val(),
				name:$('#instore_name').val(),
				count:$('#instore_count').val(),
				price:$('#instore_in_price').val()
		};
		_instoreList.push(instoreItem);
//		console.log(_instoreList);
		showList();
	});
	
	var showList  = function(){
		$('#instore_list').html('');
		var table = $('<table>').addClass('pannel_list_table').appendTo('#instore_list');
		var th = $('<tr>').appendTo(table);
		$('<th>').html('序号').appendTo(th);
		$('<th>').html('条码').appendTo(th);
		$('<th>').html('商品名称').appendTo(th);
		$('<th>').html('数量').appendTo(th);
		$('<th>').html('进价').appendTo(th);
//		$('<th>').html('入库时间').appendTo(th);
		$(_instoreList).each(function(i,instore){
			var tr = $('<tr>').appendTo(table);
			$('<td>').html(i+1).appendTo(tr);
			$('<td>').html(instore.code).appendTo(tr);
			$('<td>').html(instore.name).appendTo(tr);
			$('<td>').html(instore.count).appendTo(tr);
			$('<td>').html(instore.price).appendTo(tr);
//			$('<td>').html(instore.date).appendTo(tr);
		});
	};
	
	$('#instore_save').click(function(){
		$.ajax({
			url: '../rest/commodity/saveInstore',
			type: 'POST',
			dataType:"json",
			contentType:'application/json;charset=UTF-8',
			data: JSON.stringify({
				instoreList:_instoreList
			}),
			success: function(data){
				
			},
			error: function (){
				alert("失败！");
			}
		});
	});
});