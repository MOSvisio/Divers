#include "emploi.h"

//Manutentionnaire
Manutentionnaire::Manutentionnaire(int i,string n, string p, int a) : employe(n,p,a){
    this->nombreHeure = i;
}

float Manutentionnaire::Salaire(){
    return employe::Salaire(this->nombreHeure,10);
}

void Manutentionnaire::afficher(){
    employe::afficher();
    cout << " nombre d'heures : " << this->nombreHeure << " Salaire : " << Manutentionnaire::Salaire() << "\n";
}


//Technicien
Technicien::Technicien(int i, string n, string p, int a) : employe(n,p,a) {
    this->nombreUnite = i;
}

float Technicien::Salaire(){
    return employe::Salaire(this->nombreUnite,2);
}

void Technicien::afficher(){
    employe::afficher();
    cout << "nombre d'unité: " << this->nombreUnite << " Salaire : " << Technicien::Salaire() << "\n";
}

//Representant
Representant::Representant(int i, string n, string p, int a) : employe(n,p,a){
    this->chiffreAffaire = i;
}

float Representant::Salaire(){
    return employe::Salaire(this->chiffreAffaire,0.2) + 120;
}

void Representant::afficher(){   
    employe::afficher();
    cout << "chiffre d'affaire : " << this->chiffreAffaire << " Salaire : " << Representant::Salaire() << "\n";
}

//Vendeur
Vendeur::Vendeur(int i, string n, string p, int a) : employe(n,p,a) {
    this->chiffreAffaire = i;
}

float Vendeur::Salaire(){
    return employe::Salaire(this->chiffreAffaire,0.2) + 60;
}

void Vendeur::afficher(){
    employe::afficher();
    cout << "chiffre d'affaire : " << this->chiffreAffaire << " Salaire : " << Vendeur::Salaire() << "\n";
}