//页面加载时候加载此login.js
$(function(){
//	调用验证码id，然后在页面映射出验证码视图
//	用户点击登录按钮时候，触发时间
	$("#login_btn").click(checkLogin);
});

function checkLogin(){
//	获取参数
	var userName = $("#userName").val();
	var password = $("#password").val().trim();
	alert(password);
	$("#userName_msg").html("");
	$("#password_msg").html("");
//	检查格式
	ok = true;
	if(userName == ""){
		ok = false;
		$("#useName_msg").html("用户名不能为空");
	}
	if(password == ""){
		ok = false;
		$("#password_msg").html("密码不能为空");
	}
	if(ok){
		$.ajax({
			url:base_path+"/customer/login.do",
			type:"post",
			data:{"us_email":u_mail_phone,"u_pwd":u_pwd},
			dataType:"json",
			success:function(result){
				var s = result.data;
				if(result.status == 0){
					addCookie("u_user_username",s.us_name,2);
					addCookie("u_user_email",s.us_email,2);
					addCookie("u_user_password",s.us_password,2);
					window.location.href = "index.html";
				}else if(result.status==1){
					$("#mailorphone_msg").html(result.msg);
				}else if(result.status==2){
					$("#pwd_msg").html(result.msg);
				}
			},
			error:function(){
				alert("登录异常");
			}
		});
	}
}