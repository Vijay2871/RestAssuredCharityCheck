package getCheck;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest {
	private static RequestSpecification reqSpec;

    @BeforeEach
     public void beforeTest() {
        reqSpec = new RequestSpecBuilder().
                setBaseUri("https://api.trademe.co.nz/v1").
                addParam("with_counts", true).
                build();
    }
    
	@Test
	public void getcharitydetails() {
		given()
		.when()
		.get("https://api.trademe.co.nz/v1/Charities.json")
		.then()
		.assertThat().
        body("Description", hasItem("St John"));
		
		
		System.out.println("St John is found in the charity list");
		
		 
	}
}
