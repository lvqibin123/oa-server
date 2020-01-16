package com.lvqibin.oa.sys.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.lvqibin.oa.common.AngularFileMeta;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.service.CommonService;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/common")
@Slf4j
public class CommonController {
	
	/**
     * @apiDefine commonGroup 公共方法管理
     */
	
	@Autowired
	private CommonService service;
	
	private static String DOC_STORE_PATH = "fileUpload/angularFileUpload/";

	/**
     *  根据 列名、列值、表名和主键ID 查询记录数  
     *  date 2019-12-05
     *@author lvqibin
     *@param dbSchema 表空间名称 oa_sys(系统表空间)、oa_app(业务表空间) 不能为空
     *@param tableName 查询的表名 不能为空
     *@param columnName 查询列的名称 不能为空
     *@param columnValue 查询列的值 不能为空
     *@param idColumnName 表主键的名称  可以为空
     *@param idColumnValue 表主键的值  可以为空
     *@param  wheres where 条件不用加and  可以为空
     *@return Message
     */
	
	/**
     * @api {get} /common/isFind 根据 列名、列值、表名和主键ID 查询记录数
     * @apiDescription  根据 列名、列值、表名和主键ID 查询记录数
     * @apiName isFind
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  dbSchema 表空间名称 oa_sys(系统表空间)、oa_app(业务表空间) 不能为空
     * @apiParam {String}  tableName 查询的表名 不能为空
     * @apiParam {String}  columnName 查询列的名称 不能为空
     * @apiParam {String}  columnValue 查询列的值 不能为空
     * @apiParam {String}  idColumnName 表主键的名称  可以为空
     * @apiParam {String}  idColumnValue 表主键的值  可以为空
     * @apiParam {String}  wheres where 条件不用加and  可以为空
     * 
     * 
     *@apiSampleRequest /common/isFind
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   res.data.isFind true(已经存在)、  false(不存在)  
     *@apiSuccess (success 200) {String}   res.data.tip 提示信息
     *
     */
	
	@RequestMapping("/isFind")
	@ResponseBody
	@CheckToken
	public Message isFind(@RequestParam Map<String, String> params) {
		log.debug("CommonController.isFind  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		Message message = new Message();
		String dbSchema ="";
		String tableName="";
		String columnName="";
		String columnValue="";
		String idColumnName="";
		String idColumnValue="";
		
		String wheres="";
		if(StringUtils.isNotEmpty(params.get("dbSchema"))){ 
			dbSchema = params.get("dbSchema") ;
		}
		if(StringUtils.isNotEmpty(params.get("tableName"))){ 
			tableName = params.get("tableName") ;
		}
		if(StringUtils.isNotEmpty(params.get("columnName"))){ 
			columnName = params.get("columnName") ;
		}
		if(StringUtils.isNotEmpty(params.get("columnValue"))){ 
			columnValue = params.get("columnValue") ;
		}
		if(StringUtils.isNotEmpty(params.get("idColumnName"))){ 
			idColumnName = params.get("idColumnName");
		}
		if(StringUtils.isNotEmpty(params.get("idColumnValue"))){ 
			idColumnValue = params.get("idColumnValue");
		}
		if(StringUtils.isNotEmpty(params.get("wheres"))){ 
			wheres = params.get("wheres") ;
		}
		log.debug("Param : tableName = " + tableName );
		log.debug("Param : columnName = " + columnName );
		log.debug("Param : columnValue = " + columnValue );
		log.debug("Param : idColumnName = " + idColumnName );
		log.debug("Param : idColumnValue = " + idColumnValue );
		log.debug("Param : wheres = " + wheres );
		JsonObject json = new JsonObject();
		if ( StringUtils.isNotEmpty(tableName) && StringUtils.isNotEmpty(columnName) && StringUtils.isNotEmpty(columnValue) ) {
			Long dataCount= service.getDataCount(dbSchema,tableName,columnName,columnValue,idColumnName,idColumnValue,wheres);
			log.debug("action  : query    dataCount = " + dataCount );
			if(dataCount > 0 ) {
				json.addProperty("isFind", true);
				json.addProperty("tip", "查询数据记录成功！");
				message.setStatus(200);
				message.setData(json);
				message.setMessage("查询成功");
			}else {
				json.addProperty("isFind", false);
				json.addProperty("tip", "查询数据记录失败！");
				message.setStatus(200);
				message.setData(json);
				message.setMessage("查询成功");
			}
		} else {
			message.setStatus(-200);
			message.setMessage("表名、列名和列值不能为空！");
		}
		log.debug("CommonController.isFind  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return message;
	}
	
	
	
    /***************************************************
     * URL: common/angularFileUpload  
     * upload(): receives files
     * @param request : MultipartHttpServletRequest auto passed
     * @param response : HttpServletResponse auto passed
     * @return LinkedList<AngularFileMeta> as json format
     * @throws IOException 
     ****************************************************/
	
	/**
     * @api {get} /common/angularFileUpload angular的文件上传
     * @apiDescription  angular的文件上传
     * @apiName angularFileUpload
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  filePath 文件的保存路径 不能为空
     * @apiParam {String}  uid 前端文件生成的uuid 不能为空
     * 
     * 
     *@apiSampleRequest /common/angularFileUpload
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *@apiSuccess (success 200) {String}   res.data.fileID 文件id  
     *@apiSuccess (success 200) {String}   res.data.fileName 文件名称
     *@apiSuccess (success 200) {String}   res.data.fileSize 文件大小  
     *@apiSuccess (success 200) {String}   res.data.fileType 文件类型
     *@apiSuccess (success 200) {String}   res.data.filePath 文件路径
     *@apiSuccess (success 200) {String}   res.data.fileList 文件列表 暂时没有用到
     *
     */
	
    @RequestMapping(value="/angularFileUpload", method = RequestMethod.POST)
    @CheckToken
    public @ResponseBody LinkedList<AngularFileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, String> params) throws IOException {
 
    	String filePath = params.get("filePath");
    	String uid = params.get("uid");
        //1. build an iterator
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         StringBuilder json = new StringBuilder();
         LinkedList<AngularFileMeta> files = new LinkedList<AngularFileMeta>();
      
         //2. get each file
         while(itr.hasNext()){
 
             //2.1 get next MultipartFile
             mpf = request.getFile(itr.next()); 
            //  System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());
 
             //2.2 if files > 10 remove the first from the list
             if(files.size() >= 10)
                 files.pop();
 
             //2.3 create new fileMeta
             AngularFileMeta fileMeta = new AngularFileMeta();
             fileMeta.setFileName(mpf.getOriginalFilename());
             fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
             fileMeta.setFileType(mpf.getContentType());
             String fileID = "";
             if (StringUtils.isNotEmpty(uid)) {
            	 fileID = uid;
             } else {
            	 fileID = UUIDUtil.getUuid();
             }
             fileMeta.setFileID(fileID); 
            json.append("{");
			json.append("\"fileID\":\""+fileID+"\",");
			json.append("\"fileName\":\""+mpf.getOriginalFilename()+"\",");
			json.append("\"fileSize\":\""+mpf.getSize()/1024+" Kb"+"\",");
			json.append("\"fileType\":\""+mpf.getContentType()+"\",");
             try {
                // uploads文件夹位置
            	 // fileMeta.setBytes(mpf.getBytes()); 
            	 String rootPath = "" ;
            	 if (StringUtils.isNotEmpty(filePath)) {
            		 fileMeta.setFilePath(filePath); 
            		 rootPath = request.getSession().getServletContext().getRealPath("/")+ ".." + File.separator + ".."+File.separator+DOC_STORE_PATH+filePath+File.separator;
            		 json.append("\"filePath\":\""+filePath+"\"");
            	 }else {
            		 fileMeta.setFilePath("NULL"); 
            		 json.append("\"filePath\":\"\"");
            		 rootPath = request.getSession().getServletContext().getRealPath("/")+ ".." + File.separator + ".."+File.separator+DOC_STORE_PATH;
            	 }
                 File dir = new File(rootPath);
                 if (!dir.exists() && !dir.isDirectory()) {
    	              dir.mkdirs();
    	        }
                 FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(rootPath+fileID));
 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw e;
            }
             //2.4 add to files
             if (itr.hasNext()) {
            	 json.append("},");
             } else {
            	 json.append("}");
             }
             fileMeta.setFileList(json.toString()); 
             files.add(fileMeta);
         }
         
         // JsonArray jsonArray =  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJsonTree(files, new TypeToken<LinkedList<AngularFileMeta>>() {}.getType()).getAsJsonArray();
        return files;
    }
    
    /***************************************************
     * URL: /rest/controller/get/{value}
     * get(): get file as an attachment
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     * @throws IOException 
     ****************************************************/
    
    /**
     * @api {get} /common/getAngularFile angular的文件下载
     * @apiDescription  angular的文件下载
     * @apiName getAngularFile
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  filePath 文件的保存路径 不能为空
     * @apiParam {String}   fileID 文件id   不能为空
     * @apiParam {String}   fileName 文件名称 不能为空
     * @apiParam {String}   fileType 文件类型 不能为空
     * @apiParam {String}   filePath 文件路径 不能为空
     * 
     * 
     *@apiSampleRequest /common/getAngularFile
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *
     */
    @RequestMapping(value = "/getAngularFile" ,method = RequestMethod.GET)
    @CheckToken
     public void get(HttpServletRequest request,HttpServletResponse response,@RequestParam Map<String, String> params) throws IOException{
    	String filePath = params.get("filePath");
    	String fileName = params.get("fileName");
    	String fileID = params.get("fileID");
    	String fileType = params.get("fileType");
    	 String rootPath = "" ;
    	 if (StringUtils.isNotEmpty(filePath)) {
    		 rootPath = request.getSession().getServletContext().getRealPath("/")+ ".." + File.separator + ".."+File.separator+DOC_STORE_PATH+File.separator+filePath+File.separator+fileID;
    	 }else {
    		 rootPath = request.getSession().getServletContext().getRealPath("/")+ ".." + File.separator + ".."+File.separator+DOC_STORE_PATH+File.separator+fileID;
    	 }
         try {      
                response.setContentType(fileType);
                if ( "image/png".equals(fileType) ) {
                	response.setHeader("Content-disposition", "attachment; filename=\""+fileName+"\"");
                } else {
                	response.setHeader("Content-disposition", "inline; filename=\""+fileName+"\"");
                }
                File file = new File(rootPath);
                FileInputStream fis = new FileInputStream(file);
                FileCopyUtils.copy(fis, response.getOutputStream());
         }catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw e;
         }
    	/*File file = new File(rootPath);
 		FileInputStream fis = new FileInputStream(file);
 		response.setHeader("Cache-Control", "pre-check=0, post-check=0, max-age=0");
 		response.addHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
 			
 		OutputStream os = response.getOutputStream();
         byte[] buffer = new byte[BUFFER_SIZE];
         try {
             int read;
             while ((read = fis.read(buffer)) != -1) {
             	os.write(buffer, 0, read);
             }
         } finally {
             fis.close();
         }*/
     }
    /**
     * @api {get} /common/download angular的文件下载匹配的是href中的download请求
     * @apiDescription  angular的文件下载匹配的是href中的download请求
     * @apiName download
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
     * @apiHeader {String} token
     *
     * @apiParam {String}  filePath 文件的保存路径 不能为空
     * @apiParam {String}   fileID 文件id   不能为空
     * @apiParam {String}   fileName 文件名称 不能为空
     * @apiParam {String}   filePath 文件路径 不能为空
     * 
     * 
     *@apiSampleRequest /common/download
     *@apiSuccess (success 200) {String}   res.status    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.message    消息
     *
     */
    @RequestMapping(value="/download") //匹配的是href中的download请求
    @ResponseBody
//    @CheckToken
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam Map<String, String> params
            ) throws IOException{
    	String filePath = params.get("filePath");
    	String fileName = params.get("fileName");
    	String fileID = params.get("fileID");
		 String rootPath = "" ;
		 if (StringUtils.isNotEmpty(filePath)) {
			 rootPath = request.getSession().getServletContext().getRealPath("/")+ ".." + File.separator + ".."+File.separator+DOC_STORE_PATH+File.separator+filePath+File.separator+fileID;
		 }else {
			 rootPath = request.getSession().getServletContext().getRealPath("/")+ ".." + File.separator + ".."+File.separator+DOC_STORE_PATH+File.separator+fileID;
		 }
        
        File file = new File(rootPath);//新建一个文件
        
        HttpHeaders headers = new HttpHeaders();//http头信息
        
        String downloadFileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");//设置编码
        
        headers.setContentDispositionFormData("attachment", downloadFileName);
        
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
        
    }
    
    
    /**
     * date:2019-12-18
     * 获取省份
     * @param  keyWord 关键字搜索
     * */

    /**
     * @api {get} /common/queryProvice 获取省份
     * @apiDescription  获取省份
     * @apiName queryProvice
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
	 * @apiHeader {String} token
	 * 
     *
     * @apiParam {String}  keyWord 关键字搜索 可以为空
     *
     *@apiSampleRequest /common/queryProvice
     *@apiSuccess (success 200) {String}   res.code    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.msg    消息
     *@apiSuccess (success 200) {String}   res.data.value    编码
     *@apiSuccess (success 200) {String}   res.data.label    名称
     *
     *
     */
    @RequestMapping("/queryProvice")
    @ResponseBody
    @CheckToken
    public Message queryProvice(String keyWord){
        log.debug("CommonController.queryProvice  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("CommonController.queryProvice  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return service.queryProvice(keyWord);
    }

    /**
     * date:2019-12-18
     * 获取城市根据省份id
     * @param  keyWord 关键字搜索
     * @param  provinceId 省份id
     * */

    /**
     * @api {get} /common/queryCityByProviceId 获取城市根据省份id
     * @apiDescription  获取城市根据省份id
     * @apiName queryCityByProviceId
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
	 * @apiHeader {String} token
	 * 
     *
     * @apiParam {String}  keyWord 关键字搜索 可以为空
     * @apiParam {String}  provinceId 省份id 不能为空
     *
     *@apiSampleRequest /common/queryCityByProviceId
     *@apiSuccess (success 200) {String}   res.code    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.msg    消息
     *@apiSuccess (success 200) {String}   res.data.value    编码
     *@apiSuccess (success 200) {String}   res.data.label    名称
     *
     *
     */
    @RequestMapping("/queryCityByProviceId")
    @ResponseBody
    @CheckToken
    public Message queryCityByProviceId(String keyWord,String provinceId){
        log.debug("CommonController.queryCityByProviceId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  provinceId = " + provinceId );
        log.debug("CommonController.queryCityByProviceId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return service.queryCityByProviceId(keyWord,provinceId);
    }


    /**
     * date:2019-12-18
     * 获取县根据城市id
     * @param  keyWord 关键字搜索
     * @param  cityId 城市id
     * */

    /**
     * @api {get} /common/queryCountyByCityId 获取县根据城市id
     * @apiDescription  获取县根据城市id
     * @apiName queryCountyByCityId
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
      *
	 * @apiHeader {String} token
	 * 
     *
     * @apiParam {String}  keyWord 关键字搜索 可以为空
     * @apiParam {String}  cityId 城市id 不能为空
     *
     *@apiSampleRequest /common/queryCountyByCityId
     *@apiSuccess (success 200) {String}   res.code    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.msg    消息
     *@apiSuccess (success 200) {String}   res.data.value    编码
     *@apiSuccess (success 200) {String}   res.data.label    名称
     *
     *
     */
    @RequestMapping("/queryCountyByCityId")
    @ResponseBody
    @CheckToken
    public Message queryCountyByCityId(String keyWord,String cityId){
        log.debug("CommonController.queryCountyByCityId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  cityId = " + cityId );
        log.debug("CommonController.queryCountyByCityId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return service.queryCountyByCityId(keyWord,cityId);
    }


    /**
     * date:2019-12-18
     * 获取乡镇根据县id
     * @param  keyWord 关键字搜索
     * @param  countyId 县id
     * */

    /**
     * @api {get} /common/queryTownByCountyId 获取乡镇根据县id
     * @apiDescription  获取乡镇根据县id
     * @apiName queryTownByCountyId
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
	 * @apiHeader {String} token
	 * 
     *
     * @apiParam {String}  keyWord 关键字搜索 可以为空
     * @apiParam {String}  countyId 县id 不能为空
     *
     *@apiSampleRequest /common/queryTownByCountyId
     *@apiSuccess (success 200) {String}   res.code    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.msg    消息
     *@apiSuccess (success 200) {String}   res.data.value    编码
     *@apiSuccess (success 200) {String}   res.data.label    名称
     *
     *
     */
    @RequestMapping("/queryTownByCountyId")
    @ResponseBody
    @CheckToken
    public Message queryTownByCountyId(String keyWord,String countyId){
        log.debug("CommonController.queryTownByCountyId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  countyId = " + countyId );
        log.debug("CommonController.queryCountyByCityId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return service.queryTownByCountyId(keyWord,countyId);
    }

    /**
     * date:2019-12-18
     * 获取村根据乡镇id
     * @param  keyWord 关键字搜索
     * @param  townId 乡镇id
     * */

    /**
     * @api {get} /common/queryVillageByTownId 获取村根据乡镇id
     * @apiDescription  获取村根据乡镇id
     * @apiName queryVillageByTownId
     * @apiVersion 1.0.0
     * @apiGroup commonGroup
     *
     *
	 * @apiHeader {String} token
	 * 
     * @apiParam {String}  keyWord 关键字搜索 可以为空
     * @apiParam {String}  townId 乡镇id 不能为空
     *
     *@apiSampleRequest /common/queryVillageByTownId
     *@apiSuccess (success 200) {String}   res.code    标识码 200 成功 否则失败
     *@apiSuccess (success 200) {String}   res.msg    消息
     *@apiSuccess (success 200) {String}   res.data.value    编码
     *@apiSuccess (success 200) {String}   res.data.label    名称
     *
     *
     */
    @RequestMapping("/queryVillageByTownId")
    @ResponseBody
    @CheckToken
    public Message queryVillageByTownId(String keyWord,String townId){
        log.debug("CommonController.queryTownByCountyId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  keyWord = " + keyWord );
        log.debug("Param :  townId = " + townId );
        log.debug("CommonController.queryCountyByCityId  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return service.queryVillageByTownId(keyWord,townId);
    }
}
