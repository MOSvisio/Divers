{if $isLogged}
<form method="post" action="createUsager.php">
  
  <div class="input">
    <label for="name">nom</label>
    <div class="input">
      <input type="text" name="nom" value="" />
    </div>
  </div>
  
  <div class="input">
    <label for="name">numéro de carte</label>
    <div class="input">
      <input type="text" name="num_carte" value="" />
    </div>
  </div>   
  
  <div class="input">
    <label for="name">libellé de la categorie</label>
    <div class="input">
      <input type="text" name="lib_categ" value="" />
    </div> 
  </div>   
  
  <div class="input">
    <label for="name">montant caution</label>
    <div class="input">
      <input type="text" name="mt_caution" value="" />
    </div>
  </div>  

  <input type="submit" value="Create account" />
</form>
<a href="logout.php">Se déconnecter</a>
{/if}

