<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <br><br><br>
<!--    <section class="breadcrumb" style="background-image: url(/static/photos/background/创新港图书馆橘黄-微博@WKing丶.jpg);">-->
<!--      <div class="breadcrumb-overlay"></div>-->
<!--      <div class="container">-->
<!--        <h1><a href="#/committee">Committee</a></h1>-->
<!--        <span><a href="#/">Home</a></span><span><i class="fa fa-angle-right"></i>Committee</span>-->
<!--      </div>-->
<!--    </section>-->
    <section class="meet-team section">
      <div class="container">
        <div class="title sec-title">
          <h2 class="mytext">Committee</h2>
          <p>委员会名单 / Committee members list</p>
          <br>
          <br>
          <h3>学术委员会</h3>
          <p class="p">主席：邓红文</p>
          <p class="p">副主席: 李明定，Yun-Long Liu</p>
          <br>
          <p class="p">委员（按姓氏笔画排序）</p>
          <p class="p">Yu-Ping Wang，邓飞艳，Hao Zhu，刘鹏渊，李明，李轩，李淼新，</p>
          <p class="p">沈洁，吴焕梅，肖红梅，肖苏妹，杨铁林，张峰，张垒，张丽姝，</p>
          <p class="p">官方霖，郭燕，徐书华，蒋慧，蒋德科，雷署丰，Wei Lei</p>
          <br><br>
          <h3>组织委员会</h3>
          <p class="p">主席：杨铁林</p>
          <br>
          <p class="p">委员（按姓氏笔画排序）</p>
          <p class="p">王然，邓飞艳，朱东丽，刘鹏渊，李淼新，肖苏妹，陈晓峰，张峰，</p>
          <p class="p">张垒，张丽姝，林旭，郭燕，董珊珊，蒋德科，蒋慧，雷署丰</p>
        </div>
      </div>
    </section>
    <section class="introduction">
      <br><br>
    </section>
    <FooterComponent></FooterComponent>
  </div>
</template>

<script setup>
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
</script>

<style scoped>
.p {
  font-size: 18px;
}
.introduction {
  /* 100%窗口高度 */
//height: 100vh;
  /* 弹性布局 水平+垂直居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  /* 渐变背景 */
//background: linear-gradient(200deg,#517fa4,#243949);
}
.card{
  /* 相对定位 */
  position: relative;
  width: 300px;
  height: 450px;
  margin: 20px;
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
  text-align: center;
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
  width: 120px;
  height: 150px;
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
  top: 370px;
  transition: 0.5s;
  color: white;
}
.card:hover h1{
  top: 170px;
}
.card h2{
  margin-top: 220px;
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
  text-indent: 32px;
  font-size: 16px;
  margin-bottom: 15px;
  line-height: 30px;
  text-align: center;
  margin-right: 30px;
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
</style>
