
var _outstoreList = new Array();
$(function(){
	$('#outstore_add').click(function(){
		var outstoreItem = {
				code:$('#outstore_code').val(),
				name:$('#outstore_name').val(),
				count:$('#outstore_count').val(),
				price:$('#outstore_out_price').val()
		};
		_outstoreList.push(outstoreItem);
		showList();
	});
	
	var showList  = function(){
		var payCount=0;
		$('#outstore_list').html('');
		var table = $('<table>').addClass('pannel_list_table').appendTo('#outstore_list');
		var th = $('<tr>').appendTo(table);
		$('<th>').html('序号').appendTo(th);
		$('<th>').html('条码').appendTo(th);
		$('<th>').html('商品名称').appendTo(th);
		$('<th>').html('数量').appendTo(th);
		$('<th>').html('进价').appendTo(th);
//		$('<th>').html('入库时间').appendTo(th);
		$(_outstoreList).each(function(i,outstore){
			var tr = $('<tr>').appendTo(table);
			var count = $('<input size = 4>').val(outstore.count);
			$('<td>').html(i+1).appendTo(tr);
			$('<td>').html(outstore.code).appendTo(tr);
			$('<td>').html(outstore.name).appendTo(tr);
			$('<td>').html(count).appendTo(tr);
			$('<td>').html(outstore.price).appendTo(tr);
			payCount += outstore.count*outstore.price;
//			$('<td>').html(outstore.date).appendTo(tr);
		});
		$('#pay_count').html(payCount);
	};
	
	$('#outstore_save').click(function(){
		$.ajax({
			url: '../rest/commodity/saveOutstore',
			type: 'POST',
			dataType:"json",
			contentType:'application/json;charset=UTF-8',
			data: JSON.stringify({
				outstoreList:_outstoreList
			}),
			success: function(data){
				
			},
			error: function (){
				alert("失败！");
			}
		});
	});
	$('#pay_real').change(function(){
		$('#pay_back').html($(this).val()-$('#pay_count').html());
	});
});
