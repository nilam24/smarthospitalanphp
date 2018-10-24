<?php

require 'dbconnect.php';
//if($_SERVER['REQUEST_METHOD']=='GET'){

//$admin_firstName=$_GET['admin_firstName'];
//$admin_email=$_GET['admin_email'];
//$admin_pass=$_GET['admin_pass'];

$sql="select * from admin_tab"; //where admin_firstName='".$admin_firstName."' and admin_pass='".$admin_pass."'";

$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{

array_push($response,array('admin_firstName'=>$row['admin_firstName'],'admin_email'=>$row['admin_email'],'admin_pass'=>$row['admin_pass']));
 
// $response['admin_firstName']=$row['admin_firstName'];
//  $response['admin_pass']=$row['admin_pass'];
//  $response['admin_email']=$row['admin_email']; 

}

die(print_r(json_encode($response),true));

mysqli_close($db);

//}
?>
