<?php 

//Connect to MySQL
include_once "ConnectSQL.php";

$con = mysqli_connect("localhost", "id1438584_share_aware", "winhackathon", "id1438584_share_inc");

//Receive variables from HTML
$Email =$_POST['Email'];
$Password = $_POST['Password'];
 
$sql = "SELECT * FROM Users WHERE Email='$Email' AND Password='$Password'";
$query = mysqli_query($con, "SELECT * FROM Users WHERE Email = '$Email'");
 
//Counts the records that match the query
$login_counter = mysqli_num_rows($query);
 
//If the login counter is greater, that means the data is present!
if ($login_counter > 0) {

//While loop receives all of the account data
while ($data = mysqli_fetch_array($query)) {

//Receive the account data
$FirstName = $data["FirstName"];
$LastName = $data["LastName"];
$ProfilePic = $data["ProfilePic"];
$Contacts = $data["Contacts"];
$AboutMe = $data["AboutMe"];
$Causes = $data["Causes"];
$Articles = $data["Articles"];
$Volunteering = $data["Volunteering"];
 
//Print the data back to HTML 
print "Your first name is $FirstName";
echo "<br>";
print "Your last name is $LastName";
echo "<br>";
print "Your profile picture: $ProfilePic";
echo "<br>";
print "Your contacts are: $Contacts";
echo "<br>";
print "About Me: $AboutMe";
echo "<br>";
print "Causes: $Causes";
echo "<br>";
print "Articles: $Articles";
echo "<br>";
print "Volunteering: $Volunteering";
} 
} else {
print "The login details do not match our records!";
header("Location: https://shareaware.000webhostapp.com/home.html");
}
?>
