<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String[] urlArr = (String[])request.getAttribute("imagesUrlArr");
%>

<!doctype html>
<html>
	<head>
	<base href="<%=basePath %>">
		<meta name="keywords" content="���ӿƼ���ѧ��Ƥ����������ϵͳ">
		<meta name="/x.copyright" content="��Ȩ����ӿƼ���ѧ�������о���������">
		<meta name="description" content="���ӿƼ���ѧƤ����������ϵͳ��ҳ">

		<title>���ӿƼ���ѧƤ����������ϵͳ</title>
		<link rel="shortcut icon" href="images/home/head.ico" />
		<link rel="stylesheet" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/sudy-slider.css">
		<link rel="stylesheet" type="text/css" href="css/jquery.Jcrop.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-labelauty.css">
		<link rel="stylesheet" type="text/css" href="css/premage.min.css">
		<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
		
		<script type="text/javascript"
			src="js/sandbox/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/sandbox/jquery/jquery.sudySlider.m.js"></script>
		<script type="text/javascript" src="js/jquery.Jcrop.js"></script>
		<script type="text/javascript" src="js/jquery-labelauty.js"></script>
		<script type="text/javascript" src="js/homePageJS.js"></script>
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/premage.min.js"></script>
		<script type="text/javascript">
			var imgs = [
				<%for(int i = 0; i < urlArr.length; i++){ %>
				{
				    title:"ͼƬʾ��",
					src:'<%=urlArr[i] %>'
				},
				<%} %>
			];
			function validateForm(form){
				var val = $('input:radio[name="positionFlag"]:checked').val();
				if(val == null){
					alert("��ѡ�񲡱䲿λ");
					return false;
				}else{
					var webh=document.body.scrollHeight;
					Id('waitingbox').style.display="block";
					Id("waitingbox").style.height=webh+"px";
					return true;
				}
			}
		</script>
	</head>

	<body>
		<!--ҳ��ȴ�����-->
		<div id="waitingbox">
			<div id="waiting">
				<img src="images/waiting.jpg" width="50px" height="50px" id="loadpage" alt="ҳ�������..." />
			</div>
		</div>
		<!--ҳ�׿�ʼ-->
		<header>
		<img src="images/home/uestc2.png" alt="���ӿƼ���ѧ" id="uestclogo" />
		<nav id="headernav">
		<ul>
			<li>
				<a>�ͻ�������</a>
			</li>
			<li>
				<a>��ϵ����</a>
			</li>
		</ul>
		</nav>
		<div class="line"></div>
		</header>

		<!--���ݿ�ʼ-->
		<form action="<%=basePath %>servlet/searchServlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm(this)">
			<div id="con">
				<section id="upimgsec">
				<img src="images/home/title2.png" alt="Ƥ�����������ϵͳ��������ߵĽ���ר��"
					id="titleimg" />
				<input type="button" value="�ϴ�ͼƬ" onclick="path.click()"
					id="imgchoose" />
				<input type="file" id="path" name="path" onchange="showfileinfo(this.value);"
					accept="image/*" />
				<input type="text" disabled='disabled' size="20" name="upfile"
					id="upfile" />
				<input type="button" value="�ύ" id="subimg" onclick="setImgPath()"/>

				<!--�ü���Ƭ��ʼ-->
				<div id="darkclo">
					<section id='cutfilesec'>
					<input type="button" value="x" id="closeclo" />
					<div id="cutzone">
						<p>
							��ü�����������Ϊ��ʹ������Ӿ�ȷ����ʹ��������λ�����м䣩
						</p>
						<div id="cutimgbox">
							<div class="cutImg">
								<img id="targetimg" alt="�ϴ���ͼƬ" onload="autoResize();" src=null/>
							</div>
							<div>
								<!-- ��¼��ʾͼƬ�Ŀ�͸�-->
								<input type="hidden" id="imgWidth" name="imgWidth">
								<input type="hidden" id="imgHeight" name="imgHeight"/>
							</div>
							<div id="coords" class="coords">
								<!-- This is the form that our event handler fills -->
								<input type="hidden" id="x1" name="x1" />
								<input type="hidden" id="y1" name="y1" />
								<input type="hidden" id="x2" name="x2" />
								<input type="hidden" id="y2" name="y2" />
								<input type="hidden" id="w" name="w" />
								<input type="hidden" id="h" name="h" />
							</div>
							<section id='selbut'>
							<h4>
								��λ�궨
							</h4>
							<ul class="dowebok">
								<li>
									<input type="radio" name="positionFlag" data-labelauty="ͷ��" value="0"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="����" value="1"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="����" value="2"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="��֫" value="3"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="�ֲ�" value="4"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="�ز�" value="5"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="����" value="6"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="����" value="7"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="����" value="8"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="�β�" value="9"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="��ֳ��" value="10"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="��֫" value="11"/>
								</li>
								<li>
									<input type="radio" name="positionFlag" data-labelauty="�㲿" value="12"/>
								</li>
							</ul>
							</section>
						</div>
					</div>
					<div id="preview-pane">
						<div class="preview-container">
							<img class="jcrop-preview" alt="Preview" id="preview" src=null />
						</div>
					</div>
					<input id="imgsubmit" type="submit" value="�ύ"/>
					</section>
				</div>
				</section>
				<br />
				<section id="imgslisec">
					<div class="line"></div>
					<div id="slider"></div>
				</section>
			</div>
		</form>
		<!--ҳβ��ʼ-->
		<footer>
		<section>
		<h4>
			��������
		</h4>
		<nav>
		<ul>
			<li>
				<a href="#">���ӿƼ���ѧ</a>
			</li>
			<li>
				<strong>��</strong>
			</li>
			<li>
				<a href="#">�������о�����</a>
			</li>
		</ul>
		</nav>
		</section>
		<section id='small'>
		<small>��Ȩ���У����ӿƼ���ѧ�������о�����<br />��ַ���ɶ��и���������������Դ���2006����¥<br />
		</small>
		<pre>
			<small>�绰��4006472998   ���棺0472-2885356   ���䣺bjqchkj@163.com</small>
		</pre>
		</section>
		</footer>
		<script type="text/javascript">
		//���safari�����Ե������Ԫ�ض�����ע�ⲻҪ�Ƶ�����js�ļ��У�
    window.onload=function(){
    	myBrowser();
  	}
  function myBrowser(){
    var userAgent = navigator.userAgent; //ȡ���������userAgent�ַ���
    var isOpera = userAgent.indexOf("Opera") > -1;
	    if (isOpera) {
        	return "Opera"
    	}; //�ж��Ƿ�Opera�����
    	if (userAgent.indexOf("Firefox") > -1) {
        	return "FF";
    	} //�ж��Ƿ�Firefox�����
	    if (userAgent.indexOf("Chrome") > -1){
  	return "Chrome";
 	}
    	if (userAgent.indexOf("Safari") > -1) {
        	return "Safari";
    	} //�ж��Ƿ�Safari�����
	    if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
        	return "IE";
    	}; //�ж��Ƿ�IE�����
	}
	//�����ǵ�������ĺ���
	var mb = myBrowser();
	if ("Safari" == mb) {
  	document.getElementById('path').style.display="inline";
  	document.getElementById('path').style.visibility="hidden";
  	document.getElementById('upfile').style.display='none';
	}
		</script>
	</body>
</html>