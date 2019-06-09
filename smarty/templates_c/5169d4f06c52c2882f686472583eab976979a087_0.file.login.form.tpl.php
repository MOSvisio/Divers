<?php
/* Smarty version 3.1.30, created on 2017-03-26 13:43:15
  from "/homepages/41/d322675862/htdocs/AS/smarty/templates/forms/login.form.tpl" */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.30',
  'unifunc' => 'content_58d7a953586e34_97199114',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '5169d4f06c52c2882f686472583eab976979a087' => 
    array (
      0 => '/homepages/41/d322675862/htdocs/AS/smarty/templates/forms/login.form.tpl',
      1 => 1490528542,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_58d7a953586e34_97199114 (Smarty_Internal_Template $_smarty_tpl) {
?>
<form method="post" action="login.php">
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
