<?php
  require_once "./usager.class.php";
  session_start();
  
  $error = false; 
  if (!empty($_POST)){
    $requireFields = array("nom", "num_carte", "lib_categ", "mt_caution");
    foreach ($requireFields as $field){
      if (empty($_POST[$field])){
        $error .= "Field $field can't be empty <br />";
      }
    }
    
    if (!$error){
      if (!Usager::usagerExist($_POST["nom"])){
        $usager = new Usager($_POST["nom"], $_POST["num_carte"], $_POST["lib_categ"], $_POST["mt_caution"]);
        $usager->save();
        $_SESSION["success_message"] = "Account created";
        /*
        
         $name = null,
    $surname = null,
    $login = null,
    $password = null
    */
      }else{
        $error = "Usage already exist"; 
      }
    }
    
  }else{
    $error = "Fields can't be empty";
  }
  
  if ($error){
    $_SESSION["error_message"] = $error;
  }
  header("location:pageCreateUsager.php");
  die;