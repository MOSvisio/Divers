#include<iostream>
#include<stdlib.h>
#include<string.h>
#include"employe.h"
#include"emploi.h"

using namespace std;

int main(){

   employe em("SCHUTZ","Lucas",21);
   Manutentionnaire test(100,"SCHUTZ", "Lucas", 21);
   Vendeur vendu(10,"DAUFFER", "Quentin", 3);
   em = vendu;
   em.afficher();
   test.afficher();
   vendu.afficher();
}