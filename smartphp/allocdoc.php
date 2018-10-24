<?php

require 'dbconnect.php';


$sql="select * from doc_tab";


$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{
array_push($response,array('doc_firstName'=>$row['doc_firstName']));

  //$response['doc_firstName']=$row['doc_firstName'];
	  

}

die(print_r(json_encode($response),true));

mysqli_close($db);

?>
