<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园宿舍管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
	  
		   if(isNull(form1.Sname.value)){
		   alert("请输入姓名！");
		   return false;
		   }
		   if(isNull(form1.Ssex.value)){
		   alert("请输入性别！");
		   return false;
		   }
		   if(isNull(form1.Stel.value)){
		   alert("请输入联系电话！");
		   return false;
		   }
		  
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改学生</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="StudentUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Sno" type="text" class="noshow" id="Sno" value="<s:property value='cnbean.Sno'/>"></td>
                  </tr>
           
                
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="Sname" type="text" class="text2" id="Sname" value="<s:property value='cnbean.Sname'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>性别：</td>
                    <td><select name="Ssex" id="Ssex">
                      <option value="">请选择</option>
                      <option value="男" 
                      <s:if test='cnbean.Ssex=="男"'>selected</s:if>
                      >男
                      </option>
                      <option value="女" 
                      <s:if test='cnbean.Ssex=="女"'>selected</s:if>
                      >女
                      </option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">楼号：</td>
                    <td><input name="Ano" type="text" class="text2" id="Ano" value="<s:property value='cnbean.Ano'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">宿舍号：</td>
                    <td><input name="Dno" type="text" class="text2" id="Dno" value="<s:property value='cnbean.Dno'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">床号：</td>
                    <td><input name="Bno" type="text" class="text2" id="Bno" value="<s:property value='cnbean.Bno'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="Stel" type="text" class="text2" id="Stel" value="<s:property value='cnbean.Stel'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">班主任联系电话：</td>
                    <td><input name="Ttel" type="text" class="text2" id="Ttel" value="<s:property value='cnbean.Ttel'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改学生">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
