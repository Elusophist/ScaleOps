package scaleops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ImageDownloaderApplication {

    private static final int MAX_IMAGES = 10; // Maximum number of images to download
    private static final String SEARCH_QUERY = "cute kittens"; // Search query string

    public static void main(String[] args) {
        SpringApplication.run(ImageDownloaderApplication.class, args);
    }
}
