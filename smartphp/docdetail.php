<?php
 require 'dbconnect.php';

  $sqlSelect="select * from doc_tab";

  $result=mysqli_query($db,$sqlSelect);
  $response=array();
  while($row=mysqli_fetch_array($result))
  {
  array_push($response,array('doc_firstName'=>$row['doc_firstName'],'doc_lastName'=>$row['doc_lastName'],'doc_contact'=>$row['doc_contact'],'doc_email'=>$row['doc_email'],'doc_pass'=>$row['doc_pass'],'doc_city'=>$row['doc_city'],'doc_state'=>$row['doc_state'],'doc_pin'=>$row['doc_pin'],'doc_country'=>$row['doc_country']));
   

  }

   die(print_r(json_encode($response),true));
  
    mysqli_close($db);
?>
