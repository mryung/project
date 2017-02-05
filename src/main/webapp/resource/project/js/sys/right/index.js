var rightid = "";
var usrId = "";
var dptId = "";
var orgId = "";
var tree = null;
$(function() {
	$("#toptoolbar").ligerToolBar({
		items : [ {
			text : '新增',
			icon : 'add',
			click : addUserWindow
		}, {
			line : true
		}, {
			text : '修改',
			icon : 'edit',
			click : editUserWindow
		}, {
			line : true
		}, {
			text : '查询',
			icon : 'search',
			click : serachUser
		}, {
			line : true
		}]
	});
	$("#layout").ligerLayout({
		leftWidth : 200
	});
	tree = $("#tree").ligerTree({
		url : serverpath + "/sys/right/tree",
		ajaxType : "POST",
		jsonField : "tree",
		idFieldName : 'rightId',
		textFieldName: 'rightName',
		parentIDFieldName : 'rightParentId',
		slide : true,
		checkbox : false,
		onClick : function(note) {
			rightid=note.data.rightId;
			refreshGrid();
		},
		nodeWidth : 200
	});
	grid = $("#maingrid").ligerGrid({
		height : '100%',
		columns : [ {
			display : '权限编号',
			name : 'rightId',
			align : 'left',
			width : 50,
//			hide : true,
		}, {
			display : '权限名字',
			name : 'rightName',
			width : 80,
			align : 'left',
			minWidth : 100
		}, {
			display : '权限url',
			name : 'rightUrl',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '父权限id',
			name : 'rightParentId',
			width : 50,
			align : 'left',
			minWidth : 50
		}, {
			display : '权限父路径',
			name : 'rightParents',
			width : 100,
			align : 'left',
			minWidth : 100
		},{
			display : '权限描述',
			name : 'rightDescription',
			align : 'left',
			width : 100
		}, {
			display : '权限编码',
			name : 'rightCode',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '排序编号',
			name : 'sorted',
			width : 50,
			align : 'left',
			minWidth : 50
		}, {
			display : '是否显示',
			name : 'isShow',
			width : 50,
			align : 'left',
			minWidth : 50,
			render:function(item){
				var flag = item.isShow;
				if(flag == 0){
					return "不显示";
				}else{
					return "显示";
				}
			}
		}, {
			display : '是否有效',
			name : 'available',
			width : 50,
			align : 'left',
			minWidth : 50,
			render:function(item){
				var flag = item.available;
				if(flag == 0){
					return "无效";
				}else{
					return "有效";
				}
			}
		} ],
		url : serverpath + "/sys/right/data",
		jsonField : "pageInfo",
		dataAction : 'server',
		pageSize : 100,
		method : "POST",
		onDblClickRow : function(data, rowindex, rowobj) {
			usrId = data.usrid;
			dptId = data.usrdept;
			orgId = data.usrorgan;
			editUserWindow();
		},
		onSelectRow : function(data, rowindex, rowobj) {
			usrId = data.usrid;
			dptId = data.usrdept;
			orgId = data.usrorgan;
		},
		rownumbers : true
	});
	$("#sysmenu").each(function() {
		$(this).height($(this).parent().height() - $(this).prev().height());
	});
});
// 刷新树
function refreshTree() {
	tree.reload();
}
// 刷新列表
function refreshGrid() {
	if(rightid != ''||rightid != null){
		grid.setParm("rightid", rightid);
	}
	grid.reload();
}
// 创建子窗口 用于修改或新增
function addUserWindow() {
	if (dptId == "") {
		$.ligerDialog.warn('请选择用户部门');
		return false;
	}
	openWindow("", dptId, orgId);
}
function editUserWindow(){
	if (usrId == "") {
		$.ligerDialog.warn('请选择修改用户');
		return false;
	}
	openWindow(usrId, dptId, orgId);
}
//创建子窗口 用于修改或新增
function openWindow(usrid, dptid, orgid) {
	var url = serverpath + '/sys/user/add?='+usrid+
			'&dptId='+dptid+"&orgId="+orgid;
	var title = "用户信息【新增】";
	if (usrid != "") {
		title = "用户信息【修改】";
	}
	$.ligerDialog.open({
		url : url,
		width : 600,
		height : 450,
		name : "iFrame",
		title : title,
		buttons : [ {
			text : '保存',
			onclick : function(item, dialog) {
				iFrame.submit();
			}
		}, {
			text : '重置密码',
			onclick : function(item, dialog) {
				iFrame.resetPassword();
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
//查询
function serachUser() {
	var url = serverpath + '/dba/sql/add?tabId=15';
	var title = "用户信息【查询】";
	var m = $.ligerDialog.open({
		url : url,
		width : 560,
		height : 420,
		name : "iQuery",
		title : title,
		buttons : [ {
			text : '查询',
			onclick : function(item, dialog) {
				setQueryParms();
				dialog.close();
			}
		}, {
			text : '退出',
			onclick : function(item, dialog) {
				dialog.close();
			}
		} ],
		modal : true,
		isResize : true
	});
}
function setQueryParms() {
	var inputs = $(window.frames["iQuery"].document).find("input");
	$(inputs).each(function(i){
		if((this.name).indexOf("filters")==0&&
			this.type!="radio"){
			grid.setParm(this.name, this.value);
		}else if((this.name).indexOf("filters")==0&&
			this.type=="radio"&&this.checked==true){
			grid.setParm(this.name, this.value);
		}
	});
	grid.reload();
}