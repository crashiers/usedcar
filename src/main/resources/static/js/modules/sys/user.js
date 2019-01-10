$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'userId', index: "user_id", width: 25, key: true, hidden: true },
			{ label: '姓名', name: 'relname', width: 30 },
			{ label: '邮箱', name: 'email', width: 70 },
			{ label: '手机号', name: 'mobile', width: 40 },
            { label: '省', name: 'province', index: 'province', width: 1*10+20 , hidden: true},
            { label: '市', name: 'city', index: 'city', width: 1*10+20 , hidden: true},
            { label: '区', name: 'district', index: 'district', width: 1*10+20 , hidden: true},
            { label: '公司', name: 'company', index: 'company', width: 70 },
            { label: '地址', name: 'address', index: 'address', width: 120, formatter: function(value, options, row){
                return row.province+row.city+row.district+row.address;
            }},
			{ label: '状态', name: 'status', width: 30, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
            { label: '添加日期', name: 'createDate', index: 'createDate', width: 40 },
        ],
		viewrecords: true,
        height: 'auto',
        //height: 385,
        rowNum: 50,
		rowList : [50,100,200],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            username: null
        },
        showList: true,
        title:null,
        roleList:{},
        user:{
            status:1,
            deptId:null,
            deptName:null,
            roleIdList:[]
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.roleList = {};
            vm.user = {deptName:null, deptId:null, status:1, roleIdList:[], city:'', district:''};

            //获取角色信息
            this.getRoleList();

            vm.getDept();
        },
        getDept: function(){
            //加载部门树
            $.get(baseURL + "sys/dept/list", function(r){
                ztree = $.fn.zTree.init($("#deptTree"), setting, r);
                var node = ztree.getNodeByParam("deptId", vm.user.deptId);
                if(node != null){
                    ztree.selectNode(node);

                    vm.user.deptName = node.name;
                }
            })
        },
        update: function () {
            var userId = getSelectedRow();
            if(userId == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getUser(userId);
            //获取角色信息
            this.getRoleList();
        },
        del: function () {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/user/delete",
                    contentType: "application/json",
                    data: JSON.stringify(userIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            var url = vm.user.userId == null ? "sys/user/save" : "sys/user/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.user),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getUser: function(userId){
            $.get(baseURL + "sys/user/info/"+userId, function(r){
                vm.user = r.user;
                vm.user.password = null;

                // 选中地区下拉列表
                $("#distpicker2").distpicker({
                    province: vm.user.province,
                    city: vm.user.city,
                    district: vm.user.district
                });
                //vm.getDept();
            });
        },
        getRoleList: function(){
            $.get(baseURL + "sys/role/select", function(r){
                vm.roleList = r.list;
            });
        },
        deptTree: function(){
            // layer.open({
            //     type: 1,
            //     offset: '50px',
            //     skin: 'layui-layer-molv',
            //     title: "选择部门",
            //     area: ['300px', '450px'],
            //     shade: 0,
            //     shadeClose: false,
            //     content: jQuery("#deptLayer"),
            //     btn: ['确定', '取消'],
            //     btn1: function (index) {
            //         var node = ztree.getSelectedNodes();
            //         //选择上级部门
            //         vm.user.deptId = node[0].deptId;
            //         vm.user.deptName = node[0].name;
            //
            //         layer.close(index);
            //     }
            // });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
        }
    }
});