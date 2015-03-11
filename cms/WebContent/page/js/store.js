$(function(){
	var param = {};
	$.ajax({
		url: '../rest/commodity/getStore',
		type: 'POST',
		dataType:"json",
		contentType:'application/json;charset=UTF-8',
		data: JSON.stringify(param),
		success: function(data){
			$('#store_list').html('');
			var table = $('<table>').addClass('pannel_list_table').appendTo('#store_list');
			var th = $('<tr>').appendTo(table);
			$('<th>').html('序号').appendTo(th);
			$('<th>').html('条码').appendTo(th);
			$('<th>').html('商品名称').appendTo(th);
			$('<th>').html('数量').appendTo(th);
			$('<th>').html('进价').appendTo(th);
			$('<th>').html('售价').appendTo(th);
			$('<th>').html('生产商').appendTo(th);
			$('<th>').html('保质期').appendTo(th);
//			$('<th>').html('入库时间').appendTo(th);
			$(data).each(function(i,store){
				var tr = $('<tr>').appendTo(table);
				$('<td>').html(i+1).appendTo(tr);
				$('<td>').html(store.code).appendTo(tr);
				$('<td>').html(store.commodity.name).appendTo(tr);
				$('<td>').html(store.count).appendTo(tr);
				$('<td>').html(store.commodity.inPrice).appendTo(tr);
				$('<td>').html(store.commodity.outPrice).appendTo(tr);
				$('<td>').html(store.commodity.productor).appendTo(tr);
				$('<td>').html(store.commodity.qualityDay+"天").appendTo(tr);
//				$('<td>').html(instore.date).appendTo(tr);
			});
		},
		error: function (){
			alert("失败！");
		}
	});
});