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
          <h2 class="mytext">Register/Submission</h2>
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
              <div class="submit-button">
                <el-button type="primary" @click="submitForm" class="enlarged-button">Register Now</el-button>
              </div>
            </el-col>

            <el-col :span="24">
              <br><br><br>
                <el-form-item>
                  <el-upload class="upload-demo" drag action="/api/upload" multiple :limit="1"
                             name="doc" :on-exceed="handleExceed"
                             :before-upload="beforeAvatarUpload" :on-success="handleAvatarSuccess"
                             :file-list="fileList">
                    <i class="el-icon-upload"></i>
                    <div class="el-upload__text">Drag the file here, or <em> click to upload</em></div>
                    <div class="el-upload__tip" slot="tip">Please change the file name to 'Name - Title'!<br>
                      Note: Only .pdf/.doc files are supported and do not exceed 10MB.<br>
                      Only 1 file can be uploaded at a time. Please check it.</div>
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
.enlarged-button {
  font-size: 16px; /* Adjust the font size as needed */
  padding: 12px 20px; /* Adjust the padding to increase button size */
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
