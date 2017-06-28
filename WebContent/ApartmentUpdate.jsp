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
	if(isNull(form1.Fcount.value)){  
		   alert("请输入楼层数量！"); 
		   return false;
		   }
	   if(isNull(form1.Dcount.value)){  
		   alert("请输入宿舍数量！"); 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改公寓</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ApartmentUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Ano" type="text" class="noshow" id="Ano" value="<s:property value='cnbean.Ano'/>"></td>
                  </tr>
                    <tr>
                    <td height="30" align="right">居住性别：</td>
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
                    <td height="30" align="right"><span style="color:red;">*</span>楼层数量：</td>
                    <td><input name="Fcount" type="text" class="text2" id="Fcount" value="<s:property value='cnbean.Fcount'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>宿舍数量：</td>
                    <td><input name="Dcount" type="text" class="text2" id="Dcount" value="<s:property value='cnbean.Dcount'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right">居住费用：</td>
                    <td><input name="Aspend" type="text" class="text2" id="Aspend" value="<s:property value='cnbean.Aspend'/>"></td>
                  </tr>
                   <tr>
                    <td height="30" align="right">管理室联系座机：</td>
                    <td><input name="Mtel" type="text" class="text2" id="Mtel" value="<s:property value='cnbean.Mtel'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改公寓">
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
