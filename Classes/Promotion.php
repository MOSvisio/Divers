<?php

class Promotion{
  public $libelle;
  private $etudiant = [];

  public function __construct(){
    $this->libelle = "none";
  }

  public function addEtudiant($etudiant){
    array_push($this->etudiant, $etudiant);
  }

  public function getNombreEtudiants(){
    return count($this->etudiant);
  }

  public function getMoyenne(){
    $totalMoy = 0;
    foreach($this->etudiant as $valeur){
      $totalMoy += $valeur->getNote();
    }
    return $totalMoy / $this->getNombreEtudiants();
  }

  public function getEtudiant($nom, $prenom){
    foreach($this->etudiant as $valeur){
      if($valeur->getNom() == $nom && $valeur->getPrenom() == $prenom){
        return $valeur;
      }
    }
    return false;
  }

}


?>
