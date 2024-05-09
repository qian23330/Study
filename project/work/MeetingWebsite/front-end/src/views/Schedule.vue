<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <br><br><br>
<!--    <section class="breadcrumb" style="background-image: url(/static/photos/background/创新港图书馆橘黄-微博@WKing丶.jpg);">-->
<!--      <div class="breadcrumb-overlay"></div>-->
<!--      <div class="container">-->
<!--        <h1><a href="#/schedule">Schedule</a></h1>-->
<!--        <span><a href="#/">Home</a></span><span><i class="fa fa-angle-right"></i>Schedule</span>-->
<!--      </div>-->
<!--    </section>-->
    <section class="clients section">
      <div class="container">
        <div class="title sec-title">
          <h2 class="mytext">Schedule</h2>
          <p>会议具体时间安排如下：</p>
          <p>The specific schedule of the meeting is as follows:</p>
          <br><br>
          <img src="/static/file/table.png" alt="table.png">
        </div>
      </div>
    </section>
    <FooterComponent></FooterComponent>
  </div>
</template>

<style scoped>
.mytext {
  text-transform: capitalize;
}
</style>
<script setup>
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
</script>
