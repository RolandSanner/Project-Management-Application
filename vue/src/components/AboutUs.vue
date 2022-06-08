<template>
  <div class="aboutus">
    <div class="jack section">
      <a href="https://www.linkedin.com/in/jackkhodr/"><img src="./../assests/jack.jpg" alt="jack"></a>
      <h2>Jack Khodr</h2>
    </div>
    <div class="roland section">
      <a href="https://www.linkedin.com/in/roland-sanner/"><img src="./../assests/roland.jpg" alt="roland"></a>
      <h2>Roland Sanner</h2>
    </div>
    <div class="colin section">
      <a href="https://www.linkedin.com/in/colinwmcgregor/"><img src="./../assests/colin.jpg" alt="colin"></a>
      <h2>Colin Mcgregor</h2>
    </div>
    <div  class="drew section">
      <a href="https://www.linkedin.com/in/reed-drew/"><img src="./../assests/drew.jpg" alt="drew"></a>
      <h2>Drew Reed</h2>
    </div>
  </div>
</template>


<script>

export default {
  name: "AboutUs"
}
</script>

<style scoped>

  .aboutus {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
      "jack roland"
      "colin drew"
    ;
    align-items: center;
  }

  .aboutus img {
    max-height: 300px;
    width: auto;
  }

  h2 {
    display: flex;
    justify-content: center;
    margin: 0;
  }

  .section {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 25px 0 25px 0;
    flex-grow: 1;
    flex-direction: column;
  }

  .jack {
    grid-area: jack;
  }
  .colin {
    grid-area: colin;
  }
  .roland {
    grid-area: roland;
  }
  .drew {
    grid-area: drew;
  }


</style>