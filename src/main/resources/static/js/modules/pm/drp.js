$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pm/drp/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 35, key: true, hidden: true },
			{ label: '经销商ID', name: 'dealerId', index: 'dealer_id', width: 5*10+20 }, 			
			{ label: '序号', name: 'num', index: 'num', width: 2*10+20 }, 			
			{ label: '入库号', name: 'rkdh', index: 'rkdh', width: 3*10+20 }, 			
			{ label: '品牌', name: 'brand', index: 'brand', width: 2*10+20 }, 			
			{ label: '车型', name: 'arctic', index: 'arctic', width: 2*10+20 }, 			
			{ label: '车款', name: 'carModel', index: 'car_model', width: 2*10+20 }, 			
			{ label: '颜色', name: 'color', index: 'color', width: 2*10+20 }, 			
			{ label: '表征里程', name: 'mileage', index: 'mileage', width: 4*10+20 }, 			
			{ label: '初登日期', name: 'firstDate', index: 'first_date', width: 4*10+20 }, 			
			{ label: '排量', name: 'displacement', index: 'displacement', width: 2*10+20 }, 			
			{ label: '变速箱', name: 'gearbox', index: 'gearbox', width: 3*10+20 }, 			
			{ label: '车架号', name: 'vin', index: 'vin', width: 3*10+20 }, 			
			{ label: '车况简述', name: 'remark', index: 'remark', width: 4*10+20 }, 			
			{ label: '收购类型:置换收购,直客收购,渠道收购,车辆寄售,内部转入', name: 'buyType', index: 'buy_type', width: 29*10+20 }, 			
			{ label: '收购客户来源:基盘客户挖掘,内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他', name: 'buyClientRef', index: 'buy_client_ref', width: 50*10+20 }, 			
			{ label: '收购单位', name: 'buyCompany', index: 'buy_company', width: 4*10+20 }, 			
			{ label: '推荐人', name: 'buyReferrer', index: 'buy_referrer', width: 3*10+20 }, 			
			{ label: '推荐人职务', name: 'buyReferrerDuty', index: 'buy_referrer_duty', width: 5*10+20 }, 			
			{ label: '收购人', name: 'buyer', index: 'buyer', width: 3*10+20 }, 			
			{ label: '旧车主姓名', name: 'rawCarOwner', index: 'raw_car_owner', width: 5*10+20 }, 			
			{ label: '联系电话', name: 'rawPhone', index: 'raw_phone', width: 4*10+20 }, 			
			{ label: '置换车型', name: 'permuteArctic', index: 'permute_arctic', width: 4*10+20 }, 			
			{ label: '收购日期', name: 'buyDate', index: 'buy_date', width: 4*10+20 }, 			
			{ label: '收购价格', name: 'buyPrice', index: 'buy_price', width: 4*10+20 }, 			
			{ label: '过户费用', name: 'buyTransferFee', index: 'buy_transfer_fee', width: 4*10+20 }, 			
			{ label: '其他收购成本', name: 'buyOtherFee', index: 'buy_other_fee', width: 6*10+20 }, 			
			{ label: '预期库存风险期（盈亏平衡点）', name: 'bep', index: 'bep', width: 14*10+20 }, 			
			{ label: '库位号', name: 'slNum', index: 'sl_num', width: 3*10+20 }, 			
			{ label: '上架销售时间', name: 'sellDate', index: 'sell_date', width: 6*10+20 }, 			
			{ label: '是否认证', name: 'isAuth', index: 'is_auth', width: 4*10+20 }, 			
			{ label: '整备费用', name: 'servicingCosts', index: 'servicing_costs', width: 4*10+20 }, 			
			{ label: '日常维护费用', name: 'upkeep', index: 'upkeep', width: 6*10+20 }, 			
			{ label: '验车费', name: 'checkFee', index: 'check_fee', width: 3*10+20 }, 			
			{ label: '购买交强险', name: 'sali', index: 'sali', width: 5*10+20 }, 			
			{ label: '库存时间', name: 'storeTime', index: 'store_time', width: 4*10+20 }, 			
			{ label: '是否超期', name: 'isExceed', index: 'is_exceed', width: 4*10+20 }, 			
			{ label: '批售起竞价/零售底价', name: 'minPrice', index: 'min_price', width: 10*10+20 }, 			
			{ label: '批售保留价/零售定价', name: 'sellPrice', index: 'sell_price', width: 10*10+20 }, 			
			{ label: '销售类型:内部转出,外部批售,零售,认证零售', name: 'sellType', index: 'sell_type', width: 22*10+20 }, 			
			{ label: '销售客户来源:内部全员营销,网络营销,自媒体营销,活动营销,展厅展场营销,转介绍,其他', name: 'sellClientRef', index: 'sell_client_ref', width: 43*10+20 }, 			
			{ label: '推荐人', name: 'sellReferrer', index: 'sell_referrer', width: 3*10+20 }, 			
			{ label: '推荐人职务', name: 'sellReferrerDuty', index: 'sell_referrer_duty', width: 5*10+20 }, 			
			{ label: '销售人', name: 'seller', index: 'seller', width: 3*10+20 }, 			
			{ label: '新车主名称', name: 'newCarOwner', index: 'new_car_owner', width: 5*10+20 }, 			
			{ label: '联系电话', name: 'newPhone', index: 'new_phone', width: 4*10+20 }, 			
			{ label: '批售渠道名称（零售不需要填写）', name: 'channel', index: 'channel', width: 15*10+20 }, 			
			{ label: '销售日期', name: 'sellDateFinal', index: 'sell_date_final', width: 4*10+20 }, 			
			{ label: '销售价格', name: 'sellPriceFinal', index: 'sell_price_final', width: 4*10+20 }, 			
			{ label: '付款方式', name: 'paymentType', index: 'payment_type', width: 4*10+20 }, 			
			{ label: '首付金额', name: 'paymentFirstMoney', index: 'payment_first_money', width: 4*10+20 }, 			
			{ label: '贷款金额', name: 'paymentLoanMoney', index: 'payment_loan_money', width: 4*10+20 }, 			
			{ label: '过户费用', name: 'transferFee', index: 'transfer_fee', width: 4*10+20 }, 			
			{ label: '其他销售成本', name: 'sellOtherFee', index: 'sell_other_fee', width: 6*10+20 }, 			
			{ label: '退商业险', name: 'rbr', index: 'rbr', width: 4*10+20 }, 			
			{ label: '金融手续费', name: 'fhc', index: 'fhc', width: 5*10+20 }, 			
			{ label: '保险利润', name: 'profitInsurance', index: 'profit_insurance', width: 4*10+20 }, 			
			{ label: '装饰利润', name: 'profitDecorative', index: 'profit_decorative', width: 4*10+20 }, 			
			{ label: '手续代办', name: 'formalitieCharge', index: 'formalitie_charge', width: 4*10+20 }, 			
			{ label: '厂家返利', name: 'rebate', index: 'rebate', width: 4*10+20 }, 			
			{ label: '其他', name: 'other', index: 'other', width: 2*10+20 }, 			
			{ label: '进销差毛利1', name: 'maori', index: 'maori', width: 6*10+20 }, 			
			{ label: '收购毛利率1', name: 'maoriRate', index: 'maori_rate', width: 6*10+20 }, 			
			{ label: '直接成本', name: 'directCost', index: 'direct_cost', width: 4*10+20 }, 			
			{ label: '毛利2', name: 'maori2', index: 'maori2', width: 3*10+20 }, 			
			{ label: '收购毛利率2', name: 'maoriRate2', index: 'maori_rate2', width: 6*10+20 }, 			
			{ label: '衍生收益', name: 'otherEarnings', index: 'other_earnings', width: 4*10+20 }, 			
			{ label: '厂家返利', name: 'rebate2', index: 'rebate2', width: 4*10+20 }, 			
			{ label: '综合毛利', name: 'synthesisMaori', index: 'synthesis_maori', width: 4*10+20 }, 			
			{ label: '收购年', name: 'buyYear', index: 'buy_year', width: 3*10+20 }, 			
			{ label: '收购月', name: 'buyMonth', index: 'buy_month', width: 3*10+20 }, 			
			{ label: '销售年', name: 'sellYear', index: 'sell_year', width: 3*10+20 }, 			
			{ label: '销售月', name: 'sellMonth', index: 'sell_month', width: 3*10+20 }, 			
			{ label: '收购方式(采购来源=1)', name: 'buyWay', index: 'buy_way', width: 12*10+20 }, 			
			{ label: '销售方式(零售=0，认证零售=1)', name: 'sellWay', index: 'sell_way', width: 17*10+20 }, 			
			{ label: '销售方式2', name: 'sellWay2', index: 'sell_way2', width: 5*10+20 }, 			
			{ label: '车龄', name: 'carAge', index: 'car_age', width: 2*10+20 }, 			
			{ label: '车龄阶梯', name: 'carAgeLeavel', index: 'car_age_leavel', width: 4*10+20 }, 			
			{ label: '收车价格阶梯', name: 'buyPriceLeavel', index: 'buy_price_leavel', width: 6*10+20 },
			{ label: '是否库存', name: 'isStore', index: 'is_store', width: 4*10+20 }, 			
			{ label: '添加日期', name: 'createDate', index: 'create_date', width: 4*10+20 }, 			
			{ label: '添加时间', name: 'createDatetime', index: 'create_datetime', width: 4*10+20 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
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
        showAdd: false,
        showUpload: false,
		title: null,
		drp: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
            vm.showAdd = true;
            vm.showUpload = false;
			vm.title = "新增";
			vm.drp = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null || id == false){
				return ;
			}
            vm.showList = false;
            vm.showAdd = true;
            vm.showUpload = false;
            vm.title = "修改";
            
            vm.getInfo(id);
		},
        upload: function(){
            vm.showList = false;
            vm.showAdd = false;
            vm.showUpload = true;
            vm.title = "导入";
            vm.drp = {};
        },
		saveOrUpdate: function (event) {
			var url = vm.drp.id == null ? "pm/drp/save" : "pm/drp/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.drp),
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
            event.currentTarget.disabled = true;
            var url = "pm/drp/upload";
            $.ajaxFileUpload({
                type: "POST",
                url: baseURL + url,
                fileElementId: 'file',
                data: {'token':localStorage.getItem("token")},
                success: function(r){
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
                    event.currentTarget.disabled = false;
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
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pm/drp/delete",
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
			$.get(baseURL + "pm/drp/info/"+id, function(r){
                vm.drp = r.drp;
            });
		},
		reload: function (event) {
			vm.showList = true;
            vm.showAdd = false;
            vm.showUpload = false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		}
	}
});