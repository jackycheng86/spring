package com.spring.entity;

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
@Table(name = "file", schema = "spring", catalog = "")
public class FileEntity {
    private String fileid;
    private String filename;
    private String filetype;
    private byte[] filedata;

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
    @Column(name = "filedata", nullable = true)
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
                Arrays.equals(filedata, that.filedata);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(fileid, filename, filetype);
        result = 31 * result + Arrays.hashCode(filedata);
        return result;
    }

    /**
     * 将byte数组转为stream
     *
     * @return
     */
    public InputStream getInputStream() {
        if (filedata != null) {
            return new ByteArrayInputStream(filedata);
        }
        return null;
    }
}
