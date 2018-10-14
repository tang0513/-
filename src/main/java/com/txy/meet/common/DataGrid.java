package com.txy.meet.common;



import java.io.Serializable;
import java.util.List;

/**
 * 封装了一个 和页面交互的DataGrid的类
 * @author luqian
 *
 */
public class DataGrid implements Serializable{

	private Long total;
	private List<?> rows;
    
	
	public DataGrid() {
		super();
	}

	public DataGrid(Long total, List<?> rows) {
		super();
		this.total = total;   //分页条数
		this.rows = rows;    //分页数据
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
