<?php
/* Smarty version 3.1.33, created on 2019-06-06 13:33:23
  from '/opt/lampp/htdocs/TD6C/smarty/templates/layout.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cf8fa0325e986_15779087',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '364eeaf0995f89c86885b316768f96b659c1cb5b' => 
    array (
      0 => '/opt/lampp/htdocs/TD6C/smarty/templates/layout.tpl',
      1 => 1490528918,
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
function content_5cf8fa0325e986_15779087 (Smarty_Internal_Template $_smarty_tpl) {
?><html>
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
      
      <div class="success-pane <?php echo $_smarty_tpl->tpl_vars['classSuccess']->value;?>
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
