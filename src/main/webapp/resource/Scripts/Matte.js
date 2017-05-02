function showMatte() {
    var bH = getHeight();
    var bW = getWidth();
    $("body").append("<div id=Matte></div>");
    $("#Matte").css({ width: bW, height: bH, display: "block" });    
}
function resetBg() {
    var fullbg = $("#Matte").css("display");
    if (fullbg == "block") {
        var bH = getHeight();
        var bW = getWidth();
        $("#Matte").css({ width: bW, height: bH });           
    }
}

//关闭灰色JS遮罩层和操作窗口
function closeMatte() {
    $("#Matte").remove();
}
function getHeight() {
    return Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight);
}
function getWidth() {
    return Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth);
}

function SetUrl() {   
        var pattern = /[^\/]*\.aspx/g;
        if (pattern.test(location.pathname)) {
            var pageName = RegExp.lastMatch;
            $("[href='" + pageName + "']").css({ "color": "Red" });
            $("[href='" + pageName + "']").click(function (e) {
                e.preventDefault();
            });
        }
    }
    $(document).ready(function () {
        SetUrl();
    })