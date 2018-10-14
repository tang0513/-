<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/index2.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.8.2.min.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/My97DatePicker/WdatePicker.js"></script>
</head>
<script type="text/javascript">

//获取选中的下拉框的值
var oall=document.getElementById("all");
var oid=document.getElementsByName("id");
oall.onclick=function(){
    for(var i=0;i<oid.length;i++){
        oid[i].checked=oall.checked;        
    }
};
for(var i=0;i<oid.length;i++){
    oid[i].onclick=function(){
        for(var j=0;j<oid.length;j++){
          if(oid[j].checked==false){
            oall.checked=false;
            break;
          }else{
            oall.checked=true;
          }
        }
    };
}

//批量删除
function del(){
    var ids="";
    var n=0;
    for(var i=0;i<oid.length;i++){
        if(oid[i].checked==true){
            var id=oid[i].value;
            if(n==0){
                ids+="ids="+id;
            }else{
                ids+="&ids="+id;
            }
            n++;
        }           
    }
    
    $.get("/del",ids,function(data){
        if(data){
            alert("删除成功!");
            location.href="http://localhost/list";
        }else{
            alert("删除失败!");
        }
    });
}

//二级联动
function getData(obj) {
	var opt = obj.options[obj.selectedIndex]
	//alert("The option you select is:"+opt.text+"("+opt.value+")");
	$.ajax({
	url : "<%=request.getContextPath()%>/findSessOneBySname.do",
	type : "Post",
	data : 'sname='+opt.value,
	success : function(data) {
		/* for (var i = 0; i < data.length; i++) { */
			$("#cpxh").append("<option value='"+data.cname+"'>" + data.cname + "</option>");
		/* } */
	}
	});
}

function fenye(current){
	location.href="<%=request.getContextPath()%>/list.do?current="+current;
}

//全选反选
function  checkAll(){
    var all = document.getElementById("all");
    var ckOnes = document.getElementsByName("id");
    for (var i = 0; i < ckOnes.length; i++) {
        ckOnes[i].checked= all.checked;
    }   
}

</script>
<body>

<table>
	<tr>
		<td style="text-align:left;" colspan="3">
			<a href="#" onclick="del()">批量删除</a>
		</td>
		<td style="text-align:left;" colspan="10">
			<form action="<%=request.getContextPath()%>/list.do" method="post" id="myform">
				届别：
				<select name="sname" onchange="getData(this)">
					<option value="0">所有</option>
					<c:forEach items="${sesslist }" var="sess">
						<option value="${sess.sname }">${sess.sname }</option>
					</c:forEach>
				</select>　　
				班级：
				<select name="cname" id="cpxh">
					<option value="0">所有</option>
				</select>　　
				关键字：<input type="text" name="stuname" placeholder="学号/姓名">
				<input type="submit" value="查询">
			</form>
		</td>
	</tr>
	<tr>
		<td align="center" width="9%"><input type="checkbox" name="ckAll"  value="全选/反选" onclick="checkAll()"  id="all"/>全选/反选</td>
		<td>届别</td>
		<td>班级名称</td>
		<td>学号</td>
		<td>姓名</td>
		<td>出生日期</td>
		<td>性别</td>
		<td>状态</td>
		<td>民族</td>
		<td>电话</td>
		<td>入学日期</td>
		<td>备注</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${page.list }" var="shop">
		<tr>
			<td><input name="id" id="all" type="checkbox" value="${shop.sid }" /></td>
			<td>${shop.sname }</td>
			<td>${shop.cname }</td>
			<td>${shop.rnum }</td>
			<td>${shop.stuname }</td>
			<td>${shop.stuborn }</td>
			<td>${shop.stusex }</td>
			<td>${shop.states }</td>
			<td>${shop.stunation }</td>
			<td>${shop.stuphone }</td>
			<td>${shop.rdate }</td>
			<td>${shop.content }</td>
			<td>
				<a href="<%=request.getContextPath()%>/toAdd.do">添加</a>
				<a href="<%=request.getContextPath()%>/del.do?rid=${shop.rid}">删除</a>
				<a href="<%=request.getContextPath()%>/toUpdate.do?rid=${shop.rid}">修改</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="13">
			<form action="<%=request.getContextPath()%>/daochu.do" method="post" accept-charset="UTF-8" consubmit="document.charset='UTF-8';" enctype="multipart/form-data">
			<input type="button" value="首页" onclick="fenye(1)"/>
			<input type="button" value="上一页" onclick="fenye(${page.prePage})"/>
			<input type="button" value="下一页" onclick="fenye(${page.nextPage})"/>
			<input type="button" value="末页" onclick="fenye(${page.pages})"/>
			<input type="submit" value="导出">
			</form>
		</td>
	</tr>
</table>

</body>
</html>