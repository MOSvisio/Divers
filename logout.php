<?php
  session_start();
  $error = false; 
  
  if (empty($_SESSION["user"])){
    $error = "You are not logged"; 
  }else{
    session_unset();
    session_destroy();
  }
  
  if ($error){
    $_SESSION["error_message"] = $error;
  }
  
  header("location:index.php");
  die;