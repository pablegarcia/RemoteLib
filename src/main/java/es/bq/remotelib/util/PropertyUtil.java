package es.bq.remotelib.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class represents the Application Properties utility. It should be used
 * for manage the main properties depending on the compiling environment.
 * 
 * @author Pablo Garcia
 */
public class PropertyUtil {

	/**
	 * Reads the properties file depending on the compiling environment (dev,
	 * demo, test and prod) and returns the set of defined properties.
	 * 
	 * @param propertiesFileName
	 *            The name of the containing properties file for this project.
	 * @return The set of environment properties
	 */
	public static Properties getProperties() {
		Properties properties = new Properties();

		// Get the transformed properties values as a stream
		InputStream stream = PropertyUtil.class.getClassLoader()
				.getResourceAsStream("project.properties");

		try {
			// Load the stream of properties on the Properties object to be
			// returned
			properties.load(stream);
		} catch (IOException exception) {
			return null;
		}

		try {
			stream.close();
		} catch (IOException exception) {
			return null;
		}

		return properties;
	}
}
