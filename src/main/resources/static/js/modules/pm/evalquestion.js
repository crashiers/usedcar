$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/evalquestion/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
			{ label: '序号', name: 'num', index: 'num', width: 15},
			{ label: '条目', name: 'title', index: 'title', width: 70 },
			{ label: '满分', name: 'fullScore', index: 'full_score', width: 15 },
			{ label: '评价方式', name: 'evaluateWay', index: 'evaluate_way', width: 50 },
			{ label: '评价方式分数百分比', name: 'evaluateWayScore', index: 'evaluate_way_score', width: 30 },
			{ label: '一级分类', name: 'category1', index: 'category1', width: 30 },
			{ label: '二级分类', name: 'category2', index: 'category2', width: 30 },
			{ label: '三级分类', name: 'category3', index: 'category3', width: 30 },
			{ label: '阶段', name: 'businessStage', index: 'business_stage', width: 15 },
			{ label: '层级', name: 'tier', index: 'tier', width: 20 },
			{ label: '添加日期', name: 'createDate', index: 'create_date', width: 30 },
        ],
		viewrecords: true,
        height: 'auto',
        //height: 385,
        rowNum: 50,
		rowList : [10,30,50],
        rownumbers: false,
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
		showAdd: false,
		title: null,
		evalQuestion: {}
	},
	methods: {
		query: function () {
            vm.showAdd = false;
			vm.reload();
		},
		add: function(){
            $("#distpicker4").distpicker({
                placeholder: false
            });
			vm.showList = false;
			vm.showAdd = true;
			vm.title = "新增";
			vm.evalQuestion = {};
		},
        upload: function(){
            vm.showList = false;
            vm.showAdd = false;
            vm.title = "导入";
            vm.evalQuestion = {};
        },
		update: function (event) {

			var id = getSelectedRow();
			if(id == null || id == false){
				return ;
			}
			vm.showList = false;
            vm.showAdd = true;
            vm.title = "修改";
            
            vm.getInfo(id);
		},
		saveOrUpdate: function (event) {

            vm.evalQuestion.category1 = $("#province1").val();
            vm.evalQuestion.category2 = $("#city1").val();
            vm.evalQuestion.category3 = $("#district1").val();

			var url = vm.evalQuestion.id == null ? "pm/evalquestion/save" : "pm/evalquestion/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.evalQuestion),
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
        upLoadFile: function (event) {
            var url = "pm/evalquestion/upload";


            $.ajaxFileUpload({
                type: "POST",
                url: baseURL + url,
                fileElementId: 'file',
                data: {'token':localStorage.getItem("token")},
                success: function(r){
                    if(r.code === 0){
                        alert('已成功导入', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                },
                complete:function(r){
                	var _r = JSON.parse(r.responseText);
                    if(_r.code === 0){
                        alert('已成功导入', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(_r.msg);
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
				    url: baseURL + "pm/evalquestion/delete",
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
			$.get(baseURL + "pm/evalquestion/info/"+id, function(r){
                vm.evalQuestion = r.evalQuestion;

                // 选中地区下拉列表
                $("#distpicker4").distpicker({
                    placeholder: false,
                    province: vm.evalQuestion.category1,
                    city: vm.evalQuestion.category2,
                    district: vm.evalQuestion.category3
                });
            });
		},
		reload: function (event) {
			vm.showList = true;
            vm.showAdd = false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		}
	}
});