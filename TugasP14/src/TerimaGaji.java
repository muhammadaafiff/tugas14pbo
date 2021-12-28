import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TerimaGaji extends Gaji {
    static Connection conn;
	String url = "jdbc:mysql://localhost:3306/pbotugas14";

    public void delete() {
        System.out.println("\nHapus Data Pegawai.");
		
		try{
	        show();
            System.out.print("\nInput Nomor Pegawai : ");
            String keyword = temp.nextLine();
	        
	        String sql = "DELETE FROM gaji_karyawan WHERE nomor LIKE '%"+keyword+"%'";
	        conn = DriverManager.getConnection(url,"root","");
	        Statement statement = conn.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Data pegawai berhasil dihapus. (Nomor "+nomor+")");
	        }
	   }
		catch(SQLException e){
	        System.out.println("Terjadi kesalahan dalam menghapus data.");
	    }
        catch(Exception e){
            System.out.println("Input data yang benar!");
        }
	}

    public void search() throws SQLException {
        System.out.println("\nCari Data Pegawai.");
				
		System.out.print("Input nama pegawai : ");    
		String keyword = temp.nextLine();
		
		String sql = "SELECT * FROM gaji_karyawan WHERE nama LIKE '%"+keyword+"%'";
		conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
            System.out.print("\nNomor Pegawai\t\t : ");
            System.out.print(result.getInt("nomor"));
            System.out.print("\nNama Pegawai\t\t : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nJabatan\t\t\t : ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nGaji Pokok\t\t : ");
            System.out.print(result.getInt("gaji_pokok"));
            System.out.print("\nJumlah Hari Masuk\t : ");
            System.out.print(result.getInt("jumlah_hadir"));
            System.out.print("\nPotongan Gaji\t\t : ");
            System.out.print(result.getInt("potongan"));
            System.out.print("\nTotal gaji\t\t : ");
            System.out.print(result.getInt("total_gaji"));
            System.out.print("\n");
	    }   
    }
}