/**
 Author: Sofien
**/

DROP SCHEMA IF EXISTS hackathon;

CREATE SCHEMA hackathon;
USE hackathon;

/* Table: user (Application Users) */
CREATE TABLE users (
    id     INT NOT NULL,
    username  NVARCHAR(50) ,
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
    PRIMARY KEY(id)
);

/* Table: categories (Application Categories) */
CREATE TABLE categories (
    id     INT NOT NULL,
    name    NVARCHAR(20) NOT NULL,
    description  TEXT,
	PRIMARY KEY(id)
);

/* Table: articles (Application Articles) */
create sequence group_seq;
CREATE TABLE articles (
    id    INT default group_seq.nextval  ,
    title    TEXT,
    article_type  NVARCHAR(50) ,
    summary   TEXT ,
    fulltext  TEXT ,
	post_date DATE,
    category_id INT references categories(id),
	user_id INT references users(id),
	PRIMARY KEY(id)
);

/* Table: commentaires (Application commentaires) */
CREATE TABLE commentaires (
    id     INT NOT NULL,
	comment_date DATE,
    commentaire    TEXT,
    article_id INT references articles(id),
	user_id INT references users(id),
	PRIMARY KEY(id)
);

