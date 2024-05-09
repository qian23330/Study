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
.mytext {
  text-transform: capitalize;
}
</style>
