<?php
  require_once "usager.class.php";
  require_once "SmartyIUT.class.php"; 
  session_start();
 
  $isLogged = !empty($_SESSION["user"]);
  $listUsager = Usager::getName();
  
  $smarty = new SmartyIUT();
  $smarty->assign("list", $listUsager);
  $smarty->assign("isLogged", $isLogged);
  $smarty->display("forms/menu.form.tpl");
  $smarty->display("forms/createDepot.form.tpl");
