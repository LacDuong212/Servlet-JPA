package LD01.dao;


import LD01.entity.Video;

import java.util.List;

public interface IVideoDao {

    void insert(Video video);

    void update(Video video);

    void delete(int videoid) throws Exception;

    Video findById(int videoid);

    int count();

    List<Video> findAll();

}
