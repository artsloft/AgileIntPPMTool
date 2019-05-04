package com.elastitrader.ppmtool.exceptions;

public class ProjectIdExceptionRespone {
    private String projectIdentifier;

    public ProjectIdExceptionRespone(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
