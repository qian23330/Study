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
          <h2 class="mytext">Registration</h2>
          <h3>注册费 / Registration Fee</h3>
          <br>
          <p>会议注册费缴纳方式为银行转账汇款或现场缴费</p>
<!--          <p>The payment method for conference registration is bank transfer remittance or on-site payment</p>-->
          <p>（注：注册时选择预定住宿者，住宿费需入住当日现场缴费；<em><strong>请在转账备注信息中备注"姓名+ISGTM"。</strong></em>）</p>
<!--          <p>(Note: When registering, if you select the accommodation, the accommodation fee needs to be paid on-site on the day of check-in.-->
<!--            <em><strong>Please note your name and email in the transfer remarks to ensure consistency with your registered email.</strong></em>)</p>-->
          <br>
          <div>
            <img src="/static/file/fee.png" alt="fee.png">
          </div>
          <br>
          <h3>账户信息 / Account information：</h3>
          <br>
          <h5>1. 国内汇款：</h5>
          <p>账户名称：西安交通大学</p>
          <p>银行账号：3700023509088100314</p>
          <p>开户银行：中国工商银行西安互助路支行</p>
          <p>联行行号：102791000162</p>
          <br>
          <h5>2. Overseas Remittance / 国外汇款：</h5>
          <p>Account Name / 账户名：XI’AN JIAOTONG UNIVERSITY 西安交通大学</p>
          <p>Bank Name / 开户行：BANK OF CHINA SHAANXI BRANCH XI’AN JIAODA SUB-BRANCH 中国银行西安交大支行</p>
          <p>Bank Address / 开户行地址：NO.8D YouYiDongLu XI’AN SHAANXI CHINA 陕西省西安市友谊东路8D号</p>
          <p>Account Number / 账户号码:</p>
          <p>US dollar / 美元账号：103600215153</p>
          <p>European dollar / 欧元账号：102400215168</p>
          <p>Japanese Yen / 日元账号：102000215162</p>
          <p>Hong Kong dollar / 港币账号：103200215157</p>
          <p>SWIFT CODE / 银行代码:BKCHCNBJ620</p>
          <p>Telephone / 银行电话：029-82582595</p>
        </div>
        <div class="row text-center">
          <div class="modern-inner mx-auto align-content-center">
            <h5>请填写以下信息完成注册。</h5>
            <h5>Please fill in the following information to complete registration.</h5>
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

                <!-- 预定酒店预订 -->
                <el-col :span="12">
                  <el-form-item label="预定酒店:" prop="bookHotel">
                    <el-select v-model="people.bookHotel" placeholder="Book Hotel">
                      <el-option label="是 / Yes" value="yes"></el-option>
                      <el-option label="否 / No" value="no"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>

                <template v-if="people.bookHotel === 'yes'">
                  <!-- 房型选择 -->
                  <el-col :span="12">
                    <el-form-item label="房型 :" prop="roomType">
                      <el-select v-model="people.roomType" placeholder="Room Type">
                        <el-option label="精品双床房 / Deluxe Twin Room" value="0"></el-option>
                        <el-option label="精品大床房 / Deluxe King Room" value="1"></el-option>
                        <el-option label="观景大床房 / Scenic View King Room" value="2"></el-option>
                        <el-option label="蔓兰套房 / Manlan Suite" value="3"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>

                  <!-- 开始日期选择 -->
                  <el-col :span="24">
                    <el-form-item label="入住日期 :" prop="checkInDate">
                      <el-date-picker
                        v-model="people.checkInDate"
                        type="date"
                        placeholder="Check In Date"
                        start-placeholder="开始 / Start"
                        end-placeholder="结束 / End"
                        value-format="yyyy-MM-dd"
                        format="yyyy-MM-dd"
                        @change="checkDate"
                        :default-value="new Date(2024,5,14)"
                        :picker-options="{
                          disabledDate(time) {
                          let checkInDate = new Date(2024, 5, 13); // 月份是从0开始，所以6月是5
                          let checkOutDate = new Date(2024, 5, 16);
                          return time.getTime() < checkInDate.getTime() || time.getTime() > checkOutDate.getTime();}}"
                      ></el-date-picker>
                    </el-form-item>
                  </el-col>

                  <!-- 结束日期选择 -->
                  <el-col :span="24">
                    <el-form-item label="退房日期 :" prop="checkOutDate">
                      <el-date-picker
                        v-model="people.checkOutDate"
                        type="date"
                        placeholder="Check Out Date"
                        start-placeholder="开始 / Start"
                        end-placeholder="结束 / End"
                        value-format="yyyy-MM-dd"
                        format="yyyy-MM-dd"
                        :default-value="new Date(2024,5,14)"
                        :picker-options="{
                          disabledDate(time) {
                          let checkInDate = new Date(people.checkInDate);
                          let checkOutDate = new Date(2024, 5, 17);
                          return time.getTime() <= checkInDate.getTime() || time.getTime() >= checkOutDate.getTime(); }}"
                      ></el-date-picker>
                    </el-form-item>
                  </el-col>
                </template>

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
                    <div class="el-upload__tip" slot="tip">请将投稿摘要文件重命名为“题目-姓名”<br>
                      仅支持上传pdf或doc格式的文件，请不要超过10MB<br>
                      一次仅支持上传一个文件</div>
                    <div class="el-upload__tip" slot="tip">Please change the file name to 'Title-Name'.<br>
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
        bookHotel: "",
        roomType: "",
        checkInDate: "",
        checkOutDate: "",
        attach: {files: ""}
      },
      fileList: [],
      formRules: {
        name: [{required: true, message: 'Please input name', trigger: 'blur'}],
        email: [{required: true, message: 'Please input email', trigger: 'blur'}],
        telephone: [{required: true, message: 'Please input telephone', trigger: 'blur'}],
        bookHotel: [{required: true, message: 'Please choose yes or no', trigger: 'blur'}],
        roomType: [{required: true, message: 'Please input room type', trigger: 'blur'}],
        checkInDate: [{required: true, message: 'Please input check in date', trigger: 'blur'}],
        checkOutDate: [{required: true, message: 'Please input check out date', trigger: 'blur'}]
      },
    };
  },
  methods: {
    // 检查并确保退房日期晚于入住日期
    checkDate () {
      const { checkInDate, checkOutDate } = this.people;
      if (checkInDate && checkOutDate && new Date(checkInDate).getTime() >= new Date(checkOutDate).getTime()) {
        this.people.checkOutDate = '';
      }},
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
