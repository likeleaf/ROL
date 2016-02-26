	function searchUser(){
		var myurl = '${basePath}/background/jsp/user/user_searchUser';
		alert($('#userName').val());
		
		$('#searchForm').form('submit',{
			url: myurl,
			onSubmit: function(){
				return true;
			},
			success: function(result){
				var data = eval('(' + result + ')');  
				if (data.suc == 'suc'){
					$('#users').datagrid('reload');	
				} else {
					$.messager.alert({
						title: '查询出错！',
						msg: '<span style="text-align:center;margin-left:auto;margin-right:auto;color:red;display:bolck">'+data.msg+'</span>'
					});
				}
				return false;
			}
		});
	}
