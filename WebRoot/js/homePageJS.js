//�ֲ�ͼƬ
$(function(){
		$("#slider").sudySlider();
});
//JropͼƬ�ü����
var bflag;var initflag=0;
jQuery(function($){
  var jcrop_api;
  var $preview,
      $pcnt,
      $pimg;
  var boundx,boundy,

      // Grab some information about the preview pane
      
      xsize,
      ysize;
function imagecutjrop(){
  // Create variables (in this scope) to hold the API and image size
  console.log('init',[xsize,ysize]);
  $('#targetimg').Jcrop(
  {
    minSize: [100,100],
    onChange: updatePreview,
    onSelect: updatePreview,
    onRelease: clearCoords,
    bgFade:true,
    bgOpacity: .4,
    //setSelect: [ 50, 50, 200, 200 ],
    drawBorders: false,
    aspectRatio: 1,
    allowSelect: false
  },function() {
    jcrop_api = this;
    var img = new Image(); 
    img.src =$('#targetimg').attr("src") ; 
    var imgWidth = img.width;
    var imgHeight = img.height;
    var w_03=imgWidth*0.33;
    var w_06=imgWidth*0.66;
    var hw=(imgHeight-w_06+w_03)/2;
    var hw2=hw+w_06-w_03;
    jcrop_api.setSelect([ w_03, hw, w_06, hw2 ]);
    startbound(this);
  });

  $preview = $('#preview-pane'),
  $pcnt = $('#preview-pane .preview-container'),
  $pimg = $('#preview-pane .preview-container img');
  xsize = $pcnt.width(),
  ysize = $pcnt.height();
}
  function startbound(tar){
    // Use the API to get the real image size
    var bounds = tar.getWidgetSize();
    bflag=tar.getWidgetSize();
    boundx = bounds[0];
    boundy = bounds[1];
    // Store the API in the jcrop_api variable
    // Move the preview into the jcrop container for css positioning
    $preview.appendTo(jcrop_api.ui.holder);
  }

  function updatePreview(c)
  {
    if (parseInt(c.w) > 0)
    {
      var rx = xsize / c.w;
      var ry = ysize / c.h;
      var targetimgwidth=Id('targetimg').width;
      boundx=targetimgwidth;boundy=targetimgwidth/targetimgpro;
      $pimg.css({
        width: Math.round(rx * boundx) + 'px',
        height: Math.round(ry * boundy) + 'px',
        marginLeft: '-' + Math.round(rx * c.x) + 'px',
        marginTop: '-' + Math.round(ry * c.y) + 'px'
      });
      $('#x1').val(c.x);
	  	$('#y1').val(c.y);
	  	$('#x2').val(c.x2);
	  	$('#y2').val(c.y2);
	  	$('#w').val(c.w);
	  	$('#h').val(c.h);
      var obj = document.getElementById("targetimg");
      var style = null;
      if (window.getComputedStyle) {
          style = window.getComputedStyle(obj, null);    // ����IE
      } else { 
          style = obj.currentStyle;  // IE
      }
      var nw=parseInt(style.width);
      var nh=parseInt(style.height);
      var profobj=nw/nh;
      if(profobj < 0.8){nh=500;nw=500*profobj;}else{nw=500;nh=500/profobj;}
      $('#imgWidth').val(nw);
      $('#imgHeight').val(nh);
    }
    initflag++;
    if (initflag==4&&changepathflag==0) {
      initit();
    };
  };
  var img,imgHeight,imgWidth,w_03,w_06,hw,hw2;
  function initit(){
      img = new Image();
      img.src =$('#targetimg').attr("src") ;
      imgWidth = img.width;
      imgHeight = img.height;
      w_03=imgWidth*0.33;
      w_06=imgWidth*0.66;
      hw=(imgHeight-w_06+w_03)/2;
      hw2=hw+w_06-w_03;
      jcrop_api.setSelect([ w_03, hw, w_06, hw2 ]);
  }
	// Simple event handler, called from onChange and onSelect
	// event handlers, as per the Jcrop invocation above  
	function clearCoords(){
	  $('#coords input').val('');
	};
  var changepathflag=1;
  $('#subimg').click(function(e) {
    var nullimg=true;
    nullimg=imgcut();
    if (!nullimg) return;
    var imgrealsize;
    var imgpath;
    //������ε��δ��Ӧ����
    if (changepathflag==1) {imgrealw=Id("targetimg").width;imgrealh=Id("targetimg").height;};
    if(changepathflag==1){
      Id("targetimg").style.width=imgrealw;
      Id("targetimg").style.height=imgrealh;
    }
    imagecutjrop();
    $("#darkclo").fadeIn('normal');
    var webh=document.body.scrollHeight;
    Id("darkclo").style.height=webh+"px";
    if (changepathflag==0) {
      imgpath= getFileUrl("path");
      preImg("path","targetimg");
      autoResize();
      preImg("path","preview");
      jcrop_api.setImage(imgpath);
      jcrop_api.setOptions({minSize: [100,100]});
    };
    if (changepathflag==0) {initflag=1;
      /*var img = new Image();
      img.src =$('#targetdow').attr("src") ;
      var imgWidth = img.width;
      var imgHeight = img.height;
      var w_03=imgWidth*0.33;
      var w_06=imgWidth*0.66;
      var hw=(imgHeight-w_06+w_03)/2;
      var hw2=hw+w_06-w_03;
      jcrop_api.setSelect([ w_03, hw, w_06, hw2 ]);*/
      jcrop_api.setSelect([0,0,0,0]);
    };
  });

  $('#closeclo').click(function(e) {
    $("#darkclo").hide();
    changepathflag=0;
    jcrop_api.destroy();
  });

function imgcut(){
  var upfileinput=document.getElementById('path').value;
    if(upfileinput==''){alert('����û��ѡ���κ�ͼƬӴ');return false;}
    
  var file = document.getElementById("path");
  if(file.value==''){
      //����Ĭ��ͼƬ
      alert("����û��ѡ���κ�ͼƬӴ");
      document.getElementById("targetimg").src="images/text.png";
      document.getElementById("preview").src="images/text.png";
  }else{
      if (changepathflag==1){preImg("path","targetimg");
      preImg("path","preview");}
  }return true;
  }
  //��ȡinput[file]ͼƬ��url Important
function getFileUrl(fileId) { 
  var url; 
  var file = document.getElementById(fileId);
  var agent = navigator.userAgent;
  if (agent.indexOf("MSIE")>=1) {
    url = file.value; 
  } else if(agent.indexOf("Firefox")>0) { 
    url = window.URL.createObjectURL(file.files.item(0)); 
  } else if(agent.indexOf("Chrome")>0) {
    url = window.URL.createObjectURL(file.files.item(0)); 
  } 
  return url; 
  } 
  //��ȡͼƬ��Ԥ��
function preImg(fileId,imgId) { 
  var imgPre =document.getElementById(imgId);
  imgPre.src = getFileUrl(fileId);
}
});


//��λѡ��
$(function(){
	  $(':input').labelauty();
});

//����idѡ����
function Id(id){
	return document.getElementById(id);
}

function showfileinfo(pvalue){
    var pfilename=pvalue.toString();
    if(pfilename!=null){
      if(pfilename.substr(3,8)=='fakepath'){    //for chrome&opera
      	document.getElementById('upfile').value=pfilename.slice(12);
      }else{
          document.getElementById('upfile').value=pfilename;
      }
      document.getElementById('imgchoose').value="����ͼƬ";
      $("#imgchoose").animate({right:'210px',width:'120px'});
      $("#upfile").fadeIn('normal');
      $("#subimg").fadeIn('normal');
      $("#subimg").animate({left:'210px',opacity:'1'});
      if ("Safari" == mb) {
    	  $("#upfile").animate({right:'210px',opacity:'1'});
      };
    }

    document.all.subimg.focus();
}

var targetimgpro;
function autoResize(){
	var img = document.getElementById('targetimg');
  var jcropholder=Id('jcropholder');
	var img = new Image();
	img.src = $('#targetimg').attr("src");
	var w = img.width;
	var h = img.height;
  targetimgpro=w/h;
}
// �ļ����ͼ��
    // �ļ��ϴ��ļ�ѡ����¼�
   $(document).ready(function() {
    $("input[id^='path']").each(
  // ����������each��Ϊ�Ƕ��ļ��ϴ���input��id����fileToUpload ��ͷ
      function() {
   $("#" + $(this).attr("id") + "").live('change',function() {
   var fileName = $(this).val();
   if (fileName != null&& fileName != "") {
    // lastIndexOf���û���������򷵻�Ϊ-1
    if (fileName.lastIndexOf(".") != -1) {
     var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1,
    fileName.length)).toLowerCase();
     var suppotFile = new Array();
     suppotFile[0] = "jpg";
     suppotFile[1] = "gif";
     suppotFile[2] = "bmp";
     suppotFile[3] = "png";
     suppotFile[4] = "jpeg";
     for ( var i = 0; i < suppotFile.length; i++) {
      if (suppotFile[i] == fileType) {
  if (fileName.length > 100) {
   alert("�ļ������Ȳ��ܳ���100�ַ�");
   if (!window.addEventListener) {      
      document.getElementById(fileName[j]).outerHTML+='';  // IE���inputfile
      }else { 
       document.getElementById(fileName[j]).value = "";   // FF���inputfile
      } 
   return false;
  }
  return true;
   } else {
  continue;
   }
   }
    alert("�ļ����Ͳ��Ϸ�,ֻ֧�� jpg��gif��png��jpeg���ͣ�");
      if (!window.addEventListener) {
      document.getElementById('upfile').value='';      
      document.getElementById(fileName[j]).outerHTML+='';  // IE
      }else { 
        document.getElementById('upfile').value='';
       document.getElementById(fileName[j]).value = "";   // FF
      } 
     return false;
    } else {
     alert("�ļ����Ͳ��Ϸ�,ֻ֧�� jpg��gif��png��jpeg���ͣ�");
      if (!window.addEventListener) {   
      document.getElementById('upfile').value='';   
      document.getElementById(fileName[j]).outerHTML+='';  // IE
      }else { 
        document.getElementById('upfile').value='';
       document.getElementById(fileName[j]).value = "";   // FF
      } 
     return false;
    }
   }
  });
  });
  });
