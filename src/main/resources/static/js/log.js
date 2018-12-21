(function () {
    var params = {};
    //Document对象数据
    if(document) {
        params.domain = document.domain || '';
        params.url = document.URL || '';
        params.title = document.title || '';
        params.referrer = document.referrer || '';
    }
    //location对象数据
    if(location) {
        params.page = pageName();
        params.allpage = pageNameAndExt();
        params.path = location.pathname || '';
        params.search = location.search || '';
    }
    //Window对象数据
    if(window && window.screen) {
        params.sh = window.screen.height || 0;
        params.sw = window.screen.width || 0;
        params.cd = window.screen.colorDepth || 0;
    }
    //navigator对象数据
    if(navigator) {
        params.lang = navigator.language || '';
    }
    //解析_maq配置
    if("undefined" != typeof _maq && _maq){
        var _key;
        var _value;
        for(var i in _maq) {
            _key = _maq[i][0];
            _value = _maq[i][1];
            params[_key] = _value;
            /*switch(_key) {
             case 'type':
             params.account = _value;
             break;
             default:
             break;
             }*/
        }
    }
    //拼接参数串
    var args = '';
    for(var i in params) {
        if(args != '') {
            args += '&';
        }
        args += i + '=' + encodeURIComponent(params[i]);
    }

    //通过Image对象请求后端脚本
    var img = new Image(1, 1);
    img.src = 'http://47.95.249.246:8090/log.gif?' + args;
})();

// 取当前页面名称(不带后缀名)
function pageName()
{
    var a = location.href;
    var b = a.split("/");
    var c = b.slice(b.length-1, b.length).toString(String).split(".");
    return c.slice(0, 1);
}

//取当前页面名称(带后缀名)
function pageNameAndExt()
{
    var strUrl=location.href;
    var arrUrl=strUrl.split("/");
    var strPage=arrUrl[arrUrl.length-1];
    return strPage;
}