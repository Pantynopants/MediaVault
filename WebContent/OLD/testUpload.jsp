<%@ page contentType="text/html;charset=GBK"%>  
<html>  
    <head>  
        <title>File Upload</title>  
    </head>  
    <body>  
        <font size=5 color=#FF0000> <b>文件上传----使用jspsmart upload组件</b>  
        </font>  
        <br>  
  
        <form action="TestUpload" method="post" enctype="multipart/form-data">  
            <p>  
                文件名称：  
                <input type="file" name="file1" size="20" maxlength="80">  
            </p>  
            <p>  
                文件名称：  
                <input type="file" name="file2" size="20" maxlength="80">  
            </p>  
            <p>  
                文件名称：  
                <input type="file" name="file3" size="20" maxlength="80">  
            </p>  
            <p>  
                上传路径：  
                <input type="text" name="path" size="30" maxlength="50">  
                <br>  
            </p>  
  
            <p>  
                附加内容:  
                <input type="text" name="other" size="30" maxlength="50">  
            </p>  
            <p>  
                <input type="submit" value="上传">  
                <input type="reset" value="重置">  
            </p>  
        </form>  
  
        <font size=5 color=#FF0000> <b>文件下载----使用jspsmart upload组件</b>  
        </font>  
        <br>  
        <form action="downloadfile" method="post">  
            <p>  
                下载文件的名称：  
                <input type="text" name="downloadFileName" size="20" maxlength="80">  
            </p>  
            <input type="submit" value="下载">  
    </body>  
    </form>  
</html>  