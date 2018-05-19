<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
		#l-map{height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
		#r-result{height:100%;width:20%;float:left;}
	</style>
	<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(109.48, 36.60);
	map.centerAndZoom(point, 15);
	// 编写自定义函数,创建标注
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  // var marker2 = new BMap.Marker(point, {icon: icon});  // 创建标注
	  // var icons = "./img/1.png";
	  // var icon = new BMap.Icon(icons, new BMap.Size(30, 53)); //显示图标大小
	  map.addOverlay(marker);
	  marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	}
	// 随机向地图添加25个标注
	var bounds = map.getBounds();
	var sw = bounds.getSouthWest();
	var ne = bounds.getNorthEast();
	var lngSpan = Math.abs(sw.lng - ne.lng);
	var latSpan = Math.abs(ne.lat - sw.lat);
	for (var i = 0; i < 25; i ++) {
		var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.8), ne.lat - latSpan * (Math.random() * 0.8));
		addMarker(point);
	}
</script>



	<div id="allmap" style="width:100%;height:1000px;margin-bottom:1000px;"></div>

