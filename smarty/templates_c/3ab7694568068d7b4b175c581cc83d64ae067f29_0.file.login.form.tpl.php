<?php
/* Smarty version 3.1.33, created on 2019-06-06 13:42:59
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/login.form.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cf8fc43e364e2_38649955',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '3ab7694568068d7b4b175c581cc83d64ae067f29' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/forms/login.form.tpl',
      1 => 1490528918,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_5cf8fc43e364e2_38649955 (Smarty_Internal_Template $_smarty_tpl) {
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
