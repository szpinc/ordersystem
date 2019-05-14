//页面加载完毕执行下面代码
window.onload = function(){
	var check_mail_or_phone = true;
	$("#mail_or_phone").blur(function(){
//		获取用户注册输入的邮箱或者手机号码
		var mail_or_phone = $("#mail_or_phone").val().trim();
		$("#mail_or_phone_msg").html("");
//		手机号码格式限制
		var reg1 = /^1[3578]\d{9}$/;
//		邮箱格式限制
		var reg2 = /^([0-9a-zA-Z])+\@([a-zA-Z0-9])+\.([a-zA-Z])+$/;
//		检查格式
		if(mail_or_phone == ""|| mail_or_phone == null){
			check_mail_or_phone = false;
//			mail_or_phone_msg.innerHTML= "邮箱或者手机号码不能为空";
			$("#mail_or_phone_msg").html("邮箱或者手机号码不能为空");
		}else if(!reg1.test(mail_or_phone)&&!reg2.test(mail_or_phone)){
			check_mail_or_phone = false;
//			mail_or_phone_msg.innerHTML= "手机号码或者邮箱格式错误";
			$("#mail_or_phone_msg").html("手机号码或者邮箱格式错误");
		}
		if(check_mail_or_phone){
//		格式正确后向后端发送数据，进行二次检查
		var params={"mailOrPhone":mail_or_phone};
		$.post(base_path+"/user/checkMailOrPhone.do",params,function(result){
			if(result.status==0){
				check_mail_or_phone = true;
//				mail_or_phone_msg.innerHTML = result.msg;
				$("#mail_or_phone_msg").html(result.msg);
			}else{
				check_mail_or_phone = false;
//				mail_or_phone_msg.innerHTML = result.msg;
				$("#mail_or_phone_msg").html(result.msg);
			}
		});
		}
	});
	//检查用户名是否被占用
	var check_user_name = true;
	$("#user_name").blur(function(){
//		获取用户填写的信息
		var user_name = $("#user_name").val();
		$("#user_name_msg").text("");
		if(user_name == ""||user_name == null){
			check_user_name = false;
//			user_name_msg.innerHTML = "用户名不能为空";
			$("#user_name_msg").text("用户名不能为空");
		}
		if(check_user_name){
		$.post(base_path+"/user/checkUser_name.do", 
				{"user_name":user_name},
				function(result){
			if(result.status == 0){
				check_user_name = true;
//				user_name_msg.innerHTML = result.msg;
				$("#user_name_msg").text(result.msg);
			}else{
				check_user_name = false;
//				user_name_msg.innerHTML = result.msg;
				$("#user_name_msg").text(result.msg);
			}
		});
		}
	});
	//对密码和确认密码进行操作
	var check_sure_password = true;
	$("#sure_password").blur(function(){
		var user_password = $("#user_password").val().trim();
		var sure_password = $("#sure_password").val().trim();
		$("#sure_passowrd_msg").html("");
		if(user_password != sure_password){
			check_sure_password = false;
//			sure_password_msg.innerHTML = "密码不一致";
			$("#sure_passowrd_msg").html("密码不一致");
		}
	});
	//当点击注册时候进行的操作
	var verifyCode = new GVerify("v_container");
	$("#regist").click(function(){
	var code = $("#auth_code").val().trim();
	var mail_or_phone = $("#mail_or_phone").val().trim();
	var user_name = $("#user_name").val().trim();
	var user_password = $("#user_password").val().trim();
	if(check_mail_or_phone&&check_user_name&&check_sure_password&&verifyCode.validate(code)){
		$.ajax({
			url:base_path+"/user/regist.do",
			type:"post",
			data:{"mailOrPhone":mail_or_phone,"user_name":user_name,"user_password":user_password},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					window.location.href = "login.html";
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("注册异常");
			}
		});
	}
	});
}