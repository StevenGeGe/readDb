package com.hy.model.taskFile;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/5/28 18:46
 * @Version 1.0
 * @PACKAGE_NAME : com.hy.model.taskFile
 **/
public class TaskFile {

    private String id;
    private String foId;
    private Timestamp fst;
    private Timestamp lmt;
    private String loId;
    private String project_id;
    private Blob task_file_content;
    private String task_file_name;
    private String task_file_state;

    public TaskFile() {
        super();
    }

    public TaskFile(String id, String foId, Timestamp fst, Timestamp lmt, String loId, String project_id, Blob task_file_content, String task_file_name, String task_file_state) {
        this.id = id;
        this.foId = foId;
        this.fst = fst;
        this.lmt = lmt;
        this.loId = loId;
        this.project_id = project_id;
        this.task_file_content = task_file_content;
        this.task_file_name = task_file_name;
        this.task_file_state = task_file_state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoId() {
        return foId;
    }

    public void setFoId(String foId) {
        this.foId = foId;
    }

    public Timestamp getFst() {
        return fst;
    }

    public void setFst(Timestamp fst) {
        this.fst = fst;
    }

    public Timestamp getLmt() {
        return lmt;
    }

    public void setLmt(Timestamp lmt) {
        this.lmt = lmt;
    }

    public String getLoId() {
        return loId;
    }

    public void setLoId(String loId) {
        this.loId = loId;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Blob getTask_file_content() {
        return task_file_content;
    }

    public void setTask_file_content(Blob task_file_content) {
        this.task_file_content = task_file_content;
    }

    public String getTask_file_name() {
        return task_file_name;
    }

    public void setTask_file_name(String task_file_name) {
        this.task_file_name = task_file_name;
    }

    public String getTask_file_state() {
        return task_file_state;
    }

    public void setTask_file_state(String task_file_state) {
        this.task_file_state = task_file_state;
    }
}
