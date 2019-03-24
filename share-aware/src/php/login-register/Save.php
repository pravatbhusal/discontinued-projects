<?php 

//Connect to MySQL
include_once "ConnectSQL.php";

$con = mysqli_connect("localhost", "id1438584_share_aware", "winhackathon", "id1438584_share_inc");

//Data received from HTML
$Email = $_POST['Email'];
$FirstName = $_POST['FirstName'];
$LastName = $_POST['LastName'];
$ProfilePic = $_POST['ProfilePic'];
$Contacts = $_POST['Contacts'];
$AboutMe = $_POST['AboutMe'];
$Causes = $_POST['Causes'];
$Articles = $_POST['Articles'];
$Volunteering = $_POST['Volunteering'];


//Sets the information into the correct columns based on username
$sql = "UPDATE Users SET FirstName='$FirstName', LastName='$LastName', ProfilePic='$ProfilePic', Contacts='$Contacts', AboutMe='$AboutMe', Causes='$Causes', Articles='$Articles', Volunteering='$Volunteering' WHERE Email='$Email'";
mysqli_query($con, $sql) or exit("Error, could not save!");
exit("Saved Successfully!");				  
?>
