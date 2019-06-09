<?php
/* Smarty version 3.1.33, created on 2019-06-09 12:30:27
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/listUsager.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cfcdfc38201b3_55678387',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'd7d5356ca7994987b4ff1fa1a349e5c04f5111a0' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/listUsager.form.tpl',
      1 => 1560076200,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cfcdfc38201b3_55678387 (Smarty_Internal_Template $_smarty_tpl) {
?><html>
  <head>
    <title>PHP - Examen</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
    <?php if ($_smarty_tpl->tpl_vars['isLogged']->value) {?>
    <table>
      <tr>
      <td>Nom utilisateur</td>
        <td>Numéro de carte</td>
        <?php
$_from = $_smarty_tpl->smarty->ext->_foreach->init($_smarty_tpl, $_smarty_tpl->tpl_vars['listUsager']->value, 'item');
if ($_from !== null) {
foreach ($_from as $_smarty_tpl->tpl_vars['item']->value) {
?>
          <tr>
            <td><?php echo $_smarty_tpl->tpl_vars['item']->value['nom'];?>
</td>
            <td><?php echo $_smarty_tpl->tpl_vars['item']->value['num_carte'];?>
</td>
          </tr>
        <?php
}
}
$_smarty_tpl->smarty->ext->_foreach->restore($_smarty_tpl, 1);?>
      </tr>
    </table>
    <a href="logout.php">Se déconnecter</a>
    <?php }?>
  </body>
</html><?php }
}
