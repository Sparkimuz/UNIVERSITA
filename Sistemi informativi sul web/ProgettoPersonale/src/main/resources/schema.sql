CREATE TABLE credenziali (
                             id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                             username VARCHAR(255) NOT NULL,
                             password VARCHAR(255) NOT NULL,
                             ruolo VARCHAR(50) NOT NULL
);

CREATE TABLE musicista (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           nome VARCHAR(255) NOT NULL,
                           cognome VARCHAR(255) NOT NULL,
                           data_nascita DATE,
                           voto_totale INT DEFAULT 0,
                           credenziali_id BIGINT UNIQUE,
                           FOREIGN KEY (credenziali_id) REFERENCES credenziali(id)
);

CREATE TABLE utente (
                        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        nome VARCHAR(255) NOT NULL,
                        cognome VARCHAR(255) NOT NULL,
                        data_nascita DATE,
                        credenziali_id BIGINT UNIQUE,
                        FOREIGN KEY (credenziali_id) REFERENCES credenziali(id)
);

CREATE TABLE album (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       titolo VARCHAR(255) NOT NULL,
                       canzoni TEXT NOT NULL,
                       voto INT NOT NULL,
                       musicista_id BIGINT,
                       FOREIGN KEY (musicista_id) REFERENCES musicista(id)
);

CREATE TABLE votazione (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           mittente_id BIGINT,
                           destinatario_id BIGINT,
                           album_id BIGINT,
                           voto INT NOT NULL,
                           FOREIGN KEY (destinatario_id) REFERENCES musicista(id),
                           FOREIGN KEY (album_id) REFERENCES album(id)
);