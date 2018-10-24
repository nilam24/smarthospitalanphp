<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
		
   $pat_firstName=$_POST['pat_firstName'];
   $pat_lastName=$_POST['pat_lastName'];
   $pat_contact=$_POST['pat_contact'];
   $pat_email=$_POST['pat_email'];
   $pat_pass=$_POST['pat_pass'];
   $pat_conf_pass=$_POST['pat_conf_pass'];
   $pat_city=$_POST['pat_city'];
   $pat_state=$_POST['pat_state'];
   $pat_pin=$_POST['pat_pin'];
   $pat_country=$_POST['pat_country'];
 
		$mysql="INSERT INTO `pat_tab`(`pat_firstName`, `pat_lastName`, `pat_contact`, `pat_email`, `pat_pass`, `pat_conf_pass`, `pat_city`, `pat_state`, `pat_pin`, `pat_country`) VALUES ('$pat_firstName','$pat_lastName','$pat_contact','$pat_email','$pat_pass','$pat_conf_pass','$pat_city','$pat_state','$pat_pin','$pat_country')";


$q1="UPDATE `pat_tab` SET `pat_country`='qwe' WHERE `pat_Id`=101";

  if(mysqli_query($db,$mysql))
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
