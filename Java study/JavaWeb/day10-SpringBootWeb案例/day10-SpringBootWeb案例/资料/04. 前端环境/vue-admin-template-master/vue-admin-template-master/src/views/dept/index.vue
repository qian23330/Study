<template>
  <div style="margin-top: 20px; margin: 50px; margin-right: 100px">
    <!-- 按钮 -->

    <el-row>
      <el-button
        style="float: right"
        type="primary"
        @click="dialogFormVisible = true; dept={}"
        >+ 新增部门</el-button
      >
    </el-row>
    <br>
    <!-- 数据表格 -->
    <template>
      <el-table
        highlight-current-row
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        border
      >
        <el-table-column type="index" width="100" label="序号" header-align="center" align="center"> </el-table-column>
        <el-table-column prop="name" label="部门名称" header-align="center" align="center"></el-table-column>
        <el-table-column label="最后操作时间" header-align="center" align="center">
          <template slot-scope="scope">
              {{scope.row.updateTime ? scope.row.updateTime.replace('T',' '):''}}
          </template>
        </el-table-column>

        <el-table-column label="操作" width="420" header-align="center" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              plain
              @click="selectById(scope.row.id)"
              >编辑</el-button
            >

            <el-button
              size="mini"
              type="danger"
              plain
              @click="deleteById(scope.row.id)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>

    <!-- 新建对话框 -->

    <el-dialog title="保存部门" :visible.sync="dialogFormVisible" >
      <el-form :model="dept">
        <el-form-item label="部门名称" :label-width="formLabelWidth">
          <el-input v-model="dept.name"  placeholder="请输入部门名称" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="add()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { findAll, add, update, deleteById, selectById } from "@/api/dept.js";

export default {
  data() {
    return {
      formLabelWidth: "120px",
      dialogFormVisible: false, //控制对话框是否可见
      dept: {
        name: "",
      },
      tableData: [],
    };
  },

  methods: {

    //删除部门
    deleteById(id) {
      this.$confirm("确认删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
          deleteById(id).then((result) => {
          	if(result.data.code == 1){
	          	this.$message({
	              message: "恭喜你，删除成功",
	              type: "success",
	            });
	        }else{
	        	this.$message.error(result.data.msg);
	        }
            //重新查询数据
            this.init();
          });
        }).catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },

    //根据ID查询部门 -- 回显
    selectById(id) {
      this.dialogFormVisible = true;
      selectById(id).then((result) => {
        this.dept = result.data.data;
      });
    },

    //保存方法
    add() {
      let method ;// 添加
      if (this.dept.id) {
        method = update(this.dept); // 修改
      }else{
        method = add(this.dept); //添加 
      }
      method.then((result) => {
        if (result.data.code == 1) {
          //修改成功
          this.$message.success("恭喜你，保存成功");
          //重新查询数据
          this.init();
        } else {
          this.$message.error(result.data.msg);
        }
      });
      // 关闭新建窗口
      this.dialogFormVisible = false;

      // 清空模型数据
      this.dept = {};
    },

    //初始化 - 查询全部
    init() {
      findAll().then((result) => {
        console.log(result);
        if (result.data.code == 1) {
          this.tableData = result.data.data;
        }
      });
    },
  },
  mounted() {
    //当页面加载完成后自动执行。
    this.init();
  },
};
</script>
<style>

</style>
