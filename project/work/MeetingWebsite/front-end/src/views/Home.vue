<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <div class="slider-container">
      <img class="slider-items" src="@/assets/images/background/第二届基因组与转化医学国际研讨会.jpg" alt="image"/>
    </div>
    <section class="slide-bottom-sec">
      <div class="container">
        <div class="slide-bottom">
          <div class="row">
            <div class="col-md-4 modern-class">
              <div class="modern-inner">
                <h4>会议地点/Address</h4>
                <p>西安交通大学</p>
                <p>(中国西部科技创新港)</p>
                <p>Xi'an Jiaotong University</p>
                <p>(Western China Science And Technology Innovation Harbor)</p>
                <div class="modern-btn">
                  <a href="#/traffic">learn more<i class="fa fa-long-arrow-right"></i></a>
                </div>
                <div class="modern-icon">
                  <i class="fa fa-location-arrow"></i>
                </div>
              </div>
            </div>
            <div class="col-md-4 modern-class">
              <div class="modern-inner">
                <h4>重要日期/Important Date</h4>
                <p>论文投稿/Submission：</p>
                <p>2024.01.01-2024.05.01</p>
                <p>参会注册/Register：</p>
                <p>2024.01.01-2024.06.12</p>
                <p>会议时间/Meeting：</p>
                <p>2024.06.13-2024.06.16</p>
                <div class="modern-btn">
                  <a href="#/schedule">learn more<i class="fa fa-long-arrow-right"></i></a>
                </div>
                <div class="modern-icon">
                  <i class="fa fa-calendar"></i>
                </div>
              </div>
            </div>
            <div class="col-md-4 modern-class modern-apply text-center">
              <div class="modern-apply-inner">
                <!-- <p>Apply To</p> -->
                <h3>Click To Register</h3>
                <a href="#/submission" class="btn btn-primary btn">Register</a>
              </div>
            </div>
          </div>
        </div>

        <div class="welcome section pdb0 clear">
          <div class="row mx-auto d-flex justify-content-center">
            <div class="col-md-8">
              <div class="title">
                <h2 class="d-flex justify-content-center">会议议题/Agenda</h2>
              </div>
              <div class="welcome-inner">
                <div class="row">
                  <div class=" col-md-6">
                    <div class="edu_feature">
                      <div class="edu-feature-icon">
                        <i class="fa fa-database"></i>
                      </div>
                      <div class="edu-featre-des">
                        <h3>01 生物信息学与统计方法</h3>
                        <p>Bioinformatics and Statistical Methods </p>
                      </div>
                    </div>
                  </div>
                  <!-- END col-sm-6 -->

                  <div class="col-md-6">
                    <div class="edu_feature">
                      <div class="edu-feature-icon">
                        <i class="fa fa-simplybuilt"></i>
                      </div>
                      <div class="edu-featre-des">
                        <h3>02 人工智能、大数据与精准医疗</h3>
                        <p>Artificial Intelligence, Big Data, and Precision Medicine </p>
                      </div>
                    </div>
                  </div>
                  <!-- END col-sm-6 -->

                  <div class="col-md-6">
                    <div class="edu_feature">
                      <div class="edu-feature-icon">
                        <i class="fa fa-desktop"></i>
                      </div>
                      <div class="edu-featre-des">
                        <h3>03 多组学、生物标志物、疾病诊断和风险预测 </h3>
                        <p>Multi-omics, Biomarkers, Disease Diagnosis, and Risk Prediction </p>
                      </div>
                    </div>
                  </div>
                  <!-- END col-sm-6 -->

                  <div class="col-md-6">
                    <div class="edu_feature">
                      <div class="edu-feature-icon">
                        <i class="fa fa-medkit"></i>
                      </div>
                      <div class="edu-featre-des">
                        <h3>04 药物、靶点、疾病机制和治疗 </h3>
                        <p>Drugs, Targets, Disease Mechanisms, and Treatment </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="popular-course section grey-background">
      <div class="container">
        <div class="title sec-title">
          <h2 class="mytext">主办与承办单位/Host and organizer</h2>
          <h6>西安交通大学/Xi'an Jiaotong University</h6>
          <br>
          <h6>西安简介/Introduction of Xi'an :</h6>
        </div>
        <div class="pupular-course-inner">
            <Slider></Slider>
        </div>
      </div>
    </section>
    <FooterComponent></FooterComponent>
  </div>
</template>

<script>
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import Slider from "@/components/SliderComponent.vue";
export default {
  name: 'HomeView',
  components: {Slider, FooterComponent, HeaderComponent}
}
</script>

<style scoped>
.mytext {
  text-transform: capitalize;
}
</style>
