window.onload = function(){
//	var ok =true;
	$("#f_mail").blur(function(){
//		获取用户输入的参数
		var mail = $("#f_mail").val();
		$("#f_mail_msg").html("");
		var reg2 = /^([0-9a-zA-Z])+\@([a-zA-Z0-9])+\.([a-zA-Z])+$/;
		$("#f_mail_msg").html("");
//		检查格式
//		当鼠标移开时检查邮箱格式
//		并且向数据库访问是否邮箱存在
//		正则表达式邮箱格式限制
		if(mail == "" || mail == null){
//			ok = false;
			$("#f_mail_msg").html("邮箱为空");
			return;
		}else if(!reg2.test(mail)){
//			ok = false;
			$("#f_mail_msg").html("邮箱格式不正确");
			return;
		}else{
//		格式通过后再向数据库发送请求
		$.post(base_path+"/forget/checkMail.do",
				{"email":mail},
				function(result){
					if(result.status == 1){
						$("#f_mail_msg").text("");
					}else if(result.status == 0){
						$("#f_mail_msg").text("邮箱不存在");
//						ok = false;
						return;
					}
				}
		);
		}
	});
	$("#f_gain").click(function(){
		var mail = $("#f_mail").val();
		if(mail == ""|| mail ==null){
			$("#f_mail_msg").html("请填写邮箱后再发送");
			return;
		}
//		当用户点击发送验证码时候
		$.post(base_path+"/forget/sendCode.do",
				{"email":mail,"subject":"众筹系统找回密码：","code":6},
				function(result){
//					后台返回数据
					var createcode = result.data;
//					alert(createcode);
//					设置有限期限10分钟
					addCookie("sjm",createcode,0.1);
		}
		);
	});
	$("#f_code").blur(function(){
//			获取用户输入的code
			var code = $("#f_code").val();
			var createcode = getCookie("sjm");
			$("#f_code_msg").text("");
			if(code==""||code == null){
//				ok = false;
				$("#f_code_msg").text("请输入随机码(有效时间一分钟)");
				return;
			}else{
			if(code != createcode){
				$("#f_code_msg").text("验证码输入错误");
//				ok = false;
				return;
			}else{
				$("#f_code_msg").text("");
			}
		}
	});
	$("#new_pwd").blur(function(){
//		用户输入的新密码
		var newpwd = $("#new_pwd").val();
		$("#new_pwd_msg").text("");
		if(newpwd==""|| newpwd==null){
//			ok = false;
			$("#new_pwd_msg").text("密码为空");
			return;
		}else if(newpwd.length<6){
//			ok = false;
			$("#new_pwd_msg").text("密码至少为6位");
			return;
		}else{
			$("#new_pwd_msg").text("");
		}
	});
	 $("#sure_new_pwd").blur(function(){
//			获取确认密码
			var surepwd = $("#sure_new_pwd").val();
			var newpwd = $("#new_pwd").val();
		 if(surepwd == ""||surepwd == null){
//			 ok = false;
			 $("#sure_new_pwd_msg").text("确认密码为空");
			 return;
		 }else if(newpwd != surepwd){
//			 ok = false;
			 $("#sure_new_pwd_msg").text("密码不一致");
			 return;
		 }else{
			 $("#sure_new_pwd_msg").text("");
		 }
	 });
//	 前面的一切都正确的前提再向数据库发送请求
	 $("#forgetbtn").click(function(){
		 var mail = $("#f_mail").val();
		 var code = $("#f_code").val();
		 var newpwd = $("#new_pwd").val();
		 if(mail == null|| mail == ""){
			 $("#f_mail_msg").html("邮箱为空");
			 return;
		 }else if(code == ""||code == null){
			 $("#f_code_msg").text("验证码发送失败");
			 return;
		 }else if(newpwd==""||newpwd == null){
			 $("#new_pwd_msg").text("密码为空");
			 return;
		 }
		 $.ajax({
			 url:base_path+"/forget/commit.do",
			 type:"post",
			 data:{"email":mail,"code":code,"newpwd":newpwd},
			 dataType:"json",
			 success:function(result){
				 if(result.status == 0 ){
//					 alert(result.msg);
					 window.location.href = "login.html";
				 }else{
					 alert(result.msg);
				 }
			 },
			 error:function(){
				 alert("修改异常");
			 }
		 });
	 });
};
//下面代码意思是睡眠指定时间后再运行下面代码
function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}