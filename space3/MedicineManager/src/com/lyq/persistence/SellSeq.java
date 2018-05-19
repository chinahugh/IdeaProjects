package com.lyq.persistence;

/**
 * ��������ʵ����
 * ���ڷ�װ����ͳ����Ϣ
 *
 * @author Li Yong Qiang
 */
public class SellSeq {
    private String name;        //����
    private Double totalPrice;    //�ܼ�
    private Long totalCount;    //������
    private Integer medId;        //ҩƷid

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }
}
