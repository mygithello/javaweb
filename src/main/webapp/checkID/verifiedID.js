// JavaScript Document
var aCity = {
	11 : "北京",
	12 : "天津",
	13 : "河北",
	14 : "山西",
	15 : "内蒙古",
	21 : "辽宁",
	22 : "吉林",
	23 : "黑龙江 ",
	31 : "上海",
	32 : "江苏",
	33 : "浙江",
	34 : "安徽",
	35 : "福建",
	36 : "江西",
	37 : "山东",
	41 : "河南",
	42 : "湖北 ",
	43 : "湖南",
	44 : "广东",
	45 : "广西",
	46 : "海南",
	50 : "重庆",
	51 : "四川",
	52 : "贵州",
	53 : "云南",
	54 : "西藏 ",
	61 : "陕西",
	62 : "甘肃",
	63 : "青海",
	64 : "宁夏",
	65 : "新疆",
	71 : "台湾",
	81 : "香港",
	82 : "澳门",
	91 : "国外 "
};

function cidInfo(sId) {
	alert("进入身份证验证，点击确定即刻开始验证");
	var sId = sId.value;
	alert(sId);
	var iSum = 0;
	var info = "";
	
	//校验17位数字+X或者x   或者是18位数字	
	if (!/^\d{17}(\d|x|X)$/.test(sId)) {
		alert("身份证输入不正确");
		return false;
	}
	
	//取前两位校验省份
	sId = sId.replace(/x$/i, "a");//把x替换成a
	//alert(sId+"replace");
	if (aCity[parseInt(sId.substr(0, 2))] == null) {
		alert("非法省份");

		return "Error:非法省份";
	}
	
	//取7-14位校验生日
	sBirthday = sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-"
			+ Number(sId.substr(12, 2));
	//sBirthday中的-替换成/，以/为格式的字符串，才能够构建成Date对象
	//在这里，如果sBirthday=1984-18-20,构建出来的d是1985年6月20日
	var d = new Date(sBirthday.replace(/-/g, "/"));
	alert(d+"DDDDDDD");
	if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d
			.getDate())) {
		alert("非法生日");
		return "Error:非法生日";
	}
	
	//通过for循环，取出每一位数字，计算最后的校验位
	for ( var i = 17; i >= 0; i--) {
		iSum += (Math.pow(2, i) % 11) * parseInt(sId.charAt(17 - i), 11);
	}
	if (iSum % 11 != 1) {
		alert("非法验证码");
		return "Error:非法证号";
	}
	
	//取倒数第二位校验性别
	alert("性别："+(sId.substr(16, 1) % 2 ? "男" : "女"));
	
	//可以取身份证上倒数第二位，跟选择的性别比较，在此处return没有用到
	return aCity[parseInt(sId.substr(0, 2))] + "," + sBirthday + ","
			+ (sId.substr(16, 1) % 2 ? "男" : "女");
}
