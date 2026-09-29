# File Map (Frontend/Backend Contract)

If a route, field name, or model attribute changes, update this file before both students continue.

## Public Routes
| Method / URL | Template | Required contract |
| --- | --- | --- |
| GET /login | login.html | Form submits username and password to POST /login. Optional query params: error (invalid credentials), registered (registration success). |
| GET /register | register.html | Form submits username, password, and confirmPassword to POST /register. Optional model attribute: error (message text). |
| POST /register | (redirect) | Success: redirect to /login?registered. Failure: return register.html with model attribute error. |

## Admin Routes (ADMIN only)
| Method / URL | Template | Required contract |
| --- | --- | --- |
| GET /admin/users | userAdmin.html | Model attribute users (list of user objects with id, username, role, enabled). Optional model attribute message. |
| GET /admin/users/edit/{id} | editUser.html | Model attribute user (id, username, role, enabled). |
| POST /admin/users/edit | (redirect) | Form fields: id (hidden), role, enabled. Success: redirect to /admin/users. |
| GET /admin/users/delete/{id} | confirmDeleteUser.html | Model attribute user (id, username, role). |
| POST /admin/users/delete | (redirect) | Form field: id (hidden). Success: redirect to /admin/users. |

## Form Field Names
- Login: username, password (matches Spring Security's standard form login)
- Register: username, password, confirmPassword
- Edit user: id, role, enabled
- Delete user: id

## Notes
- confirmPassword is only used to verify the two password entries. It is not stored in UserEntity.
- Roles are stored as USER and ADMIN. Public registration always assigns USER.
- Passwords are never shown or edited on admin pages.
- Logout is a POST form to /logout.