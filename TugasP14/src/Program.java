import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    //static Scanner scanner;
	static Connection conn;

    public static void main(String[] args) throws Exception{
        try (Scanner inputan = new Scanner (System.in)){
            String pilihanUser;
            boolean isLanjutkan = true;
            
            String url = "jdbc:mysql://localhost:3306/pbotugas14";
            
            String salamTemu = "     \nWELCOME!!     ";
            String temu = salamTemu.trim(); //method trim()
            System.out.println(temu); 
            
            try (Scanner input = new Scanner(System.in)){
                System.out.println("\nMasukkan Password : ");
                String password1 = input.nextLine();
                String password2="afif2030"; 
                System.out.println("Password " +password1.equals(password2)); //method equals()

                if(password1.equals(password2))
                {
                    System.out.println("\n--------------------------------");
                    System.out.println("PROGRAM KALKULASI GAJI DI PT ABC");
                    System.out.println("--------------------------------");
                }

                    try{
                        TerimaGaji uang = new TerimaGaji();
                        
                        Class.forName("com.mysql.cj.jdbc.Driver");
            	        conn = DriverManager.getConnection(url,"root","");
            	        System.out.println("Class Driver ditemukan!!!");

                        while (isLanjutkan){
                            System.out.println("----------------------");
            		        System.out.println("Database Pegawai");
            		        System.out.println("----------------------");
            		        System.out.println("1. Lihat Data Pegawai");
            		        System.out.println("2. Tambah Data Pegawai");
            		        System.out.println("3. Ubah Data Pegawai");
            		        System.out.println("4. Hapus Data Pegawai");
            		        System.out.println("5. Cari Data Pegawai");
            		
            		        System.out.print("\nPilihan anda (1-5) : ");
            		        pilihanUser = inputan.next();
            		
            		        switch (pilihanUser)
                            {
                                case "1":
            			        uang.show();
            			        break;
            		            case "2":
            			        uang.insert();
            			        break;
            		            case "3":
            			        uang.edit();
            			        break;
            		            case "4":
            			        uang.delete();
            			        break;
            		            case "5":
            			        uang.search();
            			        break;
            		            default:
            			        System.err.println("\nInputan Anda tidak ditemukan.\nSilakan pilih (1-5)");
                            }

                        System.out.print("\nApakah Anda ingin melanjutkan? [y/n]");
            		    pilihanUser = inputan.next();
            		    isLanjutkan = pilihanUser.equalsIgnoreCase("y");
                        }
                    
            	    System.out.println("Program selesai...");
                    }

                catch(ClassNotFoundException ex) 
                {
                    System.err.println("Driver Error");
                    System.exit(0);
                }
                catch(SQLException e)
                {
                    System.err.println("Tidak berhasil koneksi.");
                }
                finally
                {
                    LocalDate tanggalSkrg = LocalDate.now(); 
                    LocalTime waktuSkrg = LocalTime.now();
                    System.out.println("--------------------------------");               
                    System.out.println("Accessed on :");
                    System.out.println("Date\t: "+tanggalSkrg.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
                    System.out.println("Time\t: "+waktuSkrg.format(DateTimeFormatter.ofPattern("hh:mm:ss")) +" WIB");
                     System.out.println("--------------------------------");

                    String salamPisah = "Program selesai. See you later! :)";
                    String pisah = salamPisah.replace("Program selesai.", "Thanks for using this program."); //method replace()
                    System.out.println(pisah);
                }
                
            }
        }             
    }
}