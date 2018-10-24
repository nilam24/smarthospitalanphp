<?php
require 'dbconnect.php';


//if($_SERVER['REQUEST_METHOD']=='GET'){

//$admin_email=$_GET['admin_email'];
$sql="select * from device_tab"; // where admin_email='".$admin_email."'"; 
$result=mysqli_query($db,$sql);

$response1=array();
while($row=mysqli_fetch_array($result))
{
     	        array_push($response1,array('admin_email'=>$row['admin_email'],'token'=>$row['token']));

}

 die(print_r(json_encode($response1),true));

mysqli_close($db);

//}
?>
