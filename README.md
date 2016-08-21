# A Media Library Website using Apache Derby & Hibernate & JPA
---  
> Richard Thomas in course :
>> Media Vault is a personal media library which can Up/Download and immediate access your radio/video resource.


## Intro

Using Derby embed model as server, Hibernate as JPA implementation, servlet as controller and jsp as viewer.  

Design the DB -> create model class -> unit test model ->  implement DAO ->

Create html -> change to jsp -> design service/servlet according to needed ->

## Installation  

*Assuming that you are using eclipse*  

1. project -> R click -> add external jars. Then add jdom.jar/smartupload.jar/...,  which is in /WenContent/WEB-INF/lib , to it.  

2. maven update. If error occurred, delete local maven folder and retry.

3. Run as -> run configurations -> tomcat7 -> classpath -> add projects. Then add this project. It can ensure the entitymanager can be used in our project.

4. Can also create a new maven webapp project and copy these files.

5. Presist.xml web.xml would be edit later.

**Also, meta-data of media can be store in xml**  

*if you wanna use xml(.nfo) to store the data, plz use jps files in folder 'OLD' instead of current jsp.*

## TODO
- [ ] get upload*.jsp together to 1 file.
- [ ] responsive page optimization
- [ ] login service

## Reference
- [Bootstrap](https://github.com/twbs/bootstrap)
- [Dropzone.js](http://www.dropzonejs.com/)
- Jspsmart
- Junit
- [Coreservlets-JPA](http://www.coreservlets.com)
- [dropdown](https://github.com/CWSpear/bootstrap-hover-dropdown)

---
Also thanks @Richard and @Ada   
Feel free to filing an issue :)

---  
[DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE](http://www.wtfpl.net/txt/copying/)
