<%@ page language="java" contentType="text/html; charset=utf-8" import="java.io.*,java.util.*,java.net.URLEncoder,java.net.URLDecoder,java.util.zip.*"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
request.setAttribute("ctxPath", basePath);
%>

<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件下载</title>
</head>

<style>
.filelist-item-file{
background:#eee;
cursor: pointer;
}
.filelist-item-directory{
background:#FFEAA6;
cursor: pointer;
}
.filelist-item-root{
background:#666;
cursor: pointer;
}

.filelist-item{
margin: 1px;
cursor: pointer;
}

.file-list-checkbos{
display: inline-block;
}
.ui-checkbox{
float:left;
}
</style>

<body>

<%


//创建需要的工具方法
class FileDesc implements Comparable<FileDesc>{ 
	private String filePath;
	private String fileType;
	private String fileName;
	private long lastModified;
	
	public FileDesc(){}
	
	public FileDesc(String filePath ,String fileType,String fileName,long lastModified){
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileName = fileName;
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	public void setFileType(String fileType){
		this.fileType = fileType;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public String getFilePath(){
		try{
			return URLEncoder.encode(filePath,"utf-8");
		}catch(Exception e){ 
			e.printStackTrace();
			}
		return filePath;
	}
	
	public String getFileType(){
		return fileType;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public long getLastModifed(){
		return lastModified;
	}
	
	public void setLastModified(long lastModified){
		this.lastModified = lastModified;
	}
	
	public int compareTo(FileDesc f1){
		return  new Long(this.lastModified).compareTo( f1.lastModified);
	}
	
}



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
	CommonUtil c = new CommonUtil();
	public String getFileListToJson(File file){
		StringBuilder sb = new StringBuilder();
		if(file.isDirectory()){
			File [] files = file.listFiles();
			for(File f:files){
				sb.append(",").append(getFileIntorduceToJson(f));
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
	public String getFileIntorduceToJson(File file){
		return "{'filePath':'"+file.getAbsolutePath()+"','fileType':'"+(file.isDirectory()?"directory":"file")+"','fileName'}:'"+file.getName()+"'";
	}
	
	//得到文件夹下面的文件的信息
	public List<FileDesc> getFileListToBean(File file){

		List<FileDesc> list = new ArrayList<FileDesc>();
		if(file.isDirectory()){
			File [] files = file.listFiles();
			if(files == null || files.length == 0) return list;
			for(File f:files){
				//只显示可读文件和非隐藏文件  否则会出现莫名其妙的错误
				if(f.canRead() && !f.isHidden()){
					list.add(getFileIntorduceToBean(f));
				}
			}
			Collections.sort(list);
		}
		
		return list;
	}
	//得到传入的文件的信息
	public FileDesc getFileIntorduceToBean(File file){
		return new FileDesc(file.getAbsolutePath(),file.isDirectory()?"directory":"file",file.getName(),file.lastModified());
	}
	
	//得到绝对路径
	public String getRealPath(ServletContext servletContext, String name){
		String path = servletContext.getRealPath(name);
		try{
			if(c.isBlank(path)){
				servletContext.getResource(name).getPath();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return path;
	}
	
	public void zip(OutputStream os, File []inputFile) throws Exception {  
        System.out.println("压缩中...");  
        ZipOutputStream out = new ZipOutputStream(os);  
        BufferedOutputStream bo = new BufferedOutputStream(out); 
        for(File f : inputFile){
	        zip(out, f, f.getName(), bo);  
        }
        bo.close();  
        out.close(); // 输出流关闭  
        System.out.println("压缩完成");  
    }  
  
    public void zip(ZipOutputStream out, File f, String base,  
            BufferedOutputStream bo) throws Exception { // 方法重载  
    	if(f.isHidden()) return ;
            
        if (f.isDirectory()) {  
            File[] fl = f.listFiles();  
            if (fl == null || fl.length == 0) {  
                out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base  
                System.out.println(base + "/");  
            }  
            for (int i = 0; i < fl.length; i++) {  
                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹  
            }  
        } else {  
            out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base  
            FileInputStream in = new FileInputStream(f);  
            BufferedInputStream bi = new BufferedInputStream(in);  
            int b;  
            while ((b = bi.read()) != -1) {  
                bo.write(b); // 将字节流写入当前zip目录  
            }  
            bi.close(); 
            bo.flush();
            in.close(); // 输入流关闭  
        }  
    } 
    
    //设置文件到流中，以供前台下载
    public void setFile(HttpServletRequest request,HttpServletResponse response,JspWriter out,PageContext pageContext,String filePath[]) throws Exception{
    		
    /* 	response.reset();
    	response.resetBuffer(); */
    	if(filePath == null || filePath.length == 0){
    		return ;
    	}
    	String fileName = "";
    	response.reset();
        ServletOutputStream ou = response.getOutputStream();
    	response.setContentType("text/html;charset=utf-8");

        if(filePath.length == 1 ){//处理单个文件，不进行压缩，直接传输以供下载
	    	File file = new File(URLDecoder.decode(filePath[0],"utf-8"));
        
	    	if (!file.exists()) {
				 out.write("<script>alert('文件已被删除+'"+file.getName()+")</script>");
	    		 return;
	            }
	   		if(file.isFile()){
	   			
				 fileName = file.getName();
				 System.out.println(fileName);
				 FileInputStream fis = new FileInputStream(file);
			     BufferedInputStream bis = new BufferedInputStream(fis);
			     
			     response.setContentType("application/x-msdownload");
                 response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"),"iso-8859-1") + "");
                 
                 if (bis != null) {
                     int filelen = bis.available();
                     
                     byte a[] = new byte[1024*256];
                     int len;
                     while((len = bis.read(a)) != -1 ){
 	                    ou.write(a,0,len);
                     	
                     }
                 }
                 ou.flush();  
                 ou.close();  
                 ou=null;  
                 response.flushBuffer();  
                 out.clear();  
                 bis.close();
                 return ;
	   		}
    	}
        
    	fileName = "download.zip";
	     
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "");
        
        File []files = new File[filePath.length];
        
		for(int i=0;i<files.length;i++){
			files[i] = new File(filePath[i]);
		}                
        zip(ou, files);
        
        ou.flush();  
        ou=null;  
        response.flushBuffer();  
        out.clear();  
    }
    	
    	
        
 	 // 读取文件流
     // 下载文件
     // 设置响应头和下载保存的文件名
}

FileUtil f = new FileUtil();
 

//前台的相关操作
	String password = "a";
	String param = "a";
	String type = request.getParameter("type");
	
	//默认获取目录结构
	if(c.isBlank(type)){
		type = "init";
	} 
	
	//输入密码
	if(!"check".equals(request.getAttribute("check")+"")){
		if(password.equals(request.getParameter(param))){
			session.setAttribute("check", "check");
		}else{
	%><script>
		alert("非法登录");
	  </script>
	<%
		return;
		} 
	}
	//验证成功
	if("getFileList".equals(type)){//获取目录结构
		String filePath = request.getParameter("filePath");
		File file = new File(URLDecoder.decode(filePath,"utf-8"));
		
		List<FileDesc> fd = f.getFileListToBean(file);
		
		%>
		<div id="filelist" class="filelist" >
			<form action="file_list.jsp?a=a" id="iForm">
				<input type="hidden" name="a" value="a">
				<input type="hidden" name="type" value="download">
				<ul id="filelist-ul" >
				<li class="filelist-item filelist-item-tips">当前位置：<%=URLDecoder.decode(file.getAbsolutePath(),"utf-8") %>　　　　　　　　　　　<button type="button" onclick="downloadAll()">下载</button></li>
					<%
					for(FileDesc f1:fd){
						if(f1.getFileName().toUpperCase().endsWith(".MSI")) continue;
						if("directory".equals(f1.getFileType())){
					%>
						<li class='filelist-item filelist-item-directory' ondblclick="clickDirectory('<%=f1.getFilePath() %>')"><div class="file-list-checkbos"><input type="checkbox" name="fileList" value="<%=f1.filePath %>"/><%=f1.getFileName()%></div></li>
					<% 
					}else{
							
						%>
						<li class='filelist-item filelist-item-file' ondblclick="downOneFile('<%=f1.getFilePath() %>')"><div class="file-list-checkbos"><input type="checkbox" name="fileList" value="<%=f1.filePath %>"/><%=f1.getFileName()%></div></li>
						<% 
					}
					}
					%>
				</ul>
			</form>
		</div>
		<%
		
	} else if("init".equals(type)){
		
		String filePath = f.getRealPath(application, "/");
		FileDesc fd= f.getFileIntorduceToBean(new File("file_list.jsp"));
		File[] files= new File("file_list.jsp").listRoots();
		
		
		%>
		<div id="filelist" class="filelist" >
			<form action="file_list">
				<ul id="filelist-ul" >
					<li class="filelist-item filelist-item-tips">当前位置：根目录</li>
					<%
					for(File file:files){

						if(file.listFiles() == null) continue;
					%>
					<li class='filelist-item filelist-item-root' ondblclick="clickDirectory('<%=URLEncoder.encode(file.getAbsolutePath(),"utf-8") %>')"><label ><%=file.getAbsolutePath() %></label></li>
					<% 
					}
					%>
				</ul>
			</form>
		</div>
		<%
	} else if("download".equals(type)){//选中框下载
		String []filePath = request.getParameterValues("fileList");
		try{
			f.setFile(request, response, out,pageContext,filePath);
			pageContext.pushBody();
			return ;
		}catch(Exception e){e.printStackTrace();}
			
	}else if("downloadForOne".equals(type)){//双击造成的下载
		String filePath = request.getParameter("filePath");
		try{
			f.setFile(request, response, out,pageContext,new String[]{filePath});
			
			pageContext.pushBody();
			
			return ;
			
		}catch(Exception e){
			e.printStackTrace();
			}
		
		
	}
	
	%>


</body>
	
<script>
	function clickDirectory(root){
		var url = window.location.href.split('?')[0];
		$go(url+'?a=a&type=getFileList&filePath='+root);
		
		}

	function downOneFile(path){
		var url = window.location.href.split('?')[0];
		$go(url+'?a=a&type=downloadForOne&filePath='+path);
		}

	function downloadAll(){
		var obj = document.getElementsByName('fileList');
		var val = new Array();
		
		for(var i = 0 ;i<obj.length;i++){
			if(obj[i].checked){
				val.push(obj[i].value);
			}
		}
		
		if(val.length == 0){
			alert("未选中文件！");
			return false;
			}
		
		document.forms[0].submit();
		}

	function $go(address){document.location.assign(address);}
</script>
</html>