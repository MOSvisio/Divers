<?php
  class Connexion {
    
    private static $db; 
    
    public static function get(){
      if (empty(self::$db)){
        self::$db = new PDO('mysql:dbname=php_resto;host=localhost', "root", "");
      }
      return self::$db;
    }
    
  }