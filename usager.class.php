<?php
    require_once"connection.class.php";
    define('USAGER_FILE', 'usager.json');

class Usager {

    private $nom;
    private $num_carte;
    private $lib_categ;
    private $date_carte;
    private $mt_caution;

    public function __construct(
        $nom = null,
        $num_carte = null,
        $lib_categ = null,
        $mt_caution = null
    ) {
        $this->setNom($nom);
        $this->setNumCarte($num_carte);
        $this->setLib($lib_categ);
        $this->setDate(date("Y-m-d"));
        $this->setMtCaution($mt_caution);

    }

    public function setNom($nom){
        $this->nom = $nom;
    }

    public function getNom(){
        return $this->nom;
    }

    public function setNumCarte($num){
        $this->num_carte = $num;
    }

    public function getNumCarte(){
        return $this->num_carte;
    }

    public function setLib($lib){
        $this->lib_categ = $lib;
    }

    public function getCategorie(){
        return $this->lib_categ;
    }

    public function setDate($date){
        $this->date_carte = $date;
    }

    public function setMtCaution($mt){
        $this->mt_caution = $mt;
    }

    public function getMtCaution(){
        return $this->mt_caution;
    }

    public function getDate(){
        return $this->date_carte;
    }

    public static function get($num_carte){
        $db = Connexion::get();
        $result = $db->query("SELECT * FROM USAGER, CATEGORIE WHERE USAGER.num_categ = CATEGORIE.num_categ AND num_carte='$num_carte'");
        if ($usager = $result->fetch()){
            return new Usager($usager['nom'], $usager["num_carte"], $usager['lib_categ'], $usager['date_carte'], $usager['mt_caution']);
        }
        return FALSE;
    }

    public static function getUsagers(){
        $db = Connexion::get();
        $result = $db->query("SELECT nom, num_carte FROM USAGER");
        $usagers = $result->fetchAll();
        return $usagers;
    }

    public static function getName(){
        $db = Connexion::get();
        $result = $db->query("SELECT nom FROM USAGER");
        $nom = $result->fetchAll();
        return $nom;
    }

    public static function usagerExist($num_carte) {
        $db = Connexion::get();
        $result = $db->query("SELECT * FROM USAGER WHERE num_carte='$num_carte'");
        return $result->fetch();
    }

    public function save() {
        $db = Connexion::get(); 
        if (!self::usagerExist($this->getNumCarte())){
            try {
              var_dump( $this->toArray());
              $prepare = $db->prepare("INSERT INTO USAGER (num_carte, nom, num_categ, mt_caution, date_carte) VALUE (:num_carte, :nom, :num_categ, :mt_caution, :date_carte)");
              $insert = $prepare->execute($this->toArray());
            } catch (PDOException $e){
              return FALSE; 
            }
          return TRUE; 
        }
        return FALSE;
    }

    public function toArray() {
        return array(
          'nom' => $this->getNom(),
          'num_carte' => $this->getNumCarte(),
          'num_categ' => $this->getNumCateg($this->lib_categ),
          'date_carte' => $this->getdate(),
          'mt_caution' => $this->getMtCaution(),
        );
    }

    public function getNumCateg($lib_categ){
        $db = Connexion::get();
        $result = $db->query("SELECT num_categ FROM CATEGORIE WHERE lib_categ = '$lib_categ'");
        $toSend = $result->fetch();
        return $toSend[0];
    }

}
