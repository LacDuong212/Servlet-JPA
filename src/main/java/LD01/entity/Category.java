package LD01.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name="Category.findAll", query="select c from Category c")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private int categoryId;

    @Column(name = "Categoryname", columnDefinition = "NVARCHAR(200) NOT NULL")
    @NotEmpty(message = "Không được để trống")
    private String categoryname;

    @Column(name = "Image", columnDefinition = "NVARCHAR(MAX)")
    private String image;

    @Column(name = "Status")
    private int status;

    @OneToMany(mappedBy = "category")
    private List<Video> videos;

    public Video addVideo(Video video){
        getVideos().add(video);
        video.setCategory(this);

        return video;
    }

    public Video removeVideo(Video video){
        getVideos().remove(video);
        video.setCategory(null);

        return video;
    }
}