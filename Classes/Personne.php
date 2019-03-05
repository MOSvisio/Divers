<?php
  class Personne{
    private $nom;
    private $prenom;
    private $age;
    private $sexe;

    public function __construct($nom, $prenom, $age, $sexe){
      $this->nom = $nom;
      $this->prenom = $prenom;
      $this->age = $age;
      $this->sexe = $sexe;
    }

    public function getNom(){
      return $this->nom;
    }

    public function getPrenom(){
      return $this->prenom;
    }

    public function getAge(){
      return $this->age;
    }

    public function getSexe(){
      return $this->sexe;
    }

    function __toString(): string{
      return $this->getNom() . ' ' . $this->getPrenom() . ' ' . $this->age . ' ' . $this->sexe;
    }
  }




?>
