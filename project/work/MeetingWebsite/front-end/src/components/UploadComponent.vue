<template>
  <div>
    <el-upload class="upload-demo" drag action="/api/upload" multiple accept=".pdf,.doc"
               :limit="1"
               :before-upload="beforeAvatarUpload">
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
      <div class="el-upload__tip" slot="tip">只能上传.pdf/.doc文件，且不超过10MB</div>
    </el-upload>
  </div>
</template>

<script>
export default {
  name: 'Upload',
  data() {
    return {
      attach: {
        files: []
      }
    };
  },
  methods: {
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

  }
}
</script>
<style scoped></style>
