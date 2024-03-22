<template>
  <div>
    <h4>缴费金额/Registration fee</h4>
    <br>
    <el-table
      :data="tableData"
      style="width: 100%"
      height="200" class="fontchange">
      <el-table-column
        prop="date"
        label="国内参会人员 / Domestic Participants"
        width="200">
      </el-table-column>
      <el-table-column
        prop="time"
        label="国外参会人员 / Overseas Participants"
        width="200">
      </el-table-column>
      <el-table-column
        fixed
        prop="topic"
        label="2024年5月15前 / Before 5.15.2024"
        width="200">
      </el-table-column>
    </el-table>
    <el-table
      :data="tableData2"
      style="width: 100%"
      height="200" class="fontchange">
      <el-table-column
        prop="date"
        label="国内参会人员 / Domestic Participants"
        width="200">
      </el-table-column>
      <el-table-column
        prop="time"
        label="国外参会人员 / Overseas Participants"
        width="200">
      </el-table-column>
      <el-table-column
        fixed
        prop="topic"
        label="2024年5月15后 / After 5.15.2024"
        width="200">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'FeeTable',
  data() {
    return {
      tableData: [{
        date: '￥1200',
        time: '$280',
        topic: '学者/Scholar'
      }, {
        date: '￥600',
        time: '$80',
        topic: '学生/Student'
      }],
      tableData2: [{
        date: '￥1500',
        time: '$300',
        topic: '学者/Scholar'
      }, {
        date: '￥800',
        time: '$100',
        topic: '学生/Student'
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
