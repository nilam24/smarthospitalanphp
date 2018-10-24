<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
		
   $admin_email=$_POST['admin_email'];
   $token=$_POST['token'];
//   $doc_contact=$_POST['doc_contact'];
  // $doc_email=$_POST['doc_email'];
  // $doc_pass=$_POST['doc_pass'];
 //  $doc_conf_pass=$_POST['doc_conf_pass'];
 //  $doc_city=$_POST['doc_city'];
 //  $doc_state=$_POST['doc_state'];
 //  $doc_pin=$_POST['doc_pin'];
 //  $doc_country=$_POST['doc_country'];
    $sql="INSERT INTO `device_tab`(`admin_email`, `token`) VALUES ('$admin_email','$token')";

//	$mytry="INSERT INTO `device_tab`(`admin_email`,`token`,)VALUES('$admin_email','$token')";


//$q1="UPDATE `device_tab` SET `admin_email`='qwe@gmail' WHERE `Id`=1";

  if(mysqli_query($db,$sql))

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
