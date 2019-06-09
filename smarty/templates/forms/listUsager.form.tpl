<html>
  <head>
    <title>PHP - Examen</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
    {if $isLogged}
    <table>
      <tr>
      <td>Nom utilisateur</td>
        <td>Numéro de carte</td>
        {foreach from=$listUsager item=item}
          <tr>
            <td>{$item.nom}</td>
            <td>{$item.num_carte}</td>
          </tr>
        {/foreach}
      </tr>
    </table>
    <a href="logout.php">Se déconnecter</a>
    {/if}
  </body>
</html>