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
    
    <title>PARKn Search</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="./Data/css/search.css"/>
	<link rel="stylesheet" type="text/css" href="./Data/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="./Data/css/comment.css"/>
	<link rel="stylesheet" type="text/css" href="./Data/css/home.css"/>
 </head>
<body>
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
				<div class="tShopOwer tReft">
					<a>ShopOwer</a>
					<ul class="tUlFloat" ">
						<li>* IWannaSetUpShop</li>
						<li>* GoodsSold</li>
						<li>* GoodsOn Sole</li>
					</ul>
				</div>
			</div>
		</div>
	<div id="main">
		<div id="logo">
				<div class="lLogoImage"><img src="./Data/homeLogo.gif"/></div>
				<div class="lMSearch">
					<input class="mSearchText" type="text" />
					<input type="submit" class="mSearchSubmt" value="search" />
				</div>
			</div>
		<div id="nav">
				<ul>
					<li>Home</li>
					<li>Device</li>
					<li>HouseHold</li>
					<li>EveryDay</li>
					<li>Clothes</li>
					<li>&nbsp;</li>
				</ul>
				<div class="ChomeCart preferentail" >
					<a>Preferentail</a>
				</div>
				<div class="ChomeCart">
					<img src="./Data/images/shopping_cart_filled-512.gif"/>
					
					
				</div>
			</div>
			<div id="sear">
				<div>
				<p>current position: 羽绒服</p>
				<table border=1 width=1000 cellpadding=20>
					<tr>
						<td><font size=4>cloth<font></td>
						<td><font size=4>man(1999) women(555)<font></td>
					</tr>
					<tr>
						<td ><font size=4>shoes<font></td>
						<td><font size=>shoes<font></td>
					</tr>
				</table>
				</div>
				<br>
				<div>
				If you want to find: 羽绒  女  羽绒短外套
				</div>
				<br>
				<table width=500>
				<tr><td><font size=6>综合</font><img src=".\Data\images\searchreasult\head.png"></td>
				<td><font size=6>销量</font><img src=".\Data\images\searchreasult\head.png"></td>
				<td><font size=6>信用</font><img src=".\Data\images\searchreasult\head.png"></td></tr>
				</table>
				<hr>
				<div>
				<!--搜索结果-->
				
				<s:iterator value="#request.commodityList" var='u'>
					<s:iterator value="#u.commodityImages" var="img">
						<s:if test="%{#img.isDefault==true}">
							<div class="search">
								<a href="shopping!gotoDetail.action?commodityId=<s:property value='#u.commodityId' />" >
									<img src=<s:property value="#img.imageUrl" /> /></a>
							</div>
						</s:if>
					</s:iterator>
				</s:iterator>
				
				</div>
			</div>
			<div ><!--推荐商品-->
				<div>
				<br>
				<p>you may like</p>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\1.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\2.jpg"/></div>
					<div class="adtext"> 超轻经典立领羽绒服（女） 黑色
					售价：￥249
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\3.jpg"/></div>
					<div class="adtext"> 精致细节系腰带修身羽绒服 梅紫色
					售价：￥198
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\4.jpg"/></div>
					<div class="adtext"> 戴帽超轻羽绒 黑色
					售价：￥129
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\5.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\6.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\7.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\8.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\3.jpg"/></div>
					<div class="adtext"> 精致细节系腰带修身羽绒服 梅紫色
					售价：￥198
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\4.jpg"/></div>
					<div class="adtext"> 戴帽超轻羽绒 黑色
					售价：￥129
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\5.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\6.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
				<div >
					<div class="adimage"><img src=".\Data\images\searchreasult\adgoods\6.jpg"/></div>
					<div class="adtext"> DF 笛凡 新款男装
					售价：￥99
					</div>
				</div>
			</div>
	</div>
	
	<div id="footer">
			<div id="footerlist">
				<div id="lAbortParkn" class="footerListdetail">
					<ul>
						<li><b>Abort PARKn</b></li>
						<li><a>Company Profile</a></li>
						<li><a>jion Us</a></li>
						<li><a>Coorperation</a></li>
						<li><a>Contact us</a></li>
						<li><a>Friendly Links</a></li>
					</ul>
				</div>
				<div id="lGuide" class="footerListdetail">
					<ul>
						<li><b>beginner guide</b></li>
						<li><a>Account registraction</a></li>
						<li><a>Account Registration</a></li>
						<li><a>Site Map</a></li>
						<li><a>Merchant settled</a></li>
					
					</ul>
				</div>
				<div id="lDistribution" class="footerListdetail">
					<ul>
						<li><b>Distribute</b></li>
						<li><a>Domestic distribution</a></li>
						
					</ul>
				</div>
				<div id="lPayment" class="footerListdetail">
					<ul>
						<li><b>Payment</b></li>
						<li><a>Cash on delivery</a></li>
						<li><a>Online Payment</a></li>
						
					</ul>
				</div>
				<div id="lService" class="footerListdetail">
					<ul>
						<li><b>Service</b></li>
						<li><a>Return Policy</a></li>
						<li><a>Returned Process</a></li>
						<li><a>Returned Description</a></li>
						<li><a>Returned online check</a></li>
					</ul>
				</div>
				<div id="lHelp" class="footerListdetail setLast">
					<ul>
						<li><b>Help</b></li>
						<li><a>Online Service</a></li>
						<li><a>Forgot Password</a></li>
						<li><a>privacy Statement</a></li>
						
					</ul>
				</div>
			</div>
			<div id="footerImageList" >
				<div><img src=""/></div>
				<div><img src=""/></div>
				<div><img src=""/></div>
				<div><img src=""/></div>
			</div>	
		</div>
		<div class="footerLine">
			<div><a>返回顶层</a></div>
		</div>
</body>
</html>
