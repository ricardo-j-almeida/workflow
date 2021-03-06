/*
 * @(#)IsActiveActivityTag.java
 *
 * Copyright 2009 Instituto Superior Tecnico
 * Founding Authors: Luis Cruz, Paulo Abrantes
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Case Handleing Based Workflow Module.
 *
 *   The Case Handleing Based Workflow Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The Workflow Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Workflow Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package module.workflow.presentationTier.taglib;

import javax.servlet.jsp.JspException;

import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import module.workflow.domain.WorkflowProcess;

/**
 * 
 * @author Paulo Abrantes
 * 
 */
public class IsActiveActivityTag extends WorkflowBodyTag {

    @Override
    public int doStartTag() throws JspException {
        WorkflowActivity<WorkflowProcess, ActivityInformation<WorkflowProcess>> activity = getActivity();
        return activity != null && activity.isActive(getWorkflowProcess()) ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }
}
