#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>


typedef struct{
  int x;
  int y;
  int z;
}coordonnees;

void initialize(coordonnees *c){
  c->x=10;
  c->y=5;
  c->z=2;
}

void affichage(coordonnees *c){
  printf("%d %d %d\n", c->x, c->y, c->z);
}

void multiplication(coordonnees *c){
  c->z = c->x * c->y;
  affichage(c);
}

void addition(coordonnees *c){
  c->z = c->x + c->y;
  affichage(c);
}

int main(int argc, char *argv[]){
  coordonnees ici;
  coordonnees* pointeurIci = &ici;
  initialize(pointeurIci);
  affichage(pointeurIci);
  multiplication(pointeurIci);
  addition(pointeurIci);
}
