$('.hshowAhide').each(function(){
	$(this).bind({
		mouseover:function(){
			$(this).children('ul').css({"display":"block"});
			$(this).css({"background":"#FFFFFF"});
		},
		mouseout:function(){
			$(this).children('ul').css({"display":"none"});
			$(this).css({"background":"#F7F7F7","color":"#CC3399"})
		}
	});
});

$(function(){
	/*
	 当页面刷新是的搜索图标
	 * */
	if($("#hsearch01").val()==""){
		$("#hsearch01").addClass("mSearchTextSite");
	}else{
		$("#hsearch01").removeClass("mSearchTextSite");
	}
	/*当鼠标指定输入框式*/
	$("#hsearch01").bind({
		focus:function(){
			$("#hsearch01").removeClass("mSearchTextSite");
		},
		blur:function(){
			if($("#hsearch01").val()==""){
				$("#hsearch01").addClass("mSearchTextSite");
			}
		}
	});
	
	
});
/*
 cart代码，
 * */
var flag=0;
$("#hCartImage").hover(function(){
	$(this).next().css({"display":"block"});
	$("#homeCartDetail").bind({
			mouseover:function(){
				
				$(this).css({"display":"block"});
				flag=1;
				
			},
			mouseout:function(){
				$(this).css({"display":"none"});
				
	 		}
	});
},function(){
	time=null;
	
	time=setTimeout(function(){
		if(flag==0){
			$("#hCartImage").next().css({"display":"none"});
		}	
	},200);
	flag=0;
	

});

/*
 
 * 图片轮播图*/
var aImg=[];
$("#carousel img").each(function(){
	aImg.push($(this));
});
var aImg01=aImg;
$("#carLeft").bind("click",function(){
	var temp=aImg.shift();
	aImg.push(temp);
	showImage(aImg[0]);
});
$("#carRight").bind("click",function(){
	var temp=aImg.pop();
	aImg.unshift(temp);
	showImage(aImg[0]);
});
function showImage(obj){
	obj.fadeIn(500);
	obj.siblings(".mainCarousel").each(function(){
		$(this).hide();
	});
}

$("#carousel ul li").each(function(i){
	$(this).bind("click",function(){
		showImage(aImg01[i]);
	});
	
});








