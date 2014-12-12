<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Regist</title>
    
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
    
<body class="templatemo-bg-gray">
	<div class="row">
				<div class="col-md-8" >
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
       <div class="row">
        		<div class="col-md-12"style="margin-top:10px" >
        	    <ol class="breadcrumb" style="background-color:#888888" >
        		</div>
        	</div> 		
	<h1 class="margin-bottom-15" style="margin-right:650px">Regist</h1>
		<div class="row">
		<div class="col-md-6">	
		
		
			<form class="form-horizontal <!-- templatemo-container templatemo-login-form-1 margin-bottom-30 -->" role="form"  action="login!regist.action" method="post">
					
					
					<div class="row">
		          			<div class="col-md-12">
		          				<div class="control-wrapper">
		            				<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            				
		            				<input type="text" name="user.userName" class="form-control"  id="username" placeholder="User Name">
		            				
		            				<label for="UserName" id="1" style="visibility:hidden">Support 4-16 Characters</label>
		            			</div>
		            		</div>
		            		<div class="col-md-12" style="margin-top:10px">
		          				<div class="control-wrapper">
				            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
				            	
				            	<input type="password" name="user.userPassword" class="form-control" id="password" placeholder="Password">
				            	
				            	<label for="password" id="2" style="visibility:hidden" >Support 4-16 Characters</label>
		            			</div>
		            		</div>
		            		<div class="col-md-12" style="margin-top:10px">
		          				<div class="control-wrapper">
				            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
				            	
				            	<input type="password" class="form-control" id="password2" placeholder="Password">
				            	
				            	<label for="password" id="3" style="visibility:hidden">Please Anter The Password Again</label>
		            			</div>
		            		</div>
		            		<div class="col-md-12" style="margin-top:10px">
		          				<div class="control-wrapper">
				            	<label for="email" class="control-label fa-label"><i class="fa  fa-envelope-o fa-medium"></i></label>
				            	
				            	<input type="email" name="user.userEmail" class="form-control" id="email" placeholder="Email">
				            	
				            	<label for="email" id="4" style="visibility:hidden">Mailbox cannot be registered</label>
				          		</div>
		            		</div>
		            		<div class="col-md-12" style="margin-top:10px">
	             				<div class="control-wrapper" >
			                	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
			                	
			                	<input  type="text"  name="checksum" id="input1" style="width: 120px" />
							     
							     <img src="login!gotoCheckSum.action" id="checkCode" class="unchanged" style="width: 60px " />  
							     
			    				<input type="button" id="Button1" class="btn btn-warning" style="margin-left:20px" value="换一张" onclick="hyz()" />
								
		             			</div>
		          			</div>
		          			
			          		<div class="col-md-12">
			            			<label>
			            			
			            				<input type="checkbox">I agree to the <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">ParKncProvision</a>
			            			
			            			</label>
			          		</div>
			          		<div class="col-md-12">
			            		
			            		<input type="submit" value="Regist" class="btn btn-primary btn-lg" style="margin-left:200px" style="width: 400px" >
			          		
			          		</div>	
		            	</div> 
		    </form>
		</div>
						<div >
		            		<img  src="./Data/images/liujian/fuck.png" height="300px" width="500px" style="margin-top:5px margin-right:200px float:left">
		            	</div> 
		            	<div>
		            		<label  class="control-label"><h3>I ALready Have An Account <br>&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp     Now I</h3><a href="login!gotoLogin.action" class="pull-middle"><h2>Login</h2></a></label>
		            	</div> 
			        </div>
				</div>
			</form>
		</div>
	</div>
			<script type="text/javascript">
				document.getElementById('username').onmouseover = function(){
						document.getElementById('1').style.visibility=""
				}
			</script> 
			<script type="text/javascript">
				document.getElementById('username').onmouseout = function(){
						document.getElementById('1').style.visibility="hidden"
			}
			</script> 
			<script type="text/javascript">
				document.getElementById('password').onmouseover = function(){
						document.getElementById('2').style.visibility=""
			}
			</script> 
			<script type="text/javascript">
				document.getElementById('password').onmouseout = function(){
						document.getElementById('2').style.visibility="hidden"
			}
			</script> 
			<script type="text/javascript">
				document.getElementById('password2').onmouseover = function(){
						document.getElementById('3').style.visibility=""
			}
			</script> 
			<script type="text/javascript">
				document.getElementById('password2').onmouseout = function(){
						document.getElementById('3').style.visibility="hidden"
			}
			</script> 
			<script type="text/javascript">
				document.getElementById('email').onmouseover = function(){
						document.getElementById('4').style.visibility=""
			}
			</script> 
			<script type="text/javascript">
				document.getElementById('email').onmouseout = function(){
						document.getElementById('4').style.visibility="hidden"
			}
			</script> 
</body>
</html>
