const box = document.querySelector("#box");
const bar = document.querySelector("#container");
let speed = 1;
const clicked = false;

function move(target, distance) {
  const actualPosition = parseInt(getComputedStyle(target).left);
  target.style.left = actualPosition + distance + "px";

  setTimeout(() => move(target, speed), 5);

  console.log()

  if (parseInt(getComputedStyle(bar).width) < actualPosition + parseInt(getComputedStyle(target).width)) {
    speed = -1;
  } else if (actualPosition < 0) {
    speed = 1;
  }

}


box.addEventListener("click", () => {
    move(box, speed);
});