package com.lyq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * Hibenrate������
 * ���ڳ�ʼ��Session��������ȡSession����
 * ͨ��ThreadLocal���й���Session
 *
 * @author Li Yong Qiang
 */
public class HibernateFilter implements Filter {
    // ThreadLocal����
    private static ThreadLocal threadLocal = new ThreadLocal();
    // SessionFactory����
    private static SessionFactory factory = null;

    @Override
    public void destroy() {
        if (!factory.isClosed()) {
            factory.close();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } finally {
            Session session = (Session) threadLocal.get();
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
                threadLocal.remove();
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        //��ʼ��SessionFactory
        try {
            Configuration cfg = new Configuration().configure();
            factory = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡSession
     *
     * @return Session
     */
    public static Session getSession() {
        Session session = (Session) threadLocal.get();
        if (session == null) {
            session = factory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
