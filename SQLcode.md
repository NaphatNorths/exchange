CREATE TABLE users (
    userid VARCHAR(36) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    address TEXT NULL
);

CREATE TABLE itemList (
    itemid VARCHAR(36) PRIMARY KEY,
    userid VARCHAR(36) NOT NULL,
    itemname VARCHAR(255) NOT NULL,
    info TEXT NULL,
    image VARBINARY(MAX),
    value VARCHAR(36),
    itemtype VARCHAR(36),
    FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE exchangeOrder (
    orderid VARCHAR(36) PRIMARY KEY,
    userid VARCHAR(36) NOT NULL,
    targetitemid VARCHAR(36) NOT NULL,
    myitemid VARCHAR(36) NOT NULL,
    createdate DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(36) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(userid),
    FOREIGN KEY (targetitemid) REFERENCES itemList(itemid),
    FOREIGN KEY (myitemid) REFERENCES itemList(itemid)
);

CREATE TABLE itemFavorite (
    favoriteid VARCHAR(36) PRIMARY KEY,
    userid VARCHAR(36) NOT NULL,
    itemid VARCHAR(36) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(userid),
    FOREIGN KEY (itemid) REFERENCES itemList(itemid)
);


INSERT INTO users (userid, username, password, firstname, lastname, address) VALUES
('user-001', 'john_doe', '1234', 'John', 'Doe', '123 Main St'),
('user-002', 'jane_smith', '1234', 'Jane', 'Smith', '456 Elm St'),
('user-003', 'alice_wonder', '1234', 'Alice', 'Wonderland', '789 Oak St');

INSERT INTO itemList (itemid, userid, itemname, info, image) VALUES
('item-001', 'user-001', 'Laptop', 'Gaming Laptop', NULL),
('item-002', 'user-002', 'Smartphone', 'Latest Model', NULL),
('item-003', 'user-003', 'Bicycle', 'Mountain Bike', NULL);

INSERT INTO exchangeOrder (orderid, userid, targetitemid, myitemid, createdate, status) VALUES
('order-001', 'user-001', 'item-002', 'item-001', CURRENT_TIMESTAMP, 'Pending'),
('order-002', 'user-002', 'item-003', 'item-002', CURRENT_TIMESTAMP, 'Approved'),
('order-003', 'user-003', 'item-001', 'item-003', CURRENT_TIMESTAMP, 'Canceled');

INSERT INTO itemFavorite (favoriteid, userid, itemid) VALUES
('fav-001', 'user-001', 'item-003'),
('fav-002', 'user-002', 'item-001'),
('fav-003', 'user-003', 'item-002');

CREATE VIEW userItemListView AS
SELECT 
    i.itemid,
    i.userid,
    u.username,
    i.itemname,
    i.info,
    i.image
FROM itemList i
JOIN users u ON i.userid = u.userid;

CREATE VIEW itemListView AS
SELECT 
    i.itemid,
    i.itemname,
    i.info,
    i.image,
    i.userid,
    u.username AS owner
FROM itemList i
JOIN users u ON i.userid = u.userid;

CREATE VIEW itemFavoriteView AS
SELECT 
    f.favoriteid,
    f.userid,
    u.username AS favorited_by,
    f.itemid,
    i.itemname AS favorite_item
FROM itemFavorite f
JOIN users u ON f.userid = u.userid
JOIN itemList i ON f.itemid = i.itemid;



SELECT * FROM userItemListView WHERE userid = 'user-001';
SELECT * FROM itemListView WHERE userid = 'user-001';
SELECT * FROM itemFavoriteView WHERE userid = 'user-001';
