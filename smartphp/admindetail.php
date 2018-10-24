<?php

require 'dbconnect.php';

$sql="select * from admin_tab";

$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{

  	 			array_push($response,array('admin_firstName'=>$row['admin_firstName'],'admin_lastName'=>$row['admin_lastName'],'admin_contact'=>$row['admin_contact'],'admin_email'=>$row['admin_email'],'admin_pass'=>$row['admin_pass'],'admin_city'=>$row['admin_city'],'admin_state'=>$row['admin_state'],'admin_pin'=>$row['admin_pin'],'admin_country'=>$row['admin_country']));
	 

}

die(print_r(json_encode($response),true));

mysqli_close($db);

?>
