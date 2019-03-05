<?php
  include 'Classes/Personne.php';
  include 'Classes/Etudiant.php';
  include 'Classes/Promotion.php';

  $personne1 = new Personne('lucas','schutz',21,'male');
  $personne2 = new Personne('anais','Dauffer',22,'femelle');
  $personne3 = new Personne('jean-paul','Sartre',999,'male');
  $etudiant1 = new Etudiant('petit','pierre',21,'male',10.5);
  $promo = new Promotion();
  $promo->libelle = "AS 2014";
  $promo->addEtudiant($etudiant1);

  echo $personne1;
  echo "</br>";
  echo $etudiant1;
  echo "</br>";
  echo $promo->getNombreEtudiants();
  echo "</br>";
  $a =  $promo->getEtudiant('petit','pierre');

  echo $a->getNom();
  echo "</br>";
  echo $a->getNote();
?>
