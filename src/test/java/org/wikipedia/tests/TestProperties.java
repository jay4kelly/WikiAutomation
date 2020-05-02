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
	private static String LINUX_CHROME_DRIVER_LOCATION = "linux_chrome_driver_location";
	private static String LINUX_FIREFOX_DRIVER_LOCATION = "linux_firefox_driver_location";
	private static String WINDOWS_CHROME_DRIVER_LOCATION = "windows_chrome_driver_location";
	private static String WINDOWS_FIREFOX_DRIVER_LOCATION = "windows_firefox_driver_location";
	protected static String URL = "url";
	protected static String LOG_SYSTEM_PROPERTIES = "log_system_properties";

	// PROPERTY VALUES
	private static String TRUE_VALUE = "true";

	// Browser Types
	public static String CHROME = "chrome";
	public static String SAFARI = "safari";
	public static String FIREFOX = "firefox";

	// System property values
	private static String OS_NAME = "os.name";

	// circleci property used to detect if build is running on circleci
	private static String WIKI_BUILD_ON_CIRCLE = "WIKI_BUILD_ON_CIRCLE";

	public TestProperties() throws IOException {
		try {
			loadPropertyFile();
			logPlatformInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Unable to load property file.", e);
			throw e;
		}
	}

	private void logPlatformInfo() {
		log.info((getCircleCIBuild()? "Building on Circleci": "Building on local"));
		if ((getlogSystemProperties() && loggedEnv == false)) {
			log.info("**************************");
			log.info("Log Environment Variables");
			Map<String, String> env = System.getenv();
			Set<String> keys = env.keySet();
			Iterator<String> iterator = keys.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				String value = env.get(key);
				log.info(key + " : " + value);
			}
			log.info("**************************");
			log.info("Log Environment Variables");
			Properties sysProp = System.getProperties();
			Set<Object> keySysSet = sysProp.keySet();
			Iterator<Object> iteratorSys = keySysSet.iterator();
			while (iteratorSys.hasNext()) {
				Object keySys = iteratorSys.next();
				Object keyVal = sysProp.get(keySys);
				log.info(keySys.toString() + " : " + keyVal.toString());
			}
			loggedEnv = true;
		}
	}

	private String getOperatingSystem() {
		return System.getProperty(OS_NAME);
	}

	private boolean isWindows() {
		return getOperatingSystem().contains("Win");
	}
	
	public boolean getlogSystemProperties() {
		return prop.getProperty(LOG_SYSTEM_PROPERTIES).compareToIgnoreCase(TRUE_VALUE) == 0 ? true : false;
	}

	public boolean getCircleCIBuild() {
		String circle = System.getenv(WIKI_BUILD_ON_CIRCLE);
		boolean result;
		if ((circle != null) && (circle.length() != 0)) {
			result = true;
		} else {
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

	public String getChromeDriverLocation() {
		return isWindows()? getWindowsChromeDriverLocation() : getLinuxChromeDriverLocation();
	}
	
	public String getFirefoxDriverLocation() {
		return isWindows()? getWindowsFirefoxDriverLocation() : getLinuxFirefoxDriverLocation();
	}
	
	private String getLinuxChromeDriverLocation() {
		return prop.getProperty(LINUX_CHROME_DRIVER_LOCATION);
	}

	private String getWindowsChromeDriverLocation() {
		return prop.getProperty(WINDOWS_CHROME_DRIVER_LOCATION);
	}

	private String getLinuxFirefoxDriverLocation() {
		return prop.getProperty(LINUX_FIREFOX_DRIVER_LOCATION);
	}
	
	private String getWindowsFirefoxDriverLocation() {
		return prop.getProperty(WINDOWS_FIREFOX_DRIVER_LOCATION);
	}
}
