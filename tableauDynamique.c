#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>

int main(int argc, char* argv[]){
  int i = 0;
  char * pointeur = (char *)malloc(20*sizeof(char));
  if(pointeur == NULL){
    printf("L'allocation n'a pu etre réalisée\n");
  }
  else{
    for(i = 0; i<20;i++){
      pointeur[i] = 'A' + (random()%52);
    }
  }
  for(i = 0; i<(20);i++){
    printf("%c", pointeur[i]);
  }
  printf("\n");

  int choix;
  scanf("%d",&choix);
  pointeur = realloc(pointeur, sizeof(char) * choix);
  for(i = 0; i<choix;i++){
    pointeur[i] = 'A' + (random()%52);
  }
  for(i = 0; i<(choix);i++){
    printf("%c", pointeur[i]);
  }
  printf("\n");

  free(pointeur);
  pointeur=NULL;
}
