<?php
/* Smarty version 3.1.33, created on 2019-05-23 12:13:09
  from '/home/lagrang12u/PHP/TD6C/smarty/templates/forms/login.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5ce68e5583ad75_71415691',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'ab1a1b6e239cd47e67abdfda3b0d5f3d979b88b2' => 
    array (
      0 => '/home/lagrang12u/PHP/TD6C/smarty/templates/forms/login.form.tpl',
      1 => 1490521718,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5ce68e5583ad75_71415691 (Smarty_Internal_Template $_smarty_tpl) {
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
