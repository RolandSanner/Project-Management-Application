<template>
  <div class="aboutus">
    <div class="jack section">
      <a href="https://www.linkedin.com/in/jackkhodr/"
        ><img src="./../assests/jack.jpg" alt="jack"
      /></a>
      <h2>Jack Khodr</h2>
      <p>
        Jack Khodr's civil engineering and project management background has
        shaped him into a problem solver, and finding solutions to other
        people's problems is a passion. Integrating both those skills into
        coding came both generic and natural. Jack love listening to podcasts
        and audiobooks, the wisdom and knowledge gained have been indispensable.
        Sir Isaac Newton once said, If I have seen further, it is by standing on
        the shoulders of giants. Having access to the minds of great thinkers
        and leaders has opened Jack's eyes to how essential technology has been
        in reducing the friction in propagating information around the world.
      </p>
      <br />

      <a href="https://github.com/RolandSanner" class="github">GitHub</a
      ><a href="mailto: Sanner.roland@gmail.com" class="email">Email</a>
    </div>
    <div class="roland section">
      <a href="https://www.linkedin.com/in/roland-sanner/"
        ><img src="./../assests/roland.jpg" alt="roland"
      /></a>
      <h2>Roland Sanner</h2>
      <p>
        Roland Sanner is a Pragmatic, solutions-focused and results-driven
        United States Marine Corps Veteran, who is passionate about creating
        strategies to maximize efficiency. Cross-pollinator, motivated to expand
        and advance multi-disciplinary work history into a software development
        position. Roland loves to travel the world and believes you should never
        stop learning or limit yourself on what you believe isn't possible. 
      </p>
      <br />

      <a href="https://github.com/RolandSanner" class="github">GitHub</a
      ><a href="mailto: Sanner.roland@gmail.com" class="email">Email</a>
      <br />
    </div>
    <div class="colin section">
      <a href="https://www.linkedin.com/in/colinwmcgregor/"
        ><img src="./../assests/colin.jpg" alt="colin"
      /></a>
      <h2>Colin McGregor</h2>
      <p>
        Colin McGregor is a Tech Elevator Java Web Development graduate. Hard
        worker with a history of success in multiple industries and locations
        looking to start a career in software development. Colin has a wealth of
        experiences in a variety of disciplines that have all helped craft him
        into the programmer he is today. Whether I was working with children on
        the west coast of Japan, teaching business professionals in the heart of
        Prague, or plating desserts at the Ritz-Carlton in the Virgin Islands,
        I've always been forced to hit the ground running and adapt as I go.
      </p>
      <br />

      <a href="https://github.com/RolandSanner" class="github">GitHub</a
      ><a href="mailto: Sanner.roland@gmail.com" class="email">Email</a>
    </div>
    <div class="drew section">
      <a href="https://www.linkedin.com/in/reed-drew/"
        ><img src="./../assests/drew.jpg" alt="drew"
      /></a>
      <h2>Drew Reed</h2>
      <p>
        Drew Reed is a Jr Full-Stack Developer out of Tulsa, OK. With a
        background in medicine, 12 years a paramedic, he learned to love
        science. While attending Roger’s State University he learned about
        computer science. They say the rest is history. Now holding a degree in
        computer science and a recent graduate from Tech Elevator bootcamp he is
        looking to further his knowledge of programming.
      </p>
      <br />

      <a href="https://github.com/drew-a-reed" class="github">GitHub</a
      ><a href="mailto: drew.reed@hotmail.com" class="email">Email</a>
    </div>
  </div>
</template>


<script>
export default {
  name: "AboutUs",
};
</script>

<style scoped>
.aboutus {
  display: grid;
  background: whitesmoke;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "jack roland"
    "colin drew";
  align-items: center;
}

.aboutus img {
  max-height: 300px;
  width: auto;
  border-radius: 12%;
  box-shadow: 2px 10px 20px rgb(17, 17, 17);
  transition: all 0.9s ease;
}
.aboutus img:hover {
  box-shadow: 0 0 20px rgb(48, 46, 77, 0.15);
  transition: all 0.5s ease;
}

h2 {
  padding-top: 30px;
  display: flex;
  justify-content: center;
  color: rgb(0, 0, 153);
  margin: 0;
}
.github{
  font-weight: bold;
  font-size: 22px;
  color: rgb(0, 0, 153);
  margin: 0;
}
.email{
  font-weight: bold;
  font-size: 22px;
  padding-top: 30px;
  color: rgb(0, 0, 153);
  margin: 0;
}
.section {
  color: rgb(83, 83, 83);
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
.section p {
  font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
  font-weight: 600;
  font-size: 18px;
  padding-top: 30px;
  display: flex;
  justify-content: center;
  max-width: 50%;
  background-color: whitesmoke;
}
</style>