$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/evalquestion/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
			{ label: '题目', name: 'title', index: 'title', width: 200 },
            { label: '编号', name: 'num', index: 'num', width: 0, hidden: true },
            { label: '答案', name: 'evaluateWay', index: 'evaluate_way', width: 300, title:false, formatter: function(value, options, row){
				var str = '';
        		var answerList = value.split(",");
                for ( var i = 0; i < answerList.length; i++ ){
                    if (answerList[i] == ""){
                    	continue;
					}
					// 样式1
                    str += '<label>';
                    str += '<input type="radio" name="answer_'+row.num+'" class="a-radio"value="'+answerList[i]+'">';
                    str += '<span class="b-radio"></span>'+answerList[i];
                    str += '</label>';
                    
                    // 样式2
                    // str += '<label for="man" class="radio">';
                    // str += '<span class="radio-bg"></span>';
                    // str += '<input type="radio" name="answer_'+row.num+'" value="'+answerList[i]+'" /> '+answerList[i];
                    // str += '<span class="radio-on"></span>';
                    // str += '</label>';

                    //str += '<div class="checkbox-inline" style="margin-left: 0px; margin-right:10px;"><input type="radio" class="answer_radio" name="answer_'+row.num+'" value="'+answerList[i]+'"/>'+answerList[i]+'</div>';
                }
        		return str;
            }}
        ],
		viewrecords: true,
        height: 'auto',
        rowNum: 1000,
		rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 35,
        autowidth:true,
        multiselect: false,
        //pager: "#jqGridPager",
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
		evalResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.evalResult = {};
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
			var url = vm.evalResult.id == null ? "pm/evalresult/save" : "pm/evalresult/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.evalResult),
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
				    url: baseURL + "pm/evalresult/delete",
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
			$.get(baseURL + "pm/evalresult/info/"+id, function(r){
                vm.evalResult = r.evalResult;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		}
	}
});