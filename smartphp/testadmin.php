<?php

require 'dbconnect.php';


$sql="select * from admin_tab";


$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{

  	$response['admin_firstName']=$row['admin_firstName'];
	$response['admin_lastName']=$row['admin_lastName'];
	$response['admin_contact']=$row['admin_contact'];
	$response['admin_email']=$row['admin_email'];
	$response['admin_pass']=$row['admin_pass'];
	$response['admin_conf_pass']=$row['admin_conf_pass'];
	$response['admin_city']=$row['admin_city'];
	$response['admin_state']=$row['admin_state'];
        $response['admin_pin']=$row['admin_pin'];
	$response['admin_country']=$row['admin_country'];   
	 

}

die(print_r(json_encode($response),true));

mysqli_close($db);

?>
