-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2021 at 04:39 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbotugas14`
--

-- --------------------------------------------------------

--
-- Table structure for table `gaji_karyawan`
--

CREATE TABLE `gaji_karyawan` (
  `nomor` int(100) NOT NULL,
  `nama` char(100) NOT NULL,
  `jabatan` char(100) NOT NULL,
  `gaji_pokok` int(100) NOT NULL,
  `jumlah_hadir` int(100) NOT NULL,
  `potongan` int(100) NOT NULL,
  `total_gaji` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gaji_karyawan`
--

INSERT INTO `gaji_karyawan` (`nomor`, `nama`, `jabatan`, `gaji_pokok`, `jumlah_hadir`, `potongan`, `total_gaji`) VALUES
(1112553, 'afif', 'Director', 75000000, 25, 500000, 74500000),
(2436622, 'dede', 'Manager', 45000000, 10, 8000000, 37000000),
(1345353, 'icat', 'Employee', 20000000, 26, 0, 20000000),
(1367748, 'biyan', 'Employee', 20000000, 21, 2500000, 17500000),
(748333, 'erlangga', 'Intern', 8000000, 15, 5500000, 2500000),
(73992, 'fatih', 'Security', 5000000, 23, 1500000, 3500000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
