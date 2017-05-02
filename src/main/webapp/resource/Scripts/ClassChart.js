//title year month week ,day,filename,elementname

var clickyear;
var clickmonth;
var clickweek;
var clickday;

function showd(id) {
    $('#'+id.replace('chartContai','')).show();
    $('.same').hide();
    $('.sameRight').hide();
	$('#'+id+'Right').show();
    $('#' + id).show();      
}
function ClassChart(ctParms) {
    var sumData=0;
    var jump_chart = new Highcharts.Chart({
        chart: {
            renderTo: ctParms.id,
            defaultSeriesType: ctParms.type,
            width: ctParms.width,
            height: ctParms.height,
            borderWidth: 0,
            marginRight: 5
        },
        color: ['#FFFF00'],
        credits: {
            text: "",
            href: null
        },
        title: {
            text: ctParms.title,
            margin: 30
        },
        xAxis: {
            categories: ctParms.categories
        },
        yAxis: {
            title: {
                align: 'high',
                offset: 0,
                text: (function () {
                    if (ctParms.option == '日')
                        return "<I>kWh</I><span id=high >峰</span><span id=usual >平</span><span id=low >谷</span>"
                    return '<I>kWh</I>';
                })(),
                margin: (function () {
                    if (ctParms.option == '日')
                        return -130;
                    return -20;
                })()
            },
        },
        tooltip: {
            formatter: function () {
                generateSmallChart({
                    id: 'chartContainer_small',
                    sum: sumData,
                    name: this.x,
                    title: ctParms.option + "用电量统计",
                    cuData: this.y
                });
                return this.x + ' :<br/>' + this.y.toFixed(2); ;
            },
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#a2a2a2',
                    connectorColor: '#a2a2a2',
                    formatter: function () {
                        return '<b>' + this.point.name + '</b>: ' + this.point.y.toFixed(2) + ' %';
                    }
                }
            },
            column:
                {
                    events:
                        {
                            click: function myfunction(e) {
                                var title, month, mydata, id, option;
                                var data,url;
                                var categories = [];
                                title = ctParms.title;
                                option = ctParms.option;
                                if (option == '日')
                                    return;
                                if(option == '总'){ //得到选择的年
                                	clickyear = e.point.category;
                                	option = '年';
                                	
                                	id = 'chartContainer1';
                                	$('#chartContainer1').data("isExists", true);
                                    showd('chartContainer1');//展示'年'和年的图表包容DIV
                                    
                                    if(title.indexOf('号楼')!=-1)
                                    {
	                                    title=title.substr(0,2);
	                                    title+='楼'+e.point.category+'年统计数据';
                                    }
                                    else{
                                    	title = clickyear + '年统计数据';//修改标题参数
                                    }
                                    data = {
                                        year: clickyear,
                                        elementname: ctParms.data.elementname
                                    },
                                    url = serverpath+"/"+ctParms.controller+"/"+ctParms.controller+"Year";
//                                    url = serverpath+'/build/buildYear';
                                    $.ajax({
                                        url: serverpath+'/month', //得到月份
                                        type:"POST",
                                        data: data,
                                        cache: false,
                                        async: false,
                                        success: function (data) {
                                            mydata = data.month;
                                            $.each(mydata, function (i) {
                                                categories[i] = i+1+'月';
                                            });
                                        }
                                    });
                                }
                                else if (option == '年') {   //判别求时间请求类型   选择到月， 得到周的
                                	option = '月';
                                	id = "chartContainer2";//传递包容的div id
                                    $('#chartContainer2').data("isExists", true);
                                    showd('chartContainer2');//展示'年'和年的图表包容DIV
                                    clickmonth = e.point.x+1
                                    title = title.replace("统计数据", '');
                                    title += clickmonth + '月统计数据';//修改标题参数
                                    url = serverpath+"/"+ctParms.controller+"/"+ctParms.controller+"Month";
                                    data = {
                                            year: clickyear,
                                            month: clickmonth,
                                            elementname: ctParms.data.elementname
                                        };
                                    $.ajax({
                                        url: serverpath+'/week',//请求展示时间段 ，用于生成categories
                                        type: "post",
                                        data: data,
                                        cache: false,//不缓存
                                        async: false,//同步
                                        success: function (data) {
                                            mydata = data.week;
                                            var day = 1;
                                            for(var i = 0; i < mydata.length;i++){
                                            	var start = new Date(mydata[i].startTime * 1000);
                                            	var end = new Date(mydata[i].endTime * 1000 - 86400000);
                                        		categories[i] = (i + 1) + '周' 
                                        		+ '<br/>'+(start.getMonth()+1)+'月' + start.getDate() + '号'+'-'+(end.getMonth()+1)+"月"+ end.getDate() +'号'+ '<br/>';
                                            }
                                        }
                                    });
                                }
                                else if (option == '月') {
                                	clickweek = e.point.x + 1;
                                	id = 'chartContainer3';
                                    option = '周';
                                    $('#chartContainer3').data("isExists", true);
                                    showd('chartContainer3');

                                    title = title.replace("统计数据", '');
                                    title += clickweek + '周统计数据';
                                    url = serverpath+"/"+ctParms.controller+"/"+ctParms.controller+"Week";
                                    data = {
                                            year: clickyear,
                                            month: clickmonth,
                                            week: clickweek,
                                            elementname: ctParms.data.elementname
                                        };
                                    
                                    $.ajax({
                                        url: serverpath+'/day',
                                        data: data,
                                        type: "POST",
                                        cache: false,
                                        async: false,
                                        success: function (data) {
                                            mydata =data.day;
                                            $.each(mydata, function (i) {
                                            	var weekday=new Array(7)
                                            	weekday[0]="星期天";
                                            	weekday[1]="星期一";
                                            	weekday[2]="星期二";
                                            	weekday[3]="星期三";
                                            	weekday[4]="星期四";
                                            	weekday[5]="星期五";
                                            	weekday[6]="星期六";
                                            	var date = new Date(this.startTime * 1000);
                                                categories[i] = weekday[date.getDay()] + '<br/>' + (date.getMonth() + 1) + '月' + date.getDate()+'号';
                                            });
                                        }
                                    });
                                }
                                else if (option == '周') {
                                	mydata = [0,1];
                                	id = 'chartContainer4';
                                	clickday = e.point.x;
                                    $('#chartContainer4').data("isExists", true);
                                    showd('chartContainer4');
                                    option = '日';
                                    url = serverpath+"/"+ctParms.controller+"/"+ctParms.controller+"Day";
                                    data = {
                                            year: clickyear,
                                            month: clickmonth,
                                            week: clickweek,
                                            day: clickday,
                                            elementname: ctParms.data.elementname
                                        };
                                    title = title.replace("统计数据", '');
                                    title += "<br>"+ e.point.category + '日统计数据';
                                    for (var i = 0; i < 24; i++)
                                        categories[i] = (i + 1)
                                }
                                ClassChart({
                                    id: id,
                                    type: ctParms.type,
                                    width: ctParms.width,
                                    height: ctParms.height,
                                    elementname: ctParms.elementname,
                                    calenum:ctParms.calenum, 
                                    controller: ctParms.controller,
                                    kinds: ctParms.kinds,
                                    title: title,
                                    data: data,
                                    url : url,
                                    categories: categories,
                                    option: option
                                });
                            }
                        }
                }


        },
        series: (function () {
            var series = [];
            series[0] = {};
            series[0].data = [];//初始化series 为数组
            var mydata;
            $.ajax({
                url: ctParms.url,//请求生成图表的数据 柱状图 详细比例图
                data: ctParms.data,
                cache: false,
                async: false,
                type: "POST",
                success: function (data) {
                    var multi = data
                    $.each(multi.timeData, function (i) { if (multi.timeData[i] < 0) multi.timeData[i] = 0 });//修正负数数据
                    $.each(multi.detailData, function (i) { if (multi.detailData[i] < 0) multi.detailData[i] = 0 });//同上
                    mydata = multi.timeData;
                    DetailPie({
                        id: ctParms.id+'Right',
                        detailData: multi.detailData,//采用详细数据
                        kinds: ctParms.kinds,
                        title: ctParms.option + '用电量统计'
                    });
                }
            });
            var pt = /号楼/g;
            $.each(mydata, function (i) {
            	sumData += this;
            });
            var info =  [{
	            name: '用电',
	            data: (function(){
	            	if(ctParms.option == "总"){
	            		return mydata.reverse();
	            	}else{
	            		return mydata;
	            	}
	            })(),
	            ctParms:ctParms.categories
	        }];
        	return info
        })()
    });
    
    scopeBigChart.push(jump_chart);
}



function chToNum(str)
{
  switch(str){
      case "一":return 1;
      case "二":return 2;
      case "三": return 3;
      case "四": return 4;
      case "五": return 5;
      case "六": return 6;
      case "日":return 7
   }
}
function numToCh(no) {
    switch (no) {
        case 1: return "一";
        case 2: return "二";
        case 3: return "三";
        case 4: return "四";
        case 5: return "五";
        case 6: return "六";
        case 7: return "日";
    }
}