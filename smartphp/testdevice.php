<?php
require 'dbconnect.php';
if($_SERVER['REQUEST_METHOD']=='POST'){
 
     $admin_email=$_POST['admin_email'];
     $token=$_POST['token'];
   
     $mytry="INSERT INTO `device_tab`(`admin_email`,'token') VALUES ('$admin_email','$token')";

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
