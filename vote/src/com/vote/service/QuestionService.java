package com.vote.service;

import com.vote.bean.Question;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class QuestionService {
	public List<Question> litQuesByOid(int oid) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		List<Question> quesList = new LinkedList();
		String sql = "select seq,content,qtype from wj_question where oid='"
				+ oid + "' order by seq asc";
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Question ques = new Question();
				int seq = rs.getInt("seq");
				int qtype = rs.getInt("qtype");
				String content = rs.getString("content");
				ques.setContent(content);
				ques.setSeq(seq);
				ques.setQtype(qtype);
				quesList.add(ques);
			}
			return quesList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
	}

	public int addQues(int oid, String content, int qtype, int seq) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "insert into wj_question(oid,content,qtype,seq) values('"
				+ oid + "','" + content + "','" + qtype + "','" + seq + "')";
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			int i = stm.executeUpdate(sql);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
	}

	public int updateQuesOrder(int oid, int seq) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "update wj_question set seq=(seq + 1) where oid = '" + oid
				+ "'and seq > '" + seq + "'";
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			int i = stm.executeUpdate(sql);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
	}

	public Question getQuesBySeq(int seq, int oid) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Question ques = new Question();
		String sql = "select content,qtype from wj_question where oid = '"
				+ oid + "' and seq = '" + seq + "'";
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				String content = rs.getString("content");
				int qtype = rs.getInt("qtype");
				ques.setContent(content);
				ques.setQtype(qtype);
			}
			return ques;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
	}

	public int deleteQues(int seq, int oid) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "delete  from wj_question where oid=" + oid
				+ " and seq = " + seq;
		System.out.println(sql);
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			count = stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
		return count;
	}

	public int updateQseq(int seq, int oid) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "update wj_question set seq=(seq-1) where oid = " + oid
				+ " and seq > " + seq;
		System.out.println(sql);
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			count = stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
		return count;
	}

	public int getQuesCount(int oid) {
		DBConnection dbcon = null;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		int qcount = 0;
		try {
			dbcon = new DBConnection();
			con = dbcon.getConnection();
			stm = con.createStatement();
			String sql = "select count(*) from wj_question where oid=" + oid;
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				qcount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeAll(con, stm, rs);
		}
		System.out.println("问题的总数" + qcount);
		return qcount;
	}
}
