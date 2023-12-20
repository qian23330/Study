<template>
  <div class="marquee">
    <div class="marquee_box" ref="marquee_box">
      <ul class="marquee_list" :class="{marquee_top:animate}">
        <li v-for="(item,index) in list" :key="index">{{item}}</li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Marquee',
  data () {
    return {
      animate: false,
      showNum: 4, // 可见列表条数
      list: [
        'Genomics research is essential for revealing the complex regulatory relationships\n' +
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
      ]
    }
  },
  created () {
    // 页面显示
    setInterval(this.showMarquee, 2000)
  },
  mounted () {
    // 可见数据高度
    this.$refs.marquee_box.style.height = this.showNum * 30 + 'px'
  },
  methods: {
    // 处理数组方法
    showMarquee () {
      this.animate = true
      this.list.push(this.list[0])
      setTimeout(() => {
        this.list.shift()
        this.animate = false
      }, 1000)
    }
  }
}
</script>
<style scoped>
.marquee {
  width: 100%;
  /* height: 200px; */
  align-items: center;
  color: #3a3a3a;
  background-color: white;
  display: flex;
  box-sizing: border-box;
  overflow: hidden;
}
.marquee_title {
  padding: 0 20px;
  height: 21px;
  font-size: 14px;
  border-right: 1px solid #d8d8d8;
  align-items: center;
}
.marquee_box {
  display: block;
  position: relative;
  width: 65%;
  overflow: hidden;
  margin: 0 auto;
}
.marquee_list {
  display: block;
  position: absolute;
  top: 0px;
  left: 0;
}
.marquee_top {
  transition: all 1s;
  margin-top: -30px;
}
.marquee_list li {
  height: 30px;
  line-height: 30px;
  font-size: 14px;
  padding-left: 20px;
}
.marquee_list li span {
  padding: 0 2px;
}
</style>