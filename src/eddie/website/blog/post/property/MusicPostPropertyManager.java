package eddie.website.blog.post.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import eddie.website.blog.post.music.MusicPostConstants;

public class MusicPostPropertyManager {

	private static Properties prop = new Properties();

	static {
		try {
			String conn_path = MusicPostConstants.PROPERTIES_DIR
					+ MusicPostConstants.PATH_SEPERATOR
					+ MusicPostConstants.MUSIC_POST_PROPERTIES_FILENAME;
			prop.load(new FileInputStream(conn_path));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(String propertyName) {
		String str = prop.getProperty(propertyName);
		if (str == null) {
			System.out.println(propertyName
					+ "is not present in the property file : "
					+ MusicPostConstants.MUSIC_POST_PROPERTIES_FILENAME);
			str = "";
		}
		return str;
	}

	public static void setProperty(String propertyName, String value) {
		prop.setProperty(propertyName, value);
		String conn_path = MusicPostConstants.PROPERTIES_DIR
				+ MusicPostConstants.PATH_SEPERATOR
				+ MusicPostConstants.MUSIC_POST_PROPERTIES_FILENAME;

		try {
			prop.store(new FileOutputStream(conn_path), "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
