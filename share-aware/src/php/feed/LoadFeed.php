<?php 

//Connect to MySQL
include_once "ConnectSQL.php";

$con = mysqli_connect("localhost", "id1438584_share_aware", "winhackathon", "id1438584_share_inc");

$ID = $_POST['ID'];
$query = mysqli_query($con, "SELECT * FROM Feed WHERE ID = '$ID'");
 
//Counts the records that match the query
$login_counter = mysqli_num_rows($query);
 
//If the login counter is greater, that means the data is present!
if ($login_counter > 0) {

//While loop receives all of the account data
while ($data = mysqli_fetch_array($query)) {

//Receive the account data
$Date = $data["Date"];
$Text = $data["Text"];
$Name = $data["Name"];
 
//Print the data back to HTML 
print "DateAndTime=$Date";
print "&";
print "Message=$Text";
print "&";
print "Name=$Name";
} 
} else {
print "The login details do not match our records!";
}
?>
