<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<link rel="stylesheet" type="text/css" href="Data/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="Data/css/comment.css"/>
	<link rel="stylesheet" type="text/css" href="Data/css/home.css"/>
	<script src="Data/js/jquery-2.1.1.min.js" type="text/javascript" charset="utf-8"></script>
</head>

<body >
		<div id="top">
			<div class="topList">
				<div class="tUserName tleft"><span>Hi </span><a>UserName</a></div>
				<div class="tLoginRegist tleft"><a href="login!gotoLogin.action">Login</a><span>&nbsp;&nbsp; </span><a>Regist</a></div>
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
		<div id="main">
			<div id="logo">
				<div class="lLogoImage"><img src="Data/homeLogo.gif"/></div>
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
					<img src="Data/images/shopping_cart_filled-512.gif"/>
					
					<div id="homeCartDetail" class="Chomecartdetail">
						<span>Recently Add To Cart<span>
						<div class="cartGoods">
							<div class="cartGoodsImage">
								<img src="Data/images/adImage/cart1.gif"/>
							</div>
							<div class="cartGoodschart">
								<a>good cloths</a>
								<span >$100</span>
							</div>
							<div class="cartGoodsDe">
								<a>delete</a>
							</div>
						</div>
						<div class="cartGoods">
							<div class="cartGoodsImage">
								<img src="Data/images/adImage/cart1.gif"/>
							</div>
							<div class="cartGoodschart">
								<a>good cloths</a>
								<span >$100</span>
							</div>
							<div class="cartGoodsDe">
								<a>delete</a>
							</div>
						</div>
						<input type="button" name="horder" id="horder" value="order" />
					</div>
				</div>
			</div>
			<div id="carouselMain">
				<div id="carousel">
					<div id="carLeft"></div>
					<div id="carRight"></div>
					
					<img class="mainCarousel" src="" />
					<img class="mainCarousel" src=""/>
					<img class="mainCarousel" src="" />
					<img class="mainCarousel" src=""/>
					<img class="mainCarousel" src="" />
					<img class="mainCarousel" src="Data/images/1200.jpg"/>
					<ul id="carPointer">
						<li>&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
					</ul>
				</div>
			</div>
			<div id="displayGoods">
				<div class="diaplayLarge displayRightSpace">
					<img src="Data/images/adImage/d6h2bs29.gif"/>
				</div>
				<div class="diaplaySmall">
					<img src="Data/images/adImage/10niavse.gif"/>
				</div>
				<div class="diaplayMiddle displayRightSpace">
					<img src="Data/images/adImage/4hu9u0e4.gif"/>
				</div>
				<div class="diaplayMiddle displayRightSpace">
					<img src="Data/images/adImage/5shrvt7c.gif"/>
				</div>
				<div class="diaplayMiddle ">
					<img src="Data/images/adImage/euhybgcg.gif"/>
				</div>
				<div class="diaplaySmall displayRightSpace">
					<img src="Data/images/adImage/7q71ddr8.gif"/>
				</div>
				<div class="diaplayLarge">
					<img src="Data/images/adImage/2v43v0a0.gif"/>
				</div>
				<div class="displayMoreSmall displayRightSpace">
					<img src="Data/images/adImage/8l7959m8.gif"/>
				</div>
				<div class="displayMoreSmall displayRightSpace">
					<img src="Data/images/adImage/7a4yi29z.gif"/>
				</div>
				<div class="displayMoreSmall ">
					<img src="Data/images/adImage/9bagng74.gif"/>
				</div>
			</div>
			
			
			<div id="mHotkey">
				
				<div id="hotLeft">
					<b>HotKey<b>
				</div>
				<div id="hotRightTop">
					<ul id="hotkeyWord">
						<li><a>Shoes</a></li>
						<li><a>Flowers</a></li>
						<li><a>Computer</a></li>
						<li><a>fruit</a></li>
						<li><a>Bag</a></li>
						<li><a>JackJONS</a></li>
						<li><a>LV</a></li>
						<li><a>爱马仕</a></li>
						<li><a>&nbsp</a></li>
					</ul>
				</div>
				<div id="hotRightBottom">
					<div id="hotRightBottomSearch">
						<input type="text" class="hotSearchText"/>
						<input type="submit" class="hotsearchSubmit" value="search"/>
					</div>
					
					<div id="hotFunctionSelect" class="cHotFunctionSelect" >
						<input type="text"  class="cFunctionSelectText"/>
						<a class="cFunctionSelectLowSite"> </a>
						<ul>
							<li><a>aaa</a></li>
							<li><a>aaaasdad</a></li>
						</ul>
					</div>
					<div id="hotbrandSelect" class="cHotFunctionSelect">
						<input type="text"  class="cFunctionSelectText"/>
						<a class="cBrandSelectLowSite"> </a>
						<ul>
							<li><a>aaa</a></li>
							<li><a>aaaasdads</a></li>
						</ul>
					</div>
					
					
				</div>
			</div>
			<div id="mAd">
				<img />
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

