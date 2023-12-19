package scaleops;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageDownloaderConfig {

    @Value("${search.query}")
    private String searchQuery;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public ImageDownloader downloader() {
        return new ImageDownloaderImpl(searchQuery, jdbcUrl, username, password);
    }
}
