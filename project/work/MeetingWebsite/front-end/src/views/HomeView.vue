<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
<!--    <HeaderComponent></HeaderComponent>-->
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import HeaderComponent  from "@/components/HeaderComponent.vue";
export default {
  name: 'HomeView',
  components: {
    HeaderComponent,
    HelloWorld
  }
}
</script>
