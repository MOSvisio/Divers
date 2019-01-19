#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>

int main(int argc, char * argv[]){
  int ** matrice = (int **)malloc(5 * sizeof(int*));
  for(int i = 0; i<5 ; i++){
    matrice[i] = malloc(5*sizeof(int));
  }

  printf("entrez les nouvelles tailles de la matrice");

  int n,m;
  scanf("%d", &n);
  scanf("%d", &m);

  matrice = realloc(matrice, n * sizeof(int*));
  for(int i = 0; i<n ; i++){
    matrice[i] = realloc(matrice[i],m*sizeof(int));
  }

  for(int i=0; i<n;i++){
    for(int j=0; j<m;j++){
      matrice[i][j] = random()%10;
    }
  }

  for(int i=0; i<n;i++){
    for(int j=0; j<m;j++){
      printf("%d", matrice[i][j]);
    }
    printf("\n");
  }

  for(int i=0; i<n;i++){
    for(int j=0; j<m;j++){
      free(matrice[i]);
    }
  }
  free(matrice);
}
