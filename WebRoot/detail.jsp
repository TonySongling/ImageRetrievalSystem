<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String[] similarImgUrls = (String[])request.getAttribute("similarImgUrls");
	String imgUrl = (String)request.getAttribute("imgUrl");
%>

<!doctype html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta name="keywords" content="���ӿƼ���ѧ��Ƥ����������ϵͳ">
		<meta name="/x.copyright" content="��Ȩ����ӿƼ���ѧ�������о���������">
		<meta name="description" content="���ӿƼ���ѧƤ����������ϵͳ��ҳ">

		<title>������ϸ</title>
		<link rel="shortcut icon" href="images/home/head.ico" />
		<link rel="stylesheet" href="css/detail2.css">
		<script type="text/javascript" src="js/sandbox/jquery/jquery-1.8.3.min.js"></script>
		<!--�ص�����js����-->
		<script type="text/javascript">
    		$(function(){
    	        var bot1=document.getElementById("form_top");
        		var bot2=document.getElementById("float_catalog");
        	$(window).scroll(function(){
        		var y=document.body.scrollHeight-document.documentElement.clientHeight-198;
        		if($(window).scrollTop()>=y){
        			var s=$(window).scrollTop()-y;
        			bot1.style.bottom=24+s+"px";
        			bot2.style.bottom=90+s+"px";
        		}
        		else{
        			bot1.style.bottom="24px";
        			bot2.style.bottom="90px";
        		}
            	if($(window).scrollTop()> 100){
                	$("#form_top").fadeIn(500);//���뽥�붯��
                	$("#float_catalog").fadeIn(500);
            	}else{
                	$("#form_top").fadeOut(500);//���뽥������
                	$("#float_catalog").fadeOut(500);
            	}
        	});
         
	        $("#form_top").click(function(){
	            $('body,html').animate({scrollTop:0},500);
	        });
    });
		</script>
	</head>

	<body>
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
		<div id="con">
			<!--�����Ƕ����б���ʾ-->
				<dl>
  					<dt>${disease.name }</dt>
  					<img src="<%=imgUrl %>" alt="${disease.name }" id="dermimg1" />
    			</dl>
			<table id="catalog">
				<td rowspan="8">Ŀ¼</td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('desc').scrollIntoView();" class="list-con">1&nbsp;�������</a></td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('symptom').scrollIntoView();" class="list-con">2&nbsp;����֢״</a></td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('etiology').scrollIntoView();" class="list-con">3&nbsp;����ԭ��</a></td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('prevent').scrollIntoView();" class="list-con">4&nbsp;Ԥ��</a></td>
  				</tr>
  				<tr>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('identify').scrollIntoView();" class="list-con">5&nbsp;����</a></td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('therapies').scrollIntoView();" class="list-con">6&nbsp;���Ʒ���</a></td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('complication').scrollIntoView();" class="list-con">7&nbsp;����֢</a></td>
  				<td><a href="javascript:void(0)" onclick="document.getElementById('imgs').scrollIntoView();" class="list-con">8&nbsp;������Ƭ</a></td>
			</table>
			<div class="line"></div>
			<section>
				<a id="desc">�������</a>
					${disease.desc }
				<div class="line"></div>
			</section>
			<section>
				<a id="symptom">����֢״</a>
					${disease.symptom }
				<div class="line"></div>
			</section>
			<section>
				<a id="etiology">����ԭ��</a>
					${disease.etiology }
				<div class="line"></div>
			</section>
			<section>
				<a id="prevent">Ԥ��</a>
					${disease.prevent }
				<div class="line"></div>
			</section>
			<section>
				<a id="identify">����</a>
					${disease.identify }
				<div class="line"></div>
			</section>
			<section>
				<a id="therapies">���Ʒ���</a>
					${disease.therapies }
				<div class="line"></div>
			</section>
			<section>
				<a id="complication">����֢</a>
					${disease.complication }
				<div class="line"></div>
			</section>
			<section>
				<a id="imgs">������Ƭ</a>
				<br/>
				<div id="photos">
					<c:forEach items="<%=similarImgUrls %>" var="similarImgUrl">
	  					<img src="${similarImgUrl }" alt="����ͼƬ" class="dermimg2" />
	  				</c:forEach>
	  			</div>
			</section>
		</div>

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
    <div id="float_catalog">
    	<ul>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('desc').scrollIntoView();" class="list-con">1&nbsp;�������</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('symptom').scrollIntoView();" class="list-con">2&nbsp;����֢״</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('etiology').scrollIntoView();" class="list-con">3&nbsp;����ԭ��</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('prevent').scrollIntoView();" class="list-con">4&nbsp;Ԥ��</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('identify').scrollIntoView();" class="list-con">5&nbsp;����</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('therapies').scrollIntoView();" class="list-con">6&nbsp;���Ʒ���</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('complication').scrollIntoView();" class="list-con">7&nbsp;����֢</a></li>
    		<li><a href="javascript:void(0)" onclick="document.getElementById('imgs').scrollIntoView();" class="list-con">8&nbsp;������Ƭ</a></li>
		</ul>
    </div>
    <div id="form_top"></div>
	</body> 
</html>
