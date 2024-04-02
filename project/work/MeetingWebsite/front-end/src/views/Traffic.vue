<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <br><br><br>
<!--    <section class="breadcrumb" style="background-image: url(/static/photos/background/创新港图书馆橘黄-微博@WKing丶.jpg);">-->
<!--      <div class="breadcrumb-overlay"></div>-->
<!--      <div class="container">-->
<!--        <h1><a href="#/traffic">Traffic/Hotel</a></h1>-->
<!--        <span><a href="#/">Home</a></span><span><i class="fa fa-angle-right"></i>Traffic/Hotel</span>-->
<!--      </div>-->
<!--    </section>-->
    <section class="clients section">
      <div class="container">
            <div class="title sec-title">
              <h2 class="mytext">Traffic / Hotel</h2>
            </div>
        <div class="col-md-8 mx-auto">
          <div class="contact-info">
            <p class="newtext" ><i class="fa fa-map-marker"></i>乘坐西安地铁5号线至 “创新港/创新港东” 站</p>
            <p class="newtext" >Take Xi‘an metro line 5 to CHUANG XIN GANG
              or CHUANG XIN GANG DONG station.</p>
          </div>
          <div class="contact-info">
            <p class="newtext"><i class="fa fa-map-marker"></i>如果您乘坐出租车或驾驶私家车来创新港，大致时间距离约为：
              - 从西安火车站至创新港
              67 分钟/30 公里
              - 从西安咸阳国际机场至创新港
              50 分钟/25 公里
            </p>
            <p class="newtext">
              You can drive a car or take a taxi to XJTU iharbour, the approximate travel time and distance is:  - From Xi'an Railway Station
              67 min/30 km  - From Xi'an Xianyang International Airport
              50 min/25 km.
            </p>
            <br>
          </div>
          <div class="Mapcontainer">
            <Map></Map>
          </div>
        </div>


      </div>
    </section>
    <div class="container">
      <div class="title sec-title">
        <h3>蔓兰酒店/Man Lan Hotel</h3>
        <br>
        <a href="http://www.hotelmomc.com.cn/html/rmmdd/sc/16.html" class="btn-link">酒店详情 / Hotel Details</a>
        <br><br>
        <p>订房电话：18191061030（张丽）/ Booking phone number: 18191061030 (Zhang Li)</p>
        <p>预定时备注“ISGTM-2”或“第二届基因组学与转化医学国际研讨会”可享受优惠价！</p>
        <p>Please note "ISGTM-2" or "2nd International Symposium on Genomics and Translational Medicine" when booking to enjoy discounted prices!</p>
      </div>
    </div>
    <section class="introduction">
      <div class="card">
        <div class="photo"><img src="/static/photos/hotel/标注_精品大床房.png" alt=""></div>
        <h1></h1>
        <h2>精品大床房 / Deluxe King Room</h2>
        <p>￥478</p>
        <a href="http://www.hotelmomc.com.cn/html/rmmdd/sc/16.html">酒店详情 / Hotel Details</a>
      </div>
      <div class="card">
        <div class="photo"><img src="/static/photos/hotel/标注_观景大床房.png" alt=""></div>
        <h1></h1>
        <h2>观景大床房 / Scenic View King Room</h2>
        <p>￥768</p>
        <a href="http://www.hotelmomc.com.cn/html/rmmdd/sc/16.html">酒店详情 / Hotel Details</a>
      </div>
      <div class="card">
        <div class="photo"><img src="/static/photos/hotel/标注_蔓兰套房.png" alt=""></div>
        <h1></h1>
        <h2>蔓兰套房 / Manlan Suite</h2>
        <p>￥1288</p>
        <a href="http://www.hotelmomc.com.cn/html/rmmdd/sc/16.html">酒店详情 / Hotel Details</a>
      </div>
    </section>
    <FooterComponent></FooterComponent>
  </div>
</template>

<style scoped>
.Mapcontainer {
  height: 50vh;
  width: 100%;
}
.introduction {
  width: auto;
  /* 100%窗口高度 */
//height: 100vh;
  /* 弹性布局 水平+垂直居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  /* 渐变背景 */
//background: linear-gradient(200deg, white, wheat);
}
.card{
  /* 相对定位 */
  position: relative;
  width: 30%;
  height: 20vw;
  margin: 10px;
  background-color: #758a99;
  border-radius: 20px;
  /* 溢出隐藏 */
  overflow: hidden;
  /* 弹性布局 */
  display: flex;
  /* 元素纵向排列 */
  flex-direction: column;
  /* 居中 */
  align-items: center;
  color: #fff;
  /* 阴影 */
  box-shadow: 0 0 30px rgba(0,0,0,0.5);
  /* 不让其被挤压 */
  flex-shrink: 0;
}
.card .photo img{
  width: 100%;
  height: 100%;
  /* 保持原有尺寸比例，裁切长边 */
  object-fit: cover;
}
/* 默认大图 */
.card .photo{
  /* 绝对定位 */
  position: absolute;
  top: 0;
  width: 100%;
  height: 100%;
  border-radius: 0%;
  overflow: hidden;
  /* 动画过渡 */
  transition: 0.5s;
}
/* 鼠标移入变小图 */
.card:hover .photo{
  top: 30px;
  width: 0px;
  height: 0px;
  border-radius: 50%;
  box-shadow: 0 0 20px rgba(0,0,0,0.8);
}
/* 这里加个黑色到透明的渐变背景，可以更好的看清楚名字 */
.card .photo::before{
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom,transparent 50%,#222);
}
.card h1{
  position: absolute;
  top: 170px;
  transition: 0.5s;
  color: white;
}
.card:hover h1{
  top: 70px;
}
.card h2{
  margin-top: 60px;
  color: white;
  width: 80%;
  border-bottom: 1px solid rgba(255,255,255,0.3);
  font-size: 20px;
  text-align: center;
  margin-bottom: 20px;
  padding-bottom: 20px;
}
.card p{
  width: 90%;
  //text-indent: 32px;
  font-size: 16px;
  margin-bottom: 15px;
  line-height: 30px;
  text-align: center;
}
.card a{
  font-size: 14px;
  color: rgba(255,255,255,0.8);
  text-decoration: none;
  border: 1px solid rgba(255,255,255,0.5);
  padding: 8px 32px;
  border-radius: 8px;
}
.card a:hover{
  color: #fff;
  background-color: rgba(255,255,255,0.2);
}
.mytext {
  text-transform: capitalize;
}
.newtext {
  font-size: 16px;
  text-align: center;
  width: 100%;
}
</style>
<script>
export default {
  components: {HeaderComponent, FooterComponent, Map}
}
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import Map from "@/components/MapComponent.vue";

</script>
