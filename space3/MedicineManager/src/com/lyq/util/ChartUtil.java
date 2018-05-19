package com.lyq.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.text.NumberFormat;
import java.util.List;

/**
 * �Զ�����ͼ�����࣬����������ͼ����
 *
 * @author Li Yong Qiang
 */
public class ChartUtil {
    /**
     * ����List���ϴ���һ������ͼ
     *
     * @param list List����
     * @return JFreeChart����
     */
    public JFreeChart categoryChart(List list) {
        JFreeChart chart = null;
        if (list != null && list.size() > 0) {
            // ��������ͼ�����ݼ���
            DefaultPieDataset dataset = new DefaultPieDataset();
            // �����ݼ������������
            for (int i = 0; i < list.size(); i++) {
                Object[] objs = (Object[]) list.get(i);
                dataset.setValue(objs[0].toString(), (Number) objs[1]);
            }
            chart = ChartFactory.createPieChart3D(
                    "ҩƷ���ͳ��",    // ͼ��ı���
                    dataset,            // ����ͼ�����ݼ�����
                    true,                // �Ƿ���ʾͼ��
                    true,                // �Ƿ���ʾ��ʾ�ı�
                    false);                // �Ƿ����ɳ�����
            //���ñ�������
            chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
            //����ͼ���������
            chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
            // ��û�ͼ������
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setForegroundAlpha(0.5f);    // ����ǰ��͸����
            // ���÷����ǩ������
            plot.setLabelFont(new Font("����", Font.PLAIN, 12));
            plot.setCircular(true);    // ���ñ���Ϊ��Բ
            // ���÷����ǩ�ĸ�ʽ
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={2}",
                    NumberFormat.getNumberInstance(),
                    NumberFormat.getPercentInstance()));
        }
        return chart;
    }
}
