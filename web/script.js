var button = document.getElementById("button");
var ul = document.getElementById("scroll").children[0];
var first_card = document.getElementById("first-card");
var frame = document.getElementById("frame");
var ul_margin_left = Number(ul.style.marginLeft);
var frame = document.getElementById("frame");
var woo = document.getElementById("woo");
var left = 200;

button.addEventListener("click", function() {
  first_card.style.display = "none";
  woo.style.backgroundImage = "none";

  button.style.animationName = "button_bg_change";
  button.style.animationDuration = "2s";
  button.style.animationIterationCount = 1;
  button.innerHTML = "Hide";
  
  //frame.style.backgroundImage = "url('http://www.olgame.tw/lm/css/lmimg/gacha/card_shine2_106x123.png')";
  
  frame.style.backgroundPosition = "center";
  frame.style.backgroundSize = "120%";
  frame.id = "pop_shine";
  //frame.style.animation = "none";

  setTimeout(function(){
    frame.style.animation = "none";
    frame.style.opacity = 0;
  },300)

  setTimeout(function(){
    ul.style.display = "block";
    var setTimeInterval = setInterval(changePerson, 20); 

    function changePerson() {
      console.log(left);    
      ul_margin_left = ul_margin_left - left;
      ul.style.marginLeft = ul_margin_left + "px";

      if (left < 50 & left > 0) {
         left = left - 1;
      } else if (left < 100 & left >= 50) {
        left = left - 2;
      } else if (left < 150 & left >= 100) {
        left = left - 3;
      } else if (left <= 200 & left >= 150) {
        left = left - 15;
      } else {
        left = 4;
      }

      
      if (Number(ul_margin_left) < -5660) {
        clearInterval(setTimeInterval);

        ul_margin_left = ul_margin_left - 18;
        ul.style.marginLeft = ul_margin_left + "px";
        
        setTimeout(function(){
          ul.style.display = "none";
          frame.style.animationName = "frame";
          frame.style.animationDuration = "0.5s";
          frame.style.animationIterationCount = 1;
        },100)

        setTimeout(function(){
          frame.style.animation = "woo 1s steps(29) infinite";
          frame.style.opacity = 0;
          ul.style.display = "block";
          woo.style.backgroundImage = "none";
          frame.style.backgroundSize = "cover";
          frame.id = "woo2";
          frame.animation = "none";
          frame.style.opacity = 1;
        },500)
        
      }
    }

  },200)

})
