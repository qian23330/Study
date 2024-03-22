<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <br><br><br>
<!--    <section class="breadcrumb" style="background-image: url(/static/photos/background/创新港图书馆橘黄-微博@WKing丶.jpg);">-->
<!--      <div class="breadcrumb-overlay"></div>-->
<!--      <div class="container">-->
<!--        <h1><a href="#/history">History</a></h1>-->
<!--        <span><a href="#/">Home</a></span><span><i class="fa fa-angle-right"></i>History</span>-->
<!--      </div>-->
<!--    </section>-->
    <section class="clients section">
      <div class="container">
        <div class="title sec-title">
          <h2 class="mytext">Our History</h2>
          <p>往届会议回顾 / Review of the 1st ISGTM</p>
        </div>
        <div class="video-top">
          <div class="row">
            <img src="../../src/assets/images/others/history.jpeg" alt="" class="new_responsive">
          </div>
        </div>
        <br>
        <div class="video-bottom">
          <div class="row">
            <div class="new_container"></div>
            <div class="video-bottom-inner">
              <p>首届基因组与转化医学研讨会于2018年6月14-17日在苏州举行，
                主题为探讨基因组学与转化医学领域的交叉研究，
                为疾病治疗提供新的思路。
                该次会议共有来自海内、外60多所高校、
                科研院所的200余名代表参加了此次大会，其中外宾30余人。
              <br><br>The 1st ISGTM was held in Suzhou from June 14 to 17, 2018,
                with the theme of exploring the cross-research between genomics and translational medicine to provide new ideas for disease treatment.
                A total of more than 200 representatives from more than 60 universities and research institutes at home and abroad attended the conference,
                including more than 30 foreign guests.</p>
            </div>
          </div>
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
