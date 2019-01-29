#ifndef EMPLOI_H
#define EMPLOI_H
#include "employe.h"

using namespace std;

class Manutentionnaire : public employe{
    private : 
        int nombreHeure;
    
    public :
        Manutentionnaire(int,string,string,int);
        float Salaire();
        void afficher();
};

class Technicien : public employe{
    private : 
        int nombreUnite;
    public :
        Technicien(int, string, string, int);
        float Salaire();
        void afficher();
};

class Representant : public employe{
    private :
        int chiffreAffaire;
    public :
        Representant(int, string, string, int);
        float Salaire();
        void afficher();
};

class Vendeur : public employe{
    private : 
        int chiffreAffaire;
    public :
        Vendeur(int, string, string, int);
        float Salaire();
        void afficher();
};


#endif