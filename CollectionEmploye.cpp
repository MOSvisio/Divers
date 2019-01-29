#include"CollectionEmploye.h"

CollectionEmploye::CollectionEmploye(){
   this->nb_employe = 0;
   this->tab = malloc(sizeof(employe) * 1);
}

void CollectionEmploye::afficher(){
   for(int i=0; i<this->nb_employe; i++){
      this->tab[i]->afficher();
   }
}

float CollectionEmploye::salaireMoyen(){
   int count = 0;
   for(int i=0; i<this->nb_employe; i++){
      count = count + this->tab[i]->Salaire();
   }
   return count/this->nb_employe;
}


void CollectionEmploye::ajouterEmploye(){
   this->nb_employe++;
   this->tab = realloc(tab, sizeof(employe) * this->nb_employe);
   cout << "entrer un chiffre: 1) crée un manutentionnaire, 2) crée un Technicien, 3) crée un Representant, 4) crée un vendeur\n";
   int reponse;
   int age;
   string prenom;
   string nom;
   int valeur;
   cin >> reponse;

   cout << "entrer le prénom de la personne\n";
   cin >> prenom;
   cout << "entrer le nom de la personne\n";
   cin >> nom;
   cout << "entrer l'age de la personne\n";
   cin >> age;
   cout << "entrer la valeur\n";
   cin >> valeur;

   switch(reponse){
     case 1 : this->tab[this->nb_employe - 1] = new Manutentionnaire test(valeur,nom, prenom, age);
          break;
     case 2 : this->tab[this->nb_employe - 1] = new Technicien test(valeur,nom, prenom, age);
          break;
     case 3 : this->tab[this->nb_employe - 1] = new Representant test(valeur,nom, prenom, age);
          break;
     case 4 : this->tab[this->nb_employe - 1] = new Vendeur test(valeur,nom, prenom, age);
          break;
   }
}
