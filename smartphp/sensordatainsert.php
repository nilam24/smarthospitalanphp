<?php
 require 'dbconnect.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
		
   $file_name_pat_Id=$_POST['pat_firstName_fileName'];
   $doc_firstName=$_POST['doc_firstName'];
   $doc_contact=$_POST['doc_contact'];
   $pat_contact=$_POST['pat_contact'];
   $w_pressure=$_POST['w_pressure'];
   $heart_beat=$_POST['heart_beat'];
   $temp=$_POST['temp'];
   
	$mytry="INSERT INTO `sensor_tab1`(`pat_firstName_fileName`,'doc_firstName','doc_contact','pat_contact',`w_pressure`, `heart_beat`, `temp`) VALUES ('$pat_firstName_fileName','$doc_firstName','$doc_contact','$pat_contact''$w_pressure','$heart_beat','$temp')";


$q1="UPDATE `sensor_tab` SET `w_pressure_`='qwe' WHERE `sens_Id`=101";

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
