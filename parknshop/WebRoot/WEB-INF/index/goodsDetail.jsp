<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>PARKn Shopping</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

		<link href='http://fonts.googleapis.com/css?family=Sintony:700,400&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" typ="text/css" href="./Data/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="./Data/css/comment.css"/>
		<link rel="stylesheet" type="text/css" href="./Data/css/home.css"/>
        <link rel="stylesheet" type="text/css" href="./Data/css/shopping.css"/>
    </head>
    
    
    <body>
    <div id="da">
    	<div id="top">
			<div class="topList">
				<div class="tUserName tleft"><span>Hi </span><a>UserName</a></div>
				<div class="tLoginRegist tleft"><a>Logout</a><span> </span><a>Regist</a></div>
				<div class="tMyOrder tleft"><a>MyOrderList</a></div>
				<div class="tFavor tleft"><a>FavoriteSite</a></div>
				<!--
                	作者：1099163058@qq.com
                	时间：2014-11-22
                	描述：该部分向右浮动，最右边的要往前靠
                -->
				<div class="tWeixin tReft"><a>aa<img /></a></div>
				<div class="tWeibo tReft"><a>aa<img /></a></div>
				<div class="tPARKnApp tReft">
					<a>PARKnApp</a>
					<a>
						<img />
					</a>
				</div>
				<div class="tNotice tReft">
					<a>Notice</a>
					<ul class="tUlFloat">
						<li>* Site Notice</li>
						<li>* Important Notice</li>
					</ul>			
				</div>
				<div class="tHelp tReft">
					<a>Help</a>
					<ul class="tUlFloat">
						<li>GuideBook</li>
						<li>Distribution</li>
					</ul>
				</div>
				<div class="tMyPARKn tReft">
					<a>MyPARKn</a>
					<ul class="tUlFloat" style="display: block;">
						<li>*Cart</li>
						<li>*Orders</li>
					</ul>
				</div>
				<div class="tShopOwer tReft" >
					<a>ShopOwer</a>
					<ul class="tUlFloat" ">
						<li>* IWannaSetUpShop</li>
						<li>* GoodsSold</li>
						<li>* GoodsOn Sole</li>
					</ul>
				</div>
			</div>
		</div>
        <!--
        
        上面是最上面的一条，接下来是主题的内托荣 -->
        
        
        <div class="nav">
        	img
        </div>
        <div class="search">
					<input class="input" type="text" />
					<input type="submit" class="submit" value="search" />
	</div>
                
         <!--文字标签1 -->
         <div class="letter1">
         		文字标1
         </div>
         <!--文字标2-->
         <div class="letter2">
         	文字标2
         </div>
         
         <!-- 小图片   -->
         <div class="Spictrue">
         	小图片
         </div>
         
         <!--导航菜单目录-->
         
         <div class="goods">
         	All good
         	
         </div>
         <div class="Shome">
         	Shop home	
         </div>
         <div class="deal">
         	Shop deal	
         </div>
 		<div class="fresh">
         	Today fresh	
    </div>
         <!--小图片二-->
         <div class="sp2">
         	img
    </div>
    <div class="bletter">
    
    	My sd
    </div>
    <div class="bimg">
    
    	big img
    </div>
    <div class="N1">  
    	Home
    </div>
    <div class="N2">  
    	Shopname
    </div>
    <div class="N3">  
    	Goodtype
    </div>
    <div class="N4">  
    	Goodname
    </div>
    
    <%
    	int i=1;
     %>
    
    <s:iterator value="#request.commodity" var="u" >
    	<s:iterator value="#u.commodityImages" var="img">
    		<s:if test="%{#img.isDefault==true }">
			    <div class="bimg2">  
			    	<img src=<s:property value="#img.imageUrl" /> />
			    </div>
		    </s:if>
		    <s:elseif test="%{#img.isDefault==false }">
			    <!--四个小图片-->
			    <div class="sMimg<%=i %>">
			    	<img src=<s:property value="#img.imageUrl" /> />
			    </div >
			    <%
			    	i++;
			     %>  
		    </s:elseif>
	    </s:iterator>
	    
		<div class="part2">
			<p>物品名：<s:property value="#u.commodityName" /></p>
    		<p>物品详细信息：<s:property value="#u.commodityDetails" /></p>
    		<p>物品价格：<s:property value="#u.commodityPrice" /></p>
    		
    		<input type="button" value="立即购买" onclick="javascript:location.href='shopping!createOrder.action?commodityId=<s:property value="#u.commodityId" />'" />
    	</div>
    </s:iterator>
    
    <div class="rightline1">
    </div>
    <div class="leftcontent">
    </div>
    
    </div>
    
    </body>
</html>
