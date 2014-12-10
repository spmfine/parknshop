<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="./Data/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="./Data/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="./Data/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="./Data/css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<style type="text/css">  

        .code   
        {   
            background-image:url(code.jpg);   
            font-family:Arial;   
            font-style:italic;   
            color:Red;   
            border:0;   
            padding:2px 3px;   
            letter-spacing:3px;   
            font-weight:bolder;   
        }   
        .unchanged   
        {   
            border:0;   
        }   
</style>
<script>     
     function hyz(){
     
     	var request = new XMLHttpRequest();
     	request.onreadystatechange = function(){
     		
     		if(request.readyState==4){
     			
     			document.getElementById("checkCode").src = "login!gotoCheckSum.action";
     		}
     	}
     	request.open("GET","login!gotoCheckSum.action",true);
     	request.send(null);
     }

</script> 
    
    
<%
	String name = null;
	String pass = null;
	Cookie[] c = request.getCookies();
	for(Cookie t:c){
	
		if(t.getName().equals("username"))
			name=t.getValue();
		if(t.getName().equals("password"))
			pass=t.getValue();
	}
 %>
       
     
<body class="templatemo-bg-gray">

    <div class="row">
        
        <div class="col-md-8">
        	<div class="row">
            <div class="col-md-6"  >
            <label><h4>PARKn shopping</h4></label>
            </div>
        		<div class="col-md-2" style="margin-top:10px ">
        		<label for="home" class="control-label fa-label"><i class="fa fa-home fa-medium"></i></label>
        		<a href="index.html" >HomePage</a>
        		</div>
        		<div class="col-md-2" style="margin-top:10px">
        		<label for="help" class="control-label fa-label"><i class="fa fa-question-circle fa-medium"></i></label>
        		<a href="help.html" >Help</a>
        		</div>
        		<div class="col-md-2" style="margin-top:10px ">
        		<label for="shoppingCar" class="control-label fa-label"><i class="fa  fa-shopping-cart fa-medium"></i></label>
        		<a href="shoppingCar.html" >shoppingCar</a>
        		</div>
        	</div>
        	<div class="row">
        		<div class="col-md-12"style="margin-top:10px" >
        	    <ol class="breadcrumb" style="background-color:#888888" >
        		</div>
        	</div>
        	<div class="row">
        		<div class="col-md-12" style="margin-top:25px">
        	    <img  src="./Data/images/liujian/a.jpg" height="490" width="880"style="margin-left:5px" >
        		</div>
        	</div>
        </div>
        <div class="col-md-4">
        	<div class="row">
        		<div class="col-md-12">
        		<img  src="./Data/images/liujian/good2.jpg" height="120px" width="420px" style="margin-top:5px">
        		</div>
        	</div>
        	<div class="row" style="margin-right:20px">
        		<div class="col-md-12">
				   <h1 class="margin-bottom-15">Login </h1>
				   
				   <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form"  action="login!loginC.action" method="post">		
				   		
			        <div class="form-group">
			          <div class="col-xs-12">		            
			            <div class="control-wrapper">
			            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
			            	<%
			            		if(name==null){
			            	 %>
			            	<input type="text" name="username" class="form-control" id="username" placeholder="Username/Mobilenumber/Mailbox">
			            	<% 
			            		}else{
			            	%>
			            	<input type="text" name="username" class="form-control" id="username" value=<%=name %> />
			            	<%
			            		}
			            	 %>
			            </div>		            	            
			          </div>              
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			          	<div class="control-wrapper">
			            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
			            	<%
			            		if(pass==null){
			            	 %>
			            	<input type="password" name="password" class="form-control" id="password" placeholder="Password">
			            	<% 
			            		}else{
			            	%>
			            	<input type="password" name="password" class="form-control" id="password" value=<%=pass %> />
			            	<%
			            		}
			            	 %>
			            </div>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
		             	<div class="checkbox control-wrapper">
		                	<label>
		                	
		                  		<input type="checkbox" name="remember" value="remember"> Remember password
		                  		
	                		</label>
	                		
	                		<a href="login!gotoForgetPassword.action" class="text-right pull-right">Forgot password?</a>
	                		
		              	</div>
			          </div>
			         <div class="form-group">
			          <div class="col-md-12">
		             	<div class="checkbox control-wrapper">
		                	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		                	
		                	<input  type="text"  name="checksum" id="input1" style="margin-left:30px;width: 120px" />
		                	
						    <img src="login!gotoCheckSum.action" id="checkCode" class="unchanged" style="width: 60px " />  
						    
		    				<input type="button" id="Button1" class="btn btn-warning" style="margin-left:20px" value="换一张" onclick="hyz()" />
		    				
			             </div>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			          	<div class="control-wrapper">
			          	
			          		<input type="submit" value="Login" class="btn btn-primary btn-lg btn-block"  >
			          		
			          		<a href="login!gotoRegist.action" class="text-right pull-right"><h4>GoRegist <i class="fa fa-arrow-circle-o-right"></i></h4></a>
			          		
			          	</div>
			          </div>
			        </div>
			        <hr>
			        <div class="form-group">
			        	<div class="col-md-12">
			        		<label>Login with: </label>
			        		<div class="inline-block">
			        			<a href="#"><i class="fa fa-facebook-square login-with"></i></a>
				        		<a href="#"><i class="fa fa-twitter-square login-with"></i></a>
				        		<a href="#"><i class="fa fa-google-plus-square login-with"></i></a>
				        		<a href="#"><i class="fa fa-tumblr-square login-with"></i></a>
				        		<a href="#"><i class="fa fa-github-square login-with"></i></a>
			        		</div>		        		
			        	</div>
			        </div>
			      </form>
	
			      <!-- <div class="text-center">
			      	<a href="create-account.html" class="templatemo-create-new">Create new account <i class="fa fa-arrow-circle-o-right"></i></a>	
			      </div> -->
        		</div>
        	</div>
        </div>  
    </div>
    </div>
	
	</div>
	 
	</div>
</body>
