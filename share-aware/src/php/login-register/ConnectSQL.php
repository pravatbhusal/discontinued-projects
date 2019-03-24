<?php
 
//Database Connection Variables

$db_name = "id1438584_share_inc";
 
$db_username = "id1438584_share_aware";
 
$db_password = "winhackathon";
 
$db_host = "localhost";
 
/*
mysql_connect is a built in function that allows us to make an easy connection.
*/
 
$con = mysqli_connect($db_host, $db_username, $db_password, $db_name);
 
/*
mysql_select_db is a built in function that allows us to select the database. This is an essential function.
 
We use the 'die' function to check for errors.
 
*/
 
mysqli_select_db($con, "id1438584_share_inc") or die (mysqli_error("Error with loading the database."));
 
 
?>
