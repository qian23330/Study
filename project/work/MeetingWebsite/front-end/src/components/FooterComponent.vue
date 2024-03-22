<template>
  <div>
<!--    <section class="edu-counter section" style="background-image:url(/static/photos/background/创新港涵英楼正蓝-无出处.jpg);">-->
<!--      <div class="edu-counter-overlay"></div>-->
<!--      <div class="container ">-->
<!--        <div class="row clearfix ">-->
<!--          <div class="col-md-3 col-sm-6 mx-auto">-->
<!--            <div class="counter-area ">-->
<!--              <h2 class="counter ">{{ registeredCount }}</h2>-->
<!--              <h3>已注册</h3>-->
<!--            </div>-->
<!--          </div>-->

<!--          <div class="col-md-3 col-sm-6 mx-auto">-->
<!--            <div class="counter-area ">-->
<!--              <h2 class="counter ">{{ submittedCount }}</h2>-->
<!--              <h3>已投稿</h3>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </section>-->
    <br><br><br><br><br>
    <footer>
      <div class="container">
        <div class="row mx-auto d-flex justify-content-center">
          <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="footer-widget">
              <h2>联系方式 / Contact Info</h2>
              <div class="widget-content">
                <div class="text">如有任何问题，请随时联系。</div>
                <div class="text">Feel free to contact us.</div>
                <address class="add">
                  <p><i class="fa fa-map-marker"></i> 朱老师 / Dr. Zhu</p>
                  <p><i class="fa fa-phone"></i>+86-18192703755</p>
                  <p><i class="fa fa-envelope"></i>zhudongli2018@xjtu.edu.cn</p>
                </address>
              </div>
            </div>
          </div>

          <div class="col-md-5 col-sm-6 col-xs-12">
            <div class="footer-widget links-widget">
              <h2>参会意向 / Registration Intention Survey</h2>

              <div class="row">
                <div class="col-md-6 col-sm-6 col-sm-12">
                  <ul>
                    <li><a class="text-center" style="text-transform: initial">为了更好的举办本届会议，请有意向参会的人员长按二维码填写 “参会意向表” /
                      If you are interested in participating, please scan the QR code. Thank you!</a></li>
                  </ul>
                </div>
                <div class="col-md-6 col-sm-6 col-sm-12">
                  <img src="@/assets/images/others/00.webp" alt="" class="img-responsive">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>

    <div class="footer-bottom">
      <div class="container">
        <div class="row">
            <div class="text-left">Copyright &copy; 2024 Biomedical Informatics & Genomics Center, Xi’an Jiaotong University, China. All rights reserved.
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--Footer Bottom-->
</template>
<script>
import axios from 'axios';
export default {
  name: "FooterComponent",
  data() {
    return {
      registeredCount: 0,
      submittedCount: 0
    };
  },
  // mounted() {
  //   this.fetchRegisteredCount();
  //   this.fetchSubmittedCount();
  // },
  // methods: {
  //   async fetchRegisteredCount() {
  //     try {
  //       // 使用 Axios 或 Fetch 发送请求获取已注册人数
  //       const response = await axios.get('/api/getRegisteredCount');
  //       this.registeredCount = response.data.count; // 假设后端返回数据格式为 { count: 100 }
  //     } catch (error) {
  //       console.error('Error fetching registered count:', error);
  //     }
  //   },
  //   async fetchSubmittedCount() {
  //     try {
  //       // 使用 Axios 或 Fetch 发送请求获取已投稿人数
  //       const response = await axios.get('/api/getSubmittedCount');
  //       this.submittedCount = response.data.count; // 假设后端返回数据格式为 { count: 50 }
  //     } catch (error) {
  //       console.error('Error fetching submitted count:', error);
  //     }
  //   }
  // }
}
</script>
<style scoped>
.add{
  text-align: left;
}
</style>
