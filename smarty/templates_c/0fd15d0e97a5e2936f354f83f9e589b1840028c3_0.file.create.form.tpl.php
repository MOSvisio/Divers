<?php
/* Smarty version 3.1.33, created on 2019-06-06 13:33:23
  from '/opt/lampp/htdocs/TD6C/smarty/templates/forms/create.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cf8fa03261699_93043165',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '0fd15d0e97a5e2936f354f83f9e589b1840028c3' => 
    array (
      0 => '/opt/lampp/htdocs/TD6C/smarty/templates/forms/create.form.tpl',
      1 => 1490528918,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cf8fa03261699_93043165 (Smarty_Internal_Template $_smarty_tpl) {
?><form method="post" action="createAccount.php">
  
  <div class="input">
    <label for="name">Name</label>
    <div class="input">
      <input type="text" name="name" value="" />
    </div>
  </div>
  
  <div class="input">
    <label for="name">Surname</label>
    <div class="input">
      <input type="text" name="surname" value="" />
    </div>
  </div>   
  
  <div class="input">
    <label for="name">Login</label>
    <div class="input">
      <input type="text" name="login" value="" />
    </div> 
  </div>
  
  <div class="input">
    <label for="name">Password</label>
    <div class="input">
      <input type="password" name="password" value="" />
    </div>
  </div>     
  
  <input type="submit" value="Create account" />
</form><?php }
}
