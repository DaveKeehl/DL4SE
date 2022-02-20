-- ID GENERATION SEQUENCE
CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

-- TABLES
CREATE TABLE "language" (
    "id" bigint PRIMARY KEY NOT NULL,
    "name" text NOT NULL,
    "extensions" text[] NOT NULL
);

CREATE TABLE "git_repo" (
    "id" bigint PRIMARY KEY NOT NULL,
    "name" text UNIQUE NOT NULL,
    "license" text,
    "is_fork" boolean NOT NULL,
    "commits" bigint NOT NULL,
    "contributors" bigint NOT NULL,
    "issues" bigint NOT NULL,
    "stars" bigint NOT NULL,
    "last_update" timestamp NOT NULL,
    "is_deleted" boolean NOT NULL
);

CREATE TABLE "file" (
    "id" bigint PRIMARY KEY NOT NULL,
    "repo_id" bigint NOT NULL,
    "lang_id" bigint NOT NULL,
    "path" text NOT NULL,
    "is_parsed" boolean NOT NULL,
    "content" text NOT NULL,
    "content_hash" text NOT NULL,
    "ast" text,
    "ast_hash" text,
    "total_tokens" bigint,
    "code_tokens" bigint,
    "lines" bigint NOT NULL,
    "characters" bigint NOT NULL,
    "is_test" boolean NOT NULL,
    "contains_non_ascii" boolean NOT NULL
);

CREATE TABLE "function" (
    "id" bigint PRIMARY KEY NOT NULL,
    "repo_id" bigint NOT NULL,
    "lang_id" bigint NOT NULL,
    "file_id" bigint NOT NULL,
    "content" text NOT NULL,
    "content_hash" text NOT NULL,
    "ast" text,
    "ast_hash" text,
    "total_tokens" bigint,
    "code_tokens" bigint,
    "lines" bigint NOT NULL,
    "characters" bigint NOT NULL,
    "is_test" boolean NOT NULL,
    "contains_non_ascii" boolean NOT NULL,
    "boilerplate_type" text
);

-- FOREIGN KEYS
ALTER TABLE "file" ADD FOREIGN KEY ("repo_id") REFERENCES "git_repo" ("id");
ALTER TABLE "file" ADD FOREIGN KEY ("lang_id") REFERENCES "language" ("id");
ALTER TABLE "function" ADD FOREIGN KEY ("repo_id") REFERENCES "git_repo" ("id");
ALTER TABLE "function" ADD FOREIGN KEY ("lang_id") REFERENCES "language" ("id");
ALTER TABLE "function" ADD FOREIGN KEY ("file_id") references "file" ("id");
