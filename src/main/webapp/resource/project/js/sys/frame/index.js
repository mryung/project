var tab = null;
var tree = null;
$(function() {
	$("#layout").ligerLayout({
		leftWidth : 200,
		centerBottomHeight : 180
	});
	var height = $(".l-layout-left").height();
	// Tab
	$("#layoutcenter").ligerTab({
		height : height,
		showSwitch : true
	});
	tab = liger.get("layoutcenter");

	tree = $("#tree").ligerTree({
		url :serverpath+"/sys/frame/menu",
		ajaxType : "POST",
		jsonField : "tree",
		slide : false,
		checkbox : false,
		onClick : clickTree,
		nodeWidth : 300,
		idFieldName : 'rightId',
		textFieldName: 'rightName',
		parentIDFieldName : 'rightParentId'
	});
	$("#help").click(function() {
		var url = serverpath + "/help/操作手册.doc";
		window.open(url);
	});
	$("#editpwd").click(function() {
		var url = serverpath + "/sys/password";
		addTab("999999", "修改密码", url);
	});
	$("#logout").click(function() {
		window.top.location.replace(serverpath);
	}); 
	// 设置高度 
	$("#layoutleft").each(function (){
		$(this).height($(this).parent().height() - $(this).prev().height());
		});
	tab.addTabItem({
		tabid : 0,
		text : "我的主页",
		showClose : false,
		url : serverpath + "/sys/frame/welcome"
	});
});


$(window).resize(function() {
	$("#layoutleft").each(function() {
		$(this).height($(this).parent().height() - $(this).prev().height());
	});
});
function addTab(tabid, text, url) {
	tab.addTabItem({
		tabid : tabid,
		text : text,
		url : url
	});
}
function clickTree(note) {
	var url = serverpath +"/"+ note.data.rightUrl;
	if (note.data.rightUrl != null && note.data.rightUrl != "") {
		addTab(note.data.rightId, note.data.rightName, url);
	}
}
$(window).resize(function() {
	$("#layoutleft").each(function() {
		$(this).height($(this).parent().height() - $(this).prev().height());
	});
});