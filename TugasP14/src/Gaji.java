import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gaji implements PTABC {
    //static Scanner scanner;
    static Connection conn;
	String url = "jdbc:mysql://localhost:3306/pbotugas14";

    public Integer nomor, jmlHadir, jmlAbsen, level, gajiPokok, potongan, totalGaji;
    public String nama, jabatan;

    Scanner temp = new Scanner(System.in);

    public void show() throws SQLException {
        String judul = "Info Gaji";
        String judulDua = judul.replace("Info Gaji", "INFORMASI DAFTAR GAJI KARYAWAN"); 
        System.out.println(judulDua);
						
		String sql ="SELECT * FROM gaji_karyawan";
		conn = DriverManager.getConnection(url,"root","");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){
			System.out.print("\nNomor Pegawai\t\t : ");
            System.out.print(result.getString("nomor"));
            System.out.print("\nNama Pegawai\t\t : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nGaji Pokok\t\t : ");
            System.out.print(result.getString("gaji_pokok"));
            System.out.print("\nJumlah Hari Masuk\t : ");
            System.out.print(result.getInt("jumlah_hadir"));
            System.out.print("\nPotongan Gaji\t\t : ");
            System.out.print(result.getInt("potongan"));
            System.out.print("\nTotal gaji\t\t : ");
            System.out.print(result.getInt("total_gaji"));
            System.out.print("\n");
		}
	}

    public void insert() throws SQLException {
        String inputan2 = "\nInputkan Data Pegawai.";
		System.out.println(inputan2.toUpperCase());
		
        try {
        // No Pegawai
        System.out.println("Masukkan Nomor Pegawai : ");
        nomor = temp.nextInt();

        // Nama Pegawai
        System.out.println("Masukkan Nama Pegawai : ");
        nama = temp.next();

        // Pilih Jabatan
        System.out.println("Jabatan : ");
        System.out.println("1 >> Director \n2 >> Manager \n3 >> Employee \n4 >> Intern \n5 >> Security");
        System.out.print("Masukkan Nomor Jabatan : ");
        level = temp.nextInt();
        
        if (level == 1)
        {
            jabatan = "Director";
        } 
        else if (level == 2)
        {
            jabatan = "Manager";
        } 
        else if (level == 3)
        {
            jabatan = "Employee";
        } 
        else if (level == 4)
        {
            jabatan = "Intern";
        }
        else if (level == 5)
        {
            jabatan = "Security";
        }
        else
        {
            System.out.println("Jabatan tidak tersedia.");
        }
        
         // Gaji Pokok
        if(level == 1)
        {
            gajiPokok = 75000000;
        }
        else if(level == 2)
        {
            gajiPokok = 45000000;
        } 
        else if (level == 3)
        {
            gajiPokok = 20000000;
        } 
        else if (level == 4)
        {
            gajiPokok = 8000000;
        } 
        else if (level == 5)
        {
            gajiPokok = 5000000;
        }
        else
        {
            System.out.println("\nGaji pokok tidak tersedia.");
        }
        System.out.println("\nGaji pokok : Rp" + gajiPokok);

        // Jumlah Hari Masuk
        System.out.print("Inputkan Jumlah Hadir : ");
        jmlHadir = temp.nextInt();
        
        //potongan
        jmlAbsen = 26 - jmlHadir;
        potongan = jmlAbsen*500000;
        System.out.println("\nPotongan: Rp" +potongan);

        //total gaji
        totalGaji = gajiPokok - potongan;
        System.out.println("Total gaji: Rp" + totalGaji);

        String sql = "INSERT INTO gaji_karyawan (nomor, nama, jabatan, gaji_pokok, jumlah_hadir, potongan, total_gaji) VALUES ('"+nomor+"','"+nama+"','"+jabatan+"','"+gajiPokok+"','"+jmlHadir+"','"+potongan+"','"+totalGaji+"')";
	    conn = DriverManager.getConnection(url,"root","");
	    Statement statement = conn.createStatement();
	    statement.execute(sql);
	    System.out.println("Input Data Berhasil!!");
    }

    catch (SQLException e) {
        System.err.println("Terjadi kesalahan input data.");
    } 
    catch (InputMismatchException e) {
        System.err.println("Inputan harus berupa angka.");
       }
    }

    public void edit() throws SQLException{
        System.out.println("\nEdit Data Pegawai.");

        try{
            show();
            System.out.print("\nMasukkan Nomor Pegawai yang ingin diubah : ");
            Integer nomor = Integer.parseInt(temp.nextLine());
            
            String sql = "SELECT * FROM gaji_karyawan WHERE nomor = " +nomor;
            conn = DriverManager.getConnection(url,"root","");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Nama baru ["+result.getString("nama")+"]\t: ");
                String nama = temp.nextLine();
                   
                sql = "UPDATE gaji_karyawan SET nama='"+nama+"' WHERE nomor='"+nomor+"'";
                //System.out.println(sql);

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Data telah diperbarui (Nomor "+nomor+")");
                }
            }
            statement.close();        
        } 
		catch (SQLException e){
        	System.err.println("Terjadi kesalahan dalam mengedit data.");
            System.err.println(e.getMessage());
        }
	}

    public void delete() {

    }

    public void search() throws SQLException {

    }
}