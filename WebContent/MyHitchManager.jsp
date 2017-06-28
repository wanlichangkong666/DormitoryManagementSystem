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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">宿舍故障提交记录</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MyHitchManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                   
                    <td width="72%" align="center">查询：
                      <select name="Dno" id="Dno">
                        <option value="">全部宿舍</option>
                        <s:iterator  value="DormitoryList">
                        <option value="${Dno}">${Dno}</option>
                        </s:iterator>
                      </select>
                      <select name="SearchRow" id="SearchRow">
                        <option value="Htime">报修时间</option>
                        <option value="Htype">故障类型</option>                       
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询">
                      <label for="Ano"></label>
                      <input name="Ano" type="text" class="noshow" id="Ano" value="${Ano}"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    
                    <td height="25" bgcolor="#D5E4F4"><strong>宿舍号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>故障类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>报修时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>维修人员</strong></td>
                    <td bgcolor="#D5E4F4"><strong>维修时间</strong></td>             
                    
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">                      
                      <td height="25" align="center">${Dno}</td>
                      <td>${Htype}</td>
                      <td>${Htime}</td>
                      <td>${Rperson}</td>
                      <td>${Rtime}</td>                                                               
                    </tr>
                  </s:iterator>
                </table></td>
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
