# Wireframes

Text-based wireframes for each page in the Users feature. Layout and structure only, not styling.

## Navigation Bar (shared by all pages)
- App name / Orders link
- Login link (logged out only)
- Register link (logged out only)
- User Admin link (ADMIN only)
- Logout button (logged in only)

## login.html
- Page title: Login
- Message area: registration success message (green) and invalid credentials error (red)
- Form (POST /login)
  - Username input (name: username)
  - Password input (name: password)
  - Login button
- Link to Register page

## register.html
- Page title: Register
- Error area: username already exists, passwords do not match, missing fields (red)
- Form (POST /register)
  - Username input (name: username)
  - Password input (name: password)
  - Confirm password input (name: confirmPassword)
  - Register button
- Link back to Login page
- No role selection field

## userAdmin.html
- Page title: User Administration
- Feedback message area
- Table of users (one row per user in users)
  - Columns: Id, Username, Role, Enabled, Actions
  - Actions: Edit link, Delete link

## editUser.html
- Page title: Edit User
- Error area
- Form (POST /admin/users/edit)
  - Hidden input (name: id)
  - Username (display only)
  - Role dropdown (name: role): USER, ADMIN
  - Enabled checkbox (name: enabled)
  - Save button
  - Cancel link back to User Administration
- No password field

## confirmDeleteUser.html
- Page title: Confirm Delete
- Message: Are you sure you want to delete this user?
- Details of the user (username and role)
- Form (POST /admin/users/delete)
  - Hidden input (name: id)
  - Delete button
  - Cancel link back to User Administration