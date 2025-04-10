<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <div class="slider-container">
      <img class="slider-items" src="@/assets/images/background/" alt="image"/>
    </div>
    <section class="slide-bottom-sec">
      <div class="container">
        <div class="slide-bottom">
              <!-- 搜索区域 -->
              <el-row :gutter="20" class="search-container">
                <el-col :span="8">
                  <el-input
                    v-model="searchTerm"
                    placeholder="输入关键词..."
                    clearable
                  ></el-input>
                </el-col>
                <el-col :span="8">
                  <el-select v-model="searchCategory" placeholder="选择分类">
                    <el-option label="所有 / All" value="all"></el-option>
                    <el-option label="议题 / Topic" value="topic"></el-option>
                    <el-option label="演讲者 / Speaker" value="speaker"></el-option>
                    <el-option label="日期 / Date" value="date"></el-option>
                  </el-select>
                </el-col>
                <el-col :span="8">
                  <el-button type="primary" @click="fetchData">搜索 / Search</el-button>
                </el-col>
              </el-row>
              <!-- 表格区域 -->
              <el-table
                v-if="tableData.length > 0"
                :data="tableData"
                border
                style="width: 100%; margin-top: 20px"
              >
                <el-table-column
                  v-for="(header, index) in tableHeaders"
                  :key="index"
                  :label="header.label"
                  :prop="header.prop"
                ></el-table-column>
              </el-table>
              <el-empty v-else description="暂无数据"></el-empty>
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
  data() {
    return {
      searchTerm: "", // 搜索关键词
      searchCategory: "all", // 搜索分类
      tableHeaders: [
        { label: "列1 / Column 1", prop: "column1" },
        { label: "列2 / Column 2", prop: "column2" },
        { label: "列3 / Column 3", prop: "column3" },
      ],
      tableData: [], // 表格数据
    };
  },
  methods: {
    fetchData() {
      // 模拟后端数据
      const mockData = [
        { column1: "议题1", column2: "演讲者A", column3: "2024-06-13" },
        { column1: "议题2", column2: "演讲者B", column3: "2024-06-14" },
      ];

      // 数据过滤逻辑
      const filteredData = mockData.filter((item) => {
        if (this.searchCategory === "all") {
          return Object.values(item).some((value) =>
            value.includes(this.searchTerm)
          );
        } else if (this.searchCategory === "topic") {
          return item.column1.includes(this.searchTerm);
        } else if (this.searchCategory === "speaker") {
          return item.column2.includes(this.searchTerm);
        } else if (this.searchCategory === "date") {
          return item.column3.includes(this.searchTerm);
        }
      });

      this.tableData = filteredData;

      // 如果没有结果，显示提示
      if (this.tableData.length === 0) {
        ElMessage.warning("未找到符合条件的数据");
      }
    },
    tiaozhuan(){
      this.$router.push({path: '/submission', hash: '#target'})
    }
  }
}
</script>

<style scoped>
.mytext {
  text-transform: capitalize;
}
hr {
  height: 5px;
  color: rgb(0, 78, 151);  /*对应于下边框的颜色*/
  background-color: rgb(0, 78, 151);  /*对应于下边框的颜色*/
  width: 100%;
  margin: auto; /*将横线居中显示*/
}
.search-container {
  top: 20px;
  margin: 20px auto;
  max-width: 1000px;
  text-align: center;

}
</style>
