<?php
  include 'classes/user.php';

  $user1 = new user('schutz','lucas','schutz47u','31807585');
  $user1->save();
  $data = user::getAll();
  echo '</br>';
  var_dump(user::getUser('schutz47u', '31807585'));
  echo '</br>';
  echo $user1->toString();

?>
