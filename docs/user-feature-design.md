# Users Feature Design

## Feature Summary
- Registration: new visitors create an account with a username and password.
- Login / logout: users sign in with their credentials and can sign out from the navigation bar.
- Admin user management: an administrator can list users, edit a user's role and enabled status, and delete users.

## User Roles
- Regular user (USER): can register, log in, log out, and use the Orders pages as before.
- Admin (ADMIN): everything a regular user can do, plus access to the User Admin pages.

## High-Level User Flows
- Register -> login -> use app
- Admin -> view users -> edit -> delete (with a confirmation page before deleting)

## Navigation Bar
- Not logged in: Login, Register
- Logged in (any role): Logout
- Logged in as ADMIN: User Admin, Logout
- Links are shown or hidden with sec:authorize so users only see what they can access.

## Error and Feedback Messages
Registration errors (shown in a red message area above the form):
- Username already exists
- Password and confirm password do not match
- Missing required fields

Login messages (shown above the login form):
- Invalid credentials: red error message
- Registration successful: green success message

Recovery: the form stays on screen so the user can correct the problem and resubmit.