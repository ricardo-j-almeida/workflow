<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr" %>


<%@page import="module.workflow.presentationTier.WorkflowLayoutContext"%>
<%@page import="myorg.presentationTier.actions.ContextBaseAction"%><h2>

<bean:message key="title.comments" bundle="WORKFLOW_RESOURCES"/>
</h2>

<%
	final WorkflowLayoutContext layoutContext = (WorkflowLayoutContext) ContextBaseAction.getContext(request);
%>

<jsp:include page='<%= layoutContext.getWorkflowShortBody() %>'/>

<p>
	<html:link page="/workflowProcessManagement.do?method=viewProcess" paramId="processId" paramName="process" paramProperty="externalId">
		« <bean:message key="link.backToProcess" bundle="WORKFLOW_RESOURCES"/>
	</html:link>
</p>

<logic:empty name="comments">
	<p class="mtop15"><em><bean:message key="label.noComments" bundle="WORKFLOW_RESOURCES"/>.</em></p>
</logic:empty>


<logic:notEmpty name="comments">
	<fr:view name="process" >
		<fr:layout name="viewComments">
			<fr:property name="commentBlockClasses" value="comment"/>
		</fr:layout>
	</fr:view>
</logic:notEmpty>

<bean:define id="processOid" name="process" property="externalId" type="java.lang.String"/>

<fr:form action='<%= "/workflowProcessManagement.do?method=addComment&processId=" + processOid%>'>
	 
	<fr:edit id="comment" name="bean" visible="false"/>

	<table class="form">
		<tr>
			<td>
				<bean:message key="label.addComment" bundle="WORKFLOW_RESOURCES"/>:
			</td>
			<td>
				<fr:edit id="comment-text" name="bean" slot="comment" type="java.lang.String" validator="pt.ist.fenixWebFramework.renderers.validators.RequiredValidator">
					<fr:layout name="longText">
						<fr:property name="rows" value="6"/>
						<fr:property name="columns" value="60"/>
						<fr:property name="classes" value="form"/>
					</fr:layout>
				</fr:edit>
			</td>
		</tr>
			<tr>
			<td>
				<bean:message key="label.notifyPeopleByEmail" bundle="WORKFLOW_RESOURCES"/>:
			</td>
			<td>
				<fr:edit id="peopleToNotify" name="bean" slot="peopleToNotify">
					<fr:layout name="option-select">
						<fr:property name="providerClass" value="module.workflow.presentationTier.renderers.providers.CommentersForProcess"/>
						<fr:property name="eachLayout" value="values"/>
						<fr:property name="eachSchema" value="showUsers"/> 
						<fr:property name="saveOptions" value="true"/>
						<fr:property name="selectAllShown" value="true"/>
						<fr:property name="classes" value="nobullet"/>
					</fr:layout>
				</fr:edit>
			</td>
		</tr>
	</table>
	<html:submit styleClass="inputbutton"><bean:message key="renderers.form.add.name" bundle="RENDERER_RESOURCES"/> </html:submit>
</fr:form>

