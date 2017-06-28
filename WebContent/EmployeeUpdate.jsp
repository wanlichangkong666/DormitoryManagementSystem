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
   if(isNull(form1.Eno.value)){  
   alert("请输入编号！"); 
   return false;
   }
   if(isNull(form1.Ename.value)){
   alert("请输入姓名！");
   return false;
   }
   if(isNull(form1.Esex.value)){
   alert("请选择性别！");
   return false;
   }
   if(isNull(form1.Epos.value)){
   alert("请输入职位！");
   return false;
   }
   if(isNull(form1.Etel.value)){
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改员工</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="EmployeeUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Eno" type="text" class="noshow" id="Eno" value="<s:property value='cnbean.Eno'/>"></td>
                  </tr>                           
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="Ename" type="text" class="text2" id="Ename" value="<s:property value='cnbean.Ename'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>性别：</td>
                    <td><select name="Esex" id="Esex">
                      <option value="">请选择</option>
                      <option value="男" 
                      <s:if test='cnbean.Esex=="男"'>selected</s:if>
                      >男
                      </option>
                      <option value="女" 
                      <s:if test='cnbean.Esex=="女"'>selected</s:if>
                      >女
                      </option>
                    </select></td>
                  </tr>
                  <tr><td height="30" align="right"><span style="color:red;">*</span>职位：</td>
                   <td><select name="Epos" id="Epos">
                      <option value="">请选择</option>
                      <option value="宿管" 
                      <s:if test='cnbean.Epos=="宿管"'>selected</s:if>
                      >宿管
                      </option>
                      <option value="保洁" 
                      <s:if test='cnbean.Epos=="保洁"'>selected</s:if>
                      >保洁
                      </option>
                    </select></td>
                  </tr>
                                    <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="Etel" type="text" class="text2" id="Etel" value="<s:property value='cnbean.Etel'/>"></td>
                  </tr>
                                    <tr>
                    <td height="30" align="right">负责楼号：</td>
                    <td><input name="Eano" type="text" class="text2" id="Eano" value="<s:property value='cnbean.Eano'/>"></td>
                  </tr>
                       <tr><td height="30" align="right"><span style="color:red;">*</span>值班时间：</td>
                   <td><select name="Etime" id="Etime">
                      <option value="">请选择</option>
                      <option value="单周" 
                      <s:if test='cnbean.Etime=="单周"'>selected</s:if>
                      >单周
                      </option>
                      <option value="双周" 
                      <s:if test='cnbean.Etime=="双周"'>selected</s:if>
                      >双周
                      </option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改员工">
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
