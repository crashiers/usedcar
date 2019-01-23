$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/dr/list',
        // 只加载本地数据，也就是不向服务器发送请求
        datatype: "local",
        colModel: [
            { label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
            { label: '年月', name: 'yearMonth', index: 'year_month', width: 4*10+20 },
            { label: '建卡量', name: 'createdAmount', index: 'created_amount', width: 2*10+20 },
            { label: 'DCC量', name: 'dccAmount', index: 'dcc_amount', width: 2*10+20 },
            { label: '总量', name: 'allAmount', index: 'all_amount', width: 2*10+20 },
            { label: '零售', name: 'retailAmount', index: 'retail_amount', width: 2*10+20 },
            { label: '二网', name: 'twoNetAmount', index: 'two_net_amount', width: 2*10+20 },
            { label: '大客户', name: 'bigClientAmount', index: 'big_client_amount', width: 3*10+20 },
            { label: '置换潜客量', name: 'latentAmount', index: 'latent_amount', width: 2*10+20 },
            { label: '潜客评估量', name: 'latentAssessAmount', index: 'latent_assess_amount', width: 2*10+20 },
            { label: '评估成交量', name: 'latentAssessDealAmount', index: 'latent_assess_deal_amount', width: 2*10+20 },
            { label: '置换潜客率', name: 'latentRate', index: 'latent_rate', width: 5*10+20, formatter: function(value, options, row){
                return value >= 0 ? value + "%" : '';
            } },
            { label: '潜客评估率', name: 'latentAssessRate', index: 'latent_assess_rate', width: 5*10+20 , formatter: function(value, options, row){
                return value >= 0 ? value + "%" : '';
            } },
            { label: '评估成交率', name: 'latentAssessDealRate', index: 'latent_assess_deal_rate', width: 5*10+20, formatter: function(value, options, row){
                return value >= 0 ? value + "%" : '';
            }  },
            { label: '广义置换率', name: 'generalizedRate', index: 'generalized_rate', width: 5*10+20, formatter: function(value, options, row){
                return value >= 0 ? value + "%" : '';
            }  },
            { label: '狭义置换率', name: 'narrowlyRate', index: 'narrowly_rate', width: 5*10+20, formatter: function(value, options, row){
                return value >= 0 ? value + "%" : '';
            }  },
            { label: '零售建卡量', name: 'sellCreatedAmount', index: 'sell_created_amount', width: 4*10+20 },
            { label: '零售成交量', name: 'sellDealAmount', index: 'sell_deal_amount', width: 4*10+20 },
            { label: '转化率', name: 'sellDealRate', index: 'sell_deal_rate', width: 3*10+20, formatter: function(value, options, row){
                return value >= 0 ? value + "%" : '';
            }  },
            { label: '添加日期', name: 'createDate', index: 'create_date', width: 4*10+20, hidden:true }
        ],
        viewrecords: true,
        height: 'auto',
        //height: 385,
        rowNum: 100,
        rowList : [50,100,200],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
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
            name: null,
            startMonthVal: getPreYearMonth(),
            endMonthVal: getThisMonth(),
        },
        showList: true,
        showAdd: false,
        showUpload: false,
        showUploadAmount1: false,
        showUploadAmount2: false,
        showUpdateAmount: false,
        title: null,
        dr: {},
        flag: true,
        dealerId: 0,
        dealerLists: null,
        dealer: {},
        brandId: 0,
        brandLists: null,
        smallBrandLists: null,
        yearMonthLists: null,
        amountDataLists1: [],
        amountDataLists2: [],
        allAmountDataLists1: [],
        allAmountDataLists2: [],
        updateAmountData: {}
    },
    methods: {
        query: function () {
            // 看日期是否在一年之内
            var timeslong = getDate($("#endMonth").val()).getTime() - getDate($("#startMonth").val()).getTime();
            var days = timeslong/(1000*60*60*24);
            if (days > 365){
                alert("查询日期相隔不能超过一年！");
                return;
            }

            vm.q.startMonthVal = $("#startMonth").val();
            vm.q.endMonthVal = $("#endMonth").val();

            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.showAdd = true;
            vm.showUpload = false;
            vm.showUploadAmount1 = false;
            vm.showUploadAmount2 = false;
            vm.showUpdateAmount = false;
            vm.title = "新增";
            vm.dr = {};
            $("#startTimeAlarm").val("");
        },
        upload: function(){
            vm.showList = false;
            vm.showAdd = false;
            vm.showUpload = true;
            vm.showUploadAmount1 = false;
            vm.showUploadAmount2 = false;
            vm.showUpdateAmount = false;
            vm.title = "导入";
            vm.dr = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if(id == null || id == false){
                return ;
            }
            vm.showList = false;
            vm.showAdd = true;
            vm.showUpload = false;
            vm.showUploadAmount1 = false;
            vm.showUploadAmount2 = false;
            vm.showUpdateAmount = false;
            vm.title = "修改";

            vm.getInfo(id);
        },
        saveOrUpdate: function (event) {
            vm.dr.yearMonth = $("#startTimeAlarm").val();
            vm.dr.dealerId = vm.dealerId;
            var url = vm.dr.id == null ? "pm/dr/save" : "pm/dr/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.dr),
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
            var buttonObj = event.currentTarget;
            buttonObj.disabled = true;
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            var url = "pm/dr/upload?dealerId="+vm.dealerId;
            $.ajaxFileUpload({
                type: "POST",
                url: baseURL + url,
                fileElementId: 'file',
                data: {'token':localStorage.getItem("token")},
                success: function(r){
                    buttonObj.disabled = false;
                    $("#file").val("");
                    if(r.code === 0){
                        alert('已成功导入', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                },
                complete:function(r){
                    buttonObj.disabled = false;
                    $("#file").val("");
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
        upLoadFileAmount: function (event) {
            var atype = 1;
            var buttonObj = event.currentTarget;
            buttonObj.disabled = true;
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            if (vm.brandId == null){
                //return;
            }
            var url = "pm/dr/uploadamount?atype="+atype+"&dealerId="+vm.dealerId+"&brand="+vm.brandId;
            $.ajaxFileUpload({
                type: "POST",
                url: baseURL + url,
                fileElementId: 'file',
                data: {'token':localStorage.getItem("token")},
                success: function(r){
                    buttonObj.disabled = false;
                    $("#file").val("");
                    if(r.code === 0){
                        alert('已成功导入', function(index){
                            vm.getAmountAllLists();
                        });
                    }else{
                        alert(r.msg);
                    }
                },
                complete:function(r){
                    buttonObj.disabled = false;
                    $("#file").val("");
                    var _r = JSON.parse(r.responseText);
                    if(_r.code === 0){
                        alert('已成功导入', function(index){
                            vm.getAmountAllLists();
                        });
                    }else{
                        alert(_r.msg);
                    }
                }
            });
        },
        upLoadFileAmount2: function (event) {
            var atype = 2;
            var buttonObj = event.currentTarget;
            buttonObj.disabled = true;
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            if (vm.brandId == null){
                //return;
            }
            var url = "pm/dr/uploadamount?atype="+atype+"&dealerId="+vm.dealerId+"&brand="+vm.brandId;
            $.ajaxFileUpload({
                type: "POST",
                url: baseURL + url,
                fileElementId: 'file',
                data: {'token':localStorage.getItem("token")},
                success: function(r){
                    buttonObj.disabled = false;
                    $("#file").val("");
                    if(r.code === 0){
                        alert('已成功导入', function(index){
                            vm.getAmountAllLists();
                        });
                    }else{
                        alert(r.msg);
                    }
                },
                complete:function(r){
                    buttonObj.disabled = false;
                    $("#file").val("");
                    var _r = JSON.parse(r.responseText);
                    if(_r.code === 0){
                        alert('已成功导入', function(index){
                            vm.getAmountAllLists();
                        });
                    }else{
                        alert(_r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids.length == 1 && ids[0] < 1){
                alert("平均和合计行不允许删除！");
                return;
            }

            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "pm/dr/delete",
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
            $.get(baseURL + "pm/dr/info/"+id, function(r){
                vm.dr = r.dr;
                $("#startTimeAlarm").val(r.dr.yearMonth);
                vm.dealerId = r.dr.dealerId;
            });
        },
        reload: function (event) {
            vm.showList = true;
            vm.showAdd = false;
            vm.showUpload = false;
            vm.showUploadAmount1 = false;
            vm.showUploadAmount2 = false;
            vm.showUpdateAmount = false;
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();

            vm.q.startMonthVal = $("#startMonth").val();
            vm.q.endMonthVal = $("#endMonth").val();

            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name, dealerId: vm.dealerId, brand:vm.brandId, startMonth: vm.q.startMonthVal, endMonth: vm.q.endMonthVal},
                page:page,
                datatype: "json"
            }).trigger("reloadGrid");

            // 获取经销商的品牌
            vm.getDealerBrand();
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
                    layer.alert('请先添加经销商，再操作置换零售业务！', function(){
                        parent.location = "/default.html#modules/pm/dealer.html";
                    });
                }

            });
        },

        // 获取经销商的品牌
        getDealerBrand: function () {
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            $.get(baseURL + "pm/dealer/info/"+vm.dealerId, function(r){
                vm.dealer = r.dealer;
                vm.brandId = vm.dealer.brand;

                // 获取转换和零售数据
                vm.getAmountAllLists();

            });
        },

        // 获取置换和零售数据
        getAmountAllLists: function () {
            vm.showList = true;
            vm.showAdd = false;
            vm.showUpload = false;
            vm.showUploadAmount1 = false;
            vm.showUploadAmount2 = false;
            vm.showUpdateAmount = false;

            vm.amountDataLists1 = [];
            vm.amountDataLists2 = [];
            vm.getAmountLists(1);
            vm.getAmountLists(2);
        },

        // 数量 整体数据
        getAmountLists: function (atype) {
            //vm.brandId = $("#selectBrandId").val() == null ? vm.brandId : $("#selectBrandId").val();
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            $.get(baseURL + "pm/dr/getsmallcate/"+vm.brandId+"/"+atype+"/"+vm.dealerId+"/"+vm.q.startMonthVal+"/"+vm.q.endMonthVal, function(r){
                vm.smallBrandLists = r.smallBrandLists;
                vm.yearMonthLists = r.yearMonthLists;
                if (atype == 1){
                    vm.amountDataLists1 = r.amountDataLists;
                    // 计算总计
                    vm.allAmountDataLists1 = [];
                    vm.calSumAmount(1);
                }else{
                    vm.amountDataLists2 = r.amountDataLists;
                    // 计算总计
                    vm.allAmountDataLists2 = [];
                    vm.calSumAmount(2);
                }
            });
        },

        // 数量 汇总
        calSumAmount: function (atype) {
            //vm.brandId = $("#selectBrandId").val() == null ? vm.brandId : $("#selectBrandId").val();
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
            $.get(baseURL + "pm/dr/getsmallcateall/"+vm.brandId+"/"+atype+"/"+vm.dealerId+"/"+vm.q.startMonthVal+"/"+vm.q.endMonthVal, function(r){
                if (atype == 1){
                    vm.allAmountDataLists1 = r.allAmountLists;
                }else{
                    vm.allAmountDataLists2 = r.allAmountLists;
                }
            });
        },

        // 数量导入
        uploadAmount: function(atype){
            vm.showList = false;
            vm.showAdd = false;
            vm.showUpload = false;
            vm.showUpdateAmount = false;
            if (atype == 1){
                vm.showUploadAmount1 = true;
                vm.title = "每月各款新车的零售量";
            }else{
                vm.showUploadAmount2 = true;
                vm.title = "每月各款新车的置换量";
            }
            vm.dr = {};
        },

        // 按行修改数量
        updateRowAmount: function (arcticId, arcticName, atype, dataArr) {

            vm.showList = false;
            vm.showAdd = false;
            vm.showUpload = false;
            vm.showUploadAmount1 = false;
            vm.showUploadAmount2 = false;
            vm.showUpdateAmount = true;
            if (atype == 1){
                vm.title = "修改每月各款新车的零售量";
            }else{
                vm.title = "修改每月各款新车的置换量";
            }

            vm.updateAmountData.arcticId = arcticId;
            vm.updateAmountData.arcticName = arcticName;
            vm.updateAmountData.atype = atype;
            vm.updateAmountData.dataArr = dataArr;

        },

        // 保存数量
        saveAmount: function () {
            var url = "pm/dr/savedra";
            vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();

            // 遍历
            $("input[name='updateAmountAmount']").each(function(){

                var dataObj = {};
                dataObj.dealerId =vm.dealerId;
                dataObj.brand =vm.brandId;
                dataObj.arctic =$("#updateAmountArcticId").val();
                dataObj.atype =$("#updateAmountAtype").val();

                dataObj.amount = $(this).val();
                dataObj.yearMonth = $(this).attr("yearMonth");

                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(dataObj),
                    success: function(r){

                    }
                });

            });

            vm.reload();

        }

    }
});

// 获取经销商数据
vm.getDealerListData();


// 查看业务看板
function gotoBoard(obj) {
    vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
    vm.q.startMonthVal = $("#startMonth").val();
    vm.q.endMonthVal = $("#endMonth").val();
    //vm.brandId = $("#selectBrandId").val() == null ? vm.brandId : $("#selectBrandId").val();
    $(obj).attr("href", "/board?d="+vm.dealerId+"&b="+vm.brandId+"&token="+localStorage.getItem("token")+"&sm="+vm.q.startMonthVal+"&em="+vm.q.endMonthVal);
    return true;
}
function gotoAllBoard(obj) {
    vm.dealerId = $("#selectDealerId").val() == null ? vm.dealerId : $("#selectDealerId").val();
    $(obj).attr("href", "/board?d="+vm.dealerId+"&token="+localStorage.getItem("token"));
    return true;
}

