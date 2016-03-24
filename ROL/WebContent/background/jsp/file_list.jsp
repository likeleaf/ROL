<%@ page language="java" contentType="text/html; charset=utf-8" import="java.io.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件下载</title>
    
</head>
<body>

<%
//创建需要的工具方法
//通用工具类
class CommonUtil{
	public boolean isBlank(String str){
		return (str == null || str.trim().equals(""));
	}
	
	public boolean isNotBlank(String str){
		return !isBlank(str);
	}
}
CommonUtil c = new CommonUtil();

//创建文件相关的操作

 class FileUtil{
	public String getFileListToJson(File file){
		StringBuilder sb = new StringBuilder();
		if(file.isDirectory()){
			File [] files = file.listFiles();
			for(File f:files){
				sb.append(",").append(getFileIntorduce(f));
			}
		}else{
			sb.append("file");
		}
		if(sb.length() <= "file".length()){
			return sb.toString();
		}
		
		return "{["+sb.substring(1)+"]}";
	}
	
	//得到文件的介绍，json形式
	public String getFileIntorduce(File file){
		return "{'filePath':'"+file.getAbsolutePath()+"','fileType':'"+(file.isDirectory()?"directory":"file")+"','fileName'}:'"+file.getName()+"'";
	}
	
	
	public String getRealPath(ServletContext servletContext, String name){
		String path = servletContext.getRealPath("name");
		try{
			if(c.isBlank(path)){
				servletContext.getResource(name).getPath();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return path;
	}
}

FileUtil f = new FileUtil();
 
%>
<%
//前台的相关操作
	String password = "a";
	String param = "a";
	String type = request.getParameter("type");
	
	//默认获取目录结构
	/* if(c.isBlank(type)){
		type = "init";
	} */
	
	OutputStream os = response.getOutputStream();
	
	//输入密码
	if(!"check".equals(request.getAttribute("check")+"")){
		
		if(password.equals(request.getParameter(param))){
			session.setAttribute("check", "check");
		}else{
			
	%><script>
		alert("非法登录");
	</script><%
		} 
	}
	else{//验证成功
		String json = "";
		if("getFileList".equals(type)){//获取目录结构
			String filePath = request.getParameter("filePath");
			File file = new File(filePath);
			json = f.getFileListToJson(file);
			
		} else if("init".equals(type)){
			String filePath = f.getRealPath(application, "/");
			json = f.getFileIntorduce(new File(filePath));
			
		} else if("download".equals(type)){
			String []filePath = request.getParameterValues("fileList");
			if(filePath != null && filePath.length >1){
				
			}else{//单个文件直接得到文件然后下载
				
			}
		}
		os.write(json.getBytes());
		if(os != null){
			os.close();
		}
	}
	%>
<div id="filelist" class="filelist" >
	<ul id="filelist-ul" >
		
	</ul>
</div>

</body>
	
	
	
	
<script>
	$(function (){
		var value = getQueryValue("a");
		if("a" == value){
			 var myurl = url + "/jsp/sys/file_list.jsp?type="+"init";
			 $sendRequest("post",myurl,null,"text",window,getFileListInit);
			}
		});


	function getQueryValue(queryName){
		var myurl = window.location.href;
		if(myurl.indexOf("?") != -1 && myurl.indexOf(queryName+"=") != -1){
			var queryString = myurl.substring(myurl.indexOf("?")+1);
			var array = queryString.split("&");
			
			for(var i=0;i<array.length;i++){
				var query = array[i].split("=");
				if(queryName == query[0]){
					return query[1];
				}
			}
		}
		return "";
	}

	function getFileListInit(){
		var res = ajax.json;
		for(var key in res){
			alert(res);
			}
		}

		
</script>
</html>