<html>
  <head>
    <title>PHP - Examen</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
    <h1>Examen PHP</h1>
    {if !$isLogged}
    <div class="inscription">
      {include file="forms/login.form.tpl"}
    </div>
    {else}
      <h1>vous êtes connecté en tant que {$user}</h1>
    {/if}
  </body>
</html>