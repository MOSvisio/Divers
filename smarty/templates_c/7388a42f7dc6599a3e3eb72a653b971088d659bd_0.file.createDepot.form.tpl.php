<?php
/* Smarty version 3.1.33, created on 2019-06-09 12:30:29
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/createDepot.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cfcdfc5d52af6_20983459',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '7388a42f7dc6599a3e3eb72a653b971088d659bd' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/createDepot.form.tpl',
      1 => 1560076187,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cfcdfc5d52af6_20983459 (Smarty_Internal_Template $_smarty_tpl) {
if ($_smarty_tpl->tpl_vars['isLogged']->value) {?>
<form method="post" action="createDepot.php">
  
  <div class="input">
    <label for="name">Utilisateur</label>
    <div class="input">
      <SELECT name="Utilisateur" size="1">
        <?php
$_from = $_smarty_tpl->smarty->ext->_foreach->init($_smarty_tpl, $_smarty_tpl->tpl_vars['list']->value, 'item');
if ($_from !== null) {
foreach ($_from as $_smarty_tpl->tpl_vars['item']->value) {
?>
          <OPTION><?php echo $_smarty_tpl->tpl_vars['item']->value['nom'];?>

        <?php
}
}
$_smarty_tpl->smarty->ext->_foreach->restore($_smarty_tpl, 1);?>
      </SELECT>
    </div>
  </div>

  <div class="input">
    <label for="name">montant</label>
    <div class="input">
      <input type="text" name="montant" value="" />
    </div>
  </div>  

  <input type="submit" value="Create account" />
</form>
<a href="logout.php">Se déconnecter</a>
<?php }
}
}
