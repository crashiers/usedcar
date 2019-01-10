$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/approveresult/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
			{ label: '基础信息ID', name: 'infoId', index: 'info_id', width: 6*10+20 },
			{ label: '满意度总分', name: 'approveAmount', index: 'approve_amount', width: 5*10+20 }, 			
			{ label: '客户期望', name: 'approveAmount1', index: 'approve_amount1', width: 4*10+20 }, 			
			{ label: '感知质量', name: 'approveAmount2', index: 'approve_amount2', width: 4*10+20 }, 			
			{ label: '感知价值', name: 'approveAmount3', index: 'approve_amount3', width: 4*10+20 },
			{ label: '客户投诉', name: 'approveAmount4', index: 'approve_amount4', width: 4*10+20 }, 			
			{ label: '客户忠诚', name: 'approveAmount5', index: 'approve_amount5', width: 4*10+20 }, 			
			{ label: '日期', name: 'createDate', index: 'create_date', width: 2*10+20 }, 			
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
            name: null
		},
		showList: true,
		title: null,
		approveResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		},
        del: function (event) {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "pm/approveresult/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
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
        back: function () {
            history.go(-1);
        }
	}
});