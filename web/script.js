var img = document.getElementById("img");
//people animation
var ul = document.getElementById("people");
var ul_style = Number(ul.style.marginLeft);

//click open and hide first card
var click_open = document.getElementById("click_open");

click_open.addEventListener("click", function(){
  var img = document.getElementById("img");
  var card = document.getElementById("card");
  img.style.backgroundImage = "none";
  img.style.backgroundImage = "url('http://www.olgame.tw/lm/css/lmimg/gacha/card_shine2_106x123.png')";
  card.style.animation = "none";
  card.style.background = "none";
  var out = document.getElementById("out");
  var item = document.getElementById("item");
  var woo = document.getElementById("woo");
  function back_none() {
    img.style.backgroundImage = "none";
    item.style.display = "block";
    woo.style.backgroundImage = "none";
    out.style.backgroundImage = "url('http://www.olgame.tw/lm/css/lmimg/gacha/card_slot_82x100.png')";

    var set_interval = setInterval(run, 20);

    function run() {
      ul_style = (ul_style - 50);
      if (ul_style <= -1440) {
        clearInterval(set_interval);
        woo.style.backgroundImage = "url('http://www.olgame.tw/lm/css/lmimg/gacha/card_aura_gray_128x128.png')";
        out.style.backgroundPosition = "left";
      }
      ul.style.marginLeft = ul_style + "px";
    }
  }
  setTimeout(function(){ back_none(); }, 100);
  
})
