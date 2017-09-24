/* Fill data users */
insert into users (id,username, password, first_name, last_name, email, role, is_active, is_blocked, security_provider_id, default_customer_id, secret_question, secret_answer, enable_beta_testing, enable_renewal) values
('1'      ,'demo'     , 'demo'     , 'Mrinmoy'  , 'Majumdar', 'arivera2@joomla.org'    , 'USER' , 1, 0, 10001, 20000, 'Diverse'       , 'Yellow' , 0, 0),
('2'     , 'admin' , 'admin'   , 'Theresa'  , 'Russell' , 'trussell1@about.me'     , 'ADMIN', 1, 0, 10001, 20000, 'knowledge base', 'Mauv'   , 1, 0),
('3'      , 'user'   , 'user'   , 'Virginia' , 'Reynolds', 'vreynolds0@slashdot.org','USER' , 1, 0, 10001, 20000, 'Innovative'    , 'Turquoise', 1, 1),
('4'   , 'jowens3'  , 'jowens3'  , 'Judy'     , 'Owens'   , 'jowens3@hp.com'         , 'USER' , 0, 0, 10001, 20001, 'capacity'      , 'Fuscia' , 1, 1),
('5'   , 'kburns4', 'kburns4'  , 'Kelly'    , 'Burns'   , 'kburns4@icio.us'        , 'ADMIN', 1, 0, 10000, 20002, 'user-facing'   , 'Crimson', 1, 1),
('6'    , 'jshaw5'  , 'jshaw5'   , 'Julie'    , 'Shaw'    , 'jshaw5@opera.com'      , 'ADMIN', 1, 1, 10000, 20000, 'software'      , 'Green'  , 0, 1),
('7' , 'pgilbert6', 'pgilbert6', 'Peter'    , 'Gilbert' , 'pgilbert6@eepurl.com'   , 'ADMIN', 1, 1, 10000, 20000, 'multi-state'   , 'Puce'   , 1, 1),
('8'  , 'jjacobs7', 'jjacobs7' , 'Justin'   , 'Jacobs'  , 'jjacobs7@google.co.uk'  ,'USER' , 1, 0, 10000, 20002, 'motivating'    , 'Crimson', 1, 0),
('9' , 'kbennett8', 'kbennett8', 'Kevin'    , 'Bennett' , 'kbennett8@hostgator.com' , 'ADMIN', 0, 0, 10001, 20000, 'Exclusive'     , 'Purple' , 1, 1),
('10'  , 'cmurphy9' , 'cmurphy9' , 'Chris'    , 'Murphy'  , 'cmurphy9@over-blog.com'  , 'ADMIN', 0, 1, 10000, 20000, 'empowering'    , 'Maroon' , 0, 1);

/* Fill data categories */
insert into categories (id, name, description) values
('1'      , 'Loisir'     , 'Tous ce qui concernent les loisirs: sport, sortie ...etc.'),
('2'      , 'Sociale'     , 'Tous ce qui concernent les nouveautes dans les reseaux sociaux'),
('3'      , 'Generale'     , 'Toutes les nouveautes n''ayant pas de categorie specifique'),
('4'      , 'Technologie'     , 'Tous ce qui concernent les nouveautes technologiques'),
('5'      , 'Sante'     , 'Tous ce qui concernent la sante des collaborateurs');

/* Fill data articles */
insert into articles (id, title, article_type, summary, fulltext, post_date, category_id, user_id) values
('1', 'Tournoi foot Sofrecom Tunisie', 'EVENT', 'Tournoi de foot des equipes Sofrecom Tunisie, chaque etage va etre presente par deux equipes', 'Tournoi de foot des equipes Sofrecom Tunisie, chaque etage va etre presente par deux equipes, liste des joueurs : chaque capitaine d''equipe doit remplir la fiche avec les noms des 9 joueurs qui composent son equipe.', '2017-08-28','1','1'),
('2', 'DevDay\ Hackathon', 'EVENT', 'Devday, une journee specialement dedie au developpement et a l''innovation aura lieu prochainement.', 'Devday, une journee specialement dedie au developpement et a l''innovation aura lieu prochainement. Cette journee est precede d''une competition Hackathon qui aura lieu le ( L E 2 3 E T L E 2 4 S E P T E M B R E ). Plus de details :Hackathon collecte d''idee' , '2017-09-23', '4','8'),
('3', 'Job Fair', 'EVENT', 'Job Fair est un evenement tres attendu par les jeunes techniciens et ingenieurs en informatique La Smart Tunisia Job Fair', 'Job Fair est un evenement tres attendu par les jeunes techniciens et ingenieurs en informatique La Smart Tunisia Job Fair, ce salon de l''emploi qui rassemble plusieurs professionnels du secteur pour un moment d''echange et de rencontres entre les entreprises IT et les jeunes diplomes en recherche d''emploi. A cette occasion, Sofrecom Tunisie etait presente parmi les professionnels du secteur. Nos collaborateurs ont rencontre et echange avec les jeunes diplomes,ainsi plusieurs etudiants ont pu decouvrir les principaux metiers de l''entreprise, son environnement et son systeme de recrutement mais aussi postuler aux differents postes ouverts.' , '2017-09-23', '4','2'),
('4', 'Lancement messaging pro a Madagascar', 'ACTU_TECHNO', 'Messaging Pro est la continuite de Bulk Messaging, solution web permettant de generer des campagnes de communication sur canal Voix et SMS pour nos clients entreprise.', 'Messaging Pro est la continuite de Bulk Messaging, solution web permettant de generer des campagnes de communication sur canal Voix et SMS pour nos clients entreprise. Cette version du produit vient dans le cadre de la fusion Bulk Messaging / MTEW, et inclut de nouvelles fonctionnalites comme les QCM & Sondage vocaux, Questions/Reponses SMS & voix et une nouvelle experience utilisateur avec le dernier branding Orange. En plus des clients B2B d''Orange, Messaging Pro elargit le spectre en servant les partenariats d''Orange avec les ONG (AUF, AFD, UN) pour des projets d''education et de sante. Messaging Pro est aussi utilise par certaines filiales Orange pour communiquer avec les revendeurs de cartes prepayees afin d''en dynamiser les ventes. L''organisation agile de l''equipe projet a permis de livrer en 3 mois et a moindre coût cette version du produit. Ces succes sont le reflet d''une collaboration fructueuse entre plusieurs equipes : OLS/Bizz, Orange Labs Tunisie, OLS/Comserv, Orange Labs Egypte, Technocentre Amman & XDLAB. Madagascar etant le deploiement pilote, le parcours de ce core0 continue en 2017 avec une roadmap qui compte deja Niger, Mali, Cote d''Ivoire Senegal, Botswana et Guinee Conakry.' , '2017-05-31', '4','5'),
('5', 'Visite de Guillaume Boudin a Sofrecom Tunisie', 'ACTU', 'Un premier contact apprecie des collaborateurs. Le nouveau CEO de Sofrecom Group, Guillaume Boudin a entame sa tournee des filiales et a choisi la Tunisie comme premiere etape de son parcours les 10 et 11 juillet. ' , 'Un premier contact apprecie des collaborateurs. Le nouveau CEO de Sofrecom Group, Guillaume Boudin a entame sa tournee des filiales et a choisi la Tunisie comme premiere etape de son parcours les 10 et 11 juillet. Sofrecom Tunisie est dotee d''un talentueux capital de 460 professionnels qui assurent les activites des principales BU : le centre de service Orange Labs Tunisie, le centre de service DSI France, le centre de services Sofrecom SA, la direction Conseil et Ingenierie et la direction Edition de Logiciels completees par ses fonctions Support. Le coup d''envoi de la visite a ete donne par Abdelkader Dali qui a partage l''objectif de la rencontre avec les collaborateurs et donne un aperçu global du contexte actuel de l''entreprise et des tres bons resultats. Guillaume Boudin a presente son parcours au sein du Groupe Orange, evoque sa vision pour Sofrecom avec une ambition d''etre un acteur de reference dans le monde du Conseil et de l''Ingenierie, une entreprise de services numeriques (ESN). ', '2017-06-09', '3','7'),
('6', 'SOFRECOM TUNISIE n°1 la plus suivie sur Linkedin', 'ACTU', 'Une etude menee en 2017 par Linkedin a montre que SOFRECOM Tunisie est l''entreprise n°1 la plus suivie sur Linkedin dans la categorie Computer Software moins de 500 employes en Tunisie.' , 'Une etude menee en 2017 par Linkedin a montre que SOFRECOM Tunisie est l''entreprise n°1 la plus suivie sur Linkedin dans la categorie « Computer Software » moins de 500 employes en Tunisie. Elle devance Wevioo et IP-TECH, deux beaux concurrents sur le marche du recrutement dans notre categorie. Son positionnement resolument digital accompagne de l''excellence de nos projets nous donne une longueur et font de nous « the place to be » en Tunisie. Cela nous permet aussi de resister du mieux que nous pouvons aux departs vers l''etranger ainsi que d''avoir un turnover quasi nul vers d''autres societes en Tunisie. Ces rapports LinkedIN font le tour du monde, soyons fiers de nous.', '2017-06-21', '3','9'),
('7', 'Bien-etre : PAUSE AMMA', 'ACTU', 'Sofrecom Tunisie met en place une pause AMMA pour le bien-etre de ses collaborateurs. Cette technique se pratique habille sur une chaise ergonomique et apporte relaxation et detente. Elle permet l''elimination des toxines par la stimulation de points d''accupression, et donc de preserver la sante du beneficiaire.' , 'Sofrecom Tunisie met en place une pause AMMA pour le bien-etre de ses collaborateurs. Cette technique se pratique habille sur une chaise ergonomique et apporte relaxation et detente. Elle permet l''elimination des toxines par la stimulation de points d''accupression, et donc de preserver la sante du beneficiaire. Crane, nuque, epaules, dos ... L''integralite des zones de tensions sera travaillee afin d''etre denouee pour retrouver bien-etre et legerete. Les bienfaits aux collaborateurs: Amelioration de la posture grace a l''assouplissement des articulations, Gain d''energie, Sensation de legerete, Augmentation de la concentration... Faire beneficier aux collaborateurs de cette prestation leur permettra entre autre de :,Relacher les tensions, Renforcer leur sentiment d''appartenance a l''entreprise, Mieux gerer le stress et l''impulsivite, Accroître la motivation, Reduire l''absenteisme...', '2017-07-17', '5','10'),
('8', 'Comite d''Orientation Strategique (COS) de l''Agence Universitaire de la Francophonie (AUF)', 'ACTU_TECHNO', 'Sofrecom Tunisie participe au Comite d''Orientation Strategique (COS) de l''Agence Universitaire de la Francophonie (AUF).','Sofrecom Tunisie participe au Comite d''Orientation Strategique (COS) de l''Agence Universitaire de la Francophonie (AUF). Le Vendredi 9 avril, a Paris, Abdelkader Dali et Thierry Souche, DSI/CIO du Groupe Orange, Senior VP Orange Labs Services ont presente un retour d''experience de Sofrecom Tunisie sur les projets de rapprochement avec le monde universitaire. La principale thematique de cette session a porte sur le developpement des formations professionnalisantes et le dialogue Universites - Entreprises. Abdelkader Dali a presente au Conseil le retour d''experience de Sofrecom Tunisie, ses collaborateurs, ses metiers, ses projets et sa relation avec le monde universitaire, en insistant sur l''importance de la formation par alternance permettant de rapprocher Entreprises et Universites pour preparer et ancrer les talents en Tunisie et relever ensemble les defis du monde de demain où ces talents seront cles.Tunisie.' , '2017-06-12', '4','4'),
('9', 'Demarrage Hackathon 2017', 'ACTU_TECHNO', 'Demarrage ce matin du 1er Hackathon de Sofrecom Tunisie , un defi que nos super developpeurs n''ont pas peur de relever armes de leur creativite et de leur talent ! ','Demarrage ce matin du 1er Hackathon de Sofrecom Tunisie , un defi que nos super developpeurs n''ont pas peur de relever armes de leur creativite et de leur talent ! Au bout de 36 heures, les 4 equipes devront livrer 4 applications a usage entreprise : crowdfunding, annuaire des metiers libres, communication interne et outil de rendez-vous entre collegues. Bonne chance !' , '2017-09-23', '4','8');

/* Fill data commentaires */
insert into commentaires (id, comment_date, commentaire, article_id, user_id) values
('1'      , '2017-09-23'     , 'Comment puis-je ajouter mon nom dans la liste des participants du tournoi de foot ?', '1', '3'),
('2'      , '2017-09-24'     , 'On va gangner les gars Equipe Carthage', '6', '6'),
('3'      , '2017-07-24'     , 'Good news, cela fait un grand plaisir ! Go go Sofrecom', '6', '10'),
('4'      , '2017-07-19'     , 'Une belle idee mais comment proceder pour prendre un rendez-vous ?', '7', '10'),
('5'      , '2017-07-27'     , 'ça se passe tout les jours ?', '7', '8'),
('6'      , '2017-08-10'     , 'J''ai passe hier et c''etait une belle seance, relax et no stress, merci pour cette idee.', '7', '2');
