package com.datasource.common;

import java.io.Serializable;

/**
 * @author HGH
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 184594365144147991L;
    public static final int DEFAULT_PAGE_SIZE = 20;

    //当前页码
    private int page;
    //当前页默认行数
    private int defaultRows;
    //当前页行数
    private int currentRows;

    //总行数
    private int totalRows;
    //总页数
    private int totalPages;


    public Page() {
        this(0, DEFAULT_PAGE_SIZE);
    }

    public Page(int totalRows) {
        this(totalRows, DEFAULT_PAGE_SIZE);
    }

    public Page(int totalRows, int defaultRows) {
        this.totalRows = totalRows;
        this.defaultRows = defaultRows;
        this.totalPages = (this.totalRows % this.defaultRows) == 0
                ? (this.totalRows / this.defaultRows)
                : (this.totalRows / this.defaultRows + 1);
        this.page = 1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        this.totalPages = (this.totalRows % this.defaultRows) == 0
                ? this.totalRows / this.defaultRows
                : (this.totalRows / this.defaultRows) + 1;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;

    }

    public int getCurrentRows() {
        return currentRows;
    }

    public void setCurrentRows(int currentRows) {
        this.currentRows = currentRows;
    }

    public int getDefaultRows() {
        return defaultRows;
    }

    public void setDefaultRows(int defaultRows) {
        this.defaultRows = defaultRows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", defaultRows=" + defaultRows +
                ", currentRows=" + currentRows +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                '}';
    }
}
