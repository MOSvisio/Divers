<?php
/* Smarty version 3.1.30, created on 2017-03-26 13:45:59
  from "/homepages/41/d322675862/htdocs/AS/smarty/templates/forms/update.form.tpl" */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.30',
  'unifunc' => 'content_58d7a9f7db0ad0_27672133',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'd2037cf3f73821218b2d9832e42913a72d508972' => 
    array (
      0 => '/homepages/41/d322675862/htdocs/AS/smarty/templates/forms/update.form.tpl',
      1 => 1490528714,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_58d7a9f7db0ad0_27672133 (Smarty_Internal_Template $_smarty_tpl) {
?>
<form method="post" action="updateAccount.php">
  
  <div class="input">
    <label for="name">Name</label>
    <div class="input">
      <input type="text" name="name" value="<?php echo $_smarty_tpl->tpl_vars['user']->value['name'];?>
" />
    </div>
  </div>
  
  <div class="input">
    <label for="name">Surname</label>
    <div class="input">
      <input type="text" name="surname" value="<?php echo $_smarty_tpl->tpl_vars['user']->value['surname'];?>
" />
    </div>
  </div>   
  
  <div class="input">
    <label for="name">Login</label>
    <div class="input">
      <input type="text" name="login" value="<?php echo $_smarty_tpl->tpl_vars['user']->value['login'];?>
" />
    </div> 
  </div>
  
  <div class="input">
    <label for="name">Password</label>
    <div class="input">
      <input type="password" name="password" value="<?php echo $_smarty_tpl->tpl_vars['user']->value['password'];?>
" />
    </div>
  </div>     
  
  <input type="submit" value="Update my account" />
</form><?php }
}
