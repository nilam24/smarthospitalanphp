<?php

require 'dbconnect.php';
if($_SERVER['REQUEST_METHOD']=='GET'){

	$pat_firstName=$_GET['pat_firstName'];

	$sql="select * from pat_tab where pat_firstName='".$pat_firstName."'";

	
	$result=mysqli_query($db,$sql);
	$response=array();
	while($row=mysqli_fetch_array($result))
	{

 	$response['pat_firstName']=$row['pat_firstName'];
	$response['pat_lastName']=$row['pat_lastName'];
	$response['pat_contact']=$row['pat_contact'];
	$response['pat_email']=$row['pat_email'];
	$response['pat_pass']=$row['pat_pass'];
	$response['pat_conf_pass']=$row['pat_conf_pass'];
	$response['pat_city']=$row['pat_city'];
	$response['pat_state']=$row['pat_state'];
        $response['pat_pin']=$row['pat_pin'];
	$response['pat_country']=$row['pat_country'];  

	}

	die(print_r(json_encode($response),true));

	mysqli_close($db);
	}
?>
