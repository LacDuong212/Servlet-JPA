package LD01.controllers.admin;

import LD01.entity.Category;
import LD01.entity.Video;
import LD01.services.ICategoryService;
import LD01.services.IVideoService;
import LD01.services.impl.CategoryService;
import LD01.services.impl.VideoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Paths;
import java.util.List;

import static LD01.utils.Constant.DIR;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/videos", "/admin/video/add",
        "/admin/video/insert", "/admin/video/edit", "/admin/video/update",
        "/admin/video/delete", "/admin/video/search"})
public class VideoController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    public IVideoService videoService = new VideoService();
    public ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("videos")) {
            List<Video> list = videoService.findAll();
            req.setAttribute("listvideo", list);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        } else if (url.contains("add")) {
            List<Category> categories = categoryService.findAll();  // Lấy danh sách category
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        } else if (url.contains("edit")) {
            List<Category> categories = categoryService.findAll();  // Lấy danh sách category
            req.setAttribute("categories", categories);
            String id = req.getParameter("id");

            Video video = videoService.findById(id);

            req.setAttribute("video", video);

            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        } else if (url.contains("delete")) {
            String id = req.getParameter("id");
            try {
                videoService.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("insert")) {
            Video video = new Video();
            String videoId = req.getParameter("videoId");
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            int categoryId = Integer.parseInt(req.getParameter("category"));
            int status = Integer.parseInt(req.getParameter("active"));

            video.setVideoId(videoId);
            video.setTitle(title);
            video.setDescription(description);
            video.setCategory(categoryService.findById(categoryId));
            video.setActive(status);

            String fname = "";
            String uploadPath = DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part filePart = req.getPart("poster");
                if (filePart.getSize() > 0) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    // Change file name
                    int index = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + fileExtension;
                    // Upload file
                    filePart.write(uploadPath + "/" + fname);
                    video.setPoster(fname);
                } else {
                    video.setPoster("default_poster.png");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            videoService.insert(video);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } else if (url.contains("update")) {
            String videoId = req.getParameter("videoId");
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            int categoryId = Integer.parseInt(req.getParameter("category"));
            int status = Integer.parseInt(req.getParameter("active"));

            Video video = videoService.findById(videoId);
            video.setTitle(title);
            video.setDescription(description);
            video.setCategory(categoryService.findById(categoryId));
            video.setActive(status);

            String oldPoster = video.getPoster();
            String fname = "";
            String uploadPath = DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part filePart = req.getPart("poster");
                if (filePart.getSize() > 0) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    // Change file name
                    int index = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + fileExtension;
                    // Upload file
                    filePart.write(uploadPath + "/" + fname);
                    video.setPoster(fname);
                } else {
                    video.setPoster(oldPoster);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            videoService.update(video);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }
}
