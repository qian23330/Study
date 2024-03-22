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
                <h4>会议地点 / Address</h4>
                <p>西安交通大学（创新港校区）</p>
                <p>陕西省西安市西咸新区沣西新城河堤路与梧桐东路交叉路口南</p>
                <p>Xi'an Jiaotong University(Western China Science And Technology Innovation Harbor)</p>
                <p>South of the Intersection of Hedi Road and Wutong East Road, Fengxi New City, Xixian New Area, Xi'an City, Shaanxi Province.</p>
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
                <h4>重要日期 / Important Date</h4>
                <p>论文投稿 / Submission：</p>
                <p>2024.01.01 - 05.01</p>
                <p>参会注册 / Register：</p>
                <p>2024.01.01 - 06.12</p>
                <p>会议时间 / Meeting：</p>
                <p>2024.06.13 - 06.16</p>
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
                <div class="notice-block">
                  <h3>Notice</h3>
                  <p>Please Download this file for details of this meeting.</p>
                  <a href="/static/file/notice.pdf" @click.prevent="downloadFile" class="btn btn-primary btn">Download</a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="welcome section pdb0 clear">
          <div class="row mx-auto d-flex justify-content-center">
            <div class="col-md-8">
              <div class="title">
                <h2 class="d-flex justify-content-center">会议主题 / Theme</h2>
              </div>
              <div class="welcome-inner">
                <div class="row">
                  <h6 style="text-align: justify; text-indent: 2em; line-height: 2">大会议题包括GWAS与后GWAS的数据分析与挖掘、精准医学和转化医学、
                    联合多组学和医学影像的疾病诊疗与药物重定位研究、基于基因组信息和AI的疾病风险模型预测、AI在多组学数据挖掘中的应用研究、生物信息学与统计方法开发等。
                    本次大会将邀请多位海内外知名学者和专家与会，并将设置四大专题报告和墙报专栏，以供学科前沿进展研讨，促进海内外的学术交流与合作。</h6>
                  <hr><br>
                  <h6 style="text-align: justify; text-indent: 2em; line-height: 1.8">The conference topics include GWAS and post-GWAS data analysis and mining,
                    precision medicine and translational medicine, disease diagnosis and drug repositioning research using integrated multi-omics and medical imaging,
                    disease risk prediction models based on genomic information and AI, the application of AI in multi-omics data mining, and the development of bioinformatics
                    and statistical methods. The conference will invite renowned scholars and experts from home and abroad and will feature four major thematic presentations
                    and a poster section for in-depth discussions on cutting-edge developments in the field, promoting academic exchange and collaboration both domestically
                    and internationally.</h6>
                  <br><br>
                </div>
              </div>
            </div>
            <div class="col-md-8">
              <div class="title">
                <h2 class="d-flex justify-content-center">会议议题 / Agenda</h2>
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
          <h2 class="mytext">主办与承办单位 / Host and organizer</h2>
          <h6>西安交通大学 / Xi'an Jiaotong University</h6>
          <br>
          <h6>西安简介 / Introduction of Xi'an :</h6>
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
  components: {Slider, FooterComponent, HeaderComponent},
  methods: {
    downloadFile(event) {
      const url = event.target.href;  // 获取链接的url
      fetch(url)
        .then(response => response.blob())
        .then(blob => {
          // 创建Blob URL并用于异步下载
          const downloadUrl = window.URL.createObjectURL(blob);
          const link = document.createElement('a');
          link.href = downloadUrl;
          link.download = 'notice.pdf'; // 设置下载的文件名
          document.body.appendChild(link);
          link.click();
          document.body.removeChild(link);
        })
        .catch(() => {
          this.$message.error('Download error');
        });
    }
  }
}
</script>

<style scoped>
.mytext {
  text-transform: capitalize;
}
.notice-block {
  margin-top: 30px;
  padding: 60px;
  border-radius: 5px;
}
hr {
  height: 5px;
  color: rgb(0, 78, 151);  /*对应于下边框的颜色*/
  background-color: rgb(0, 78, 151);  /*对应于下边框的颜色*/
  width: 100%;
  margin: auto; /*将横线居中显示*/
}
</style>
