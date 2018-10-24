<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
		
   $admin_firstName=$_POST['admin_firstName'];
   $admin_lastName=$_POST['admin_lastName'];
   $admin_contact=$_POST['admin_contact'];
   $admin_email=$_POST['admin_email'];
   $admin_pass=$_POST['admin_pass'];
   $admin_conf_pass=$_POST['admin_conf_pass'];
   $admin_city=$_POST['admin_city'];
   $admin_state=$_POST['admin_state'];
   $admin_pin=$_POST['admin_pin'];
   $admin_country=$_POST['admin_country'];
 

		$mytry="INSERT INTO `admin_tab`(`admin_firstName`, `admin_lastName`, `admin_contact`, `admin_email`, `admin_pass`, `admin_conf_pass`, `admin_city`, `admin_state`, `admin_pin`, `admin_country`) VALUES ('$admin_firstName','$admin_lastName','$admin_contact','$admin_email','$admin_pass','$admin_conf_pass','$admin_city','$admin_state','$admin_pin','$admin_country')";


$q1="UPDATE `admin_tab` SET `admin_country`='qwe' WHERE `doc_Id`=101";

  if(mysqli_query($db,$mytry))

   {

  

 	$response['success'] = "200";
        
        //$response="success";
       die(print_r(json_encode($response),true));
  }
   else{
        $response="failed to register try again";
        die(print_r(json_encode($response),true));
    }
    mysqli_close($db);
}
?>
