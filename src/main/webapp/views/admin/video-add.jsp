<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath}/admin/video/insert" method="post" enctype="multipart/form-data">
    <label for="videoId" >Video ID:</label><br>
    <input type="text" id="videoId" name="videoId"><br><br>
    <label for="title">Video Title:</label><br>
    <input type="text" id="title" name="title"><br><br>
    <label for="poster">Poster:</label><br>
    <div style="width: 100px; height: 100px">
        <img id="images" height="150px" width="150px" src=""  alt="poster"/>
    </div><br><br><br>
    Upload File:
    <input type="file" onchange="chooseFile(this)" id="poster" name="poster"><br>
    <p><label for="description">Description:</label></p>
    <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>
    <label for="category">Choose category:</label>
    <select name="category" id="category">
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryId}">${category.categoryname}</option>
        </c:forEach>
    </select>
    <p>Status:</p>
    <input type="radio" id="ston" name="active" value="1" checked>
    <label for="ston">Đang hoạt động</label><br>
    <input type="radio" id="stoff" name="active" value="0">
    <label for="stoff">Khóa</label><br>
    <br> <input type="submit" value="Add Video">
</form>