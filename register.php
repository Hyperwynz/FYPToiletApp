<?php


// connecting database
	$con = new mysqli("localhost","id162771_waichun","123456","id162771_toiletapp");

// check connnection error

if ($con->connect_error){
	die( 'Connect Error: ' .$con-> connect_errno . ': ' .$con->connect_error );
}

    //$con = mysqli_connect("toiletapp.000webhostapp.com","id162771_waichun","123456","id162771_toiletapp");

    $email = $_POST["email"];
    $username = $_POST["username"];
    $phoneNo = $_POST["phoneNo"];
    $password = $_POST["password"];
$sql = "INSERT INTO user (email, username, phoneNo, password, isAdmin) VALUES ('$email', '$username', $phoneNo,'$password', null)";
//echo $sql;

//$response = array();


if (mysqli_query($con, $sql)) {
    //echo "New record created successfully";
	//$response["success"] = true; 
	$response = array();
	$response["success"] = true;
	echo json_encode($response);
	
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($con);
}

   /* $statement = mysqli_prepare($con, "INSERT INTO user (user_id, name, username, age, password) VALUES (null, $name, $age, $username, $password)");
    mysqli_stmt_bind_param($statement, "siss", $name, $username, $age, $password);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;  
$response["name"] = $name;
$response["age"] = $age;
$response["username"] = $username;
$response["password"] = $password;
 
    echo json_encode($response);
   */



?>