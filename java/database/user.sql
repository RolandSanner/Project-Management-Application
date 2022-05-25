-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER project_management_app_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO project_management_app_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO project_management_app_owner;

CREATE USER project_management_app_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO project_management_app_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO project_management_app_appuser;
