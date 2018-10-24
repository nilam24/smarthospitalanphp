<?php


require 'dbconnect.php';
if($_SERVER['REQUEST_METHOD']=='GET'){

//	$pat_firstName=$_GET['pat_firstName'];
        
//	$pat_pass=$_GET['pat_pass'];

$sql="select * from pat_tab" ; //where pat_firstName='".$pat_firstName."' and pat_pass='".$pat_pass."'";

$result=mysqli_query($db,$sql);
$response1=array();
while($row=mysqli_fetch_array($result))
{
     	        array_push($response1,array('pat_firstName'=>$row['pat_firstName'],'pat_lastName'=>$row['pat_lastName'],'pat_contact'=>$row['pat_contact'],'pat_email'=>$row['pat_email'],'pat_pass'=>$row['pat_pass'],'pat_city'=>$row['pat_city'],'pat_state'=>$row['pat_state'],'pat_pin'=>$row['pat_pin'],'pat_country'=>$row['pat_country']));

}


 die(print_r(json_encode($response1),true));

mysqli_close($db);
}
?>
