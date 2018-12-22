$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/evalquestion/list2?sidx=num&order=asc',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 45, key: true, hidden: true },
			{ label: '题目', name: 'title', index: 'title', width: 200 },
            { label: '编号', name: 'num', index: 'num', width: 0, hidden: true },
            { label: '已答', name: 'answer', index: 'answer', width: 0, hidden: true },
            { label: '答案', name: 'evaluateWay', index: 'evaluate_way', width: 250, title:false, formatter: function(value, options, row){
				var str = '';
        		var answerList = value.split(",");
                for ( var i = 0; i < answerList.length; i++ ){
                    if (answerList[i] == ""){
                    	continue;
					}
                    str += '<label>';
                    str += '<input type="radio" name="answer_'+row.num+'" class="a-radio" onclick="clickRadio(this)" rn="'+row.num+'" value="'+answerList[i]+'"';
                    if (row.answer == answerList[i]){
                        str += ' checked';
                    }
                    str += '/>';
                    str += '<span class="b-radio"></span>'+answerList[i];
                    str += '</label>';
                }
        		return str;
            }}
        ],
		viewrecords: true,
        height: 'auto',
		//height: $(window).height() - 100,
        rowNum: 1000,
		rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 50,
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
        },
        loadComplete: function () {
            //debugger;
            //在表格加载完成后执行
            var ids = $("#jqGrid").jqGrid("getDataIDs");//获取所有行的id
            var rowDatas = $("#jqGrid").jqGrid("getRowData");//获取所有行的数据
            for (var ii = 0; ii < rowDatas.length; ii++) {
                var rowData = rowDatas[ii];
                if (rowData.num == 235) {//如果某一行中的“tax”为0，那就把这一整行的背景颜色设为红色
                    //$("#" + ids[ii] + " td").css("background-color", "red");
                }
            }
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            name: null,
            type1: null,
            type2: null,
            type3: null
		},
		showList: true,
		title: null,
		evalResult: {},
        menu:{
            oneDatas: null,
            twoDatas: null,
            threeDatas: null
        }
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

            var url = "pm/evalresult/update";
            var data = "";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                data: data,
                dataType: "json",
			    success: function(r){
			    	if(r.code === 0){
						alert('提交成功！', function(index){
                            //parent.location = "/default.html#modules/pm/evalstage.html";
                            parent.location.reload();
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
                postData:{'name': vm.q.name, 'type1':vm.q.type1, 'type2':vm.q.type2, 'type3':vm.q.type3, 'sid':'num', 'order':'asc'},
                page:page
            }).trigger("reloadGrid");
		},

        // 下面的所有方法 是用来实现菜单栏目的
        getMenuData: function () {
            $.get(baseURL + "pm/basicdata/list2/board", function(lists){
                vm.menu.oneDatas = lists.length == 0 ? null : lists;
                vm.reload();
            });
        },

        // 下面的所有方法 是用来实现菜单栏目的
        getMenuData2: function () {
            $.get(baseURL + "pm/basicdata/list2/board", function(lists){
                vm.menu.oneDatas = lists.length == 0 ? null : lists;
            });
        },

        // 清空一级，也就是选中了全部一级
        clearOneType: function () {
            vm.q.type1 = null;
            vm.q.type2 = null;
            vm.q.type3 = null;
            vm.menu.twoDatas = null;
            vm.menu.threeDatas = null;
            vm.q.mtype = null;
            vm.reload();
        },
        // 获取二级三级栏目 数据
        getChildMenuData: function (parentId, leavel) {

            // 相等，说明是取消选中
            if(leavel == 4 && vm.q.type3 == parentId){
                vm.clearThreeType();
                return;
            }
            if(leavel == 3 && vm.q.type2 == parentId){
                vm.clearTwoType();
                return;
            }
            if(leavel == 2 && vm.q.type1 == parentId){
                vm.clearOneType();
                return;
            }


            vm.q.mtype = parentId;

            // 代表最后一级，此时点击不需要再去取下一级的内容，可以直接返回
            if (leavel == 4){
                vm.q.type3 = parentId;
                vm.reload();
                return;
            }

            $.get(baseURL + "pm/basicdata/list2/getchild/"+parentId+"/leavel/"+leavel, function(lists){
                if (leavel == 2){
                    vm.menu.twoDatas = lists.length == 0 ? null : lists;
                    vm.q.type1 = parentId;
                    vm.q.type2 = null;
                    vm.q.type3 = null;
                    vm.menu.threeDatas = null;
                }

                else if (leavel == 3){
                    vm.menu.threeDatas = lists.length == 0 ? null : lists;
                    vm.q.type2 = parentId;
                    vm.q.type3 = null;
                }
                vm.reload();
            });
        },

        // 获取二级三级栏目 数据
        getChildMenuData2: function (parentId, leavel) {
            $.get(baseURL + "pm/basicdata/list2/getchild/"+parentId+"/leavel/"+leavel, function(lists){
                if (leavel == 2){
                    vm.menu.twoDatas = lists.length == 0 ? null : lists;
                }

                else if (leavel == 3){
                    vm.menu.threeDatas = lists.length == 0 ? null : lists;
                }
            });
        },
        // 清空二级，也就是选中了全部二级
        clearTwoType: function () {
            vm.q.type2 = null;
            vm.q.type3 = null;
            vm.menu.threeDatas = null;
            vm.q.mtype = vm.q.type1;
            vm.reload();
        },
        // 清空三级，也就是选中了全部三级
        clearThreeType: function () {
            vm.q.type3 = null;
            vm.q.mtype = vm.q.type2;
            vm.reload();
        },
        // 获取单条栏目信息
        getMenuInfo: function(id){
            $.get(baseURL + "pm/basicdata/info/"+id, function(r){
                vm.html.title = r.basicData.name;
            });
        }
	}
});


// 获取栏目数据
vm.getMenuData();


// 单选框点击事件
function clickRadio(obj) {

	var rn = $(obj).attr("rn");
	var an = $(obj).val();
    var data = "rn="+rn+"&an="+an;

    var url = "pm/evalresult/save";
    $.ajax({
        type: "POST",
        url: baseURL + url,
        data: data,
        dataType: "json",
        success: function(r){
            vm.getMenuData2();
            if (vm.q.type1 != null) {
                vm.getChildMenuData2(vm.q.type1, 2);
            }
            if (vm.q.type2 != null) {
                vm.getChildMenuData2(vm.q.type2, 3);
            }
        }
    });
}