<?php
	
	
	// connecting database
	$con = new mysqli("localhost","id162771_waichun","123456","id162771_toiletapp");

// check connnection error

if ($con->connect_error){
	die( 'Connect Error: ' .$con-> connect_errno . ': ' .$con->connect_error );
}
	
    
    $email = $_POST["email"];
    $password = $_POST["password"];
	
	//echo $email;
	//echo $password;
    
    $stmt = mysqli_prepare($con, "SELECT * FROM user WHERE email = ? AND password = ?");
	
	$stmt->bind_param('ss', $email, $password);
	$stmt->execute();
	$stmt->store_result();
	$num_row = $stmt->num_rows();
		
	//echo $num_row;
	$response = array();
	$response["success"] = true;
	
	if($num_row > 0 ){
		//echo "Record found" ;
		echo json_encode($response);
		
		
	}
	else{
		$response["success"] = false;
		echo json_encode($response);
	}
	
	
	
	
	
