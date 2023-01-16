-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 08, 2023 lúc 07:51 AM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `lemanh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `iddonhang` int(11) NOT NULL,
  `idsp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `size` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`iddonhang`, `idsp`, `soluong`, `gia`, `size`, `color`) VALUES
(22, 11, 1, '161970000', '', ''),
(22, 12, 1, '30500000', '', ''),
(23, 11, 1, '161970000', '', ''),
(23, 12, 1, '30500000', '', ''),
(24, 11, 1, '161970000', '', ''),
(24, 12, 1, '30500000', '', ''),
(25, 11, 1, '161970000', '', ''),
(26, 27, 1, '23950000', '', ''),
(27, 28, 1, '25499000', '', ''),
(28, 28, 1, '25499000', '', ''),
(29, 28, 1, '25499000', '', ''),
(30, 28, 1, '25499000', '', ''),
(31, 28, 1, '25499000', '', ''),
(32, 28, 1, '25499000', '', ''),
(33, 28, 1, '25499000', '', ''),
(34, 28, 1, '25499000', '', ''),
(35, 28, 1, '25499000', '', ''),
(36, 28, 1, '25499000', '', ''),
(37, 28, 1, '25499000', '', ''),
(38, 28, 1, '25499000', '', ''),
(39, 28, 1, '25499000', '', ''),
(40, 28, 1, '25499000', '', ''),
(41, 28, 1, '25499000', '', ''),
(42, 28, 1, '25499000', '', ''),
(43, 28, 1, '25499000', '', ''),
(44, 28, 1, '25499000', '', ''),
(45, 28, 1, '25499000', '', ''),
(46, 28, 1, '25499000', '', ''),
(47, 28, 1, '25499000', '', ''),
(48, 28, 1, '25499000', '', ''),
(49, 4, 3, '33990000', '', ''),
(50, 4, 3, '33990000', '', ''),
(60, 4, 3, '33990000', '', ''),
(61, 28, 1, '25499000', '', ''),
(64, 28, 1, '25499000', '', ''),
(65, 28, 1, '25499000', '', ''),
(66, 28, 1, '25499000', '', ''),
(67, 28, 1, '25499000', '', ''),
(68, 28, 1, '25499000', '', ''),
(78, 14, 2, '25499000', '', ''),
(78, 7, 1, '15499000', '', ''),
(78, 14, 2, '25499000', '', ''),
(79, 16, 1, '46600000', '', ''),
(79, 13, 1, '23950000', '', ''),
(79, 27, 1, '23950000', '', ''),
(80, 1, 1, '12200000', '', ''),
(81, 27, 1, '23950000', '', ''),
(82, 27, 1, '23950000', '', ''),
(82, 20, 1, '13950000', '', ''),
(83, 27, 1, '23950000', '', ''),
(83, 20, 1, '13950000', '', ''),
(84, 27, 1, '23950000', '', ''),
(84, 25, 1, '53990000', '', ''),
(85, 27, 1, '23950000', '', ''),
(85, 25, 1, '53990000', '', ''),
(85, 2, 1, '46600000', '', ''),
(86, 28, 1, '25499000', '', ''),
(87, 27, 1, '23950000', '', ''),
(88, 20, 6, '13950000', '', ''),
(89, 28, 1, '25499000', '', ''),
(90, 28, 1, '25499000', '', ''),
(91, 28, 1, '25499000', '', ''),
(92, 28, 1, '25499000', '', ''),
(93, 28, 1, '25499000', '', ''),
(94, 28, 1, '25499000', '', ''),
(94, 3, 2, '24280000', '', ''),
(94, 1, 1, '12200000', '', ''),
(94, 2, 1, '46600000', '', ''),
(95, 27, 1, '23950000', '', ''),
(96, 1, 1, '12200000', '', ''),
(97, 27, 1, '23950000', '', ''),
(98, 27, 1, '23950000', '', ''),
(98, 22, 1, '13200000', '', ''),
(98, 20, 1, '13950000', '', ''),
(98, 18, 1, '33990000', '', ''),
(99, 27, 2, '23950000', '', ''),
(100, 11, 2, '53990000', '', ''),
(101, 3, 1, '24280000', '', ''),
(102, 3, 1, '24280000', '', ''),
(103, 27, 1, '23950000', '', ''),
(104, 27, 1, '23950000', '', ''),
(105, 27, 2, '23950000', '', ''),
(105, 25, 2, '53990000', '', ''),
(105, 24, 2, '34280000', '', ''),
(106, 25, 1, '53990000', '', ''),
(107, 25, 1, '53990000', '', ''),
(108, 27, 1, '23950000', '', ''),
(109, 27, 1, '23950000', '', ''),
(110, 27, 1, '23950000', '', ''),
(111, 27, 1, '23950000', '', ''),
(112, 27, 1, '23950000', '', ''),
(113, 27, 1, '23950000', '', ''),
(114, 27, 1, '23950000', '', ''),
(115, 25, 1, '53990000', '', ''),
(117, 24, 4, '34280000', '', ''),
(117, 16, 4, '46600000', '', ''),
(117, 8, 3, '13200000', '', ''),
(118, 24, 4, '34280000', '', ''),
(118, 16, 4, '46600000', '', ''),
(118, 8, 3, '13200000', '', ''),
(119, 24, 4, '34280000', '', ''),
(119, 16, 4, '46600000', '', ''),
(119, 8, 3, '13200000', '', ''),
(120, 24, 4, '34280000', '', ''),
(120, 16, 4, '46600000', '', ''),
(120, 8, 3, '13200000', '', ''),
(123, 25, 1, '53990000', '', ''),
(123, 25, 1, '53990000', '', ''),
(123, 25, 1, '53990000', '', ''),
(124, 25, 1, '53990000', '', ''),
(124, 25, 1, '53990000', '', ''),
(124, 25, 1, '53990000', '', ''),
(125, 25, 1, '53990000', '', ''),
(125, 25, 1, '53990000', '', ''),
(125, 25, 1, '53990000', '', ''),
(126, 25, 3, '53990000', '', ''),
(126, 4, 1, '33990000', '', ''),
(126, 15, 1, '12200000', '', ''),
(127, 27, 1, '23950000', '', ''),
(128, 6, 1, '13950000', '', ''),
(128, 27, 1, '23950000', '', ''),
(129, 6, 1, '13950000', '', ''),
(129, 27, 1, '23950000', '', ''),
(129, 25, 1, '53990000', '', ''),
(129, 27, 1, '23950000', '', ''),
(129, 23, 1, '56600000', '', ''),
(129, 24, 1, '34280000', '', ''),
(129, 20, 1, '13950000', '', ''),
(130, 10, 5, '171400000', '', ''),
(131, 24, 5, '34280000', '', ''),
(131, 20, 1, '13950000', '', ''),
(131, 25, 1, '53990000', '', ''),
(132, 20, 1, '13950000', '', ''),
(132, 10, 1, '34280000', '', ''),
(133, 27, 1, '23950000', '', ''),
(133, 23, 1, '56600000', '', ''),
(134, 4, 1, '33990000', '', ''),
(134, 6, 1, '13950000', '', ''),
(135, 43, 2, '446', '', ''),
(136, 43, 2, '446', '', ''),
(137, 43, 2, '446', '', ''),
(138, 43, 2, '446', '', ''),
(139, 43, 2, '446', '', ''),
(140, 43, 2, '446', '', ''),
(141, 43, 2, '446', '', ''),
(142, 43, 2, '446', '', ''),
(143, 43, 2, '446', '', ''),
(144, 45, 1, '34', '', ''),
(144, 44, 1, '223', '', ''),
(144, 43, 1, '223', '', ''),
(145, 45, 1, '34', '', ''),
(145, 44, 1, '223', '', ''),
(146, 45, 2, '68', '', ''),
(154, 45, 1, '34', 'XL', 'Màu xám'),
(155, 45, 1, '34', 'XL', 'Màu xám'),
(156, 45, 1, '34', 'XL', 'Màu xám'),
(156, 46, 1, '345', 'M', 'Màu đỏ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `diachi` text COLLATE utf8_unicode_ci NOT NULL,
  `sodienthoai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `tongtien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `iduser`, `diachi`, `sodienthoai`, `email`, `soluong`, `tongtien`, `trangthai`) VALUES
(155, 15, 'vhffgg', '0123456789', 'name@gmail.com', 1, '34', 0),
(156, 15, 'gfghh', '0123456789', 'name@gmail.com', 2, '379', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `hinhanh`) VALUES
(1, 'Trang chủ', 'https://simg.nicepng.com/png/small/13-131873_home-icons-png-transparent-home-icon-green-png.png'),
(2, 'Điện thoại', 'https://png.pngtree.com/png-vector/20210303/ourmid/pngtree-mobile-phone-png-smartphone-camera-mockup-png-image_3009170.jpg'),
(3, 'LapTop', 'https://png.pngtree.com/png-vector/20191026/ourmid/pngtree-laptop-icon-png-image_1871608.jpg'),
(4, 'Đơn hàng', 'https://muicamau.vn/wp-content/uploads/2019/05/don-hang.jpg'),
(5, 'Thông tin', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB58u7avqp-FJaggI87xctKv4VIey3O_jb5Q&usqp=CAU');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanphammoi`
--

CREATE TABLE `sanphammoi` (
  `id` int(11) NOT NULL,
  `tensp` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `giasp` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh` text COLLATE utf8_unicode_ci NOT NULL,
  `mota` text COLLATE utf8_unicode_ci NOT NULL,
  `loai` int(2) NOT NULL,
  `size` text CHARACTER SET utf8 NOT NULL,
  `color` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanphammoi`
--

INSERT INTO `sanphammoi` (`id`, `tensp`, `giasp`, `hinhanh`, `mota`, `loai`, `size`, `color`) VALUES
(42, 'gsghjh', '12', '42.jpg', 'dhgggg', 1, 'L, XL, XXL', 'Màu đỏ, Màu tím, Màu xám'),
(43, 'spuuuu', '223', '43.jpg', 'gfdghh', 2, 'L, XL, XXL', 'Màu tím, Màu xám, Màu trắng, Màu đen, Màu nâu'),
(44, 'spuuuu', '223', '43.jpg', 'gfdghh', 2, 'L, XL, XXL', 'Màu tím, Màu xám, Màu trắng, Màu đen, Màu nâu'),
(45, 'hhhhhhh', '34', '45.jpg', 'ghfggfgg', 1, 'XL, L, M', 'Màu xám, Màu trắng, Màu đen'),
(46, 'sach', '345', '46.jpg', 'jgfyt fyg', 1, 'M', 'Màu đỏ, Màu tím');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mobile` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `uid` text COLLATE utf8_unicode_ci NOT NULL,
  `token` text COLLATE utf8_unicode_ci NOT NULL,
  `status` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `pass`, `username`, `mobile`, `uid`, `token`, `status`) VALUES
(15, 'name@gmail.com', '123456', 'name', '0123456789', 'RvY0yQkwflbhHxSjt4dfDCNhyY92', 'dYuuMDZhSmm92u0q2Q7WiA:APA91bFq11gHLkHo7GnxCUxu5qJcXjFAsOh3ftbqlE-6YHyjBrApJBaM4-oiiuoU0_Xj71tggTw3g06FbMvvzpGHqG3Fj9YLmSHJgoYhY-DVeCYZQLty0BfXm_76OXc6s3-R4vVMclSJ', 0),
(16, 'user@gmail.com', '123456', 'user', '0123456789', 'wtqhYvjsNPVQOOi8Ay9S8VcP2Zw2', 'fXLA2Xb2SoCcfzcQyobn8P:APA91bEZi1EiNy6VwI7XMmE88DiGtYjvTg5-DDrDCdd78gJIugrXl1NDaPtVl2Y1c0XlDzrWClq4oCOGwBqAq3UVkf-71mBeS7KzC4CWlX2g9Nr8K33H67KpsNT0Lt5_2EtIlljU2TWa', 0),
(17, 'manhitdz@gmail.com', '123456', 'manh', '0123456789', 'Spm2PttHKLStrTFNVgVoN6i0c1y1', 'd1K2DeXtSWyazgKEc9wXKz:APA91bF0CrRMXssuPyGBcjIn6BU_bvLfOvBd-Jks_GAt_r1uYyPbvWjGkbJXg1THJaPvzAvNB7QkI8iT73uvy-z9KzitqbXCC9qwOjm4YLUx3rQhrVR9bZyBDAnO6OV8etnUggP6ONnz', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=157;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT cho bảng `sanphammoi`
--
ALTER TABLE `sanphammoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
