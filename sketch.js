var x1, y1;
var x2, y2;

x1 = 200;
y1=300;

x2 = x1 + 50;
y2 = y1 + 50;

function setup() {
  createCanvas(400, 400);
}

function draw() {
  line(200,200,x1,y1);
  ellipse(x1,y1, 10,10);

  line(x1,y1,x2,y2);
  ellipse(x2,y2,10,10);
  noLoop();
}
