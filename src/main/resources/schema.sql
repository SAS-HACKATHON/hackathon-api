/**
 Author: Sofien
**/

DROP SCHEMA IF EXISTS hackathon;

CREATE SCHEMA hackathon;
USE hackathon;

/* Table: user (Application Users) */
CREATE TABLE user (
    user_id     NVARCHAR(20) NOT NULL,
    password    NVARCHAR(20) NOT NULL,
    first_name  NVARCHAR(50) ,
    last_name   NVARCHAR(50) ,
    email       NVARCHAR(70) ,
    security_provider_id INT ,
    default_customer_id  INT ,
    role        NVARCHAR(20) ,
    other_roles NVARCHAR(80) ,
    is_active   TINYINT  ,
    is_blocked  TINYINT  ,
    secret_question     NVARCHAR(100),
    secret_answer       NVARCHAR(100),
    enable_beta_testing TINYINT,
    enable_renewal      TINYINT,
    CONSTRAINT user_id PRIMARY KEY(user_id)
);
