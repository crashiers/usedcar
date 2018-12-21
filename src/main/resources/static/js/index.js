

//生成菜单
var menuItem = Vue.extend({
	name: 'menu-item',
	props:{item:{},index:0},
	template:[
	          '<li :class="{active: (item.type===0 && index === 0)}">',
				  '<a v-if="item.type === 0" href="javascript:;">',
					  '<i v-if="item.icon != null" :class="item.icon"></i>',
					  '<span>{{item.name}}</span>',
					  '<i class="fa fa-angle-left pull-right"></i>',
				  '</a>',
				  '<ul v-if="item.type === 0" class="treeview-menu">',
					  '<menu-item :item="item" :index="index" v-for="(item, index) in item.list"></menu-item>',
				  '</ul>',
				  '<a v-if="item.type === 1" :href="\'#\'+item.url">' +
					  '<i v-if="item.icon != null" :class="item.icon"></i>' +
					  '<i v-else class="fa fa-circle-o"></i> {{item.name}}' +
				  '</a>',
	          '</li>'
	].join('')
});

//iframe自适应
$(window).on('resize', function() {
	var $content = $('.content');
	$content.height($(this).height() - 90);
	$content.find('iframe').each(function() {
		$(this).height($content.height());
	});
}).resize();

//注册菜单组件
Vue.component('menuItem',menuItem);

var vm = new Vue({
	el:'#rrapp',
	data:{
		user:{},
		menuList:{},
		main:"main.html",
		password:'',
		newPassword:'',
        navTitle:"欢迎页",
		src:'',
        captcha:'',
		userinfo:{}
	},
	methods: {
		getMenuList: function () {
			$.getJSON(baseURL + "sys/menu/nav", function(r){
				vm.menuList = r.menuList;
                window.permissions = r.permissions;

                //路由
                var router = new Router();
                routerList(router, vm.menuList);
                router.start();
			});
		},
		getUser: function(){
			$.getJSON(baseURL + "sys/user/info", function(r){
				vm.user = r.user;

				// 选中地区下拉列表
                $("#distpicker3").distpicker({
                    province: vm.user.province,
                    city: vm.user.city,
                    district: vm.user.district
                });

			});
		},
		updatePassword: function(){
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "修改密码",
				area: ['400px', '270px'],
				shadeClose: false,
				content: jQuery("#passwordLayer"),
				btn: ['修改','取消'],
				btn1: function (index) {
					var data = "password="+vm.password+"&newPassword="+vm.newPassword;
					$.ajax({
						type: "POST",
					    url: baseURL + "sys/user/password",
					    data: data,
					    dataType: "json",
					    success: function(r){
							if(r.code == 0){
								layer.close(index);
								layer.alert('修改成功', function(){
									location.reload();
								});
							}else{
								layer.alert(r.msg);
							}
						}
					});
	            }
			});
		},
        goSuperAdmin: function(){
			// 先刷新出验证码
            vm.refreshCode();
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "切换为超级管理员",
				area: ['400px', '300px'],
				shadeClose: false,
				content: jQuery("#superAdminLoginLayer"),
				btn: ['登录','取消'],
				btn1: function (index) {
					var data = "password="+vm.password+"&username=admin&captcha="+vm.captcha;
					$.ajax({
						type: "POST",
						url: baseURL + "sys/login",
						data: data,
						dataType: "json",
						success: function(r){
                            if(r.code == 0){//登录成功
                                localStorage.setItem("token", r.token);
                                location.reload();
                            }else{
                                vm.refreshCode();
                                vm.captcha = '';
                                layer.alert(r.msg);
                            }
						}
					});
				}
			});
		},
        updateInfo: function () {
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "修改资料",
                area: ['600px', '520px'],
                shadeClose: false,
                content: jQuery("#updateInfoLayer"),
                btn: ['修改','取消'],
                btn1: function (index) {
                    if ($.trim($("#input_company").val()) == ""){
                        layer.alert("请填写公司名称");
                        $("#input_company").focus();
                        return;
                    }
                    // 判断省市区是否未填写
                    if ($.trim($("#province1").val()) == "" || $.trim($("#city1").val()) == "" || $.trim($("#district1").val()) == ""){
                        layer.alert("请选择公司所在地区");
                        $("#province1").focus();
                        return;
                    }
                    if ($.trim($("#input_address").val()) == ""){
                        layer.alert("请填写公司详细地址");
                        $("#input_address").focus();
                        return;
                    }
                    if ($.trim($("#input_relname").val()) == ""){
                        layer.alert("请填写您的称呼");
                        $("#input_relname").focus();
                        return;
                    }

                    // var data = "?relname="+$.trim($("#input_relname").val());
                    // data += "&province="+$.trim($("#province1").val())+"&city="+$.trim($("#city1").val());
                    // data += "&district="+$.trim($("#district1").val())+"&address="+$.trim($("#input_address").val());
                    // data += "&company="+$.trim($("#input_company").val())+"&tel="+$.trim($("#input_tel").val());

                    $.ajax({
                        type: "POST",
                        url: baseURL + "sys/user/update",
                        contentType: "application/json",
                        data: JSON.stringify(vm.user),
                        success: function(r){
                            if(r.code == 0){
                                layer.close(index);
                                layer.alert('修改成功', function(){
                                    location.reload();
                                });
                            }else{
                                layer.alert(r.msg);
                            }
                        }
                    });

                }
            });
        },
        refreshCode: function(){
            this.src = "captcha.jpg?t=" + $.now();
        },
        logout: function () {
			//删除本地token
            localStorage.removeItem("token");
            //跳转到登录页面
            location.href = baseURL + 'login.html';
            //location.href = "http://ssa.jd.com/sso/logout?ReturnUrl=http://"+location.host+"/man";
        },
        donate: function () {
            layer.open({
                type: 2,
                title: false,
                area: ['806px', '467px'],
                closeBtn: 1,
                shadeClose: false,
                content: ['http://xxx/donate.jpg', 'no']
            });
        }
	},
	created: function(){
		this.getMenuList();
		this.getUser();
	}
});



function routerList(router, menuList){
	for(var key in menuList){
		var menu = menuList[key];
		if(menu.type == 0){
			routerList(router, menu.list);
		}else if(menu.type == 1){
			router.add('#'+menu.url, function() {
				var url = window.location.hash;
				
				//替换iframe的url
			    vm.main = url.replace('#', '');
			    
			    //导航菜单展开
			    $(".treeview-menu li").removeClass("active");
                $(".sidebar-menu li").removeClass("active");
			    $("a[href='"+url+"']").parents("li").addClass("active");

			    vm.navTitle = $("a[href='"+url+"']").text();
			});
		}
	}
}
