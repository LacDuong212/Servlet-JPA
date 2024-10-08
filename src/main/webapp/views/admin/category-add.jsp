<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype="multipart/form-data">
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>
    <label for="image">Image:</label><br>
    <div style="width: 100px; height: 100px">
        <img id="images" height="150px" width="150px" src=""  alt="image"/>
    </div><br><br><br>
   <%-- Nhập link: <input type="text" id="imageUrl" name="imageUrl" oninput="previewByUrl()"><br><br>--%>
    Upload file:
    <input type="file" onchange="chooseFile(this)" id="image" name="image"><br>
    <p>Status:</p>
    <input type="radio" id="ston" name="status" value="1" checked>
    <label for="ston">Đang hoạt động</label><br>
    <input type="radio" id="stoff" name="status" value="0">
    <label for="stoff">Khóa</label><br>
    <br> <input type="submit" value="Add Category">
</form>