<?php
/* Smarty version 3.1.33, created on 2019-06-08 08:54:07
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/menu.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cfb5b8f494b09_44051068',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '45ecd5f730779402d1b3f3b1202e30ac2b5be01a' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/menu.form.tpl',
      1 => 1559976844,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cfb5b8f494b09_44051068 (Smarty_Internal_Template $_smarty_tpl) {
?><style type="text/css">
    .menu {
        background-color : lightgrey;
        height: 50px;
        display: flex;  
        flex-direction: row;
    }          

    .menu a{
        margin: auto;
        height: 100%;
        padding: 15px;
    }
</style>

<div class="menu">
    <a href="index.php">Index</a>
    <a href="listUsager.php">Liste usager</a>
    <a href="pageCreateUsager.php">Créer usager</a>
    <a href="pageCreateDepot.php">Créer Dépot</a>
    <a href="tarif.php">Tarifs</a>
</div><?php }
}
