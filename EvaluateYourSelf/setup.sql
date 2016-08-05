CREATE TABLE public."Users"
(
  "US_ID" integer NOT NULL DEFAULT nextval('"Users_US_ID_seq"'::regclass), -- User Id
  "USFIRSTNAME" character varying(45), -- User firstname
  "USLASTNAME" character varying(45), -- User lastname
  "USJOINDATE" date, -- Date when user join to community
  "USCREATIONDATE" timestamp with time zone, -- Creation timestamp for row in database
  "USLOGIN" character varying(40), -- User login
  "USPASSWORD" character varying(500), -- User passwors hashed by bcrypt or scypt alghoritm
  CONSTRAINT pkus_id PRIMARY KEY ("US_ID")
)
WITH (
  OIDS=TRUE
);
ALTER TABLE public."Users"
  OWNER TO mateusz;
COMMENT ON TABLE public."Users"
  IS 'Table stores informations about all registered users';
COMMENT ON COLUMN public."Users"."US_ID" IS 'User Id';
COMMENT ON COLUMN public."Users"."USFIRSTNAME" IS 'User firstname';
COMMENT ON COLUMN public."Users"."USLASTNAME" IS 'User lastname';
COMMENT ON COLUMN public."Users"."USJOINDATE" IS 'Date when user join to community';
COMMENT ON COLUMN public."Users"."USCREATIONDATE" IS 'Creation timestamp for row in database';
COMMENT ON COLUMN public."Users"."USLOGIN" IS 'User login';
COMMENT ON COLUMN public."Users"."USPASSWORD" IS 'User passwors hashed by bcrypt or scypt alghoritm';