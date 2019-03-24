<?php 
//Connect to MySQL
include_once "ConnectSQL.php";

$con = mysqli_connect("localhost", "id1438584_share_aware", "winhackathon", "id1438584_share_inc");
if (mysqli_connect_errno())
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

//Data received from HTML
$Name = $_POST['Name'];
$Date = strtotime("now");
$Text = $_POST['Text'];

$sql = "INSERT INTO Feed (Name,Date,Text) 
VALUES ('$Name','$Date','$Text')";
mysqli_query($con, $sql) or exit("Error in registration process!");
exit("Save Complete!");  

?>
