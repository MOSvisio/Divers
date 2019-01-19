#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>

int main(int argc, char *argv[]){
  int n;
  scanf("%d",&n);
  char ** tableau = malloc(n*sizeof(char*));
  for(int i=0; i<n;i++){
    tableau[i] = malloc(255 * sizeof(char));
  }

  char chaine[255];

  for(int i=0; i<n; i++){
    scanf("%s", chaine);
    for(int j=0; j<strlen(chaine)+1 ;j++){
      if (j!=strlen(chaine))
        tableau[i][j] = chaine[j];
      else
        tableau[i][j] = '\0';
    }
  }

  printf("\n");

  for(int i=0; i<n; i++){
    for(int j=0; j<256 ;j++){
      printf("%c", tableau[i][j]);
    }
    printf("\n" );
  }

  for(int i=0; i<n; i++){
    for(int j=0; j<256 ;j++){
      free(tableau[i]);
    }
  }
  free(tableau);
}
