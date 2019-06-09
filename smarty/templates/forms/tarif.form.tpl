   {if $isLogged}       
        <table>
        <tr>
            <td>libellé prestation</td>
            <td>libellé categorie</td>
            <td>prix</td>
            {foreach from=$prix item=item}
              <tr>
                <td>{$item.num_prest}</td>
                <td>{$item.num_categ}</td>
                <td>{$item.prix}</td>
              </tr>
            {/foreach}
        </tr>
        </table>
        <a href="logout.php">Se déconnecter</a>
  {/if}