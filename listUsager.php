<?php
  require_once "usager.class.php";
  require_once "SmartyIUT.class.php"; 
  session_start();
 
  $listUsager = Usager::getUsagers();
  $isLogged = !empty($_SESSION["user"]);
  
  $smarty = new SmartyIUT();
    $smarty->assign("listUsager", $listUsager);
    $smarty->assign("isLogged", $isLogged);

  $smarty->display("forms/menu.form.tpl");
  $smarty->display("forms/listUsager.form.tpl");