function leaf(){
	
};

leaf.prototype = {
		constructor:leaf
}

leaf.ajax = function(json){
	var setting = {type:'post',url:null,data:null,dataType:null,success:null,failed:null};
	
	$.extend(setting,json);
	console.log(setting.url);
	if(!setting.url){
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

/***********************************标签工具*****************************************/
leaf.alertContent = function(content){
	return "<span style=\"margin-left:auto;margin-right:auto;display:block;text-align:center\">"+content+"</span>";
}

/***********************************时间工具*****************************************/
/**
 * 将时间格式化为
 * @param date 时间 
 * @param format 格式 年份只能为2或者4或者0位
 */
leaf.formatDate = function(date,format){
	var month = (date.getMonth() + 1) + '';
	month = month.length == 1?'0'+month:month;
	var day = date.getDate()+'';
	day = day.length == 1?'0'+day:day;
	var year = date.getFullYear();
	
	if(/yy/.test(year)){
		year = year.substr(2,2);
	}
	
	return format.replace(/[y]+/,year).replace(/M+/,month).replace(/d+/,day);
};

/************************************提供交换的数据*************************************/
leaf.dataForSwap = function (cla,key){
	var date = {};
	
	var a = [{'10':'普通用户','20':'作者' ,'30':'vip','40':'管理员','50':'超级管理员'}];
	date['role'] = a;
	return date[cla][0][key];
};