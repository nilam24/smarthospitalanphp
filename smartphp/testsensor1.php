<?php
require 'dbconnect.php';


//if($_SERVER['REQUEST_METHOD']=='GET'){

//$admin_email=$_GET['admin_email'];
$sql="select * from sensor_tab1"; // where admin_email='".$admin_email."'"; 
$result=mysqli_query($db,$sql);

$response1=array();
while($row=mysqli_fetch_array($result))
{
     	        array_push($response1,array('pat_firstName_fileName'=>$row['pat_firstName_fileName'],'doc_firstName'=>$row['doc_firstName'],'doc_contact'=>$row['doc_contact'],'pat_contact'=>$row['pat_contact'],'w_pressure'=>$row['w_pressure'],'heart_beat'=>$row['heart_beat'],'temp'=>$row['temp']));

}

 die(print_r(json_encode($response1),true));

mysqli_close($db);

//}
?>
