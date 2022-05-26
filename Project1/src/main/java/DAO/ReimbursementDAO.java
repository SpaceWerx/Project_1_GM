package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Reimbursement;
import Models.Status;
import Models.Type;
import Utilities.ConnectionFactory;

public class ReimbursementDAO {

		public List<Reimbursement> getReimbursementById(int id) {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from ers_reimbursements where id = ?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, id);
				
				rs = ps.executeQuery();
				
				List<Reimbursement> reimbursementList = new ArrayList<>();
				
				while(rs.next()) {
					Reimbursement r = new Reimbursement(
							rs.getInt("id"),
							rs.getInt("author"),
							rs.getInt("resolver"),
							rs.getString("descirption"),
							rs.getDouble("amount"),
							Status.valueOf(rs.getString("status")),
							Type.valueOf(rs.getString("type"))
							);
							
							reimbursementList.add(r);
							
						
				}
				return reimbursementList;
				
			} catch (SQLException e) {
				System.out.println("Something went wrong with the database!");
				e.printStackTrace();
				return null;
			}
		
		}
		public List<Reimbursement> getReimbursementsByUser (int userId){
			
			try (Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from ers_reimbursements where author = ?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, userId);
				
				rs = ps.executeQuery();
				
			 List<Reimbursement> reimbursementList = new ArrayList<>();
				
			while(rs.next()) {
				Reimbursement r = new Reimbursement(
						rs.getInt("id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("descirption"),
						rs.getDouble("amount"),
						Status.valueOf(rs.getString("status")),
						Type.valueOf(rs.getString("type"))
						);
						
						reimbursementList.add(r);
				
			}
				return reimbursementList;
				
			} catch (SQLException e) {
				System.out.println("Something went wrong with obtaining the list");
				e.printStackTrace();
				
			}
			return null;
		}
		public List<Reimbursement> getByStatus (Status status){
			
			try (Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from ers_reimbursements where status = ?::status";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1,status.toString());
				
				rs = ps.executeQuery();
				
			 List<Reimbursement> reimbursementList = new ArrayList<>();
				
			while(rs.next()) {
				Reimbursement r = new Reimbursement(
						rs.getInt("id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("descirption"),
						rs.getDouble("amount"),
						Status.valueOf(rs.getString("status")),
						Type.valueOf(rs.getString("type"))
						);
						
						reimbursementList.add(r);
				
			}
				return reimbursementList;
				
			} catch (SQLException e) {
				System.out.println("Something went wrong with obtaining the reimbursements!");
				e.printStackTrace();
				
			}
			return null;
		}
		
		public List<Reimbursement> getAllREimbrusements(){
			
			try (Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from ers_reimbursements";
				
				Statement s = conn.createStatement();
				
				rs = s.executeQuery(sql);
				
			 List<Reimbursement> reimbursementList = new ArrayList<>();
				
			while(rs.next()) {
				Reimbursement r = new Reimbursement(
						rs.getInt("id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("descirption"),
						rs.getDouble("amount"),
						Status.valueOf(rs.getString("status")),
						Type.valueOf(rs.getString("type"))
						);
						
						reimbursementList.add(r);
				
			}
				return reimbursementList;
				
			} catch (SQLException e) {
				System.out.println("Something went wrong with obtaining the database");
				e.printStackTrace();
				
			}
			return null;
		}
		
		public int create(Reimbursement reimbursementToBeSubmitted){
			
			try (Connection conn = ConnectionFactory.getConnection()){
				
				
				String sql = "INSERT INTO ers_reimbursements (author, description, type, status, amount)"
						+ "VALUES (?, ?, ?:: type, ?::status,?)"
						+ "RETURNING ers_reimbursements.id";
								
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, reimbursementToBeSubmitted.getAuthor());
				ps.setString(2, reimbursementToBeSubmitted.getDescription());
				ps.setObject(3, reimbursementToBeSubmitted.getType().name());
				ps.setObject(4, reimbursementToBeSubmitted.getStatus().name());
				ps.setDouble(5, reimbursementToBeSubmitted.getAmount());
				
				ResultSet rs;
				
				if((rs = ps.executeQuery()) !=null) {
					
					rs.next();
					
					return rs.getInt(1);
				}
									
			} catch (SQLException e) {
				System.out.println("Creating reimbursement has failed");
				e.printStackTrace();
				
			}
			return 0;
		}
		
		public void update(Reimbursement unprocessedReimbursement){
			
			try (Connection conn = ConnectionFactory.getConnection()){
				
				
				String sql = "UPDATE ers_reimbursements SET resolver = ?, status =?::status WHERE id =?";
								
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, unprocessedReimbursement.getResolver());
				ps.setObject(2, unprocessedReimbursement.getStatus().name());
				ps.setInt(3, unprocessedReimbursement.getID());
				
				ps.executeUpdate();
				
				System.out.println("Reimbursement Successfully Updated!");
				
									
			} catch (SQLException e) {
				System.out.println("Updating Failed!");
				e.printStackTrace();
			}
		}
}
