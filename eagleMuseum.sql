use eagleMuseum_schema;

/*會員*/
DROP TABLE IF EXISTS `member`;

create table `member`(
    memberID int auto_increment not null comment '會員ID(主鍵)' primary key,
    memberEmail varchar(255) not null comment '帳號：用戶email' unique,
    memberPassword varchar(255) not null comment '密碼',
    memberName varchar(255) not null comment '用戶名',
	memberQA varchar(255) not null comment '忘記密碼驗證問題',
    memberAns varchar(255) not null comment '忘記密碼驗證回答',
    memberAddress varchar(255) not null comment '地址',
    memberPhone int not null comment '手機',
    memberGender int not null comment '性別',
    memberBirthday date not null comment '生日',	
    memberPermission int default 0 not null comment '使用權限',
    modifyTime datetime not null default now() comment '修改時間',
    lastEnterTime datetime not null default now() comment '最後登入時間'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '會員資料表';
INSERT INTO `db01`.`member` ( `memberEmail`, `memberPassword`, `memberName`, `memberQA`, `memberAns`, `memberAddress`, `memberPhone`, `memberGender`, `memberBirthday`, `memberPermission`) VALUES ('zz@xx.com', 'password', 'leo', '1232', '321', 'taipei', '900', '4', '1995-07-11', '1');



DROP TABLE IF EXISTS `donation`;

create table donation(
    donationID int auto_increment not null comment '捐款ID(主鍵)' primary key,
    memberID int comment '會員ID(外來鍵)',
    donationOrderTime datetime not null default now() comment '捐款日期',
    donationMoney int not null comment '捐款金額',
	donationMessage text comment '捐款留言',
    constraint FK_donation_memberID foreign key (memberID)
    references member (memberID)
)COMMENT = '捐款資料表';


/*館藏*/
DROP TABLE IF EXISTS `collection`;

create table collection(
	collectionID int auto_increment not null comment '館藏ID(主鍵)' primary key,
    collectionTitle text not null comment '館藏名稱' unique,
    collectionText text not null comment '文字內容',
	collectionEar text not null comment '時代',
    collectionMaterial varchar(255) comment '材質',
    collectionStatus boolean not null default false comment '館藏上架狀態(預設隱藏)',
    lastUpdateTime datetime not null default now() comment '最後更新時間'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT = '館藏資料表';

DROP TABLE IF EXISTS `tag`;

create table tag(
	tagID int auto_increment not null comment '標籤ID(主鍵)' primary key,
    tag varchar(255) not null comment '標籤' unique,
    lastUpdateTime datetime not null default now() comment '最後更新時間'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT = '標籤資料表';

DROP TABLE IF EXISTS `collectionTag`;

create table collectionTag(
	collectionTagID int auto_increment not null comment '館藏標籤明細ID(主鍵)' primary key,
    collectionID int comment '館藏ID(外來鍵)',
    tagID int comment '標籤ID(外來鍵)',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_collectionTag_collectionID foreign key (collectionID)
    references collection (collectionID),
    constraint FK_tag_tagID foreign key (tagID)
    references tag (tagID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '館藏標籤明細資料表';

DROP TABLE IF EXISTS `collectionImage`;

create table collectionImage(
	imageID int auto_increment not null comment '圖片ID(主鍵)' primary key,
    collectionID int comment '館藏ID(外來鍵)',
    imageName varchar(255) not null comment '圖片名稱',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_collectionImage_collectionID foreign key (collectionID)
    references collection (collectionID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT = '館藏圖片資料表';

DROP TABLE IF EXISTS `collectionFavorite`;

create table collectionFavorite(
	memberID int  comment '會員ID(外來鍵)',
    collectionID int comment '館藏ID(外來鍵)',
    favoriteStatus boolean default false comment '我的最愛狀態(預設無)',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_collectionFavorite_collectionID foreign key (collectionID)
    references collection (collectionID),
    constraint FK_collectionFavorite_memberID foreign key (memberID)
    references member (memberID),
    primary key(collectionID, memberID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT = '館藏最愛資料表';


/*聯絡我們*/
DROP TABLE IF EXISTS `location`;

create table location(
	locationId int auto_increment not null comment '場地ID(主鍵)' primary key,
    locationName varchar(255) not null comment '場地名稱',
    capacity int not null comment '容納人數',
    rent int comment '租金',
    covered boolean default true not null comment '遮蔽狀態(預設室內)',
    useable boolean default false not null comment '啟用狀態(預設未啟用)',
    lastUpdateTime datetime not null default now() comment '最後更新時間'
)COMMENT = '場地資料表';



DROP TABLE IF EXISTS `questionType`;

create table questionType(
	questionTypeID int auto_increment not null comment '問題類型ID(主鍵)' primary key,
    questionType varchar(255) not null comment '問題類型內容',
    lastUpdateTime datetime not null default now() comment '最後更新時間'
)COMMENT = '問題類型資料表';

DROP TABLE IF EXISTS `questionContent`;

create table questionContent(
	questionContentID int auto_increment not null comment '問題回應ID(主鍵)' primary key,
    memberId int comment '會員ID(外來鍵)',
    questionTypeID int comment '問題類型ID(外來鍵)',
    questionContent text not null comment '問題內容',
    answerContent text comment '答覆內容',
    answered boolean default false not null comment '答覆狀態(預設未答)',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_questionContent_questionTypeID foreign key (questionTypeID)
    references questionType (questionTypeID),
    constraint FK_questionContent_memberID foreign key (memberID)
    references member (memberID)
)COMMENT = '問題回饋資料表';


/*展覽*/
DROP TABLE IF EXISTS `exhibition`;

create table exhibition(
	exhibitionID int auto_increment not null comment '展覽ID(主鍵)' primary key,
    locationId int comment '場地ID(外來鍵)',
    exhibitionType int not null comment '展覽類別',
    exhibitionName varchar(255) not null comment '展覽名稱',
    exhibitionStartDate date not null comment '展覽開始日期',
    exhibitionEndDate date not null comment '展覽結束日期',
    exhibitionArticle text not null comment '展覽概述',
    exhibitionStatus int default 0 not null comment '展覽狀態',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_exhibition_locationId foreign key (locationId)
    references location (locationId)
)COMMENT = '展覽資料表';

DROP TABLE IF EXISTS `exhibitionImg`;

create table exhibitionImg(
	exhibitionImgID int auto_increment not null comment '展覽圖片ID(主鍵)' primary key,
    exhibitionID int comment '展覽ID(外來鍵)',
    imgName varchar(255) not null comment '圖片名稱',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_exhibitionImg_exhibitionID foreign key (exhibitionID)
    references exhibition (exhibitionID)
)COMMENT = '展覽圖片資料表';

DROP TABLE IF EXISTS `ticket`;

create table ticket(
	ticketID int auto_increment not null comment '票券ID(主鍵)' primary key,
    memberId int comment '會員ID(外來鍵)',
    exhibitionID int comment '展覽ID(外來鍵)',
    ticketDate date not null comment '票券日期',
    ticketType int not null comment '票券種類',
    ticketPrice int not null comment '票價',
    ticketStatus int default 0 not null comment '票券狀態',
    memo text comment '備註',
    buyTime datetime comment '購票時間',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_ticket_exhibitionID foreign key (exhibitionID)
    references exhibition (exhibitionID),
    constraint FK_ticket_memberID foreign key (memberID)
    references member (memberID)
)COMMENT = '票券資料表';


/*商城*/
DROP TABLE IF EXISTS `productType`;

create table productType(
	prodTypeID int auto_increment not null comment '商品類別ID(主鍵)' primary key,
    prodType varchar(255) not null comment '商品類別',
    lastUpdateTime datetime not null default now() comment '最後更新時間'
)COMMENT = '商品類別資料表';

DROP TABLE IF EXISTS `discountDetails`;

create table discountDetails(
	discountID int auto_increment not null comment '折扣ID(主鍵)' primary key,
    discount double not null comment '折數',
    discountCode varchar(255) not null comment '優惠碼',
    ticketStatus boolean default false not null comment '折扣狀態(未啟用)',
    createTime datetime comment '建立時間',
    lastUpdateTime datetime not null default now() comment '最後更新時間'
)COMMENT = '折扣明細資料表';


DROP TABLE IF EXISTS `productList`;

create table productList(
	productID int auto_increment not null  comment '商品編號(主鍵)' primary key,
    prodName varchar(255) not null comment '商品名稱',
    prodTypeID int comment '商品類別ID(外來鍵)',
    prodPrice int not null comment '商品價錢',
    discountID int comment '折扣ID',
    prodDescription text not null comment '商品說明',
    prodStatus int not null default 0 comment '商品狀態',
    creatTime datetime comment '創建時間',
    launchTime datetime comment '上架日期',
    sellQuantity int default 0 not null  comment '賣出數量',
    prodInStock int default 0 not null  comment '庫存數量',
    bestSeller boolean default false not null comment '熱門商品狀態(預設否)',
    lastUpdateTime datetime comment '最後更新時間',
    constraint FK_productList_prodTypeID foreign key (prodTypeID)
    references productType (prodTypeID)
)COMMENT = '商品資料表';

DROP TABLE IF EXISTS `productImg`;

create table productImg(
	productImgID int auto_increment not null comment '商品圖片ID(主鍵)' primary key,
    productID int comment '商品編號(外來鍵)',
    imgName varchar(255) not null comment '圖片名稱',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_productImg_productID foreign key (productID)
    references productList (productID)
)COMMENT = '商品圖片資料表';

DROP TABLE IF EXISTS `order`;

create table `order`(
	orderID int auto_increment not null comment '訂單編號(主鍵)' primary key,
    memberId int comment '會員ID(外來鍵)',
    orderAmount int not null comment '訂單金額',
    orderStatus int not null comment '訂單狀態',
    deliveryAddress text not null comment '配送地址',
    freight int not null comment '運費',
    memo text comment '備註',
    createTime datetime comment '建立時間',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_order_memberID foreign key (memberID)
    references member (memberID)
)COMMENT = '訂單資料表';

DROP TABLE IF EXISTS `orderDetails`;

create table `orderDetails`(
	orderDetailsID int auto_increment not null comment '訂單明細編號(主鍵)' primary key,
    productID int comment '商品編號(外來鍵)',
    orderID int comment '訂單編號(外來鍵)',
    prodQuantity int default 1 not null  comment '商品數量',
    constraint FK_orderDetails_productID foreign key (productID)
    references productList (productID),
    constraint FK_orderDetails_orderID foreign key (orderID)
    references `order` (orderID)
)COMMENT = '訂單明細資料表';

DROP TABLE IF EXISTS `productFavorite`;

create table productFavorite(
	memberID int  comment '會員ID(外來鍵)',
    productID int comment '商品編號(外來鍵)',
    favoriteStatus boolean default false comment '我的最愛狀態(預設無)',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_productFavorite_productID foreign key (productID)
    references productList (productID),
    constraint FK_productFavorite_memberID foreign key (memberID)
    references member (memberID),
    primary key(productID, memberID)
)COMMENT = '商品最愛資料表';

DROP TABLE IF EXISTS `cartList`;
create table cartList(
	memberID int  comment '會員ID(外來鍵)',
    productID int comment '商品編號(外來鍵)',
    prodQuantity int default 1 not null  comment '商品數量',
    lastUpdateTime datetime not null default now() comment '最後更新時間',
    constraint FK_cartList_productID foreign key (productID)
    references productList (productID),
    constraint FK_cartList_memberID foreign key (memberID)
    references member (memberID),
    primary key(productID, memberID)
)COMMENT = '購物車清單資料表';

