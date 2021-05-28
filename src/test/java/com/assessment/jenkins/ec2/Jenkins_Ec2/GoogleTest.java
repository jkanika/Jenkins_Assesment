package com.assessment.jenkins.ec2.Jenkins_Ec2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleTest {

	final String siteURL = "https://www.google.com/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// setup up
		System.setProperty("webdriver.gecko.driver", driverPath);
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--headless");
		driver = new FirefoxDriver(option);
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		// 7 .close driver
		driver.close();
	}

	@Test
	@DisplayName("Google Title Test")
	void testGoogleTitle() {
		String expected = "Google";
		assertEquals(expected, driver.getTitle());
	}
	
	@Test
	@DisplayName("Google Test")
	void testGoogle() {
		WebElement searchBox = driver.findElement(By.name("q"));
		
		assertTrue(searchBox.isDisplayed());
		assertTrue(searchBox.isEnabled());
		
		// enter data into search field.
		searchBox.sendKeys("What to buy");
		
		//submit
		searchBox.submit();
	}
	
}
