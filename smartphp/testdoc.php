<?php

require 'dbconnect.php';

//if($_SERVER['REQUEST_METHOD']=='GET'){

	//$doc_firstName=$_GET['doc_firstName'];
        //$doc_pass=$_GET['doc_pass'];
        

$sql="select * from doc_tab"; // where doc_firstName='".$doc_firstName."'and doc_pass='".$doc_pass."'";


$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{

 array_push($response,array('doc_firstName'=>$row['doc_firstName'],'doc_pass'=>$row['doc_pass']));
  

}

die(print_r(json_encode($response),true));

mysqli_close($db);
//}
?>
