package LD01.dao;


import LD01.entity.Video;

import java.util.List;

public interface IVideoDao {

    void insert(Video video);

    void update(Video video);

    void delete(String videoid) throws Exception;

    Video findById(String videoid);

    int count();

    List<Video> findAll();

}
