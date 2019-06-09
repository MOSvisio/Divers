<?php
/* Smarty version 3.1.33, created on 2019-06-09 12:40:39
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/create.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cfce2275f1a21_66889462',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '8abde7ccfbc37760fc3a45731a2dc5883518dd87' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/create.form.tpl',
      1 => 1560076776,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cfce2275f1a21_66889462 (Smarty_Internal_Template $_smarty_tpl) {
if ($_smarty_tpl->tpl_vars['isLogged']->value) {?>
<form method="post" action="createUsager.php">
  
  <div class="input">
    <label for="name">nom</label>
    <div class="input">
      <input type="text" name="nom" value="" />
    </div>
  </div>
  
  <div class="input">
    <label for="name">numéro de carte</label>
    <div class="input">
      <input type="text" name="num_carte" value="" />
    </div>
  </div>   
  
  <div class="input">
    <label for="name">libellé de la categorie</label>
    <div class="input">
      <input type="text" name="lib_categ" value="" />
    </div> 
  </div>   
  
  <div class="input">
    <label for="name">montant caution</label>
    <div class="input">
      <input type="text" name="mt_caution" value="" />
    </div>
  </div>  

  <input type="submit" value="Create account" />
</form>
<a href="logout.php">Se déconnecter</a>
<?php }?>

<?php }
}
