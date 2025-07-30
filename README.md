# Hệ thống Quản lý - Spring Boot với Spring Security

## Mô tả
Hệ thống quản lý nhân viên được xây dựng bằng Spring Boot với tính năng đăng nhập/đăng ký sử dụng Spring Security.

## Tính năng chính

### 🔐 Xác thực và Phân quyền
- Đăng ký tài khoản mới
- Đăng nhập với username/password
- Phân quyền người dùng (USER/ADMIN)
- Mã hóa mật khẩu với BCrypt
- Session management

### 👥 Quản lý Nhân viên
- Xem danh sách nhân viên
- Thêm nhân viên mới
- Chỉnh sửa thông tin nhân viên
- Xóa nhân viên
- REST API cho mobile app

### 🎨 Giao diện
- Giao diện đẹp với Bootstrap 5
- Responsive design
- Dashboard với thống kê
- Form validation

## Cấu trúc Database

### Bảng `users`
- `id`: Primary key
- `username`: Tên đăng nhập (unique)
- `password`: Mật khẩu (đã mã hóa)
- `email`: Email (unique)
- `first_name`: Họ
- `last_name`: Tên
- `enabled`: Trạng thái kích hoạt

### Bảng `roles`
- `id`: Primary key
- `name`: Tên vai trò (ROLE_USER, ROLE_ADMIN)
- `description`: Mô tả vai trò

### Bảng `user_roles` (Many-to-Many)
- `user_id`: Foreign key đến users
- `role_id`: Foreign key đến roles

## Cài đặt và Chạy

### Yêu cầu hệ thống
- Java 21
- Maven 3.6+
- MySQL 8.0+

### Bước 1: Cấu hình Database
1. Tạo database MySQL:
```sql
CREATE DATABASE qlnhanvien;
```

2. Cập nhật thông tin kết nối trong `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/qlnhanvien
spring.datasource.username=root
spring.datasource.password=123456
```

### Bước 2: Chạy ứng dụng
```bash
# Clone repository
git clone <repository-url>
cd KienTrucSpring

# Build project
mvn clean install

# Chạy ứng dụng
mvn spring-boot:run
```

### Bước 3: Truy cập ứng dụng
- URL: http://localhost:8080
- Tài khoản admin mặc định: `admin/admin123`

## API Endpoints

### Authentication
- `GET /` - Trang chủ
- `GET /login` - Trang đăng nhập
- `POST /login` - Xử lý đăng nhập
- `GET /register` - Trang đăng ký
- `POST /register` - Xử lý đăng ký
- `GET /dashboard` - Dashboard (cần đăng nhập)
- `POST /logout` - Đăng xuất

### Employee Management
- `GET /employees` - Danh sách nhân viên
- `GET /employees/add` - Form thêm nhân viên
- `POST /employees/add` - Thêm nhân viên
- `GET /employees/edit/{id}` - Form chỉnh sửa
- `POST /employees/edit/{id}` - Cập nhật nhân viên
- `GET /employees/delete/{id}` - Xóa nhân viên

### REST API
- `GET /employees/api` - Lấy danh sách nhân viên (JSON)
- `GET /employees/api/{id}` - Lấy nhân viên theo ID
- `POST /employees/api` - Tạo nhân viên mới
- `PUT /employees/api/{id}` - Cập nhật nhân viên
- `DELETE /employees/api/{id}` - Xóa nhân viên

## Cấu trúc Project

```
src/main/java/com/dev/ldt/NewSpring/KienTrucSpring/
├── config/
│   ├── SecurityConfig.java          # Cấu hình Spring Security
│   └── DataInitializer.java        # Khởi tạo dữ liệu mẫu
├── controller/
│   ├── AuthController.java          # Xử lý đăng nhập/đăng ký
│   └── EmployeeController.java      # Quản lý nhân viên
├── entity/
│   ├── User.java                   # Entity User
│   ├── Role.java                   # Entity Role
│   └── Employee.java               # Entity Employee
├── repository/
│   ├── UserRepository.java         # Repository User
│   ├── RoleRepository.java         # Repository Role
│   └── EmployeeRepository.java     # Repository Employee
└── service/
    ├── UserService.java            # Service User
    ├── CustomUserDetailsService.java # UserDetailsService
    └── EmployeeService.java        # Service Employee
```

## Tính năng bảo mật

### Spring Security
- Form-based authentication
- Password encoding với BCrypt
- Role-based access control
- Session management
- CSRF protection

### Validation
- Username/email uniqueness
- Password strength validation
- Form validation
- Client-side validation

## Giao diện

### Trang chủ
- Hero section với call-to-action
- Giới thiệu tính năng
- Navigation menu

### Đăng nhập/Đăng ký
- Form validation
- Error handling
- Responsive design
- Password strength indicator

### Dashboard
- Thống kê tổng quan
- Quick actions
- Recent activities
- Sidebar navigation

### Quản lý nhân viên
- Table view với pagination
- CRUD operations
- Search và filter
- Export functionality

## Tài khoản mặc định

### Admin User
- Username: `admin`
- Password: `admin123`
- Roles: `ROLE_USER`, `ROLE_ADMIN`

## Troubleshooting

### Lỗi kết nối database
- Kiểm tra MySQL service đang chạy
- Kiểm tra thông tin kết nối trong `application.properties`
- Đảm bảo database `qlnhanvien` đã được tạo

### Lỗi Spring Security
- Kiểm tra dependencies trong `pom.xml`
- Đảm bảo `SecurityConfig` được cấu hình đúng
- Kiểm tra `CustomUserDetailsService`

### Lỗi template
- Kiểm tra Thymeleaf dependencies
- Đảm bảo templates nằm trong `src/main/resources/templates/`
- Kiểm tra syntax Thymeleaf

## Đóng góp

1. Fork project
2. Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Tạo Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Liên hệ

- Email: your.email@example.com
- Project Link: [https://github.com/yourusername/KienTrucSpring](https://github.com/yourusername/KienTrucSpring)