<template>
  <div>
    <HeaderComponent></HeaderComponent>
    <br><br><br>
<!--    <section class="breadcrumb" style="background-image: url(/static/photos/background/创新港图书馆橘黄-微博@WKing丶.jpg);">-->
<!--      <div class="breadcrumb-overlay"></div>-->
<!--      <div class="container">-->
<!--        <h1><a href="#/submission">Submission</a></h1>-->
<!--        <span><a href="#/">Home</a></span><span><i class="fa fa-angle-right"></i>Submission</span>-->
<!--      </div>-->
<!--    </section>-->
    <section class="contact-page inner-page">
      <div class="col-md-6 mx-auto">
        <div class="title inner-page-title">
          <h3 class="mytext">Submission(Not Started Yet)</h3>
        </div>
        <el-form ref="form" :model="people" label-width="100px" :rules="formRules">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="Name :" prop="name">
                <el-input v-model="people.name" placeholder="Name" ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="Email :" prop="email">
                <el-input v-model="people.email" placeholder="Email"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="Tel :" prop="telephone">
                <el-input v-model="people.telephone" placeholder="Telephone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="Title :">
                <el-input v-model="people.title" placeholder="Title"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="Content :">
                <el-input type="textarea" v-model="people.content" rows="12"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-button type="primary" @click="submitForm">Send Now</el-button>
            </el-col>
            <el-col :span="24">
              <br><br><br>
              <el-form-item>
                <el-upload class="upload-demo" drag action="/api/upload" multiple :limit="1"
                           name="doc"
                           :before-upload="beforeAvatarUpload" :on-success="handleAvatarSuccess"
                           :file-list="fileList" :on-change="handleChange">
                  <i class="el-icon-upload"></i>
                  <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                  <div class="el-upload__tip" slot="tip">请修改文件名为‘姓名-标题'！<br>
                    注意：仅支持.pdf/.doc文件，且不超过10MB。<br>
                    一次仅支持上传一个文件，请检查无误后上传。</div>
                </el-upload>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
    </section>
    <FooterComponent></FooterComponent>
  </div>
</template>

<script>
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import { add, update } from "@/api/send.js";

export default {
  components: { HeaderComponent, FooterComponent },
  data() {
    return {
      people: {
        name: "",
        email: "",
        telephone: "",
        title: "",
        content: "",
        attach: {
          files: '',
        }
      },
      fileList: [],
      formRules: {
        name: [{required: true, message: 'Please input name', trigger: 'blur'}],
        email: [{required: true, message: 'Please input email', trigger: 'blur'}],
        telephone: [{required: true, message: 'Please input telephone', trigger: 'blur'}]
      },
    };
  },
  methods: {
    handleChange(file, fileList) {
      // 获取上传文件的信息，设置文件名到 fileList
      file.raw && this.fileList.push({ name: file.raw.name });
    },
    handleAvatarSuccess(res, file) {
      this.people.attach.files = res.data.data;
      this.$message.success('文件上传成功！');
    },
    beforeAvatarUpload(file) {
      const fileType = file.type.toLowerCase();
      const isPDF = fileType === 'application/pdf';
      const isDOC = fileType === 'application/msword' || fileType === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';

      const isAllowedType = isPDF || isDOC;
      const isLt2M = file.size / 1024 / 1024 < 10;

      if (!isAllowedType) {
        this.$message.error("上传文件只能是 PDF 或 DOC 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传文件大小不能超过 10MB!");
      }

      return isAllowedType && isLt2M;
    },
    submitForm() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          // 表单验证通过，执行提交逻辑
          this.$confirm("confirm to submit?", "Warning", {
            confirmButtonText: "Yes",
            cancelButtonText: "No",
            type: "warning",
          }).then(() => {
            add(this.people) // 直接执行添加操作
              .then((resp) => {
                if (resp.data.code === 1) {
                  this.$message.success({ message: 'successfully submitted', type: 'success' })
                  // 可以根据需求做页面跳转或其他操作
                } else {
                  this.$message.error(resp.data.msg);
                }
              }).catch((err) => {
              this.$message.error('An error occurred while submitting the form: ' + err.message);
            });
          }).catch(() => {
            // 用户点击取消按钮
            this.$message.info("canceled");
          });
        } else {
          // 表单验证失败，显示错误信息
          this.$message.error('Please fill in the required fields');
          return false;
        }
      });
    },
  }
}
</script>
<style scoped>
.upload-demo {
width: fit-content;
}
.el-upload__tip {
  font-size: medium;
}
.mytext {
  text-transform: capitalize;
}
</style>
