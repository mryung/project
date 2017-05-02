<script type="text/javascript" src="${rc.contextPath}/resource/Scripts/generateChart.js"></script>
<script type="text/javascript" src="${rc.contextPath}/resource/Scripts/ClassChart.js"></script>
<script type="text/javascript">
						var scopeBigChart = [];
						$(document)
								.ready(
										function() {
											generateChart(optionBld);
											generateChart(optionCy);
											$('#container').hide();
											$('.page').hide();
											showd('chartContainer');
											$("#hd_menu")
													.children("ul")
													.append(
															" <li><a href='#' class='mapTog'>地图收起</a></li>");
											$('.mapTog')
													.click(
															function(e) {
																var pattern = /[收]/g;
																if (pattern
																		.test(e.target.innerText)) {
																	e.target.innerText = "地图展开";
																} else {
																	e.target.innerText = "地图收起";
																}
																$('#emap').toggle;
															});
											$('.bld')
													.click(
															function(e) {
																var chart = new ClassChart(
																		{
																			year : 2012,
																			month : 0,
																			week : 0,
																			day : 0,
																			elementname : e.target.id, //请求展示楼层比列图
																			calenum : '1',
																			width : 800,
																			height : 600,
																			type : 'column',
																			id : 'chartContainer',
																			title : this.id
																					+ '2012年',
																			option : '年',
																			kinds : [
																					'一号楼',
																					'二号楼',
																					'三号楼',
																					'四号楼',
																					'五号楼',
																					'六号楼' ],
																			categories : [
																					'1月',
																					'2月',
																					'3月',
																					'4月',
																					'5月',
																					'6月',
																					'7月',
																					'8月',
																					'9月',
																					'10月',
																					'11月',
																					'12月' ]
																		});
																$('#container')
																		.show();
																$('#ner')
																		.show();
																$(
																		'#chartContainer')
																		.data(
																				'isExists',
																				true);
															});
											$("#ct_close")
													.click(
															function(e) {
																e
																		.preventDefault();
																$(
																		'#chartContainer')
																		.data(
																				"isExists",
																				false);
																for (var i = 1; i < 4; i++)
																	$(
																			'#chartContainer'
																					+ i)
																			.data(
																					"isExists",
																					false);
																showd('chartContainer');
																$("#container")
																		.hide();
																$('.page')
																		.hide();
																$
																		.each(
																				scopeBigChart,
																				function() {
																					//this.destory();
																				});
															});
											$("#fixCt_bldsZoom")
													.click(
															function(e) {
																e
																		.stopPropagation();
																$('#container')
																		.show();
																var chart = new ClassChart(
																		{
																			year : 2012,
																			month : 0,
																			week : 0,
																			day : 0,
																			elementname : 'Build', //请求展示楼层比列图
																			calenum : '0',
																			width : 800,
																			height : 600,
																			type : 'column',
																			id : 'chartContainer',
																			title : '园区'
																					+ '2012年',
																			option : '年',
																			kinds : [
																					'一号楼',
																					'二号楼',
																					'三号楼',
																					'四号楼',
																					'五号楼',
																					'六号楼' ],
																			categories : [
																					'1月',
																					'2月',
																					'3月',
																					'4月',
																					'5月',
																					'6月',
																					'7月',
																					'8月',
																					'9月',
																					'10月',
																					'11月',
																					'12月' ]
																		});
																$('#ner')
																		.show();
																$(
																		'#chartContainer')
																		.data(
																				'isExists',
																				true);
															});
											$("#fixCt_cyZoom")
													.click(
															function(e) {
																e
																		.stopPropagation();
																$('#container')
																		.show();
																var chart = new ClassChart(
																		{
																			year : 2012,
																			month : 0,
																			week : 0,
																			day : 0,
																			elementname : 'System', //请求展示楼层比列图
																			calenum : '0',
																			width : 800,
																			height : 600,
																			type : 'column',
																			id : 'chartContainer',
																			title : '园区'
																					+ '2012年',
																			option : '年',
																			kinds : [
																					'照明插座',
																					'空调',
																					'变压器',
																					'机房',
																					'其他' ],
																			categories : [
																					'1月',
																					'2月',
																					'3月',
																					'4月',
																					'5月',
																					'6月',
																					'7月',
																					'8月',
																					'9月',
																					'10月',
																					'11月',
																					'12月' ]
																		});
																$('#ner')
																		.show();
																$(
																		'#chartContainer')
																		.data(
																				'isExists',
																				true);
															});

											$("#fixCt_bldsTog")
													.click(
															function(e) {
																e
																		.preventDefault();
																if (optionBld.type == "pie") {
																	optionBld.type = 'column';
																	generateChart(optionBld)
																} else {
																	optionBld.type = "pie";
																	generateChart(optionBld);
																}
															});
											$('.page')
													.click(
															function(e) {
																e
																		.preventDefault();
																if ($(
																		'#chartContai'
																				+ this.id)
																		.data(
																				"isExists") === true) {
																	showd('chartContai'
																			+ this.id);
																}
															})
											$("#fixCt_cyTog")
													.click(
															function(e) {
																e
																		.preventDefault();
																if (optionCy.type == "pie") {
																	optionCy.type = 'column';
																	generateChart(optionCy);
																} else {
																	optionCy.type = "pie";
																	generateChart(optionCy);
																}
															});
										});
					</script>
