<?php
  require_once "SmartyIUT.class.php"; 
  session_start();
  $isLogged = !empty($_SESSION["user"]);

  $classError = !empty($_SESSION["error_message"]) ? "show" : "hide"; 
  $errorMessage = !empty($_SESSION["error_message"]) ? $_SESSION["error_message"] : false;
  
    
  $classSuccess = !empty($_SESSION["success_message"]) ? "show" : "hide"; 
  $successMessage = !empty($_SESSION["success_message"]) ? $_SESSION["success_message"] : false;
  
  if ($isLogged){
    $user = $_SESSION["user"];
  } else $user = "none";
  if ($errorMessage){ unset($_SESSION["error_message"]); }
  if ($successMessage){ unset($_SESSION["success_message"]); }
  
  $smarty = new SmartyIUT();
    $smarty->assign("classSuccess", $classSuccess);
    $smarty->assign("successMessage", $successMessage);
    $smarty->assign("isLogged", $isLogged);
    $smarty->assign("user", $user);
    $smarty->assign("classError", $classError);
    $smarty->assign("errorMessage", $errorMessage);
  $smarty->display("forms/menu.form.tpl");
  $smarty->display("layout.tpl");