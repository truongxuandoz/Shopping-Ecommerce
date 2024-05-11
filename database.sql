-- Bảng Khách hàng
CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL,
    Address VARCHAR(200) NOT NULL,
    City VARCHAR(50) NOT NULL,
    Country VARCHAR(50) NOT NULL,
    PostalCode VARCHAR(20) NOT NULL,
    Phone VARCHAR(20) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    DateOfBirth DATE,
    IsSubscribed BOOLEAN DEFAULT 0
);

-- Bảng Danh mục
CREATE TABLE Categories (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(100) NOT NULL,
    Description VARCHAR(500)
);

-- Bảng Nhà sản xuất
CREATE TABLE Manufacturers (
    ManufacturerID INT AUTO_INCREMENT PRIMARY KEY,
    ManufacturerName VARCHAR(100) NOT NULL,
    Address VARCHAR(200) NOT NULL,
    Country VARCHAR(50) NOT NULL
);

-- Bảng Đơn vị tính
CREATE TABLE Units (
    UnitID INT AUTO_INCREMENT PRIMARY KEY,
    UnitName VARCHAR(50) NOT NULL
);

-- Bảng Sản phẩm
CREATE TABLE Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(200) NOT NULL,
    Description VARCHAR(500),
    Price DECIMAL(18,2) NOT NULL,
    StockQuantity INT NOT NULL,
    ImageURL VARCHAR(500),
    CategoryID INT,
    ManufacturerID INT,
    UnitID INT,
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
    FOREIGN KEY (ManufacturerID) REFERENCES Manufacturers(ManufacturerID),
    FOREIGN KEY (UnitID) REFERENCES Units(UnitID)
);

-- Bảng Đơn hàng
CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT,
    EmployeeID INT,
    OrderDate DATE NOT NULL,
    ShipAddress VARCHAR(300) NOT NULL,
    TotalAmount DECIMAL(18,2) NOT NULL,
    ShippingFee DECIMAL(18,2) NOT NULL,
    Status VARCHAR(50) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);

-- Bảng Chi tiết đơn hàng
CREATE TABLE OrderDetails (
    OrderDetailID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    SalePrice DECIMAL(18,2) NOT NULL,
    DiscountID INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    FOREIGN KEY (DiscountID) REFERENCES Discounts(DiscountID)
);

-- Bảng Nhân viên
CREATE TABLE Employees (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL,
    Address VARCHAR(200) NOT NULL,
    Phone VARCHAR(20) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Position VARCHAR(100) NOT NULL,
    IsAdmin BOOLEAN NOT NULL DEFAULT 0,
    JoinDate DATE NOT NULL
);

-- Bảng Thanh toán
CREATE TABLE Payments (
    PaymentID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    PaymentDate DATE NOT NULL,
    Amount DECIMAL(18,2) NOT NULL,
    PaymentMethodID INT,
    PaymentStatusID INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (PaymentMethodID) REFERENCES PaymentMethods(PaymentMethodID),
    FOREIGN KEY (PaymentStatusID) REFERENCES PaymentStatuses(PaymentStatusID)
);

-- Bảng Trạng thái thanh toán
CREATE TABLE PaymentStatuses (
    PaymentStatusID INT AUTO_INCREMENT PRIMARY KEY,
    StatusName VARCHAR(50) NOT NULL
);

-- Bảng Phương thức thanh toán
CREATE TABLE PaymentMethods (
    PaymentMethodID INT AUTO_INCREMENT PRIMARY KEY,
    PaymentMethodName VARCHAR(50) NOT NULL
);

-- Bảng Đánh giá
CREATE TABLE Reviews (
    ReviewID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT,
    ProductID INT,
    ReviewText VARCHAR(500) NOT NULL,
    Rating TINYINT NOT NULL CHECK (Rating >= 1 AND Rating <= 5),
    ReviewDate DATE NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Bảng Mã giảm giá
CREATE TABLE Discounts (
    DiscountID INT AUTO_INCREMENT PRIMARY KEY,
    DiscountCode VARCHAR(50) NOT NULL,
    Description VARCHAR(500),
    DiscountValue DECIMAL(18,2) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL
);

-- Bảng Khuyến mãi
CREATE TABLE Promotions (
    PromotionID INT AUTO_INCREMENT PRIMARY KEY,
    PromotionName VARCHAR(100) NOT NULL,
    Description VARCHAR(500),
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL
);

-- Bảng Chi tiết khuyến mãi
CREATE TABLE PromotionDetails (
    PromotionDetailID INT AUTO_INCREMENT PRIMARY KEY,
    PromotionID INT,
    ProductID INT,
    DiscountValue DECIMAL(18,2) NOT NULL,
    FOREIGN KEY (PromotionID) REFERENCES Promotions(PromotionID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Bảng Giao hàng
CREATE TABLE Shipments (
    ShipmentID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    ShipDate DATE NOT NULL,
    ShipAddress VARCHAR(300) NOT NULL,
    ShipMethod VARCHAR(100) NOT NULL,
    ShipStatus VARCHAR(50) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);
