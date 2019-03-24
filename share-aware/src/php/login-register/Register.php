<?php 
//Connect to MySQL
include_once "ConnectSQL.php";

$con = mysqli_connect("localhost", "id1438584_share_aware", "winhackathon", "id1438584_share_inc");
if (mysqli_connect_errno())
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
//Default Values
$Email = "None";
$Password = "None";
$FirstName = "None";
$LastName = "None";
$ProfilePic = "None";
$Contacts = "None";
$AboutMe = "None";
$Causes = "None";
$Articles = "None";
$Volunteering = "None";

//Data received from HTML
$Email = $_POST['Email'];
$Password = $_POST['Password'];
$FirstName = $_POST['FirstName'];
$LastName = $_POST['LastName'];
$ProfilePic = $_POST['ProfilePic'];
$Contacts = $_POST['Contacts'];
$AboutMe = $_POST['AboutMe'];
$Causes = $_POST['Causes'];
$Articles = $_POST['Articles'];
$Volunteering = $_POST['Volunteering'];


//Check if email is in use
$CheckUsage = mysqli_query($con, "SELECT * FROM Users WHERE Email = '$Email'");

//If there is more than 0 uses of the email
if(mysqli_num_rows($CheckUsage) > 0){
exit("Email is already in use!");
} else {
$sql = "INSERT INTO Users (Email,Password,FirstName,LastName,ProfilePic,Contacts,AboutMe,Causes,Articles,Volunteering) 
VALUES ('$Email','$Password','$FirstName','$LastName','$ProfilePic','$Contacts','$AboutMe','$Causes','$Articles','$Volunteering')";
mysqli_query($con, $sql) or exit("Error in registration process!");
header("Location: https://shareaware.000webhostapp.com/home.html");
exit("Registration Complete!");  
}
?>
