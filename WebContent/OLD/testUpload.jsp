<%@ page contentType="text/html;charset=GBK"%>  
<html>  
    <head>  
        <title>File Upload</title>  
    </head>  
    <body>  
        <font size=5 color=#FF0000> <b>�ļ��ϴ�----ʹ��jspsmart upload���</b>  
        </font>  
        <br>  
  
        <form action="TestUpload" method="post" enctype="multipart/form-data">  
            <p>  
                �ļ����ƣ�  
                <input type="file" name="file1" size="20" maxlength="80">  
            </p>  
            <p>  
                �ļ����ƣ�  
                <input type="file" name="file2" size="20" maxlength="80">  
            </p>  
            <p>  
                �ļ����ƣ�  
                <input type="file" name="file3" size="20" maxlength="80">  
            </p>  
            <p>  
                �ϴ�·����  
                <input type="text" name="path" size="30" maxlength="50">  
                <br>  
            </p>  
  
            <p>  
                ��������:  
                <input type="text" name="other" size="30" maxlength="50">  
            </p>  
            <p>  
                <input type="submit" value="�ϴ�">  
                <input type="reset" value="����">  
            </p>  
        </form>  
  
        <font size=5 color=#FF0000> <b>�ļ�����----ʹ��jspsmart upload���</b>  
        </font>  
        <br>  
        <form action="downloadfile" method="post">  
            <p>  
                �����ļ������ƣ�  
                <input type="text" name="downloadFileName" size="20" maxlength="80">  
            </p>  
            <input type="submit" value="����">  
    </body>  
    </form>  
</html>  