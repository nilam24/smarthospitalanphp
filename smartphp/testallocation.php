<?php

require 'dbconnect.php';

$sql="select * from allocation_tab";

$result=mysqli_query($db,$sql);
$response=array();
while($row=mysqli_fetch_array($result))
{
  array_push($response,array('pat_firstName'=>$row['pat_firstName'],'doc_firstName'=>$row['doc_firstName']));

 		 
}

die(print_r(json_encode($response),true));

mysqli_close($db);

?>
