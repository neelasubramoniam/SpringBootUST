package com.sam.USTAPITEST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class EtoEPMS {

	public static String response;
	public static String vID;
	public static String vMSG;

	public static void main(String[] args) throws InterruptedException {

		RestAssured.baseURI = "http://localhost:8080/";

		CREATE_CRUD();
		Thread.sleep(5000);
		GET_CRUD();
		Thread.sleep(5000);
		UPDATE_CRUD();
		Thread.sleep(15000);
		DELETE_CRUD();
		Thread.sleep(5000);

	}

	public static void CREATE_CRUD() {
		System.out.println("--------------------------------------");

		response = given().header("Content-Type", "application/json").header("Connection", "keep-alive")
				.body(AddPizzaPayLoad()).when().post("addPizza").then().assertThat().statusCode(201)
				.header("unique", containsString("chicken")).extract().response().asString();

		System.out.println(response);
		System.out.println("--------------------------------------");

		JsonPath jpath = new JsonPath(response);
		vID = jpath.getString("id");
		vMSG = jpath.getString("msg");

		System.out.println("ID is " + vID);
		System.out.println("Message is " + vMSG);

	}

	public static void GET_CRUD() {
		System.out.println("--------------------------------------");
		response = given().when().get("getPizza/" + vID).then().log().all().extract().response().asString();
		JsonPath jpath = new JsonPath(response);
		Assert.assertEquals(vID, jpath.getString("pID"));
		System.out.println("--------------------------------------");
	}

	public static void UPDATE_CRUD() {
		System.out.println("--------------------------------------");
		given().header("Content-Type", "application/json").body(updatePizza()).when().put("updatePizzaInfo/" + vID)
				.then().log().body();
		System.out.println("--------------------------------------");
	}

	public static void DELETE_CRUD() {
		System.out.println("--------------------------------------");
		given().header("Content-Type", "application/json").body(deletePizza()).when().delete("deletePizzaInfo").then()
				.log().body().log();
		System.out.println("--------------------------------------");
	}

	public static String AddPizzaPayLoad() {

		return "{\"pNAME\":\"chicken\",\"rate\":\"200\",\"pSIZE\":\"medium\"}";
	}

	public static String updatePizza() {

		return "{\"pNAME\":\"chicken\",\"rate\":\"250\",\"pSIZE\":\"Large\"}";
	}

	public static String deletePizza() {

		return "{\r\n" + "    \"pID\":\"" + vID + "\"\r\n" + "}";

	}

}
