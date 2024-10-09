package LD01.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "videos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name="Video.findAll", query="SELECT v From Video v")
public class Video implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VideoId")
    private int videoId;

    @Column(name = "Active")
    private int active;

    @Column(name = "Description", columnDefinition = "NVARCHAR(500) null")
    private String description;

    @Column(name = "Poster", columnDefinition = "NVARCHAR(500) null")
    private String poster;

    @Column(name = "Title", columnDefinition = "NVARCHAR(5000) null")
    @NotEmpty(message = "Không được để trống")
    private String title;

    @Column(name = "Views")
    private int views;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

}