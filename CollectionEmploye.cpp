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
   cout << "entrer un chiffre: 1) cr�e un manutentionnaire, 2) cr�e un Technicien, 3) cr�e un Representant, 4) cr�e un vendeur\n";
   int reponse;
   int age;
   string prenom;
   string nom;
   int valeur;
   cin >> reponse;

   cout << "entrer le pr�nom de la personne\n";
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
