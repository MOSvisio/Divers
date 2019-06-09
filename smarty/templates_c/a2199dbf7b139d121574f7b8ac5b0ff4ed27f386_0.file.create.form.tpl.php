<?php
/* Smarty version 3.1.30, created on 2017-03-26 13:44:23
  from "/homepages/41/d322675862/htdocs/AS/smarty/templates/forms/create.form.tpl" */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.30',
  'unifunc' => 'content_58d7a99709d879_98073784',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'a2199dbf7b139d121574f7b8ac5b0ff4ed27f386' => 
    array (
      0 => '/homepages/41/d322675862/htdocs/AS/smarty/templates/forms/create.form.tpl',
      1 => 1490528636,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_58d7a99709d879_98073784 (Smarty_Internal_Template $_smarty_tpl) {
?>
<form method="post" action="createAccount.php">
  
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
