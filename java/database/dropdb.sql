-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'project_management_app';

DROP DATABASE project_management_app;

DROP USER project_management_app_owner;
DROP USER project_management_app_appuser;
