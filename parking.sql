use parkingdb;

create table `status` (
	id int not null auto_increment primary key,
    `name` varchar(100) not null
) engine=InnoDB;

create table `parking` (
	id int not null auto_increment primary key,
    address varchar(100) not null,
    quantity int not null,
    daily_price int not null,
    night_price int not null,
    status_id int not null,
    note varchar(255),
    foreign key (status_id) references status(id)
) engine=InnoDB;

create table `user` (
	id int not null auto_increment primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(50) not null,
    phone varchar(10) not null,
    username varchar(100) not null unique,
    `password` varchar(100) not null,
    user_role varchar(15) not null,
    avatar varchar(100) not null
) engine=InnoDB;

create table `comment` (
	id int not null auto_increment primary key,
    content varchar(255) not null,
    user_id int not null,
    parking_id int not null,
    foreign key (user_id) references user(id),
    foreign key (parking_id) references parking(id)
) engine=InnoDB;

create table `rating` (
	id int not null auto_increment primary key,
    stars int not null,
    user_id int not null,
    parking_id int not null,
    foreign key (user_id) references user(id),
    foreign key (parking_id) references parking(id)
) engine=InnoDB;

create table order_parking (
	id int not null auto_increment primary key,
    user_id int not null,
    parking_id int not null,
    vehicle_name varchar(100) not null,
    license_plates varchar(15) not null,
    created_date datetime not null,
    `status` varchar(50) not null,
    start_time datetime,
    end_time datetime,
    total int not null,
    foreign key (user_id) references user(id),
    foreign key (parking_id) references parking(id)
) engine=InnoDB;

create table order_detail (
	id int not null auto_increment primary key,
    order_id int not null,
    total int not null,
    method_pay varchar(20) not null,
    foreign key (order_id) references order_parking(id)
) engine=InnoDB;

create table order_cancel (
	id int not null auto_increment primary key,
    order_id int not null,
    reason varchar(255) not null,
    `date` datetime not null,
    `status` varchar(100) not null,
    bank_name varchar(50) not null,
    account_number varchar(20) not null,
    foreign key (order_id) references order_parking(id)
) engine=InnoDB;

INSERT INTO `parkingdb`.`user` (`first_name`, `last_name`, `email`, `phone`, `username`, `password`, `user_role`, `avatar`) VALUES ('dong', 'minh', 'minh@gmail.com', '0123456789', 'admin', '$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO', 'ROLE_ADMIN', 'https://res.cloudinary.com/dxxwcby8l/image/upload/v1692330009/vuyk886cdgjykoi6qs3f.png');