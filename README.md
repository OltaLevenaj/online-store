# Online Shop

A Spring Boot-based online shop application with user authentication, product management, and order processing capabilities.

## Features

- **User Management**
  - User registration and authentication
  - Role-based access control (Admin/User)
  - User profile management

- **Product Management**
  - Browse active products
  - Search products by title, author, or category
  - Admin CRUD operations for products

- **Order Processing**
  - Create and manage orders
  - Order line management
  - Order history

- **Admin Dashboard**
  - User management
  - Product catalog management
  - Order management
  - Category management

## Tech Stack

- **Backend**: Spring Boot 3.5.7
- **Database**: MySQL
- **Security**: Spring Security
- **Build Tool**: Maven
- **Java Version**: 21

## Getting Started

### Prerequisites

- Java 21 or later
- MySQL 8.0 or later
- Maven 3.6.0 or later

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Online_Shop.git
   cd Online_Shop
   ```

2. Configure the database:
   - Create a MySQL database named `online_shop`
   - Update the database configuration in `application.properties`

3. Build the application:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /user/register` - Register a new user

### Public Endpoints
- `GET /products/active` - Get all active products
- `GET /products/{id}` - Get product by ID
- `GET /products/search/` - Search products
- `GET /products/search/author/` - Search products by author
- `GET /products/search/category/` - Search products by category
- `GET /products/search/title` - Search products by title

### Admin Endpoints (Requires ADMIN role)

#### User Management
- `POST /admin/user/create` - Create a new user
- `GET /admin/user/accounts` - Get all users
- `GET /admin/user/accounts/{id}` - Get user by ID
- `PUT /admin/user/update` - Update user

#### Product Management
- `GET /products/all` - Get all products (including inactive)
- `POST /products/create` - Create a new product
- `PUT /products/update` - Update a product
- `DELETE /products/delete/{id}` - Delete a product

#### Category Management
- `POST /category/create` - Create a new category
- `PUT /category/update/{id}` - Update a category

#### Author Management
- `POST /authors/create` - Create a new author
- `PUT /authors/update/{id}` - Update an author

## Security

The application uses Spring Security with role-based access control. Endpoints are secured based on user roles (ADMIN/USER).

## Database Schema

The application uses JPA entities to manage the following tables:
- UserAccount
- Product
- Category
- Author
- Order
- OrderLine

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Your Name - your.email@example.com

Project Link: [https://github.com/yourusername/Online_Shop](https://github.com/yourusername/Online_Shop)
