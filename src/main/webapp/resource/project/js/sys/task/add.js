var pwin = window.parent;
$(function() {
	$("#navtab").ligerTab();
	$("#remark").ligerTextBox({
		currency : false
	});
	$("#beanName").ligerTextBox({
		currency : false
	});
	$("#methodName").ligerTextBox({
		currency : false
	});
	$("#methodParams").ligerTextBox({
		currency : false
	});
	$("#cronExpression").ligerTextBox({
		currency : false
	});
	status0Manager = $("#status0").ligerRadio({
		disabled : false
	});
	status1Manager = $("#status1").ligerRadio({
		disabled : false
	});
	status0Manager.setValue(true);
	loadData();
});
function loadData() {
	
	if(jobId == null || jobId == ''){
		return false;
	}
	$.ajax({
		url : serverpath + "/task/data?jobId="+jobId,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var job  = data.job;
			$("#jobId").val(job.jobId);
			$("#remark").val(job.remark);
			$("#beanName").val(job.beanName);
			$("#methodName").val(job.methodName);	
			$("#methodParams").val(job.methodParams);
			$("#cronExpression").val(job.cronExpression);
		
			if (job.status == 0) {
				status0Manager.setValue(true);
				status1Manager.setValue(false);
			}else if(job.status == 1){
				status0Manager.setValue(false);
				status1Manager.setValue(true);
			}
		},
		error : function() {
			$.ligerDialog.error("查询失败!");
		}
	});
}
// 保存
function submit() {
	var url = serverpath + "/task/save";
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
			if (data.jobId != null) {
				jobId=data.jobId;
				loadData();
				pwin.refreshGrid();
			}
		},
		error : function() {
			$.ligerDialog.error('保存失败!');
			waitManager.close();
		}
	});
}