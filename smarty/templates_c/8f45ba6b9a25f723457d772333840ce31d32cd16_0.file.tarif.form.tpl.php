<?php
/* Smarty version 3.1.33, created on 2019-06-09 12:30:30
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/tarif.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cfcdfc6f0f150_80284014',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '8f45ba6b9a25f723457d772333840ce31d32cd16' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/tarif.form.tpl',
      1 => 1560076211,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cfcdfc6f0f150_80284014 (Smarty_Internal_Template $_smarty_tpl) {
?>   <?php if ($_smarty_tpl->tpl_vars['isLogged']->value) {?>       
        <table>
        <tr>
            <td>libellé prestation</td>
            <td>libellé categorie</td>
            <td>prix</td>
            <?php
$_from = $_smarty_tpl->smarty->ext->_foreach->init($_smarty_tpl, $_smarty_tpl->tpl_vars['prix']->value, 'item');
if ($_from !== null) {
foreach ($_from as $_smarty_tpl->tpl_vars['item']->value) {
?>
              <tr>
                <td><?php echo $_smarty_tpl->tpl_vars['item']->value['num_prest'];?>
</td>
                <td><?php echo $_smarty_tpl->tpl_vars['item']->value['num_categ'];?>
</td>
                <td><?php echo $_smarty_tpl->tpl_vars['item']->value['prix'];?>
</td>
              </tr>
            <?php
}
}
$_smarty_tpl->smarty->ext->_foreach->restore($_smarty_tpl, 1);?>
        </tr>
        </table>
        <a href="logout.php">Se déconnecter</a>
  <?php }
}
}
