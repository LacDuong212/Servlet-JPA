package LD01.services;

import LD01.entity.Video;

import java.util.List;

public interface IVideoService {

    int count();

    List<Video> findAll();

    Video findById(int videoid);

    void delete(int videoid) throws Exception;

    void update(Video video);

    void insert(Video video);
}
