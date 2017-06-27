/**<pre>
 * 1. Project Name : LotteCardMall
 * 2. Package Name : com.lottecard.mall.cmmn.dao
 * 3. File Name		: CommonDao.java
 * 4. Date				 : 오후 2:14 2015-01-15
 * 5. Author			 : D.G.Youn
 * 6. Note				 :
 * </pre>
 */
package com.ztest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ztest.service.TeamServiceImpl;
import com.ztest.vo.Team;

/**
 * <pre>
 * 공통 Dao
 * 공통 처리 Dao
 * @version 1.0
 * @author H.N.KIM
 * @since 2016. 5. 2. 
 * @see
 * @History
 *  Date          |    author    | 변경내용
 *	2016. 5. 2. |    H.N.KIM  | 신규
 * @Todo
 * </pre>
 */
@Component
public class CommonDao {
//@Component 어노테이션이 적용된 클래스를 검색하여 빈으로 등록하게 된다.
	private static final Logger logger = LoggerFactory.getLogger(CommonDao.class);
	
	// --------------------------------------------------------------------------
	// # sqlSession 설정
	//	 -- DataSource를 두개 쓰므로 @Resource(name="sqlSession") 사용
	//	 -- 하나만 사용할 경우 @Autowired
	// --------------------------------------------------------------------------
	@Resource(name="sqlSessionComm")
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * <pre>
	 * team 리스트조회
	 * @param 
	 * @return List<Team>
	 * @throws Exception
	 * @since 2016. 5. 2. 
	 * @author H.N.KIM
	 * @비고
	 *
	 * </pre>
	 */
	public List<Team> selectTeamList() throws Exception {
		logger.debug("CommonDao/selectTeamList :: START");
		return sqlSession.selectList("CommonMapper.selectTeamList");

	}
	
	/**
	 * <pre>
	 * 트랜잭션 테스트
	 * @param 
	 * @return int
	 * @throws Exception
	 * @since 2016. 7. 11. 
	 * @author H.N.KIM
	 * @비고
	 *
	 * </pre>
	 */
	public int testTransact()throws Exception {
		return sqlSession.insert("CommonMapper.testTransact");
	}
	
	public static void main(String[] args) {
		//http://hyeonstorage.tistory.com/111  -참고
		 	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // url 형식
	        Connection conn = null;//DB연결
	        PreparedStatement pstmt = null;//쿼리전송
	        ResultSet rs = null;//결과값
	        try{
	            Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버 로드
//	            Class.forName("com.mysql.jdbc.Driver") 처럼 특정 클래스를 로딩하면 자동으로 객체가 생성되고 DriverManager에 등록된다.
//	            드라이버 클래스를 찾지 못할 경우 forName() 메소드는 ClassNotFoundException 예외를 발생시키므로 반드시 예외 처리를 해야 한다.
//	            http://javacan.tistory.com/entry/1 - 참고
	            
	            conn = DriverManager.getConnection(url, "test", "khn123"); // 데이터베이스 연결(id/pw)
	            if(conn==null){
	                System.out.println("연결실패");
	            }else{
	                System.out.println("연결성공");
	                // 출력 준비
	                String sql = "		    SELECT T.T_ID AS T_ID"
				+", T.TEAM_NAME AS TEAM_NAME"
				+", M.ID AS ID"
				+", M.NAME AS NAME"
				+", M.AGE AS AGE"
			+" FROM TEAM T "
				+"	 JOIN "
				+"	 MEMBER M" 
				+"	 ON T.T_ID = M.T_ID";
	               
	                pstmt = conn.prepareStatement(sql);
	                rs = pstmt.executeQuery();
	                
	                // 출력
	                while(rs.next()){ // boolean 값을 던짐
	                    String t_id = rs.getString(1); // 바인딩
	                    String team_name = rs.getString(2);
	                    String id = rs.getString(3);
	                    String name = rs.getString(4);
	                    String age = rs.getString(5);
	                    System.out.println(t_id+", "+team_name+", "+id+", "+name+", "+age);
	                }
	            }
	        }catch(ClassNotFoundException ce){
	            ce.printStackTrace();            
	        }catch(SQLException se){
	            se.printStackTrace();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            System.out.println("나 finally");
	            try{ // 연결 해제(한정돼 있으므로)
	                if(rs!=null){        rs.close();            }
	                if(pstmt!=null){    pstmt.close();        }
	                if(conn!=null){    conn.close();        }
	            }catch(SQLException se2){
	                se2.printStackTrace();
	            }            
	        }
	}

}