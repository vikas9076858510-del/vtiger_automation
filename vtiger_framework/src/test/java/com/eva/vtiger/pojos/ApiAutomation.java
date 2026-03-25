package com.eva.vtiger.pojos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ApiAutomation {

	@Test
	public static void VarifyContactCreation() {

		Employee emp1 = new Employee("Rahul", "Yadav", 78, true);
		AddressPojo ap=	new AddressPojo();
		ap.setPermanent("Bhadoi");
		ap.setResidential("Jaunpur");
		ap.setPin(123455);
		emp1.setAddress(ap);
		
		List<String> hobbiesList=new ArrayList<String>();
		hobbiesList.add("Cricket");
		hobbiesList.add("Movies");
		hobbiesList.add("xyz");
		emp1.setHobbies(hobbiesList);
		
	   DepartmentPojo dp1=new DepartmentPojo();
		dp1.setDeptId(7);
		dp1.setDeptName("QA");
		
		DepartmentPojo dp2=new DepartmentPojo();
		dp2.setDeptId(6);
		dp2.setDeptName("Dev");
		
		DepartmentPojo dp3=new DepartmentPojo();
		dp3.setDeptId(8);
		dp3.setDeptName("Sales");
		
		List<DepartmentPojo> deptList= new ArrayList<DepartmentPojo>();
         deptList.add(dp1);
         deptList.add(dp2);
         deptList.add(dp3);
         emp1.setDepartmentInfo(deptList);
         
		

		Employee emp2 = new Employee("Amit", "Kumar", 76, false);








		//		Response get=	RestAssured.given().auth().basic("vikas@evaPrayagraj.com", "vicky@123").accept("application/json").get("https://vikasevaprayagraj.agilecrm.com/dev/api/contacts");
		//		String strResponse=	get.getBody().asPrettyString();
		//		System.out.println(strResponse);
		//		System.out.println(get.getStatusCode());


//		byte[] btarry=null;
//		try {
//			btarry = Files.readAllBytes(Paths.get("C:\\Users\\admin\\Desktop\\CreatContact.json"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		String reqJsonPost= new String(btarry);
//		JsonPath jsp=new JsonPath(reqJsonPost);
//
//		String expStratValue=jsp.getString("star_value");
//		List<String> expFirstName= jsp.getList("properties.findAll{it.name=='first_name'}.value");
//		String expLastName= jsp.getString("properties[1].value");
//		String expEmail= jsp.getString("properties[2].value");
//
//
//		Response resp=	given().auth().basic("vikas@evaPrayagraj.com", "vicky@123").contentType("application/json").		
//				accept("application/json").body(reqJsonPost).post("https://vikasevaprayagraj.agilecrm.com/dev/api/contacts");
//		String responseJsonString=	resp.getBody().asPrettyString();
//
//		resp.then().body(matchesJsonSchemaInClasspath("D:\\ContactSchema.json"));
//
//		JsonPath respJsp =new JsonPath(responseJsonString);
//		Integer intStarValue=respJsp.getInt("star_value");
//		String actualStarValue=intStarValue.toString();
//
//		String actualFirstName=respJsp.getString("properties[0].value");
//		String actualLasttName=respJsp.getString("properties[1].value");
//		String actualEmail=respJsp.getString("properties[2].value");
//
//		Assert.assertEquals(actualStarValue, expStratValue);
//		Assert.assertEquals(actualFirstName, expFirstName);
//		Assert.assertEquals(actualLasttName, expLastName);
//		Assert.assertEquals(actualEmail, expEmail);





	}
  }
