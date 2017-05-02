var userId = "";
var orgId = "";
var tree = null;
$(function() {
	$("#toptoolbar").ligerToolBar({
		items : [ {
			text : '新增',
			icon : 'add',
			click : addUser
		}, {
			line : true
		}, {
			text : '修改',
			icon : 'edit',
			click : editUserWindow
		}, {
			line : true
		}, {
			line : true
		}, {
			text : '删除',
			icon : 'delete',
			click : deleteUser
		},]
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
			orgId=note.data.orgId;
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
			userId = data.userId;
			editUserWindow();
		},
		onSelectRow : function(data, rowindex, rowobj) {
			userId = data.userId;
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
	if (userId == "") {
		$.ligerDialog.warn('请选择修改用户');
		return false;
	}
	openWindow(userId);
}
//创建子窗口 用于修改或新增
function openWindow(userId) {
	var url = serverpath + '/sys/user/add?userId='+userId;
	var title = "用户信息【新增】";
	if (userId != "") {
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

function deleteUser(){
	if(userId == null || userId == ''){
		$.ligerDialog.warn("请选择删除的用户！");
		return false;
	}
	var r = confirm("你确定要删除当前用户吗");
	if(r == true){
		$.ajax({
			url: serverpath + "/sys/user/delete/"+userId,
			type: "post",
			success: function(data){
				
				if(data.code == 1){
					//删除成功
					userId = ''; //重置userid
					$.ligerDialog.alert(data.msg);
					refreshGrid();
				}else{
					$.ligerDialog.warn(data.msg);
				}
			},
			error : function() {
				$.ligerDialog.error('删除失败！');
			}
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