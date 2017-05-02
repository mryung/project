var jobId = "";

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
$(function() {
	$("#toptoolbar").ligerToolBar({
		items : [{
			text : '添加',
			icon : 'add',
			click : addJobWindow
		},{
			text : '修改',
			icon : 'edit',
			click : editJobWindow
		}]
	});
	$("#layout").ligerLayout({
		leftWidth : 200
	});
	grid = $("#maingrid").ligerGrid({
		height : '100%',
		columns : [ {
			display : '任务id',
			name : 'jobId',
			align : 'left',
			width : 50,
//			hide : true,
		}, {
			display : '任务名字',
			name : 'remark',
			width : 80,
			align : 'left',
			minWidth : 100
		}, {
			display : '控制器名字',
			name : 'beanName',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '方法名',
			name : 'methodName',
			width : 50,
			align : 'left',
			minWidth : 50
		}, {
			display : '方法参数',
			name : 'methodParams',
			width : 100,
			align : 'left',
			minWidth : 100
		},{
			display : '时间表达式',
			name : 'cronExpression',
			align : 'left',
			width : 100
		}, {
			display : '任务状态',
			name : 'status',
			width : 100,
			align : 'left',
			minWidth : 100,
			render:function(item){
				var flag = item.status;
				if(flag == 0){
					return "运行";
				}else{
					return "暂停";
				}
			}

		}, {
			display : '产生时间',
			name : 'createTime',
			width : 150,
			align : 'left',
			minWidth : 150,
			render:function(item){
				var date = new Date(item.createTime);
				return date.Format("yyyy-MM-dd hh:mm:ss");
			}
		} ],
		url : serverpath + "/task/list",
		jsonField : "pageInfo",
		dataAction : 'server',
		pageSize : 100,
		method : "POST",
		onDblClickRow : function(data, rowindex, rowobj) {
			jobId = data.jobId;
			editJobWindow();
		},
		onSelectRow : function(data, rowindex, rowobj) {
			jobId = data.jobId;
		},
		rownumbers : true
	});
	$("#sysmenu").each(function() {
		$(this).height($(this).parent().height() - $(this).prev().height());
	});
});
// 刷新列表
function refreshGrid() {
	grid.reload();
}
// 创建子窗口 用于修改或新增
function addJobWindow() {
	openWindow("");
}
function editJobWindow(){
	if (jobId == "") {
		$.ligerDialog.warn('请选择修改的job');
		return false;
	}
	openWindow(jobId);
}
//创建子窗口 用于修改或新增
function openWindow(jobId) {
	var url = serverpath + '/task/add'+
			"?jobId="+jobId;
	var title = "任务【新增】";
	if (jobId != "") {
		title = "任务【修改】";
	}
	$.ligerDialog.open({
		url : url,
		width : 600,
		height : 350,
		name : "iFrame",
		title : title,
		buttons : [ {
			text : '保存',
			onclick : function(item, dialog) {
				iFrame.submit();
			}
		}, {
			text : '取消',
			onclick : function(item, dialog) {
				dialog.close();
			}
		} ],
		modal : false,
		isResize : true
	});
}