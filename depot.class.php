<?php
    require_once"connection.class.php";
    define('DEPOT_FILE', 'depot.json');

class Depot{
    private $num_carte;
    private $date_depot;
    private $montant;


    public function __construct(
        $nom = null,
        $montant = null
    ) {
        $this->num_carte = $this->getNumCarteByUsager($nom);
        $this->date_depot = date("Y-m-d");
        $this->montant = $montant;
    }

    public function getNumCarteByUsager($usager){
            $db = Connexion::get();
            $result = $db->query("SELECT num_carte FROM USAGER WHERE nom = '$usager'");
            $toSend = $result->fetch();
            return $toSend[0];
    }

    public function save() {
        $db = Connexion::get(); 
        //if (!self::usagerExist($this->getNumCarte())){
            try {
              var_dump( $this->toArray());
              $prepare = $db->prepare("INSERT INTO DEPOT (num_carte, date_depot, montant) VALUE (:num_carte, :date_depot, :montant)");
              $insert = $prepare->execute($this->toArray());
            } catch (PDOException $e){
              return FALSE; 
            }
          return TRUE; 
        //}
        //return FALSE;
    }

    public function toArray() {
        return array(
          'num_carte' => $this->getNumCarte(),
          'date_depot' => $this->getDate(),
          'montant' => $this->getMontant(),
        );
    }

    public function getNumCarte(){
        return $this->num_carte;
    }

    public function getDate(){
        return $this->date_depot;
    }

    public function getMontant(){
        return $this->montant;
    }

    public function depotExist(){
        $num_carte = $this->num_carte;
        $date_depot = $this->getDate();
        $montant = $this->getMontant();
        $db = Connexion::get();
        $result = $db->query("SELECT * FROM DEPOT WHERE num_carte='$num_carte' AND date_depot='$date_depot' AND montant='$montant'");
        return $result->fetch();
    }
    
}
