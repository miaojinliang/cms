$(function(){
	$('#save').click(function(){
		var commodity = {
				code:$('#commodity_code').val(),
				name:$('#commodity_name').val(),
				inPrice:$('#commodity_in_price').val(),
				outPrice:$('#commodity_out_price').val(),
				productor:$('#commodity_productor').val(),
				qualityDay:$('#commodity_quality_day').val()
		}
		$.ajax({
			url: '../rest/commodity/insert',
			type: 'POST',
			dataType:"json",
			contentType:'application/json;charset=UTF-8',
			data: JSON.stringify(commodity),
			success: function(data){
				getCommodities();
			},
			error: function (){
				alert("失败！");
			}
		});
	});
	
//	commodity_list
	var _com_list_div = $('#commodity_list');
	var getCommodities = function(){
		$('#commodity_list').html('');
		var params = {
//				conditions: [{
//					name: 'channelcode',
//					logic: 'IN',
//					values: channelcodes
//				}],
//				relation: 'AND',
//				orderBy: [{
//					name: 'channelcode',
//					order: 'ASC'
//				}],
//				start: (pageNo-1) * pageSize,
//				limit: pageSize
			};
		$.ajax({
			url: '../rest/commodity/getCommodities',
			type: 'POST',
			dataType:"json",
			contentType:'application/json;charset=UTF-8',
			data: JSON.stringify(params),
			success: function(data){
				var table = $('<table>').addClass('pannel_list_table').appendTo('#commodity_list');
				var th = $('<tr>').appendTo(table);
				$('<th>').html('序号').appendTo(th);
				$('<th>').html('条码').appendTo(th);
				$('<th>').html('商品名称').appendTo(th);
				$('<th>').html('进价').appendTo(th);
				$('<th>').html('售价').appendTo(th);
				$('<th>').html('制造商').appendTo(th);
				$('<th>').html('保质期').appendTo(th);
				$(data).each(function(i,commodity){
					var tr = $('<tr>').appendTo(table);
					$('<td>').html(i+1).appendTo(tr);
					$('<td>').html(commodity.code).appendTo(tr);
					$('<td>').html(commodity.name).appendTo(tr);
					$('<td>').html(commodity.inPrice).appendTo(tr);
					$('<td>').html(commodity.outPrice).appendTo(tr);
					$('<td>').html(commodity.productor).appendTo(tr);
					$('<td>').html(commodity.qualityDay).appendTo(tr);
				});
			},
			error: function (){
				alert("失败！");
			}
		});
	};
	getCommodities();
});