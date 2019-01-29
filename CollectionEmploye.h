#ifndef COLLECTIONEMPLOYE_H
#define COLLECTIONEMPLOYE_H
#include"employe.h"

class CollectionEmploye{

    private:
        employe * tab;
        int nb_employe;

    public:
        CollectionEmploye();
        void afficher();
        void ajouterEmploye();
        float salaireMoyen();
};


#endif
