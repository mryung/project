//title year month week ,day,filename,elementname

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
            lineWidth: 1,
            tickWidth: 1,
            title: {
                align: 'high',
                offset: 0,
                text: (function () {
                    if (ctParms.option == '日')
                        return "<I>kWh</I><span id=high >峰</span><span id=usual >平</span><span id=low >谷</span>"
                    return '<I>kWh</I>';
                })(),
                rotation: 0,
                y: -20,
                margin: (function () {
                    if (ctParms.option == '日')
                        return -130;
                    return -20;
                })()
            },
            min: 0,
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                generateSmallChart({
                    id: 'chartContainer_small',
                    sum: sumData,
                    name: this.point.name,
                    title: ctParms.option + "用电量统计",
                    cuData: this.y
                });
                return this.point.name + ' :<br/>' + this.y.toFixed(2); ;
            }
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
                                var title, month, mydata, id, option, week, day, year;
                                var categories = [];
                                title = ctParms.title;
                                year = ctParms.year;
                                month = ctParms.month;
                                week = ctParms.week;
                                day = ctParms.day;
                                id = ctParms.id;
                                option = ctParms.option;
                                if (option == '日')
                                    return;
                                if(option == '总'){
                             //   $('#ner1').show();
                                $('#chartContainer1').data("isExists", true);
                                    showd('chartContainer1');//展示'年'和年的图表包容DIV
                                    option = '年';
                                    month=0;
                                    title = title.replace("统计数据", '');
                                    title += "期间"+e.point.name + '年统计数据';//修改标题参数
                                    year=e.point.name.substr(0,4);
                                    id = 'chartContainer1';
                                    $.ajax({
                                        url: 'Date.ashx',
                                        data: {
                                            year: year,
                                            month: month,
                                            week: week
                                        },
                                        cache: false,
                                        async: false,
                                        success: function (data) {
                                            mydata = eval('(' + data + ')');
                                            $.each(mydata, function (i) {
                                                categories[i] = i+1+'月';
                                            });
                                        }
                                    });
                                }
                                else if (option == '年') {//判别求时间请求类型
                                    //if (new Date().getMonth() + 1 < parseInt(e.point.name[0]))//如果选择月大于当前月则返回
                                    //   return;
                                   //     $('#ner2').show();
                                    $('#chartContainer2').data("isExists", true);
                                    showd('chartContainer2');//展示'年'和年的图表包容DIV
                                    option = '月';
                                    title = title.replace("统计数据", '');
                                    title += e.point.name + '统计数据';//修改标题参数
                                    if(e.point.name[1]=='0')
                                        month = e.point.name[0]+'0';
                                    else if(e.point.name[1]=='1')
                                        month = e.point.name[0]+'1';
                                    else if(e.point.name[1]=='2')
                                        month = e.point.name[0]+'2';
                                    else
                                        month = e.point.name[0];
                                    id = "chartContainer2";//传递包容的div id
                                    $.ajax({
                                        url: 'Date.ashx',//请求展示时间段 ，用于生成categories
                                        data: {
                                            year: year,
                                            month: month,
                                            week: week
                                        },
                                        cache: false,//不缓存
                                        async: false,//同步
                                        success: function (data) {
                                            mydata = eval('(' + data + ')');
                                            $.each(mydata, function (i) {
                                                var bdt=new Date(new Date(this * 1000));                                              
                                                var adt=new Date(this * 1000 + 7 * 60 * 60 * 24 * 1000);   //生成最后展示的categories
                                                var _month;
                                                var _day;
                                                var _year
                                                if(adt.getDate()==1)
                                                    {_month=adt.getMonth()-1;
                                                switch(_month)
                                                {
                                                case 0:
                                                    _day=31;
                                                    break;
                                                case 1:
                                                    if(_year%4==0)
                                                        _day=29;
                                                    else
                                                        _day=28;
                                                    break;
                                                case 2:
                                                    _day=31;
                                                    break;
                                                case 3:
                                                    _day=30;
                                                    break;
                                                case 4:
                                                    _day=31;
                                                    break;
                                                case 5:
                                                    _day=30;
                                                    break;
                                                case 6:
                                                    _day=31;
                                                    break;
                                                case 7:
                                                    _day=31;
                                                    break;
                                                case 8:
                                                    _day=30;
                                                    break;
                                                case 9:
                                                    _day=31;
                                                    break;
                                                case 10:
                                                    _day=30;
                                                    break;
                                                case 11:
                                                    _day=31;
                                                    break;
                                                }
                                                categories[i] = (i + 1) + '周' + '<br/>'+(bdt.getMonth()+1)+'月' + bdt.getDate() + '号'+'-'+(adt.getMonth())+"月" + _day+'号'+ '<br/>';
                                                }
                                                else
                                                categories[i] = (i + 1) + '周' + '<br/>'+(bdt.getMonth()+1)+'月' + bdt.getDate() + '号'+'-'+(adt.getMonth()+1)+"月" + (adt.getDate()-1)+'号'+ '<br/>';
                                            });
                                        }
                                    });
                                }
                                else if (option == '月') {
                               // $('#ner3').show();
                                    option = '周';
                                    $('#chartContainer3').data("isExists", true);
                                    showd('chartContainer3');
                                    title = title.replace("统计数据", '');
                                    title += e.point.name[0] + '周统计数据';
                                    week = e.point.name[0];
                                    id = 'chartContainer3';
                                    $.ajax({
                                        url: 'Date.ashx',
                                        data: {
                                            year: year,
                                            month: month,
                                            week: week
                                        },
                                        cache: false,
                                        async: false,
                                        success: function (data) {
                                            mydata = eval('(' + data + ')');
                                            $.each(mydata, function (i) {
                                                categories[i] = '星期' + numToCh(i + 1) + '<br/>' + ((new Date(this * 1000)).getMonth() + 1) + '月' + (new Date(this * 1000)).getDate();
                                            });
                                        }
                                    });
                                }
                                else if (option == '周') {
                              //  $('#ner4').show();
                                    $('#chartContainer4').data("isExists", true);
                                    showd('chartContainer4');
                                    id = 'chartContainer4';
                                    option = '日';
                                    title = title.replace("统计数据", '');
                                    title += e.point.name + '日统计数据';
                                    day = chToNum( e.point.name[2]);
                                    for (var i = 0; i < 24; i++)
                                        categories[i] = (i + 1)
                                }
                                ClassChart({
                                    id: id,
                                    type: ctParms.type,
                                    width: ctParms.width,
                                    height: ctParms.height,
                                    year: year,
                                    month: month,
                                    week: week,
                                    day: day,
                                    elementname: ctParms.elementname,
                                    calenum:ctParms.calenum,                             
                                    kinds: ctParms.kinds,
                                    title: title,
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
                url: 'Build.ashx',//请求生成图表的数据 柱状图 详细比例图
                data: {
                    year: ctParms.year,
                    month: ctParms.month,
                    week: ctParms.week,
                    day: ctParms.day,                 
                    elementname: ctParms.elementname,//元素名称 
                    calenum:ctParms.calenum,//CalculatorEnum
                },
                cache: false,
                async: false,
                success: function (data) {
                    var multi = eval('(' + data + ')');
                    $.each(multi.TimeData, function (i) { if (multi.TimeData[i] < 0) multi.TimeData[i] = 0 });//修正负数数据
                    $.each(multi.DetailData, function (i) { if (multi.DetailData[i] < 0) multi.DetailData[i] = 0 });//同上
                    mydata = multi.TimeData;
                    DetailPie({
                        id: ctParms.id+'Right',
                        detailData: multi.DetailData,//采用详细数据
                        kinds: ctParms.kinds,
                        title: ctParms.option + '用电量统计'
                    });



                }
            })
            var pt = /号楼/g;

            if (mydata.length == 24) {
                $.each(mydata, function (d) {
                    var i = d + 1;//不同的时间段用不同颜色柱子展示
                    if ((i > 7 && i <= 11) || (i > 19 && i <= 23)) {
                        series[0].data.push({
                            name: '峰<br/>' + i + ":00 ",
                            color: "Red",
                            y: this
                        });
                    } else if (i > 23 || i <= 7) {
                        series[0].data.push({
                            name: '谷<br/>' + i + ":00 ",
                            color: "#00C957",
                            y: this
                        });
                    }
                    else if (i > 11 && i <= 19) {
                        series[0].data.push({
                            name: '平<br/>' + i + ":00 ",
                            color: "Yellow",
                            y: this
                        });

                    }
                });
            }
            else {
//                var divde = 0;
//                var pteng=/[^a-z][^a-z号]/;//正则表达式判断具有无英文  无号 为系统
//                var bld = pt.test(ctParms.elementname);
//                var sys = pteng.test(ctParms.elementname);
//                if (bld)
//                    divde = 6;
//                if (sys)
//                    divde = 5;
//               var mh =new Date().getMonth();
//               var fullYear=new Date().getFullYear();
//               //对非整个园区取平均 并将非GE数据库数据展示为虚柱子
//               var Hisdata=[265320,313920,273680,257760,322360,365800,505280,599600,190339,261338,231335,318600];
                $.each(mydata, function (i) {  
                                 series[0].data[i] = {
                                name: ctParms.categories[i],
                                color: "Yellow",
                                y: this
                            };              
//                    if (mydata.length == 12) {
//                        if (i<2 || i>mh) {
//                            if (bld || sys) {
//                                series[0].data[i] = {
//                                    name: ctParms.categories[i],
//                                    color: "#FAFAD2",
//                                    y: Hisdata[i] / divde
//                                };
//                            }
//                            else {

//                                series[0].data[i] = {
//                                    name: ctParms.categories[i],
//                                    color: "#FAFAD2",
//                                    y: Hisdata[i]
//                                };
//                            }
//                        }
//                        else {
//                            series[0].data[i] = {
//                                name: ctParms.categories[i],
//                                color: "Yellow",
//                                y: this
//                            };
//                        }
//                    }
//                    else {
//                        series[0].data[i] = {
//                            name: ctParms.categories[i],
//                            color: "Yellow",
//                            y: this
//                        };
//                    }
                });
            }
            $.each(series[0].data, function () {
                sumData += this.y;
            });
            return series;

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