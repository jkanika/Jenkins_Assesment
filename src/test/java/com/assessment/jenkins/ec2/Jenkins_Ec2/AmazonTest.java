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

class AmazonTest {

	final String siteURL = "https://www.amazon.in/";
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
	@DisplayName("Amazon Home Page Title")
	void testTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}
	
	@Test
	@DisplayName("Amazon Link Click Test")
	void testLink() {
		//find mobile link
		WebElement mobile = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		// test evaluation
		assertTrue(mobile.isDisplayed());
		assertTrue(mobile.isEnabled());
		// click action
		mobile.click();	
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}

}
