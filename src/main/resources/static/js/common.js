//jqGrid的配置信息
if ($($.jgrid).length>0){
    $.jgrid.defaults.width = 1000;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';
}

//工具集合Tools
window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost/index.html?id=123
// T.p('id') --> 123;
var url = function(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
};
T.p = url;

//请求前缀
var baseURL = "/";




// //登录token
// var token = localStorage.getItem("token");
//
// // 需要删除token重新根据url的参数来获得，这样的话就不会保留上一次的token
// var isDelToken = url("_d");
// if (isDelToken != null && isDelToken.toString().length>1){
//     token = null;
// }
//
// if(token == null){
//     token = url("_t");
//     if (token != null && token.toString().length>1){
//         localStorage.setItem("token", token);
//         // 去掉传递token的url参数
//         var _url = delQueStr(parent.location.href, "_t");
//         parent.location.href = delQueStr(_url, "_d");
//     }else{
//         parent.location.href = baseURL + 'login.html';
//     }
// }



//登录token
var token = localStorage.getItem("token");
if(token == 'null'){
    parent.location.href = baseURL + 'login.html';
}

//jquery全局配置
$.ajaxSetup({
	dataType: "json",
	cache: false,
    headers: {
        "token": token
    },
    // xhrFields: {
    //     withCredentials: true
    // },
    complete: function(xhr) {
        //token过期，则跳转到登录页面
        if(xhr.responseJSON.code == 401){
            parent.location.href = baseURL + 'login.html';
        }
    }
});

//jqgrid全局配置
if ($($.jgrid).length>0) {
    $.extend($.jgrid.defaults, {
        ajaxGridOptions: {
            headers: {
                "token": token
            }
        }
    });
}

//权限判断
function hasPermission(permission) {
    if (window.parent.permissions.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}

//重写alert
window.alert = function(msg, callback){

    // 优化... 避免驾车按钮多次提交
    // 先拦截回车按钮，如果是回车的话，避免再次执行alert
    $(document).on('keydown', function(e){  //document为当前元素，限制范围，如果不限制的话会一直有事件
        if(e.keyCode == 13){
            window.event.returnValue = false;
            parent.layer.close(parent.layer.index);
            if(typeof(callback) === "function"){
                callback("ok");
                callback = "";
            }
        }
    });

	parent.layer.alert(msg, function(index){
		parent.layer.close(index);
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}

//重写confirm式样框
window.confirm = function(msg, callback){

    // 回车 后，执行 [确定] 的操作
    $(document).on('keydown', function(e){  //document为当前元素，限制范围，如果不限制的话会一直有事件
        if(e.keyCode == 13){
            window.event.returnValue = false;
            parent.layer.close(parent.layer.index);
            if(typeof(callback) === "function"){
                callback("ok");
                callback = "";
            }
        }
    });

	parent.layer.confirm(msg, {btn: ['确定','取消']},
	function(){//确定事件
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
    	alert("只能选择一条记录");
    	return ;
    }
    
    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请至少选择一条记录");
    	return ;
    }
    
    return grid.getGridParam("selarrrow");
}

//选择多条记录且可以一条都不选
function getSelectedRowsAndAlowNotSelect() {
    var grid = $("#jqGrid");
    return grid.getGridParam("selarrrow");
}

// 日期格式化，根据传过来的 var date = new Date();  date.Format("yyyy-MM-dd"); 这样来调用
Date.prototype.Format = function (fmt) {
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


//删除url中某个参数
function delQueStr(url, ref) {
    var str = "";
    if (url.indexOf('?') != -1) {
        str = url.substr(url.indexOf('?') + 1);
    }
    else {
        return url;
    }
    var arr = "";
    var returnurl = "";
    var setparam = "";
    if (str.indexOf('&') != -1) {
        arr = str.split('&');
        for (i in arr) {
            if (arr[i].split('=')[0] != ref) {
                returnurl = returnurl + arr[i].split('=')[0] + "=" + arr[i].split('=')[1] + "&";
            }
        }
        return url.substr(0, url.indexOf('?')) + "?" + returnurl.substr(0, returnurl.length - 1);
    }
    else {
        arr = str.split('=');
        if (arr[0] == ref) {
            return url.substr(0, url.indexOf('?'));
        }
        else {
            return url;
        }
    }
}