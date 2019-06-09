<?php
/* Smarty version 3.1.33, created on 2019-06-06 13:33:23
  from '/opt/lampp/htdocs/TD6C/smarty/templates/forms/login.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cf8fa03262ae6_23658386',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '9438df68deed154c84b943ecfcba26b79317a5d8' => 
    array (
      0 => '/opt/lampp/htdocs/TD6C/smarty/templates/forms/login.form.tpl',
      1 => 1490528918,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cf8fa03262ae6_23658386 (Smarty_Internal_Template $_smarty_tpl) {
?><form method="post" action="login.php">
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
  
  <input type="submit" value="Login" />
</form><?php }
}
