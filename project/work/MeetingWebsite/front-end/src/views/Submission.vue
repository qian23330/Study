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
    <section class="clients section">
      <div class="col-md-6 mx-auto">
        <div class="title sec-title">
          <h2 class="mytext">Register</h2>
        </div>
        <img src="/static/file/bank.png" alt="bank.png">
        <br>
        <img src="/static/file/fee.png" alt="fee.png">
        <div class="row text-center">
          <div class="modern-inner mx-auto align-content-center">
            <el-form ref="form" :model="people"  :rules="formRules">
              <el-row :gutter="24">
                <el-col :span="12">
                  <el-form-item label="姓名 :" prop="name">
                    <el-input v-model="people.name" placeholder="Name" ></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="邮箱 :" prop="email">
                    <el-input v-model="people.email" placeholder="Email"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="电话 :" prop="telephone">
                    <el-input v-model="people.telephone" placeholder="Telephone"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="单位 :" prop="institution">
                    <el-input v-model="people.institution" placeholder="Institution"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="文章题目 :">
                    <el-input v-model="people.title" placeholder="Title"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="投稿主题 :" prop="选择框">
                    <el-select v-model="people.topic" placeholder="Topic" style="width: 100%;">
                      <el-option label="生物信息学与统计方法/Bioinformatics and Statistical Methods" value="0"></el-option>
                      <el-option label="人工智能、大数据与精准医疗/Artificial Intelligence, Big Data, and Precision Medicine" value="1"></el-option>
                      <el-option label="多组学、生物标志物、疾病诊断和风险预测/Multi-omics, Biomarkers, Disease Diagnosis, and Risk Prediction" value="2"></el-option>
                      <el-option label="药物、靶点、疾病机制和治疗/Drugs, Targets, Disease Mechanisms, and Treatment" value="3"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>

                <el-col :span="24">
                  <div class="submit-button" id="target">
                    <el-button type="primary" @click="submitForm" class="btn btn-primary btn">Register Now</el-button>
                  </div>
                  <br><br><br>
                </el-col>
              </el-row>
              <div class="title sec-title">
                <h2 class="mytext">Submission</h2>
              </div>
              <div class="col-md-4 modern-class modern-apply text-center mx-auto">
                <div class="modern-apply-inner">
                  <div class="notice-block">
                    <h6>投稿模版 / Templates</h6>
                    <a href="/static/file/templates.zip" @click.prevent="downloadFile" class="btn btn-primary btn">Download</a>
                  </div>
                  <br>
                </div>
              </div>
              <el-col :span="24">
                <el-form-item>
                  <el-upload class="upload-demo" drag action="/api/upload" multiple :limit="1"
                             name="doc" :on-exceed="handleExceed"
                             :before-upload="beforeAvatarUpload" :on-success="handleAvatarSuccess"
                             :file-list="fileList">
                    <i class="el-icon-upload"></i>
                    <div class="el-upload__text">将文件拖到此处或<em>点击上传</em>。</div>
                    <div class="el-upload__text">Drag the file here, or <em>click to upload</em>.</div>
                    <div class="el-upload__tip" slot="tip">请将投稿摘要文件重命名为“题目-邮箱”<br>
                      仅支持上传pdf或doc格式的文件，请不要超过10MB<br>
                      一次仅支持上传一个文件</div>
                    <div class="el-upload__tip" slot="tip">Please change the file name to 'Title-Email'.<br>
                      Only .pdf/.doc files are supported and do not exceed 10MB.<br>
                      Only one file can be uploaded at a time. Please check it.</div>
                  </el-upload>
                </el-form-item>
              </el-col>
            </el-form>
          </div>
        </div>
      </div>
    </section>
    <FooterComponent></FooterComponent>
  </div>
</template>

<script>
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import { add, update } from "@/api/send.js";
import Table from "@/components/TimetableComponent.vue";
import FeeTable from "@/components/Fee.vue";

export default {
  mounted() {
    if (this.$route.hash) {
      this.scrollToElement(this.$route.hash.slice(1));
    }
  },
  components: {FeeTable, Table, HeaderComponent, FooterComponent },
  data() {
    return {
      people: {
        name: "",
        email: "",
        telephone: "",
        institution: "",
        title: "",
        topic: "",
        attach: {files: ""}
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
    scrollToElement(id) {
      const element = document.getElementById(id);
      if (element) {
        element.scrollIntoView({
          behavior: "smooth",
        });
      }
    },
    downloadFile(event) {
      const url = event.target.href;  // 获取链接的url
      fetch(url)
        .then(response => response.blob())
        .then(blob => {
          // 创建Blob URL并用于异步下载
          const downloadUrl = window.URL.createObjectURL(blob);
          const link = document.createElement('a');
          link.href = downloadUrl;
          link.download = 'templates.zip'; // 设置下载的文件名
          document.body.appendChild(link);
          link.click();
          document.body.removeChild(link);
        })
        .catch(() => {
          this.$message.error('Download error');
        });
    },
    handleExceed(){
      this.$message({
        type:'warning',
        message:'Only 1 file can be uploaded!'
      });
      return false;
    },
    handleAvatarSuccess(res) {
      this.people.attach.files = res.data.data;
      this.$message.success('file uploaded successfully！');
    },
    beforeAvatarUpload(file) {
      const fileType = file.type.toLowerCase();
      const isPDF = fileType === 'application/pdf';
      const isDOC = fileType === 'application/msword' || fileType === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';

      const isAllowedType = isPDF || isDOC;
      const isLt2M = file.size / 1024 / 1024 < 10;

      if (!isAllowedType) {
        this.$message.error("please check your file type which should be .pdf or .docx");
        return false;
      }
      if (!isLt2M) {
        this.$message.error("The file size cannot exceed 10MB!");
        return false;
      }

      return isAllowedType && isLt2M;
    },

    submitForm() {
      // Check if input fields are filled
      if (!this.people.name || !this.people.email || !this.people.telephone) {
        this.$message.error('Please fill in all the required fields');
        return;
      }

      const phoneNumberPattern = /^\d+$/;
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

      // Validate email format
      if (!emailPattern.test(this.people.email)) {
        this.$message.error('Please enter a valid email address');
        return;
      }

      // Validate phone number format
      if (!phoneNumberPattern.test(this.people.telephone)) {
        this.$message.error('Please enter a valid phone number (digits only)');
        return;
      }

      // Proceed with form validation
      this.$refs.form.validate((valid) => {
        if (valid) {
          // Rest of your existing logic for confirmation and submission
          this.$confirm("confirm to submit?", "Warning", {
            confirmButtonText: "Yes",
            cancelButtonText: "No",
            type: "warning",
          }).then(() => {
            add(this.people)
              .then((resp) => {
                if (resp.data.code === 1) {
                  this.$message.success({ message: 'successfully submitted', type: 'success' });
                  // Additional actions upon successful submission
                } else {
                  this.$message.error(resp.data.msg);
                }
              }).catch((err) => {
              this.$message.error('An error occurred while submitting the form: ' + err.message);
            });
          }).catch(() => {
            this.$message.info("canceled");
          });
        } else {
          this.$message.error('Please fill in the required fields');
          return false;
        }
      });
    },

  }
}
</script>
<style scoped>
.mytext {
  text-transform: capitalize;
}
.submit-button {
  display: flex;
  justify-content: right;
  margin-top: 20px; /* Adjust as needed */
}
.el-upload__tip {
  width: 100%; /* 文本框宽度占比 */
  font-size: 14px;
  text-align: center;
}
.el-upload__text {
  text-align: center;
}

/deep/ .el-upload{
  width: 100%;
}
/deep/ .el-upload .el-upload-dragger {
  width: 100%;
}
</style>
