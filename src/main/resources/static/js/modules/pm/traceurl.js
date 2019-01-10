$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/traceurl/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
			{ label: '申请人', name: 'createErp', index: 'create_erp', width: 3*10+20 },
			{ label: '部门', name: 'createThirdDep', index: 'create_third_dep', width: 3*10+20 },
			{ label: '生成的url', name: 'urlEnd', index: 'url_end' },
			{ label: '投放时间', name: 'putDate', index: 'put_date', width: 2*10+20 },
			{ label: '申请日期', name: 'createDate', index: 'create_date', width: 2*10+20 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
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
            keyword: null
		},
		showList: true,
		title: null,
		traceUrl: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.traceUrl = {};
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
			var url = vm.traceUrl.id == null ? "pm/traceurl/save" : "pm/traceurl/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.traceUrl),
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
				    url: baseURL + "pm/traceurl/delete",
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
			$.get(baseURL + "pm/traceurl/info/"+id, function(r){
                vm.traceUrl = r.traceUrl;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'keyword': vm.q.keyword},
                page:page
            }).trigger("reloadGrid");
		}
	}
});