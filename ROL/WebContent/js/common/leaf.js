/**
 *
 *	自定义常用js 以leaf开头
 *
 **/

function leaf(){}

/**
*
*	leaf的原型方法
*
**/
leaf.prototype = {
	constructor:leaf
	

};

/**
 * ajax调用 
 * @param aUrl url
 * @param aData 传输的数据
 * @param aDataType 类型
 * @param suc 成功回调函数
 * @param fal 失败回调函数
 */
leaf.ajax = function(aUrl,aData,aDataType,suc,fal){
	$.ajax({
	  type : 'post',
	  url : aUrl,
	  data : aData,
	  dataType : aDataType,
	  success : suc,
	  failed : fal
	})
}
/**
 * 创建一个tip
 * @param id tip作用的对象
 * @param content tip内显示的内容
 * @returns {String} tip的id
 */
leaf.toolsTip = function (id,content){
	if(id){
		var oPar = $("#"+id);
		var html = "";
		var tipId = "tip"+(Math.random()<<10).toString().substr(3);
		while($("#"+tipId)){
			tipId = "tip"+(Math.random()<<10).toString().substr(3);
		}
		html +="<div id='"+tipId+"' class=\"leaf-tips\">"+
					"<div class=\"leaf-tips-triangle\"></div>"+
						+"<div class=\"leaf-tips-content-background\">"+	
						+"<span class=\"leaf-tips-content\">"+content+"</span>"+				
					+"</div>"
				+"</div>";
		oPar.html(html);
		return tipId;
	}
}
leaf.clearTip = function (id){
	if(id){
		var oTip = document.getElementById(id);
		oTip.parentElement.removeChild(oTip);
		}
}
