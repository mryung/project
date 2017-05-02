var pointId = "";

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
}

$(function() {
	$("#toptoolbar").ligerToolBar({
		items : [{
			text : '添加',
			icon : 'add',
			click : addJobWindow
		},{
			text : '修改',
			icon : 'edit',
			click : editPointWindow
		}]
	});
	$("#layout").ligerLayout({
		leftWidth : 200
	});
	grid = $("#maingrid").ligerGrid({
		height : '100%',
		columns : [ {
			display : '节点id',
			name : 'pointId',
			align : 'left',
			width : 50,
			hide : true,
		}, {
			display : '节点编号',
			name : 'pointCode',
			width : 80,
			align : 'left',
			minWidth : 100
		}, {
			display : '节点描述',
			name : 'pointDescription',
			width : 300,
			align : 'left',
			minWidth : 100
		}, {
			display : '节点抓取时间',
			name : 'pointTime',
			width : 150,
			align : 'left',
			minWidth : 50,
			render:function(item){
				var date = new Date(item.pointTime*1000);
				return date.Format("yyyy-MM-dd hh:mm:ss");
			}
		}, {
			display : '节点出错次数',
			name : 'pointError',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '是否有效',
			name : 'pointValid',
			width : 100,
			align : 'left',
			minWidth : 100,
			render:function(item){
				var flag = item.pointValid;
				if(flag == 0){
					return "无效";
				}else{
					return "有效";
				}
			}

		}],
		url : serverpath + "/point/list",
		jsonField : "pageInfo",
		dataAction : 'server',
		usePager : true,
		method : "POST",
		onDblClickRow : function(data, rowindex, rowobj) {
			pointId = data.pointId;
			editPointWindow();
		},
		onSelectRow : function(data, rowindex, rowobj) {
			pointId = data.pointId;
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
function editPointWindow(){
	if (pointId == "") {
		$.ligerDialog.warn('请选择修改的job');
		return false;
	}
	openWindow(pointId);
}
//创建子窗口 用于修改或新增
function openWindow(pointId) {
	var url = serverpath + '/point/add'+
			"?pointId="+pointId;
	var title = "节点【新增】";
	if (pointId != "") {
		title = "节点【修改】";
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