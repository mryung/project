var pwin = window.parent;
var role = null;
$(function() {
	$("#navtab").ligerTab();
	roleNameManager = $("#roleName").ligerTextBox({
		currency : false
	});
	roleCodeManager = $("#roleCode").ligerTextBox({
		currency : false
	});
	roleParentTxtManager = $("#roleParentTxt").ligerTextBox({
		currency : false
	});
	roleDescriptionManager = $("#roleDescription").ligerTextBox({
		currency : false
	});
	sortedManager = $("#sorted").ligerTextBox({
		currency : false
	});
	
	uservalid1Manager = $("#available1").ligerRadio({
		disabled : false
	});
	uservalid1Manager.setValue(true);
	uservalid0Manager = $("#available0").ligerRadio({
		disabled : false
	});
	
	parentRoleTxtManager = $("#parentRoleTxt").ligerComboBox({
		tree : {
			url : serverpath + "/sys/role/tree",
			ajaxType : "POST",
			jsonField : "tree",
			idFieldName : 'roleId',
			textFieldName: 'roleName',
			parentIDFieldName : 'roleParentId',
			slide : true,
			checkbox : false,
			nodeWidth : 200
		},
		textField: "roleName",
		valueField: "roleId",
		valueFieldID : "roleParentId",
		width : 300,
		clickSelectHide : true,
		treeLeafOnly : false
	});
	loadData();
	
user = $("#userList").ligerGrid({
		
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
		
		url : serverpath + "/sys/role/userList?format=json",
		ajaxType : "post",
		slide : true,
		height : 300,
		usePager : true,
		dataAction : 'server',
		jsonField : "pageInfo",
		parms :[
		        {name:"roleId",value:roleId}],
	});
	right = $("#rightTree").ligerTree({
			url : serverpath + "/sys/role/rightTree?format=json",
			ajaxType : "post",
			jsonField : "tree",
			slide : true,
			checkbox : true,
			nodeWidth : 300,
			idFieldName : 'rightId',
			textFieldName: 'rightName',
			enabledCompleteCheckbox:false,
			parentIDFieldName : 'rightParentId',
			parms :[
			        {name:"roleId",value:roleId}],
			
	});
});
function loadData() {
	if(roleId == null || roleId == ''){
		return false;
	}
	$.ajax({
		url : serverpath + "/sys/role/roleData",
		type : "POSt",
		dataType : 'json',
		data : {"roleId":roleId},
		success : function(data) {
			var role = data.role;		
			$("#roleId").val(role.roleId);
			$("#roleName").val(role.roleName);
			$("#roleCode").val(role.roleCode);
			$("#organizationId").val(role.organizationId);
			$("#roleDescription").val(role.roleDescription);
			$("#sorted").val(role.sorted);
			
			//设置福全新
			if(data.parentRole != null){
				$("#parentRoleTxt").val(data.parentRole.roleName);
				$("#roleParentId").val(data.parentRole.roleId);
			}else{
				$("#parentRoleTxt").val("根目录(root)");
				$("#roleParentId").val(0);
			}
			
			if (role.available==1) {
				uservalid0Manager.setValue(false);
				uservalid1Manager.setValue(true);
			} else {
				uservalid0Manager.setValue(true);
				uservalid1Manager.setValue(false);
			}
		},
		error : function() {
			$.ligerDialog.error('查询失败');
		}
	});
}
function cmdClickOrgan(note){
	orgId = note.data.orgId;
	$("#orgName").val(note.data.orgName);
	$("#organizationId").val(orgId);
	usrorgannameManager.reload();
}

function submit() {
	var roleName = $("#roleName").val();
	if(roleName==""){
		$.ligerDialog.error('角色名不能为空!');
		return false;
	}
	
	var roleDescription = $("#roleDescription").val();
	if(roleDescription==""){
		$.ligerDialog.error('角色描述不能为空!');
		return false;
	}
	
	var roleCode = $("#roleCode").val();
	if(roleCode==""){
		$.ligerDialog.error('权限编码不能为空!');
		return false;
	}
	
	var roleParentId = $("#roleParentId").val();
	if(roleParentId==""){
		$.ligerDialog.error('父角色不能为空!');
		return false;
	}
	
	if(roleId != null || roleId != ''){
		if(roleId == $("#roleParentId").val()){
			$.ligerDialog.error('父角色不能和当前角色相同!');
			return false;
		}
	}
	$("#rights").val(getRights());
	alert($("#rights").val());
	
	var url = serverpath + "/sys/role/save";
	var waitManager = $.ligerDialog.waitting('正在保存,请稍候.......');
	$.ajax({
		url : url,
		type : "post",
		data : $("#form").serialize(),
		dataType : 'json',
		success : function(data) {
			var msg = data;
			waitManager.close();
			$.ligerDialog.alert(msg.msg);
			if(msg.code=="0"){
				if (data.usrId != null) {
					userId = userId;
					loadData();
				}
			}
			parent.refreshGrid();
		},
		error : function() {
			$.ligerDialog.error('保存失败!');
			waitManager.close();
		}
	});
}

//获取树形id
function getRights() {
	var rights = "0";
	var notes = right.getChecked();
	for (var i = 0; i < notes.length; i++) {
		if (notes[i].data.rightId != null)
			rights += "," + notes[i].data.rightId;
	}
	return rights;
}
