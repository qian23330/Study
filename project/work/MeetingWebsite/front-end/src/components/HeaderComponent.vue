<template>
  <div class="top-header">
<!--    <h2>HELLO</h2>-->
    <div class="container">
      <div class="row">


          <li>Welcome!</li>
          <h1>HELLO</h1>


      </div>
    </div>
  </div>

</template>

<script>
export default {

}
</script>
<style>
.top-header {
  background: #03a9f4;
  padding: 10px 0;
  clear: both;
}
.container {
  max-width:720px
}
.row {
  display:-webkit-box;
  display:-ms-flexbox;
  display:flex;
  -ms-flex-wrap:wrap;
  flex-wrap:wrap;
  margin-right:-15px;
  margin-left:-15px
}
.col-md-5{-webkit-box-flex:0;-ms-flex:0 0 41.666667%;flex:0 0 41.666667%;max-width:41.666667%;display: none;}
.col-sm-5{-webkit-box-flex:0;-ms-flex:0 0 41.666667%;flex:0 0 41.666667%;max-width:41.666667%}
.tophead-link {
  display: inline-block;
}

</style>