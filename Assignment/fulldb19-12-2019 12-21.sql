#
# TABLE STRUCTURE FOR: City
#

DROP TABLE IF EXISTS `City`;

CREATE TABLE `City` (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT,
  `fk_state_id` int(9) NOT NULL,
  `city_name` varchar(100) NOT NULL,
  `city_postcode` int(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (1, 1, 'South Leraton', 71781);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (2, 2, 'Turcottemouth', 79457);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (3, 3, 'Goyettefurt', 7155);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (4, 4, 'Dennisborough', 32570);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (5, 5, 'New Damarisport', 9674);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (6, 1, 'Bennettberg', 77751);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (7, 2, 'Stiedemannton', 11330);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (8, 3, 'Aminaland', 48507);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (9, 4, 'North Katarinatown', 63366);
INSERT INTO `City` (`id`, `fk_state_id`, `city_name`, `city_postcode`) VALUES (10, 5, 'North Tillmanstad', 91507);


#
# TABLE STRUCTURE FOR: Shop
#

DROP TABLE IF EXISTS `Shop`;

CREATE TABLE `Shop` (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT,
  `fk_city_id` int(9) unsigned NOT NULL,
  `shop_name` varchar(100) NOT NULL,
  `shop_category` varchar(255) NOT NULL,
  `shop_address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (1, 1, 'omnis', 'Torphy, Hahn and Macejkovic', '89625 Amir Extension\nBeerbury, NY 12751');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (2, 2, 'qui', 'Toy Inc', '707 Jacobi Streets Suite 957\nLefflerstad, ND 76242');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (3, 3, 'veritatis', 'Lockman Inc', '662 Zieme Forges Suite 936\nPort Georgiana, IL 95216-7243');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (4, 4, 'illum', 'Raynor, Runolfsdottir and Runolfsson', '612 Halvorson Ports Apt. 172\nHermannmouth, IN 78781-2931');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (5, 5, 'dolorum', 'Orn, Kohler and Bosco', '43314 Leon Parks\nBeierborough, TN 53632-2631');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (6, 6, 'minima', 'Feil LLC', '2558 Mayert Terrace\nWest Alessiabury, NC 89217');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (7, 7, 'et', 'Veum-Hamill', '14478 Braun Wells\nSouth Ahmed, TX 91527-0808');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (8, 8, 'consequuntur', 'Flatley-Donnelly', '694 Jarrett Route Apt. 720\nRodland, UT 88023-3736');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (9, 9, 'blanditiis', 'Cassin Inc', '966 Connelly Ford Apt. 341\nBorerton, MA 89775');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (10, 10, 'rerum', 'Hackett-Kshlerin', '62939 Lebsack Common\nKutchhaven, MD 53958');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (11, 1, 'placeat', 'Lebsack Inc', '7714 Moen Islands Suite 130\nEast Stanleymouth, MI 73742-8645');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (12, 2, 'excepturi', 'Pacocha, Wilkinson and Kuhlman', '881 Marielle Canyon\nRauhaven, AL 18082-9934');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (13, 3, 'corrupti', 'Hand, Simonis and Mills', '994 Lauretta Corner\nGreenholtberg, MS 68803-0033');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (14, 4, 'nisi', 'Barton and Sons', '05082 Boyer Curve Suite 159\nPort Devynstad, ID 38291-5476');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (15, 5, 'odio', 'Dooley-Rippin', '943 Kaycee Fields Apt. 877\nChristinamouth, LA 14288');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (16, 6, 'autem', 'Murazik-Zulauf', '804 Treutel Inlet Suite 027\nHaleyburgh, KY 25819');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (17, 7, 'ratione', 'Greenholt, Heathcote and Bailey', '69542 Bernier Trace Apt. 417\nCathrineton, AR 64505-5446');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (18, 8, 'nihil', 'O\'Kon, Olson and Cole', '222 Priscilla Islands Suite 980\nEnolafort, MD 65287');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (19, 9, 'nisi', 'Kessler-Willms', '187 Fernando Shores\nCassinberg, OR 99599-1620');
INSERT INTO `Shop` (`id`, `fk_city_id`, `shop_name`, `shop_category`, `shop_address`) VALUES (20, 10, 'ipsam', 'Hodkiewicz-O\'Hara', '5263 Lacey Freeway Apt. 452\nSwiftberg, KY 66760');


#
# TABLE STRUCTURE FOR: State
#

DROP TABLE IF EXISTS `State`;

CREATE TABLE `State` (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT,
  `state_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `State` (`id`, `state_name`) VALUES (1, 'Louisiana');
INSERT INTO `State` (`id`, `state_name`) VALUES (2, 'Florida');
INSERT INTO `State` (`id`, `state_name`) VALUES (3, 'Illinois');
INSERT INTO `State` (`id`, `state_name`) VALUES (4, 'Virginia');
INSERT INTO `State` (`id`, `state_name`) VALUES (5, 'Ohio');


