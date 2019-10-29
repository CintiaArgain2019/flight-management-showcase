USE airline;

--
-- Table structure for table `passenger`
--
CREATE TABLE `passenger` (
  `passenger_id` bigint(20) NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `first_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



CREATE TABLE IF NOT EXISTS `passenger_seq` (
  `next_val` bigint(20) DEFAULT NULL
);


CREATE TABLE `flight` (
  `flight_id` bigint(20) NOT NULL,
  `arrival` datetime DEFAULT NULL,
  `departure` datetime DEFAULT NULL,
  `destination` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `flight_number` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `origin` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `status` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`flight_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `flight_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `booking` (
  `booking_id` bigint(20) NOT NULL,
  `arrival` datetime DEFAULT NULL,
  `departure` datetime DEFAULT NULL,
  `flight_id` bigint(20) DEFAULT NULL,
  `passenger_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `booking_id_seq` (
  `next_val` bigint(20) DEFAULT NULL
);
