<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
		
   $doc_firstName=$_POST['doc_firstName'];
   $doc_lastName=$_POST['doc_lastName'];
   $doc_contact=$_POST['doc_contact'];
   $doc_email=$_POST['doc_email'];
   $doc_pass=$_POST['doc_pass'];
   $doc_conf_pass=$_POST['doc_conf_pass'];
   $doc_city=$_POST['doc_city'];
   $doc_state=$_POST['doc_state'];
   $doc_pin=$_POST['doc_pin'];
   $doc_country=$_POST['doc_country'];
 

	$mytry="INSERT INTO `doc_tab`(`doc_firstName`, `doc_lastName`, `doc_contact`, `doc_email`, `doc_pass`, `doc_conf_pass`, `doc_city`, `doc_state`, `doc_pin`, `doc_country`) VALUES ('$doc_firstName','$doc_lastName','$doc_contact','$doc_email','$doc_pass','$doc_conf_pass','$doc_city','$doc_state','$doc_pin','$doc_country')";


$q1="UPDATE `doc_tab` SET `doc_country`='qwe' WHERE `doc_Id`=101";

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
