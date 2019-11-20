package cn.ssh.utils;

import java.util.List;

/**
 *  通用的分页的工具类
 */
public class Page<T> {
    private int currentPage;  //当前页码
    private int pageSize ;   // 每页展示的条数
    private int count;      // 数据的总条数
    private int pageCount;  // 总页数
    private int startIndex;  // 查询的开始下标

    private List<T>  dataList;   // 分页查询后的数据的集合

    public Page(int currentPage, int pageSize, int count) {
       this.pageSize = pageSize;
       this.count = count;
       // 计算总页数
        this.pageCount = (this.count%this.pageSize==0)?(this.count/this.pageSize):(this.count/this.pageSize+1);
        // 判断currentPage是否合法

        if(currentPage>pageCount){
            currentPage = pageCount;
        }
        if(currentPage<=0){
            currentPage=1;
        }
        this.currentPage = currentPage;

        // 计算开始下标
        this.startIndex = (this.currentPage-1)*this.pageSize;
    }

    public Page() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
