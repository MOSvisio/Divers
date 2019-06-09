<?php
  require_once "./depot.class.php";
  session_start();
  
  $error = false; 
  if (!empty($_POST)){
    $requireFields = array("Utilisateur", "montant");
    foreach ($requireFields as $field){
      if (empty($_POST[$field])){
        $error .= "Field $field can't be empty <br />";
      }
    }
    $depot = new Depot($_POST["Utilisateur"], $_POST["montant"]);
    if (!$error){
      if (!$depot->depotExist()){
        $depot->save();
        $_SESSION["success_message"] = "Account created";
        /*
        
         $name = null,
    $surname = null,
    $login = null,
    $password = null
    */
      }else{
        $error = "Depot already exist"; 
      }
    }
    
  }else{
    $error = "Fields can't be empty";
  }
  
  if ($error){
    $_SESSION["error_message"] = $error;
  }
  header("location:pageCreateDepot.php");
  die;