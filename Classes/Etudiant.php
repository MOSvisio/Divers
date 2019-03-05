<?php
  include_once 'Classes/Personne.php';
  class Etudiant extends Personne{
    private $note;

    public function __construct($nom, $prenom, $age, $sexe, $note){
        $this->note = $note;
        parent::__construct($nom, $prenom, $age, $sexe);
    }

    function __toString(): string{
      return $this->getNom() . ' ' . $this->getPrenom() . ' ' . $this->getAge() . ' ' . $this->getSexe() . ' '. $this->getNote();
    }

    public function getNote(){
        return $this->note;
    }

    public function setNote($note){
      $this->note = $note;
    }
  }

?>
