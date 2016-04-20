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
};

leaf.msg = function (content){
	var hid = $('.hidden-window');
	if(hid){
		hid.removeClass('hid');
	}
	var obj = $("<div style='color:red;text-shadow:1px 1px 0 #FF9900;font-weight:bolder;border:2px solid red;font-size:28px;text-align:center;top:200px;right:620px;position:fixed;'>"+content+"</div>");
	$('body').append(obj);
	setTimeout(function(){
		obj.remove();
		hid.addClass("hid");
	}, 1500);
};

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
/***********************************url工具*****************************************/
/**
 *	 从地址栏的参数得到参数的值，如果该参数不存在，则返回""，不是null，是""
 */

leaf.getQueryValue = function getQueryValue(queryName){
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


