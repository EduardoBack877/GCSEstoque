-- liquibase formatted sql

-- changeset Back:1624927151130-1

CREATE TABLE IF NOT EXISTS "public"."produto" ("id" SERIAL NOT NULL, "descricao" VARCHAR(150) NOT NULL, "cor" VARCHAR(50) NOT NULL, "marca" VARCHAR(150), "tamanho" VARCHAR(10), "qtd" INTEGER NOT NULL, "codsecao" INTEGER, "codgrupo" INTEGER, "codprat" INTEGER, CONSTRAINT "pk_id_prod" PRIMARY KEY ("id"));

CREATE TABLE IF NOT EXISTS "public"."prateleira" ("id" SERIAL NOT NULL, CONSTRAINT "pk_id_prateleira" PRIMARY KEY ("id"));

CREATE TABLE IF NOT EXISTS "public"."usuario" ("id" SERIAL NOT NULL, "login" VARCHAR(50) NOT NULL, "senha" VARCHAR(50) NOT NULL, "status" INTEGER, CONSTRAINT "usuario_pkey" PRIMARY KEY ("id"));

CREATE TABLE IF NOT EXISTS "public"."grupoproduto" ("id" SERIAL NOT NULL, "descricao" VARCHAR(150) NOT NULL, CONSTRAINT "pk_id_grupoproduto" PRIMARY KEY ("id"));

CREATE TABLE IF NOT EXISTS "public"."movestoque" ("id" SERIAL NOT NULL, "periodo" TIMESTAMP WITHOUT TIME ZONE NOT NULL, "operacao" VARCHAR(1) NOT NULL, "qtd" INTEGER NOT NULL, "codprod" INTEGER NOT NULL, CONSTRAINT "pk_movestoque" PRIMARY KEY ("id"));

CREATE TABLE IF NOT EXISTS "public"."secao" ("id" SERIAL NOT NULL, "descricao" VARCHAR(150) NOT NULL, CONSTRAINT "pk_id_secao" PRIMARY KEY ("id"));

ALTER TABLE "public"."produto" DROP CONSTRAINT IF EXISTS "fk_codsecao_prod";
ALTER TABLE "public"."produto" ADD CONSTRAINT "fk_codsecao_prod" FOREIGN KEY ("codsecao") REFERENCES "public"."secao" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE "public"."produto" DROP CONSTRAINT IF EXISTS "fk_codgrupo_prod";
ALTER TABLE "public"."produto" ADD CONSTRAINT "fk_codgrupo_prod" FOREIGN KEY ("codgrupo") REFERENCES "public"."grupoproduto" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;


ALTER TABLE "public"."movestoque" DROP CONSTRAINT IF EXISTS "fk_movestoque_codprod";
ALTER TABLE "public"."movestoque" ADD CONSTRAINT "fk_movestoque_codprod" FOREIGN KEY ("codprod") REFERENCES "public"."produto" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE "public"."produto" DROP CONSTRAINT IF EXISTS "fk_codprat_prod";
ALTER TABLE "public"."produto" ADD CONSTRAINT "fk_codprat_prod" FOREIGN KEY ("codprat") REFERENCES "public"."prateleira" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;


-- changeset Back:1624927151130-2

CREATE TABLE IF NOT EXISTS testandoprofessor ("id" SERIAL, "descricao" VARCHAR(500));

