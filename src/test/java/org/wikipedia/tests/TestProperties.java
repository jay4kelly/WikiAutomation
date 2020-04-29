package org.wikipedia.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestProperties {

	private static Properties prop = null;
	private static Boolean loggedEnv = false; 
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());

	// Property File
	private static String PROPERTY_FILE = "data.properties";

	// Properties
	private static String BROWSER = "browser";
	private static String HEADLESS = "headless";
	private static String MAC_CHROME_DRIVER_LOCATION = "mac_chrome_driver_location";
	private static String CIRCLE_CI_CHROME_DRIVER_LOCATION = "circleci_chrome_driver_location";
	private static String MAC_FIREFOX_DRIVER_LOCATION = "mac_firefox_driver_location";
	protected static String URL = "url";
	

	// PROPERTY VALUES
	private static String TRUE_VALUE = "true";

	// Browser Types
	public static String CHROME = "chrome";
	public static String SAFARI = "safari";
	public static String FIREFOX = "firefox";

	//circleci property used to detect if build is running on circleci
	private static String WIKI_BUILD_ON_CIRCLE = "WIKI_BUILD_ON_CIRCLE";
	
	public TestProperties() throws IOException {
		try {
			logPlatformInfo();
			loadPropertyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Unable to load property file.", e);
			throw e;
		}
	}

	private void logPlatformInfo() {
		if (loggedEnv == false) {
			Map<String,String> env = System.getenv();
			Set<String> keys = env.keySet();
			Iterator<String> iterator = keys.iterator();
			while (iterator.hasNext()) {
			    String key = iterator.next();
			    String value = env.get(key);
			    log.info(key + " : " + value);
			}
			Properties sysProp = System.getProperties();
			Set<Object> keySysSet = sysProp.keySet();
			Iterator<Object> iteratorSys = keySysSet.iterator();
			while(iteratorSys.hasNext()) {
				Object keySys = iteratorSys.next();
				Object keyVal = sysProp.get(keySys);
				log.info(keySys.toString() + " : " + keyVal.toString());
			}
			loggedEnv = true;
		}
	}
	
	public boolean isCircleCIBuild() {
		String circle = System.getenv(WIKI_BUILD_ON_CIRCLE);
		boolean result;
		if ((circle != null) && (circle.length() != 0)){
			result = true;
		}else
		{
			result = false;
		}
		return result;
	}
	
	private void loadPropertyFile() throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE);
		prop = new Properties();
		prop.load(is);
	}

	public String getBaseURL() {
		return prop.getProperty(URL);
	}

	private String getBrowserType() {
		return prop.getProperty(BROWSER);
	}

	public boolean useChromeBrowser() {
		return getBrowserType().equalsIgnoreCase(CHROME);
	}

	public boolean useFirefoxBrowser() {
		return getBrowserType().equalsIgnoreCase(FIREFOX);
	}

	public boolean useSafariBrowser() {
		return getBrowserType().equalsIgnoreCase(SAFARI);
	}

	public boolean useHeadless() {
		return Boolean.parseBoolean(prop.getProperty(HEADLESS));
	}

	public String getMACChromeDriverLocation() {
		return prop.getProperty(MAC_CHROME_DRIVER_LOCATION);
	}
	
	public String getCircleciChromeDriverLocation() {
		return prop.getProperty(CIRCLE_CI_CHROME_DRIVER_LOCATION);
	}
	
	public String getMACFirefoxDriverLocation() {
		return prop.getProperty(MAC_FIREFOX_DRIVER_LOCATION);
	}
}
