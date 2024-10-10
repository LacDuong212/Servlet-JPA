package LD01.services.impl;

import LD01.dao.IVideoDao;
import LD01.dao.impl.VideoDao;
import LD01.entity.Video;
import LD01.services.IVideoService;

import java.util.List;

public class VideoService implements IVideoService {

    IVideoDao videodao = new VideoDao();

    @Override
    public int count() {
        return videodao.count();
    }

    @Override
    public List<Video> findAll() {
        return videodao.findAll();
    }

    @Override
    public Video findById(String videoid) {
        return videodao.findById(videoid);
    }

    @Override
    public void delete(String videoid) throws Exception {
        videodao.delete(videoid);
    }

    @Override
    public void update(Video video) {
        videodao.update(video);
    }

    @Override
    public void insert(Video video) {
        videodao.insert(video);
    }
}
