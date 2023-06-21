EXPLAIN SELECT * FROM READERS
        WHERE READERS.FIRSTNAME = 'John';

CREATE INDEX BOOKS_INDEX ON BOOKS (TITLE);

CREATE INDEX READERS_INDEX ON READERS (FIRSTNAME);

EXPLAIN SELECT BOOKS.TITLE FROM BOOKS;

EXPLAIN SELECT READERS.FIRSTNAME FROM READERS;

EXPLAIN SELECT READERS.LASTNAME FROM READERS;

EXPLAIN SELECT * FROM READERS
        WHERE READERS.FIRSTNAME = 'John';

DROP INDEX BOOKS_INDEX ON books;

DROP INDEX READERS_INDEX ON readers;