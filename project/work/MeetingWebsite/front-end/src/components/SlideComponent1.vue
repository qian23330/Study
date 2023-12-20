<template>
  <div>
    <div class="slider-container">
<!--      <Marquee></Marquee>-->
      <img class="slider-items" src="@/assets/images/background/第二届基因组与转化医学国际研讨会.jpg" alt="image"/>

    </div>
  </div>
</template>

<script>
import Marquee from '@/components/TextComponent.vue'
export default {

  name: "Slider",
  components: {
    Marquee
  },
  data() {
    return {
      english:'Genomics research is essential for revealing the complex regulatory relationships\n' +
          '              between sequence variations,human phenotypes, gene functiones, disease occurrence\n' +
          '              and development. In recent years, advancements in sequencing technologies for various\n' +
          '              omics and progress in bioinformatics, AI technology and statistical genetics methods\n' +
          '              have greatly facilitated the rapid development of functional genomics research.\n' +
          '              At the same time， translational medicine serves as a bridge connecting basic genomics\n' +
          '              research with clinical applications.\n' +
          '              In order to further enhance communication and collaboration between the domestic and\n' +
          '              international genomics and translational medicine research communities and promote the\n' +
          '              development of discovery of disease drugs, the "Second International Symposium on\n' +
          '              Genomics and Translational Medicine" will invite renowned scholars and experts from China\n' +
          '              and abroad. The conference will feature multiple thematic presentations with poster sessions\n' +
          '              and we warmly welcome scholars and students in relevant fields to participate, collaborate on\n' +
          '              interdisciplinary endeavors, and share advanced experiences in this grand event!',
      chinese: '基因组学研究是揭示序列变异与基因功能、生命发育、疾病发生发展、人类表型的复杂调控关系的必然手段。近年来，\n' +
          '              多组学（基因组、转录组、表观组、三维基因组、微生物组等）测序技术、AI技术和生物信息学、统计遗传学方法的\n' +
          '              不断进步极大推动了功能基因组学研究的快速发展。转化医学是连接基因组学基础研究与临床应用的桥梁。\n' +
          '              为进一步加强国内外基因组与转化医学研究界的交流与合作，推动生物医学发展和疾病药物研发，“第二届基因组与\n' +
          '              转化医学国际研讨会”将邀请多位海内外知名学者和专家与会，大会将设置多个专题报告和墙报专栏。热忱欢迎相关\n' +
          '              领域学者和学生与会，共商学科大计，共享盛举！'
    }
  }
};
</script>

<style scoped>
/* 样式可根据需求进行调整 */
.slider-container {
  position: relative;
  width: 100%; /* 可根据图片尺寸调整 */
  height: auto; /* 可根据图片尺寸调整 */
}

.slider-items {
  width: 100%;
  height: auto;
  display: block;
}

.slider-content {
  position: absolute;
  width: 80%;
  top: 90%;
  left: 50%;
  transform: translate(-50%, -45%);
  color: #fff;
  font-size: 20px;
}

.p1 {
  line-height: 2.5vw;
  line-break: loose;
  text-indent: 4vw;
  text-align: justify;
  margin-top: 20px;
}


</style>
