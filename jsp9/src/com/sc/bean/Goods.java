package com.sc.bean;

public class Goods {
	
	private int gid;       //商品编号
	private String gname;  //商品名称 
	private float gprice;  //商品价格
	private int buynum;    //够买数量
	private int gnum;      //库存数量
	private String gpic;   //商品图片
	
	//无参构造函
    //自动生成：鼠标右键->source->generate constructor using fileds
	public Goods() {
		super();
	}

	//全参构造函数
	public Goods(int gid, String gname, float gprice, int buynum, int gnum, String gpic) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.buynum = buynum;
		this.gnum = gnum;
		this.gpic = gpic;
	}

	//生成set、get方法
	//自动生成：鼠标右键->source->generate getters and setters
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public float getGprice() {
		return gprice;
	}

	public void setGprice(float gprice) {
		this.gprice = gprice;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public String getGpic() {
		return gpic;
	}

	public void setGpic(String gpic) {
		this.gpic = gpic;
	}
	
	
	

}
