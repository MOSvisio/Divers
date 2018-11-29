#include<iostream>
#include<stdlib.h>

using namespace std;

int *Lire(int nb);
void afficher(int *Tab, int nb);
int *changerPlace(int *Tab, int a, int b);
void TriTableau(int *Tab, int nb);

int main(){
    int *Tab; int nb;
    cout << "entrer la valeur de n : ";
    cin >> nb;
    Tab = Lire(nb);

    TriTableau(Tab, nb);
    cout << '\n';
    afficher(Tab, nb);
    return 0;
    free(Tab);
}

void TriTableau(int *Tab, int nb){
    for(int k=0;k<nb;k++){
        for(int l=k;l<nb;l++){
            if(Tab[k]>Tab[l]){
                Tab = changerPlace(Tab,l,k);
            }
        }
    }
}

int *changerPlace(int *Tab, int a, int b){
    int z = Tab[a];
    Tab[a] = Tab[b];
    Tab[b] = z;
    return Tab;
}

int *Lire(int nb){
    int *array;
    array = (int*)malloc(sizeof(int) * nb);
    cout << "entrez vos valeurs \n";
    for(int i=0;i<nb;i++){
        cin >> array[i];
    }

    return array;
}

void afficher(int *Tab, int nb){
    for(int j=0;j<nb;j++){
        cout << Tab[j] << '\n';
    }
}
