<template>
  <el-table
      :data="tableData"
      style="width: 100%"
      height="350" class="fontchange">
    <el-table-column
        prop="date"
        label="日期/Date"
        width="150">
    </el-table-column>
    <el-table-column
        prop="time"
        label="时间/Time"
        width="220">
    </el-table-column>
    <el-table-column
        prop="location"
        label="地点/Location"
        width="150">
    </el-table-column>
    <el-table-column
        prop="topic"
        label="主题/Topic"
        width="300">
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
        topic: 'Nope'
      }, {
        date: '2023-06-13',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Nope'
      }, {
        date: '2023-06-14',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Nope'
      }, {
        date: '2023-06-14',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Nope'
      }, {
        date: '2023-06-15',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Nope'
      }, {
        date: '2023-06-15',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Nope'
      }, {
        date: '2023-06-16',
        time: '8:30-12:00 a.m.',
        location: '18-2081',
        topic: 'Nope'
      }, {
        date: '2023-06-16',
        time: '2:30-5:30 p.m.',
        location: '18-2081',
        topic: 'Nope'
      }]
    }
  }
}
</script>
<style scoped>
.fontchange {
  font-size: medium;
  font-family: Arial,serif;
}
</style>
