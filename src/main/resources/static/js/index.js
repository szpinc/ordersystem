$(function(){
	//登录成功之后首先获取cookie，进行判断
	//获取用户登录后保存的cookie值
	var username = getCookie("u_user_username");
	//判断cookie是否为空
	//为空则header上面显示登录样式
	if(username == "" ||username == null){
		$("#change").html("登录");
		$("#change1").html("注册");
		//当为登录样式情况下
		//用户点击下跳转到登录按钮
		$("#change").click(function(){
			window.location.href = "login.html";
		});
		$("#change1").click(function(){
			window.location.href = "reg.html";
		});
		return;
	}
	//如果cookie不为空则显示用户名和退出样式
	$("#change").html(username);
	$("#change1").html("退出");
	$("#change").click(function(){
		window.location.href = "user.html";
	});
	$("#change1").click(function(){
		//当点击退出之后消除cookie值
		delCookie("u_user_username");
		//让页面再次跳转到index.html,起到页面刷新的结果
		window.location.href = "index.html";
	});
	
//	页面信息追加
	
});