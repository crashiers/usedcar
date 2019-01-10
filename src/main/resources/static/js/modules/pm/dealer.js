$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/dealer/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
			{ label: '名称', name: 'title', index: 'title', width: 2*10+20 },
            { label: '省', name: 'province', index: 'province', width: 1*10+20 , hidden: true},
            { label: '市', name: 'city', index: 'city', width: 1*10+20 , hidden: true},
            { label: '区', name: 'district', index: 'district', width: 1*10+20 , hidden: true},
            { label: '地址', name: 'address', index: 'address', width: 120, formatter: function(value, options, row){
                return row.province+row.city+row.district+ row.address;
            }},
			{ label: '联系人', name: 'relname', index: 'relname', width: 3*10+20 }, 			
			{ label: '联系电话', name: 'tel', index: 'tel', width: 4*10+20 }, 			
			{ label: '邮箱', name: 'email', index: 'email', width: 2*10+20 , hidden: true},
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 3*10+20 , hidden: true},
			{ label: '品牌', name: 'brandname', index: 'brandname', width: 40 },
			{ label: '添加日期', name: 'createDate', index: 'create_date', width: 4*10+20 }, 			
			{ label: '添加时间', name: 'createDatetime', index: 'create_datetime', width: 4*10+20, hidden: true }
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

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            name: null
		},
		showList: true,
		title: null,
        brandId: 0,
        brandLists: null,
		dealer: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dealer = {};

            // 获取品牌数据
            vm.getBrandListData();
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null || id == false){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id);
		},
		saveOrUpdate: function (event) {
			var url = vm.dealer.id == null ? "pm/dealer/save" : "pm/dealer/update";
            vm.dealer.province = $("#province1").val();
            vm.dealer.city = $("#city1").val();
            vm.dealer.district = $("#district1").val();
            vm.dealer.brand = $("#selectBrand").val();
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dealer),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pm/dealer/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "pm/dealer/info/"+id, function(r){
                vm.dealer = r.dealer;

                // 选中地区下拉列表
                $("#distpicker2").distpicker({
                    placeholder: false,
                    province: vm.dealer.province,
                    city: vm.dealer.city,
                    district: vm.dealer.district
                });

                // 获取品牌数据
                vm.getBrandListData();

            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		},

		// 品牌下拉列表
        getBrandListData: function () {
            $.get(baseURL + "pm/basicdata/list3/brand", function(lists){
                vm.brandLists = lists.length == 0 ? null : lists;
                console.log(vm.dealer.brand);
                $("#selectBrand").val(vm.brandLists[0].id);
                if (vm.dealer.brand != null){
                    $("#selectBrand").val(vm.dealer.brand);
				}
            });
        }
	}
});

