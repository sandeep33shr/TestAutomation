package com.ssp.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.apache.commons.lang.StringUtils;
import org.testng.log4testng.Logger;

// TODO: Auto-generated Javadoc
/**
 * EnvironmentPropertiesReader is to set the environment variable declaration
 * mapping for config properties in the UI test.
 */
public class EnvironmentPropertiesReader {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(EnvironmentPropertiesReader.class);
	
	/** The env properties. */
	private static EnvironmentPropertiesReader envProperties;

	/** The properties. */
	private Properties properties;

	/**
	 * Instantiates a new environment properties reader.
	 */
	private EnvironmentPropertiesReader() {
		properties = loadProperties();
	}

	/**
	 * Load properties.
	 *
	 * @return the properties
	 */
	private Properties loadProperties() {
		File file = new File("./src/main/resources/config.properties");
		FileInputStream fileInput = null;
		Properties props = new Properties();

		try {
			fileInput = new FileInputStream(file);
			props.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			log.error("config.properties is missing or corrupt : " + e.getMessage());
		} catch (IOException e) {
			log.error("read failed due to: " + e.getMessage());
		}

		return props;
	}

	/**
	 * Gets the single instance of EnvironmentPropertiesReader.
	 *
	 * @return single instance of EnvironmentPropertiesReader
	 */
	public static EnvironmentPropertiesReader getInstance() {
		if (envProperties == null) {
			envProperties = new EnvironmentPropertiesReader();
		}
		return envProperties;
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * Checks for property.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	public boolean hasProperty(String key) {
		return properties.getProperty(key).isEmpty();
	}
}
