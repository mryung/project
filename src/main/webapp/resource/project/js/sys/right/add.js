var sysId = 0; // 树形机构ID
var modId = 0; // 编辑机构ID
var tree = null;
var rolegrid = null;
var usergrid = null;
var pwin = window.parent;
$(function() {
	$("#navtab").ligerTab();
	rightNameManager = $("#rightName").ligerTextBox({
		currency : false
	});
	rightCodeManager = $("#rightCode").ligerTextBox({
		currency : false
	});
	rightUrlManager = $("#rightUrl").ligerTextBox({
		currency : false
	});
	descriptionManager = $("#rightDescription").ligerTextBox({
		currency : false
	});
	sortManager = $("#sorted").ligerTextBox({
		currency : false
	});
	rightparentManager = $("#rightparenttxt").ligerComboBox({
		tree : {
			url : serverpath + "/sys/right/tree?format=json",
			ajaxType : 'post',
			jsonField : "tree",
			textFieldName: 'rightName',
			idFieldName : 'rightId',
			parentIDFieldName : 'rightParentId',
			checkbox : false,
			parms :[{name:"rightid", value:rightid}],
		},
		textField: "rightName",
        valueField : "rightId",
		valueFieldID : "rightParentId",
		width : 300,
		clickSelectHide : true,
		treeLeafOnly : false
	});
	show0Manager = $("#isShow0").ligerRadio({
		disabled : false
	});
	show1Manager = $("#isShow1").ligerRadio({
		disabled : false
	});
	show0Manager.setValue(true);
	available0Manager = $("#available0").ligerRadio({
		disabled: false,
	});
	available1Manager = $("#available1").ligerRadio({
		disabled: false,
	});
	available0Manager.setValue(true)
	loadData();
	rolegrid = $("#rolegrid").ligerGrid({
		columns : [ {
			display : 'ID',
			name : 'roleId',
			align : 'left',
			width : 100,
			hide : true,
			minWidth : 60
		}, {
			display : '角色编码',
			name : 'roleCode',
			width : 120,
			align : 'left',
			minWidth : 120
		}, {
			display : '角色名称',
			name : 'roleName',
			width : 160,
			align : 'left',
			minWidth : 120
		}, {
			display : '描述',
			name : 'roleDescription',
			width : 220,
			align : 'left',
			minWidth : 120
		} ],
		url : serverpath + "/sys/right/role?rightid=" + rightid,
		slide : true,
		method : "post",
		height : 300,
		usePager : true,
		dataAction : 'server',
		jsonField : "pageInfo"
	});
	
	usergrid = $("#usergrid").ligerGrid({
		columns : [ {
			display : 'ID',
			name : 'userId',
			align : 'left',
			width : 100,
			hide : true,
			minWidth : 60
		}, {
			display : '用户名称',
			name : 'username',
			width : 120,
			align : 'left',
			minWidth : 120
		}, {
			display : '所属部门',
			name : 'orgName',
			width : 160,
			align : 'left',
			minWidth : 120
		}, {
			display : '电话',
			name : 'phone',
			width : 220,
			align : 'left',
			minWidth : 120
		} , {
			display : '邮箱',
			name : 'email',
			width : 220,
			align : 'left',
			minWidth : 120
		} ],
		
		url : serverpath + "/sys/right/user?rightid=" + rightid,
		ajaxType : "post",
		slide : true,
		height : 300,
		usePager : true,
		dataAction : 'server',
		jsonField : "pageInfo",
	});
	
//	usergrid = $("#usergrid").ligerGrid({
//		columns : [ {
//			display : 'ID',
//			name : 'userId',
//			align : 'left',
//			width : 100,
//			hide : true,
//			minWidth : 60
//		}, {
//			display : '用户名称',
//			name : 'username',
//			width : 120,
//			align : 'left',
//			minWidth : 120
//		}, {
//			display : '电话',
//			name : 'phone',
//			width : 220,
//			align : 'left',
//			minWidth : 120
//		} , {
//			display : '邮箱',
//			name : 'email',
//			width : 220,
//			align : 'left',
//			minWidth : 120
//		} , {
//			display : '所属部门',
//			name : 'orgName',
//			width : 160,
//			align : 'left',
//			minWidth : 120
//		} ],
//		url : serverpath + "/sys/right/user?rightid=" + rightid,
//		slide : true,
//		method : "post",
//		height : 300,
//		usePager : true,
//		dataAction : 'server',
//		jsonField : "pageInfo"				
//	});
});
function loadData() {
	
	if(rightid == null || rightid == ''){
		return false;
	}
	$.ajax({
		url : serverpath + "/sys/right/data?rightid="+rightid,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var right = data.data;
			
			$("#rightName").val(right.rightName);
			$("#rightId").val(right.rightId);
			$("#rightparenttxt").val(data.parent.rightName);	
			$("#rightParentId").val(data.parent.rightId);
			$("#rightCode").val(right.rightCode);
			$("#rightUrl").val(right.rightUrl);
			$("#rightDescription").val(right.rightDescription);
			$("#sorted").val(right.sorted);
		
			if (right.isShow == 1) {
				show0Manager.setValue(true);
				show1Manager.setValue(false);
			}else if(right.isShow == 0){
				show0Manager.setValue(false);
				show1Manager.setValue(true);
			}
			if (right.available == 1) {
				available0Manager.setValue(true);
				available1Manager.setValue(false);
			}else if(right.isShow == 0){
				available0Manager.setValue(false);
				available1Manager.setValue(true);
			}
		},
		error : function() {
			$.ligerDialog.error("查询失败!");
		}
	});
}
// 保存
function submit() {
	var url = serverpath + "/sys/right/save";
	var waitManager=$.ligerDialog.waitting('正在保存,请稍候.......');
	$.ajax({
		url : url,
		type : "post",
		data : $("#form").serialize(),
		dataType : 'json',
		success : function(data) {
			var msg=data.msg;
			$.ligerDialog.alert(msg);
			waitManager.close();
			if (data.rightId != null) {
				rightid=data.rightId;
				loadData();
				pwin.refreshTree();
				pwin.refreshGrid();
			}
		},
		error : function() {
			$.ligerDialog.error('保存失败!');
			waitManager.close();
		}
	});
}