package zetc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class EmpDAO {

	// DB 연결시  관한 변수 
	private static final String 	   dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
	
	
	private Connection	 		con;	
	
	private  static EmpDAO instance;
	public static EmpDAO	getInstance() throws Exception
	{
		if( instance == null )
		{
			instance = new EmpDAO();
		}
		return instance;
	}
	
	private EmpDAO() throws Exception
	{
			Class.forName( dbDriver );			
	}
	
	/*
	 * 데이타를 입력하는 함수
	 */
	public int insert(EmpVO rec) throws Exception
	{

		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			/********************************************
						SQL 쿼리 확인 
		    */
			String sql		= "INSERT INTO item_review(no, name,  item, content, stars)  VALUES(seq_review_no.nextval,?,?,?,?)";  

			ps		= con.prepareStatement( sql );

			ps.setString	( 1, rec.getName()	);
			ps.setString	( 2, rec.getItem()	);
			ps.setString	( 3, rec.getContent()	);
			ps.setString	( 4, rec.getStars()	);
			
			return ps.executeUpdate();
					
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}	
	}
	
	
	/*
	 *  데이타 목록 전체를 얻어올 때
	 */
	public List<EmpVO> selectList() throws Exception
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmpVO> mList = new ArrayList<EmpVO>();
		boolean isEmpty = true;
		
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			/********************************************
					SQL 쿼리 확인 
			 */
			String sql		= "SELECT no, name, item, content, stars FROM item_review";  
			ps		= con.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next())
			{
				isEmpty = false;
				EmpVO m = new EmpVO();
				
				m.setNo( rs.getString("NO"));
				m.setName(rs.getString("NAME"));
				m.setItem(rs.getString("ITEM"));
				m.setContent(rs.getString("CONTENT"));
				m.setStars(rs.getString("STARS"));
				
				mList.add(m);
			}
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	

}
