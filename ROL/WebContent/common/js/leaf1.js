/**
 *	自定义常用js 以leaf开头
 **/
;(function($,window){
	
	$.fn.leaf = function(){
		return this.each(function(){
			
		});
	}
	
	/**
	 * ajax调用 
	 * @param aUrl url
	 * @param aData 传输的数据
	 * @param aDataType 类型
	 * @param suc 成功回调函数
	 * @param fal 失败回调函数
	 */
	$.fn.leaf.ajax = function(json){
		var setting = {type:'post',url:null,data:null,dataType:null,success:null,failed:null};
		
		$.extend{setting,json};
		
		if(setting.url){
			alert("使用ajax时，url不能为空！");
		}
		
		$.ajax({
		  type : setting.type,
		  url : setting.url,
		  data : setting.data,
		  dataType : setting.dataType,
		  success : setting.success,
		  failed : setting.failed
		})
	};
	
	
	$.fn.leaf.formatDate = function(date,format){
		var month = date.getMonth()+'';
		month = month.length == 1?'0'+month:month;
		var day = date.getDay()+'';
		day = day.length == 1?'0'+day:day;
		var year = date.getFullYear();
		
		if(/yy/.test(year)){
			year = year.substr(2,2);
		}
		
		return format.replace(/[y]+/,year).replace(/M+/,month).replace(/d+/,day);
	};
	
	$.fn.leaf.dataForSwap = function (cla,key){
		var date = {};
		
		var a = [{'10':'普通用户','20':'作者' ,'30':'管理员','40':'超级管理员'}];
		date['role'] = a;
		return date[cla][0][key];
	};
	
})(jQuery,window);




/*function leaf(){
	
};
*/
/**
 *	leaf的原型方法
 **/
/*leaf.prototype = {
	constructor:leaf
};*/

/**
 * ajax调用 
 * @param aUrl url
 * @param aData 传输的数据
 * @param aDataType 类型
 * @param suc 成功回调函数
 * @param fal 失败回调函数
 */
/*leaf.ajax = function(json){
	var setting = {type:'post',url:null,data:null,dataType:null,success:null,failed:null};
	
	$.extend{setting,json};
	
	if(setting.url){
		alert("使用ajax时，url不能为空！");
	}
	
	$.ajax({
	  type : setting.type,
	  url : setting.url,
	  data : setting.data,
	  dataType : setting.dataType,
	  success : setting.success,
	  failed : setting.failed
	})
};*/



/***********************************时间工具*****************************************/
/**
 * 将时间格式化为
 * @param date 时间 
 * @param format 格式 年份只能为2或者4或者0位
 */
/*leaf.formatDate = function(date,format){
	var month = date.getMonth()+'';
	month = month.length == 1?'0'+month:month;
	var day = date.getDay()+'';
	day = day.length == 1?'0'+day:day;
	var year = date.getFullYear();
	
	if(/yy/.test(year)){
		year = year.substr(2,2);
	}
	
	return format.replace(/[y]+/,year).replace(/M+/,month).replace(/d+/,day);
};*/

/************************************提供交换的数据*************************************/
/*leaf.dataForSwap = function (cla,key){
	var date = {};
	
	var a = [{'10':'普通用户','20':'作者' ,'30':'管理员','40':'超级管理员'}];
	date['role'] = a;
	return date[cla][0][key];
};*/