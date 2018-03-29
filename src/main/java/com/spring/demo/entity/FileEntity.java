package com.spring.demo.entity;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

/**
 * com.spring.entity
 *
 * @author jacky
 * 2017/12/23
 **/
@Entity
@Table(name = "file")
public class FileEntity {
    private String fileid;
    private String filename;
    private String filetype;
    private String fileext;
    private byte[] filedata;

    public FileEntity() {
    }

    public FileEntity(String fileid, String filename, String filetype, String fileext) {
        this.fileid = fileid;
        this.filename = filename;
        this.filetype = filetype;
        this.fileext = fileext;
    }

    public FileEntity(String fileid, String filename, String filetype, String fileext, byte[] filedata) {
        this.fileid = fileid;
        this.filename = filename;
        this.filetype = filetype;
        this.fileext = fileext;
        this.filedata = filedata;
    }

    @Id
    @Column(name = "fileid", nullable = false, length = 50)
    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    @Basic
    @Column(name = "filename", nullable = false, length = 200)
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    @Basic
    @Column(name = "filetype", nullable = false, length = 50)
    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    @Basic
    @Column(name = "fileext", nullable = false, length = 50)
    public String getFileext() {
        return fileext;
    }

    public void setFileext(String fileext) {
        this.fileext = fileext;
    }

    @Basic
    @Lob
    @Column(name = "filedata", columnDefinition = "BLOB", nullable = true)
    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileEntity that = (FileEntity) o;
        return Objects.equals(fileid, that.fileid) &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(filetype, that.filetype) &&
                Objects.equals(fileext, that.fileext) &&
                Arrays.equals(filedata, that.filedata);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(fileid, filename, filetype, fileext);
        result = 31 * result + Arrays.hashCode(filedata);
        return result;
    }

    /**
     * 将byte数组转为stream
     *
     * @return
     */
    @Transient
    public InputStream getInputStream() {
        if (filedata != null) {
            return new ByteArrayInputStream(filedata);
        }
        return null;
    }
}
