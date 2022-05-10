
/**
 * 加入购物车
 */
function buy(bId){
	$.get("books_buy", {bId:bId}, function(data){
// <<<<<<< HEAD
// 		if(data=="ok")
// =======
		if(data==="ok")
// >>>>>>> ssj
		{
			layer.msg("添加到购物车!", {time:800}, function(){
               location.reload();
            });
		}
		else if(data==="fail")
		{
            layer.msg("库存不足,请购买其他商品!", {time:800}, function(){

            });
		}
		/*if(data=="ok"){
			layer.msg("操作成功!", {time:800}, function(){
				location.reload();
			});
		}else if(data=="login"){
			alert("请登录后购买!");
			location.href="login.jsp";
		}else if(data=="empty"){
			alert("库存不足!");
			location.reload();
		}else{
			alert("请求失败!");
		}*/

	});
}

function lessen(bId){
    $.post("books_lessen", {bId:bId}, function(data){
        if(data==="ok"){
            layer.msg("操作成功!", {time:800}, function(){
                location.reload();
            });
        }
//		if(data=="ok"){
//			layer.msg("操作成功!", {time:800}, function(){
//				location.href="cart.action";
//			});
//		}else if(data=="login"){
//			alert("请登录后操作!");
//			location.href="login.jsp";
//		}else{
//			alert("请求失败!");
//		}
    });
}
/**
 * 购物车删除
 */
function deletes(bId){
    $.post("books_delete", {bId:bId}, function(data){
        if(data==="ok"){
            layer.msg("删除成功!", {time:800}, function(){
                location.reload();
            });
        }
    });
}