package com.ajai.studentrecords;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@Repository
public class StudentServiceImpl implements StudentService{
	
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAllStudent() {
		Transaction tx = session.beginTransaction();
		List<Student> sList = session.createQuery("from Student").list();
		tx.commit();
		return sList;
	}

	@Transactional
	public void saveStudent(Student s) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(s);
		tx.commit();
	}

	@Transactional
	public Student searchStudent(int id) {
		Transaction tx = session.beginTransaction();
		Student s = session.get(Student.class, id);
 		tx.commit();
		return s;
	}

	@Transactional
	public void deleteStudent(int id) {
		Transaction tx = session.beginTransaction();
		Student s = session.get(Student.class, id);
		session.delete(s);
 		tx.commit();
	}

	@Transactional
	public List<Student> searchStudentByName(String studentName) {
		Transaction tx = session.beginTransaction();
		String query = "from Student where studentName like '%" + studentName + "%'";
		List<Student> sList = session.createQuery(query).list();
 		tx.commit();		
 		return sList;
	}

}
