#ifndef EMPLOYE_H
#define EMPLOYE_H
#include <iostream>
#include <string.h>

using namespace std;

class employe{
    protected :
        string nom;
        string prenom;
        int age;

    public :
        employe(string, string, int);
        string getNom();
        string getPrenom();
        int getAge();
        void setNom(string);
        void setPrenom(string);
        void setAge(int);

        virtual float Salaire(int, float);
        void afficher();

};



#endif