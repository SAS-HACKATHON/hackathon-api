/* User */
insert into user (user_id, password, first_name, last_name, email, role, is_active, is_blocked, security_provider_id, default_customer_id, secret_question, secret_answer, enable_beta_testing, enable_renewal) values
('demo'      , 'demo'     , 'Mrinmoy'  , 'Majumdar', 'arivera2@joomla.org'    , 'USER' , 1, 0, 10001, 20000, 'Diverse'       , 'Yellow' , 0, 0),
('admin'     , 'admin'    , 'Theresa'  , 'Russell' , 'trussell1@about.me'     , 'ADMIN', 1, 0, 10001, 20000, 'knowledge base', 'Mauv'   , 1, 0),
('user'      , 'user'     , 'Virginia' , 'Reynolds', 'vreynolds0@slashdot.org','USER' , 1, 0, 10001, 20000, 'Innovative'    , 'Turquoise', 1, 1),
('jowens3'   , 'jowens3'  , 'Judy'     , 'Owens'   , 'jowens3@hp.com'         , 'USER' , 0, 0, 10001, 20001, 'capacity'      , 'Fuscia' , 1, 1),
('kburns4'   , 'kburns4'  , 'Kelly'    , 'Burns'   , 'kburns4@icio.us'        , 'ADMIN', 1, 0, 10000, 20002, 'user-facing'   , 'Crimson', 1, 1),
('jshaw5'    , 'jshaw5'   , 'Julie'    , 'Shaw'    , 'jshaw5@opera.com'      , 'ADMIN', 1, 1, 10000, 20000, 'software'      , 'Green'  , 0, 1),
('pgilbert6' , 'pgilbert6', 'Peter'    , 'Gilbert' , 'pgilbert6@eepurl.com'   , 'ADMIN', 1, 1, 10000, 20000, 'multi-state'   , 'Puce'   , 1, 1),
('jjacobs7'  , 'jjacobs7' , 'Justin'   , 'Jacobs'  , 'jjacobs7@google.co.uk'  ,'USER' , 1, 0, 10000, 20002, 'motivating'    , 'Crimson', 1, 0),
('kbennett8' , 'kbennett8', 'Kevin'    , 'Bennett' , 'kbennett8@hostgator.com' , 'ADMIN', 0, 0, 10001, 20000, 'Exclusive'     , 'Purple' , 1, 1),
('cmurphy9'  , 'cmurphy9' , 'Chris'    , 'Murphy'  , 'cmurphy9@over-blog.com'  , 'ADMIN', 0, 1, 10000, 20000, 'empowering'    , 'Maroon' , 0, 1);
