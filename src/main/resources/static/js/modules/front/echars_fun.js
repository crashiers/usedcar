// 颜色数组
var colors = ['#ab78ba', '#08a9f2', '#72b201', '#f8a761', '#8fed7c', '#80ebbf', '#8085ea', '#91c7ae', '#749f83', '#ca8622', '#bda29a', '#d9534f', '#5bc0de', '#92ebe1'];
//var colors = ['#66b7f0', '#66d9f1', '#92ebe1', '#80ebbf', '#76df94', '#9fee94', '#dbf694', '#f9e351', '#749f83', '#ca8622', '#bda29a', '#434347'];


// 客流量报表展示
function clientFlowCharts(divId, chartsTitle, thisTitles, thisDatas, thisMax) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));
    dataAxis = thisTitles;
    data = thisDatas;
    var yMax = thisMax;
    var dataShadow = [];

    for (var i = 0; i < data.length; i++) {
        dataShadow.push(yMax);
    }

    option = {
        title: {
            text: chartsTitle
        },
        xAxis: {
            data: dataAxis,
            axisLabel: {
                inside: true,
                textStyle: {
                    color: '#fff'
                }
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            z: 10
        },
        yAxis: {
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#999'
                }
            }
        },
        dataZoom: [
            {
                type: 'inside'
            }
        ],
        series: [
            { // For shadow
                type: 'bar',
                itemStyle: {
                    normal: {color: 'rgba(0,0,0,0.05)'}
                },
                barGap:'-100%',
                barCategoryGap:'40%',
                data: dataShadow,
                animation: false
            },
            {
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#83bff6'},
                                {offset: 0.5, color: '#188df0'},
                                {offset: 1, color: '#188df0'}
                            ]
                        )
                    },
                    emphasis: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#2378f7'},
                                {offset: 0.7, color: '#2378f7'},
                                {offset: 1, color: '#83bff6'}
                            ]
                        )
                    }
                },
                data: data
            }
        ]
    };

    // Enable data zoom when user click bar.
    var zoomSize = 6;
    myChart.on('click', function (params) {
        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
        myChart.dispatchAction({
            type: 'dataZoom',
            startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
            endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
        });
    });

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

// 客流量报表展示效果2
function clientFlowCharts2(divId, chartsTitle, thisTitles, thisDatas) {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    var xAxisData = thisTitles;
    var data1 = thisDatas;

    option = {
        title: {
            text: chartsTitle
        },
        color: ['#188df0'],
        toolbox: {
            // y: 'bottom',
            feature: {
                magicType: {
                    type: ['stack', 'tiled']
                },
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                }
            }
        },
        tooltip: {},
        xAxis: {
            data: xAxisData,
            silent: false,
            splitLine: {
                show: false
            }
        },
        yAxis: {
        },
        series: [{
            name: '人数',
            type: 'bar',
            data: data1,
            animationDelay: function (idx) {
                return idx * 10;
            }
        }],
        animationEasing: 'elasticOut',
        animationDelayUpdate: function (idx) {
            return idx * 5;
        }
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}

// 折线图式的每日客流量
function getPointClientFlow(divId, chartsTitle, thisTitles, thisDatas) {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        title: {
            text: chartsTitle,
            subtext: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['']
        },
        // 离左右的距离，也就是边距
        grid: {
            left: '5%',
            right: '5%',
            bottom: '10%',
            containLabel: true
        },
        xAxis:  {
            type: 'category',
            boundaryGap: false,
            data: thisTitles
        },
        yAxis: {
            type: 'value',
            // axisLabel: {
            //     formatter: '{value} °C'
            // }
        },
        series: [
            {
                name:'客流量',
                type:'line',
                data:thisDatas,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}

// 顾客手机品牌
function phoneCharts(divId, chartsTitle, thisTitles, thisDatas) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        title: {
            text: chartsTitle
        },
        color: ['#188df0'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        // 离左右的距离，也就是边距
        grid: {
            left: '5%',
            right: '5%',
            bottom: '10%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : thisTitles,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'客流量',
                type:'bar',
                barWidth: '60%',
                data:thisDatas
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

// 每小时的客流量'各时段客流量'
function getPointHour(divId, chartsTitle, thisTitles, thisDatas, thisColor) {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        title: {
            text: chartsTitle,
            subtext: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['']
        },
        // 离左右的距离，也就是边距
        grid: {
            left: '5%',
            right: '5%',
            bottom: '10%',
            containLabel: true
        },
        xAxis:  {
            type: 'category',
            boundaryGap: false,
            data: thisTitles
        },
        yAxis: {
            type: 'value',
            // axisLabel: {
            //     formatter: '{value} °C'
            // }
        },
        series: [
            {
                name:'客流量',
                type:'line',
                data:thisDatas,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                }
            }
        ]
    };
    if (thisColor != ""){
        option.color = [thisColor];
    }

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}




// 兼容多y 轴 和 单 y轴的情况
function moreLineMoreY(divId, chartsTitle, thisTitles, thisDatas, thisCates, isShowCates, formatter, isStack, isArea, thisCatesColors, yDatas, thisCatesYs) {

    isShowCates = isShowCates || 1;
    formatter = formatter || '';
    // 是否叠加
    isStack = isStack || '';
    // 是一条线，还是一个面
    isArea = isArea || '';
    // 每个分类用哪种颜色
    thisCatesColors = thisCatesColors || '';
    // 多y 轴，这是每个轴的数据
    yDatas = yDatas || '';
    // 这是每个分类对应在哪条 y 轴上
    thisCatesYs = thisCatesYs || '';
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));
    myChart.clear();

    option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            left: '1%',
            right: '1%',
            bottom: '10%',
            top:'3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: thisTitles,
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    //color:'#ccc',
                    width:0,//轴线的粗细
                }
            }
        },
        yAxis: {
            type: 'value',
            // 不显示一条一条的横线
            splitLine:{show:false},
            // 显示整数
            minInterval: 1,
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    //color:'#ccc',
                    width:0,//轴线的粗细
                }
            }
        },
        series: []
    };

    if (yDatas != ''){
        option.yAxis = [];
        for (var k = 0, length = yDatas.length; k < length; k++) {
            var item = {
                type: 'value',
                name: yDatas[k].name,
                min: yDatas[k].min,
                max: yDatas[k].max,
                splitLine:{show:false},
                axisLabel: {
                    formatter: yDatas[k].formatter
                }
            };
            option.yAxis.push(item);
        }
        // 把x 轴显示出来
        option.xAxis.axisLine = {};
    }else{
        // 把x,y 轴显示出来
        option.xAxis.axisLine = {};
        option.yAxis.axisLine = {};
        // 把 背景中横线(参考线) 隐藏掉
        option.yAxis.splitLine = {show:false};
    }

    if (isShowCates == 1 || isShowCates == 11){
        option.legend = {
            data:thisCates
        };
        option.grid.top = '12%';
        if (isShowCates == 11){
            option.grid.top = '3%';
            option.legend.bottom = 'bottom';
            option.legend.y = 'bottom';
            option.grid.bottom = '13%';
        }
    }

    if (chartsTitle != ""){
        option.title = {
            text: chartsTitle,
            x:'center',
            textStyle:{
                //文字颜色
                color:'#666',
                //字体风格,'normal','italic','oblique'
                fontStyle:'normal',
                //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
                fontWeight:'bold',
                //字体系列
                fontFamily:'sans-serif',
                //字体大小
                fontSize:15
            }
        };
        option.grid.top = '10%';
    }

    for (var k = 0, length = thisCates.length; k < length; k++) {
        var item = {
            name:thisCates[k],
            type:'line',
            data:thisDatas[k],
            //设置颜色
            itemStyle:{
                normal:{
                    color:colors[k]
                }
            }
        };
        if (yDatas != ''){
            item.yAxisIndex = thisCatesYs[k];
        }
        if (thisCatesColors != ''){
            item.itemStyle = {
                normal:{color:thisCatesColors[k]}
            };
        }
        if (isStack == ''){
            item.stack = "总量";
        }
        if (isArea == ''){
            item.areaStyle = {normal: {}};
        }else{
            option.grid.right = '3%';
        }
        option.series.push(item);
    }



    if (formatter != ''){
        // 这个要求，option.series.data 为这种形式的如：  [{name:"周一",value:120}, {name:"周二",value:132}]
        // 原来是 [120, 132]
        option.tooltip.formatter = function(params)
        {
            var relVal = params[0].name;
            for (var i = 0, l = params.length; i < l; i++) {
                var valueFormatter = formatter(params[i].value);
                relVal += '<br/>' + params[i].seriesName + ' : ' + valueFormatter;
            }
            return relVal;
        }
    }

    // 使用刚指定的配置项和数据显示图表。
    myChart.clear();
    myChart.setOption(option);

}

function moreLine(divId, chartsTitle, thisTitles, thisDatas, thisCates, isShowCates, formatter, isStack, isArea) {

    isShowCates = isShowCates || 1;
    formatter = formatter || '';
    // 是否叠加
    isStack = isStack || '';
    // 是一条线，还是一个面
    isArea = isArea || '';
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            left: '1%',
            right: '10%',
            bottom: '10%',
            top:'3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: thisTitles,
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    //color:'#ccc',
                    width:0,//轴线的粗细
                }
            }
        },
        yAxis: {
            type: 'value',
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    //color:'#ccc',
                    width:0,//轴线的粗细
                }
            }
        },
        series: []
    };

    if (isShowCates == 1 || isShowCates == 11){
        option.legend = {
            data:thisCates
        };
        option.grid.top = '12%';
        if (isShowCates == 11){
            option.grid.top = '3%';
            option.legend.bottom = 'bottom';
            option.grid.bottom = '13%';
        }
    }

    if (chartsTitle != ""){
        option.title = {
            text: chartsTitle,
            x:'center'
        };
        option.grid.top = '20%';
    }

    for (var k = 0, length = thisCates.length; k < length; k++) {
        var item = {
            name:thisCates[k],
            type:'line',
            data:thisDatas[k],
            //设置颜色
            itemStyle:{
                normal:{color:colors[k]}
            }
        };
        if (isStack == ''){
            item.stack = "总量";
        }
        if (isArea == ''){
            item.areaStyle = {normal: {}};
        }else{
            option.grid.right = '1%';
        }
        option.series.push(item);
    }



    if (formatter != ''){
        // 这个要求，option.series.data 为这种形式的如：  [{name:"周一",value:120}, {name:"周二",value:132}]
        // 原来是 [120, 132]
        option.tooltip.formatter = function (params, ticket, callback) {
            var res = params[0].name+'<br/>';
            var myseries = option.series;
            for (var i = 0; i < myseries.length; i++) {
                for(var j = 0; j<myseries[i].data.length; j++){
                    if(myseries[i].data[j].name == params[0].name){
                        var valueFliter = formatter(myseries[i].data[j].value);
                        res += myseries[i].name +' : '+valueFliter+'</br>';
                    }
                }
            }
            return res;
        };
    }

    // 使用刚指定的配置项和数据显示图表。
    myChart.clear();
    myChart.setOption(option);

}

// 饼状图
function bing(divId, chartsTitle, thisTitles, thisDatas, isAllBing, isShowLabelLine) {


    // 是否是全饼(2)，还有半圈的饼(1)
    isAllBing = isAllBing || 1;
    // 是否显示 明文标签提示，显示(2)不显示(1)
    isShowLabelLine = isShowLabelLine || 1;

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'right',
            type: 'scroll',
            right: 10,
            top: 50,
            bottom: 30,
            data: thisTitles
        },
        color: colors,
        series: [
            {
                name:chartsTitle,
                type:'pie',
                radius: ['50%', '80%'],
                center: ['43%', '53%'],
                avoidLabelOverlap: true,   //是否启用防止标签重叠策略
                data:thisDatas
            }
        ]
    };

    // 全饼
    if(isAllBing == 2){
        option.series[0].radius = '85%';
    }
    // 不显示 明文标签
    if (isShowLabelLine == 1){
        option.series[0].label = {
            normal: {
                show: false,
                position: 'center'
            },
            emphasis: {
                show: true,
                textStyle: {
                    fontSize: '15',
                    fontWeight: 'bold'
                }
            }
        };
        option.series[0].labelLine = {
            normal: {
                show: false
            }
        };
    }


    // 使用刚指定的配置项和数据显示图表。
    myChart.clear();
    myChart.setOption(option);

}

// 仪表盘
function dash_board(divId, chartsTitle, dataValue, dataUnit, dataTitle) {

    // dataUnit 值的单位，如 完成率，利率等
    dataUnit = dataUnit || '';
    // dataValue 单个值，如50
    dataValue = dataValue || 0;
    // dataTitle 指这是个什么东西 如 业务指标，如 天气情况
    dataTitle = dataTitle || chartsTitle;

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        tooltip : {
            formatter: "{a} {b} : {c}"
        },
        series: [
            {
                name: dataTitle,
                type: 'gauge',
                radius: '100%',

                axisLine: {            // 坐标轴线
                    lineStyle: {       // 属性lineStyle控制线条样式
                        width: 10,
                        color: [[0.5, '#c23531'], [0.6, '#e98f6f'], [0.7, '#63869e'], [0.8, '#91c7ae'], [1, '#749f83']]
                    }
                },
                splitLine: {           // 分隔线
                    length: 10,         // 属性length控制线长
                    lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                        color: 'auto'
                    }
                },

                detail: {formatter:dataTitle, fontSize:18},
                data: [{value: dataValue, name: dataUnit}]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

// 堆叠柱状图
function moreColumnar(divId, chartsTitle, thisTitles, thisDatas, thisCates, isShowCates, thisStacks, formatter, isXYexchange) {

    isShowCates = isShowCates || 1;
    formatter = formatter || '';
    thisStacks = thisStacks || '';
    // 是否调换xy轴显示
    isXYexchange = isXYexchange || '';
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));

    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '1%',
            right: '2%',
            bottom: '2%',
            top:'5%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: thisTitles,
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    //color:'#ccc',
                    width:0,//轴线的粗细
                }
            }
        },
        yAxis: {
            type: 'value',
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    //color:'#ccc',
                    width:0,//轴线的粗细
                }
            }
        },
        series: []
    };

    if (isShowCates == 1){
        option.legend = {
            data:thisCates
        };
        option.grid.top = '10%';
    }
    for (var k = 0, length = thisCates.length; k < length; k++) {

        // 这个变量是用于控制 是在一要柱子上叠加显示，还是一组柱子平行显示
        var stack = "总量";
        if (thisStacks != ''){
            stack = thisStacks[k];
        }

        option.series.push(
            {
                name:thisCates[k],
                type:'bar',
                stack: stack,
                barWidth:30,
                //设置柱体颜色
                itemStyle:{
                    normal:{color:colors[k]}
                },
                data:thisDatas[k]
            });
    }

    // 是否调换xy轴显示
    if (isXYexchange != ''){
        var tmp = option.xAxis;
        option.xAxis = option.yAxis;
        option.yAxis = tmp;
    }



    if (formatter != ''){
        // 这个要求，option.series.data 为这种形式的如：  [{name:"周一",value:120}, {name:"周二",value:132}]
        // 原来是 [120, 132]
        option.tooltip.formatter = function (params, ticket, callback) {
            var res = params[0].name+'<br/>';
            var myseries = option.series;
            for (var i = 0; i < myseries.length; i++) {
                for(var j = 0; j<myseries[i].data.length; j++){
                    if(myseries[i].data[j].name == params[0].name){
                        var valueFliter = formatter(myseries[i].data[j].value);
                        res += myseries[i].name +' : '+valueFliter+'</br>';
                    }
                }
            }
            return res;
        };
    }

    // 使用刚指定的配置项和数据显示图表。
    myChart.clear();
    myChart.setOption(option);

}

// 树状矩阵
function pubMapTree(divId, thisTitles, thisDatas, thisColors) {
    var myChart = echarts.init(document.getElementById(divId));

    var option = {
        tooltip : {
            trigger: 'item',
            //formatter: "{b}: {c}"
            formatter: "{b}"
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : false,
        color: thisColors,
        series : [
            {
                name:'',
                type:'treemap',
                width:'100%',// 宽度
                height:'100%',
                breadcrumb:false,// 不显示底下的面包屑
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            formatter: "{b}"
                        },
                        borderWidth: 1
                    },
                    emphasis: {
                        label: {
                            show: true
                        }
                    }
                },
                data:[
                    // {
                    //     name: '三星',
                    //     value: 6
                    // },
                    // {
                    //     name: '小米',
                    //     value: 4
                    // },
                    // {
                    //     name: '苹果',
                    //     value: 4
                    // },
                    // {
                    //     name: '华为',
                    //     value: 2
                    // },
                    // {
                    //     name: '联想',
                    //     value: 2
                    // },
                    // {
                    //     name: '魅族',
                    //     value: 1
                    // },
                    // {
                    //     name: '中兴',
                    //     value: 1
                    // }
                ]
            }
        ]
    };



    for (var k = 0, length = thisTitles.length; k < length; k++) {
        var item = {
            name:thisTitles[k]+"："+thisDatas[k],
            value:thisDatas.length > 0 ? thisDatas[k] : 0
        };
        option.series[0].data.push(item);
    }

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}


// 点面图...
function pointArea(divId, thisDatas, xName, yName){

    // x 轴 上方显示的文字
    xName = xName || '';
    // y 轴 右方显示的文字
    yName = yName || '';

    var myChart = echarts.init(document.getElementById(divId));

    var option = {
        grid: {
            left: '5%',
            right: '2%',
            bottom: '15%',
            top: '4%'
        },
        tooltip : {
            //trigger: 'axis',
            showDelay : 0,
            formatter : function (params) {
                if (params.value.length > 1) {
                    return 'x：'+params.value[0] + ' '
                        + 'y：'+params.value[1] + ' ';
                }
                else {
                    return params.seriesName + ' :<br/>'
                        + params.name + ' : '
                        + params.value + 'kg ';
                }
            },
            // axisPointer:{
            //     show: true,
            //     type : 'cross',
            //     lineStyle: {
            //         type : 'dashed',
            //         width : 1
            //     }
            // }
        },
        xAxis : [
            {
                name : xName,
                type : 'value',
                scale:true,
                axisLabel : {
                    //formatter: '{value} cm'
                    formatter: '{value}'
                },
                axisLine:{
                    onZero: false,   // 不从0点开始，也就是说如果有负数时，x轴从最下方的负数开始
                    lineStyle:{
                        //color:'#ccc',
                        //width:0,//不显示线
                    }
                },
                splitLine: {
                    show: false
                }
            }
        ],
        yAxis : [
            {
                name : yName,
                type : 'value',
                scale:true,
                min: -10,
                max: 10,
                axisLabel : {
                    //formatter: '{value} kg'
                    formatter: '{value}'
                },
                axisLine:{
                    onZero: false,   // 不从0点开始，也就是说如果有负数时，y轴从最左侧的负数开始
                    lineStyle:{
                        //color:'#ccc',
                        //width:0,//不显示线
                    }
                },
                splitLine: {
                    show: false
                }
            }
        ],
        series : [
            {
                //name:'',
                type:'scatter',
                // 点的大小
                symbolSize:2,
                color:colors[4],
                data : thisDatas
                // data: [[161.2, -51.6], [167.5, 59.0], [159.5, 49.2], [157.0, 63.0], [155.8, 53.6],
                //     [170.0, 59.0], [159.1, 47.6], [166.0, 69.8], [176.2, 66.8], [160.2, 75.2],
                //     [172.5, 55.2], [170.9, 54.2], [172.9, 62.5], [153.4, 42.0], [160.0, 50.0]
                // ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}




// 雷达图
function getRadar(divId, indicatorArr, dataArr) {
    indicatorArr = indicatorArr || [];
    dataArr = dataArr || [];

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(divId));
    var option = {
        title: {
            //text: '基础雷达图'
        },
        tooltip: {},
        legend: {
            //show:false,
            data: []
        },
        radar: {
            nameGap : 5, // 图中每个角文字 距离图的距离 ****
            name: {
                textStyle: {
                    color: '#666'
                }
            },
            // indicator: [
            //     { name: '销售销售销售', max: 6500},
            //     { name: '管理销售销售', max: 16000},
            //     { name: '信息技术销售', max: 30000},
            //     { name: '客服销售销售', max: 38000},
            //     { name: '研发销售销售', max: 52000},
            //     { name: '市场销售销售', max: 25000}
            // ],
            indicator: indicatorArr,
            radius: 70
        },
        series: [{
            name: '预算 vs 开销（Budget vs spending）',
            type: 'radar',
            // areaStyle: {normal: {}},
            itemStyle: {                // 折线拐点标志的样式。
                normal: {                   // 普通状态时的样式
                    lineStyle: {
                        width: 1
                    },
                    opacity: 1
                },
                emphasis: {                 // 高亮时的样式
                    lineStyle: {
                        width: 5
                    },
                    opacity: 1
                }
            },
            // data : [
            //     {
            //         value : [4300, 10000, 28000, 35000, 50000, 19000],
            //         name : '预算分配（Allocated Budget）',
            //
            //         // label: {                    // 单个拐点文本的样式设置
            //         //     normal: {
            //         //         show: true,             // 单个拐点文本的样式设置。[ default: false ]
            //         //         position: 'top',        // 标签的位置。[ default: top ]
            //         //         distance: 5,            // 距离图形元素的距离。当 position 为字符描述值（如 'top'、'insideRight'）时候有效。[ default: 5 ]
            //         //         color: 'rgba(255,0,0,1)',          // 文字的颜色。如果设置为 'auto'，则为视觉映射得到的颜色，如系列色。[ default: "#fff" ]
            //         //         fontSize: 14,           // 文字的字体大小
            //         //         formatter:function(params) {
            //         //             return params.value;
            //         //         }
            //         //     }
            //         // },
            //         // itemStyle: {                // 单个拐点标志的样式设置。
            //         //     normal: {
            //         //         borderColor: 'rgba(255,0,0,1)',       // 拐点的描边颜色。[ default: '#000' ]
            //         //         borderWidth: 3,                        // 拐点的描边宽度，默认不描边。[ default: 0 ]
            //         //     }
            //         // },
            //         // lineStyle: {                // 单项线条样式。
            //         //     normal: {
            //         //         opacity: 0.5            // 图形透明度
            //         //     }
            //         // },
            //         // areaStyle: {                // 单项区域填充样式
            //         //     normal: {
            //         //         color: 'rgba(255,0,0,0.6)'       // 填充的颜色。[ default: "#000" ]
            //         //     }
            //         // }
            //     },
            //     {
            //         value : [5000, 14000, 28000, 31000, 42000, 21000],
            //         name : '实际开销（Actual Spending）'
            //     }
            // ]

            // //这里的配置显示数值 这是data里的属性
            // label: {
            //     normal: {
            //         show: true,
            //         formatter:function(params) {
            //             return params.value;
            //         }
            //     }
            // }

            //data: dataArr
            data:[]
        }]
    };

    for (var k = 0; k < dataArr.length; k++) {
        var item = {
            name:dataArr[k].name,
            value:dataArr[k].value,
            //设置颜色
            itemStyle:{
                normal:{color:colors[k]}
            }
        };

        //这里的配置显示数值
        if (dataArr.length == 1){
            item.label = {
                normal: {
                    show: true,
                    formatter:function(params) {
                        return params.value;
                    }
                }
            };
        }


        if (dataArr.length > 1)
            option.legend.data.push(dataArr[k].name);

        option.series[0].data.push(item);
    }

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}


