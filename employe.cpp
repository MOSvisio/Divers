#include"employe.h"


employe::employe(string nom, string Prenom, int age){
    this->nom = nom;
    this->prenom = Prenom;
    this->age = age;
}

int employe::getAge(){return this->age;}
string employe::getNom(){return this->nom;}
string employe::getPrenom(){return this->prenom;}

void employe::setNom(string s){
    this->nom = s;
}
void employe::setPrenom(string s){
    this->prenom = s;
}
void employe::setAge(int i){
    this->age = i;
}

float employe::Salaire(){
    return 0;
}

void employe::afficher(){
    cout << "Nom : " << this->nom << " Prénom : " << this->prenom << " age : " << this->age;
}

