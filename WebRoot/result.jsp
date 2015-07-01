<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String[] descContent = (String[])request.getAttribute("descContent");
	int i = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta name="keywords" content="���ӿƼ���ѧ��Ƥ����������ϵͳ">
	<meta name="/x.copyright" content="��Ȩ����ӿƼ���ѧ�������о���������">
	<meta name="description" content="���ӿƼ���ѧƤ����������ϵͳ��ҳ">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>�������</title>
	<link rel="shortcut icon" href="images/home/head.ico"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/result.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/jquery.circliful.min.js"></script>
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
  <br><br>

  <div class="container">
    <div align="center"><a href="<%=basePath %>home"><img src="images/result/logo.png" alt="Ƥ�����������ϵͳ" id="resultlogo"/></a></div>
    <div class="row">
       <div class="col-sm-4 col-md-4 col-lg-3">
        <p id="resulttext">���ϴ���ͼƬ���ü�����</p>
      </div>
      <div class="col-sm-3 col-md-4 col-lg-3">
        <a href="#" rel="<%=basePath%>${cropServerPath }" class="preview"><img id="imglist" class="img-rounded" src="<%=basePath%>${cropServerPath }" alt="ԭͼ��"/></a>
      </div>
    </div>   

    <br><br>
      <div class="line"></div>
    <br><br>
    <div>
       <p>�������:</p>
    </div>
    <section id="resultline">
	<c:forEach items="${resultList}" var="result">
		<div class="resultblock">
			<a href="<%=basePath %>servlet/detailServlet?diseaseId=${result.imageStrc.disease.id}&imgUrl=${result.cropImgUrl }" target="_blank"><img class="resultimg" src="${result.cropImgUrl }" alt="�������"/></a>
      		<h4>${result.imageStrc.disease.name }</h4>
      		<p class="resultinfor"><%=descContent[i++] %></p><hr>
      		<table class="simtable">
      			<tr>
      				<td><span class="simspan">���ƶȣ�</span></td>
      				<td>
      					<div style="text-align:center" class="resultdata">
        					<div id="myStat" data-dimension="50" data-text="${result.similarity }%" data-info="New Clients"  
      							data-width="6" data-fontsize="6" data-percent="${result.similarity }" data-fgcolor="#359c7e"  
      							data-bgcolor="#eee" data-fill="#ddd" style="margin:0 auto">
        					</div> 
      					</div>
 					</td>
 				</tr>
 			</table>
    	</div>
	</c:forEach>
    </section>
    <br/>
    <!--<a href="#" id="loadmore">���ظ�����</a>  -->

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

</body>
</html>