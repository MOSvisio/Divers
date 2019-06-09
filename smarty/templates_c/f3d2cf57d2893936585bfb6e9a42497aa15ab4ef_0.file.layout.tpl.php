<?php
/* Smarty version 3.1.33, created on 2019-06-09 12:34:14
  from '/opt/lampp/htdocs/PhpExam/smarty/templates/layout.tpl' */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.33',
  'unifunc' => 'content_5cfce0a6707770_19063263',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    'f3d2cf57d2893936585bfb6e9a42497aa15ab4ef' => 
    array (
      0 => '/opt/lampp/htdocs/PhpExam/smarty/templates/layout.tpl',
      1 => 1560076405,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
    'file:forms/login.form.tpl' => 1,
  ),
),false)) {
function content_5cfce0a6707770_19063263 (Smarty_Internal_Template $_smarty_tpl) {
?><html>
  <head>
    <title>PHP - Examen</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
    <h1>Examen PHP</h1>
    <?php if (!$_smarty_tpl->tpl_vars['isLogged']->value) {?>
    <div class="inscription">
      <?php $_smarty_tpl->_subTemplateRender("file:forms/login.form.tpl", $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, $_smarty_tpl->cache_lifetime, array(), 0, false);
?>
    </div>
    <?php } else { ?>
      <h1>vous êtes connecté en tant que <?php echo $_smarty_tpl->tpl_vars['user']->value;?>
</h1>
    <?php }?>
  </body>
</html><?php }
}
