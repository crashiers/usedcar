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
            value:dataArr[k].value
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