<%--
  Class Name : EgovUserInsert.jsp
  Description : 사용자등록View JSP
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.03.03   JJY              최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 JJY
    since    : 2009.03.03
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Language" content="ko" >
<link href="<c:url value='/'/>css/common.css" rel="stylesheet" type="text/css" >

<title>사용자 등록</title>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="employeesVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript" src="<c:url value='/js/EgovZipPopup.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
function fnIdCheck(){
    var retVal;
    var url = "<c:url value='/uss/umt/cmm/EgovIdDplctCnfirmView.do'/>";
    var varParam = new Object();
    varParam.checkId = document.employeesVO.emplyrId.value;
    var openParam = "dialogWidth:303px;dialogHeight:250px;scroll:no;status:no;center:yes;resizable:yes;";
    retVal = window.showModalDialog(url, varParam, openParam);
    if(retVal) {
        document.employeesVO.emplyrId.value = retVal;
        document.employeesVO.id_view.value = retVal;
    }
}
function showModalDialogCallback(retVal) {
    if(retVal) {
        document.employeesVO.emplyrId.value = retVal;
        document.employeesVO.id_view.value = retVal;
    }
}
function fnListPage(){
    document.employeesVO.action = "<c:url value='/uss/umt/user/EgovUserManage.do'/>"; 
    document.employeesVO.submit();
}
function fnInsert(){
	document.employeesVO.submit();
}
function fn_egov_inqire_cert() {
    var url = '/uat/uia/EgovGpkiRegist.do';
    var popupwidth = '500';
    var popupheight = '400';
    var title = '인증서';

    Top = (window.screen.height - popupheight) / 3;
    Left = (window.screen.width - popupwidth) / 2;
    if (Top < 0) Top = 0;
    if (Left < 0) Left = 0;
    Future = "fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no, scrollbars=no,resizable=no,left=" + Left + ",top=" + Top + ",width=" + popupwidth + ",height=" + popupheight;
    PopUpWindow = window.open(url, title, Future)
    PopUpWindow.focus();
}

function fn_egov_dn_info_setting(dn) {
    var frm = document.employeesVO;
    
    frm.subDn.value = dn;
}

/*
if (typeof(opener.fn_egov_dn_info_setting) == 'undefined') {
    alert('메인 화면이 변경되거나 없습니다');
    this.close();
} else {
    opener.fn_egov_dn_info_setting(dn);
    this.close();
}
*/

//-->
</script>

</head>
<body>
<noscript>자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>    
<!-- 전체 레이어 시작 -->
<div id="wrap">
    <!-- header 시작 -->
    <div id="header"><c:import url="/EgovPageLink.do?link=main/inc/EgovIncHeader" /></div>
    <div id="topnavi"><c:import url="/sym/mms/EgovMainMenuHead.do" /></div>        
    <!-- //header 끝 --> 
    <!-- container 시작 -->
    <div id="container">
        <!-- 좌측메뉴 시작 -->
        <div id="leftmenu"><c:import url="/sym/mms/EgovMainMenuLeft.do" /></div>
        <!-- //좌측메뉴 끝 -->
            <!-- 현재위치 네비게이션 시작 -->
            <div id="content">
                <div id="cur_loc">
                    <div id="cur_loc_align">
                        <ul>
                            <li>HOME</li>
                            <li>&gt;</li>
                            <li>내부시스템관리</li>
                            <li>&gt;</li>
                            <li><strong>사용자관리</strong></li>
                        </ul>
                    </div>
                </div>
                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
                    <div id="search_field_loc"><h2><strong>업무사용자 등록</strong></h2></div>
                </div>
		        <form:form commandName="employeesVO" action="${pageContext.request.contextPath}/bizerp/hmr/employees/addEmployees.do" name="employeesVO" method="post" >
                    <div class="modify_user" > 
				        <table>
				            <tr> 
				                <th width="20%" height="23" class="required_text">파트ID
				                    <img src="<c:url value='/'/>images/required.gif" width="15" height="15" alt="필수" />
				                </th>
				                <td width="30%" >
				                    <form:input path="partyId" id="partyId" title="파트ID" size="20" maxlength="20" />
				                </td>
                                <th width="20%" height="23" class="required_text">파트유형ID</th>
                                <td width="30%" >
                                    <form:input path="partyTypeId" id="partyTypeId" title="파트유형ID" cssClass="txaIpt" size="20" maxlength="15" />
                                </td>
				            </tr>
				            
				            <tr> 
				                <th width="20%" height="23" class="required_text">외부ID</th>
				                <td width="30%" >
				                    <form:input path="externalId" id="externalId" title="외부ID" size="20" maxlength="20" />
				                </td>
                                <th width="20%" height="23" class="required_text">참조통화UOM ID</th>
                                <td width="30%" >
                                    <form:input path="preferredCurrencyUomId" id="preferredCurrencyUomId" title="파트유형ID" cssClass="txaIpt" size="20" maxlength="15" />
                                </td>
				            </tr>
				            
				            <tr> 
				                <th width="20%" height="23" class="required_text">설명</th>
				                <td width="30%" >
				                    <form:input path="description" id="externalId" title="설명" size="20" maxlength="20" />
				                </td>
                                <th width="20%" height="23" class="required_text">상태ID</th>
                                <td width="30%" >
                                    <form:input path="statusId" id="statusId" title="상태ID" cssClass="txaIpt" size="20" maxlength="15" />
                                </td>
				            </tr>
				            
				            <tr> 
				                <th width="20%" height="23" class="required_text">데이터소스ID</th>
				                <td width="30%" >
				                    <form:input path="dataSourceId" id="dataSourceId" title="데이터소스" size="20" maxlength="20" />
				                </td>
                                <th width="20%" height="23" class="required_text">읽지않음여부</th>
                                <td width="30%" >
                                    <form:input path="isUnread" id="isUnread" title="읽지않음여부" cssClass="txaIpt" size="20" maxlength="15" />
                                </td>
				            </tr>
                        </table>
                    </div>

                    <!-- 버튼 시작(상세지정 style로 div에 지정) -->
                    <div class="buttons" style="padding-top:10px;padding-bottom:10px;">

                        <!-- 목록/저장버튼  -->
                        <table border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr> 
                          <td>
                            <a href="#LINK" onclick="JavaScript:fnInsert(); return fallse;"><spring:message code="button.save" /></a> 
                          </td>
                          <td width="10"></td>
                          <td>
                            <a href="<c:url value='/bizerp/hmr/employees/EmployeesList.do'/>" onclick="fnListPage(); return false;"><spring:message code="button.list" /></a> 
                          </td>
                          <td width="10"></td>
                          <td>
                            <a href="#LINK" onclick="javascript:document.employeesVO.reset();"><spring:message code="button.reset" /></a>
                          </td>      
                        </tr>
                        </table>
                    </div>
                    <!-- 버튼 끝 -->                           

			        <!-- 검색조건 유지 -->
			        <input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
			        <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
			        <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/><c:if test="${searchVO.pageIndex eq null}">1</c:if>"/>
			        
                </form:form>

            </div>  
            <!-- //content 끝 -->    
    </div>  
    <!-- //container 끝 -->
    <!-- footer 시작 -->
    <div id="footer"><c:import url="/EgovPageLink.do?link=main/inc/EgovIncFooter" /></div>
    <!-- //footer 끝 -->
</div>
<!-- //전체 레이어 끝 -->
</body>
</html>

