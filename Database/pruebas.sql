/* A D M I N */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Admin', false, 'pass','turixteam2019@gmail.com',false);

/* U S U A R I O S */
/* EN ESPERA */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Arthur', true, 'pass','jarturoga1337@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Diana', true, 'pass','dianissssss@ciencias.unam.mx',true);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yo', false, 'pass','yo@gmail.com',true);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Daniela', true, 'pass','danisuuuuuu@ciencias.unam.mx',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Miguel', true, 'pass','miguellllll@gmail.com',false);
/* ASIGNADOS */
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Ernesto', false, 'pass','ernestoasfasaas@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Amelia', false, 'pass','angelasfsafsafsaf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Russell', false, 'pass','rusellasfsafafsa@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Canaria', false, 'pass','canariaasfasfasf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Yolanda', false, 'pass','yolandaasfasfaf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Zepeda', false, 'pass','zepedaasfasfafs@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Roberto', false, 'pass','robertoasfasfafsaf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Will', false, 'pass','willasfafasf@gmail.com',false);
INSERT INTO notitia.Usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('Miriam', false, 'pass','miriam@gmail.com',false);
INSERT INTO notitia.usuario (nombre_usuario, en_espera, contraseña, correo, es_informador)
VALUES ('info', true, 'contraseña','info@gmail.com',true);

/*T E M A S*/
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Hospitales', 'engage real-time content', 'Ernesto', '#e88bef');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Escuelas', 'syndicate 24/7 synergies', 'Amelia', '#3fa04f');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Parques', 'engineer one-to-one ROI', 'Ernesto', '#6167e7');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Museos', 'cultivate user-centric bandwidth', 'Amelia', '#c7a8f3');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Fondas', 'brand magnetic platforms', 'Arthur', '#784dee');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Restaurantes', 'expedite innovative channels', 'Arthur', '#4f0280');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Universidades', 'incentivize bricks-and-clicks niches', 'Miguel', '#a7e5e3');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Bancos', 'embrace impactful web services', 'Miguel', '#96ca2b');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Cajeros', 'synthesize extensible communities', 'Ernesto', '#bcd4cf');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Gasolineras', 'cultivate wireless applications', 'Miguel', '#88b1ba');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Tiendas', 'enhance visionary architectures', 'Yolanda', '#711781');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Supermercados', 'maximize killer experiences', 'Ernesto', '#784f6a');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Primarias', 'transition intuitive deliverables', 'Roberto', '#b25742');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Oficinas', 'generate cutting-edge e-markets', 'Roberto', '#d8434a');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Teatros', 'strategize granular action-items', 'Yolanda', '#2bbea1');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Iglesias', 'implement front-end technologies', 'Roberto', '#56826d');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Casas de Cultura', 'cultivate cross-media initiatives', 'Miriam', '#fa700c');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Farmacias', 'empower one-to-one vortals', 'Miriam', '#c73aa0');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Clínicas', 'matrix ubiquitous niches', 'Miriam', '#62d487');
insert into notitia.temas (nombre, descripcion, nombre_usuario, color) values ('Heladerías', 'strategize compelling methodologies', 'Amelia', '#6786d8');

/*M A R C A D O R E S*/
/*Hospitales*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('EMC Insurance Group Inc.', 'Configurable web-enabled structure', '-13.9535913, -71.7608251', 'Ernesto', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('BlackRock New Jersey Municipal Income Trust', 'Optional contextually-based artificial intelligence', '30.83537, 115.636717', 'Ernesto', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Vectren Corporation', 'Optional attitude-oriented array', '-3.3638779, 104.8688126', 'Ernesto', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Newtek Business Services Corp.', 'Decentralized static forecast', '51.167963, 19.4883692', 'Ernesto', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('PAVmed Inc.', 'Synergized impactful middleware', '36.8830175, 137.4502378', 'Ernesto', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Crane Company', 'Profound upward-trending forecast', '45.2881808, 20.9411779', 'Ernesto', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('American Capital Senior Floating, Ltd.', 'Digitized static info-mediaries', '42.610438, 47.5970197', 'Amelia', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Guggenheim Enhanced Equity Income Fund', 'User-centric leading edge leverage', '54.5489994, 17.7869518', 'Amelia', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Vanguard Mortgage-Backed Securities ETF', 'Multi-channelled demand-driven emulation', '-6.858925, 108.2080973', 'Amelia', 'Hospitales');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('American Financial Group, Inc.', 'Proactive 3rd generation initiative', '-9.581512, -77.7072909', 'Amelia', 'Hospitales');
/*Escuelas*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Independent Bank Group, Inc', 'Programmable bandwidth-monitored policy', '-6.9445784, 107.5179721', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('GATX Corporation', 'Balanced encompassing product', '65.50331, -171.70396', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Savings Financial Group, Inc.', 'Exclusive neutral migration', '29.978663, 111.782745', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('L.S. Starrett Company (The)', 'Vision-oriented disintermediate functionalities', '15.383361, 109.1107114', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Berkshire Hathaway Inc.', 'Automated homogeneous monitoring', '41.1667893, -8.6815733', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Prudential Financial, Inc.', 'Multi-channelled incremental Graphical User Interface', '23.701262, 117.430061', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Adtalem Global Education Inc.', 'Devolved didactic process improvement', '22.996513, 113.823603', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('SteadyMed Ltd.', 'Configurable client-server solution', '35.2188655, -80.8108888', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Gaia, Inc.', 'Configurable intangible initiative', '-30.2932904, 28.7693554', 'Amelia', 'Escuelas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Western Asset/Claymore U.S Treasury Inflation Prot Secs Fd 2', 'Extended intangible paradigm', '53.0831775, 46.2227118', 'Amelia', 'Escuelas');
/*Parques*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Alcoa Corporation', 'Progressive analyzing superstructure', '39.790486, -104.9000469', 'Amelia', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Tetra Technologies, Inc.', 'Adaptive fault-tolerant parallelism', '61.0031692, 25.3947277', 'Amelia', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('L.S. Starrett Company (The)', 'Ergonomic mission-critical intranet', '43.6165639, 27.091526', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Hertz Global Holdings, Inc', 'Virtual logistical moderator', '43.9771937, 42.974641', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Truett-Hurst, Inc.', 'Grass-roots cohesive product', '8.1592413, 125.2824211', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Sun Life Financial Inc.', 'Assimilated eco-centric hub', '39.8653333, 116.3998528', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Nuveen Ohio Quality Municipal Income Fund', 'Integrated multimedia leverage', '51.3531567, 39.3015305', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Omnicell, Inc.', 'Monitored 4th generation challenge', '22.276022, 114.1751471', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Reading International Inc', 'Business-focused reciprocal data-warehouse', '51.9466854, 15.8079723', 'Arthur', 'Parques');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Community Corporation', 'Re-engineered contextually-based orchestration', '38.7035566, -7.7801629', 'Arthur', 'Parques');
/*Museos*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Bank of N.T. Butterfield & Son Limited (The)', 'Balanced radical pricing structure', '41.8061049, 20.3353497', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Twenty-First Century Fox, Inc.', 'Reverse-engineered zero tolerance project', '-6.2245977, 106.6789296', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Inotek Pharmaceuticals Corporation', 'Reverse-engineered multi-tasking migration', '53.543617, 49.2636336', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Evolving Systems, Inc.', 'Extended static challenge', '-7.0407255, 107.0893798', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('iShares S&P Global Clean Energy Index Fund', 'Configurable intangible open architecture', '43.6943099, 2.0376775', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Norfolk Souther Corporation', 'Total content-based architecture', '35.6891975, 51.3889736', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Rentech, Inc.', 'Managed neutral product', '28.125406, 120.251605', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Forward Industries, Inc.', 'Virtual reciprocal open architecture', '10.7179292, 122.3066411', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Post Holdings, Inc.', 'Customizable systematic ability', '-4.6389001, -79.7147196', 'Arthur', 'Museos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Blueknight Energy Partners L.P., L.L.C.', 'Managed grid-enabled utilisation', '30.798775, 121.33638', 'Arthur', 'Museos');
/*Fondas*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Blackstone GSO Senior Floating Rate Term Fund', 'Networked transitional budgetary management', '45.08338, -73.36585', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('CryoLife, Inc.', 'De-engineered 4th generation ability', '39.2759274, 22.818555', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Constellation Brands Inc', 'Persevering bandwidth-monitored info-mediaries', '-26.69475, 25.4735999', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('I.D. Systems, Inc.', 'Business-focused demand-driven intranet', '25.493594, 118.247625', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Trust Rising Dividend Achievers ETF', 'Cross-group client-server artificial intelligence', '25.261992, 114.593792', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Defiance Financial Corp.', 'Focused static ability', '55.86667, 37.5', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('VSE Corporation', 'Grass-roots context-sensitive project', '29.3738721, 71.6934843', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Cummins Inc.', 'Right-sized well-modulated leverage', '-8.035636, 111.9969626', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Aerohive Networks, Inc.', 'Synchronised 5th generation superstructure', '50.0138436, 18.9779408', 'Miguel', 'Fondas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('FairPoint Communications, Inc.', 'Quality-focused asynchronous concept', '22.720974, 114.246899', 'Miguel', 'Fondas');
/*Restaurantes*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('JetBlue Airways Corporation', 'Open-architected systemic standardization', '-12.0817609, -77.0960876', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Bioverativ Inc.', 'Universal system-worthy archive', '55.9763451, 37.6084088', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('SuperValu Inc.', 'Fully-configurable leading edge system engine', '19.4520843, 103.1855702', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Pier 1 Imports, Inc.', 'Open-architected zero administration standardization', '16.2484522, -61.5175715', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Sensient Technologies Corporation', 'Digitized logistical portal', '-8.098655, 112.6824377', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Amyris, Inc.', 'Assimilated scalable database', '41.4884285, -8.6299298', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Therapix Biosciences Ltd.', 'Diverse object-oriented application', '14.1318474, 121.2669296', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Rayonier Advanced Materials Inc.', 'Secured value-added hardware', '5.87568, 121.29146', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Viavi Solutions Inc.', 'Re-engineered contextually-based protocol', '51.752684, 36.1522509', 'Miguel', 'Restaurantes');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Kaiser Aluminum Corporation', 'Cross-group context-sensitive groupware', '-34.6674349, -63.3785604', 'Miguel', 'Restaurantes');
/*Universidades*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Recon Technology, Ltd.', 'Quality-focused regional framework', '40.2617721, -76.8798693', 'Miguel', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Orion Engineered Carbons S.A', 'Mandatory logistical moratorium', '51.5598572, -2.3523889', 'Miguel', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Patriot National Bancorp Inc.', 'Networked holistic frame', '30.352134, 114.720925', 'Miguel', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Chemical Financial Corporation', 'Mandatory bifurcated application', '5.8901373, 14.5480484', 'Miriam', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Global X SuperDividend Alternatives ETF', 'Multi-channelled intangible circuit', '51.2487152, 21.5754229', 'Miriam', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Rockwell Medical, Inc.', 'Focused scalable implementation', '40.8591123, 19.7487502', 'Miriam', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Blackrock Capital and Income Strategies Fund Inc', 'Optimized disintermediate collaboration', '39.9566253, 44.5924796', 'Miriam', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('General Communication, Inc.', 'Adaptive heuristic encoding', '39.0054084, 21.6386381', 'Miriam', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('FairPoint Communications, Inc.', 'Grass-roots static workforce', '55.496478, 12.9658307', 'Miriam', 'Universidades');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('StealthGas, Inc.', 'Configurable fresh-thinking synergy', '38.640106, -9.0560562', 'Miriam', 'Universidades');
/*Bancos*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Aemetis, Inc', 'Networked real-time structure', '24.682501, 113.604535', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('TJX Companies, Inc. (The)', 'Stand-alone intangible function', '-25.7691769, -49.718244', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Halliburton Company', 'Intuitive logistical firmware', '50.4213981, 37.8304992', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Bay Bancorp, Inc.', 'Operative methodical policy', '0.0132035, 109.3128909', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Lincoln National Corporation', 'Diverse dedicated moratorium', '14.75, -88.533333', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Sino-Global Shipping America, Ltd.', 'Exclusive uniform complexity', '35.99, -115.09', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Prospect Capital Corporation', 'Advanced transitional workforce', '11.9210864, -86.1230153', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Kenon Holdings Ltd.', 'Networked global migration', '-2.5082067, 112.1787896', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Yirendai Ltd.', 'Managed motivating infrastructure', '13.7832268, 120.9891643', 'Miriam', 'Bancos');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Western Asset Municipal Partners Fund, Inc.', 'Compatible discrete instruction set', '59.9050895, 10.7673005', 'Miriam', 'Bancos');
/*Cajeros*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Simulations Plus, Inc.', 'Digitized human-resource parallelism', '17.7302207, 121.4674111', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Nord Anglia Education, Inc.', 'Profound well-modulated toolset', '40.784068, 122.1039229', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Cidara Therapeutics, Inc.', 'Upgradable dynamic matrix', '51.46681, -109.16818', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Cascadian Therapeutics, Inc.', 'Front-line system-worthy orchestration', '-7.832843, 110.2474787', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Walker & Dunlop, Inc.', 'Re-engineered static alliance', '59.9335031, 30.3251493', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('AlphaMark Actively Managed Small Cap ETF', 'Synergistic mobile budgetary management', '-11.7910581, -38.3562554', 'Ernesto', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Connecticut Water Service, Inc.', 'Optimized maximized methodology', '5.84671, 6.15257', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Limbach Holdings, Inc.', 'Secured local leverage', '59.922175, 10.727404', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('NetSol Technologies Inc.', 'Re-contextualized foreground throughput', '31.917522, 35.032191', 'Miriam', 'Cajeros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Enterprise Financial Services Corporation', 'Implemented 6th generation monitoring', '50.425413, 124.118816', 'Miriam', 'Cajeros');
/*Gasolineras*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Best Buy Co., Inc.', 'Devolved empowering Graphic Interface', '15.4239767, 120.6813126', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Onvia, Inc.', 'User-centric 6th generation frame', '26.2413688, 105.9386306', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Gladstone Investment Corporation', 'Multi-channelled maximized installation', '41.1575552, -8.2259125', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('China Life Insurance Company Limited', 'Distributed regional monitoring', '54.5442039, 38.6199751', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Delphi Automotive plc', 'Triple-buffered multi-state groupware', '7.6292088, 4.1872178', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('CSS Industries, Inc.', 'Synergized impactful capability', '39.8623333, 116.3998528', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('NI Holdings, Inc.', 'De-engineered 24/7 time-frame', '12.8074809, 122.0553349', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Pioneer Municipal High Income Advantage Trust', 'Phased static info-mediaries', '-8.074933, 112.6079459', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Ecolab Inc.', 'Cross-platform asynchronous instruction set', '45.788378, 3.1331436', 'Miriam', 'Gasolineras');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Dril-Quip, Inc.', 'User-centric dynamic methodology', '41.8210285, 20.9641822', 'Miriam', 'Gasolineras');
/*Tiendas*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Rightside Group, Ltd.', 'Multi-lateral methodical standardization', '22.555259, 113.884019', 'Ernesto', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Trust New Opportunities MLP & Energy Fund', 'Grass-roots foreground forecast', '60.2577358, 24.3903505', 'Ernesto', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('USG Corporation', 'Phased cohesive functionalities', '46.6817873, -64.8659804', 'Ernesto', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Trust Large Cap Core AlphaDEX Fund', 'Organized high-level encryption', '57.8001246, 11.9841764', 'Ernesto', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Northern Technologies International Corporation', 'Operative foreground hub', '34.61672, 109.248057', 'Ernesto', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Aspen Insurance Holdings Limited', 'Vision-oriented leading edge support', '65.2674812, 27.5126688', 'Miriam', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Jumei International Holding Limited', 'Diverse upward-trending capability', '44.9870496, 38.994454', 'Miriam', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('United Bancshares, Inc.', 'Virtual system-worthy middleware', '48.9933962, 14.5417888', 'Miriam', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Apollo Investment Corporation', 'Robust modular portal', '14.5421715, -91.4130682', 'Miriam', 'Tiendas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Extra Space Storage Inc', 'Cross-group composite secured line', '30.274084, 120.15507', 'Miriam', 'Tiendas');
/*Supermercados*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Liberty Media Corporation', 'Pre-emptive uniform workforce', '45.7123346, 15.8074521', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Potash Corporation of Saskatchewan Inc.', 'Integrated 24 hour concept', '40.5566629, -8.5821839', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Global Partners LP', 'Synergized content-based capability', '29.7857853, -95.8243956', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('MIDSTATES PETROLEUM COMPANY, INC.', 'Cross-group human-resource contingency', '41.8815942, -8.628833', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('MACOM Technology Solutions Holdings, Inc.', 'Ergonomic multimedia benchmark', '45.7718709, 126.6701902', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Innoviva, Inc.', 'Devolved object-oriented portal', '45.0244716, 20.056916', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('EPR Properties', 'Digitized 24/7 task-force', '11.0915371, -6.8914024', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Remark Holdings, Inc.', 'Seamless analyzing synergy', '18.026373, -95.514174', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Encana Corporation', 'Extended regional budgetary management', '14.7342524, 121.0702642', 'Miriam', 'Supermercados');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Jewett-Cameron Trading Company', 'Optional zero tolerance focus group', '15.3242773, -91.4839442', 'Miriam', 'Supermercados');
/*Primarias*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Rubicon Technology, Inc.', 'Sharable homogeneous standardization', '55.4055305, 38.2447393', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Zayo Group Holdings, Inc.', 'Fundamental next generation moratorium', '25.8025129, -100.2268529', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Sotherly Hotels Inc.', 'Fundamental global access', '36.3645281, 37.0158772', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Kayne Anderson Energy Total Return Fund, Inc.', 'Monitored mobile standardization', '38.681707, 112.337992', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('QAD Inc.', 'Digitized fault-tolerant process improvement', '22.9637053, 120.3320195', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('J P Morgan Chase & Co', 'Realigned responsive concept', '10.151, 122.9978', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('On Deck Capital, Inc.', 'Distributed local secured line', '-20.2687728, -50.5316737', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Verizon Communications Inc.', 'Diverse upward-trending moderator', '-24.4770763, 25.8906212', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Interpublic Group of Companies, Inc. (The)', 'Profit-focused systemic firmware', '-0.4616728, -76.9931074', 'Ernesto', 'Primarias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Viacom Inc.', 'Visionary static benchmark', '-32.4084888, -63.2596263', 'Ernesto', 'Primarias');
/*Oficinas*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Hanmi Financial Corporation', 'Profound real-time help-desk', '41.565627, 120.453743', 'Miriam', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('PartnerRe Ltd.', 'Customer-focused even-keeled matrix', '54.6219097, 24.9344265', 'Miriam', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('KCAP Financial, Inc.', 'Multi-channelled hybrid moratorium', '24.803563, 115.482733', 'Miriam', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Davis Select U.S. Equity ETF', 'Front-line dynamic productivity', '-34.6906944, -58.601544', 'Miriam', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('iShares MSCI Europe Small-Cap ETF', 'Re-contextualized static pricing structure', '36.9635917, 56.3712327', 'Miriam', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('VelocityShares 3x Inverse Silver ETN', 'Profound interactive system engine', '22.483182, 113.916509', 'Ernesto', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Trust Low Beta Income ETF', 'Inverse asynchronous functionalities', '30.603546, 121.095594', 'Ernesto', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Trust Nasdaq Semiconductor ETF', 'User-friendly background frame', '42.901533, 125.136451', 'Ernesto', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('VictoryShares US Discovery Enhanced Volatility Wtd ETF', 'Cross-group intermediate throughput', '41.5608072, -8.5863716', 'Ernesto', 'Oficinas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('LRAD Corporation', 'Multi-tiered stable pricing structure', '40.5353559, 44.7695698', 'Ernesto', 'Oficinas');
/*Teatros*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Encore Wire Corporation', 'Focused optimal methodology', '7.5932558, 122.7995493', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Taro Pharmaceutical Industries Ltd.', 'Upgradable regional toolset', '59.6833779, 16.6108186', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('PTC Inc.', 'Decentralized grid-enabled application', '39.0284006, -9.3200883', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('VALE S.A.', 'Sharable 4th generation open architecture', '49.9469881, 18.1870189', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Enerplus Corporation', 'Proactive interactive model', '15.59861, 48.18278', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('PowerShares DWA SmallCap Momentum Portfolio', 'Networked incremental framework', '-6.9826515, 111.431315', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Cancer Genetics, Inc.', 'Object-based motivating extranet', '46.0675028, 44.4160763', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Destination Maternity Corporation', 'Multi-lateral user-facing process improvement', '48.890054, 2.2372792', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Bank of America Corporation', 'Business-focused motivating open architecture', '28.555787, 121.244605', 'Miriam', 'Teatros');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Busey Corporation', 'Ergonomic mission-critical approach', '38.9680341, 121.4703114', 'Miriam', 'Teatros');
/*Iglesias*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('RTI Surgical, Inc.', 'Fundamental reciprocal framework', '7.7442314, -7.6168439', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Xenetic Biosciences, Inc.', 'Upgradable methodical approach', '46.592721, 131.164723', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Blackrock Debt Strategies Fund, Inc.', 'Automated methodical solution', '25.4251732, 68.7514645', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Kinsale Capital Group, Inc.', 'Progressive homogeneous parallelism', '14.914778, -91.444669', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Quinpario Acquisition Corp. 2', 'Future-proofed encompassing migration', '31.829323, 119.977286', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Electro-Sensors, Inc.', 'Streamlined national moderator', '-3.8017999, -38.4809114', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Copart, Inc.', 'Profit-focused high-level infrastructure', '15.1786657, 101.7637775', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('UMB Financial Corporation', 'Organized bandwidth-monitored infrastructure', '39.6080157, -8.6664683', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Green Bancorp, Inc.', 'Right-sized modular info-mediaries', '-7.6589782, 110.5394227', 'Miriam', 'Iglesias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('National Beverage Corp.', 'Innovative zero defect parallelism', '11.0181098, 124.5298181', 'Miriam', 'Iglesias');
/*Casas de Cultura*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Teekay Offshore Partners L.P.', 'Organized non-volatile initiative', '23.883531, 110.666614', 'Roberto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('NextEra Energy, Inc.', 'Switchable well-modulated parallelism', '62.4658095, 6.2512238', 'Roberto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('ENGlobal Corporation', 'Assimilated impactful application', '53.248446, -0.934063', 'Roberto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Southern California Edison Company', 'Multi-lateral heuristic knowledge base', '2.7991084, 44.0793911', 'Roberto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Zogenix, Inc.', 'Reduced 6th generation secured line', '45.3876043, 18.8966831', 'Roberto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Christopher & Banks Corporation', 'Secured asynchronous focus group', '51.653437, 39.183897', 'Ernesto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('First Trust Indxx Global Agriculture ETF', 'Organized fault-tolerant help-desk', '-18.617781, 47.709942', 'Ernesto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Capitala Finance Corp.', 'Open-architected 6th generation firmware', '-33.4907417, 22.5304693', 'Ernesto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Genie Energy Ltd.', 'Phased needs-based toolset', '58.2529231, 22.4850409', 'Ernesto', 'Casas de Cultura');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Triangle Capital Corporation', 'Digitized web-enabled collaboration', '59.1499143, 9.6586061', 'Ernesto', 'Casas de Cultura');
/*Farmacias*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Alere Inc.', 'Visionary exuding middleware', '41.6985084, -8.3404338', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Home BancShares, Inc.', 'Profit-focused tangible analyzer', '7.2484596, 125.0587505', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('TOR Minerals International Inc', 'Innovative global toolset', '42.8271637, 2.9134412', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Chesapeake Lodging Trust', 'Persevering stable matrix', '60.3767999, 93.0249306', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Virco Manufacturing Corporation', 'Decentralized directional contingency', '46.3194856, -0.4546217', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Aspen Insurance Holdings Limited', 'Horizontal zero administration neural-net', '39.55699, -8.736667', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Colony NorthStar, Inc.', 'Monitored methodical success', '13.2979317, 123.7802005', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('CB Financial Services, Inc.', 'Reverse-engineered incremental emulation', '41.400351, -8.5116191', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('TriplePoint Venture Growth BDC Corp.', 'Multi-layered 4th generation software', '56.93333, 49.15361', 'Roberto', 'Farmacias');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Ocular Therapeutix, Inc.', 'Multi-tiered real-time hierarchy', '-17.722004, -48.1585601', 'Roberto', 'Farmacias');
/*Clínicas*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Aradigm Corporation', 'Total reciprocal Graphical User Interface', '48.9582445, 24.6800199', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Sajan, Inc.', 'Expanded 6th generation function', '48.5129473, 2.6780176', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Bank of the Ozarks', 'Multi-layered intermediate service-desk', '40.8151906, 111.6954214', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Concordia International Corp.', 'Innovative incremental open system', '37.0422371, 22.1141264', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Tortoise Power and Energy Infrastructure Fund, Inc', 'Optional tangible core', '14.709034, 120.947095', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('NorthStar Realty Europe Corp.', 'Inverse scalable Graphical User Interface', '-6.2568393, 106.855853', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('XG Technology, Inc', 'Persistent value-added projection', '38.2905469, 139.5501904', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Kronos Worldwide Inc', 'Optional zero administration hub', '10.2995028, -61.175278', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Wynn Resorts, Limited', 'Team-oriented uniform moderator', '59.9981042, 15.819769', 'Roberto', 'Clínicas');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('AllianzGI Convertible & Income Fund', 'Persevering directional portal', '28.4499078, 68.4494842', 'Roberto', 'Clínicas');
/*Heladerías*/
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Merus Labs International Inc.', 'Reverse-engineered tertiary local area network', '-24.4748345, -49.8956943', 'Roberto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('TPG Specialty Lending, Inc.', 'Operative foreground middleware', '28.97844, 117.151796', 'Roberto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Western Asset/Claymore U.S Treasury Inflation Prot Secs Fd 2', 'Cross-platform dynamic capability', '14.3770919, -87.1242072', 'Roberto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Pennsylvania Real Estate Investment Trust', 'Focused radical moratorium', '14.2976248, 120.9082571', 'Roberto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('POSCO', 'Integrated zero defect website', '28.040943, 112.636417', 'Roberto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Visa Inc.', 'Cross-platform bifurcated alliance', '54.4808396, 37.6941279', 'Roberto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('RenaissanceRe Holdings Ltd.', 'Cross-platform tertiary workforce', '-33.4900417, 22.5304693', 'Ernesto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Select Asset Inc.', 'Total even-keeled hardware', '31.8742348, 10.9750484', 'Ernesto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('McGrath RentCorp', 'Self-enabling non-volatile application', '-16.6488964, -49.1565948', 'Ernesto', 'Heladerías');
insert into notitia.marcadores (datos_utiles, descripcion, ubicacion, nombre_usuario, nombre) values ('Sohu.com Inc.', 'Inverse human-resource monitoring', '33.7393667, 36.5958947', 'Ernesto', 'Heladerías');
