package com.bigc.pojo;

/**
 * 分页相关信息
 */

public class Page {
    // 当前页码
    private int current = 1;
    // 显示上限
    private int limit = 10;
    // 数据总数-计算总页数
    private int rows;
    // 查询路径-复用分页链接
    private String path;

    public Page() {
    }

    public Page(int current, int limit, int rows, String path) {
        this.current = current;
        this.limit = limit;
        this.rows = rows;
        this.path = path;
    }

    /**
     * 获取
     * @return current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * 设置
     * @param current
     */
    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    /**
     * 获取
     * @return limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 设置
     * @param limit
     */
    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    /**
     * 获取
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    /**
     * 获取
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

    public String toString() {
        return "Page{current = " + current + ", limit = " + limit + ", rows = " + rows + ", path = " + path + "}";
    }
}
