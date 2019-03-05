<?php

class user{
  private $nom;
  private $prenom;
  private $login;
  private $mdp;

  public function __construct($nom, $prenom, $login, $mdp){
    $this->setNom($nom);
    $this->setPrenom($prenom);
    $this->setLogin($login);
    $this->setMdp($mdp);
  }

  public function getNom(){
    return $this->nom;
  }
  public function setNom($nom){
    $this->nom = $nom;
  }
  public function getPrenom(){
    return $this->prenom;
  }
  public function setPrenom($prenom){
    $this->prenom = $prenom;
  }
  public function getLogin(){
    return $this->login;
  }
  public function setLogin($login){
    $this->login = $login;
  }
  public function getMdp(){
    return $this->mdp;
  }
  public function setMdp($mdp){
    $this->mdp = password_hash($mdp, PASSWORD_DEFAULT);
  }

  private function toArray() : array{
    $tab = array(
      "name" => $this->getNom(),
      "prenom" => $this->getPrenom(),
      "login" => $this->getLogin(),
      "password" => $this->getMdp(),
    );
    return $tab;
  }

  /**
  *
  * vérifie si un user avec le même login n'existe pas déjà
  * dans la base
  * retourne un bool
  */
  private function existe(){
    $file_content = file_get_contents('classes/collection/users.json');
    $json_data = json_decode($file_content, true);
    foreach($json_data as $v){
      if ($v['login'] === $this->getLogin()){
        return false;
      }
    }
    return true;
  }

/**
*
*Sauvegarde l'utilisateur dans le fichier Json
*vérifie aussi si il n'a pas déjà était ajouté
*
*/
  public function save(){
    if($this->existe()){
      $data = self::getAll();
      $data[$this->getLogin()] =  $this->toArray();
      file_put_contents('classes/collection/users.json', json_encode($data));
      echo "utilisateur ajouter à la base json";
    } else {
      echo "l'utilisateur existe déjà dans la base Json";
    }
  }

  /**
  * récupere tout les utilisateurs sous la formes d'un array
  */
  public static function getAll() : Array{
    $file_content = file_get_contents('classes/collection/users.json');
    return $json_data = json_decode($file_content, true);
  }


  /**
  * récupérer une classe d'un user existant sinon retourne nul
  */
  public static function getUser($login, $mdp){
    $json_data = self::getAll();
    foreach($json_data as $v){
      if($v['login'] === $login && password_verify($mdp,$v['password'])){
        return new User(
          $v['name'],
          $v['prenom'],
          $v['login'],
          $v['password']
        );
      }
    }
    return null;
  }

  /**
  * retourne l'user sous forme de string
  * faire en sorte de le récupérer depuis le json car le mdp change à chaque fois
  */
  public function toString() : string{
    return "Login : " . $this->login . " nom : " . $this->getNom() . " prenom : " . $this->getPrenom() . " login : " . $this->getLogin() . " password : " . $this->getMdp();
  }

}

?>
