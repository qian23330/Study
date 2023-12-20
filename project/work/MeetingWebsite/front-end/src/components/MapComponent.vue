<template>
  <div id="container"></div>
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader'
window._AMapSecurityConfig = {
  securityJsCode: '95b7d8df87c907655eb3ce501a5cec98'
}
export default {
  name: "Map",
  data() {
    return {
      map: null
    }
  },
  methods: {
    initMap() {
      AMapLoader.load({
        key: '54d4dc88e3d2462ce3c21fdc6781d0c0', // 申请好的Web端开发者Key，首次调用 load 时必填
        version: '2.0', // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        plugins: ['AMap.Scale'] // 需要使用的的插件列表，如比例尺'AMap.Scale'等
      })
        .then(AMap => {
          this.map = new AMap.Map('container', {
            //设置地图容器id
            viewMode: '3D', //是否为3D地图模式
            zoom: 10, //初始化地图级别
            center: [108.65745,34.255407] //初始化地图中心点位置
          })
          // 使用本地图片作为标记点的图标
          let markerIcon = new AMap.Icon({
            imageSize: new AMap.Size(32, 32),
            image: '/static/photos/background/locate.png', // 替换为你的本地图片路径
            size: new AMap.Size(32, 32)
          })

          // 添加标记点
          let marker = new AMap.Marker({
            position: [108.65745,34.255407],
            title: "location",
            icon: markerIcon,
            map: this.map
          })

          // 创建初始信息窗体
          let initialInfoWindow = new AMap.InfoWindow({
            content: "I'm here!", // 初始弹框文本内容
            offset: new AMap.Pixel(0, -10)
          })

          // 在地图加载完成后显示初始信息窗体
          this.map.on('complete', () => {
            initialInfoWindow.open(this.map, this.map.getCenter()) // 在地图中心位置显示初始信息窗体
          })

          // 创建信息窗体
          let infoWindow = new AMap.InfoWindow({
            content: 'xjtu',
            offset: new AMap.Pixel(0, -10)
          })

          // 点击标记点显示信息窗体
          marker.on('click', () => {
            infoWindow.open(this.map, marker.getPosition())
          })
        })
        .catch(e => {
          console.log(e)
        })
    }
  },
  mounted() {
    //DOM初始化完成进行地图初始化
    this.initMap()
  }
}
</script>

<style scoped>
#container {
  padding: 0;
  margin: 0;
  width: 100%;
  height: 100%;
}
</style>
