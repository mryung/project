var pwin = window.parent;
var role = null;
var right = null;

var uservalid1Manager = null;
var uservalid0Manager = null;
$(function() {
	$("#navtab").ligerTab();
	orgNameManager = $("#orgName").ligerTextBox({
		currency : false
	});
	orgDescManager = $("#orgDescription").ligerTextBox({
		currency : false
	});
	orgParentstxtManager = $("#orgParentstxt").ligerComboBox({
		tree : {
			url :  serverpath + "/sys/user/orgTree",
			ajaxType : 'POST',
			jsonField : "tree",
			idFieldName : 'orgId',
			textFieldName: 'orgName',
			parentIDFieldName : 'orgParentId',
			checkbox : false,
			nodeWidth:300,
		},
		textField: "orgName",
		valueField: "orgId",
		valueFieldID : "orgParentId",
		width : 300,
		clickSelectHide : true,
		treeLeafOnly : false
	});
	orgvalid1Manager = $("#available1").ligerRadio({
		disabled : false
	});
	orgvalid1Manager.setValue(true);
	orgvalid0Manager = $("#available0").ligerRadio({
		disabled : false
	});
	role = $("#usergrid").ligerGrid({
		columns : [ {
			display : 'ID',
			name : 'userId',
			align : 'left',
			width : 10,
			hide : true,
			minWidth : 60
		}, {
			display : '用户名',
			name : 'username',
			width : 120,
			align : 'left',
			minWidth : 120
		}, {
			display : '电话',
			name : 'phone',
			width : 150,
			align : 'left',
			minWidth : 120
		}, {
			display : '邮箱',
			name : 'email',
			width : 140,
			align : 'left',
			minWidth : 120
		}],
		url : serverpath + "/sys/org/user?orgid=" + (orgId==null?'':orgId),
		method : "post",
		height : 300,
		usePager : true,
		dataAction : 'server',
		jsonField : "pageInfo"
	});
	loadData();
});
function loadData() {
	if(orgId == null || orgId == ''){
		return false;
	}
	$.ajax({
		url : serverpath + "/sys/org/data",
		type : "POSt",
		dataType : 'json',
		data : {"orgid":orgId},
		success : function(data) {
			var org = data.data;			
			$("#orgId").val(org.orgId);
			$("#orgName").val(org.orgName);
			
			$("#orgParentId").val(org.orgParentId);
			$("#orgParentstxt").val(data.parentdata.orgName);

			$("#orgDescription").val(org.orgDescription);
			
			if (org.available==0) {
				orgvalid1Manager.setValue(false);
				orgvalid0Manager.setValue(true);
			} else {
				orgvalid1Manager.setValue(true);
				orgvalid0Manager.setValue(false);
			}
		},
		error : function() {
			$.ligerDialog.error('查询失败');
		}
	});
}

function resetPassword() {
	var usrId = $("#usrid").val();
	if (usrId != null) {
		$.ajax({
			url : serverpath + "/sys/user/reset/" + usrId + 
				"?format=json&date=" + new Date(),
			type : "post",
			dataType : 'json',
			data : $("#form").serialize(),
			success : function(data) {
				var msg=data.msg;
				$.ligerDialog.alert(msg.context);
			},
			error : function() {
				$.ligerDialog.error('保存失败!');
			}
		});
	}
}
function submit() {
	var orgName = $("#orgName").val();
	if(orgName==""){
		$.ligerDialog.error('部门名称不能为空!');
		return false;
	}
	var orgDescription = $("#orgDescription").val();
	if(orgDescription==""){
		$.ligerDialog.error('部门描述不能为空!');
		return false;
	}
	var url = serverpath + "/sys/org/save";
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
				if (data.orgid != null) {
					orgId = data.orgid;
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
