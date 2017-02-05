/**
 * 
 */
function submit(){
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
}