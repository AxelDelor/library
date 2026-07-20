-- Books
INSERT INTO books (title, author, isbn, state) VALUES ('1984', 'George Orwell', '9780451524935', 'AVAILABLE');
INSERT INTO books (title, author, isbn, state) VALUES ('Le Petit Prince', 'Antoine de Saint-Exupéry', '9782070408504', 'BORROWED');
INSERT INTO books (title, author, isbn, state) VALUES ('Fondation', 'Isaac Asimov', '9782070415842', 'AVAILABLE');
INSERT INTO books (title, author, isbn, state) VALUES ('Dune', 'Frank Herbert', '9782266311721', 'BORROWED');
INSERT INTO books (title, author, isbn, state) VALUES ('Le Seigneur des Anneaux', 'J.R.R. Tolkien', '9782266154116', 'DAMAGED');

-- Members
INSERT INTO members (name, email, library_card) VALUES ('Alice Dupont', 'alice.dupont@email.com', 'LIB-0001');
INSERT INTO members (name, email, library_card) VALUES ('Bruno Martin', 'bruno.martin@email.com', 'LIB-0002');
INSERT INTO members (name, email, library_card) VALUES ('Claire Petit', 'claire.petit@email.com', 'LIB-0003');
INSERT INTO members (name, email, library_card) VALUES ('David Bernard', 'david.bernard@email.com', 'LIB-0004');
INSERT INTO members (name, email, library_card) VALUES ('Emma Roux', 'emma.roux@email.com', 'LIB-0005');

-- Loans (cohérents avec les livres BORROWED ci-dessus)
INSERT INTO loans (book_id, member_id, loan_date, return_date) VALUES (2, 1, '2026-07-01', NULL);
INSERT INTO loans (book_id, member_id, loan_date, return_date) VALUES (4, 3, '2026-07-10', NULL);