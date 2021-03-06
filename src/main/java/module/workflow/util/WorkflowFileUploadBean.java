/*
 * @(#)WorkflowFileUploadBean.java
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
package module.workflow.util;

import module.workflow.domain.ProcessFile;
import module.workflow.domain.WorkflowProcess;

import org.fenixedu.bennu.core.util.FileUploadBean;

/**
 * 
 * @author Paulo Abrantes
 * 
 */
public class WorkflowFileUploadBean extends FileUploadBean {

    private WorkflowProcess process;
    private Class<? extends ProcessFile> selectedInstance;
    private boolean instanceLock;
    private String extraArguments;

    public Class<? extends ProcessFile> getSelectedInstance() {
        return selectedInstance;
    }

    public void setSelectedInstance(Class<? extends ProcessFile> selectedInstance) {
        this.selectedInstance = selectedInstance;
    }

    public boolean isInstanceLock() {
        return instanceLock;
    }

    public void setInstanceLock(boolean instanceLock) {
        this.instanceLock = instanceLock;
    }

    public void setProcess(WorkflowProcess process, Class<? extends ProcessFile> selectedInstance) {
        setProcess(process);
        setSelectedInstance(selectedInstance);
        this.instanceLock = true;
    }

    public WorkflowFileUploadBean(WorkflowProcess process) {
        setProcess(process);
        this.instanceLock = false;
        extraArguments = "";
    }

    public <T extends WorkflowProcess> T getProcess() {
        return (T) this.process;
    }

    public void setProcess(WorkflowProcess process) {
        this.process = process;
    }

    /*
     * Tells if this given file type uses the default upload interface (hence
     * only needing the developer to define a schema for it's type) or rather
     * uses a developer defined JSP. If it's the latest case the JSP will be
     * looked under "/" + getClass().getName().replaceAll('.','/') +
     * "-upload.jsp"
     * 
     * By default it returns true
     */
    public boolean isDefaultUploadInterfaceUsed() {
        return true;
    }

    public void setExtraArguments(String extraArguments) {
        if (extraArguments.length() > 0) {
            this.extraArguments = "(" + extraArguments + ")";
        } else {
            this.extraArguments = extraArguments;
        }
    }

    public String getExtraArguments() {
        return extraArguments;
    }

}
