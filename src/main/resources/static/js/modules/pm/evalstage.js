// 有管理权限
if (hasPermission('pm:evalstage:manager')){

    $(function () {
        $("#jqGrid").jqGrid({
            url: baseURL + 'pm/evalstage/listall',
            datatype: "json",
            colModel: [
                { label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
                { label: '评测记录', name: 'stageNum', index: 'stage_num', width: 60, hidden: true},
                { label: '评测记录', name: '', index: 'stage_num', width: 60, formatter: function(value, options, row){
                    return '<a href="/report?n='+row.stageNum+'&token='+localStorage.getItem("token")+'" target="_blank">'+row.stageNum+'</a>';
                }},
                { label: '经销商', name: 'dealerName', index: 'dealer_name', width: 105 },
                { label: '提交时间', name: 'createDatetime', index: 'create_datetime', width: 65 },
                { label: '评测人', name: 'createAdmin', index: 'create_admin', width: 40 },
                { label: '规划分', name: 'score1', index: 'score1', width: 30 },
                { label: '运营分', name: 'score2', index: 'score2', width: 30 },
                { label: '推广分', name: 'score3', index: 'score3', width: 30 },
                { label: '执行分', name: 'score4', index: 'score4', width: 30 },
                { label: '置换分', name: 'score5', index: 'score5', width: 30 },
                { label: '零售分', name: 'score6', index: 'score6', width: 30 },
                { label: '管理分', name: 'score7', index: 'score7', width: 30 },
                { label: '运营分', name: 'score8', index: 'score8', width: 30 },
                { label: '执行分', name: 'score9', index: 'score9', width: 30 }
            ],
            viewrecords: true,
            height: 'auto',
            //height: 385,
            rowNum: 50,
            rowList : [50,100,200],
            rownumbers: true,
            rownumWidth: 25,
            autowidth:true,
            multiselect: true,//复选框列不显示 false
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
}
else
{
    $(function () {
        $("#jqGrid").jqGrid({
            url: baseURL + 'pm/evalstage/list',
            datatype: "json",
            colModel: [
                { label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
                { label: '评测记录', name: 'stageNum', index: 'stage_num', width: 60, hidden: true},
                { label: '评测记录', name: '', index: 'stage_num', width: 60, formatter: function(value, options, row){
                    return '<a href="/report?n='+row.stageNum+'&token='+localStorage.getItem("token")+'" target="_blank">'+row.stageNum+'</a>';
                }},
                { label: '经销商', name: 'dealerName', index: 'dealer_name', width: 105 },
                { label: '提交时间', name: 'createDatetime', index: 'create_datetime', width: 65 },
                { label: '规划分', name: 'score1', index: 'score1', width: 30 },
                { label: '运营分', name: 'score2', index: 'score2', width: 30 },
                { label: '推广分', name: 'score3', index: 'score3', width: 30 },
                { label: '执行分', name: 'score4', index: 'score4', width: 30 },
                { label: '置换分', name: 'score5', index: 'score5', width: 30 },
                { label: '零售分', name: 'score6', index: 'score6', width: 30 },
                { label: '管理分', name: 'score7', index: 'score7', width: 30 },
                { label: '运营分', name: 'score8', index: 'score8', width: 30 },
                { label: '执行分', name: 'score9', index: 'score9', width: 30 }
            ],
            viewrecords: true,
            height: 'auto',
            //height: 385,
            rowNum: 50,
            rowList : [50,100,200],
            rownumbers: false,
            rownumWidth: 25,
            autowidth:true,
            multiselect: true,//复选框列不显示 false
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
}

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title: null,
        dealerId: 0,
        dealerLists: null,
        evalStage: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.evalStage = {};
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
            var url = vm.evalStage.id == null ? "pm/evalstage/save" : "pm/evalstage/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.evalStage),
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
                    url: baseURL + "pm/evalstage/delete",
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
            $.get(baseURL + "pm/evalstage/info/"+id, function(r){
                vm.evalStage = r.evalStage;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name, 'dealerId':vm.dealerId},
                page:page
            }).trigger("reloadGrid");
        },

        // 参加评测
        startEval: function(){
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            if ($("#selectDealerId").val() == null || $("#selectDealerId").val() == "0"){
                alert("请先选择经销商，才能参加评测！");
                return;
            }
            self.location = "evalresult.html?dealerId="+vm.dealerId;
        },

        // 经销商下拉列表
        getDealerListData: function () {
            $.get(baseURL + "pm/dealer/list?sidx=id&order=asc", function(r){
                var lists = r.page.list;
                vm.dealerLists = lists.length == 0 ? null : lists;
                if (lists.length > 0){
                    vm.dealerId = vm.dealerLists[0].id;
                    vm.reload();
                }else{
                    layer.alert('请先添加经销商，再使用评测系统！', function(){
                        parent.location = "/default.html#modules/pm/dealer.html";
                    });
                }

            });
        }


    }
});

// 批量查看报告
function gotoReport(obj) {
    var grid = $("#jqGrid");
    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length == 0){
        alert("请最少选择一条评测记录查看报告！");
        return false;
    }
    if (selectedIDs.length > 3){
        alert("最多同时选择三条评测记录查看报告！");
        return false;
    }
    var numbers = [];
    for (var i=0;i<selectedIDs.length;i++){
        var rowData = $("#jqGrid").jqGrid('getRowData', selectedIDs[i]);
        numbers.push(rowData.stageNum);
    }
    var numberStr = numbers.join(',');
    $(obj).attr("href", "/report?n="+numberStr+"&token="+localStorage.getItem("token"));

    return true;
}

// 获取经销商数据
vm.getDealerListData();