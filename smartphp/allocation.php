<?php
 require 'dbconnect.php';

 
 if($_SERVER['REQUEST_METHOD']=='POST'){
		
   $doc_firstName=$_POST['doc_firstName'];
   $pat_firstName=$_POST['pat_firstName'];
   
    	$mytry="INSERT INTO `allocation_tab`(`doc_firstName`, `pat_firstName`) VALUES ('$doc_firstName','$pat_firstName')";

 $q1="UPDATE `doc_tab` SET `doc_country`='qwe' WHERE `doc_Id`=101";

  if(mysqli_query($db,$mytry))
   {
 	$response['success'] = "200";
        
        $response="success";
       
     die(print_r(json_encode($response),true));
  }
   else{
        $response="failed to register try again";
        die(print_r(json_encode($response),true));
    }
    mysqli_close($db);
}
 ?>
