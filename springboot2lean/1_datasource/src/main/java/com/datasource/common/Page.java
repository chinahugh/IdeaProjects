package com.datasource.common;


import java.io.Serializable;
import java.util.Arrays;

/**
 * @author HGH
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 184594365144147991L;
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 当前页码
     */
    private int page;
    /**
     * 当前页默认行数
     */
    private int defaultRows;
    /**
     * 当前页行数
     */
    private int currentRows;

    /**
     * 总行数
     */
    private int totalRows;
    /**
     * 总页数
     */
    private int totalPages;

    private Order[] orders;

    public Page() {
        this(0);
    }

    public Page(int totalRows) {
        this(totalRows, DEFAULT_PAGE_SIZE);
    }

    public Page(int totalRows, int defaultRows) {
        this.page = 1;
        this.totalRows = totalRows;
        this.defaultRows = defaultRows > 0 ? defaultRows : DEFAULT_PAGE_SIZE;
        this.totalPages = (this.totalRows % this.defaultRows) == 0
                ? (this.totalRows / this.defaultRows)
                : (this.totalRows / this.defaultRows + 1);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
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
        this.totalPages = (this.totalRows % this.defaultRows) == 0
                ? (this.totalRows / this.defaultRows)
                : (this.totalRows / this.defaultRows + 1);
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

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", defaultRows=" + defaultRows +
                ", currentRows=" + currentRows +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", order=" + Arrays.toString(orders) +
                '}';
    }
}
