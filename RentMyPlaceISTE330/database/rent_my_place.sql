DROP DATABASE IF EXISTS rent_my_place;
CREATE DATABASE rent_my_place;
USE rent_my_place;

START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rent_my_place`
--
-- --------------------------------------------------------
--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `id` int(11) NOT NULL,
  `billingAddress` varchar(255) NOT NULL,
  `creditCardNum` varchar(255) NOT NULL,
  `CVC` varchar(3) NOT NULL,
  `expireDate` date NOT NULL,
  `ownerName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `billing` (`id`, `billingAddress`, `creditCardNum`, `CVC`, `expireDate`, `ownerName`) VALUES
(1, 'Damira Tomljanovica Gavrana 13, Zagreb', 1234123412341234, 123, '2022-04-04', 'Herbie Jefferson'),
(2, 'Avenija Dubrovnik 30, Zagreb', 7894789478947894, 789, '2024-07-08', 'Mia Wong'),
(3, 'Ul. Frana Supila 15, Split', 5623562356235623, 589, '2021-02-06', 'Jackie Meldrum'),
(4, 'Ul. Krste Frankopana 6, Bjelovar', 4561456145614561, 789, '2025-06-06', 'Peter Stanbrige'),
(5, 'Ilica 50, Zagreb', 2358235823582358, 745, '2023-07-09', 'Desiree Burch');

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `locationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `contact` (`id`, `fullName`, `email`, `phone`, `locationId`) VALUES
(1, 'Herbie Jefferson', 'herbieJ@gmail.com', 0993333333, 1),
(2, 'Mia Wong', 'mia_wong@mail.com', 0987777777, 2),
(3, 'Jackie Meldrum', 'jackie@hotmail.com', 0912222888, 3),
(4, 'Peter Stanbrige', 'peter.stanbrige@mail.com', 0971111222, 4 ),
(5,  'Desiree Burch',  'desireeBurch@hotmail.com', 0918888888, 5);

--
-- Table structure for table `favorite`
--

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `propertyId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `favorite` (`id`, `userId`, `propertyId`) VALUES
(1, 1, 2),
(2, 1, 5),
(3, 3, 10),
(4, 4, 5),
(5, 2, 6),
(6, 5, 7);

--
-- Table structure for table `feature`
--

CREATE TABLE `feature` (
  `id` int(11) NOT NULL,
  `feature` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `feature` (`id`, `feature`) VALUES
(1, 'Parking'),
(2, 'Wi-fi'),
(3, 'Jacuzzi'),
(4, 'Room service '),
(5, 'Smoking room'),
(6, 'Pet friendly'),
(7, 'Air conditioning'),
(8, 'Swimming pool');

--
-- Table structure for table `feature_property`
--

CREATE TABLE `feature_property` (
  `propertyId` int(11) NOT NULL,
  `featureId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `feature_property` (`propertyId`, `featureId`) VALUES
(1, 5),
(2, 3),
(3, 6),
(4, 8),
(5, 1),
(6, 4),
(7, 3),
(8, 2),
(9, 6),
(10, 7);

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `zip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `street`, `city`, `zip`) VALUES
(1, 'Damira Tomljanovica 15', 'Zagreb', 10000),
(2, 'Obala kneza Branimira 5', 'Split', 21000),
(3, 'Ulica sv. Petra 10', 'Pula', 52100),
(4, 'Ul. Ante Starcevica 5', 'Makarska', 21300),
(5, 'Obala kneza Trpimira 4', 'Zadar', 23000),
(6, 'Ul. don Frana Bulica 6', 'Dubrovnik', 20000),
(7, 'Ul. Josipa Lovretica','Vinkovci',32100),
(8, 'Vukovarska ulica 8', 'Bjelovar', 43000),
(9, 'Optujska ulica 50', 'Varazdin', 42000),
(10, 'Ilica 50', 'Zagreb', 10000);

--
-- Table structure for table `property`
--

CREATE TABLE `property` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `locationId` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `propertyTypeId` int(11) NOT NULL,
  `imagePath` varchar(255) NOT NULL,
  `bedrooms` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `pricePerNight` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `property`
--

INSERT INTO `property` (`id`, `userId`, `locationId`, `description`, `propertyTypeId`, `imagePath`, `bedrooms`, `size`, `pricePerNight`) VALUES
(1, 1, 1, 'Bundek Office, just accross Bundek park.', 5, 'https://images.unsplash.com/photo-1497215728101-856f4ea42174?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 10, 600, 1100.00),
(2, 2, 7, 'A beautiful place to get some rest in the nature.', 6, 'https://images.unsplash.com/photo-1599601482482-93c2cd0460d5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=80', 2, 100, 199.99),
(3, 1, 8, 'Exclusive property for a very low price.', 2, 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 10, 500, 599.99),
(4, 1, 2, 'Beautiful property with a view to the sea.', 3, 'https://images.unsplash.com/photo-1564501049412-61c2a3083791?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1189&q=80', 5, 200, 300.00),
(5, 3, 5, 'Gorgeous property by the sea side, ideal for vacation.', 1, 'https://images.unsplash.com/photo-1575517111478-7f6afd0973db?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 9, 400, 799.99),
(6, 4, 9, 'Cozy rental property ideal for families.', 1, 'https://images.unsplash.com/photo-1554995207-c18c203602cb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 3, 150, 180.99),
(7, 1, 3, 'Luxury property ideal for vacation.', 3, 'https://images.unsplash.com/photo-1512917774080-9991f1c4c750?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 8, 500, 1099.00),
(8, 5, 4, 'Enjoy by the sea in this extraordinary property.', 6, 'https://images.unsplash.com/photo-1613912836585-0f5a284738f6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 6, 220, 799.99),
(9, 3, 6, 'Gorgeous office ideal for big companies.', 5, 'https://images.unsplash.com/photo-1556761175-4b46a572b786?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=967&q=80', 100, 2000, 2299.99),
(10, 4, 10, 'Find a place to park in crowded Zagreb.', 4, 'https://images.unsplash.com/photo-1614704181758-fe7e61c75375?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 1, 10, 120.00);

--
-- Table structure for table `propertytype`
--

CREATE TABLE `property_type` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `property_type` (`id`, `type`) VALUES
(1, 'house'),
(2, 'apartment'),
(3, 'villa'),
(4, 'garage'),
(5, 'office'),
(6, 'vacation home');

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `propertyId` int(11) NOT NULL,
  `arrivalDate` date NOT NULL,
  `departureDate` date NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `reservations` (`id`, `userId`, `propertyId`, `arrivalDate`, `departureDate`, `price`) VALUES
(1, 1, 5, '2021-03-03', '2021-03-10', 2000.00);

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userType` varchar(1) NOT NULL,
  `contactId` int(255) NOT NULL,
  `billingId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `username`, `password`, `userType`, `contactId`, `billingId`) VALUES
(1, 'ime', '8aa87050051efe26091a13dbfdf901c6', 'a', 1, 1),
(2, 'user123', '827ccb0eea8a706c4c34a16891f84e7b', 'u', 2, 2),
(3, 'someUser', '32250170a0dca92d53ec9624f336ca24', 'u', 3, 3),
(4, 'anotherUser', '4f351e69c91975f5532533db26492bd7', 'a', 4, 4),
(5, 'aUser', 'c54a16ca8fa833f9d23dbba08f617243', 'u', 5, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Contact_fk0` (`locationId`);

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY(`id`),
  ADD KEY `Favorite_fk0` (`userId`),
  ADD KEY `Favorite_fk1` (`propertyId`);

--
-- Indexes for table `feature`
--
ALTER TABLE `feature`
  ADD PRIMARY KEY (`id`);

  --
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `featureproperty`
--
ALTER TABLE `feature_property`
  ADD KEY `FeatureProperty_fk0` (`propertyId`),
  ADD KEY `FeatureProperty_fk1` (`featureId`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Property_fk0` (`userId`);

--
-- Indexes for table `propertytype`
--
ALTER TABLE `property_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD KEY `Reservations_fk0` (`userId`),
  ADD KEY `Reservations_fk1` (`propertyId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `User_fk0` (`contactId`),
  ADD KEY `User_fk1` (`billingId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feature`
--
ALTER TABLE `feature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `property`
--
ALTER TABLE `property`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT for table `propertytype`
--
ALTER TABLE `property_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `Contact_fk0` FOREIGN KEY (`locationId`) REFERENCES `location` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `Favorite_fk0` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)  ON DELETE CASCADE,
  ADD CONSTRAINT `Favorite_fk1` FOREIGN KEY (`propertyId`) REFERENCES `property` (`id`)  ON DELETE CASCADE;

--
-- Constraints for table `featureproperty`
--
ALTER TABLE `feature_property`
  ADD CONSTRAINT `FeatureProperty_fk0` FOREIGN KEY (`propertyId`) REFERENCES `property` (`id`)  ON DELETE CASCADE,
  ADD CONSTRAINT `FeatureProperty_fk1` FOREIGN KEY (`featureId`) REFERENCES `feature` (`id`)  ON DELETE CASCADE;

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `Reservations_fk0` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)  ON DELETE CASCADE,
  ADD CONSTRAINT `Reservations_fk1` FOREIGN KEY (`propertyId`) REFERENCES `property` (`id`)  ON DELETE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `User_fk0` FOREIGN KEY (`contactId`) REFERENCES `contact` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `User_fk1` FOREIGN KEY (`billingId`) REFERENCES `billing` (`id`)  ON DELETE CASCADE;

ALTER TABLE `Property`
	ADD CONSTRAINT `Property_fk0` FOREIGN KEY (`userId`) REFERENCES `User`(`id`)  ON DELETE CASCADE;
ALTER TABLE `Property`
	ADD CONSTRAINT `Property_fk1` FOREIGN KEY (`locationId`) REFERENCES `location`(`id`) ON DELETE CASCADE;
ALTER TABLE `Property`
	ADD CONSTRAINT `Property_fk2` FOREIGN KEY (`propertyTypeId`) REFERENCES `property_type`(`id`)  ON DELETE CASCADE;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;