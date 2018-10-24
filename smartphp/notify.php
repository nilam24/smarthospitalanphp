<?php

	date_default_timezone_set('Asia/Kolkata');
	define( 'API_ACCESS_KEY', 'AAAADAyOZ24:APA91bEC1k5RRBZs3wJQRDDoRFgERzBfotWMlCyUid_e-vBtuge1ApE-HgQPnJXX1GKC8fe0qaOD7dhcDZGEMlYAjdcU4dOEUaTLyO6jyP_93IVu60s_5hgZCtTgRXJXz3Gn6vkk27U-');
	require 'dbconnect.php';
	
	if($_SERVER['REQUEST_METHOD']=='GET'){
		
		$address = $_GET['address'];
		$notice = $_GET['notice'];
		$localname = $_GET['localname'];
		$vehicle = $_GET['vehicle'];
		$type = $_GET['type'];
		$size = $_GET['size'];
		$fid = $_GET['fid'];
		$distance = $_GET['distance'];
		$typ = "";
		
		if($type==1){
			$typ = "potholes";
		}else if($type==2){
			$typ = "speed breaker";
		}else if($type==3){
			$typ = "manholes";
		}else{
			$typ = $type;
		}
		
		$message = $typ." ahead on distance ".$distance.". Size of ".$typ." is ".$size." meter";
		//echo $message;
		
		$res1['data']['title'] = "Road Alert Notification";
								$res1['data']['message'] = $message;
								$res1['data']['tnotice'] = $notice;
								$res1['data']['flag'] = $type;
								$res1['data']['size'] = $size;
								
								$fields = array(
									 'to' => $fid,
									 'data' => $res1
								);

						
						 
								$headers = array
								(
									'Authorization: key=' . API_ACCESS_KEY,
									'Content-Type: application/json'
								);
								 
								$ch = curl_init();
								curl_setopt( $ch,CURLOPT_URL, 'https://android.googleapis.com/gcm/send' );
								curl_setopt( $ch,CURLOPT_POST, true );
								curl_setopt( $ch,CURLOPT_HTTPHEADER, $headers );
								curl_setopt( $ch,CURLOPT_RETURNTRANSFER, true );
								curl_setopt( $ch,CURLOPT_SSL_VERIFYPEER, false );
								curl_setopt( $ch,CURLOPT_POSTFIELDS, json_encode( $fields ) );
								$result = curl_exec($ch );
								curl_close( $ch );
								//echo $result;
								
								echo '200 '.$result;
		}
	


?>