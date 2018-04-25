package com.SeleniumDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver_zeus {
	
	
	/*
	 * create a object of the class to invoke the driver in the @before class
	 * */
	private static SeleniumDriver_zeus seleniumDriver_zeus;
	
	public static WebDriver driver = null;
	public static WebDriverWait waitDriver;
	public final static int TIMEOUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;
	public static Properties prop;
	public static Logger log = Logger.getLogger(SeleniumDriver_zeus.class);

	private String saucelabs_username = "";
	private String browserstack_username = "";
	private String saucelabs_accesskey = "";
	private String browserstack_accesskey = "";
	public String configPath = "/Users/sami/git/BDD_TestNG_CompleteFramework/src/main/java/com/Utilities/config.properties";
	public static String or_Json = "/Users/sami/git/EclipseWorkSpace/BDD_BootCamp/src/resources/java/com/FreeCRM_PageLocators/OR.json";

	
	public String grid_Env = getConfig_PropertiesFile(configPath).getProperty("useGrid");
	public String cloud_Env = getConfig_PropertiesFile(configPath).getProperty("useCloudEnv");

	
	

	private SeleniumDriver_zeus() throws IOException {
		
		if(grid_Env.equalsIgnoreCase("true")) {
			gridEnv();
		}else if(cloud_Env.equalsIgnoreCase("true")){
			cloudEnv();
		}else {
			localEnv();
		}
		
		driver.manage().window().maximize();

		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		String window = driver.getWindowHandle();
		System.out.println("Window ->" + window);
		
	}
	

	public WebDriver localEnv() throws IOException {

		String browserName = getConfig_PropertiesFile(configPath).getProperty("browserName");
		String os = getConfig_PropertiesFile(configPath).getProperty("os");

		if (browserName.equalsIgnoreCase("chrome")) {
			if (os.equalsIgnoreCase("Mac")) {
				System.setProperty("webdriver.chrome.driver",
						"/Users/sami/Desktop/RocketLauncher/Mac/Drivers/chromedriver_Mac_V237");
			} else if (os.equalsIgnoreCase("Win")) {
				System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
			}

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			if (os.equalsIgnoreCase("Mac")) {
				System.setProperty("webdriver.gecko.driver",
						"/Users/sami/Desktop/RocketLauncher/Mac/Drivers/geckodriver_V_19_1");
			} else if (os.equalsIgnoreCase("Win")) {
				System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");
			}
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "../Generic/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		return driver;

	}

	public WebDriver cloudEnv() throws MalformedURLException {

		String browserName = getConfig_PropertiesFile(configPath).getProperty("browserName");
		String browserVersion = getConfig_PropertiesFile(configPath).getProperty("browserVersion");
		String os = getConfig_PropertiesFile(configPath).getProperty("os");
		String os_version = getConfig_PropertiesFile(configPath).getProperty("os_version");
		String cloudEnvName = getConfig_PropertiesFile(configPath).getProperty("cloudEnvName");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browser", browserName);
		cap.setCapability("browser_version", browserVersion);
		cap.setCapability("os", os);
		cap.setCapability("os_version", os_version);
		if (cloudEnvName.equalsIgnoreCase("Saucelabs")) {
			driver = new RemoteWebDriver(new URL(
					"http://" + saucelabs_username + ":" + saucelabs_accesskey + "@ondemand.saucelabs.com:80/wd/hub"),
					cap);
		} else if (cloudEnvName.equalsIgnoreCase("Browserstack")) {
			cap.setCapability("resolution", "1024x768");
			driver = new RemoteWebDriver(new URL("http://" + browserstack_username + ":" + browserstack_accesskey
					+ "@hub-cloud.browserstack.com/wd/hub"), cap);
		}
		return driver;

	}

	public WebDriver gridEnv() throws MalformedURLException {

		// passing node url to remote driver
		String nodeURL = getConfig_PropertiesFile(configPath).getProperty("gridURL");

		// WebDriver driver = null;

		DesiredCapabilities caps = new DesiredCapabilities();

		// Platforms
		String platform = getConfig_PropertiesFile(configPath).getProperty("platform");
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(org.openqa.selenium.Platform.MAC);
		}
		if (platform.equalsIgnoreCase("Linux")) {
			caps.setPlatform(org.openqa.selenium.Platform.LINUX);
		}

		// Browsers
		String browserName = getConfig_PropertiesFile(configPath).getProperty("browserName");
		if (browserName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		// Version
		String browserVersion = getConfig_PropertiesFile(configPath).getProperty("browserVersion");
		caps.setVersion(browserVersion);

		driver = new RemoteWebDriver(new URL(nodeURL), caps);

		return driver;

	}

	public Properties getConfig_PropertiesFile(String configPropFile) {

		File file = new File(configPropFile);

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static void openPage(String url) {
		System.out.println(url);
		System.out.println(driver);
		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() throws IOException {
		if (seleniumDriver_zeus == null)
			seleniumDriver_zeus = new SeleniumDriver_zeus();

	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		seleniumDriver_zeus = null;
	}

}
