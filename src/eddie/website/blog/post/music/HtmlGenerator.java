package eddie.website.blog.post.music;

import eddie.website.blog.post.property.MusicPostPropertyManager;

public class HtmlGenerator {

	private static String htmlText = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		prepareHtmlText();

		writeHtmlContentToFile();
	}

	private static void prepareHtmlText() {

		String fb_Text = MusicPostPropertyManager
				.getProperty(MusicPostConstants.PROP_FB_ROOT_TEXT);
		String bandName = MusicPostPropertyManager
				.getProperty(MusicPostConstants.PROP_BAND_NAME);
		String imageDirUrl = MusicPostPropertyManager
				.getProperty(MusicPostConstants.PROP_POST_IMAGE_DIR_URL);
		htmlText += fb_Text + "\n";

		htmlText += MusicPostConstants.TEXT_1 + "\n";

		htmlText += MusicPostConstants.TEXT_2 + imageDirUrl + "band.jpg";

		htmlText += MusicPostConstants.TEXT_3 + bandName + ": The Band"
				+ MusicPostConstants.TEXT_4 + "\n";
		htmlText += MusicPostConstants.TEXT_5 + "\n";

		int total_songs = Integer.parseInt(MusicPostPropertyManager
				.getProperty(MusicPostConstants.PROP_TOTAL_SONGS));

		for (int i = 1; i <= total_songs; i++) {
			String song_album_year_text = MusicPostPropertyManager
					.getProperty("SONG_ALBUM_YEAR_" + i);
			String singleBlockText = generateTextBlock(i, song_album_year_text,
					bandName, imageDirUrl);
			htmlText += singleBlockText + "\n";
		}

		htmlText += MusicPostConstants.END_STRING;

		System.out.print(htmlText);

	}

	private static String generateTextBlock(int i, String song_album_year_text,
			String bandName, String imageDirUrl) {
		String text = "";
		String[] arr = song_album_year_text.split("#");
		text += "\t<!-- #" + i + " Begin-->\n";
		// text += "\t" + bandName + " :: Song details: " + song_album_year_text
		// + "\n";
		text += MusicPostConstants.BLOCK_TEXT_1 + i + "-" + bandName + ": "
				+ arr[0] + "\" alt=\"" + bandName + ": " + arr[0] + "\" src=\""
				+ imageDirUrl + i + ".jpg";
		text += MusicPostConstants.BLOCK_TEXT_2 + "\n";
		text += MusicPostConstants.BLOCK_TEXT_3 + i
				+ MusicPostConstants.BLOCK_TEXT_4 + arr[0]
				+ MusicPostConstants.BLOCK_TEXT_5 + arr[1] + "' (" + arr[2]
				+ ")";
		text += MusicPostConstants.BLOCK_TEXT_6 + arr[0]
				+ MusicPostConstants.BLOCK_TEXT_7 + "\n";

		text += "\t<!-- #" + i + " Ends-->";

		return text;
	}

	private static void writeHtmlContentToFile() {

	}

}
