var groupid = "";
var usrId = "";
var dptId = "";
var orgId = "";
var tree = null;
$(function() {
	$("#toptoolbar").ligerToolBar({
		items : [ {
			text : '新增',
			icon : 'add',
			click : addOrgWindow
		}, {
			line : true
		}, {
			text : '修改',
			icon : 'edit',
			click : editOrgWindow
		}, {
			line : true
		}, {
			text : '删除',
			icon : 'delete',
			click : deleteOrg
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
			orgId=note.data.orgId;
			refreshGrid();
		},
		nodeWidth : 200
	});
	
	grid = $("#maingrid").ligerGrid({
		height : '100%',
		columns : [ {
			display : '组织id',
			name : 'orgId',
			align : 'left',
			width : 50,
			hide : true,
		}, {
			display : '组织名字',
			name : 'orgName',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '创建时间',
			name : 'orgGenTime',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '组织描述',
			name : 'orgDescription',
			width : 100,
			align : 'left',
			minWidth : 100
		}, {
			display : '组织权限编号',
			name : 'orgCode',
			width : 150,
			align : 'left',
			minWidth : 150
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
		url : serverpath + "/sys/org/list",
		jsonField : "pageInfo",
		dataAction : 'server',
		pageSize : 100,
		method : "POST",
		onDblClickRow : function(data, rowindex, rowobj) {
			orgId = data.orgId;
			editOrgWindow();
		},
		onSelectRow : function(data, rowindex, rowobj) {
			orgId = data.orgId;
		},
		rownumbers : true
	});
	
	$("#sysmenu").each(function() {
		$(this).height($(this).parent().height() - $(this).prev().height());
	});
});
//刷新树
function refreshTree() {
	tree.reload();
}
// 刷新列表
function refreshGrid() {
	if(orgId != ''||orgId != null){
		grid.setParm("orgid", orgId);
	}
	grid.reload();
}
// 创建子窗口 用于修改或新增
function addOrgWindow() {
	openWindow("");
}
function editOrgWindow(){
	if(orgId == null || orgId == ''){
		$.ligerDialog.warn('请选择部门');
		return false;
	}
	openWindow(orgId);
}

function deleteOrg(){
	if(orgId == null || orgId == ''){
		$.ligerDialog.warn('请选择部门');
		return false;
	}
	var flag = confirm("是否要删除当前部门");
	if(!flag){
		return false;
	}
	var url = serverpath + "/sys/org/delete/"+orgId;
	$.post(url,function(data){
		if(data.code == 1){
			$.ligerDialog.warn(data.msg);
			location.reload();
		}else{
			$.ligerDialog.warn("删除出错!");
		}
	})
	
}

//创建子窗口 用于修改或新增
function openWindow(orgId) {
	var url = serverpath + '/sys/org/add?orgid='+orgId;
	var title = "部门信息【新增】";
	if (orgId != "") {
		title = "部门信息【修改】";
	}
	$.ligerDialog.open({
		url : url,
		width : 500,
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
