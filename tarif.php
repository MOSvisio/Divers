<?php
    require_once "connection.class.php";
    require_once "SmartyIUT.class.php";

    session_start();
    $db = Connexion::get();
    $data = $db->query("SELECT * FROM TARIF ORDER BY prix ASC");
    $result = $data->fetchAll();
    $isLogged = !empty($_SESSION["user"]);

    $vue = new SmartyIUT();
        $vue->assign("prix", $result);
        $vue->assign("isLogged",$isLogged);
    $vue->display("forms/menu.form.tpl");
    $vue->display("forms/tarif.form.tpl");