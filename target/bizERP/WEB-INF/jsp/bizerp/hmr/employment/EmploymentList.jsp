<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : EmploymentList.jsp
  * @Description : Employment List 화면
  * @Modification Information
  * 
  * @author 이성권
  * @since 2020-08-09
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */


function fn_egov_select(roleTypeIdFrom) {
    document.getElementById("listForm").roleTypeIdFrom.value = roleTypeIdFrom;
   	document.getElementById("listForm").action = "<c:url value='/employment/updateEmploymentView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/employment/addEmploymentView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/employment/EmploymentList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
    <input type="hidden" name="roleTypeIdFrom" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="title" /> List </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">RoleTypeIdFrom</th>
								<th align="center">RoleTypeIdTo</th>
								<th align="center">PartyIdFrom</th>
								<th align="center">PartyIdTo</th>
								<th align="center">FromDate</th>
								<th align="center">ThruDate</th>
								<th align="center">TerminationReasonId</th>
								<th align="center">TerminationTypeId</th>
								<th align="center">LastUpdatedStamp</th>
								<th align="center">LastUpdatedTxStamp</th>
								<th align="center">CreatedStamp</th>
								<th align="center">CreatedTxStamp</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
		 				<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.roleTypeIdFrom}"/>')"><c:out value="${result.roleTypeIdFrom}"/></a>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.roleTypeIdTo}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.partyIdFrom}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.partyIdTo}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.fromDate}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.thruDate}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.terminationReasonId}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.terminationTypeId}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.lastUpdatedStamp}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.lastUpdatedTxStamp}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.createdStamp}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.createdTxStamp}"/>&nbsp;</td>
									</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	<div id="sysbtn1">
		<ul>
			<li>
				<div id="sysbtn">
					<span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" alt="" />
					</span>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
