var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            name: null
		},
		showList: true,
		title: null,
        cateList:{
        	1:"准则层指标",
			2:"客户期望",
			3:"感知质量",
			4:"感知价值",
			5:"客户投诉",
			6:"客户忠诚度",
		},
        smallCateList:{},
        weightMatrixLists:{},
		approve: {},
        appdata:{}
	},
	methods: {
		query: function () {
			//vm.reload();
			vm.getInd(1);
		},

        // 保存权重矩阵
        saveWeightMatrix: function (event) {

            var cateAmounts = [];
            var isAllowPost = true;
            var focusInputId = "";

			// 是否有未填的
            $("[name='inputCate']").each(function(index,element){
            	if ($(this).val() == ""){
                    isAllowPost = false;
                    focusInputId = $(this).attr("id");
                    alert('请填写完所有分值再提交！', function(){
                        $("#"+focusInputId).focus();
                    });
                    return false;
				}else{
					// 右上侧的
                    cateAmounts.push( {
                        key : $(this).attr("cate_x_y"),
                        value : $(this).val(),
                        bigCateId : $("#cate").val()
                    });

                    var item = {};
                    item.key = $(this).attr("cate_y_x");
                    item.value = "1/"+$(this).val();
                    if($(this).val().split('/').length > 1){
                        item.value = $(this).val().split('/')[1];
                    }
                    item.bigCateId = $("#cate").val();
                    cateAmounts.push(item);

				}
            });

            // 中间斜线，指标为 1 的
            if (isAllowPost){
                $("[name='hideCate']").each(function(index,element){
                    cateAmounts.push( {
                        key : $(this).attr("cate_x_x"),
                        value : 1,
                        bigCateId : $("#cate").val()
                    });
                });
            }

            if (isAllowPost){
                var url = "pm/approve/saveweight";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(cateAmounts),
                    success: function(r){
                        if(r.code === 0){
                            alert('权重保存成功！', function(index){

                            });
                        }else {
                            alert(r.msg);
                        }
                    }
                });
			}

		},
		getInfo: function(id){
            $.get(baseURL + "pm/approve/info/"+id, function(r){
                vm.approve = r.approve;
            });
		},
        getSmallCate: function () {
			var id = $("#cate").val();
			// 清空值
			//$("[name='spanCate']").html("");
			$("[name='inputCate']").val("");

            $.get(baseURL + "pm/approve/getsmallcate/"+id, function(r){
                vm.smallCateList = r.smallTypes;
                vm.weightMatrixLists = r.lists;
            });


        },
        // 动态生成 控件id
        getControlId: function (name, rowIndex, colIndex) {
			if (name == ""){
				return rowIndex + "_" + colIndex;
			}
            return name + "_" + rowIndex + "_" + colIndex;
        },
        // 根据右上角输入框 计算 左下角指标值
        calLeftBottom: function (obj) {
			var value = $(obj).val();
            var labelId = $(obj).attr("cate_x_y");

            if((/^(\+|-)?\d+$/.test( value )) && value>0 && value<10){
                $("#label_"+labelId).html("1/"+value);
            }else if(value.split('/').length > 1 && (/^(\+|-)?\d+$/.test( value.split('/')[1] )) && value.split('/')[1]>0 && value.split('/')[1]<10){
                // 分数，且分母是整数
                $("#label_"+labelId).html(value.split('/')[1]);
			}else{
                $(obj).val("");
                $("#label_"+labelId).html("");
                $(obj).focus();
                return false;
            }

        },
        // 清空数据
        clearData : function () {
            //$("[name='spanCate']").html("");
            $("[name='inputCate']").val("");
            // 重新计算左侧的值
            $("[name='inputCate']").each(function(index,element){
                vm.calLeftBottom($(this));
            });
        },
        saveInfo : function () {
            var url = "pm/approve/save";
            vm.appdata.token = localStorage.getItem("token");
            vm.appdata.sendDate = $("#startTimeAlarm").val();
            vm.appdata.recycleDate = $("#endTimeAlarm").val();

            // 有效性较验
            vm.appdata.title = $.trim(vm.appdata.title);
            vm.appdata.scope = $.trim(vm.appdata.scope);
            vm.appdata.sendAmount = $.trim(vm.appdata.sendAmount);
            vm.appdata.recycleAmount = $.trim(vm.appdata.recycleAmount);
            vm.appdata.initiator = $.trim(vm.appdata.initiator);
            vm.appdata.executor = $.trim(vm.appdata.executor);
            vm.appdata.remark = $.trim(vm.appdata.remark);

            if (vm.appdata.title == ""){
                alert('请填写调研标题！', function(){
                    $("[name='title']").focus();
                });
                return false;
            }else if (vm.appdata.scope == ""){
                alert('请填写问卷范围！', function(){
                    $("[name='scope']").focus();
                });
                return false;
            }else if (vm.appdata.sendAmount == ""){
                alert('请填写问卷发放数量！', function(){
                    $("[name='sendAmount']").focus();
                });
                return false;
            }else if (!(/^(\+|-)?\d+$/.test( vm.appdata.sendAmount )) || vm.appdata.sendAmount <=0){
                alert('问卷发放数量不正确！', function(){
                    $("[name='sendAmount']").focus();
                });
                return false;
            }else if (vm.appdata.recycleAmount == ""){
                alert('请填写问卷回收数量！', function(){
                    $("[name='recycleAmount']").focus();
                });
                return false;
            }else if (!(/^(\+|-)?\d+$/.test( vm.appdata.recycleAmount )) || vm.appdata.recycleAmount <=0){
                alert('问卷回收数量不正确！', function(){
                    $("[name='recycleAmount']").focus();
                });
                return false;
            }

            $("#uploadInfo").val("上传与保存中，请勿关闭本页面！");
            $("#uploadInfo").attr("disabled", true);

            $.ajaxFileUpload({
                type: "POST",
                url: baseURL + url,
                fileElementId: 'file',
                data:vm.appdata,
                dataType:'text',
                success: function(r){
                    r = JSON.parse(r);
                    if(r.code === 0){
                        $("#uploadInfo").val("上传成功，请您十分钟后查看计算结果！");
                    }else{

                        alert(r.msg, function(){
                            $("#uploadInfo").val("上传");
                            $("#uploadInfo").attr("disabled", false);
                        });

                    }
                },
                complete:function(r){

                }
            });
        }
	}
});

// 页面加载时执行
vm.getSmallCate();


// 日历相关js
$(document).ready(function ($) {

    $("#endTimeAlarm").unbind("click").bind("click", function () {
        WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTimeAlarm\')||\'%y-%M-%d\'}',onpicked: changeWdatePicker  })
    });
});

function startTimeVal(){
    if("" != $("#startTimeAlarm").val()){
        $("#startTimeAlarm").removeClass("errorDateInput");
    }else{
        if("" == $("#endTimeAlarm").val() && $("#show_one_btns .cur").length !=0){
            $("#startTimeAlarm").removeClass("errorDateInput");
            return;
        }
        $("#startTimeAlarm").addClass("errorDateInput");
    }

}
function endTimeVal(){
    if("" != $("#endTimeAlarm").val()){
        $("#endTimeAlarm").removeClass("errorDateInput");
    }else{
        if("" != $("#startTimeAlarm").val() && $("#show_one_btns .cur").length ==0){
            $("#endTimeAlarm").addClass("errorDateInput");
            return;
        }
        $("#endTimeAlarm").removeClass("errorDateInput");
    }

}
function changeWdatePicker(){
    //searchForm(thisPin, 1);
}