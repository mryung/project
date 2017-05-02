Highcharts.setOptions({
	global : {
		useUTC : false
	},
});
var dt = new Date();
var optionBld = {
	id : 'fixCt_blds',
	width : 600,
	height : 190,
	type : "pie",
	elementname : 'Build',// 请求展示楼层比列图
	categories : [ '一号楼', '二号楼', '三号楼', '四号楼', '五号楼', '六号楼' ],
	title : "楼栋当日用电监测",
	url: serverpath+"/build/currentBuild"
};
var optionCy = {
	id : 'fixCt_cy',
	width : 600,
	height : 190,
	type : "pie",
	elementname : 'System',// 请求展示楼层比列图 此图为系统的 使用System 请求
	categories : [ '照明插座', '空调', '变压器', '机房', '其他' ],
	title : "系统当日用电监测",
	url: serverpath+"/system/currentSystem"
}

function generateChart1(params){
	new Highcharts.Chart({
		title:{ //设置题目，默认居中
			text : params.title,
		},
		chart : {
			renderTo : params.id,
			type : params.type,
			width : params.width,
			height : params.height,
			borderWidth : 0,
			marginRight : 5
		},
		credits : { //设置版权
			text : "",
			href : null
		},
		xAxis : { //设置x坐标显示的东西
			categories : (params.categories ? params.categories : ""),
            crosshair: true
		},
		yAxis : { //Y轴显示东西
			lineWidth : 1,
			tickWidth : 1,
			title : {
				align : 'high',
				offset : 0,
				text : 'kWh',
				rotation : 0,
				y : -10
			},
			min : 0,
			plotLines : [ {
				value : 0,
				width : 1,
				color : '#808080'
			} ]
		},
		tooltip: {  //鼠标放上去显示的数据
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="padding:0"><b>{point.y:.1f} KWh</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				distance : 0.8,
				dataLabels : {
					enabled : true,
					color : '#a2a2a2',
					connectorColor : '#a2a2a2',
					formatter : function() {
						return '<b>' + this.point.name + '</b>: '
								+ this.point.y.toFixed(2) + ' %';
					}
				}
			},
		},
		series : (function() {
			var series = [];
			series[0] = {};
			$.ajax({
				url : params.url,
				cache : false,
				async : false,
				type: "POST",
				success : function(data) {
					series[0].data =data.detailData;
					$.each(series[0].data, function(i) {
						if (this < 0)
							series[0].data[i] = 0;
					})
					params.sumData = sum(series[0].data); // 计算整个柱状图的汇总数据
				}
			});
			if (params.type == "column") {
				series[0].name = "show";
				series[0].info = [];
				var info =  [{
		            name: '用电',
		            data: series[0].data
		        }];
			 return info;
				return series;
			}else{
				$.each(series[0].data, function(i) {
					series[0].data[i] = [ params.categories[i],
					                      (this / params.sumData) * 100 ];
				})
				return series
			}
		})()
	});
}

function sum(arr) {
	var sum = 0;
	$.each(arr, function() {
		sum += this;
	});
	return sum;
}

// 展示右侧上方比例图
function generateSmallChart(ctParms) {
	var small_chart = new Highcharts.Chart({
		chart : {
			renderTo : ctParms.id,
			defaultSeriesType : 'pie',
			width : 400,
			height : 250,
			borderWidth : 0,
			marginRight : 5
		},
		color : [ '#FFFF00' ],
		credits : {
			text : "",
			href : null
		},
		title : {
			text : ctParms.title
		},
		tooltip : {
			formatter : function() {
				return this.point.name + ':<br/>' + this.y.toFixed(4) + '%';
			}

		},
		legend : {
			layout : 'horizontal',
			verticalAlign : 'bottom',
			margin : 10,
			borderWidth : 0,
			enabled : true
		},
		exporting : {
			enabled : false
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				dataLabels : {
					enabled : true,
					color : '#a2a2a2',
					connectorColor : '#a2a2a2',
					connectorWidth : 0,
					distance : 10,
					y : 3,
					formatter : function() {
						if (this.y == 0)
							return '';
						return '<b>' + this.point.name + '</b>: '
								+ this.y.toFixed(2) + ' %';
					}
				}
			}
		},
		series : (function() {
			var series = [];
			series[0] = {};
			series[0].data = [];
			var ratess = (ctParms.cuData / ctParms.sum).toFixed(4) * 100;
			var otherRatess = 100 - ratess;
			series[0].data[0] = [ ctParms.name, ratess ];
			series[0].data[1] = [ "其他", otherRatess ];
			series[0].data[2] = [ '', 0 ];// 由于highcharts Bug的因素这里添加了一个虚假的分类
											// 使其可以展现比例图的Label;
			return series
		})()
	});
}

function DetailPie(ctParms) {
	var small_chart = new Highcharts.Chart({
		chart : {
			renderTo : ctParms.id,
			defaultSeriesType : 'pie',// 默认图表类型
			width : 400,
			height : 250,
			borderWidth : 0,
			marginRight : 5
		},
		color : [ '#FFFF00' ],
		credits : {
			text : "",
			href : null
		},
		title : {
			text : ctParms.title
		},
		tooltip : {
			formatter : function() {
				return this.point.name + ':<br/>' + this.y.toFixed(2) + '%';
			}

		},
		legend : {
			layout : 'horizontal',
			verticalAlign : 'bottom',
			margin : 10,
			borderWidth : 0,
			enabled : true
		},
		exporting : {
			enabled : false
		},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				dataLabels : {
					enabled : true,
					color : '#a2a2a2',
					connectorColor : '#a2a2a2',
					connectorWidth : 0,
					distance : 0,
					y : 3,
					formatter : function() {
						if (this.point.name == "")
							return ""
						return '<b>' + this.point.name + '</b>: '
								+ this.y.toFixed(2) + ' %';
					}
				}
			}
		},
		series : (function() {
			var sumData = sum(ctParms.detailData);
			var series = [];
			series[0] = {};
			var data = [];
			$.each(ctParms.detailData, function(i) {
				data.push({
					name : ctParms.kinds[i],
					y : (this / sumData) * 100
				});
			});
			data.push({
				name : "",
				y : 0
			}); // 由于highcharts Bug的因素这里添加了一个虚假的分类 使其可以展现比例图的Label;
			series[0].data = data;
			return series
		})()
	});
}