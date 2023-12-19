package scaleops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageDownloaderImpl implements ImageDownloader {

    @Autowired
    private ImageRepository imageRepository;

    private final String searchQuery;
    private final String jdbcUrl;
    private final String username;
    private final String password;

    private ImageResizer resizer;

    public ImageDownloaderImpl(String searchQuery, String jdbcUrl, String username, String password) {
        this.searchQuery = searchQuery;
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    private List<String> downloadImages() {
        List<String> imageUrls = new ArrayList<>();
        try {
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/search?q=" + searchQuery);

            WebElement imageElement = driver.findElement(By.cssSelector("img.Q4LuWd"));
            String imageUrl = imageElement.getAttribute("src");

            // Download image to local system
            Random random = new Random();
            int i = random.nextInt();
            File imageFile = new File("image" + i + ".jpg");
            URL url = new URL(imageUrl);
            ImageIO.write(ImageIO.read(url), "jpg", imageFile);

            imageUrls.add(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageUrls;
    }



    @Override
    public void downloadAndStoreImages() {
        List<String> imageUrls = downloadImages();
        List<Image> images = new ArrayList<>();

        for (String imageUrl : imageUrls) {
            Image image = new Image();
            image.setUrl(imageUrl);
            image.setFilename("image" + images.size() + ".jpg");
            image.setSearchQuery(searchQuery);

            resizeAndStoreImage(imageUrl, image);

            images.add(image);
        }

        imageRepository.saveAll(images);
//        resizeAndStoreImage();
    }

    private void resizeAndStoreImage(String imageUrl, Image image) {
        // Resize and store image using Asynchronous tasks
        // ...
    }
}

