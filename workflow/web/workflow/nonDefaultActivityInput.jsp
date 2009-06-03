<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr"%>


<bean:define id="process" name="information" property="process" toScope="request"/>
<bean:define id="processId" name="process" property="OID" />
<bean:define id="processClassName" name="process" property="class.name" type="java.lang.String"/>
<bean:define id="name" name="information" property="activityName"/>
<bean:define id="activityInformationClass" name="information" property="class.simpleName"/>
<bean:define id="inputInterface" name="inputInterface" type="java.lang.String"/>

<bean:define id="includeFolder" value="<%= processClassName.replace('.','/')%>"/>

<h2><fr:view name="information" property="localizedName"/></h2>

<jsp:include page='<%= "/" + includeFolder + "/shortBody.jsp" %>'/>

<p>
	<jsp:include page='<%= "/" + inputInterface %>'/>
</p>