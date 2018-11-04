 var baseLayer = window.gis.createWMSLayer("动态图","http://192.168.1.10:6080/arcgis/services/FMS/FMS/MapServer/WmsServer",'0');
var featureLayer = window.gis.createFeatureLayer("矢量图层");;
var center = window.gis.lonlat(108.563332,34.153990);
initMap(center);
//showMap();


 

function initMap(center){
    //初始化地图
    window.gis.initMap("map", null, [baseLayer, featureLayer], center, 8);
    var features=[];
    //创建图层元素：多边形

    //添加多边形元素
    window.gis.addFeatures(featureLayer,features);
    //更改地图窗口大小
    window.gis.mapResiz();
    //清除图层元素
    window.gis.clearFeatures(featureLayer);
    //清除气泡/
   window.gis.clearPopu();
   window.gis.isSelect(true);
}

function showMap(json){
    //清除图层元素
   // window.gis.clearFeatures(featureLayer);
    //清除气泡
    //window.gis.clearPopu();
	//创建图层元素：多边形
//	 var center = window.gis.lonlat(polys[0].data[0].lon,polys[0].data[0].lat);
    //var features=[];
    //添加多边形元素
    //window.gis.addFeatures(featureLayer,features);
   //  window.gis.mapResiz();
    //清除图层元素
    //window.gis.clearFeatures(featureLayer);
  //  //清除气泡/
   //window.gis.clearPopu();
   
   // window.gis.isSelect(true);
	window.gis.clearFeatures(featureLayer);
	 window.gis.clearPopu();
    window.gis.addFeature2WKT(featureLayer,json);
    
}
