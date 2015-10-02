<?php

require "Slim/Slim.php";

$app = new Slim();

$app->contentType('application/json');

//$app->post('/{lado1}/{lado2}/{lado3}', function($lado1, $lado2, $lado3) use($app) {
$app->post('/calcular', function() use($app) {

	//$request = $app->request();
	//$body = $request->getBody();
	//$input = json_decode($body);

	//$lado1 = $input->lado1;
	//$lado2 = $input->lado2;
	//$lado3 = $input->lado3;
	//print_r();

	$lado1 = $app->request()->params("lado1");
	$lado2 = $app->request()->params("lado2");
	$lado3 = $app->request()->params("lado3");

	if($lado1 <= 0 || $lado2 <= 0 || $lado3 <= 0) {
		echo json_encode(array(
				'status' => false,
				'lado1' => $lado1,
				'lado2' => $lado2,
				'lado3' => $lado3,
				'resultado' => "Lado menor ou igual a zero"
				));
	} else {
		if ($lado1 == $lado2 && $lado2 == $lado3) {

			echo json_encode(array(
				'status' => true,
				'lado1' => $lado1,
				'lado2' => $lado2,
				'lado3' => $lado3,
				'resultado' => "O triângulo é Equilátero"
				));
			
		} else if ($lado1 == $lado2 || $lado2 == $lado3 || $lado3 == $lado1) {
			echo json_encode(array(
				'status' => true,
				'lado1' => $lado1,
				'lado2' => $lado2,
				'lado3' => $lado3,
				'resultado' => "O triângulo é Isósceles"
				));
		} else {
			echo json_encode(array(
				'status' => true,
				'lado1' => $lado1,
				'lado2' => $lado2,
				'lado3' => $lado3,
				'resultado' => "O triângulo é Escaleno"
				));
		}		
	}
});

$app->run();

?>