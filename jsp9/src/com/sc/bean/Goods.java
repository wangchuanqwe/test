package com.sc.bean;

public class Goods {
	
	private int gid;       //��Ʒ���
	private String gname;  //��Ʒ���� 
	private float gprice;  //��Ʒ�۸�
	private int buynum;    //��������
	private int gnum;      //�������
	private String gpic;   //��ƷͼƬ
	
	//�޲ι��캯
    //�Զ����ɣ�����Ҽ�->source->generate constructor using fileds
	public Goods() {
		super();
	}

	//ȫ�ι��캯��
	public Goods(int gid, String gname, float gprice, int buynum, int gnum, String gpic) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.buynum = buynum;
		this.gnum = gnum;
		this.gpic = gpic;
	}

	//����set��get����
	//�Զ����ɣ�����Ҽ�->source->generate getters and setters
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
