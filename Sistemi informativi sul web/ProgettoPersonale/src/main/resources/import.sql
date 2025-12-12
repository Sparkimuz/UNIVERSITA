INSERT INTO credenziali (username, password, ruolo) VALUES ('francesco', 'ciao', 'MUSICISTA');
INSERT INTO credenziali (username, password, ruolo) VALUES ('mario24', 'ciao', 'MUSICISTA');
INSERT INTO credenziali (username, password, ruolo) VALUES ('cristina17', 'ciao', 'UTENTE');

-- UTENTE
INSERT INTO utente (nome, cognome, data_nascita, credenziali_id) VALUES ('Cristina', 'Verdi', '2001-10-22', 3);

-- MUSICISTA
INSERT INTO musicista (nome, cognome, data_nascita, voto_totale, credenziali_id) VALUES ('Francesco', 'Bianchi', '2001-12-06', 0, 1);
INSERT INTO musicista (nome, cognome, data_nascita, voto_totale, credenziali_id) VALUES ('Mario', 'Rossi', '2001-03-09', 7, 2);

-- Inserimento di dati nella tabella Album
INSERT INTO album (titolo, canzoni, voto, musicista_id) VALUES ('Album1', 'Canzoni Album 1', 0, 1);
INSERT INTO album (titolo, canzoni, voto, musicista_id) VALUES ('Album2', 'Canzoni Album 2', 0, 1);
INSERT INTO album (titolo, canzoni, voto, musicista_id) VALUES ('Album1', 'Canzoni Album 1', 7, 2);

-- Inserimento di dati nella tabella Votazione
INSERT INTO votazione (mittente_id, destinatario_id, album_id, voto) VALUES (3, 2, 3, 7);
