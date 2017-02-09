var pwin = window.parent;
var role = null;
var right = null;

var uservalid1Manager = null;
var uservalid0Manager = null;
$(function() {
	$("#navtab").ligerTab();
	userManager = $("#username").ligerTextBox({
		currency : false
	});
	userManager = $("#email").ligerTextBox({
		currency : false
	});
	userManager = $("#phone").ligerTextBox({
		currency : false
	});
	sex0Manager = $("#sex0").ligerRadio({
		disabled : false
	});	
	sex1Manager = $("#sex1").ligerRadio({
		disabled : false
	});
	sex0Manager.setValue("男");
	userorgannameManager = $("#orgName").ligerComboBox({
		tree : {
			url :  serverpath + "/sys/user/orgTree",
			ajaxType : 'POST',
			jsonField : "tree",
			idFieldName : 'orgId',
			textFieldName: 'orgName',
			parentIDFieldName : 'orgParentId',
			checkbox : false,
			nodeWidth:300,
			onClick : cmdClickOrgan
		},
		valueFieldID : "orgName",
		width : 300,
		clickSelectHide : true,
		treeLeafOnly : false
	});
	uservalid1Manager = $("#available1").ligerRadio({
		disabled : false
	});
	uservalid1Manager.setValue(true);
	uservalid0Manager = $("#available0").ligerRadio({
		disabled : false
	});
	role = $("#roletree").ligerTree({
		url : serverpath + "/sys/user/roleTree?format=json",
		ajaxType : "post",
		jsonField : "tree",
		slide : true,
		checkbox : true,
		nodeWidth : 300,
		autoCheckboxEven : false,
		idFieldName : 'roleId',
		textFieldName: 'roleName',
		parentIDFieldName : 'roleParentId',
		parms :[
		        {name:"userId",value:userId}],
		isChecked: function(node){
			alert("hello");
		},
		ischecked: function(node){
			alert("hello1");
		}
	});
	right = $("#rightTree").ligerTree({
			url : serverpath + "/sys/user/rightTree?format=json",
			ajaxType : "post",
			jsonField : "tree",
			slide : true,
			checkbox : true,
			nodeWidth : 300,
			idFieldName : 'rightId',
			textFieldName: 'rightName',
			parentIDFieldName : 'rightParentId',
			parms :[
			        {name:"userId",value:userId}],
			
	});
	loadData();
});
function loadData() {
	if(userId == null || userId == ''){
		return false;
	}
	$.ajax({
		url : serverpath + "/sys/user/userData",
		type : "POSt",
		dataType : 'json',
		data : {"userId":userId},
		success : function(data) {
			var user = data.user;			
			$("#userId").val(user.userId);
			$("#username").val(user.username);
			$("#orgName").val(user.orgName);
			$("#organizationId").val(user.organizationId);
			$("#phone").val(user.phone);
			$("#email").val(user.email);
			if (user.sex=="女") {
				sex0Manager.setValue(false);
				sex1Manager.setValue(true);
			} else {
				sex0Manager.setValue(true);
				sex1Manager.setValue(false);
			}
			if (user.available==1) {
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
	var username = $("#username").val();
	if(username==""){
		$.ligerDialog.error('用户账号不能为空!');
		return false;
	}
	
	var phone = $("#phone").val();
	if(phone==""){
		$.ligerDialog.error('电话不能为空!');
		return false;
	}
	
	var email = $("#email").val();
	if(email==""){
		$.ligerDialog.error('邮箱不能为空!');
		return false;
	}
	
	var orgName = $("#orgName").val();
	if(orgName==""){
		$.ligerDialog.error('所属部门不能为空!');
		return false;
	}
	
	$("#roles").val(getRoles());
	$("#rights").val(getRights());
	var url = serverpath + "/sys/user/save";
	var waitManager = $.ligerDialog.waitting('正在保存,请稍候.......');
	$.ajax({
		url : url,
		type : "post",
		data : $("#form").serialize(),
		dataType : 'json',
		success : function(data) {
			var msg = data.msg;
			waitManager.close();
			$.ligerDialog.alert(msg.context);
			if(msg.code=="0"){
				if (data.usrId != null) {
					usrId = usrId;
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
function getRoles() {
	var roleids = "0";
	var notes = role.getChecked();
	for (var i = 0; i < notes.length; i++) {
		if (notes[i].data.roleId != null)
			rolids += "," + notes[i].data.roleId;
	}
	return roleids;
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
/*function submit(){
	var url = serverpath + "/sys/user/add";
	var waitManager = $.ligerDialog.waitting('正在保存,请稍候.......');
	$.ajax({
		url : url,
		type : "post",
		data : $("#form").serialize(),
		dataType : 'json',
		success : function(data) {
			waitManager.close();
			$.ligerDialog.alert(data.info);
			if(data.status=="1"){
				if (data.usrId != null) {
					usrId = usrId;
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
}*/