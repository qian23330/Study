<template>
  <el-table
      :data="tableData"
      style="width: 100%"
      height="450" class="fontchange">
    <el-table-column
        prop="date"
        label="日期 / Date"
        width="150">
    </el-table-column>
    <el-table-column
        prop="time"
        label="时间 / Time"
        width="160">
    </el-table-column>
    <el-table-column
        prop="location"
        label="地点 / Location"
        width="140">
    </el-table-column>
    <el-table-column
        fixed
        prop="topic"
        label="主题 / Topic"
        width="200">
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'Table',
  data() {
    return {
      tableData: [{
        date: '2023-06-13',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-13',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-14',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-14',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-15',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-15',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-16',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }, {
        date: '2023-06-16',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Single cell RNA-seq'
      }]
    }
  }
}
</script>
<style scoped>
.fontchange {
  font-size: 15px;
  font-family: Arial,serif;
}
</style>
