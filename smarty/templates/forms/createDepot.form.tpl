{if $isLogged}
<form method="post" action="createDepot.php">
  
  <div class="input">
    <label for="name">Utilisateur</label>
    <div class="input">
      <SELECT name="Utilisateur" size="1">
        {foreach from=$list item=item}
          <OPTION>{$item.nom}
        {/foreach}
      </SELECT>
    </div>
  </div>

  <div class="input">
    <label for="name">montant</label>
    <div class="input">
      <input type="text" name="montant" value="" />
    </div>
  </div>  

  <input type="submit" value="Create account" />
</form>
<a href="logout.php">Se déconnecter</a>
{/if}