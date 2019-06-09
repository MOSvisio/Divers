<?php
  session_start();
  
  $error = false; 
  
  if (!empty($_POST)){
    if (!empty($_POST["login"]) && !empty($_POST["password"])){
      if($_POST["login"] === "admin" && $_POST["password"] === "password"){
        $_SESSION["success_message"] = "Success login process";
        $_SESSION["user"] = "admin";
      }   
    }
  }

  if ($error){
    $_SESSION["error_message"] = $error;
  }
  
  header("location:index.php");
  die;
  