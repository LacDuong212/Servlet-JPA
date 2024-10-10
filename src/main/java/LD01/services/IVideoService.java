package LD01.services;

import LD01.entity.Video;

import java.util.List;

public interface IVideoService {

    int count();

    List<Video> findAll();

    Video findById(String videoid);

    void delete(String videoid) throws Exception;

    void update(Video video);

    void insert(Video video);
}
