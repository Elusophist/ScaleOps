package scaleops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "filename")
    private String filename;

    @Lob
    @Column(name = "image_data")
    private byte[] imageData;

    @Column(name = "search_query")
    private String searchQuery;
}
