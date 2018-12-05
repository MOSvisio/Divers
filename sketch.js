
var x1, y1;
var x2, y2;
var l1, l2;
var m1, m2;
var teta1, teta2;
var v_l1, v_l2;
var a_l1, a_l2;
var g = 1;
var pg;
var dessinx = [];
var dessiny = [];

l1 = 200.0;
l2 = 100.0;
m1 = 32;
m2 = 30;

v_l1 = 0.0;
v_l2 = 0.0;
a_l1 = 0.0;
a_l2 = 0.0;


function setup() {
  createCanvas(1000, 1000);
  pg = createGraphics(1000,1000);
  teta1 = PI/2;
  teta2 = PI/2;
	dessinx = [l1 * sin(teta1),l1 * cos(teta1)];
	dessiny =  [x1 + l2 * sin(teta2),x1 + l2 * cos(teta2)];
}

function draw() {
	dessinx[0] = dessinx[1];
	dessiny[0] = dessiny[1];
  background(255);

  translate(500,500);

  var a_l1Num =  -g*(2*m1 + m2)*sin(teta1) - m2*g*sin(teta1-2*teta2) - 2*sin(teta1-teta2)*m2*(pow(v_l2,2)*l2 + pow(v_l1,2)*l1*cos(teta1-teta2));
  var a_l1Denum = l1 * (2*m1 + m2 - m2 * cos(2*teta1-2*teta2));
  a_l1 = float(a_l1Num / a_l1Denum);

  var a_l2Num = 2*sin(teta1-teta2)*(pow(v_l1,2)*l1*(m1+m2)+g*(m1+m2)*cos(teta1) + pow(v_l2,2)*l2*cos(teta1 - teta2));
  var a_l2Denum = l2*(2*m1+m2-m2*cos(2*teta1-2*teta2));
  a_l2 = float(a_l2Num / a_l2Denum);

  x1 = l1 * sin(teta1);
  y1 = l1 * cos(teta1);

  x2 = x1 + l2 * sin(teta2);
  y2 = y1 + l2 * cos(teta2);

  line(0,0,x1,y1);
  ellipse(x1,y1, m1,m1);
  line(x1,y1,x2,y2);
  ellipse(x2,y2, m2,m2);

  v_l1 = v_l1 + a_l1;
  v_l2 = v_l2 + a_l2;
  teta1 = teta1 + v_l1;
  teta2 = teta2 + v_l2;
	dessinx[1] = x2;
	dessiny[1] = y2;

	pg.stroke('red');
	pg.line(dessinx[0]+500,dessiny[0]+500,dessinx[1]+500,dessiny[1]+500);

  image(pg,-500,-500);

}
