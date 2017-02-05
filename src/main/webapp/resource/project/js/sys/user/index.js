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
		},{
			text : '查询8',
			icon : 'search',
			click : addUser
		}, {
			line : true
		}]
	});
	$("#layout").ligerLayout({
		leftWidth : 200
	});
	tree = $("#tree").ligerTree({
		url : serverpath + "/sys/org/tree",
		ajaxType : "POST",
		jsonField : "tree",
		idFieldName : 'orgId',
		textFieldName: 'orgName',
		parentIDFieldName : 'orgParentId',
		slide : true,
		checkbox : false,
		onClick : function(note) {
			if(note.data.orgId=="1"){
				orgId="";
			}else{
				orgId=note.data.orgId;
			}
			refreshGrid();
		},
		nodeWidth : 200
	});
	grid = $("#maingrid").ligerGrid({
		height : '100%',
		columns : [ {
			display : 'ID',
			name : 'userId',
			align : 'left',
			width : 100,
			hide : true,
			minWidth : 60
		}, {
			display : '用户帐号',
			name : 'username',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '用户名称',
			name : 'nickname',
			width : 100,
			align : 'left',
			minWidth : 100
		},{
			display : '电话',
			name : 'phone',
			align : 'left',
			width : 300
		} ],
		url : serverpath + "/sys/user/list",
		jsonField : "pageInfo",
		dataAction : 'server',
		/*parms : [ {
			name : "dptId",
			value : dptId

		}, {
			name : "orgId",
			value : orgId
		} ],*/
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
	if(orgId != ''||orgId != null){
		grid.setParm("orgId", orgId);
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

function addUser(){
	if(orgId == ""||orgId == null){
		$.ligerDialog.warn('请选择部门');
	}else{
		var url = serverpath + '/sys/user/add?orgId='+orgId;
		var title = "添加用户【添加】";
		var m = $.ligerDialog.open({
			url : url,
			width : 560,
			height : 420,
			name : "iFrame",
			title : title,
			buttons : [ {
				text : '保存',
				onclick : function(item, dialog) {
					iFrame.submit();
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