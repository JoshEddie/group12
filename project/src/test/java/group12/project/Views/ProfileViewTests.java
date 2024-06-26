package group12.project.Views;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfileViewTests {

	@Test
	public void createProfileView_valuesAreSetCorrectly() throws Exception{
		profileView profile = new profileView(
            "Admin",
            "Timothy",
            "My Address",
            "",
            "Houston", 
            "Tx", 
            "77336"
		);

		assertEquals("Admin", profile.getUsername());
		assertEquals("Timothy", profile.getFullName());
		assertEquals("My Address", profile.getAddress1());
		assertEquals("", profile.getAddress2());
		assertEquals("Houston", profile.getCity());
		assertEquals("Tx", profile.getState());
		assertEquals("77336", profile.getZipcode());
	}

	@Test
	public void createProfileView_NameTooLong_ExceptionThrown() throws Exception{
		var badParameter = "TimothyTimothyTimothyTimothyTimothyTimothyTimothyTimothyTimothyTimothyTimothyTimothyTimothy";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				badParameter,
				"My Address",
				"",
				"Houston", 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_NameEmpty_ExceptionThrown() throws Exception{
		var badParameter = "";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				badParameter,
				"My Address",
				"",
				"Houston", 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_Address1Empty_ExceptionThrown() throws Exception{
		var badParameter = "";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				badParameter,
				"",
				"Houston", 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_Address1TooLong_ExceptionThrown() throws Exception{
		var badParameter = "AddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddress";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				badParameter,
				"",
				"Houston", 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_Address2TooLong_ExceptionThrown() throws Exception{
		var badParameter = "AddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddressAddress";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				badParameter,
				"Houston", 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_Address2Empty_ExceptionNotThrown() throws Exception{
		var badParameter = "";

		assertDoesNotThrow(
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				badParameter,
				"Houston", 
				"Tx", 
				"77336"
			);
		});
	}

	@Test
	public void createProfileView_CityEmpty_ExceptionThrown() throws Exception{
		var badParameter = "";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				badParameter, 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_CityTooLong_ExceptionThrown() throws Exception{
		var badParameter = "CityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCityCity";
		
		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				badParameter, 
				"Tx", 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_StateTooLong_ExceptionThrown() throws Exception{
		var badParameter = "TXT";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				badParameter, 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_StateEmpty_ExceptionThrown() throws Exception{
		var badParameter = "";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				badParameter, 
				"77336"
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_ZipcodeTooShort_ExceptionThrown() throws Exception{
		var badParameter = "77";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				"Tx", 
				badParameter
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_ZipcodeTooLong_ExceptionThrown() throws Exception{
		var badParameter = "12345678910";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				"Tx", 
				badParameter
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_ZipcodeContainsLetter_ExceptionThrown() throws Exception{
		var badParameter = "1234a10";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				"Tx", 
				badParameter
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_ZipcodeContainsSpecialCharacter_ExceptionThrown() throws Exception{
		var badParameter = "!234110";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				"Tx", 
				badParameter
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}

	@Test
	public void createProfileView_ZipcodeContainsWhiteSpace_ExceptionThrown() throws Exception{
		var badParameter = "2 34110";

		var result = assertThrows(Exception.class,
		()->{
			new profileView(
				"Admin",
				"Timothy",
				"Address1",
				"",
				"City",
				"Tx", 
				badParameter
			);
		});

		assertEquals(result.getMessage(), badParameter + "was not valid");
	}
}
