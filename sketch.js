var x;
var y;
var reussi = 0;
var total = 0;
var pie;
var r = 250


function setup() {
  createCanvas(1000, 500);
  background(255);
  ellipse(0,0, r*2,r*2);
}

function draw() {
    x = int(random(0,101))*5;
    y = int(random(0,101))*5;
    if(Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) <= r*2){
      fill(210);
      ellipse(x/2,y/2,5,5);
      reussi++;

    } else {
      fill(0);
      ellipse(x/2,y/2,5,5);
    }
    total++;
  pie = 4*(reussi/float(total));
  fill(255);
  noStroke();
  rect(300,0,350,200);
  fill(0);
  textSize(32);
  text(pie, 300, 50);
  text(total,300,100);
  print(pie);
}
