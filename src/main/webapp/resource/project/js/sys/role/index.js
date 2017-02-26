var tree = null;
var roleId = "";
var roleParentId = "";
$(function() {
	$("#toptoolbar").ligerToolBar({
		items : [ {
			text : '新增',
			icon : 'add',
			click : addRoleWindow
		}, {
			line : true
		}, {
			text : '修改',
			icon : 'edit',
			click : editRoleWindow
		}, {
			line : true
		}, {
			text : '查询',
			icon : 'search',
			click : deleteRole
		}, {
			line : true
		}]
	});
	$("#layout").ligerLayout({
		leftWidth : 200
	});
	tree = $("#tree").ligerTree({
		url : serverpath + "/sys/role/tree",
		ajaxType : "POST",
		jsonField : "tree",
		idFieldName : 'roleId',
		textFieldName: 'roleName',
		parentIDFieldName : 'roleParentId',
		slide : true,
		checkbox : false,
		onClick : function(note) {
			roleId=note.data.roleId;
			roleParentId=note.data.roleParentId;
			refreshGrid();
		},
		nodeWidth : 200
	});
	grid = $("#maingrid").ligerGrid({
		height : '100%',
		columns : [ {
			display : '角色编号',
			name : 'roleId',
			align : 'left',
			width : 50,
			hide : true,
		}, {
			display : '权限名字',
			name : 'roleName',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '创建时间',
			name : 'roleGenTime',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '角色权限编号',
			name : 'roleCode',
			width : 150,
			align : 'left',
			minWidth : 150
		}, {
			display : '排序编号',
			name : 'sorted',
			width : 50,
			align : 'left',
			minWidth : 50
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
		url : serverpath + "/sys/role/list",
		jsonField : "pageInfo",
		dataAction : 'server',
		pageSize : 100,
		method : "POST",
		onDblClickRow : function(data, rowindex, rowobj) {
			roleId = data.roleId;
			editRoleWindow();
		},
		onSelectRow : function(data, rowindex, rowobj) {
			roleId = data.roleId;
		},
		rownumbers : true
	});
	$("#sysmenu").each(function() {
		$(this).height($(this).parent().height() - $(this).prev().height());
	});
});
// 刷新列表
function refreshGrid() {
	if(roleId != ''||roleId != null){
		grid.setParm("roleId", roleId);
	}else{
		return false;
	}
	grid.reload();
}
// 创建子窗口 用于修改或新增
function addRoleWindow() {
	openWindow("");
}
function deleteRole(){
	if (roleId == null || roleId == "") {
		$.ligerDialog.warn('请删除的角色');
		return false;
	}
	var url = serverpath + "/sys/role/delete/"+roleId;
	$.post(url,function(data){
		if(data.code == 0){
			$.ligerDialog.alert(msg.msg);
		}else{
			$.ligerDialog.alert("删除出现错误！");
		}
	})
}
function editRoleWindow(){
	if (roleId == null || roleId == "") {
		$.ligerDialog.warn('请选择修改角色');
		return false;
	}
	openWindow(roleId);
}
//创建子窗口 用于修改或新增
function openWindow(roleId) {
	var url = serverpath + '/sys/role/add?roleId='+(roleId == null? '':roleId);
	var title = "用户信息【新增】";
	if (roleId != "" || roleId != null) {
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