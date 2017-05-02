var pwin = window.parent;

Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

$(function() {
	$("#navtab").ligerTab();
	$("#pointCode").ligerTextBox({
		currency : false
	});
	$("#pointDescription").ligerTextBox({
		currency : false
	});
	$("#pointTime1").ligerTextBox({
		currency : false
	});
	point0Manager = $("#pointValid0").ligerRadio({
		disabled : false
	});
	point1Manager = $("#pointValid1").ligerRadio({
		disabled : false
	});
	point1Manager.setValue(true);
	loadData();
});
function loadData() {
	
	if(pointId == null || pointId == ''){
		return false;
	}
	$.ajax({
		url : serverpath + "/point/data?pointId="+pointId,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var point  = data.point;
			$("#pointCode").val(point.pointCode);
			$("#pointId").val(point.pointId);
			$("#pointDescription").val(point.pointDescription);
			
			var date = new Date(point.pointTime*1000);
			$("#pointTime1").val(date.Format("yyyy-MM-dd hh:mm:ss"));	
			
			$("#pointError").val(point.pointError);
			
			if (point.pointValid == 0) {
				point1Manager.setValue(false);
				point0Manager.setValue(true);
			}else if(point.pointValid == 1){
				point1Manager.setValue(true);
				point0Manager.setValue(false);
			}
		},
		error : function() {
			$.ligerDialog.error("查询失败!");
		}
	});
}
// 保存
function submit() {
	var url = serverpath + "/point/save";
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
			if (data.pointId != null) {
				pointId=data.pointId;
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