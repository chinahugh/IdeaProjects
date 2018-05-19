 var baseLayer = window.gis.createWMSLayer("动态图","http://192.168.1.10:6080/arcgis/services/FMS/FMS/MapServer/WmsServer",'0');
var featureLayer = window.gis.createFeatureLayer("矢量图层");;
$(document).ready(function () {
    	$.ajax({
			url: getAppUrl() + "/project/getProLocation.action",
			type: 'post',
			data: {"procode":'',"proname":''},
			cache : false,
			dataType : 'JSON',
			success : function(data) {
				if (data) {
					//创建中心点//data[0].data[0].lon,data[0].data[0].lat
					 var center = window.gis.lonlat(108.563332,34.153990);
					initMap(data,center);
				}
			}
		});
//       //查询事件绑定
	$("#search_btn").click(searchProject);
	$("#clear_btn").click(clearProjectSearchFm);
	$("#query_tree").tree({
		url: getAppUrl() + "/project/resTree2Pro.action?asynch=false",
		animate: true,
		lines: true,
		onLoadSuccess: function(node, data){ /*初始化树*/
//			initMap(data);
		},
	    onClick:function(node){
	    	if(node.attributes.code == 4){
	    		showMap(node.attributes.gdzb);
	    	}
	    }
    });
//	//激活
//	window.gis.selectControl.activate();
	 $('#open').on('click',function(){
         window.gis.isSelect(true);
     });
     $('#close').on('click',function(){
         window.gis.isSelect(false);
     });
});
 function getMapData(procode,proname){
	 $.ajax({
			url: getAppUrl() + "/project/getProLocation.action",
			type: 'post',
			data: {"procode":procode,"proname":proname},
			cache : false,
			dataType : 'JSON',
			success : function(data) {
				if (data) {
					showMap(data);
				}
			}
		});
 }
 
 function searchProject(){
    var data = new Array();
	var procode= $("#proSearchMap input[name='procode']").val();
	var proname= $("#proSearchMap input[name='proname']").val();
	getMapData(procode,proname);
	
}
 
 function clearProjectSearchFm(){
	var procode= $("#proSearchMap input[name='procode']").val('');
	var proname= $("#proSearchMap input[name='proname']").val('');
	//清除所有气泡
	window.gis.clearPopu();
	//清除所有矢量图层里的所有元素
	window.gis.clearFeatures(featureLayer);
}
function initMap(polys,center){
    //初始化地图
    window.gis.initMap("map", null, [baseLayer, featureLayer], center, 8);
    var features=[];
    //创建图层元素：多边形
    for(var i=0;i<polys.length;i++){
        var list=[];
        for(var j=0;j<polys[i].data.length;j++){
            var p=window.gis.createPoint(polys[i].data[j].lon,polys[i].data[j].lat);
            list.push(p);
        }
        var poly = window.gis.createPolygonFeature(list,{id:polys[i].id});
        features.push(poly);
    }
    //添加多边形元素
    window.gis.addFeatures(featureLayer,features);
    //更改地图窗口大小
    window.gis.mapResiz();
    //清除图层元素
    window.gis.clearFeatures(featureLayer);
    //清除气泡
    window.gis.clearPopu();
    window.gis.isSelect(true);
}

function showMap(polys){
    //清除图层元素
    window.gis.clearFeatures(featureLayer);
    //清除气泡
    window.gis.clearPopu();
	//创建图层元素：多边形
	 var center = window.gis.lonlat(polys[0].data[0].lon,polys[0].data[0].lat);
	 window.gis.map.setCenter(center, 10)
	var features=[];
    for(var i=0;i<polys.length;i++){
        var list=[];
        for(var j=0;j<polys[i].data.length;j++){
            var p=window.gis.createPoint(polys[i].data[j].lon,polys[i].data[j].lat);
            list.push(p);
        }
        var poly = window.gis.createPolygonFeature(list,{id:polys[i].id});
        features.push(poly);
    }
    //添加多边形元素
    window.gis.addFeatures(featureLayer,features);
    //更改地图窗口大小
    window.gis.mapResiz();
}
