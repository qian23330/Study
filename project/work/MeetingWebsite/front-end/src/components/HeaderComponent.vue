<template>
<<<<<<< HEAD
  <div id="layout-header" :class="{'fixed':fixed,'hidden':hidden,'e':e && index===1}"
       @click.stop="mobileShow=false">
    <div class="site-branding">
      <router-link to="/">
        <a href="" class="logo"><img src="../assets/images/logo/BIGC-平面图标.png" alt="logo"></a>
      </router-link>
    </div>

    <div class="site-menus" :class="{'mobileShow':mobileShow}" @click.stop="mobileShow=!mobileShow">
      <nav>
        <router-link class="menu-item" v-for="menu in menus" :to="menu.link" :key="menu.id" :class="[{'other-link': index === menu.id}]"
                     @click="change(menu.id)">
          <a class="aa">{{ menu.name }}</a>
        </router-link>
      </nav>
=======
  <div class="top-header">
<!--    <h2>HELLO</h2>-->
    <div class="container">
      <div class="row">


          <li>Welcome!</li>
          <h1>HELLO</h1>


      </div>
>>>>>>> parent of 9cf68e39 (12-10)
    </div>
  </div>

</template>

<script>
export default {
<<<<<<< HEAD
  name: "HeaderComponent",
  data() {
    return {
      lastScrollTop: 0,
      fixed: false,
      hidden: false,
      category: [],
      mobileShow: false,
      index: 0,
      e: false,
      menus: [{
        name: "Home",
        link: "/",
        id: 0
      }, {
        name: "Committee",
        link: "/committee",
        id: 1
      }, {
        name: "Speakers",
        link: "/speakers",
        id: 2
      }, {
        name: "Schedule",
        link: "/schedule",
        id: 3
      },{
        name: "Submission",
        link: "/submission",
        id: 4
      },{
        name: "Traffic/Hotel",
        link: "/traffic",
        id: 5
      },{
        name: "History",
        link: "/history",
        id: 6
      }],
      drawer: true
    }
  },
  mounted() {
    window.addEventListener('scroll', this.watchScroll);
  },
  beforeDestroy() {
    window.removeEventListener("scroll", this.watchScroll)
  },
  methods: {
    watchScroll() {
      let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
      if (scrollTop === 0) {
        this.fixed = false;
        this.e = true;
      } else if (scrollTop >= this.lastScrollTop) {
        this.fixed = true;
        this.hidden = false;
        this.e = false;
      } else {
        this.fixed = true
        this.hidden = false
        this.e = false;
      }
      this.lastScrollTop = scrollTop
    },
    change(id) {
      this.index = id;
    }
  },
}
</script>
<style lang="less" scoped>
#layout-header .el-image {
  width: 50px;
  border-radius: 50%;

  .image-slot {
    width: 50px;
    height: 50px;
    border-radius: 50%;
  }
  .el-drawer__wrapper{
    .el-drawer{
      -webkit-transform: skew(30deg);
      -moz-transform: skew(30deg);
      -o-transform: skew(30deg);
      transform: skew(30deg);
    }
  }
}
</style>
<style scoped lang="less">
.e {
  background-color: rgba(0, 0, 0, 0.1) !important;
}

a {
  cursor: pointer;
}

.active .aa {
  color: rgba(0, 0, 0, 0) !important;
}


.user-avatar-image {
  cursor: pointer;
}


#layout-header {
  background-color: #2ea7e0;
  position: fixed;
  top: 0;
  z-index: 9;
  width: 100%;
  height: 6em;
  padding: 0 33% 0 5%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  transition: .3s all ease;
  -webkit-transition: .3s all ease;
  -moz-transition: .3s all linear;
  -o-transition: .3s all ease;
  -ms-transition: .3s all ease;


  &.hidden {
    top: -100px;
  }

  &.fixed {
    background-color: rgba(0, 0, 0, 0.1);
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
}

.site-logo {
  text-align: center;
  color: #FFFFFF;
  img {
    width: 60px;
    height: 60px;
  }

  p.site-name {
    font-size: 15px;
    font-weight: bold;
    position: relative;
    top: -10px;
  }
}

.menus-btn {
  display: none;
  visibility: hidden;
}

.site-menus {
  display: flex;
  align-items: center;

  .menu-item {
    min-width: 60px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    position: relative;
    color: #FFFFFF;

    a {
      padding: 12px 10px;
      color: #545454;
      font-weight: bold;
      font-size: 16px;
      color: #FFFFFF;

      &:hover {
        color: #545454;
      }
    }

    &:not(:last-child) {
      margin-right: 15px;
    }

    &.hasChild:hover .childMenu {
      opacity: 1;
      visibility: visible;
      transform: translateY(-5px);
    }
  }

  .childMenu {
    width: 130px;
    background-color: #FDFDFD;
    border-radius: 3px;
    border: 1px solid #ddd;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    position: absolute;
    top: 55px;
    z-index: 2;
    opacity: 0;
    visibility: hidden;
    transition: .7s all ease;
    -webkit-transition: .6s all ease;
    -moz-transition: .6s all linear;
    -o-transition: .6s all ease;
    -ms-transition: .6s all ease;

    &:before,
    &:after {
      content: '';
      position: absolute;
      width: 0;
      height: 0;
      border-left: 6px solid transparent;
      border-right: 6px solid transparent;
      border-bottom: 8px solid white;
      top: -8px;
      left: 20px;
    }

    &:before {
      top: -9px;
      border-bottom: 8px solid #ddd;
    }

    .sub-menu {
      height: 40px;
      line-height: 40px;
      position: relative;
      color: #000000;

      &:not(:last-child):after {
        /*position: absolute;*/
        content: '';
        width: 50%;
        height: 1px;
        color: #ff6d6d;
        bottom: 0;
        left: 25%;
        z-index: 99;
      }

      a {
        color: #545454;
        font-weight: normal;
      }

      a:hover {
        color: #2EA7E0;
      }
      &:hover{
        background-color: #F5F5F5;
      }
    }
  }
}

@media (max-width: 960px) {
  #layout-header {
    padding: 0 20px;
  }
}

@media (max-width: 600px) {
  #layout-header {
    padding: 0 10px;
  }

  .menus-btn {
    display: block;
    visibility: visible;
    color: #FFFFFF;
  }

  .site-menus {
    position: absolute;
    display: none;
    visibility: hidden;
    background-color: #F9F9F9;
    width: 100%;
    left: 0;
    top: 80px;
    z-index: -9;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);

    .menu-item {
      position: relative;
      height: unset;

      &:not(:last-child) {
        margin-right: 0;
      }
    }

    .header-search {
      color: #000000 !important;
    }

    .site-menus .menu-item a {
      color: #000000;
    }

    .childMenu {
      position: relative;
      width: 100%;
      top: 0;
      background-color: #F3F3F3;
      opacity: 1;
      visibility: visible;
      border: none;
      box-shadow: none;

      &:before,
      &:after {
        content: '';
        position: relative;
        width: 0;
        height: 0;
        border-left: 0;
        border-right: 0;
        border-bottom: 0;
      }
    }
  }

  .site-menus.mobileShow {
    display: inline-block;
    visibility: visible;
    z-index: 99;
  }
}

</style>
=======

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
>>>>>>> parent of 9cf68e39 (12-10)
