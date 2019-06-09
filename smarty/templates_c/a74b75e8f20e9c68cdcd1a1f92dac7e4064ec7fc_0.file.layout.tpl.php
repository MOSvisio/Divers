<?php
/* Smarty version 3.1.30, created on 2017-03-26 13:46:21
  from "/homepages/41/d322675862/htdocs/AS/smarty/templates/layout.tpl" */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.30',
  'unifunc' => 'content_58d7aa0d1dc9c9_79432293',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'a74b75e8f20e9c68cdcd1a1f92dac7e4064ec7fc' => 
    array (
      0 => '/homepages/41/d322675862/htdocs/AS/smarty/templates/layout.tpl',
      1 => 1490528777,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
    'file:forms/create.form.tpl' => 1,
    'file:forms/login.form.tpl' => 1,
    'file:forms/update.form.tpl' => 1,
  ),
),false)) {
function content_58d7aa0d1dc9c9_79432293 (Smarty_Internal_Template $_smarty_tpl) {
?>
<html>
  <head>
    <title>TP6 - Smarty</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
    <div class="global">
      <h3>Correction TP4 - Les formulaires</h3>
      <?php if ($_smarty_tpl->tpl_vars['isLogged']->value) {?>
        <div class="welcome-pane">
              Bienvenue <?php echo $_smarty_tpl->tpl_vars['user']->value['name'];?>
 <?php echo $_smarty_tpl->tpl_vars['user']->value['surname'];?>
 - <a href="logout.php">Loggout</a>
            </div>
      <?php }?>
     
      <div class="error-pane <?php echo $_smarty_tpl->tpl_vars['classError']->value;?>
">
        <?php echo $_smarty_tpl->tpl_vars['errorMessage']->value;?>

      </div>
      
      <div class="error-pane <?php echo $_smarty_tpl->tpl_vars['classSuccess']->value;?>
">
        <?php echo $_smarty_tpl->tpl_vars['successMessage']->value;?>

      </div>
      
      
      <div class="content">
        <?php if (!$_smarty_tpl->tpl_vars['isLogged']->value) {?>
          <div class="inscription">
            <?php $_smarty_tpl->_subTemplateRender("file:forms/create.form.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, $_smarty_tpl->cache_lifetime, array(), 0, false);
?>

          </div>
        
        
          <div class="connexion">
            <?php $_smarty_tpl->_subTemplateRender("file:forms/login.form.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, $_smarty_tpl->cache_lifetime, array(), 0, false);
?>

          </div>
        <?php } else { ?> 
          <div class="update">
            <?php $_smarty_tpl->_subTemplateRender("file:forms/update.form.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, $_smarty_tpl->cache_lifetime, array(), 0, false);
?>

          </div>
        <?php }?> 
      </div>
    </div>
  </body>
</html><?php }
}
